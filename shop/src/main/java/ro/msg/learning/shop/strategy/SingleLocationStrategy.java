package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.dto.OrderDetailDto;
import ro.msg.learning.shop.dto.StockDto;

import java.util.List;

public class SingleLocationStrategy implements IDeliveryStrategy{

    @Override
    public List<StockDto> getStocks(List<OrderDetailDto> orderDetailDtoList) {
        return null;
    }
}
