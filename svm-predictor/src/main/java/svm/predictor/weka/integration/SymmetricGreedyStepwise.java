package svm.predictor.weka.integration;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.GreedyStepwise;
import weka.attributeSelection.SubsetEvaluator;
import weka.attributeSelection.UnsupervisedSubsetEvaluator;
import weka.core.Instances;

public class SymmetricGreedyStepwise extends GreedyStepwise {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2744993482477275657L;
	
	private static Logger logger = LoggerFactory.getLogger(SymmetricGreedyStepwise.class);
	
	@Override
	  public int[] search(ASEvaluation ASEval, Instances data) throws Exception {

	    int i;
	    double best_merit = -Double.MAX_VALUE;
	    double temp_best, temp_merit;
	    int temp_index = 0;
	    BitSet temp_group;
	    boolean parallel = (m_poolSize > 1);
	    if (parallel) {
	      m_pool = Executors.newFixedThreadPool(m_poolSize);
	    }

	    if (data != null) { // this is a fresh run so reset
	      resetOptions();
	      m_Instances = new Instances(data, 0);
	    }
	    m_ASEval = ASEval;

	    m_numAttribs = m_Instances.numAttributes();

	    if (m_best_group == null) {
	      m_best_group = new BitSet(m_numAttribs);
	    }

	    if (!(m_ASEval instanceof SubsetEvaluator)) {
	      throw new Exception(m_ASEval.getClass().getName() + " is not a "
	        + "Subset evaluator!");
	    }

	    m_startRange.setUpper(m_numAttribs - 1);
	    if (!(getStartSet().equals(""))) {
	      m_starting = m_startRange.getSelection();
	    }

	    if (m_ASEval instanceof UnsupervisedSubsetEvaluator) {
	      m_hasClass = false;
	      m_classIndex = -1;
	    } else {
	      m_hasClass = true;
	      m_classIndex = m_Instances.classIndex();
	    }

	    final SubsetEvaluator ASEvaluator = (SubsetEvaluator) m_ASEval;

	    if (m_rankedAtts == null) {
	      m_rankedAtts = new double[m_numAttribs][2];
	      m_rankedSoFar = 0;
	    }

	    // If a starting subset has been supplied, then initialise the bitset
	    if (m_starting != null && m_rankedSoFar <= 0) {
	      for (i = 0; i < m_starting.length; i++) {
	        if ((m_starting[i]) != m_classIndex) {
	          m_best_group.set(m_starting[i]);
	        }
	      }
	    } else {
	      if (m_backward && m_rankedSoFar <= 0) {
	        for (i = 0; i < m_numAttribs; i++) {
	          if (i != m_classIndex) {
	            m_best_group.set(i);
	          }
	        }
	      }
	    }

	    // Evaluate the initial subset
	    best_merit = ASEvaluator.evaluateSubset(m_best_group);

	    // main search loop
	    boolean done = false;
	    boolean addone = false;
	    boolean z;

	    if (m_debug && parallel) {
	      System.err.println("Evaluating subsets in parallel...");
	    }
	    while (!done) {
	      List<Future<Double[]>> results = new ArrayList<Future<Double[]>>();
	      temp_group = (BitSet) m_best_group.clone();
	      temp_best = best_merit;
	      if (m_doRank) {
	        temp_best = -Double.MAX_VALUE;
	      }
	      done = true;
	      addone = false;
	      int attribCount = m_numAttribs - 1;
	      for (i = 0; i < 2 + (attribCount - 2) / 2; i++) {
	        if (m_backward) {
	          z = temp_group.get(i);
	        } else {
	          z = !temp_group.get(i);
	        }
	        if (z) {
	          // set/unset the bit
	          if (m_backward) {
	            temp_group.clear(i);
	            if(i > 1) {
	            	temp_group.clear(i + ((attribCount - 2) / 2));
	            }
	          } else {
	            temp_group.set(i);
	            if(i > 1) {
	            	temp_group.set(i + ((attribCount - 2) / 2));
	            }
	          }

	          if (parallel) {
	            final BitSet tempCopy = (BitSet) temp_group.clone();
	            final int attBeingEvaluated = i;

	            // make a copy if the evaluator is not thread safe
	            final SubsetEvaluator theEvaluator =
	              (ASEvaluator instanceof weka.core.ThreadSafe) ? ASEvaluator
	                : (SubsetEvaluator) ASEvaluation.makeCopies(m_ASEval, 1)[0];

	            Future<Double[]> future = m_pool.submit(new Callable<Double[]>() {
	              @Override
	              public Double[] call() throws Exception {
	                Double[] r = new Double[2];
	                double e = theEvaluator.evaluateSubset(tempCopy);
	                r[0] = new Double(attBeingEvaluated);
	                r[1] = e;
	                return r;
	              }
	            });

	            results.add(future);
	          } else {
	            temp_merit = ASEvaluator.evaluateSubset(temp_group);
	            if (m_backward) {
	              z = (temp_merit >= temp_best);
	            } else {
	              if (m_conservativeSelection) {
	                z = (temp_merit >= temp_best);
	              } else {
	                z = (temp_merit > temp_best);
	              }
	            }

	            if (z) {
	              temp_best = temp_merit;
	              temp_index = i;
	              addone = true;
	              done = false;
	            }
	          }

	          // unset this addition/deletion
	          if (m_backward) {
	            temp_group.set(i);
	            if(i > 1) {
	            	temp_group.set(i + ((attribCount - 2) / 2));
	            }
	          } else {
	            temp_group.clear(i);
	            if(i > 1) {
	            	temp_group.clear(i + ((attribCount - 2) / 2));
	            }
	          }
	          if (m_doRank) {
	            done = false;
	          }
	        }
	      }

	      if (parallel) {
	        for (int j = 0; j < results.size(); j++) {
	          Future<Double[]> f = results.get(j);

	          int index = f.get()[0].intValue();
	          temp_merit = f.get()[1].doubleValue();

	          if (m_backward) {
	            z = (temp_merit >= temp_best);
	          } else {
	            if (m_conservativeSelection) {
	              z = (temp_merit >= temp_best);
	            } else {
	              z = (temp_merit > temp_best);
	            }
	          }

	          if (z) {
	            temp_best = temp_merit;
	            temp_index = index;
	            addone = true;
	            done = false;
	          }
	        }
	      }

	      if (addone) {
	        if (m_backward) {
	          m_best_group.clear(temp_index);
	          if(temp_index > 1) {
	        	  m_best_group.clear(temp_index + ((attribCount - 2) / 2));
	          }
	        } else {
	          m_best_group.set(temp_index);
	          if(temp_index > 1) {
	        	  m_best_group.set(temp_index + ((attribCount - 2) / 2));
	          }
	        }
	        best_merit = temp_best;
	        if (m_debug) {
	          System.err.print("Best subset found so far: ");
	          int[] atts = attributeList(m_best_group);
	          for (int a : atts) {
	            System.err.print("" + (a + 1) + " ");
	          }
	          System.err.println("\nMerit: " + best_merit);
	        }
	        m_rankedAtts[m_rankedSoFar][0] = temp_index;
	        m_rankedAtts[m_rankedSoFar][1] = best_merit;
	        m_rankedSoFar++;
	        m_rankedAtts[m_rankedSoFar][0] = temp_index + ((attribCount - 2) / 2);
	        m_rankedAtts[m_rankedSoFar][1] = best_merit;
	        m_rankedSoFar++;
	      }
	    }

	    if (parallel) {
	      m_pool.shutdown();
	    }

	    m_bestMerit = best_merit;
	    logger.info("Attributes selected:");
	    int count = 0;
	    for(i = 0; i < m_numAttribs; ++i) {
	    	if(m_best_group.get(i)) {
	    		logger.info(data.attribute(i).name());
	    		++count;
	    	}
	    }
	    logger.info("Attributes selected: {}", count);
	    return attributeList(m_best_group);
	  }

}
