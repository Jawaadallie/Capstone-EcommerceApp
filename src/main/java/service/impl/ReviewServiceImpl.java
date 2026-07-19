package service.impl;

import domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReviewRepository;
import service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Review create(Review entity) {
        return repository.create(entity);
    }

    @Override
    public Review read(String id) {
        return repository.read(id);
    }

    @Override
    public Review update(Review entity) {
        return repository.update(entity);
    }

    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }

    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }
}
