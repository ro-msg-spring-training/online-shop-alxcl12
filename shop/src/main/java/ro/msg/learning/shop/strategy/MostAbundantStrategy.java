package ro.msg.learning.shop.strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.dto.OrderDetailDto;
import ro.msg.learning.shop.dto.StockDto;
import ro.msg.learning.shop.repository.IRepositoryStock;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MostAbundantStrategy implements IDeliveryStrategy{

    private IRepositoryStock repositoryStock;

    @Override
    public List<StockDto> getStocks(List<OrderDetailDto> orderDetailDtoList) {
        List<StockDto> toReturn = new ArrayList<>();

        for (var order: orderDetailDtoList){
            var stocks = repositoryStock.findByProductIdAndAndQuantityGreaterThanEqualOrderByQuantityDesc(order.getProductId(), order.getQuantity());

            if(!stocks.isEmpty()){
                var stock = stocks.get(0);

                StockDto dto = StockDto.builder()
                        .quantity(order.getQuantity())
                        .locationId(stock.getLocation().getId())
                        .productId(stock.getProduct().getId())
                        .build();

                toReturn.add(dto);
            }
            else {
                throw new RuntimeException();
            }
        }

        return toReturn;
    }
}
