package app.padariapaodoce.controller;

import app.padariapaodoce.service.DespesaService;
import app.padariapaodoce.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private DespesaService despesaService;

    @GetMapping("/lucros-dia")
    public Map<String, Double> lucroDia(@RequestParam("data") String dataStr) {
        LocalDate data = LocalDate.parse(dataStr);
        Double entradas = vendaService.lucroDia(data);
        Double saidas = despesaService.totalDespesasDia(data);
        Double lucro = (entradas == null ? 0.0 : entradas) - (saidas == null ? 0.0 : saidas);

        Map<String, Double> mapa = new HashMap<>();
        mapa.put("entradas", entradas);
        mapa.put("saidas", saidas);
        mapa.put("lucro", lucro);
        return mapa;
    }

    @GetMapping("/lucros-mes")
    public Map<String, Double> lucroMes(@RequestParam("ano") int ano, @RequestParam("mes") int mes) {
        YearMonth yearMonth = YearMonth.of(ano, mes);
        LocalDate inicio = yearMonth.atDay(1);
        LocalDate fim = yearMonth.atEndOfMonth();

        Double entradas = vendaService.lucroMes(inicio, fim);
        Double saidas = despesaService.totalDespesasMes(inicio, fim);
        Double lucro = (entradas == null ? 0.0 : entradas) - (saidas == null ? 0.0 : saidas);

        Map<String, Double> mapa = new HashMap<>();
        mapa.put("entradas", entradas);
        mapa.put("saidas", saidas);
        mapa.put("lucro", lucro);
        return mapa;
    }
}