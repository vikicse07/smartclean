package com.smartclean.smartclean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartclean.smartclean.Constants;
import com.smartclean.smartclean.dto.Counter;
import com.smartclean.smartclean.service.CounterService;

@RestController
public class CounterController {
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = Constants.SMART_CLEAN_API_CREATE_NEW)
	public Counter createNew(@PathVariable int startVal,@PathVariable int steptime) {
		return counterService.create(startVal, steptime, false);
	}

	@RequestMapping(value = Constants.SMART_CLEAN_API_GET_CURRENT_COUNT_BY_UNIQUEID)
	public Counter geCounterByUniqueId(@PathVariable String uniqueId) {
		return counterService.getCurrentCountByUniqueID(uniqueId);
	}

	@RequestMapping(value = Constants.SMART_CLEAN_API_GET_ALL_CURRENT_COUNT)
	public List<Counter> getAllCurrentCount() {
		return counterService.getAllCurrentCount();
	}

	@RequestMapping(value = Constants.SMART_CLEAN_API_RENDER_ALL_CURRENT_COUNT)
	public List<Counter> renderAllCurrentCount() {
		return counterService.renderAllCurrentCount();
	}

	@RequestMapping(value = Constants.SMART_CLEAN_API_STOP_SERVICE_BY_UNIQUEID)
	public Counter stopService(@PathVariable String uniqueId) {
		return counterService.stopService(uniqueId);
	}

	@RequestMapping(value = Constants.SMART_CLEAN_API_PAUSE_SERVICE_BY_UNIQUEID)
	public Counter pauseService(@PathVariable String uniqueId) {
		return counterService.pauseService(uniqueId);
	}
}
