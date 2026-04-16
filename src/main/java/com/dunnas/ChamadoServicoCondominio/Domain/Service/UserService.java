package com.dunnas.ChamadoServicoCondominio.Domain.Service;

import com.dunnas.ChamadoServicoCondominio.Domain.Core.Role;
import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import com.dunnas.ChamadoServicoCondominio.Domain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    // READ
    public Optional<UserEntity> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> getUserByLogin(String login) {
        return Optional.ofNullable(userRepository.findByLogin(login));
    }

    public List<UserEntity> getAllUsers(Role role) {
        switch (role) {
            case USER:
                return userRepository.findAllWithRoleUser();
            case ADMIN:
                return userRepository.findAllWithRoleAdmin();
            case WORKER:
                return userRepository.findAllWithRoleWorker();
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    // UPDATE
    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    // DELETE
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }
}
