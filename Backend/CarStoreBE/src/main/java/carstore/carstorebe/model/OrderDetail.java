package carstore.carstorebe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "OrderDetails", indexes = {
        @Index(name = "IX_OrderDetails_OrderId", columnList = "OrderId"),
        @Index(name = "IX_OrderDetails_ProductId", columnList = "ProductId")
})
public class OrderDetail {
    @Id
    @Column(name = "OrderDetailId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "OrderId", nullable = false)
    private Order order;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "ProductName", nullable = false, length = 100)
    private String productName;

    @NotNull
    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "UnitPrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "DiscountApplied", nullable = false, precision = 18, scale = 2)
    private BigDecimal discountApplied;

    @NotNull
    @Column(name = "SubTotal", nullable = false, precision = 18, scale = 2)
    private BigDecimal subTotal;

}