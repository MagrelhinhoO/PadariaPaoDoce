package app.padariapaodoce.service;

import app.padariapaodoce.entity.Venda;
import app.padariapaodoce.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvar(Venda venda) {
        if (venda.getFormaPagamento() == null) {
            throw new RuntimeException("Não é possível cadastrar venda sem forma de pagamento");
        }

        if (venda.getValorTotal() == null) {
            venda.setValorTotal(0.0); // regra que modifica o objeto
        }

        return vendaRepository.save(venda);
    }

    public List<Venda> listar() {
        return vendaRepository.findAll();
    }

    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada com id " + id));
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    public Double lucroDia(LocalDate data) {
        return vendaRepository.totalVendasPorDia(data);
    }

    public Double lucroMes(LocalDate inicio, LocalDate fim) {
        return vendaRepository.totalVendasPorPeriodo(inicio, fim);
    }
}