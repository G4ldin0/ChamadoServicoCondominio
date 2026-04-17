package com.dunnas.ChamadoServicoCondominio.Application.UseCases;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.BlockEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAllBlocks
{
    @Autowired
    private BlockService blockService;

    public List<BlockEntity> execute() {
        return blockService.getAllBlocks();
    }
}
