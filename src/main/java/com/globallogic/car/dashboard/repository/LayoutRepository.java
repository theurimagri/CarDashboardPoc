package com.globallogic.car.dashboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.car.dashboard.entity.Layout;

@Repository
public interface LayoutRepository extends CrudRepository<Layout, Long> {

	List<Layout> findByUserId(Long userId);
	
	Optional<Layout> findByLayoutIdAndUserId(Long layoutId, Long userId);
	
}
