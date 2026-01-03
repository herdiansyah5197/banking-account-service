package id.banking.accountservice.controller;

import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import id.banking.accountservice.service.inquiry.InquiryAccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AccountController {

    private final InquiryAccountService inquiryAccountService;


    @GetMapping("/inquiry-balance")
    public ResponseEntity<InquiryAccountResponse> inquiryAccountResponse(@RequestParam String account, HttpServletRequest servletRequest) {
        InquiryAccountRequest inquiryAccountRequest = InquiryAccountRequest.builder()
                .accNum(account)
                .build();
        InquiryAccountResponse  response =  inquiryAccountService.inquiryAccountResponse(inquiryAccountRequest, servletRequest);
        return ResponseEntity.ok(response);
    }
}
