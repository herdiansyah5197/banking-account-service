package id.banking.accountservice.service.inquiry;

import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface InquiryAccountService {


    InquiryAccountResponse inquiryAccountResponse(InquiryAccountRequest request, HttpServletRequest servletRequest);
}
