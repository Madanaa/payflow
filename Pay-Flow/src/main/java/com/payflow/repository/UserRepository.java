package com.payflow.repository;

import com.payflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByUpiIdOrderByUserIdAsc(String upiId);

    boolean existsByUpiId(String upiId);

    // for minimum user
    @Query("SELECT u FROM User u WHERE u.balance > :minBalance")
    List<User> findUsersWithBalanceGreaterThan(@Param("minBalance") Double minBalance);
}
