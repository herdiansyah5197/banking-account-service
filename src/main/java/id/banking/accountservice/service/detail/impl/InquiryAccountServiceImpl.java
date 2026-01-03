package id.banking.accountservice.service.detail.impl;

import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import id.banking.accountservice.service.detail.InquiryAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class InquiryAccountServiceImpl implements InquiryAccountService {


    @Override
    public ResponseEntity<InquiryAccountResponse> inquiryAccountResponse(InquiryAccountRequest request) {
        return null;
    }
}
