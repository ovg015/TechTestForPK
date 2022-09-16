package StepD;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class login {
		WebDriver driver = null;
	
@Given("browser is open")
	public void browser_is_open() {
		System.out.println("inside Step - browser is open");
		System.setProperty("webdriver.chrome.driver","C:/Users/Olga/eclipse-workspace/AmazLog/src/test/resources/drivers/chromedriver.exe");
	
		driver = new ChromeDriver();
	}

@And("user is on amazon page")
	public void user_is_on_amazon_page() throws InterruptedException {
		System.out.println("inside Step - user is on amazon page");
	    
		driver.navigate().to("https://www.amazon.com");	
	    
	    String titleName = driver.getTitle();
	    Assert.assertEquals(titleName, "Amazon.com. Spend less. Smile more." );
	    System.out.println("Title matching --> Part executed");
	   
	    String URL = driver.getCurrentUrl();
	    Assert.assertEquals(URL, "https://www.amazon.com/" );
	    System.out.println("URL matching --> Part executed");
	
	    driver.findElement(By.id("nav-logo-sprites"));
	    System.out.println("Logo --> presented");
	    Thread.sleep(2000);
}




@When("user click button sign")
	public void user_click_button_sign() throws InterruptedException {
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		Thread.sleep(2000);
}

@And("User login")
	public void User_login() throws InterruptedException {
		System.out.println("inside Step - User login");
		
		driver.findElement(By.id("ap_email")).sendKeys("ovg015@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("ap_password")).sendKeys("313114Amazon");
		driver.findElement(By.id("signInSubmit")).click();
		
		System.out.println("Login --> succsess");
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
		}
}
