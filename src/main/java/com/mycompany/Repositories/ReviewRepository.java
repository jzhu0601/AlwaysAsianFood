package com.mycompany.Repositories;

import com.mycompany.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mantou on 11/21/2015.
 */

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}