package service.impl;

import domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CardRepository;
import service.CardService;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    @Autowired
    public CardServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Card create(Card entity) {
        return repository.create(entity);
    }

    @Override
    public Card read(String id) {
        return repository.read(id);
    }

    @Override
    public Card update(Card entity) {
        return repository.update(entity);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }
}
