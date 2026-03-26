package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VendedorResumoDTO;
import com.example.demo.entity.Venda;
import com.example.demo.service.VendaService;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
	private final VendaService service; 
	
	public VendaController(VendaService service) {
	this.service = service;}
	
	@PostMapping("/lote")
	public List<Venda> criarLote(@RequestBody List<Venda> vendas) {
		 return service.salvarLote(vendas);
	}
	
	@GetMapping
	public List <Venda> listar() {return service. listar();
	}
	@GetMapping("/resumo")
		public List<VendedorResumoDTO> resumo(
		    @RequestParam String inicio,
		    @RequestParam String fim
		) {
		    return service.resumo(
		        LocalDate.parse(inicio),
		        LocalDate.parse(fim)
		    );
		}

}
