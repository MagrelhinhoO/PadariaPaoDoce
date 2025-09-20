package app.padariapaodoce.repository;

import app.padariapaodoce.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByData(LocalDate data);
    List<Venda> findByDataBetween(LocalDate inicio, LocalDate fim);

    @Query("SELECT SUM(v.valorTotal) FROM Venda v WHERE v.data = :data")
    Double totalVendasPorDia(LocalDate data);

    @Query("SELECT SUM(v.valorTotal) FROM Venda v WHERE v.data BETWEEN :inicio AND :fim")
    Double totalVendasPorPeriodo(LocalDate inicio, LocalDate fim);
}