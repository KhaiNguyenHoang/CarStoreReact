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
@Table(name = "Payments", indexes = {
        @Index(name = "IX_Payments_OrderId", columnList = "OrderId"),
        @Index(name = "IX_Payments_Status", columnList = "Status"),
        @Index(name = "IX_Payments_PaymentDate", columnList = "PaymentDate")
})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "OrderId", nullable = false)
    private Order order;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "PaymentMethodId", nullable = false)
    private PaymentMethod paymentMethod;

    @NotNull
    @Column(name = "Amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal amount;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "PaymentDate", nullable = false)
    private Instant paymentDate;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("'Pending'")
    @Column(name = "Status", nullable = false, length = 50)
    private String status;

    @Size(max = 100)
    @Nationalized
    @Column(name = "TransactionId", length = 100)
    private String transactionId;

    @Nationalized
    @Lob
    @Column(name = "GatewayResponse")
    private String gatewayResponse;

    @Size(max = 255)
    @Nationalized
    @Column(name = "FailureReason")
    private String failureReason;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "UpdatedAt", nullable = false)
    private Instant updatedAt;

}