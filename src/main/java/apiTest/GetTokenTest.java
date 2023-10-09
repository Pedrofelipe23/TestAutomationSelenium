package apiTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetTokenTest {

    private static final String API_URL = "https://esoxxy.solutionsa.com.br/oxxy/api/login";
    private static final String USERNAME = "oxxy";
    private static final String PASSWORD = "mEtGTxAx25";

    @Test
    public void testLoginApi() throws IOException, ParseException {
        // Crie o cliente HTTP
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(API_URL);

        // Defina o corpo da solicitação com os dados de login em formato JSON
        String requestBody = "{\"username\": \"" + USERNAME + "\", \"password\": \"" + PASSWORD + "\"}";
        StringEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPost.setEntity(requestEntity);

        // Execute a solicitação e obtenha a resposta
        HttpResponse response = httpClient.execute((HttpUriRequest) httpPost);

        // Verifique o código de status da resposta (por exemplo, 200 para sucesso)
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode, "Status code deve ser 200");

        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        System.out.println(jsonNode);

    }


}







