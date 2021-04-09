package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.OrderDetail;

public interface IRepositoryOrderDetail extends JpaRepository<OrderDetail, Long> {
}