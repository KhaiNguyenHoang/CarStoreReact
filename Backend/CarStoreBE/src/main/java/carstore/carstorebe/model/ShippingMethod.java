package carstore.carstorebe.model;

import jakarta.persistence.*;
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
@Table(name = "ShippingMethods")
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShippingMethodId", nullable = false)
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
    @Column(name = "Cost", nullable = false, precision = 18, scale = 2)
    private BigDecimal cost;

    @Column(name = "FreeShippingThreshold", precision = 18, scale = 2)
    private BigDecimal freeShippingThreshold;

    @NotNull
    @Column(name = "EstimatedMinDays", nullable = false)
    private Integer estimatedMinDays;

    @NotNull
    @Column(name = "EstimatedMaxDays", nullable = false)
    private Integer estimatedMaxDays;

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