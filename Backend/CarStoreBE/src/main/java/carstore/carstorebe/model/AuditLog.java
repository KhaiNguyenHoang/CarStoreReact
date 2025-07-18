package carstore.carstorebe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "AuditLog", indexes = {
        @Index(name = "IX_AuditLog_TableName", columnList = "TableName"),
        @Index(name = "IX_AuditLog_RecordId", columnList = "RecordId"),
        @Index(name = "IX_AuditLog_UserId", columnList = "UserId"),
        @Index(name = "IX_AuditLog_CreatedAt", columnList = "CreatedAt")
})
public class AuditLog {
    @Id
    @Column(name = "LogId", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "TableName", nullable = false, length = 100)
    private String tableName;

    @NotNull
    @Column(name = "RecordId", nullable = false)
    private Integer recordId;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "\"Action\"", nullable = false, length = 50)
    private String action;

    @Nationalized
    @Lob
    @Column(name = "OldValues")
    private String oldValues;

    @Nationalized
    @Lob
    @Column(name = "NewValues")
    private String newValues;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    @Size(max = 45)
    @Nationalized
    @Column(name = "UserIP", length = 45)
    private String userIP;

    @Size(max = 500)
    @Nationalized
    @Column(name = "UserAgent", length = 500)
    private String userAgent;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

}