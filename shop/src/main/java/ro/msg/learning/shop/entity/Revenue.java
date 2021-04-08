package ro.msg.learning.shop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class Revenue extends BaseEntity{

    private String name;
    private LocalDate date;
    private BigDecimal sum;

    @ManyToOne
    @JoinColumn(name = "LocationId")
    private Location location;
}
