package com.smartclean.smartclean.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartclean.smartclean.entity.CounterEntity;

@Repository
public interface CounterRepository extends JpaRepository<CounterEntity, String> {
	Optional<CounterEntity> findOneByUniqueId(String uniqueId);

	List<CounterEntity> findAll();

	Optional<CounterEntity> findOneByStartValueAndStepTime(int startVal, int stepTime);
}
