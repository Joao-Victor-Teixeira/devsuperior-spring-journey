package com.joaodev.crud_clients.dto;

import java.time.LocalDate;

import com.joaodev.crud_clients.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class ClientDTO {

    private Long id;
    
    @NotBlank(message = "Campo requerido")
    private String name;
    
    @NotBlank(message = "Campo requerido")
    private String cpf;
    
    @PositiveOrZero(message = "A renda deve ser positiva ou zero")
    private Double income;
    
    @PastOrPresent(message = "Data de nascimento não pode ser futura")
    private LocalDate birthDate;
    
    @PositiveOrZero(message = "O campo não pode ser negativo")
    private Integer children;

    public ClientDTO(){
        
    }

   public ClientDTO(Client client) {
    this.id = client.getId();
    this.name = client.getName();
    this.cpf = client.getCpf();
    this.income = client.getIncome();
    this.birthDate = client.getBirthDate();
    this.children = client.getChildren();
    }

 

   

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

}

