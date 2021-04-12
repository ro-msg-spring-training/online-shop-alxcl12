package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Builder
public class Order extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "ShippedFromId")
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "AddressId")
    private Address address;
}
