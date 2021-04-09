package ro.msg.learning.shop.converter;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.entity.ProductCategory;
import ro.msg.learning.shop.entity.Supplier;

@Component
public class ConverterProduct extends ConverterWrapper<Product, ProductDto> {


    @Override
    public Product getEntity(ProductDto productDto) {
        ProductCategory productCategory = new ProductCategory(productDto.getProductCategoryName(),
                productDto.getProductCategoryDescription());
        productCategory.setId(productDto.getProductCategoryId());

        Supplier supplier = new Supplier(productDto.getSupplierName());
        supplier.setId(productDto.getSupplierId());

        Product product = Product.builder()
                .productCategory(productCategory)
                .description(productDto.getDescription())
                .imageUrl(productDto.getImageUrl())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .supplier(supplier)
                .weight(productDto.getWeight())
                .build();

        product.setId(productDto.getProductId());

        return product;
    }

    @Override
    public ProductDto getDto(Product product) {
        return ProductDto.builder()
                .supplierName(product.getSupplier().getName())
                .supplierId(product.getSupplier().getId())
                .productCategoryId(product.getProductCategory().getId())
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
