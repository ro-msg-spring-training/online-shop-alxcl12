package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.entity.StockId;

import java.util.List;

public interface IRepositoryStock extends JpaRepository<Stock, StockId> {

//    @Query(value = "select * from Stock where ProductId = :prodId " +
//            "AND Quantity >= :quant order by Quantity desc", nativeQuery = true)
    List<Stock> findByProductIdAndQuantityGreaterThanOrderByQuantityDesc(@Param("prodId")Long productId,@Param("quant") Integer quantity);

//    @Query(value = "select * from Stock where ProductId = :prodId " +
//            "AND Quantity >= :quant and LocationId = :locId", nativeQuery = true)
    List<Stock> findByProductIdAndLocationIdAndQuantityGreaterThanEqual(@Param("prodId")Long productId,@Param("quant") Integer quantity,@Param("locId") Long locationId);
}
