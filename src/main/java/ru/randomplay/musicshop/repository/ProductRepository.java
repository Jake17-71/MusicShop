package ru.randomplay.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.randomplay.musicshop.entity.Product;
import ru.randomplay.musicshop.model.ProductStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p " +
            "LEFT JOIN FETCH p.categoryLinks cl " +
            "LEFT JOIN FETCH cl.category " +
            "WHERE p.id = :id")
    Optional<Product> findByIdWithCategories(@Param("id") Long id);

    @Query("SELECT p FROM Product p " +
            "LEFT JOIN FETCH p.categoryLinks cl " +
            "LEFT JOIN FETCH cl.category " +
            "LEFT JOIN FETCH p.supplier " +
            "WHERE p.id = :id")
    Optional<Product> findByIdWithCategoriesAndSupplier(@Param("id") Long id);

    @Query("SELECT DISTINCT p FROM Product p " +
            "LEFT JOIN FETCH p.categoryLinks cl " +
            "LEFT JOIN FETCH cl.category " +
            "LEFT JOIN FETCH p.supplier")
    List<Product> findAllWithCategoriesAndSupplier();

    @Query("SELECT DISTINCT p FROM Product p " +
            "LEFT JOIN FETCH p.categoryLinks cl " +
            "LEFT JOIN FETCH cl.category " +
            "LEFT JOIN FETCH p.supplier " +
            "WHERE p.status = :status")
    List<Product> findAllByStatusWithCategoriesAndSupplier(@Param("status") ProductStatus status);

    // Находим все товары, у которых содержатся все передаваемые категории
    @Query("SELECT p FROM Product p " +
            "LEFT JOIN FETCH p.categoryLinks cl " +
            "LEFT JOIN FETCH cl.category " +
            "LEFT JOIN FETCH p.supplier " +
            "WHERE p.id IN (" +
            "  SELECT p2.id FROM Product p2 " +
            "  JOIN p2.categoryLinks cl2 " +
            "  JOIN cl2.category c2 " +
            "  WHERE c2.name IN :categoryNames " +
            "  GROUP BY p2.id " +
            "  HAVING COUNT(DISTINCT c2.name) = :categoryCount" +
            ") " +
            "AND p.status = :status")
    List<Product> findAllByCategoriesAndStatusWithSupplier(@Param("categoryNames") List<String> categoryNames,
                                                           @Param("categoryCount") int categoryCount,
                                                           @Param("status") ProductStatus status);
}
