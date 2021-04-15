package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderCreateDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.service.interfaces.IServiceOrder;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerOrder {

    private final IServiceOrder service;

    @PostMapping("/orders")
    public List<OrderDto> createOrder(@RequestBody OrderCreateDto orderCreateDto){
        orderCreateDto.setTimestamp(LocalDateTime.now());

        return service.addMultipleOrders(orderCreateDto);
    }
}
