package id.banking.accountservice.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class InquiryAccountRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5773400935594722929L;
    
    private String accNum;
}
