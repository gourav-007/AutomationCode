package com.seleneiumlearn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class automateMenuLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.techlistic.com/");
		driver.manage().window().maximize();
		//		WebElement e = driver.findElement(By.xpath("//a[text()='Java']"));
		//		e.click();
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id"));
		driver.navigate().to("https://www.techlistic.com/p/java.html");
		driver.navigate().refresh();
//		Thread.sleep(10000);
		String title = driver.getTitle();
		System.out.println("Java Page Title is :"+title);		
		driver.navigate().back();

		//		@Capture ScreenShot
		//		EventFiringWebDriver a = new EventFiringWebDriver(driver);
		//		File srcfile = a.getScreenshotAs(OutputType.FILE);
		//		File destfile = new File("C:/automatemenu.png");
		//		try {
		//			FileHandler.copy(srcfile, destfile);
		//		} catch (IOException e1) {
		//			// TODO Auto-generated catch block
		//			e1.printStackTrace();
		//		}
		//	
		driver.navigate().to("https://www.techlistic.com/p/selenium.html");
//		Thread.sleep(5000);
		driver.navigate().refresh();
		String seleniumTitle = driver.getTitle();
		System.out.println("Selenium Tutorial Page Title is: "+seleniumTitle);
		driver.navigate().back();
		driver.navigate().to("https://www.techlistic.com/p/testng.html");
		String testngPageTitle = driver.getTitle();
		System.out.println("TestNG Page Title is:"+testngPageTitle);
		driver.navigate().back();
		String homepagetitle = driver.getTitle();
		System.out.println("Selenium Tutorial Page Title is: "+homepagetitle);
		driver.quit();
	}
}

