package br.com.fiap.springpfentregas.service;

import java.util.Collection;

/**
 *
 * @param <Entity> é uma classe que tem a anotação @Entity
 * @param <Request> é um DTO de Request
 * @param <Response> é um DTO de Reponse
 */
public interface ServiceDTO <Entity, Request, Response> {
    /**
     * Este método converte um DTO de requisição para uma
     * entidade pronta para ser persistida no banco
     * @param request um DTO de request
     * @return Entitdade pronta para ser salva pela 1º vez no banco de dados
     */
    Entity toEntity(Request request);

    Response toResponse(Entity entity);

    Collection<Entity> findAll();

    Entity findById(long id);

    Entity save(Entity entity);

}
