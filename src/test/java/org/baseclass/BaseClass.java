package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static void launchurl(String url) {
		driver.get(url);

	}

	public static void fillTextBox(WebElement e, String value) {

		e.sendKeys(value);

	}

	public static String getText(WebElement e) {
		return e.getText();

	}

	public static void clearTextBox(WebElement e) {
		e.clear();

	}

	public static void closeCurrentTab() {
		driver.close();

	}

	public static void browserQuit() {
		driver.quit();

	}

	public static void currentTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void currentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);

	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static String datadriven(int Rowno, int Cellno) throws IOException {
		File loc = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Dummy.xlsx");
		FileInputStream is = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(is);
		Sheet s = w.getSheet("Sheet2");
		Row r = s.getRow(Rowno);
		Cell c = r.getCell(Cellno);
		int type = c.getCellType();
		String value = null;
		if (type == 1) {
			value = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat sf = new SimpleDateFormat("d/MMM/yyyy");
			value = sf.format(date);
		} else {
			double db = c.getNumericCellValue();
			long lg = (long) db;
			value = String.valueOf(lg);
			System.out.println(value);
		}
		return value;

	}

	public static void javaScript(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);

	}

	public static void selectDate(String date, WebElement e, WebElement e1) throws InterruptedException {
		String[] split = date.split("-");
		String dt = split[0];
		String mon = split[1];
		for (int i = 0; i < 15; i++) {
			String month = e.getText();
			if (month.equals(mon)) {
				break;
			}
			WebElement next = e1;
			javaScript(next);

		}
		driver.findElement(By.linkText(dt)).click();

	}

	public static void screenShot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File temp = tk.getScreenshotAs(OutputType.FILE);
		File perm = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShot\\" + name + ".png");
		FileUtils.copyFile(temp, perm);

	}

	public static void selectDocu(WebElement e, String text) {
		WebElement selectDocu = e;
		Select s = new Select(selectDocu);
		s.selectByVisibleText(text);

	}

	public static void explicitWait(WebElement e, String name) throws IOException {
		WebDriverWait w = new WebDriverWait(driver, 40);
		w.until(ExpectedConditions.visibilityOf(e));
		screenShot(name);

	}

}
