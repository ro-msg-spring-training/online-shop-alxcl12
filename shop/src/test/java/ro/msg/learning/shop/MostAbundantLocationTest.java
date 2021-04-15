package ro.msg.learning.shop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ro.msg.learning.shop.dto.OrderCreateDto;
import ro.msg.learning.shop.dto.OrderDetailDto;
import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.repository.IRepositoryStock;
import ro.msg.learning.shop.strategy.MostAbundantStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(MockitoJUnitRunner.class)
public class MostAbundantLocationTest {

    @Mock
    private IRepositoryStock repositoryStock;
    @InjectMocks
    private MostAbundantStrategy strategy;

    private Location firstLocation;
    private Location secondLocation;

    private Product product;

    private Stock firstStock;
    private Stock secondStock;

    private List<Stock> stockList;


    @BeforeAll
    public void start(){
        firstLocation = Location.builder().name("One").build();
        firstLocation.setId(1L);

        secondLocation = Location.builder().name("Two").build();
        secondLocation.setId(2L);

        product = Product.builder().name("Product").build();
        product.setId(1L);

        firstStock = Stock.builder().location(firstLocation).quantity(10).product(product).build();
        secondStock = Stock.builder().location(secondLocation).quantity(100).product(product).build();

        stockList = new ArrayList<>();
        stockList.add(firstStock);
        stockList.add(secondStock);
    }

    @Test
    public void testStockOk(){
        Mockito.when(repositoryStock.findByProductIdAndQuantityGreaterThanOrderByQuantityDesc(product.getId(), 5)).thenReturn(stockList);

        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        orderDetailDtoList.add(OrderDetailDto.builder().productId(1L).quantity(5).build());

        OrderCreateDto sendDto = OrderCreateDto.builder().orders(orderDetailDtoList).build();

        assertEquals(firstLocation.getId(), strategy.getStocks(orderDetailDtoList).get(0).getLocationId());
    }

    @Test
    public void testStockNotOk(){
        Mockito.when(repositoryStock.findByProductIdAndQuantityGreaterThanOrderByQuantityDesc(product.getId(), 150)).thenReturn(null);

        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        orderDetailDtoList.add(OrderDetailDto.builder().productId(1L).quantity(150).build());

        OrderCreateDto sendDto = OrderCreateDto.builder().orders(orderDetailDtoList).build();

        assertThrows(RuntimeException.class, () -> strategy.getStocks(orderDetailDtoList));
    }
}
