package com.mthree.trustBank.TrustBank.controllers;
import com.mthree.trustBank.TrustBank.dto.CardTypeDTO;
import com.mthree.trustBank.TrustBank.services.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cardTypes")
public class CardTypeController {

    @Autowired
    private CardTypeService cardTypeService;

    @GetMapping
    public List<CardTypeDTO> getAllCardTypes() {
        return cardTypeService.getAllCardTypes();
    }

    @GetMapping("/{id}")
    public CardTypeDTO getCardTypeById(@PathVariable int id) {
        return cardTypeService.getCardTypeById(id);
    }

    @PostMapping
    public CardTypeDTO createCardType(@RequestBody CardTypeDTO cardTypeDTO) {
        return cardTypeService.createCardType(cardTypeDTO);
    }

    @PutMapping("/{id}")
    public CardTypeDTO updateCardType(@PathVariable int id, @RequestBody CardTypeDTO cardTypeDTO) {
        return cardTypeService.updateCardType(id, cardTypeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCardType(@PathVariable int id) {
        cardTypeService.deleteCardType(id);
    }
}