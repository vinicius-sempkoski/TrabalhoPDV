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

    public String getObservacoes() {
        return observacoes;
    }

    public Timestamp getData() {
        return data;
    }

    public BigDecimal getEmail() {
        return email;
    }

    public int getClienteId() {
        return clienteId;
    }
   
}
