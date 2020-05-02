package orgsoftuni.workshop1.web.api.modles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import orgsoftuni.workshop1.data.enums.Slot;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseModel {
    private String id;
    private String name;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;
    private Slot slot;
    boolean isOwned;
}
