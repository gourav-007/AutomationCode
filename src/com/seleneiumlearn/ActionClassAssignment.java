package com.seleneiumlearn;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionClassAssignment {
		static WebDriver driver;

		public void dropDownList(String text) throws Exception {

			WebElement dropselect = driver.findElement(By.id(text));
			Select select = new Select(dropselect);
			List<WebElement> droplist = select.getOptions();
			for(WebElement elemen:droplist) {
				System.out.println(elemen.getText());
				Thread.sleep(1000);
			}
		}

		public static void main(String[] args) throws Exception {

			System.setProperty("webdriver.chrome.driver", "C://Users//Training1.WIN-NFDCINOH1RK//Desktop//chromedriver.exe");
			driver = new ChromeDriver();

			driver.get("https://testautomationpractice.blogspot.com/");

			ChromeOptions co = new ChromeOptions();
			co.setAcceptInsecureCerts(true);

			WebElement f = driver.findElement(By.id("frame-one1434677811"));
			driver.switchTo().frame(f);
			WebElement g = driver.findElement(By.id("RESULT_TextField-1"));
			g.click();

			Actions act = new Actions(driver);
			//All Uppercase
			act.keyDown(Keys.SHIFT);
			act.sendKeys("hello");
			act.keyUp(Keys.SHIFT)
			.build().perform();

			//All Checkbox should be checked.

			List<WebElement> checklist = driver.findElements(By.xpath("//*[contains(@for,'RESULT_CheckBox-8')]"));
			System.out.println(checklist.size());
			for(int i=0;i<checklist.size();i++) {
				checklist.get(i).click();
				Thread.sleep(1000);
				System.out.println(checklist.get(i).getText()+" Checked.");
			}
			System.out.println("---------------------");
			driver.switchTo().defaultContent();
			System.out.println("Enter DropDown Name : ");
			Scanner sc = new Scanner(System.in);
			String name = sc.next();

			ActionClassAssignment aca = new ActionClassAssignment();
			aca.dropDownList(name);

			//Drag and Drop

			WebElement drag = driver.findElement(By.id("draggable"));
			WebElement drop = driver.findElement(By.id("droppable"));
			act.dragAndDrop(drag, drop).build().perform();
			WebElement afterdrag = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p[text()='Dropped!']"));
			String aftertext = afterdrag.getText();
			if(aftertext.equals("Dropped!")) {
				System.out.println("Dragged and Dropped.");
			}
			else {
				System.out.println("Dragged but not dropped.");
			}


		}

	}


}
