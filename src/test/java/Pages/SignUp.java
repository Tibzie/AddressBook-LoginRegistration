package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp {
	@FindBy(id="user_email")
	private WebElement emailField;
	
	@FindBy(id="user_password")
	private WebElement passField;
	
	public void fillCredentials() {
		emailField.sendKeys("bane@msn.com");
		passField.sendKeys("batmobile");
	}
	
	@FindBy(xpath="//*[@id=\"new_user\"]/div[3]/input")
	private WebElement regButton;
	
	public void clickRegButton() {
		regButton.click();
	}
}
