package br.mfs.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.mfs.model.Compra;
import br.mfs.service.CompraService;

@Controller
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@PostMapping("/saveCompra")
	public String saveCompra(@ModelAttribute("compra") Compra compra) throws ParseException {
		
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		Date data = df2.parse(LocalDate.now().toString());
		
		compra.setData(df1.format(data));
		compraService.create(compra);
		
		return "";
	}
	
	@GetMapping("/deleteCompra/{id}")
	public String deleteCompra(@PathVariable (value = "id") int id) {
		
		this.compraService.remove(id);
		
		return "";
	}
	
	@GetMapping("/updateCompra/{id}")
	public String updateCompra(@PathVariable (value = "id") int id, Model model) {
		
		return "";
	}
}
