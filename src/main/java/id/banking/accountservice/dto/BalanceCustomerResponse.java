package id.banking.accountservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class BalanceCustomerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 48308016637316704L;

    private BigDecimal balance;
    private Integer statusAccount;
    private String accountNumber;
    private BigDecimal holdBalance;
    private String accountOwnerName;
}
