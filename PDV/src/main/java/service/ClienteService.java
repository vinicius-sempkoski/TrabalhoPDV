package service;

import com.google.gson.Gson;
import com.mycompany.pdv.Util;
import dto.ClienteDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author vsemp
 */
public class ClienteService {
    
    private static String URLWEBSERVICE = "";
    private static int SUCESSO = 200;
    
    public static ClienteDTO buscaCliente(int id) throws Exception{
        String urlChamada = URLWEBSERVICE + id + "/json";
        
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
            throw new Exception("Erro ao retornar cliente: "+ex);
        }

    }
}
