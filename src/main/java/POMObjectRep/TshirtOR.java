package POMObjectRep;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Core.Core;

public class TshirtOR extends Core {

	public TshirtOR() {
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[3]/a")
	WebElement Tshirt;

	@FindBy(xpath = " .//span[text()='Add to cart']")
	WebElement AddtoCart;

	@FindBy(xpath = ".//*[@ title='Proceed to checkout']")
	WebElement Proceed;

	@FindBy(xpath = ".//*[@id='1_1_0_0']/i")
	WebElement Delete;

	@FindBy(xpath = ".//*[@class='product-image-container']")
	WebElement img;

	WebDriverWait wait = new WebDriverWait(d, 10l);

	public WebElement Image() {
		wait.until(ExpectedConditions.elementToBeClickable(Tshirt));
		return img;
	}

	public WebElement Tshirt() {
		wait.until(ExpectedConditions.elementToBeClickable(Tshirt));
		return Tshirt;
	}

	public WebElement AddToCart() {
		return AddtoCart;
	}

	public WebElement proceed() {
		wait.until(ExpectedConditions.visibilityOf(Proceed));
		return Proceed;
	}

	public WebElement Delete() {
		return Delete;
	}

}
