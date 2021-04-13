package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Stock;

import java.util.List;

public interface IRepositoryStock extends JpaRepository<Stock, Long> {

    List<Stock> findByProductIdAndAndQuantityGreaterThanEqualOrderByQuantityDesc(Long productId, Integer quantity);
    List<Stock> findByProductIdAndQuantityGreaterThanEqualAndLocationId(Long productId, Integer quantity, Long locationId);
}
