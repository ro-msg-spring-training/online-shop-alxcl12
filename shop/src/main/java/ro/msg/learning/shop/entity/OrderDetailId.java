package ro.msg.learning.shop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderDetailId implements Serializable {

    private Long order;
    private Long product;
}
