package br.mfs.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.mfs.model.Produto;
import br.mfs.service.ProdutoService;

import javax.annotation.PostConstruct;

@Component
public class CarregaData {

    @Value("${habilitar.carregar.massa.dados}")
    private boolean podeCarregarDados;

    @Autowired
    private ProdutoService produtoService;

    @PostConstruct
    public void loadData() {

        if (podeCarregarDados)
            for (int x = 0; x < 50; x++) 
            	produtoService.create(new Produto("Bolacha " + x, 20.0 + x / 2, "Bauduco"));
    }
}
