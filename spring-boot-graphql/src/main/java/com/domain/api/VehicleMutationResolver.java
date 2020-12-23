package com.domain.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.domain.dto.VehicleDto;
import com.domain.entity.Vehicle;
import com.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver
{
    private final IVehicleRepository vehicleRepository;
    public Vehicle createVehicle(VehicleDto vehicleDto)
    {
        return vehicleRepository.save(dtoToEntity(vehicleDto));
    }
    private Vehicle dtoToEntity(VehicleDto vehicleDto)
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setLaunchDate(new Date());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setType(vehicleDto.getType());
        return vehicle;
    }
}
