package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Builder
@ToString
@Table(name = "OrderDetail")
@IdClass(OrderDetailId.class)
public class OrderDetail{

    @Id
    @MapsId("OrderId")
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderId")
    private Order order;

    @Id
    @MapsId("ProductId")
    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId")
    private Product product;

    private Integer quantity;
}
