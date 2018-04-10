package Homepage;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Core.Core;
import POMObjectRep.indexpageOR;

public class Homepage extends Core {

	static indexpageOR index;

	@BeforeMethod
	public static void init() throws IOException {

		Core.init();

		index = new indexpageOR();
	}

	@Test
	public static void homepage() {
		index.Tshirt().click();
	}

	@AfterMethod
	public static void Close() throws InterruptedException {
		Core.tearDown();
	}
}
