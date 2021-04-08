package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class Supplier extends BaseEntity{

    private String name;
}
