package svm.predictor.dto;

import java.io.Serializable;

public abstract class BaseDto<PK extends Serializable> {

	private PK id;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}
}
