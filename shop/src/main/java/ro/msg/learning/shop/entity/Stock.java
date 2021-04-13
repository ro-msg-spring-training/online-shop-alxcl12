package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Builder
@IdClass(StockId.class)
public class Stock{

    @Id
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "LocationId")
    private Location location;

    private Integer quantity;
}
