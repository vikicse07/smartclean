package com.smartclean.smartclean.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smartclean.smartclean.Constants;
import com.smartclean.smartclean.dto.Counter;
import com.smartclean.smartclean.entity.CounterEntity;
import com.smartclean.smartclean.repository.CounterRepository;
import com.smartclean.smartclean.service.CounterService;
import com.smartclean.smartclean.utility.CommonUtility;
import com.smartclean.smartclean.utility.DatabaseTblToModelUtility;

@Service
public class CounterServiceImpl extends Thread implements CounterService {
	@Autowired
	private CounterRepository repository;

	private CounterEntity entity;
	private static final long SERVICE_TIMEOUT = 5000L;

	//Method to get entity by UniqueID
	@Override
	public Counter getCurrentCountByUniqueID(String uniqueId) {
		if (StringUtils.hasText(uniqueId)) {
			Optional<CounterEntity> counterEntity = repository.findOneByUniqueId(uniqueId);

			if (counterEntity.isPresent()) {
			    return DatabaseTblToModelUtility.getCounter(counterEntity.get());
			}
		}

		return null;
	}

	//Method to get all counter values
	@Override
	public List<Counter> getAllCurrentCount() {
		return repository.findAll().stream().map(counterEntity -> DatabaseTblToModelUtility.getCounter(counterEntity))
				.collect(Collectors.toList());
	}

	@Override
	public List<Counter> renderAllCurrentCount() {
		// TODO Auto-generated method stub
		return null;
	}

	//Method to stop a service by its uniqueId
	@Override
	public Counter stopService(String uniqueId) {
		if (StringUtils.hasText(uniqueId)) {
			Optional<CounterEntity> counterEntity = repository.findOneByUniqueId(uniqueId);

			if (counterEntity.isPresent()) {
				this.entity = counterEntity.get();
				this.entity.setModifiedTime(LocalDateTime.now());
				this.entity.setStatus(Constants.SERVICE_STATUS_STOPPED);

				create(this.entity.getStartValue(), this.entity.getStepTime(), true);
			}
		}

		return null;
	}

	//Method to pause a service by its uniqueId
	@Override
	public Counter pauseService(String uniqueId) {
		if (StringUtils.hasText(uniqueId)) {
			Optional<CounterEntity> counterEntity = repository.findOneByUniqueId(uniqueId);

			if (counterEntity.isPresent()) {
				this.entity = counterEntity.get();
				this.entity.setModifiedTime(LocalDateTime.now());
				this.entity.setStatus(Constants.SERVICE_STATUS_PAUSED);

				create(this.entity.getStartValue(), this.entity.getStepTime(), true);
			}
		}

		return null;
	}

	//Method to create a new counter with a uniqueId
	@Override
	public Counter create(int startVal, int stepTime, boolean isModify) {
		if (!isModify) {
			Optional<CounterEntity> counterEntity = repository.findOneByStartValueAndStepTime(startVal, stepTime);

			if (counterEntity.isPresent()) {
				this.entity = counterEntity.get();

				if (this.entity.getStatus().equalsIgnoreCase(Constants.SERVICE_STATUS_STARTED)) {
					this.entity.setStatus(Constants.SERVICE_STATUS_RUNNING);
					this.entity.setModifiedTime(LocalDateTime.now());
				}

		        getTimer().scheduleAtFixedRate(getTimerTask(this.entity), this.entity.getStepTime(), SERVICE_TIMEOUT);
			} else {
				this.entity = new CounterEntity();
				this.entity.setUniqueId(CommonUtility.getUniqueId());
				this.entity.setStartValue(startVal);
				this.entity.setStepTime(stepTime);
				this.entity.setStatus(Constants.SERVICE_STATUS_STARTED);
				this.entity.setCounterValue(0);
				this.entity.setCreationTime(LocalDateTime.now());
				
				getTimer().scheduleAtFixedRate(getTimerTask(this.entity), stepTime, SERVICE_TIMEOUT);
			}
		} else {
			if (this.entity.getStatus().equalsIgnoreCase(Constants.SERVICE_STATUS_STOPPED)) {
				getTimer().scheduleAtFixedRate(getTimerTask(this.entity), entity.getStepTime(), SERVICE_TIMEOUT);
				getTimer().cancel();
				getTimerTask(this.entity).cancel();
			} else if (this.entity.getStatus().equalsIgnoreCase(Constants.SERVICE_STATUS_PAUSED)) {
				getTimer().scheduleAtFixedRate(getTimerTask(this.entity), this.entity.getStepTime(), SERVICE_TIMEOUT);

				try {
					getTimer().wait();
					getTimerTask(this.entity).wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public TimerTask getTimerTask(CounterEntity entity) {
		return new TimerTask() {
			@Override
			public void run() {
				int counter = entity.getCounterValue();
				counter++;
				entity.setCounterValue(counter);

				System.out.println(entity.getUniqueId());
				repository.save(entity);
			}
		};
	}

	public Timer getTimer() {
		return new Timer();
	}
}
