package ru.randomplay.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.randomplay.musicshop.entity.Supply;

import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    @Query("SELECT DISTINCT s FROM Supply s " +
            "LEFT JOIN FETCH s.warehouseManager wm " +
            "LEFT JOIN FETCH wm.user " +
            "LEFT JOIN FETCH s.supplyItems si " +
            "LEFT JOIN FETCH si.product")
    List<Supply> findAllWithWarehouseManagerAndProducts();
}
