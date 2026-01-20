package com.joaodev.workshop_mongo.models.dto;

import com.joaodev.workshop_mongo.models.entities.User;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserDTO {

    @Schema(description = "ID único do usuário (Hexadecimal MongoDB)", example = "65ae8f2b1a4d5e0012345678")
    private String id;
	
    @Schema(description = "Nome completo do usuário", example = "João")
    private String name;
	
    @Schema(description = "Endereço de e-mail do usuário", example = "joao@dev.com")
    private String email;

    public UserDTO(){
    }

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
