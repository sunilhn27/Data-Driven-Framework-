
package Homepage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Core.Core;

public class BrokenLink extends Core {

	@Test
	public void main() throws InterruptedException, IOException {
		Core.init();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		List<WebElement> links = d.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyLink(url);
		}
	}

	public void verifyLink(String urlLink) {

		try {

			URL link = new URL(urlLink);

			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();

			httpConn.setConnectTimeout(2000);

			httpConn.connect();

			if (httpConn.getResponseCode() == 200) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
		}

		catch (Exception e) {

		}
	}
}