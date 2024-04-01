package br.com.fiap.springpfentregas.dto.request;

public record ProdutoRequest(
        String nome,
        Float peso,
        Float Altura,
        Float largura,
        Float profundidade) {



}
