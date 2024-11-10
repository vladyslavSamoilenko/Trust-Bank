package com.mthree.trustBank.TrustBank.controllers;

import com.mthree.trustBank.TrustBank.entities.Card;
import com.mthree.trustBank.TrustBank.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // Получить все карты
    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
    }

    // Получить карту по ID
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable int id) {
        return new ResponseEntity<>(cardService.getCardById(id), HttpStatus.OK);
    }

    // Создать новую карту для клиента
    @PostMapping("/client/{clientId}")
    public ResponseEntity<Card> createCardForClient(@PathVariable int clientId, @RequestBody Card card) {
        return new ResponseEntity<>(cardService.createCard(clientId, card), HttpStatus.CREATED);
    }

    // Удалить карту
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable int id) {
        cardService.deleteCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}