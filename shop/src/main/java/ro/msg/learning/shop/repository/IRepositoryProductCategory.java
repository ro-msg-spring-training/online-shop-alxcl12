package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.ProductCategory;

import java.util.Optional;

public interface IRepositoryProductCategory extends JpaRepository<ProductCategory, Long> {

    Optional<ProductCategory> findByName(String name);
}
