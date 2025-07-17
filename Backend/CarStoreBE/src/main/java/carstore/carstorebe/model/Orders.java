package carstore.carstorebe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "dbo.Orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "OrderId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "UserId", nullable = false)
    private Integer userId;

    @Column(name = "VoucherId")
    private Integer voucherId;

    @Column(name = "ShippingMethodId")
    private Integer shippingMethodId;

    @Column(name = "OrderNumber", nullable = false)
    private String orderNumber;

    @Column(name = "OrderDate", nullable = false)
    private Date orderDate;

    @Column(name = "SubTotal", nullable = false)
    private BigDecimal subTotal;

    @Column(name = "TaxAmount", nullable = false)
    private BigDecimal taxAmount = BigDecimal.ZERO;

    @Column(name = "ShippingCost", nullable = false)
    private BigDecimal shippingCost = BigDecimal.ZERO;

    @Column(name = "DiscountAmount", nullable = false)
    private BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(name = "TotalAmount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "Status", nullable = false)
    private String status = "Pending";

    @Column(name = "PaymentStatus", nullable = false)
    private String paymentStatus = "Pending";

    @Column(name = "ShippingAddress", nullable = false)
    private String shippingAddress;

    @Column(name = "BillingAddress")
    private String billingAddress;

    @Column(name = "CustomerNotes")
    private String customerNotes;

    @Column(name = "AdminNotes")
    private String adminNotes;

    @Column(name = "TrackingNumber")
    private String trackingNumber;

    @Column(name = "EstimatedDeliveryDate")
    private Date estimatedDeliveryDate;

    @Column(name = "ActualDeliveryDate")
    private Date actualDeliveryDate;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private Date updatedAt;

}
