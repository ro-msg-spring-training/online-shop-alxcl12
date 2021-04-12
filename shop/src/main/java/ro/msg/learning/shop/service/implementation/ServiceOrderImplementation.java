package ro.msg.learning.shop.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.converter.ConverterOrder;
import ro.msg.learning.shop.repository.IRepositoryOrder;
import ro.msg.learning.shop.service.interfaces.IServiceOrder;
import ro.msg.learning.shop.strategy.IDeliveryStrategy;

@Service
@RequiredArgsConstructor
public class ServiceOrderImplementation implements IServiceOrder {

    private final IRepositoryOrder repositoryOrder;
    private final ConverterOrder converterOrder;
    private final IDeliveryStrategy deliveryStrategy;


}
