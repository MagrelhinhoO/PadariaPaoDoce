package app.padariapaodoce.repository;

import app.padariapaodoce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeIgnoreCaseContaining(String nome);
    List<Produto> findByCategoriaId(Long categoriaId);
}