package com.domain.repository;

import com.domain.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle,Long>
{
    List<Vehicle> getByTypeLike(String type);
}
