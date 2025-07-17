package carstore.carstorebe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "dbo.OrderDetails")
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "OrderDetailId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailId;

    @Column(name = "OrderId", nullable = false)
    private Integer orderId;

    @Column(name = "ProductId", nullable = false)
    private Integer productId;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "DiscountApplied", nullable = false)
    private BigDecimal discountApplied = BigDecimal.ZERO;

    @Column(name = "SubTotal", nullable = false)
    private BigDecimal subTotal;

}
