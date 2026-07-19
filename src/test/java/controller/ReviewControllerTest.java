package controller;

import domain.Review;
import factory.ReviewFactory;
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
import service.ReviewService;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ReviewController.class, useDefaultFilters = false)
@ContextConfiguration(classes = {ReviewController.class, ReviewControllerTest.MockServiceConfig.class})
public class ReviewControllerTest {

    @Configuration
    public static class MockServiceConfig {
        @Bean
        public ReviewService reviewService() {
            return org.mockito.Mockito.mock(ReviewService.class);
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReviewService reviewService;

    @Test
    public void testCreate() throws Exception {
        Review entity = ReviewFactory.createReview("REV-101","CUST-101","PROD-101",5,"Great product!","2026-07-19");
        when(reviewService.create(any(Review.class))).thenReturn(entity);
        String json = "{\"reviewId\":\"REV-101\",\"customerId\":\"CUST-101\",\"productId\":\"PROD-101\",\"rating\":5,\"comment\":\"Great product!\",\"reviewDate\":\"2026-07-19\"}";
        mockMvc.perform(post("/review/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reviewId").value(entity.getReviewId()));
    }

    @Test
    public void testRead() throws Exception {
        Review entity = ReviewFactory.createReview("REV-101","CUST-101","PROD-101",5,"Great product!","2026-07-19");
        when(reviewService.read(entity.getReviewId())).thenReturn(entity);
        mockMvc.perform(get("/review/read/" + entity.getReviewId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reviewId").value(entity.getReviewId()));
    }

    @Test
    public void testUpdate() throws Exception {
        Review entity = ReviewFactory.createReview("REV-101","CUST-101","PROD-101",5,"Great product!","2026-07-19");
        when(reviewService.update(any(Review.class))).thenReturn(entity);
        String json = "{\"reviewId\":\"REV-101\",\"customerId\":\"CUST-101\",\"productId\":\"PROD-101\",\"rating\":5,\"comment\":\"Great product!\",\"reviewDate\":\"2026-07-19\"}";
        mockMvc.perform(post("/review/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reviewId").value(entity.getReviewId()));
    }

    @Test
    public void testDelete() throws Exception {
        Review entity = ReviewFactory.createReview("REV-101","CUST-101","PROD-101",5,"Great product!","2026-07-19");
        when(reviewService.delete(entity.getReviewId())).thenReturn(true);
        mockMvc.perform(delete("/review/delete/" + entity.getReviewId()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testGetAll() throws Exception {
        Review entity = ReviewFactory.createReview("REV-101","CUST-101","PROD-101",5,"Great product!","2026-07-19");
        when(reviewService.findAll()).thenReturn(Arrays.asList(entity));
        mockMvc.perform(get("/review/getall"))
                .andExpect(status().isOk());
    }
}
