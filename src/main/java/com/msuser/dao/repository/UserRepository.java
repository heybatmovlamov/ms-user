package com.msuser.dao.repository;

import com.msuser.dao.entity.UserEntity;
import com.msuser.model.enums.UserStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsernameAndStatus(String username, UserStatus status);

    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus status);
}
