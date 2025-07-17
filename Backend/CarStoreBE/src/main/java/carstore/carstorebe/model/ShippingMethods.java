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
@Table(name = "dbo.ShippingMethods")
public class ShippingMethods implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShippingMethodId", nullable = false)
    private Integer shippingMethodId;

    @Column(name = "MethodName", nullable = false)
    private String methodName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Cost", nullable = false)
    private BigDecimal cost;

    @Column(name = "FreeShippingThreshold")
    private BigDecimal freeShippingThreshold;

    @Column(name = "EstimatedMinDays", nullable = false)
    private Integer estimatedMinDays;

    @Column(name = "EstimatedMaxDays", nullable = false)
    private Integer estimatedMaxDays;

    @Column(name = "Status", nullable = false)
    private String status = "Active";

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

}
