package com.smartclean.smartclean.utility;

import com.smartclean.smartclean.dto.Counter;
import com.smartclean.smartclean.entity.CounterEntity;

public class DatabaseTblToModelUtility {
	private DatabaseTblToModelUtility() {
	}

	public static Counter getCounter(CounterEntity counterEntity) {
		Counter counter = null;

		if (counterEntity != null) {
			counter = new Counter();
			counter.setStartValue(counterEntity.getStartValue());
			counter.setStepTime(counterEntity.getStepTime());
			counter.setUniqueId(counterEntity.getUniqueId());
			counter.setStatus(counterEntity.getStatus());
			counter.setCounterValue(counterEntity.getCounterValue());
			counter.setCreationTime(counterEntity.getCreationTime());
			counter.setModifiedTime(counterEntity.getModifiedTime());
		}

		return counter;
	}
}
