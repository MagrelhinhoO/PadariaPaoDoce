package app.padariapaodoce.controller;

import app.padariapaodoce.entity.FormaPagamento;
import app.padariapaodoce.service.FormaPagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @PostMapping
    public FormaPagamento salvar(@RequestBody @Valid FormaPagamento formaPagamento) {
        return formaPagamentoService.salvar(formaPagamento);
    }

    @GetMapping
    public List<FormaPagamento> listar() {
        return formaPagamentoService.listar();
    }

    @GetMapping("/{id}")
    public FormaPagamento buscarPorId(@PathVariable Long id) {
        return formaPagamentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        formaPagamentoService.deletar(id);
    }
}