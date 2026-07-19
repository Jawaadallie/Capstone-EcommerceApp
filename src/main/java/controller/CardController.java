package controller;

import domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CardService;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public Card create(@RequestBody Card entity) {
        return cardService.create(entity);
    }

    @GetMapping("/read/{id}")
    public Card read(@PathVariable String id) {
        return cardService.read(id);
    }

    @PostMapping("/update")
    public Card update(@RequestBody Card entity) {
        return cardService.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return cardService.delete(id);
    }

    @GetMapping("/getall")
    public List<Card> getAll() {
        return cardService.findAll();
    }
}
