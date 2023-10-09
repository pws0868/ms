package study.ms.domain.review;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "review")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idx")
    private int idx;

    @Basic
    @Column(name = "shop_idx")
    private int shopIdx;

    @Basic
    @Column(name = "member_idx")
    private int memberIdx;

    @Basic
    @Column(name = "contents")
    private String contents;
}
