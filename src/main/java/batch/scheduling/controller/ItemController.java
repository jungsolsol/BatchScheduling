package batch.scheduling.controller;

import batch.scheduling.data.dto.ItemListRes;
import batch.scheduling.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ItemController {


    private final ItemService itemService;

    @GetMapping
    public List<ItemListRes> getAllItem(@RequestParam String item) {
        return itemService.getAllItem(item);
    }
}
