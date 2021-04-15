package ro.msg.learning.shop.service.interfaces;

import ro.msg.learning.shop.dto.OrderCreateDto;
import ro.msg.learning.shop.dto.OrderDto;

import java.util.List;

public interface IServiceOrder {

    List<OrderDto> addMultipleOrders(OrderCreateDto inputOrders);
}
