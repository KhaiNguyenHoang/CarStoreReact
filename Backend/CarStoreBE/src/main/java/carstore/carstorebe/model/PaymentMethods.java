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
@Table(name = "dbo.PaymentMethods")
public class PaymentMethods implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentMethodId", nullable = false)
    private Integer paymentMethodId;

    @Column(name = "MethodName", nullable = false)
    private String methodName;

    @Column(name = "Description")
    private String description;

    @Column(name = "ProcessingFee", nullable = false)
    private BigDecimal processingFee = BigDecimal.ZERO;

    @Column(name = "IsOnline", nullable = false)
    private Boolean isOnline = Boolean.TRUE;

    @Column(name = "Status", nullable = false)
    private String status = "Active";

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

}
