package id.banking.accountservice.service.inquiry.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import id.banking.accountservice.service.inquiry.InquiryAccountService;
import id.banking.accountservice.service.integrationexternal.CoreSimulationBankingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class InquiryAccountServiceImpl implements InquiryAccountService {


    private final CoreSimulationBankingService  coreSimulationBankingService;

    @Value("${core.account.balance}")
    private String esbInquiryBalanceAccount;

    public InquiryAccountServiceImpl(CoreSimulationBankingService coreSimulationBankingService) {
        this.coreSimulationBankingService = coreSimulationBankingService;
    }


    @Override
    @Cacheable(
            value = "account-balance",
            key = "#request.accNum",
            unless = "#result == null"
    )
    public InquiryAccountResponse inquiryAccountBalanceResponse(InquiryAccountRequest request, HttpServletRequest servletRequest) throws JsonProcessingException {
        InquiryAccountResponse response = null;
        try {

            String customerIdStr = servletRequest.getHeader("customer-id");
            if (customerIdStr == null || customerIdStr.isEmpty()) {
                throw new IllegalArgumentException("Customer ID tidak ditemukan di header");
            }
            Long customerId = Long.valueOf(customerIdStr);
            //

            coreSimulationBankingService.doRestExternal(esbInquiryBalanceAccount,request,coreSimulationBankingService.generateHeader(), HttpMethod.POST);
        }catch (Exception e){
            log.error("Error in inquiryAccountResponse : {}", e.getMessage());
            throw e;
        }
        return response;
    }
}
