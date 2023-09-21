package com.SpringBoot.RESTtesting.service;

import com.SpringBoot.RESTtesting.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Serializable> {
}
