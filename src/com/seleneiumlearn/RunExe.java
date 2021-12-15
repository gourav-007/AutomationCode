package com.seleneiumlearn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunExe {

	public static void main(String[] args) throws IOException {
		
		Runtime.getRuntime().exec("C:/Windows/system32/calc.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

	}

}
