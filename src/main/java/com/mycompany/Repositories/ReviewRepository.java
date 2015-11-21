package com.mycompany.Repositories;

import com.mycompany.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mantou on 11/21/2015.
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}