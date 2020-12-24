package com.domain.graphql.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.domain.graphql.entity.Vehicle;
import com.domain.graphql.repository.IVehicleRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final IVehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(String type) {
        return vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id) {
        return vehicleRepository.findById(id);
    }
}