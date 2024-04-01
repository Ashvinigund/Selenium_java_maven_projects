/**
 * 
 */


import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * May 2, 2023
 * 
 * @author Suraj Kathare
 * @version 1.0
 */
public class ApproveApplication {
	static WebDriver driver;
	static int a = 0;
	//static int i=1;

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException  {
		// cmd chrome.exe �remote-debugging-port=9222 �user-data-dir=E:\ChromeData

		// System.setProperty("webdriver.chrome.drive", "E:\\Drive D\\chrome-win
		// (1)\\chrome-win\\chrome.exe");

		WebDriverManager.chromiumdriver().setup();
		// ChromeOptions opt = new ChromeOptions();

		// opt.setExperimentalOption("debuggerAddress", "localhost:9222");

		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.navigate().to("https://education.mahaonline.gov.in/");

		

		/*
		 * List<WebElement> cnt = driver.findElements(By.id("btnScrutiny"));
		 * System.out.println("Size Is:- " + cnt.size());
		 */

		driver.findElement(By.id("UserName")).sendKeys("MSBTE.Desk3.User4");

		driver.findElement(By.id("Password")).sendKeys("Pass@123");

		// Captcha
		Scanner myObj = new Scanner(System.in);

		String scanner = myObj.nextLine();

		driver.findElement(By.id("Captcha")).sendKeys(scanner);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		//driver.manage().window().maximize();
	
		
		//System.out.println(nextbtn.size());
		//System.exit(0);
		
		for (int s = 0; s < 5000; s++) {
			Thread.sleep(2000);
			List<WebElement> cnt = driver.findElements(By.id("btnScrutiny"));
			// System.out.println("Size Is:- " + cnt.size());
			
			
			if (cnt.size() != 0) {

				Thread.sleep(2000);
				//cnt.get(0).click();
				driver.findElement(By.id("btnScrutiny")).click();
				Thread.sleep(2000);

				driver.findElement(By.id("chkSelectAll")).click();

				Thread.sleep(2000);

				driver.findElement(By.id("ScrutinyRemark")).sendKeys("Approved");

				// Thread.sleep(2000);
				try {
					//System.out.println("In try block");
				driver.findElement(By.xpath("//*[@id='btn0']")).click();
				} catch (Exception e) {
					System.out.println("In catch block");
					//driver.findElement(By.xpath("//button[text()='Approve Application']")).click();
					driver.findElement(By.xpath("//button[text()='Application Forward']")).click();
				//}
				Thread.sleep(2000);

				driver.switchTo().alert().accept();

				// Thread.sleep(2000);
				driver.findElement(By.name("OK")).click();
				// Thread.sleep(1000);
				String b = driver.findElement(By.xpath("//*[@id='TheForm']/div[1]/div/div/div[4]/ul/li[1]"))
						.getText();
				a++;
				System.out.println(a + "   " + b);
				
				// Thread.sleep(2000);
				}
			}
			else
			{
				driver.findElement(By.id("btnNext")).click();
			}
		}
	}
}
			
		
		

		    
		
	


