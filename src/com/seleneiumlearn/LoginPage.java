package com.seleneiumlearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(id="txtUsername")
	private WebElement unTextBox;
	@FindBy(id="txtPassword")
	private WebElement pTextBox;
	@FindBy(id="btnLogin")
	private WebElement loginbtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setLogin(String un, String pwd) {
		unTextBox.sendKeys(un);
		pTextBox.sendKeys(pwd);
		loginbtn.click();

	}

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage lp = new LoginPage(driver);
		lp.setLogin("Admin", "admin123");
	}

}
