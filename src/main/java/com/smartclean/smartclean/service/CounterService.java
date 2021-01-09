package com.smartclean.smartclean.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartclean.smartclean.dto.Counter;

@Service
public interface CounterService {
	Counter create(int startVal, int stepTime, boolean isModify);

	Counter getCurrentCountByUniqueID(String uniqueId);

	List<Counter> getAllCurrentCount();

	List<Counter> renderAllCurrentCount();

	Counter stopService(String uniqueId);

	Counter pauseService(String uniqueId);
}
