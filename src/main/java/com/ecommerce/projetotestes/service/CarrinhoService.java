package com.ecommerce.projetotestes.service;


import com.ecommerce.projetotestes.model.Carrinho;
import com.ecommerce.projetotestes.model.ItemVenda;
import com.ecommerce.projetotestes.model.Produto;
import com.ecommerce.projetotestes.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private final CarrinhoRepository carrinhoRepository;
    @Autowired
    private final ProdutoService produtoService;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutoService produtoService) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoService = produtoService;
    }

    public Carrinho getCarrinho() {
        Carrinho carrinho = carrinhoRepository.encontrarCarrinhoMaisRecente();
        if (carrinho == null) {
            carrinho = new Carrinho();
            carrinhoRepository.save(carrinho);
        }
        return carrinho;
    }

    public void adicionarProdutoAoCarrinho(Long idProduto, int quantidade) {
        Carrinho carrinho = getCarrinho();
        Produto produto =  produtoService.getProduto(idProduto);
        carrinhoRepository.save(carrinho);
    }






}








