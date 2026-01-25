package id.banking.accountservice;

import id.banking.accountservice.service.coreintegration.feign.AccountFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AccountServiceApplicationTests {

	@MockBean
	private AccountFeignClient accountFeignClient;

	@Test
	void contextLoads() {
	}

}
