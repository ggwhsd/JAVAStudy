package com.studyspringcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studyspringcloud.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{

}
