package carstore.carstorebe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "PaymentMethods")
public class PaymentMethod {
    @Id
    @Column(name = "PaymentMethodId", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "MethodName", nullable = false, length = 100)
    private String methodName;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Description")
    private String description;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "ProcessingFee", nullable = false, precision = 18, scale = 2)
    private BigDecimal processingFee;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "IsOnline", nullable = false)
    private Boolean isOnline = false;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("'Active'")
    @Column(name = "Status", nullable = false, length = 50)
    private String status;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

}