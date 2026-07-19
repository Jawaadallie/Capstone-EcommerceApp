package controller;

import domain.Card;
import factory.CardFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import service.CardService;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CardController.class, useDefaultFilters = false)
@ContextConfiguration(classes = {CardController.class, CardControllerTest.MockServiceConfig.class})
public class CardControllerTest {

    @Configuration
    public static class MockServiceConfig {
        @Bean
        public CardService cardService() {
            return org.mockito.Mockito.mock(CardService.class);
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CardService cardService;

    @Test
    public void testCreate() throws Exception {
        Card entity = CardFactory.createCard("CARD-101","John Doe","Visa","1234567812345678","12/28","123");
        when(cardService.create(any(Card.class))).thenReturn(entity);
        String json = "{\"cardId\":\"CARD-101\",\"cardHolderName\":\"John Doe\",\"cardType\":\"Visa\",\"cardNumber\":\"1234567812345678\",\"cardExpiry\":\"12/28\",\"cardCVV\":\"123\"}";
        mockMvc.perform(post("/card/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cardId").value(entity.getCardId()));
    }

    @Test
    public void testRead() throws Exception {
        Card entity = CardFactory.createCard("CARD-101","John Doe","Visa","1234567812345678","12/28","123");
        when(cardService.read(entity.getCardId())).thenReturn(entity);
        mockMvc.perform(get("/card/read/" + entity.getCardId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cardId").value(entity.getCardId()));
    }

    @Test
    public void testUpdate() throws Exception {
        Card entity = CardFactory.createCard("CARD-101","John Doe","Visa","1234567812345678","12/28","123");
        when(cardService.update(any(Card.class))).thenReturn(entity);
        String json = "{\"cardId\":\"CARD-101\",\"cardHolderName\":\"John Doe\",\"cardType\":\"Visa\",\"cardNumber\":\"1234567812345678\",\"cardExpiry\":\"12/28\",\"cardCVV\":\"123\"}";
        mockMvc.perform(post("/card/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cardId").value(entity.getCardId()));
    }

    @Test
    public void testDelete() throws Exception {
        Card entity = CardFactory.createCard("CARD-101","John Doe","Visa","1234567812345678","12/28","123");
        when(cardService.delete(entity.getCardId())).thenReturn(true);
        mockMvc.perform(delete("/card/delete/" + entity.getCardId()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testGetAll() throws Exception {
        Card entity = CardFactory.createCard("CARD-101","John Doe","Visa","1234567812345678","12/28","123");
        when(cardService.findAll()).thenReturn(Arrays.asList(entity));
        mockMvc.perform(get("/card/getall"))
                .andExpect(status().isOk());
    }
}
