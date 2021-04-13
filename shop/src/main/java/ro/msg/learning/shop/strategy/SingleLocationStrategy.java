package ro.msg.learning.shop.strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.dto.OrderDetailDto;
import ro.msg.learning.shop.dto.StockDto;
import ro.msg.learning.shop.repository.IRepositoryLocation;
import ro.msg.learning.shop.repository.IRepositoryStock;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SingleLocationStrategy implements IDeliveryStrategy{

    private IRepositoryStock repositoryStock;
    private IRepositoryLocation repositoryLocation;

    @Override
    public List<StockDto> getStocks(List<OrderDetailDto> orderDetailDtoList) {
        var locations = repositoryLocation.findAll();
        List<StockDto> toReturn = new ArrayList<>();

        for(var location: locations){
            for(var orderDetailDto: orderDetailDtoList){
                var stocks = repositoryStock.findByProductIdAndQuantityGreaterThanEqualAndLocationId(orderDetailDto.getProductId(),
                        orderDetailDto.getQuantity(), location.getId());

                if(!stocks.isEmpty()){
                    StockDto dto = StockDto.builder()
                            .locationId(location.getId())
                            .productId(orderDetailDto.getProductId())
                            .quantity(stocks.get(0).getQuantity())
                            .build();
                    toReturn.add(dto);

                    return toReturn;
                }
            }
        }

        throw new RuntimeException();
    }
}
