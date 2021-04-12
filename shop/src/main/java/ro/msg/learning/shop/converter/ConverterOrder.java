package ro.msg.learning.shop.converter;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.entity.Order;

@Component
public class ConverterOrder extends ConverterWrapper<Order, OrderDto>{

    @Override
    public Order getEntity(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto getDto(Order order) {
        return null;
    }
}
