package ro.msg.learning.shop.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDetailDto;
import ro.msg.learning.shop.dto.StockDto;

import java.util.List;

@Component
public interface IDeliveryStrategy {
    List<StockDto> getStocks(List<OrderDetailDto> orderDetailDtoList);
}
