package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Builder
public class Address extends BaseEntity{

    private String country;
    private String city;
    private String county;
    private String streetAddress;
}
