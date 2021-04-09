package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.converter.ConverterProduct;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.repository.IRepositoryProduct;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProductImplementation implements IServiceProduct{

    private final IRepositoryProduct repository;
    private final ConverterProduct converter;

    @Autowired
    public ServiceProductImplementation(IRepositoryProduct repo, ConverterProduct conv){
        this.converter = conv;
        this.repository = repo;
    }

    @Override
    public List<ProductDto> findAll() {
        var products = repository.findAll();

        return new ArrayList<>(converter.convertEntityToDto(products));
    }

    @Override
    public void addProduct(ProductDto productDto) {
        var productEntity = converter.getEntity(productDto);

        repository.save(productEntity);
    }

    @Override
    public ProductDto findOne(Long id) throws ServiceException {
        var product = repository.findById(id);

        if(product.isPresent()) {
            return converter.getDto(product.get());
        }
        else {
            throw new ServiceException("Product does not exist!");
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        var product = repository.findById(id);

        if(product.isPresent()) {
            repository.delete(product.get());
        }
        else {
            throw new ServiceException("Product does not exist to be deleted!");
        }
    }

    @Override
    public void update(ProductDto productDto, Long id) {
        var productInDb = repository.findById(id);

        if(productInDb.isPresent()) {
            var product = productInDb.get();
            var newProduct = converter.getEntity(productDto);

            product.setProductCategory(newProduct.getProductCategory());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            product.setName(newProduct.getName());
            product.setImageUrl(newProduct.getImageUrl());
            product.setSupplier(newProduct.getSupplier());
            product.setWeight(newProduct.getWeight());

            repository.save(product);
        }
        else {
            repository.save(converter.getEntity(productDto));
        }
    }
}
