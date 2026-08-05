package victor.policarpo.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "db_product")
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantityInventory;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "product")
    private Set<ProductShoppingCart> shoppingCartItems;


}
