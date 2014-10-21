import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 

public class Google { 
	private WebDriver driver; 
	@BeforeMethod  
	public void base() throws Exception{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void GoogleHome() throws Exception{
		try{
		
		// Navigating to google Home Page
		driver.get("https://www.google.com");
		
		driver.findElement(By.id("gbqfq")).clear();
		driver.findElement(By.id("gbqfq")).sendKeys("Testing");
		driver.findElement(By.id("gbqfq")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("ires")).findElement(By.id("rso")).findElements(By.tagName("li")).get(3)
			.findElement(By.tagName("div")).findElement(By.tagName("h3")).findElement(By.tagName("a")).click();
		String s = driver.getTitle();
		System.out.println("The Test GoogleHome  is completed");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	void googleHomeTest() {

		try {
			driver.get("https://www.google.com");
			Thread.sleep(5000);
			boolean pageTitle = driver.getPageSource().contains("Google");
			Assert.assertEquals(pageTitle, true);
			System.out.println("The Test googleHomeTest  is completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	void googleOfficeTest(){
	
	try {
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		boolean pageTitle = driver.getPageSource().contains("Doodle");
		Assert.assertEquals(pageTitle, true);		
		System.out.println("The Test googleOfficeTest  is completed");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); 
	}
	}
		@AfterMethod
		public void writereport()
		{
			driver.quit();
		}
}
