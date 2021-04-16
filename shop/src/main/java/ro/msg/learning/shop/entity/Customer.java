package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;
}
