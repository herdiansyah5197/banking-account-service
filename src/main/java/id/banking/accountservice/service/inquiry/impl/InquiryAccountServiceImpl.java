package id.banking.accountservice.service.inquiry.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import id.banking.accountservice.service.coreintegration.AccountCoreService;
import id.banking.accountservice.service.inquiry.InquiryAccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class InquiryAccountServiceImpl implements InquiryAccountService {



    private final AccountCoreService  accountCoreService;

    public InquiryAccountServiceImpl( AccountCoreService accountCoreService) {
        this.accountCoreService = accountCoreService;
    }

    @Override
    @Cacheable(
            value = "account-balance",
            key = "#request.accNum",
            unless = "#result == null"
    )
    public InquiryAccountResponse inquiryAccountBalanceResponse(InquiryAccountRequest request, HttpServletRequest servletRequest) throws JsonProcessingException {
        log.info("InquiryAccountBalanceResponse");
        try {
            return accountCoreService.inquiryAccountResponse(request.getAccNum());
        }catch (Exception e){
            log.error("Error in inquiryAccountResponse : {}", e.getMessage());
            throw e;
        }
    }
}
