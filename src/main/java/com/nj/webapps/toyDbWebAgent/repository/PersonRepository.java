package com.nj.webapps.toyDbWebAgent.repository;

import com.nj.webapps.toyDbWebAgent.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>
{
}
