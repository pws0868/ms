package study.ms.domain.reservation;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx=0;

    @Basic
    @Column(name = "shop_idx", columnDefinition = "shopIdx")
    private Integer shopIdx=0;

    @Basic
    @Column(name = "member_idx", columnDefinition = "memberIdx")
    private Integer memberIdx=0;

    @Basic
    @Column(name = "create_datetime", columnDefinition = "DATETIME")
    private LocalDateTime createDatetime = LocalDateTime.now();

    @Basic
    @Column(name = "status", columnDefinition = "status")
    private String status= "";

//    @PrePersist
//    public void prePersist() {
//        if (createDatetime != null) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            String formattedDatetime = createDatetime.format(formatter);
//            createDatetime = LocalDateTime.parse(formattedDatetime, formatter);
//        }
//    }
}
