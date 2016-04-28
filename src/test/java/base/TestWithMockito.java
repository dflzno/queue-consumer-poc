package base;

import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;

/**
 * Do this with listeners!
 * <a href="http://testng.org/doc/documentation-main.html#testng-listeners">TestNG Listeners</a>
 */
public abstract class TestWithMockito {

	@BeforeMethod
	public void injectAllTestDoubles() {
		MockitoAnnotations.initMocks(this);
	}
}
