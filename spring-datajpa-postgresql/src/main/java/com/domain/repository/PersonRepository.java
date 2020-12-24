package com.domain.repository;

import com.domain.graphql.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>
{
}
