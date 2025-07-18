package carstore.carstorebe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "CartItems", indexes = {
        @Index(name = "IX_CartItems_CartId", columnList = "CartId"),
        @Index(name = "IX_CartItems_ProductId", columnList = "ProductId")
})
public class CartItem {
    @Id
    @Column(name = "CartItemId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "CartId", nullable = false)
    private Cart cart;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "SavedForLater", nullable = false)
    private Boolean savedForLater = false;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "AddedAt", nullable = false)
    private Instant addedAt;

}