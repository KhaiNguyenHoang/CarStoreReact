package carstore.carstorebe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "dbo.CartItems")
public class CartItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CartItemId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @Column(name = "CartId", nullable = false)
    private Integer cartId;

    @Column(name = "ProductId", nullable = false)
    private Integer productId;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "SavedForLater", nullable = false)
    private Boolean savedForLater = Boolean.FALSE;

    @Column(name = "AddedAt", nullable = false)
    private Date addedAt;

}
