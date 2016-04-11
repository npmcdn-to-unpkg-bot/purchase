package by.ladyka.purchase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PurchaseApplication.class)
@WebAppConfiguration
public class PurchaseApplicationTests {

	@Test
	public void contextLoads() {
	}


}
