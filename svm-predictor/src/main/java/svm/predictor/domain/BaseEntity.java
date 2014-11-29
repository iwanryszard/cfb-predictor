package svm.predictor.domain;

import java.io.Serializable;

public interface BaseEntity<PK extends Serializable> {

	public PK getId();
	
	public void setId(PK id);
}
