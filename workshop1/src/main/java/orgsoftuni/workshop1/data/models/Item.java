package orgsoftuni.workshop1.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import orgsoftuni.workshop1.data.enums.Slot;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@NoArgsConstructor
@Getter
@Setter
public class Item extends BaseEntity {
    private String name;
    @Enumerated(EnumType.STRING)
    private Slot slot;
    private Integer stamina;
    private Integer strength;
    private Integer attack;
    private Integer defence;

    @ManyToMany
    @JoinTable(name = "heroes_items",
            joinColumns = @JoinColumn(name="hero_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="item_id", referencedColumnName = "id"))
    private List<Hero> hero;
}
