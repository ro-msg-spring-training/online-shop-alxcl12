package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Builder
public class Location extends BaseEntity{

    private String name;

    @ManyToOne
    @JoinColumn(name = "AddressId")
    private Address address;

}
