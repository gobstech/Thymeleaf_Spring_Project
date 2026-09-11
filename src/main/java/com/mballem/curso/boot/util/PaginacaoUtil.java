package com.mballem.curso.boot.util;

import java.util.List;

public class PaginacaoUtil<T> {

    private int tamanho;
    private int pagina;
    private Long totalDePaginas;
    private String direcao;
    private String coluna;
    private List<T> registros;

    public PaginacaoUtil(int tamanho, int pagina, Long totalDePaginas, String coluna, String direcao, List<T> registros) {
        this.tamanho = tamanho;
        this.pagina = pagina;
        this.totalDePaginas = totalDePaginas;
        this.coluna = coluna;
        this.direcao = direcao;
        this.registros = registros;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPagina() {
        return pagina;
    }

    public Long getTotalDePaginas() {
        return totalDePaginas;
    }

    public List<T> getRegistros() {
        return registros;
    }

    public String getDirecao() {
        return direcao;
    }

    public String getColuna() {
        return coluna;
    }
}
