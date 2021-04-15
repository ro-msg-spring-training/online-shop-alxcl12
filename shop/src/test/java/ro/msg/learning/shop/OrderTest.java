package ro.msg.learning.shop;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.shop.dto.AddressDto;
import ro.msg.learning.shop.dto.OrderCreateDto;
import ro.msg.learning.shop.dto.OrderDetailDto;
import ro.msg.learning.shop.entity.Address;
import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.repository.IRepositoryAddress;
import ro.msg.learning.shop.repository.IRepositoryLocation;
import ro.msg.learning.shop.repository.IRepositoryProduct;
import ro.msg.learning.shop.repository.IRepositoryStock;
import ro.msg.learning.shop.service.interfaces.IServiceOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ShopApplication.class)
@ActiveProfiles("test")
public class OrderTest {

    @Autowired
    private IRepositoryLocation repositoryLocation;
    @Autowired
    private IRepositoryStock repositoryStock;
    @Autowired
    private IRepositoryProduct repositoryProduct;
    @Autowired
    private IRepositoryAddress repositoryAddress;
    @Autowired
    private IServiceOrder serviceOrder;

    private Product p1 = Product.builder()
            .name("P1")
            .build();
    private Product p2 = Product.builder()
            .name("P2")
            .build();

    private Address address = Address.builder()
            .streetAddress("Avram Iancu")
            .build();

    private Location l1 = Location.builder()
            .address(address)
            .name("L1")
            .build();
    private Location l2 = Location.builder()
            .address(address)
            .name("L2")
            .build();

    private Stock s1 = Stock.builder()
            .location(l1)
            .quantity(10)
            .build();
    private Stock s2 = Stock.builder()
            .location(l1)
            .quantity(10)
            .build();
    private Stock s3 = Stock.builder()
            .location(l2)
            .quantity(10)
            .build();

    @Before
    public void start(){
        p1.setId(1L);
        p2.setId(2L);
        repositoryProduct.save(p1);
        repositoryProduct.save(p2);

        repositoryAddress.save(address);

        repositoryLocation.save(l1);
        repositoryLocation.save(l2);

        repositoryStock.save(s1);
        repositoryStock.save(s2);
        repositoryStock.save(s3);
    }

    @Test
    public void createOrderOk(){
        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();

        orderDetailDtoList.add(OrderDetailDto.builder().productId(1L).quantity(5).build());

        OrderCreateDto orderCreateDto = OrderCreateDto.builder()
                .orders(orderDetailDtoList)
                .addressDto(AddressDto.builder().addressStreet(address.getStreetAddress()).build())
                .build();

        assertFalse(serviceOrder.addMultipleOrders(orderCreateDto).isEmpty());
    }

    @Test
    public void createOrderNotOk(){
        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();

        orderDetailDtoList.add(OrderDetailDto.builder().productId(p1.getId()).quantity(50).build());

        OrderCreateDto orderCreateDto = OrderCreateDto.builder()
                .orders(orderDetailDtoList)
                .addressDto(AddressDto.builder().addressStreet(address.getStreetAddress()).build())
                .build();

        assertThrows(RuntimeException.class, () -> serviceOrder.addMultipleOrders(orderCreateDto));
    }
}
