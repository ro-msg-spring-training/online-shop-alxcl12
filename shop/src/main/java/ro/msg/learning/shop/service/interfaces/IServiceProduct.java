package ro.msg.learning.shop.service.interfaces;


import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.entity.ProductCategory;
import ro.msg.learning.shop.entity.Supplier;
import ro.msg.learning.shop.service.ServiceException;

import java.util.List;

public interface IServiceProduct {

    List<ProductDto> findAll();

    void addProduct(ProductDto productDto);

    ProductDto findOne(Long id) throws ServiceException;

    void delete(Long id) throws ServiceException;

    void update(ProductDto productDto, Long id);

    ProductCategory getProductCategory(String categoryName, String categoryDescription);

    Supplier getSupplier(String supplierName);
}
