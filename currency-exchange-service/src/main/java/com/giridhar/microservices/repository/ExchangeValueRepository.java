package com.giridhar.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giridhar.microservices.pojo.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);

}
