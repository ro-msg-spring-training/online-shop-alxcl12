package ro.msg.learning.shop.configuration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.repository.IRepositoryLocation;
import ro.msg.learning.shop.repository.IRepositoryStock;
import ro.msg.learning.shop.strategy.IDeliveryStrategy;
import ro.msg.learning.shop.strategy.MostAbundantStrategy;
import ro.msg.learning.shop.strategy.SingleLocationStrategy;

@Configuration
@AllArgsConstructor
public class StockConfiguration {

    private final IRepositoryStock repositoryStock;
    private final IRepositoryLocation repositoryLocation;

    @Bean
    public IDeliveryStrategy selectStrategy(@Value("${selectedStrategy}") String strategy){
        if(strategy.equals("mostAbundant")){
            return new MostAbundantStrategy(repositoryStock);
        }
        else if(strategy.equals("singleLocation")){
            return new SingleLocationStrategy(repositoryStock, repositoryLocation);
        }

        throw new RuntimeException();
    }
}
