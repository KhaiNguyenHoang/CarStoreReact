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
@Table(name = "dbo.Vouchers")
public class Vouchers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "VoucherId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer voucherId;

    @Column(name = "VoucherCode", nullable = false)
    private String voucherCode;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "DiscountValue", nullable = false)
    private BigDecimal discountValue;

    @Column(name = "DiscountType", nullable = false)
    private String discountType;

    @Column(name = "MinOrderValue", nullable = false)
    private BigDecimal minOrderValue = BigDecimal.ZERO;

    @Column(name = "MaxDiscountValue")
    private BigDecimal maxDiscountValue;

    @Column(name = "UsageLimit")
    private Integer usageLimit;

    @Column(name = "UsedCount", nullable = false)
    private Integer usedCount = 0;

    @Column(name = "UserUsageLimit")
    private Integer userUsageLimit = 1;

    @Column(name = "StartDate", nullable = false)
    private Date startDate;

    @Column(name = "EndDate", nullable = false)
    private Date endDate;

    @Column(name = "Status", nullable = false)
    private String status = "Active";

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

}
