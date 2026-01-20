package com.joaodev.workshop_mongo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaodev.workshop_mongo.models.dto.PostDTO;
import com.joaodev.workshop_mongo.models.dto.UserDTO;
import com.joaodev.workshop_mongo.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/users")
@Tag(name = "User", description = "Controlador Rest de Usuários.")
public class UserController {

	@Autowired
	private UserService service;
	
    @Operation(
        summary = "Retorna uma lista de usuários",
        description = "Retorna um JSON com todos os usuários cadastrados no banco, com id, nome e email.",
        responses = {
            @ApiResponse(
                description = "Sucesso",
                responseCode = "200",
                content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
            ),
            @ApiResponse(description = "Erro interno no servidor", responseCode = "500", content = @Content)
        })
	@GetMapping(produces = "application/json")
 	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

    @Operation(
        summary = "Retorna o usuário por id",
        description = "Retorna um JSON com um único usuario correspondente ao id passado na requisição",
        responses = {
            @ApiResponse(
                description = "Sucesso",
                responseCode = "200",
                content = @Content(schema = @Schema(implementation = UserDTO.class))
            ),
            @ApiResponse(description = "Not Found - Erro no id da requisição(inexistente)", responseCode = "404", content = @Content)
        })
    @GetMapping(value="/{id}", produces = "application/json")
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                  .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value="/{id}/posts")
 	public ResponseEntity<List<PostDTO>> getUSerPosts(@PathVariable String id) {
		List<PostDTO> list = service.getUSerPosts(id);
		return ResponseEntity.ok().body(list);
	}
}