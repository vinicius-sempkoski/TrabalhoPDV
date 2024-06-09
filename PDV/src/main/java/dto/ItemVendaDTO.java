/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.math.BigDecimal;

/**
 *
 * @author vsemp
 */
public class ItemVendaDTO {
    private int id;
    private int quantidade;
    private  BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private int clienteId;

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public int getClienteId() {
        return clienteId;
    }

}
