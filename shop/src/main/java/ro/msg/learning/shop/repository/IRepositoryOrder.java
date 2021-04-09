package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Order;

public interface IRepositoryOrder extends JpaRepository<Order, Long> {
}
