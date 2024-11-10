package com.mthree.trustBank.TrustBank.services;

import com.mthree.trustBank.TrustBank.entities.Card;
import com.mthree.trustBank.TrustBank.entities.Client;
import com.mthree.trustBank.TrustBank.repositories.CardRepository;
import com.mthree.trustBank.TrustBank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public CardService(CardRepository cardRepository, ClientRepository clientRepository) {
        this.cardRepository = cardRepository;
        this.clientRepository = clientRepository;
    }

    // Получить все карты
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Найти карту по ID
    public Card getCardById(int id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Карта с ID " + id + " не найдена"));
    }

    // Создать новую карту для клиента
    public Card createCard(int clientId, Card card) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Клиент с ID " + clientId + " не найден"));
        card.setClient(client);
        return cardRepository.save(card);
    }

    // Удалить карту
    public void deleteCard(int id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Карта с ID " + id + " не найдена"));
        cardRepository.delete(card);
    }
}
