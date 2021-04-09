package ro.msg.learning.shop.converter;

import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.entity.ProductCategory;

public class ConverterProductCategory extends ConverterWrapper<ProductCategory, ProductCategoryDto> {

    @Override
    public ProductCategory getEntity(ProductCategoryDto productCategoryDto) {
        ProductCategory category = new ProductCategory(productCategoryDto.getName(),
                productCategoryDto.getDescription());
        category.setId(productCategoryDto.getProductCategoryId());

        return category;
    }

    @Override
    public ProductCategoryDto getDto(ProductCategory productCategory) {
        return new ProductCategoryDto(productCategory.getId(), productCategory.getName(),
                productCategory.getDescription());
    }
}
