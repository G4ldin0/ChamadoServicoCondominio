package com.dunnas.ChamadoServicoCondominio.Application.UseCases;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.BlockEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateBlockUseCase {
    @Autowired
    private BlockService blockService;

    public BlockEntity execute(String name, int numberOfFloors, int numberOfUnitsPerFloor) {
        if (name == null || name.isEmpty()) throw new RuntimeException("Block name cannot be empty.");
        if (numberOfFloors < 0) throw new RuntimeException("Number of floors must be positive.");
        if (numberOfUnitsPerFloor <= 0) throw new RuntimeException("Number of units per floor must be greater than zero.");

        return blockService.createBlock(name, numberOfFloors, numberOfUnitsPerFloor);
    }
}
