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

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "InventoryTransactions", indexes = {
        @Index(name = "IX_InventoryTransactions_ProductId", columnList = "ProductId"),
        @Index(name = "IX_InventoryTransactions_TransactionType", columnList = "TransactionType"),
        @Index(name = "IX_InventoryTransactions_CreatedAt", columnList = "CreatedAt")
})
public class InventoryTransaction {
    @Id
    @Column(name = "TransactionId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "TransactionType", nullable = false, length = 50)
    private String transactionType;

    @NotNull
    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Size(max = 50)
    @Nationalized
    @Column(name = "ReferenceType", length = 50)
    private String referenceType;

    @Column(name = "ReferenceId")
    private Integer referenceId;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Notes")
    private String notes;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatedBy")
    private User createdBy;

}