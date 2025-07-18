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
@Table(name = "Vouchers", indexes = {
        @Index(name = "IX_Vouchers_VoucherCode", columnList = "VoucherCode"),
        @Index(name = "IX_Vouchers_Status", columnList = "Status"),
        @Index(name = "IX_Vouchers_StartDate_EndDate", columnList = "StartDate, EndDate")
}, uniqueConstraints = {
        @UniqueConstraint(name = "UQ__Vouchers__7F0ABCA93A80A629", columnNames = {"VoucherCode"})
})
public class Voucher {
    @Id
    @Column(name = "VoucherId", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "VoucherCode", nullable = false, length = 50)
    private String voucherCode;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "Title", nullable = false, length = 100)
    private String title;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Description")
    private String description;

    @NotNull
    @Column(name = "DiscountValue", nullable = false, precision = 18, scale = 2)
    private BigDecimal discountValue;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "DiscountType", nullable = false, length = 50)
    private String discountType;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "MinOrderValue", nullable = false, precision = 18, scale = 2)
    private BigDecimal minOrderValue;

    @Column(name = "MaxDiscountValue", precision = 18, scale = 2)
    private BigDecimal maxDiscountValue;

    @Column(name = "UsageLimit")
    private Integer usageLimit;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "UsedCount", nullable = false)
    private Integer usedCount;

    @ColumnDefault("1")
    @Column(name = "UserUsageLimit")
    private Integer userUsageLimit;

    @NotNull
    @Column(name = "StartDate", nullable = false)
    private Instant startDate;

    @NotNull
    @Column(name = "EndDate", nullable = false)
    private Instant endDate;

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