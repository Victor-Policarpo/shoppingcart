package victor.policarpo.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import victor.policarpo.shoppingcart.enums.DiscountType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "db_Coupons")
@Getter
@Setter
public class Coupons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupons_id")
    private Long id;

    @Column(nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    @Column(nullable = false)
    private LocalDate ExpiryDate;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private Integer usageLimit;

    @Column(nullable = false)
    private Integer usageCount;

    @Column(nullable = false)
    private BigDecimal discountValue;

    @Column(nullable = false)
    private BigDecimal minimumOrderValue;

}
