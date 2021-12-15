package com.seleneiumlearn;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyAdminLoginPage_TC2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//Verify Home Page Title
		String title = driver.getTitle();
		if(title.equals("OrangeHRM")) {
			System.out.println("Home Page title is Displayed.");
		}
		
		//Verify Uname, password and Login Button should be displayed.
		
		WebElement objuname = driver.findElement(By.id("txtUsername"));
		WebElement objpwd = driver.findElement(By.id("txtPassword"));
		WebElement objlgnbtn = driver.findElement(By.name("Submit"));
		
		if(objuname.isDisplayed() & objpwd.isDisplayed() & objlgnbtn.isDisplayed()) {
			System.out.println("Uname, Password and Login Button is Displayed.");
		}
		
		//Login
		
		String Uname = "Admin";
		String Password = "admin123";
		
		objuname.sendKeys(Uname);
		objpwd.sendKeys(Password);
		objlgnbtn.click();
		
		//Check Admin Homepage
		
		String hCheck = driver.findElement(By.id("welcome")).getText();
		if(hCheck.equals("Welcome John")) {
			System.out.println("Admin Page is Displayed.");			
		}
		
		//Mousehover Actions
		
		WebElement mhover = driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions action = new Actions(driver);
		action.moveToElement(mhover).perform();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		//Add Employee
		
		String firstname="Roman";
		String middlename ="Singh";
		String lastname = "Baggi";
		String empids = "34350";
		
		WebElement fname = driver.findElement(By.id("firstName"));
		WebElement mname = driver.findElement(By.id("middleName"));
		WebElement lname = driver.findElement(By.name("lastName"));
		WebElement empid = driver.findElement(By.id("employeeId"));
		
		fname.clear();
		fname.sendKeys(firstname);
		mname.clear();
		mname.sendKeys(middlename);
		lname.clear();
		lname.sendKeys(lastname);
		empid.clear();
		empid.sendKeys(empids);
		
		//AutoIT
//		driver.findElement(By.id("photofile")).click();
//		Runtime.getRuntime().exec("D://upload.exe");
//		Thread.sleep(10000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(20000); 
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		WebElement pdp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pdMainContainer\"]")));
//		pdp.getText();
		String pdp = driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")).getText();
		if(pdp.equals("Personal Details")) {
			System.out.println("Personal Detail page is displayed.");
		}
		Thread.sleep(10000);
		WebElement mhovers = driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions actionio = new Actions(driver);
		actionio.moveToElement(mhovers).perform();
		Thread.sleep(10000);
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		Thread.sleep(10000);
		
		//Search Employee in List
		
		WebElement table = driver.findElement(By.id("resultTable"));
		List<WebElement> rows =	table.findElements(By.tagName("tr"));
		for(int i=0;i<rows.size();i++) {
			List <WebElement> cell = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cell.size();j++) {
				String cellvalue = cell.get(j).getText();
				if(cellvalue.equals("Baggi")) {
					System.out.println(cellvalue + " is Displayed " + "in "+i+"th"+" Row and "+j+"th"+" Column.");
				}
			}
//			Thread.sleep(5000);
//			driver.findElement(By.id("welcome")).click();
//			driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
//			System.out.println("I am logging out.....");
		}
		
		driver.close();
		System.out.println("Closing the Object.");

	}
		
	}
