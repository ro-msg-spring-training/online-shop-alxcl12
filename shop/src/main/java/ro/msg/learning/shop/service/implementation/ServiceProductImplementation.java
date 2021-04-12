package ro.msg.learning.shop.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.converter.ConverterProduct;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.entity.ProductCategory;
import ro.msg.learning.shop.entity.Supplier;
import ro.msg.learning.shop.repository.IRepositoryProduct;
import ro.msg.learning.shop.repository.IRepositoryProductCategory;
import ro.msg.learning.shop.repository.IRepositorySupplier;
import ro.msg.learning.shop.service.interfaces.IServiceProduct;
import ro.msg.learning.shop.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProductImplementation implements IServiceProduct {

    private final IRepositoryProduct repositoryProduct;
    private final IRepositoryProductCategory repositoryCategory;
    private final IRepositorySupplier repositorySupplier;
    private final ConverterProduct converter;


    @Override
    public List<ProductDto> findAll() {
        var products = repositoryProduct.findAll();

        return new ArrayList<>(converter.convertEntityToDto(products));
    }

    @Override
    public void addProduct(ProductDto productDto) {
        var productEntity = converter.getEntity(productDto);

        productEntity.setProductCategory(getProductCategory(productDto.getProductCategoryName(),
                productDto.getProductCategoryDescription()));

        productEntity.setSupplier(getSupplier(productDto.getSupplierName()));

        repositoryProduct.save(productEntity);
    }

    @Override
    public ProductDto findOne(Long id) throws ServiceException {
        var product = repositoryProduct.findById(id);

        if(product.isPresent()) {
            return converter.getDto(product.get());
        }
        else {
            throw new ServiceException("Product does not exist!");
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        var product = repositoryProduct.findById(id);

        if(product.isPresent()) {
            repositoryProduct.delete(product.get());
        }
        else {
            throw new ServiceException("Product does not exist to be deleted!");
        }
    }

    @Override
    public void update(ProductDto productDto, Long id) {
        var productInDb = repositoryProduct.findById(id);

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

            repositoryProduct.save(product);
        }
        else {
            repositoryProduct.save(converter.getEntity(productDto));
        }
    }

    @Override
    public ProductCategory getProductCategory(String categoryName, String categoryDescription) {
        var category = repositoryCategory.findByName(categoryName);

        if(category.isPresent()){
            return category.get();
        }
        else {
            ProductCategory cat = new ProductCategory(categoryName, categoryDescription);
            repositoryCategory.save(cat);
            return cat;
        }
    }

    @Override
    public Supplier getSupplier(String supplierName) {
        var supplier = repositorySupplier.findByName(supplierName);

        if(supplier.isPresent()){
            return supplier.get();
        }
        else {
            Supplier supp = new Supplier(supplierName);
            repositorySupplier.save(supp);
            return supp;
        }
    }
}
