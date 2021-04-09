package ro.msg.learning.shop.service;


import ro.msg.learning.shop.dto.ProductDto;

import java.util.List;

public interface IServiceProduct {

    List<ProductDto> findAll();

    void addProduct(ProductDto productDto);

    ProductDto findOne(Long id) throws ServiceException;

    void delete(Long id) throws ServiceException;

    void update(ProductDto productDto, Long id);
}
