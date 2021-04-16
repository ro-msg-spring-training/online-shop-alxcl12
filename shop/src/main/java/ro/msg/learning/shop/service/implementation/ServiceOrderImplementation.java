package ro.msg.learning.shop.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.converter.ConverterAddress;
import ro.msg.learning.shop.converter.ConverterOrder;
import ro.msg.learning.shop.dto.OrderCreateDto;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.entity.Address;
import ro.msg.learning.shop.entity.Order;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.service.interfaces.IServiceOrder;
import ro.msg.learning.shop.strategy.IDeliveryStrategy;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOrderImplementation implements IServiceOrder {

    private final IRepositoryOrderDetail repositoryOrderDetail;
    private final IRepositoryStock repositoryStock;
    private final IRepositoryOrder repositoryOrder;
    private final IRepositoryLocation repositoryLocation;
    private final IRepositoryProduct repositoryProduct;
    private final IRepositoryAddress repositoryAddress;

    private final ConverterOrder converterOrder;
    private final ConverterAddress converterAddress;
    private final IDeliveryStrategy deliveryStrategy;


    @Override
    public List<OrderDto> addMultipleOrders(OrderCreateDto inputOrders) {
        var stocks = deliveryStrategy.getStocks(inputOrders.getOrders());
        List<OrderDto> toReturn = new ArrayList<>();

        Address address = converterAddress.getEntity(inputOrders.getAddressDto());
        repositoryAddress.save(address);

        for(var stock : stocks){
            var order = Order.builder()
                    .address(address)
                    .createdAt(inputOrders.getTimestamp())
                    .shippedFrom(repositoryLocation.findById(stock.getLocationId()).get())
                    .build();
            repositoryOrder.save(order);

            OrderDetail orderDetail = OrderDetail.builder()
                    .order(order)
                    .product(repositoryProduct.findById(stock.getProductId()).get())
                    .quantity(stock.getQuantity())
                    .build();

            repositoryOrderDetail.save(orderDetail);

            var realStock = repositoryStock.findByProductIdAndLocationIdAndQuantityGreaterThanEqual(stock.getProductId(),
                     stock.getLocationId(),stock.getQuantity()).get(0);

            realStock.setQuantity(realStock.getQuantity() - stock.getQuantity());
            repositoryStock.save(realStock);

            toReturn.add(converterOrder.getDto(order));
        }

        return toReturn;
    }
}
