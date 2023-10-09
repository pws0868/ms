package study.ms.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member")
public class Member
{
    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx = 0;

    @Column(name="id", unique = true)
    private String id = "";

    @Column(name="name")
    private String name = "";

    @Column(name="password")
    private String password = "";

    @Column(name="type")
    private String type = "";

    public boolean isEmpty() {
        return idx <= 0;
    }
}
