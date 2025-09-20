package app.padariapaodoce.repository;

import app.padariapaodoce.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findByData(LocalDate data);
    List<Despesa> findByDataBetween(LocalDate inicio, LocalDate fim);

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.data = :data")
    Double totalDespesasPorDia(LocalDate data);

    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.data BETWEEN :inicio AND :fim")
    Double totalDespesasPorPeriodo(LocalDate inicio, LocalDate fim);
}
