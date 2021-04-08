package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Product;

public interface IRepositoryProduct extends JpaRepository<Product, Long> {
}
