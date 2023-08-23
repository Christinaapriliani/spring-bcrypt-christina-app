package com.bcryptchristina.repository;

import com.bcryptchristina.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByUsernameContainingIgnoreCase(String username, Pageable pageable);

    Page<User> findByFullNameContainingIgnoreCase(String fullName, Pageable pageable);

    Page<User> findByStatus(String status, Pageable pageable);

    Page<User> findByUsernameContainingIgnoreCaseAndStatus(String username, String status, Pageable pageable);

    Page<User> findByFullNameContainingIgnoreCaseAndStatus(String fullName, String status, Pageable pageable);

    Page<User> findByUsernameContainingIgnoreCaseOrFullNameContainingIgnoreCase(String username, String fullName, Pageable pageable);

    Page<User> findByStatusNot(String status, Pageable pageable);

}
