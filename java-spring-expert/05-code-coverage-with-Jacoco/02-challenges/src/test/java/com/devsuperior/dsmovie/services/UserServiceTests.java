package com.devsuperior.dsmovie.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.dsmovie.entities.UserEntity;
import com.devsuperior.dsmovie.repositories.UserRepository;
import com.devsuperior.dsmovie.tests.UserDetailsFactory;
import com.devsuperior.dsmovie.tests.UserFactory;
import com.devsuperior.dsmovie.utils.CustomUserUtil;

@ExtendWith(SpringExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Mock
    private CustomUserUtil userUtil;

    private String existingUsername, nonExistingUsername;
    private UserEntity user;

    @BeforeEach
    void setUp() throws Exception {
        existingUsername = "maria@gmail.com";
        nonExistingUsername = "user@notfound.com";
        user = UserFactory.createUserEntity();


        Mockito.when(userUtil.getLoggedUsername()).thenReturn(existingUsername);
        Mockito.when(repository.findByUsername(existingUsername)).thenReturn(Optional.of(user));

        Mockito.when(repository.searchUserAndRolesByUsername(existingUsername)).thenReturn(UserDetailsFactory.createCustomAdminClientUser(existingUsername));
        Mockito.when(repository.searchUserAndRolesByUsername(nonExistingUsername)).thenReturn(java.util.Collections.emptyList());
    }

    @Test
    public void authenticatedShouldReturnUserEntityWhenUserExists() {
        UserEntity result = service.authenticated();
        
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getUsername(), existingUsername);
    }

    @Test
    public void authenticatedShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists() {
       
        Mockito.when(userUtil.getLoggedUsername()).thenReturn(nonExistingUsername);
        Mockito.when(repository.findByUsername(nonExistingUsername)).thenReturn(Optional.empty());

        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.authenticated();
        });
    }

    @Test
    public void loadUserByUsernameShouldReturnUserDetailsWhenUserExists() {
        UserDetails result = service.loadUserByUsername(existingUsername);
        
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getUsername(), existingUsername);
    }

    @Test
    public void loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists() {
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.loadUserByUsername(nonExistingUsername);
        });
    }
}