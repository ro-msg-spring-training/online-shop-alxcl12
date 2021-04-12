package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Supplier;

import java.util.Optional;

public interface IRepositorySupplier extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByName(String name);
}
