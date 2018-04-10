package Homepage;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Core.Core;
import POMObjectRep.TshirtOR;

public class AddtoCart extends Core {

	static TshirtOR tshirt;

	@BeforeMethod
	public static void init() throws IOException {
		Core.init();
		tshirt = new TshirtOR();
	}

	@Test
	public void addtocart() {
		tshirt.Tshirt().click();
		Actions a = new Actions(d);
		a.moveToElement(tshirt.Image()).perform();
		tshirt.AddToCart().click();
		tshirt.proceed().click();
		tshirt.Delete().click();
		Assert.fail();
	}

}
