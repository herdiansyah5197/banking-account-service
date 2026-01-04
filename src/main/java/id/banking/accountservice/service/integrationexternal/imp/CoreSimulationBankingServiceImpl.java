package id.banking.accountservice.service.integrationexternal.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.banking.accountservice.service.integrationexternal.CoreSimulationBankingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoreSimulationBankingServiceImpl implements CoreSimulationBankingService {


    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    @Override
    public Object doRestExternal(String url, Object body, HttpHeaders headers, HttpMethod httpMethod) throws JsonProcessingException {
        log.info("Start  : {}", url);
        try {
            HttpEntity<Object> entity = new HttpEntity<>(body, headers);
            log.info("Request : {}", objectMapper.writeValueAsString(entity));
            ResponseEntity<Object> responseEntity = restTemplate.exchange(url, httpMethod, entity,
                    new ParameterizedTypeReference<>() {});
            log.info("response : {}", objectMapper.writeValueAsString(responseEntity));

            return Objects.requireNonNullElse(responseEntity.getBody(), new Object());
        } catch (Exception e) {
            log.info("Error when doRestService : {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public HttpHeaders generateHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
