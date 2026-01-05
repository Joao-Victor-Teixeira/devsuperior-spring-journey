package com.devsuperior.bds04.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import com.devsuperior.bds04.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private CityRepository cityRepository;


    @Transactional(readOnly = true)
    public List<EventDTO> findAll(){
        List<Event> result = repository.findAll(Sort.by("name"));
        return result.stream().map(x -> new EventDTO(x)).toList();
    }


    @Transactional
    public EventDTO insert(EventDTO dto){

        Event entity = new Event();
        copyDtoToEntity(dto, entity);

        entity = repository.save(entity);
        return new EventDTO(entity);
    }

    @Transactional
    public EventDTO update(Long id,EventDTO dto){
       try {
        Event entity = repository.getReferenceById(id);
        
        copyDtoToEntity(dto, entity);

        entity = repository.save(entity);
        return new EventDTO(entity);
        
       } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException("Recurso não encontrado");
       }
    }

    private void copyDtoToEntity(EventDTO dto, Event entity){
        

        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        
        City city = cityRepository.getReferenceById(dto.getCityId());
        entity.setCity(city);
    }
}
