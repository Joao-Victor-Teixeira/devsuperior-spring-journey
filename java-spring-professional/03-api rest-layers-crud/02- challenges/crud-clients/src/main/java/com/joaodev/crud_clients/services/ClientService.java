package com.joaodev.crud_clients.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaodev.crud_clients.dto.ClientDTO;
import com.joaodev.crud_clients.entities.Client;
import com.joaodev.crud_clients.repositories.ClientRepository;
import com.joaodev.crud_clients.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).orElseThrow( 
        () -> new ResourceNotFoundException("Recurso não encontrado"));
            return new ClientDTO(client);
    }

    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }
}
