package service;

import domain.Review;
import java.util.List;

public interface ReviewService extends IService<Review, String> {
    List<Review> findAll();
}
