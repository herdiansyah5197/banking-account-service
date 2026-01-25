package id.banking.accountservice.service.coreintegration.feign;


import id.banking.accountservice.dto.BalanceCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accountFeignClient", url = "${url.core}")
public interface AccountFeignClient {

    @GetMapping(value = "/account/inquiry-balance", produces = "application/json")
    ResponseEntity<BalanceCustomerResponse> balanceAccount(@RequestParam String accountNumber);
}

