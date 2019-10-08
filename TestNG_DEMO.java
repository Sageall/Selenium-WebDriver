package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import static org.junit.Assert.*;
public class TestNG_DEMO {
	
	WebDriver Cdriver;
	
@BeforeTest
public void beforeTest()
{
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","/home/sejal/eclipse-workspace/seleniumDemo/src/Driver/chromedriver_linux64/chromedriver");
	Cdriver= new ChromeDriver(options);
	Cdriver.get("https://www.jabong.com/");
	Cdriver.manage().window().maximize();	  
}

	
  @Test(priority=1)
  public void TitleTest()
  {
	  String actualTitle;
	  String expectedTitle="Online Shopping: Buy Women, Men, Kids Fashion & Lifestyle in India - Jabong";
		
		actualTitle = Cdriver.getTitle();
		
		assertEquals("Title case : Passed",actualTitle,expectedTitle);
		
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Title Test Case :Passed");
		}
		
		else
		{
			System.out.println("Title Test Case :Failed");
		}
		
  }
  
  @Test(priority=2)
  public void URLTest() throws InterruptedException
  {
	  Thread.sleep(6000);
	  String currentURL;
		String expectedURL="https://www.jabong.com/about";
		Cdriver.findElement(By.linkText("About Us")).click();
		currentURL=Cdriver.getCurrentUrl();
		
		assertEquals("Title case : Passed",expectedURL,currentURL);
		if(expectedURL.equals(currentURL))
		{
			System.out.println("URL Test Case :Passed");
		}
		
		else
		{
			System.out.println("URL Test Case :Failed");
		}
	  
  }
  
  
  @Test(priority=3)
  public void navigationTest() throws InterruptedException
  {
	  Thread.sleep(4000);
	  String curNavURL;
	  String navURL="https://www.jabong.com/";
	  Cdriver.navigate().back();
	  curNavURL= Cdriver.getCurrentUrl();
	  assertEquals("Title case : Passed",navURL,curNavURL);
	  if(navURL.equals(curNavURL))
		{
			System.out.println("Nav Test Case :Passed");
		}
		
		else
		{
			System.out.println("Nav Test Case :Failed");
		}
  }
  
  
  

@Test(priority=5)
public void LogoTesting()
{
	WebElement JabongImg=Cdriver.findElement(By.cssSelector(".jabong-logo > a:nth-child(1)"));
	assertTrue(JabongImg.isDisplayed());
	if(JabongImg.isDisplayed())
	{
		System.out.println("Logo Test: Passed");
	}
	else
	{
		System.out.println("Logo Test: Failed");
	}
}

@Test(priority=6)
public void EditBoxTest() throws InterruptedException
{
	WebElement search= Cdriver.findElement(By.id("search"));
	if(search.isDisplayed())
	{
		if(search.isEnabled())
		{
			search.sendKeys("Test");
			Thread.sleep(3000);
			search.clear();
			assertTrue(search.isEnabled());
		}
		
		else
		{
			System.out.println("SearchBox not Enabled");
		}
	}
	else
	{
		System.out.println("SearchBox not Visible");
	}
}


@Test(priority=7)
public void SearchTest() throws InterruptedException
{
	Thread.sleep(3000);
	String SearchURL="https://www.jabong.com/find/shirt?tt=&rank=0";
	String SearchCurrURL;
	
	WebElement search= Cdriver.findElement(By.id("search"));
	search.sendKeys("shirt");
	search.sendKeys(Keys.ENTER);
	
	SearchCurrURL=Cdriver.getCurrentUrl();
	assertEquals("Title case : Passed",SearchURL,SearchCurrURL);
	if(SearchCurrURL.equals(SearchURL))
		{
			System.out.println("Search Test Case :Passed");
		}
		
		else
		{
			System.out.println("Search Test Case :Failed");
		}
	
	
}

@Test(priority=8)
public void checkBoxTest() throws InterruptedException
{
	Thread.sleep(3000);
	WebElement chkBox= Cdriver.findElement(By.id("boys"));
	
	if(chkBox.isDisplayed())
	{
		System.out.println("CheckBox is Displayed");
		 
		if(chkBox.isEnabled())
		{
			System.out.println("CheckBox is Enabled");
			
			if(chkBox.isSelected())
			{
				System.out.println("CheckBox is Selected");
				assertTrue(chkBox.isSelected());
			}
			else
			{
				chkBox.click();
				System.out.println("CheckBox is Selected");
;			}
		}
	}
	else
	{
		System.out.println("CheckBox is Not Displayed");
	}
		
}



@Test(priority=9)
public void LoginFailTest() throws InterruptedException
{
	  Cdriver.get("https://www.jabong.com/customer/account/login/");
	  Cdriver.findElement(By.id("login-email")).sendKeys("ssd@gmail.com");
	  Cdriver.findElement(By.id("login-pwd")).sendKeys("Pass@12345");
	  Cdriver.findElement(By.id("btn-login")).submit();
	  
	  Thread.sleep(3000);
	  WebElement error=Cdriver.findElement(By.id("top-error"));
	  
	  if(error.isDisplayed())
	  {
		  System.out.println("Login Failed");
		  assertTrue(error.isDisplayed());
	  }
	  else 
	  {
		  System.out.println("No Error");
	  }
	  	  
}

@Test(priority=10)
public void LoginTest() throws InterruptedException
{
	  String LogURL;
	  String SuccURL="https://www.jabong.com/";
	  
	  Thread.sleep(5000);
	  Cdriver.get("https://www.jabong.com/customer/account/login/");
	  Cdriver.findElement(By.id("login-email")).sendKeys("knowhere.1998@gmail.com");
	  Cdriver.findElement(By.id("login-pwd")).sendKeys("Pass@123");
	  Cdriver.findElement(By.id("btn-login")).submit();
	  Thread.sleep(3000);
	  
	  LogURL = Cdriver.getCurrentUrl();
	  
	  assertEquals("Title case : Passed",LogURL,SuccURL);
	  
	  if(LogURL.equals(SuccURL))
			{
				System.out.println("Login Test Case :Passed");
			}
			
			else
			{
				System.out.println("Login Test Case :Failed");
			}
	  Thread.sleep(3000);
	  	  
}
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  Cdriver.close();
	  Cdriver.quit();
	  
  }

}
