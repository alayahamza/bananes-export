package com.alenia.bananesexport.repository;

import com.alenia.bananesexport.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataOrderRepository extends JpaRepository<Order, Long> {
}
