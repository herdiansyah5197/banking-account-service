package id.banking.accountservice.service.inquiry;

import com.fasterxml.jackson.core.JsonProcessingException;
import id.banking.accountservice.dto.InquiryAccountRequest;
import id.banking.accountservice.dto.InquiryAccountResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface InquiryAccountService {


    InquiryAccountResponse inquiryAccountBalanceResponse(InquiryAccountRequest request, HttpServletRequest servletRequest) throws JsonProcessingException;
}
