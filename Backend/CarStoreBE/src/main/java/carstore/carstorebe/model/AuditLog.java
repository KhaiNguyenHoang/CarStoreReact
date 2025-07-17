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
@Table(name = "dbo.AuditLog")
public class AuditLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "LogId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    @Column(name = "TableName", nullable = false)
    private String tableName;

    @Column(name = "RecordId", nullable = false)
    private Integer recordId;

    @Column(name = "Action", nullable = false)
    private String action;

    @Column(name = "OldValues")
    private String oldValues;

    @Column(name = "NewValues")
    private String newValues;

    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "UserIP")
    private String userIP;

    @Column(name = "UserAgent")
    private String userAgent;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

}
