package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.OrderDetailId;

public interface IRepositoryOrderDetail extends JpaRepository<OrderDetail, OrderDetailId> {
}