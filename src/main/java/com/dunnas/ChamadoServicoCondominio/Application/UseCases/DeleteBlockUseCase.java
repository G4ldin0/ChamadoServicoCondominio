package com.dunnas.ChamadoServicoCondominio.Application.UseCases;

import com.dunnas.ChamadoServicoCondominio.Domain.Service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBlockUseCase {
    @Autowired
    private BlockService blockService;

    public void execute(String blockId) {
        if (blockId == null || blockId.isEmpty()) throw new RuntimeException("Block ID cannot be empty.");
        blockService.deleteBlock(blockId);
    }
}
