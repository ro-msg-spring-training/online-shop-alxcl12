package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Builder
@Table(name = "Stock")
@IdClass(StockId.class)
public class Stock implements Serializable {

    @Id
    @ManyToOne
    @MapsId("ProductId")
    @JoinColumn(name = "ProductId")
    private Product product;

    @Id
    @ManyToOne
    @MapsId("LocationId")
    @JoinColumn(name = "LocationId")
    private Location location;

    private Integer quantity;
}
