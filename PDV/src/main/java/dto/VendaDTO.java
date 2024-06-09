package dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class VendaDTO {
    
    private int id;
    private String observacoes;
    private Timestamp data;
    private BigDecimal email;
    private int clienteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public BigDecimal getEmail() {
        return email;
    }

    public void setEmail(BigDecimal email) {
        this.email = email;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
   
}
