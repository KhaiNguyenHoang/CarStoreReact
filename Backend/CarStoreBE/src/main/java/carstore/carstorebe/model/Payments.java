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
@Table(name = "dbo.Payments")
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PaymentId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(name = "OrderId", nullable = false)
    private Integer orderId;

    @Column(name = "PaymentMethodId", nullable = false)
    private Integer paymentMethodId;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "PaymentDate", nullable = false)
    private Date paymentDate;

    @Column(name = "Status", nullable = false)
    private String status = "Pending";

    @Column(name = "TransactionId")
    private String transactionId;

    @Column(name = "GatewayResponse")
    private String gatewayResponse;

    @Column(name = "FailureReason")
    private String failureReason;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private Date updatedAt;

}
