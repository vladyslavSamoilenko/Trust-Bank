package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.dto.CardDTO;
import com.mthree.trustBank.TrustBank.entities.Account;
import com.mthree.trustBank.TrustBank.entities.Card;
import com.mthree.trustBank.TrustBank.entities.CardType;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.repositories.AccountRepository;
import com.mthree.trustBank.TrustBank.repositories.CardRepository;
import com.mthree.trustBank.TrustBank.repositories.CardTypeRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final CardTypeRepository cardTypeRepository;

    public CardService(CardRepository cardRepository, ClientRepository clientRepository,
                       AccountRepository accountRepository, CardTypeRepository cardTypeRepository) {
        this.cardRepository = cardRepository;
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.cardTypeRepository = cardTypeRepository;
    }

    public List<CardDTO> getAllCards() {
        return cardRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CardDTO getCardById(int id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        return convertToDTO(card);
    }

    public CardDTO createCard(CardDTO cardDTO) {
        Card card = convertToEntity(cardDTO);
        card = cardRepository.save(card);
        return convertToDTO(card);
    }

    public CardDTO updateCard(int id, CardDTO cardDTO) {
        Card existingCard = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        existingCard.setCardNumber(cardDTO.getCardNumber());
        existingCard.setExpirationDate(cardDTO.getExpirationDate());
        existingCard.setCvv(cardDTO.getCvv());
        // Update other fields as necessary
        existingCard = cardRepository.save(existingCard);
        return convertToDTO(existingCard);
    }

    public void deleteCard(int id) {
        cardRepository.deleteById(id);
    }

    private CardDTO convertToDTO(Card card) {
        CardDTO dto = new CardDTO();
        dto.setCardId(card.getCardId());
        dto.setClientId(card.getClient().getClientId());
        dto.setAccountId(card.getAccount().getAccountId());
        dto.setCardTypeId(card.getCardType());
        dto.setCardNumber(card.getCardNumber());
        dto.setExpirationDate(card.getExpirationDate());
        dto.setCvv(card.getCvv());
        return dto;
    }

    private Card convertToEntity(CardDTO dto) {
        Card card = new Card();

        // Fetch the Client entity
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        card.setClient(client);

        // Fetch the Account entity by account ID
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        card.setAccount(account);

        // Set cardType directly without fetching from CardTypeRepository
        card.setCardType(dto.getCardTypeId() != 0 ? dto.getCardTypeId() : 1); // Set default to 1 if not provided

        // Set other fields
        card.setCardNumber(dto.getCardNumber());
        card.setExpirationDate(dto.getExpirationDate());
        card.setCvv(dto.getCvv());

        return card;
    }
}