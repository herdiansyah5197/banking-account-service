package id.banking.accountservice.service.inquiry.impl;

import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import id.banking.accountservice.service.inquiry.InquiryAccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class InquiryAccountServiceImpl implements InquiryAccountService {


    @Override
    @Cacheable(
            value = "account-balance",
            key = "#request.accNum",
            unless = "#result == null"
    )
    public InquiryAccountResponse inquiryAccountResponse(InquiryAccountRequest request, HttpServletRequest servletRequest) {
        InquiryAccountResponse response = null;
        try {

            String customerIdStr = servletRequest.getHeader("customer-id");
            if (customerIdStr == null || customerIdStr.isEmpty()) {
                throw new IllegalArgumentException("Customer ID tidak ditemukan di header");
            }
            Long customerId = Long.valueOf(customerIdStr);
            //TODO core mock data get
//        coreBankingClient.inquirySaldo(request.getAccNum());
        }catch (Exception e){
            log.error("Error in inquiryAccountResponse : {}", e.getMessage());
            throw e;
        }
        return response;
    }
}
