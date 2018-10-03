package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn {
	@FindBy(xpath="//*[@id=\"clearance\"]/div/div/form/div[4]/a")
	private WebElement signUpButton;
	
	public void clickSignUpButton() {
		signUpButton.click();
	}
	
	@FindBy(id="session_email")
	private WebElement loginEmail;
	
	@FindBy(id="session_password")
	private WebElement loginPass;
	
	public void signInCredentials() {
		loginEmail.sendKeys("bane@msn.com");
		loginPass.sendKeys("batmobile");
	}
	
	@FindBy(xpath="//*[@id=\"clearance\"]/div/div/form/div[3]/input")
	private WebElement signInButton;
	
	public void clickSignInButton() {
		signInButton.click();
	}
}
