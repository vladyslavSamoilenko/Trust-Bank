package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.dto.CardDTO;
import com.mthree.trustBank.TrustBank.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<CardDTO> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public CardDTO getCardById(@PathVariable int id) {
        return cardService.getCardById(id);
    }

    @PostMapping
    public CardDTO createCard(@RequestBody CardDTO cardDTO) {
        return cardService.createCard(cardDTO);
    }

    @PutMapping("/{id}")
    public CardDTO updateCard(@PathVariable int id, @RequestBody CardDTO cardDTO) {
        return cardService.updateCard(id, cardDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable int id) {
        cardService.deleteCard(id);
    }
}
