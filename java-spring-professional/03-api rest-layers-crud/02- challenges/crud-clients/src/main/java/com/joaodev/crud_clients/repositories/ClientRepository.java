package com.joaodev.crud_clients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaodev.crud_clients.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
