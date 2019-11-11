package com.proyecto.ripepotatoes.testing;

import com.proyecto.ripepotatoes.domain.Rating;
import com.proyecto.ripepotatoes.repository.RatingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingTest {

    @Autowired
    RatingRepository ratingRepository;

    @Test
    public void save() {
        Rating rating = new Rating();
        rating.setIdPeliApi(15);
        rating.setIdUsuario(2);
        rating.setRating_value(3);
        ratingRepository.save(rating);
        Rating rate = ratingRepository.findByIdPeliApiAndIdUsuario(15,2);
        assertThat(rate).isNotNull();
        ratingRepository.delete(rate);
    }

    @Test
    public void isAlreadyVoted() {
        Rating rating = new Rating();
        rating.setIdPeliApi(15);
        rating.setIdUsuario(2);
        rating.setRating_value(3);
        ratingRepository.save(rating);
        Boolean isVoted = false;
        Rating rate = ratingRepository.findByIdPeliApiAndIdUsuario(15,2);
        if(rate != null){
            isVoted = true;
        }
        assertThat(isVoted).isTrue();
        ratingRepository.delete(rate);
    }
}
