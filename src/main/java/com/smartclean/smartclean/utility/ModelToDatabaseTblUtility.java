package com.smartclean.smartclean.utility;

import com.smartclean.smartclean.dto.Counter;
import com.smartclean.smartclean.entity.CounterEntity;

public class ModelToDatabaseTblUtility {
	private ModelToDatabaseTblUtility() {
	}

	public static CounterEntity getCounterEntity(Counter counter) {
		CounterEntity counterEntity = null;

		if (counter != null) {
			counterEntity = new CounterEntity();
			counterEntity.setStartValue(counter.getStartValue());
			counterEntity.setStepTime(counter.getStepTime());
			counterEntity.setUniqueId(counter.getUniqueId());
			counterEntity.setStatus(counter.getStatus());
			counterEntity.setCounterValue(counter.getCounterValue());
			counterEntity.setCreationTime(counter.getCreationTime());
			counterEntity.setModifiedTime(counter.getModifiedTime());
		}

		return counterEntity;
	}
}
