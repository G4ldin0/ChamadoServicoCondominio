package com.dunnas.ChamadoServicoCondominio.Domain.Repository;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlockRepository extends JpaRepository<BlockEntity, UUID> {
}
