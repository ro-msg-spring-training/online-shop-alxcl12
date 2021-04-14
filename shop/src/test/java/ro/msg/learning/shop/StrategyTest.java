package ro.msg.learning.shop;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.msg.learning.shop.dto.AddressDto;
import ro.msg.learning.shop.dto.OrderCreateDto;
import ro.msg.learning.shop.dto.OrderDetailDto;
import ro.msg.learning.shop.service.interfaces.IServiceOrder;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {

    @Autowired
    private final IServiceOrder service;

    public StrategyTest(IServiceOrder service) {
        this.service = service;
    }

    @Test
    @Transactional
    public void CreateOrderSuccess() {
        List<OrderDetailDto> orderDetailList = new ArrayList<>();

        orderDetailList.add(OrderDetailDto.builder().productId(2L).quantity(3).orderId(1L).build());

        AddressDto addressDto = AddressDto.builder()
                .addressStreet("Ana Ipatescu")
                .addressCounty("Suceava")
                .addressCity("Suceava")
                .addressCountry("Romania")
                .build();

        OrderCreateDto orderDto = OrderCreateDto.builder()
                .addressDto(addressDto)
                .orders(orderDetailList)
                .build();

        try {
            var result = service.addMultipleOrders(orderDto);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
