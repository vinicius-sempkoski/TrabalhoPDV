package dao;

import dao.GenericDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Venda;

/**
 *
 * @author vsemp
 */
public class VendasDAO extends GenericDAO<Venda> {

    @Override
    protected Venda construirObjeto(ResultSet rs) {
        Venda venda = null;

        try {
            venda = new Venda();
            venda.setClienteId(
                    rs.getInt("CLIENTE_ID"));
            venda.setQuantidade(
                    rs.getInt("QUANTIDADE_VENDA"));
            venda.setValorTotal(
                    rs.getDouble("VALOR_TOTAL_VENDA"));
            venda.setObservacoes(
                    rs.getString("OBSERVACOES_VENDA"));

        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }

    @Override
    public boolean salvar(Venda obj) {
        String sql = "INSERT INTO public.\"Venda\"(\""
                + "CLIENTE_ID\", \"QUANTIDADE_VENDA\", \"VALOR_TOTAL_VENDA\", \"OBSERVACOES_VENDA\")"
                + "VALUES (?, ?, ?, ?);";

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getClienteId());
            ps.setInt(2, obj.getQuantidade());
            ps.setDouble(3, obj.getValorTotal());
            ps.setString(4, obj.getObservacoes());
            ps.executeUpdate();
            ps.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean atualizar(Venda obj) {
                String sql = "UPDATE public.\"Venda\" SET \"QUANTIDADE_ID\" = ?, \"VALOR_TOTAL_VENDA\" = ? WHERE \"CLIENTE_VENDA\" = ? ;";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getClienteId());
            ps.setInt(2, obj.getQuantidade());
            ps.setDouble(3, obj.getValorTotal());
            ps.setString(4, obj.getObservacoes());
            ps.executeUpdate();
            ps.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
