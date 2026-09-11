package com.mballem.curso.boot.dao;

import com.mballem.curso.boot.domain.Cargo;
import com.mballem.curso.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

    public PaginacaoUtil<Cargo> buscaPaginada(int pagina, String coluna, String direcao, Integer tamanho) {
        int qtdElementos = tamanho;
        int inicio = (pagina - 1) * qtdElementos; // 0*5=0, (2-1)*5=5, (3-1)*5=10
        List<Cargo> cargos = getEntityManager()
                .createQuery(" select c from Cargo c order by " + coluna + " " + direcao, Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(qtdElementos)
                .getResultList();

        Long totalRegistros = count();
        Long totalDePaginas = (totalRegistros+(qtdElementos-1))/qtdElementos;

        return new PaginacaoUtil<>(qtdElementos, pagina, totalDePaginas, coluna, direcao, cargos);
    }

    public Long count() {
        return getEntityManager()
                .createQuery("select count (*) from Cargo", Long.class)
                .getSingleResult();
    }
}
