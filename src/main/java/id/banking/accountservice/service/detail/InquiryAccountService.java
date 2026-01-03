package id.banking.accountservice.service.detail;

import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import org.springframework.http.ResponseEntity;

public interface InquiryAccountService {


    ResponseEntity<InquiryAccountResponse> inquiryAccountResponse(InquiryAccountRequest request);
}
