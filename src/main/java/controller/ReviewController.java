package controller;

import domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public Review create(@RequestBody Review entity) {
        return reviewService.create(entity);
    }

    @GetMapping("/read/{id}")
    public Review read(@PathVariable String id) {
        return reviewService.read(id);
    }

    @PostMapping("/update")
    public Review update(@RequestBody Review entity) {
        return reviewService.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return reviewService.delete(id);
    }

    @GetMapping("/getall")
    public List<Review> getAll() {
        return reviewService.findAll();
    }
}
