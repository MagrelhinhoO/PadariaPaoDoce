package app.padariapaodoce.service;

import app.padariapaodoce.entity.Despesa;
import app.padariapaodoce.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa salvar(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public List<Despesa> listar() {
        return despesaRepository.findAll();
    }

    public Despesa buscarPorId(Long id) {
        return despesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada com id " + id));
    }

    public void deletar(Long id) {
        despesaRepository.deleteById(id);
    }

    public Double totalDespesasDia(LocalDate data) {
        return despesaRepository.totalDespesasPorDia(data);
    }

    public Double totalDespesasMes(LocalDate inicio, LocalDate fim) {
        return despesaRepository.totalDespesasPorPeriodo(inicio, fim);
    }
}