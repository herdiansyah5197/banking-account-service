package id.banking.accountservice.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class InquiryAccountResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8360230218135311933L;
    
    private String accNum;
    private String status;
    private String balanceFormated;
    private BigDecimal balance;
    private String accountOwnerName;
}
