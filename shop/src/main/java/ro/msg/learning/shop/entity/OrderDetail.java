package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Builder
@IdClass(OrderDetailId.class)
public class OrderDetail{

    @Id
    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    private Long quantity;
}
