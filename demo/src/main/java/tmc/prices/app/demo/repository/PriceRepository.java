package tmc.prices.app.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tmc.prices.app.demo.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT p FROM PRICE p WHERE START_DATE = ?1 AND PRODUCT_ID = ?2 AND BRAND_ID = ?3 ")
    List<Price> findByDateProductBrand(Date startDate, Long productId, Long brandId);
}