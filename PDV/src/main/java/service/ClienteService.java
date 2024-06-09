package service;

import com.google.gson.Gson;
import com.mycompany.pdv.Util;
import dto.ClienteDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author vsemp
 */
public class ClienteService {
    
    private static String URLWEBSERVICE = "";
    private static int SUCESSO = 200;
    
    public static ClienteDTO buscarClientes(String id) throws Exception{
        String urlChamada = URLWEBSERVICE + id + "/json";
        List<Cliente> clientes = new ArrayList<>();
        
        try{
            URL url = new URL(urlChamada);
            HttpURLConnection conexao = 
                    (HttpURLConnection) url.openConnection();
            
            if(conexao.getResponseCode() != SUCESSO){
                throw new RuntimeException(
                        "Erro ao conectar: "+conexao.getResponseMessage());
            }
            
            BufferedReader resposta = new BufferedReader(
                    new InputStreamReader(conexao.getInputStream()));
            
            String json = Util.converteJsonString(resposta);
            
            Gson gson = new Gson();
            ClienteDTO dto = gson.fromJson(json, ClienteDTO.class);
                    
            return dto; 
            
        }catch(Exception ex){
            throw new Exception("Erro ao retornar endereço: "+ex);
        }

    }
}
