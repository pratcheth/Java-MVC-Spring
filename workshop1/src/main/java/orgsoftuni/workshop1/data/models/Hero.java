package orgsoftuni.workshop1.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import orgsoftuni.workshop1.data.enums.Gender;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "heroes")
@NoArgsConstructor
@Getter
@Setter
public class Hero extends BaseEntity {
    private String username;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "level", columnDefinition = "int default 1")
    private Integer level;
    @Column(name = "stamina", columnDefinition = "int default 0")
    private Integer stamina;
    @Column(name = "strength", columnDefinition = "int default 0")
    private Integer strength;
    @Column(name = "attack", columnDefinition = "int default 0")
    private Integer attack;
    @Column(name = "defence", columnDefinition = "int default 0")
    private Integer defence;

    @ManyToMany(mappedBy = "hero")
    @Column(name = "inventory")
    private List<Item> inventory;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
