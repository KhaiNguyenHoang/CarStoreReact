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
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Orders", indexes = {
        @Index(name = "IX_Orders_UserId", columnList = "UserId"),
        @Index(name = "IX_Orders_OrderDate", columnList = "OrderDate"),
        @Index(name = "IX_Orders_Status", columnList = "Status"),
        @Index(name = "IX_Orders_PaymentStatus", columnList = "PaymentStatus"),
        @Index(name = "IX_Orders_OrderNumber", columnList = "OrderNumber")
}, uniqueConstraints = {
        @UniqueConstraint(name = "UQ__Orders__CAC5E7438EEC4C12", columnNames = {"OrderNumber"})
})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "VoucherId")
    private Voucher voucher;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "ShippingMethodId")
    private ShippingMethod shippingMethod;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "OrderNumber", nullable = false, length = 50)
    private String orderNumber;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "OrderDate", nullable = false)
    private Instant orderDate;

    @NotNull
    @Column(name = "SubTotal", nullable = false, precision = 18, scale = 2)
    private BigDecimal subTotal;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "TaxAmount", nullable = false, precision = 18, scale = 2)
    private BigDecimal taxAmount;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "ShippingCost", nullable = false, precision = 18, scale = 2)
    private BigDecimal shippingCost;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "DiscountAmount", nullable = false, precision = 18, scale = 2)
    private BigDecimal discountAmount;

    @NotNull
    @Column(name = "TotalAmount", nullable = false, precision = 18, scale = 2)
    private BigDecimal totalAmount;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("'Pending'")
    @Column(name = "Status", nullable = false, length = 50)
    private String status;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("'Pending'")
    @Column(name = "PaymentStatus", nullable = false, length = 50)
    private String paymentStatus;

    @NotNull
    @Nationalized
    @Lob
    @Column(name = "ShippingAddress", nullable = false)
    private String shippingAddress;

    @Nationalized
    @Lob
    @Column(name = "BillingAddress")
    private String billingAddress;

    @Nationalized
    @Lob
    @Column(name = "CustomerNotes")
    private String customerNotes;

    @Nationalized
    @Lob
    @Column(name = "AdminNotes")
    private String adminNotes;

    @Size(max = 100)
    @Nationalized
    @Column(name = "TrackingNumber", length = 100)
    private String trackingNumber;

    @Column(name = "EstimatedDeliveryDate")
    private Instant estimatedDeliveryDate;

    @Column(name = "ActualDeliveryDate")
    private Instant actualDeliveryDate;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "UpdatedAt", nullable = false)
    private Instant updatedAt;

}