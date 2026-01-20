package com.joaodev.workshop_mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaodev.workshop_mongo.models.dto.PostDTO;
import com.joaodev.workshop_mongo.services.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/posts")
@Tag(name = "Post", description = "Controlador Rest de Postagens e Buscas.")
public class PostController {

    @Autowired
    private PostService service;

    @Operation(
        summary = "Busca postagem por ID",
        description = "Retorna os detalhes de uma postagem específica através do ID hexadecimal do MongoDB.",
        responses = {
            @ApiResponse(
                description = "Sucesso", 
                responseCode = "200", 
                content = @Content(schema = @Schema(implementation = PostDTO.class))
            ),
            @ApiResponse(description = "Not Found - Postagem não encontrada", responseCode = "404", content = @Content)
        })
    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        PostDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @Operation(
        summary = "Busca simples por título",
        description = "Filtra postagens que contenham o texto informado no título.",
        responses = {
            @ApiResponse(
                description = "Sucesso", 
                responseCode = "200", 
                content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PostDTO.class)))
            )
        })
    @GetMapping(value="/titlesearch", produces = "application/json")
    public ResponseEntity<List<PostDTO>> findByTitle(
            @Parameter(description = "Texto para pesquisar no título", example = "bom dia") 
            @RequestParam(value="text", defaultValue="") String text) {
        List<PostDTO> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @Operation(
        summary = "Busca avançada com critérios múltiplos",
        description = "Realiza uma busca completa filtrando por texto (título ou corpo) e um intervalo de datas.",
        responses = {
            @ApiResponse(
                description = "Sucesso", 
                responseCode = "200", 
                content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PostDTO.class)))
            )
        })
    @GetMapping(value="/fullsearch", produces = "application/json")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @Parameter(description = "Texto para pesquisar", example = "viagem")
            @RequestParam(value="text", defaultValue="") String text,
            
            @Parameter(description = "Data mínima (formato ISO 8601)", example = "2023-01-01")
            @RequestParam(value="start", defaultValue="") String start,
            
            @Parameter(description = "Data máxima (formato ISO 8601)", example = "2023-12-31")
            @RequestParam(value="end", defaultValue="") String end) {
        List<PostDTO> list = service.fullSearch(text, start, end);
        return ResponseEntity.ok().body(list);
    }
}