package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Builder
public class Product extends BaseEntity{

    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "SupplierId")
    private Supplier supplier;

    private String imageUrl;
}
