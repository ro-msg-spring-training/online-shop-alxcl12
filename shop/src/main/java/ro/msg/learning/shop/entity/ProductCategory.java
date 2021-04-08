package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class ProductCategory extends BaseEntity{

    private String name;
    private String description;
}
