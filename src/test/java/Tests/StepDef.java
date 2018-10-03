package Tests;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import Pages.Home;
import Pages.SignIn;
import Pages.SignUp;
import Pages.User;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	
	ChromeDriver driver;
	String url = "http://a.testaddressbook.com/";
	
	
	
	@Given("^the website$")
	public void the_website() {
	    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(url);
	}

	@When("^I click the sign in button$")
	public void i_click_the_sign_in_button() {
	    Home menu_signin = PageFactory.initElements(driver, Home.class);
	    menu_signin.clickSignInMenu();
	}

	@When("^I click on Sign up button$")
	public void i_click_on_Sign_up_button() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"clearance\"]/div/div/form/div[4]/a")));
		
	    SignIn click_reg = PageFactory.initElements(driver, SignIn.class);
	    click_reg.clickSignUpButton();
	}

	@When("^I fill out the fields with valid credentials$")
	public void i_fill_out_the_fields_with_valid_credentials() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		
	    SignUp credentials = PageFactory.initElements(driver, SignUp.class);
	    credentials.fillCredentials();
	}

	@When("^I press the sign up button$")
	public void i_press_the_sign_up_button() {
	    SignUp register = PageFactory.initElements(driver, SignUp.class);
	    register.clickRegButton();
	}

	@When("^I press sign out$")
	public void i_press_sign_out() {
	    User signout = PageFactory.initElements(driver, User.class);
	    signout.signOut();
	}

	@Then("^I enter my newly created account details$")
	public void i_enter_my_newly_created_account_details() {
	    SignIn login_cred = PageFactory.initElements(driver, SignIn.class);
	    login_cred.signInCredentials();
	}

	@Then("^I press the sign in button$")
	public void i_press_the_sign_in_button() throws InterruptedException, IOException {
	    SignIn click_login = PageFactory.initElements(driver, SignIn.class);
	    click_login.clickSignInButton();

	    File srcfl = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(srcfl, new File("/tmp/account.png"));
	    Thread.sleep(5000);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
