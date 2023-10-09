package study.ms.domain.shop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "shop")
public class Shop
{
    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx = 0;

    @Column(name="member_idx")
    private Integer memberIdx = 0;

    @Column(name="name", unique = true)
    private String name = "";

    @Column(name="location")
    private String location = "";

    @Column(name="description")
    private String description = "";

}
