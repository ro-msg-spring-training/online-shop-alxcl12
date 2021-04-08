package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Revenue;

public interface IRepositoryRevenue extends JpaRepository<Revenue, Long> {
}
