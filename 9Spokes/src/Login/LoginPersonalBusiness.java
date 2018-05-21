package Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPersonalBusiness {
	
	static WebDriver driver;
	
	static WebDriverWait wait;
	
	// user need to select Business /personal before login 
	//static String SelectAcntType="business";
	static String SelectAcntType="personal";
	
	static String url="https://login-example-app.firebaseapp.com/";
	
	static String personalacc_Username="peter";
	
	static String personalacc_pwd="personal";
	
	static String businessacc_Username="bill";
	
	static String businessacc_pwd="business";
	
	static String pageActualTitle="Login";
	


	public static void main(String[] args) throws InterruptedException {
		
		
		
		//Chrome Browser Execution
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prasad\\Desktop\\Selenium Setup\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get(url);
		
		Assert.assertEquals(driver.getTitle(), pageActualTitle);
		
		String SelectAccontType=SelectAcntType.toUpperCase().toString();
		
		 System.out.println("Account Type:"+SelectAccontType);
		 
		 switch(SelectAccontType)
		 {
		 
		 case "PERSONAL":
		 	{
				 try {
					 
					 driver.findElement(By.id("login_type_personal")).click();
					 driver.findElement(By.id("personal_username")).clear();
					 driver.findElement(By.id("personal_username")).sendKeys(personalacc_Username);
					 driver.findElement(By.id("personal_password")).clear();
					 driver.findElement(By.id("personal_password")).sendKeys(personalacc_pwd);
					 driver.findElement(By.id("login_button")).click();
					 Thread.sleep(3000);
					 
					
				     } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw e;
				}
				 break;
			 
		 	}
			 
		 	case "BUSINESS":
		 	{
		 		 try {
						
		 			 driver.findElement(By.id("login_type_business")).click();
					 driver.findElement(By.id("business_username")).clear();
					 driver.findElement(By.id("business_username")).sendKeys(businessacc_Username);
					 driver.findElement(By.id("business_password")).clear();
					 driver.findElement(By.id("business_password")).sendKeys(businessacc_pwd);
					 driver.findElement(By.id("login_button")).click();
					 Thread.sleep(3000);
					 
		 		 	} catch (Exception e) {
					
					e.printStackTrace();
					throw e;
				}
				 break;
		 	}
		 	
		 	default:
		 	{
		 		try{
		 		
		 	          System.out.println("User doesn't select Proper Account Type. By default it will open Personal Account");
		 	         driver.findElement(By.id("login_type_personal")).click();
					 driver.findElement(By.id("personal_username")).clear();
					 driver.findElement(By.id("personal_username")).sendKeys(personalacc_Username);
					 driver.findElement(By.id("personal_password")).clear();
					 driver.findElement(By.id("personal_password")).sendKeys(personalacc_pwd);
					 driver.findElement(By.id("login_button")).click();
					 Thread.sleep(3000);
		 	          
		 	       }
		 	       catch(Exception exp){
		 	        
		 	        System.exit(1);
		 	       }
		 	}
	
	 }
		 System.out.println("Login Successful");
		 
		//Verify Home Page title 
		 System.out.println(driver.findElement(By.xpath("//h1")).getText());
		 Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Home Page");
		//Logout
		 driver.findElement(By.xpath("//button")).click();
		 
		 System.out.println("Logout Successful");
		
		 driver.quit();
	

	}

}
