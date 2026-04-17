package com.dunnas.ChamadoServicoCondominio.Domain.Core;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Blocks")
public class BlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "block_id")
    private UUID id;

    @Column(name = "block_name")
    private String name;

    @Column(name = "block_floor_quant")
    private int floorQuant;

    @Column(name = "block_units_per_floor")
    private int unitPerFloor;

    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UnitEntity> units;

    public BlockEntity() {
    }

    public BlockEntity(String name, int floorQuant, int unitPerFloor) {
        this.name = name;
        this.floorQuant = floorQuant;
        this.unitPerFloor = unitPerFloor;
    }

    public int getUnitQuant() {
        return floorQuant * unitPerFloor;
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

    public int getFloorQuant() {
        return floorQuant;
    }

    public void setFloorQuant(int floorQuant) {
        this.floorQuant = floorQuant;
    }

    public int getUnitPerFloor() {
        return unitPerFloor;
    }

    public void setUnitPerFloor(int unitPerFloor) {
        this.unitPerFloor = unitPerFloor;
    }
}
