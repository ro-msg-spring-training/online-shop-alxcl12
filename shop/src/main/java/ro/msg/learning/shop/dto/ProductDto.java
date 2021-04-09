package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private Long productCategoryId;
    private Long supplierId;
    private String imageUrl;
}
