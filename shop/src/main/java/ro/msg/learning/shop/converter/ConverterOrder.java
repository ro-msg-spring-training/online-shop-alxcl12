package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.AddressDto;
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
        AddressDto addressDto = AddressDto.builder()
                .addressCity(order.getAddress().getCity())
                .addressCountry(order.getAddress().getCountry())
                .addressCounty(order.getAddress().getCounty())
                .addressStreet(order.getAddress().getStreetAddress())
                .build();

        return OrderDto.builder()
                .address(addressDto)
                .orderId(order.getId())
                .locationId(order.getShippedFrom().getId())
                .customerId(order.getCustomer().getId())
                .timestamp(order.getCreatedAt())
                .build();

    }
}
