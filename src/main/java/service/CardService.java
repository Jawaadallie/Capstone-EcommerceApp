package service;

import domain.Card;
import java.util.List;

public interface CardService extends IService<Card, String> {
    List<Card> findAll();
}
