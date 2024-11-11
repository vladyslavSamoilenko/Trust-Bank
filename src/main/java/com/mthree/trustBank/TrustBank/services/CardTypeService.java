package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.CardTypeDTO;
import com.mthree.trustBank.TrustBank.entities.CardType;
import com.mthree.trustBank.TrustBank.repositories.CardTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardTypeService {

    private final CardTypeRepository cardTypeRepository;

    public CardTypeService(CardTypeRepository cardTypeRepository) {
        this.cardTypeRepository = cardTypeRepository;
    }

    public List<CardTypeDTO> getAllCardTypes() {
        return cardTypeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CardTypeDTO getCardTypeById(int id) {
        CardType cardType = cardTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card type not found"));
        return convertToDTO(cardType);
    }

    public CardTypeDTO createCardType(CardTypeDTO cardTypeDTO) {
        CardType cardType = convertToEntity(cardTypeDTO);
        cardType = cardTypeRepository.save(cardType);
        return convertToDTO(cardType);
    }

    public CardTypeDTO updateCardType(int id, CardTypeDTO cardTypeDTO) {
        CardType existingCardType = cardTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card type not found"));
        existingCardType.setCardType(cardTypeDTO.getCardType());
        existingCardType = cardTypeRepository.save(existingCardType);
        return convertToDTO(existingCardType);
    }

    public void deleteCardType(int id) {
        cardTypeRepository.deleteById(id);
    }

    private CardTypeDTO convertToDTO(CardType cardType) {
        CardTypeDTO dto = new CardTypeDTO();
        dto.setCardTypeId(cardType.getCardTypeId());
        dto.setCardType(cardType.getCardType());
        return dto;
    }

    private CardType convertToEntity(CardTypeDTO dto) {
        CardType cardType = new CardType();
        cardType.setCardType(dto.getCardType());
        return cardType;
    }
}