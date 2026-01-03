package id.banking.accountservice.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class InquiryAccountRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -8360230218135311933L;
    
    private String accNum;
}
