package id.banking.accountservice.service.integrationexternal;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public interface CoreSimulationBankingService {

    Object doRestExternal(String url, Object body, HttpHeaders headers, HttpMethod httpMethod) throws JsonProcessingException;
    HttpHeaders generateHeader();
}
