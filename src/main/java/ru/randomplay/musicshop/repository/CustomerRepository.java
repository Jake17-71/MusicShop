package ru.randomplay.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.randomplay.musicshop.entity.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c " +
            "JOIN FETCH c.user u " +
            "JOIN FETCH c.cart " +
            "WHERE u.email = :email")
    Optional<Customer> findByUserEmail(@Param("email") String email);
}
