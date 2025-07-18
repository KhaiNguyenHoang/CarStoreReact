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
@Table(name = "ProductReviews", indexes = {
        @Index(name = "IX_ProductReviews_ProductId", columnList = "ProductId"),
        @Index(name = "IX_ProductReviews_UserId", columnList = "UserId"),
        @Index(name = "IX_ProductReviews_Rating", columnList = "Rating"),
        @Index(name = "IX_ProductReviews_Status", columnList = "Status")
})
public class ProductReview {
    @Id
    @Column(name = "ReviewId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @NotNull
    @Column(name = "Rating", nullable = false)
    private Integer rating;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Title", length = 100)
    private String title;

    @Nationalized
    @Lob
    @Column(name = "Comment")
    private String comment;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IsVerifiedPurchase", nullable = false)
    private Boolean isVerifiedPurchase = false;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "HelpfulCount", nullable = false)
    private Integer helpfulCount;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("'Pending'")
    @Column(name = "Status", nullable = false, length = 50)
    private String status;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "UpdatedAt", nullable = false)
    private Instant updatedAt;

}