import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aapplesarkar {
	static WebDriver driver;
	static int a = 0;
	// static int i=1;
	static CharSequence[] pageid= {"680", "681", "682", "683", "684","685"};
	// @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable  {

		WebDriverManager.chromiumdriver().setup();
		// ChromeOptions opt = new ChromeOptions();

		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.navigate().to("https://education.mahaonline.gov.in/");

		/*
		 * List<WebElement> cnt = driver.findElements(By.id("btnScrutiny"));
		 * System.out.println("Size Is:- " + cnt.size());
		 */

		driver.findElement(By.id("UserName")).sendKeys("MSBTE.Desk3.User4");

		driver.findElement(By.id("Password")).sendKeys("Pass@123");

		// Captcha enter
		Scanner myObj = new Scanner(System.in);

		String scanner = myObj.nextLine();

		driver.findElement(By.id("Captcha")).sendKeys(scanner);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		// driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(5000);
		WebElement pageNumberElement = driver.findElement(By.id("PageSize"));
		//pageNumberElement.clear();
		pageNumberElement.sendKeys("680");
		
		Thread.sleep(15000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		// Scroll down to the bottom of the page
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(3000);

		//for (int s = 0; s < 5000; s++) {
			Thread.sleep(2000);
			WebElement Snbtn = driver.findElement(By.id("btnScrutiny"));
			Snbtn.click();
			//if (cnt.size() != 0) {
				// perform the approval process
				Thread.sleep(2000);
				// cnt.get(0).click();
				//driver.findElement(By.id("btnScrutiny")).click();
				Thread.sleep(2000);

				driver.findElement(By.id("chkSelectAll")).click();

				Thread.sleep(2000);

				driver.findElement(By.id("ScrutinyRemark")).sendKeys("Approved");

				try {
					// System.out.println("In try block");
					driver.findElement(By.xpath("//*[@id='btn0']")).click();
				} catch (Exception e) {
					System.out.println("In catch block");
					// driver.findElement(By.xpath("//button[text()='Approve
					// Application']")).click();
					driver.findElement(By.xpath("//button[text()='Application Forward']")).click();
				}
				Thread.sleep(2000);

				driver.switchTo().alert().accept();

				// Thread.sleep(2000);
				driver.findElement(By.name("OK")).click();
				// Thread.sleep(1000);
				String b = driver.findElement(By.xpath("//*[@id='TheForm']/div[1]/div/div/div[4]/ul/li[1]")).getText();
				//a++;
				System.out.println(a + "   " + b);

				
		}
	}


