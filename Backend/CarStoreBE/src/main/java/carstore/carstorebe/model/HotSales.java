package carstore.carstorebe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "dbo.HotSales")
public class HotSales implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "HotSaleId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotSaleId;

    @Column(name = "ProductId", nullable = false)
    private Integer productId;

    @Column(name = "StartDate", nullable = false)
    private Date startDate;

    @Column(name = "EndDate", nullable = false)
    private Date endDate;

    @Column(name = "Priority", nullable = false)
    private Integer priority = 1;

    @Column(name = "Status", nullable = false)
    private String status = "Active";

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

}
