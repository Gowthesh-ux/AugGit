package org.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor javascriptExecutor;
	File file;
	Workbook book;
	Sheet sheet;
	Row row;
	Cell cell;
	public void getDriver(String browserType) {

		//BROWSER TYPE
		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			System.err.println("Invalid Browser Type");
			break;
		}

	}

	// Alert
	public void acceptAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	// Alert
	public void confirmAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	// ACTIONS
	public void allActions(WebElement pass, String action) {
		Actions a = new Actions(driver);

		switch (action) {
		case "MouseHover":
			a.moveToElement(pass).click().perform();

			break;

		case "Click":
			a.click(pass).perform();

			break;
		case "Doubleclick":
			a.doubleClick(pass).perform();

			break;
		case "Rightclick":
			a.contextClick(pass).perform();

			break;
		default:
			System.out.println("Invalid actions performed");
			break;
		}

	}

	// WINDOWSHANDLE
	public String windowsHandlesIn(int num) {
		String parentId = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();

		List<String> list = new LinkedList<>();
		list.addAll(allWindow);
		String childWindowId = list.get(num);
		return childWindowId;

	}

	public void switchToWindowHandles(String all) {
		driver.switchTo().window(all);

	}

	// GET ATTRIBUTE
	public String getAttributeByJava(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// Get TEXT
	private String getTextForElement(WebElement reference) {
		String text = reference.getText();
		return text;

	}

	// JAVASCRIPTEXECUTOR

	public void sendkeysByJs(WebElement element, String keys) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("argument[0].setAttribute('value''" + keys + "')", element);

	}

	// JAVASCRIPTEXECUTOR
	public void clickbyJavaScript(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("argument[0].click()", element);
	}

	// JAVASCRIPTEXECUTOR
	public void scrollByJavaScript(WebElement element, String scroll) {
		javascriptExecutor = (JavascriptExecutor) driver;
		switch (scroll) {
		case "Up":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", element);

			break;
		case "Down":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);

			break;
		default:
			System.out.println("Invalid");
			break;
		}

	}
	public String getCurrentUrl() {

		return driver.getCurrentUrl();
	}

	// MAXIMIZE WINDOWS
	public void winMax() {
		driver.manage().window().maximize();

	}

	// TO GET THE URL
	public void getUrl(String url) {
		driver.get(url);

	}

//TO SEND THE KEYS TO THE ELEMENT
	public void passKeysinElememt(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);

	}

	// SELECT
//SELECT BY INDEX
	public void selectByIndex(WebElement index, int number) {
		Select select2 = new Select(index);
		select2.selectByIndex(number);

	}

//SELECTBYVALUE
	public void selectByValue(WebElement ref, String value) {
		Select select = new Select(ref);
		select.selectByValue(value);

	}

	// SELECT BY VISIBLE TEXT
	private void selectByVisibleText(WebElement element, String text) {
		Select select3 = new Select(element);
		select3.deselectByVisibleText(text);
	}

//SWITCH TO FRAMES by INDEX
	public void switchFramesByIndex(int num) {
		driver.switchTo().frame(num);

	}

	// SWITCH TO FRAMES by Name
	public void switchFramesByName(String name) {
		driver.switchTo().frame(name);
	}

	// SWITCH TO FRAMES by WEBELEMENT REFERENCE
	public void switchFramesByReference(WebElement element) {
		driver.switchTo().frame(element);

	}

	// TAKESCREENSHOT
	public void screenCapture(String name) {
		try {
			TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
			File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
			File targetFile = new File(
					"C:\\Users\\GOWTHESH SIVA\\eclipse-workspace\\GetData\\ScreenShot\\" + name + ".png");
			FileUtils.copyFile(sourceFile, targetFile);

		} catch (Exception e) {

		}

	}
	
	
	public void writeExcel(WebElement element,int createRownum, int createCellNum) throws IOException {
		
			cell= sheet.createRow(createRownum).createCell(createCellNum);
			
		if (element.isDisplayed()) {
			cell.setCellValue("PASS");
			
		} else {
			cell.setCellValue("FAIL");

		}
		FileOutputStream outputStream = new FileOutputStream(file);

		book.write(outputStream);

		}
		
		public void userDefinedExcel(WebElement element,int createRownum, int createCellNum,String value) throws IOException {
			row=sheet.createRow(createRownum);
			cell = row.createCell(createCellNum);
			
			if (element.isDisplayed()) {
				cell.setCellValue(value);
			}
			FileOutputStream outputStream = new FileOutputStream(file);

			book.write(outputStream);

		}
		


//TO READ THE VALUES FROM EXCEL
	public String readExcel(int rowNum, int cellNum) {
		String value = null;

		try {
			file = new File("C:\\Users\\GOWTHESH SIVA\\Desktop\\AdactinDetails.xlsx");
			FileInputStream inputStream = new FileInputStream(file);
			book = new XSSFWorkbook(inputStream);
			sheet = book.getSheet("Sheet1");
			row = sheet.getRow(rowNum);
			cell = row.getCell(cellNum);
			CellType cellType = cell.getCellType();

			switch (cellType) {
			case STRING:
				value = cell.getStringCellValue();

				break;

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					value = simpleDateFormat.format(dateCellValue);

				} else {
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					value = valueOf.toString();
				}

				break;

			default:
				break;
			}

		} catch (Exception e) {

		}

		return value;

	}
	public void page(String app) throws AWTException {

		Robot robot = new Robot();
		switch (app) {
		case "Up":
			robot.keyPress(KeyEvent.VK_KP_UP);
			break;
		case "Down":
			robot.keyPress(KeyEvent.VK_KP_DOWN);
			break;
		case "Left":
			robot.keyPress(KeyEvent.VK_KP_LEFT);
			break;
		case "Right":
			robot.keyPress(KeyEvent.VK_KP_RIGHT);
			break;

		default:
			System.out.println("InValid Page Function");
			break;
		}
	}

}
