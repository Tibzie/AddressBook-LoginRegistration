package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User {
	@FindBy(xpath="//*[@id=\"navbar\"]/div[1]/a[3]")
	private WebElement signOutButton;
	
	public void signOut() {
		signOutButton.click();
	}
}
