package ru.randomplay.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.randomplay.musicshop.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
