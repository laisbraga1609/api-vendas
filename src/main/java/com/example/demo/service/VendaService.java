package com.example.demo.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.VendedorResumoDTO;
import com.example.demo.entity.Venda;
import com.example.demo.repository.vendaRepository;

@Service
public class VendaService {

    private final vendaRepository repository;

    public VendaService(vendaRepository repository) {
        this.repository = repository;
    }

    public List<Venda> salvarLote(List<Venda> vendas) {
        return repository.saveAll(vendas);
    }

    public List<Venda> listar() {
        return repository.findAll();
    }

    public List<VendedorResumoDTO> resumo(LocalDate inicio, LocalDate fim) {

        List<Venda> vendas = repository.findAll();

        return vendas.stream()
                .filter(v -> !v.getDataVenda().isBefore(inicio)
                        && !v.getDataVenda().isAfter(fim))
                .collect(Collectors.groupingBy(Venda::getVendedorNome))
                .entrySet()
                .stream()
                .map(entry -> {

                    String nome = entry.getKey();
                    List<Venda> lista = entry.getValue();

                    double total = lista.stream()
                            .mapToDouble(Venda::getValor)
                            .sum();

                    long dias = ChronoUnit.DAYS.between(inicio, fim) + 1;

                    double media = Math.round((total / dias) * 100.0) / 100.0;

                    return new VendedorResumoDTO(nome, total, media);
                })
                .collect(Collectors.toList());
    }
}