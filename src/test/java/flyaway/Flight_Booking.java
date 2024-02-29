package flyaway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ConfigReader.ConfigReader;

public class Flight_Booking {

	@Test
	public void Flight_Booking() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = ConfigReader.getProperty("base.url");
		driver.get(baseUrl);
		String username = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		String Emailid = ConfigReader.getProperty("Emailid");
		String ConfirmPassword = ConfigReader.getProperty("ConfirmPassword");
		String Name = ConfigReader.getProperty("Name");
		String Address = ConfigReader.getProperty("Address");
		String City = ConfigReader.getProperty("City");

		driver.findElement(By.xpath("//a[@href='home']")).click();
		driver.findElement(By.xpath("//a[@href='login']")).click();
		driver.findElement(By.xpath("//a[@href='signup']")).click();
		driver.findElement(By.xpath("//input[@name='email_id']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='pwd2']")).sendKeys(ConfirmPassword);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys(Address);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
		driver.findElement(By.xpath("//button[text()='Signup']")).click();

		driver.findElement(By.xpath("//a[@href='home']")).click();
		driver.findElement(By.xpath("//a[@href='login']")).click();
		driver.findElement(By.xpath("//input[@name='email_id']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//a[@href='home']")).click();

		Select Dropdown = new Select(driver.findElement(By.xpath("//select[@name='source']")));

		Dropdown.selectByVisibleText("Bangalore");

		Select Dropdown2 = new Select(driver.findElement(By.xpath("//select[@name='destination']")));

		Dropdown2.selectByVisibleText("Hyderabad");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//a[@href=\"bookflight?id=7\"]")).click();
		driver.findElement(By.xpath("//a[@href='completepurchase']")).click();
		boolean flight_booked = driver.findElement(By.xpath("//h3[contains(text(), 'FLYAWAY - BOOKING CONFIRMATION')]"))
				.isDisplayed();
		if (flight_booked == true) {
			System.out.println("flight booked sucessfully");
		} else {
			System.out.println("flight not booked");
		}
		driver.close();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

}
