package com.dunnas.ChamadoServicoCondominio.Domain.Core;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Units")
public class UnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "unit_id")
    private UUID id;

    @Column(name = "unit_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "unit_block_id")
    private BlockEntity block;

    public UnitEntity() {
    }

    public UnitEntity(String name, BlockEntity block) {
        this.name = name;
        this.block = block;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BlockEntity getBlock() {
        return block;
    }

    public void setBlock(BlockEntity block) {
        this.block = block;
    }
}
