package com.dunnas.ChamadoServicoCondominio.Domain.Service;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.BlockEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Core.UnitEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Repository.BlockRepository;
import com.dunnas.ChamadoServicoCondominio.Domain.Repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlockService {
    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private UnitRepository unitRepository;

    public BlockEntity createBlock(String name, int numberOfFloors, int numberOfUnitsPerFloor) {
        try {
            var block = new BlockEntity();
            block.setName(name);
            block.setFloorQuant(numberOfFloors);
            block.setUnitPerFloor(numberOfUnitsPerFloor);
            block = blockRepository.save(block);
            for (int i = 0; i < numberOfFloors; i++){
                for (int j = 0; j < numberOfUnitsPerFloor; j++){
                    var unit = new UnitEntity();
                    unit.setName(name.split(" ")[0].concat(String.format("%d%02d", i+1, j+1)));
                    unit.setBlock(block);
                    unitRepository.save(unit);
                }
            }
            return block;
        } catch (Exception e) {
            throw new RuntimeException("Error creating block: " + e.getMessage());
        }
    }

    public void deleteBlock(String blockId) {
        try {
            var block = blockRepository.findById(UUID.fromString(blockId))
                    .orElseThrow(() -> new RuntimeException("Block not found with ID: " + blockId));
            blockRepository.delete(block);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting block: " + e.getMessage());
        }
    }

    public List<BlockEntity> getAllBlocks() {
        try {
            return blockRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving blocks: " + e.getMessage());
        }
    }
}
