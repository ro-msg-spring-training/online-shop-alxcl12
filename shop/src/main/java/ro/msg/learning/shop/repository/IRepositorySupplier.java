package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Supplier;

public interface IRepositorySupplier extends JpaRepository<Supplier, Long> {
}
