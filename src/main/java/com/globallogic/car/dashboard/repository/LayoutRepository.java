package com.globallogic.car.dashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.car.dashboard.entity.Layout;

@Repository
public interface LayoutRepository extends CrudRepository<Layout, Long> {
}
