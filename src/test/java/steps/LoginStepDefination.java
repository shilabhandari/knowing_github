package steps;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.Databasepage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefination extends TestBase {
	Databasepage databasepage;
	LoginPage loginPage;
	
	@Before
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		databasepage = new Databasepage();
		
		}
	
	@Given("^User is on Techfios login page$")
	public void user_is_on_Techfios_login_page()  {
	  initDriver();
	  driver.get("https://www.techfios.com/billing/?ng=admin");
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username)   {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		 loginPage.enterUserName(username);
	}

	@When("^User  enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password)  {
		loginPage.enterPassword(password);
	}

	@When("^User click signin button$")
	public void user_click_signin_button()  {
		loginPage.clickSignInButton();
	}

	@Then("^User should land on dashboard page$")
	public void user_should_land_on_dashboard_page() throws IOException  {
		Assert.assertEquals("Dashboard- iBilling", loginPage.getPageTitle());
		takeScreenshot(driver);
			}
	
	@When("^User enters \"([^\"]*)\" from database$")
	public void user_enters_from_database(String loginData)  {
	
		switch(loginData) {
		case "username":
			loginPage.enterUserName(databasepage.getData("username"));
			System.out.println("Username from DB: "+ databasepage.getData("username"));
			break;
			case "password":
			loginPage.enterPassword(databasepage.getData("password"));
			System.out.println("Password from DB: "+ databasepage.getData("password"));
			break;
			
			default: 
				System.out.println("Unable to extract login data " + loginData + "from DB");
			
		}
		
	}
	

@After
public void teardown() {
	driver.close();
	driver.quit();
}

}
