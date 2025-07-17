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
@Table(name = "dbo.InventoryTransactions")
public class InventoryTransactions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TransactionId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @Column(name = "ProductId", nullable = false)
    private Integer productId;

    @Column(name = "TransactionType", nullable = false)
    private String transactionType;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "ReferenceType")
    private String referenceType;

    @Column(name = "ReferenceId")
    private Integer referenceId;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "CreatedBy")
    private Integer createdBy;

}
