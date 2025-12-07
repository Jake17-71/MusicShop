package ru.randomplay.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.randomplay.musicshop.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
