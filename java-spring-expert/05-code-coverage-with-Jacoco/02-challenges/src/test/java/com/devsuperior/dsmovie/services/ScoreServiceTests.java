package com.devsuperior.dsmovie.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.MovieEntity;
import com.devsuperior.dsmovie.entities.ScoreEntity;
import com.devsuperior.dsmovie.entities.UserEntity;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dsmovie.tests.MovieFactory;
import com.devsuperior.dsmovie.tests.ScoreFactory;
import com.devsuperior.dsmovie.tests.UserFactory;

@ExtendWith(SpringExtension.class)
public class ScoreServiceTests {
	
	@InjectMocks
	private ScoreService service;

	@Mock
	private MovieRepository movieRepository;

	@Mock
	private ScoreRepository scoreRepository;

	@Mock
	private UserService userService;

	private MovieEntity movie;
	private MovieDTO movieDTO;
	private ScoreDTO scoreDTO;
	private UserEntity user;
	private ScoreEntity score;

	@BeforeEach
	void setUp() throws Exception{

		movie = MovieFactory.createMovieEntity();
		user = UserFactory.createUserEntity();
		score = ScoreFactory.createScoreEntity();
		movieDTO = MovieFactory.createMovieDTO();
		scoreDTO = ScoreFactory.createScoreDTO();
		
		Mockito.when(userService.authenticated()).thenReturn(user);

		Mockito.when(movieRepository.findById(any())).thenReturn(Optional.of(movie));

		Mockito.when(scoreRepository.saveAndFlush(any())).thenReturn(score);

		Mockito.when(movieRepository.save(any())).thenReturn(movie);

	}
	
	@Test
	public void saveScoreShouldReturnMovieDTO() {

		movie.getScores().add(score); 

		MovieDTO result = service.saveScore(scoreDTO);

		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.getId(), movie.getId());

		Mockito.verify(movieRepository, Mockito.times(1)).save(any());
	}
	
	@Test
	public void saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId() {
			
		long nonExistingId = 2L;
		
		scoreDTO = new ScoreDTO(nonExistingId, 4.5); 
		
		Mockito.when(movieRepository.findById(nonExistingId)).thenReturn(Optional.empty());

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.saveScore(scoreDTO);
		});
	}
}
