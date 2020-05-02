package orgsoftuni.workshop1.web.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import orgsoftuni.workshop1.web.api.modles.ItemResponseModel;
import orgsoftuni.workshop1.web.view.models.HeroItemViewModel;

import java.util.List;

@RestController
public class ItemsApiController {
    @GetMapping("/api/items")
    public List<ItemResponseModel> getItems() {
    return List.of(
            new ItemResponseModel() {{
                setId("23132");
                setAttack(1);
                setDefence(2);
                setOwned(true);
            }},
            new ItemResponseModel() {{
                setId("123");
                setAttack(1);
                setDefence(22);
                setOwned(false);
            }}
    );
    }
}
