package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Address;

public interface IRepositoryAddress extends JpaRepository<Address, Long> {
}
