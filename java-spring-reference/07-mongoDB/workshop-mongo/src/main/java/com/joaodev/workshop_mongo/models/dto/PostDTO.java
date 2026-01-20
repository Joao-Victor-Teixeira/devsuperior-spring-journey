package com.joaodev.workshop_mongo.models.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.joaodev.workshop_mongo.models.entities.Post;
import com.joaodev.workshop_mongo.models.entities.embedded.Author;
import com.joaodev.workshop_mongo.models.entities.embedded.Comment;

import io.swagger.v3.oas.annotations.media.Schema;

public class PostDTO {

    @Schema(description = "ID único da postagem", example = "65bf12345a4d5e0012345679")
    private String id;
	
    @Schema(description = "Data da publicação (ISO 8601)", example = "2024-05-20T14:30:00Z")
    private Instant moment;
	
    @Schema(description = "Título da postagem", example = "Partiu viagem!")
    private String title;
	
    @Schema(description = "Conteúdo/Corpo da postagem", example = "Hoje comecei meu novo projeto usando Spring Batch...")
    private String body;
	
    @Schema(description = "Autor da postagem (Dados simplificados)")
    private Author author;

    @Schema(description = "Lista de comentários da postagem")
    private List<Comment> comments = new ArrayList<>();

    public PostDTO(){
    }

    public PostDTO(String id, Instant moment, String title, String body, Author author) {
        this.id = id;
        this.moment = moment;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public PostDTO(Post entity) {
        id = entity.getId();
        moment = entity.getMoment();
        title = entity.getTitle();
        body = entity.getBody();
        author = entity.getAuthor();
        comments.addAll(entity.getComments());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
