package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.entity.Product;

@Component
public class ConverterProduct extends ConverterWrapper<Product, ProductDto> {


    @Override
    public Product getEntity(ProductDto productDto) {

        Product product = Product.builder()
                .description(productDto.getDescription())
                .imageUrl(productDto.getImageUrl())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .weight(productDto.getWeight())
                .build();

        product.setId(productDto.getProductId());

        return product;
    }

    @Override
    public ProductDto getDto(Product product) {
        return ProductDto.builder()
                .supplierName(product.getSupplier().getName())
                .productCategoryName(product.getProductCategory().getName())
                .productCategoryDescription(product.getProductCategory().getDescription())
                .productId(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .weight(product.getWeight())
                .imageUrl(product.getImageUrl())
                .build();
    }
}
