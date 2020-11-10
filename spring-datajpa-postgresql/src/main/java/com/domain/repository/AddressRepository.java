package com.domain.repository;

import com.domain.entity.Address;
import com.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>
{

}
