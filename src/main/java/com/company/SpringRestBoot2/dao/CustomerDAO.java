package com.company.SpringRestBoot2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.company.SpringRestBoot2.model.CustomerModel;

@Component
public interface CustomerDAO extends CrudRepository<CustomerModel, Integer>{

}
