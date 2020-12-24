package com.domain.graphql.repository;

import com.domain.graphql.entity.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> getByTypeLike(String type);

}