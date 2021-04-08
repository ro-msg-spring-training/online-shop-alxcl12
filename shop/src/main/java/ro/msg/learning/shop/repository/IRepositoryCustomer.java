package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Customer;

public interface IRepositoryCustomer extends JpaRepository<Customer, Long> {
}
