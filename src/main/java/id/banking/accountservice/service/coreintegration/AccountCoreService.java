package id.banking.accountservice.service.coreintegration;


import com.fasterxml.jackson.core.JsonProcessingException;
import id.banking.accountservice.constant.AccountStatusConstant;
import id.banking.accountservice.dto.BalanceCustomerResponse;
import id.banking.accountservice.dto.InquiryAccountResponse;
import id.banking.accountservice.service.coreintegration.feign.AccountFeignClient;
import id.banking.accountservice.util.FormatUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountCoreService {

    private final AccountFeignClient accountFeignClient;

    public AccountCoreService(AccountFeignClient accountFeignClient) {
        this.accountFeignClient = accountFeignClient;
    }

    public InquiryAccountResponse inquiryAccountResponse(String account) throws JsonProcessingException {
        BalanceCustomerResponse response = accountFeignClient.balanceAccount(account).getBody();
        if(response!=null){
            return InquiryAccountResponse.builder()
                    .accNum(response.getAccountNumber())
                    .balance(response.getBalance())
                    .status(String.valueOf(AccountStatusConstant.getByStatusCode(response.getStatusAccount())))
                    .accountOwnerName(response.getAccountOwnerName())
                    .balanceFormated(FormatUtils.formatAmount(response.getBalance(),"#,##0.00"))
                    .build();
        }
        return null;
    }

}

