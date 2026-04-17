package com.dunnas.ChamadoServicoCondominio.Domain.Repository;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UnitRepository extends JpaRepository<UnitEntity, UUID> {
}
