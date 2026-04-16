package com.dunnas.ChamadoServicoCondominio.Domain.Repository;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByLogin(String login);

}
