package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.service.IServiceProduct;
import ro.msg.learning.shop.service.ServiceException;

import java.util.List;

@RestController
public class ControllerProduct {

    private final IServiceProduct service;

    @Autowired
    public ControllerProduct(IServiceProduct serv){
        this.service = serv;
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts(){
        return service.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProduct(@PathVariable Long id){
        try {
            return service.findOne(id);
        }
        catch (ServiceException e){
            throw new ControllerException(e.getMessage());
        }
    }

    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct(@PathVariable ProductDto productDto){
        service.addProduct(productDto);

        return new ResponseEntity<>("Product added", HttpStatus.OK);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        try {
            service.delete(id);
        }
        catch (ServiceException ex){
            throw new ControllerException(ex.getMessage());
        }

        return new ResponseEntity<>("Product deleted", HttpStatus.OK);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        service.update(productDto, id);

        return new ResponseEntity<>("Product updated", HttpStatus.OK);
    }
}
