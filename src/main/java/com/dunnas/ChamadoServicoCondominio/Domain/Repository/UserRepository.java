package com.dunnas.ChamadoServicoCondominio.Domain.Repository;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByLogin(String login);

    @Query("SELECT u FROM UserEntity u WHERE u.role = 'USER'")
    List<UserEntity> findAllWithRoleUser();

    @Query("SELECT u FROM UserEntity u WHERE u.role = 'ADMIN'")
    List<UserEntity> findAllWithRoleAdmin();

    @Query("SELECT u FROM UserEntity u WHERE u.role = 'WORKER'")
    List<UserEntity> findAllWithRoleWorker();
}
