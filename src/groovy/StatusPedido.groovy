/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristiany
 */
public enum StatusPedido {
    
    A('Aberto'),
    C('Cancelado'),
    D('Despachado'),                
    E('Entregue')
    
    private final String descricao
    
    public StatusPedido(String descricao) {
        this.descricao = descricao
    }

}

