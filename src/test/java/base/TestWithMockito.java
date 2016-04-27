package base;

import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;

public class TestWithMockito {

	@BeforeMethod  
	public void injectDoubles() {
		MockitoAnnotations.initMocks(this);
	}
}
