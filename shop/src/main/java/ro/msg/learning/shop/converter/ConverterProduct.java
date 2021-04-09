package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.entity.Product;

public class ConverterProduct extends ConverterWrapper<Product, ProductDto> {

    @Override
    public Product getEntity(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto getDto(Product product) {
        return null;
    }
}
