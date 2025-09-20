package app.padariapaodoce.repository;

import app.padariapaodoce.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNomeIgnoreCase(String nome);
}