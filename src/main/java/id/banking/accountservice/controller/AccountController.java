package id.banking.accountservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import id.banking.accountservice.service.inquiry.InquiryAccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final InquiryAccountService inquiryAccountService;


    @GetMapping("/inquiry-balance")
    public InquiryAccountResponse inquiryAccountResponse(@RequestParam String account, HttpServletRequest servletRequest) throws JsonProcessingException {
        InquiryAccountRequest inquiryAccountRequest = InquiryAccountRequest.builder()
                .accNum(account)
                .build();
        return inquiryAccountService.inquiryAccountBalanceResponse(inquiryAccountRequest, servletRequest);
    }
}
