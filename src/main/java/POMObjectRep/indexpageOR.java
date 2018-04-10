package POMObjectRep;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Core.Core;

public class indexpageOR extends Core {

	public indexpageOR() {
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[1]/a")
	WebElement Women;

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[2]/a")
	WebElement dresses;

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[3]/a")
	WebElement Tshirt;

	@FindBy(xpath = ".//*[@id='search_query_top']")
	WebElement Search;

	@FindBy(xpath = ".//*[@id='searchbox']/button")
	WebElement SearchButton;

	@FindBy(xpath = ".//*[@id='header']/div[3]/div/div/div[3]/div/a")
	WebElement Addtocart;

	WebDriverWait wait = new WebDriverWait(d, 10l);

	public WebElement Women() {
		return Women;
	}

	public WebElement Dresses() {
		return dresses;
	}

	public WebElement Tshirt() {
		return Tshirt;
	}

	public WebElement Search() {
		wait.until(ExpectedConditions.visibilityOf(Search));
		log.info("wait for the search element");
		return Search;
	}

	public WebElement SearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
		log.info("is is now in clickable state");
		return SearchButton;
	}

	public WebElement AddtoCart() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
		log.info("is is now in clickable state");
		return Addtocart;
	}

}
