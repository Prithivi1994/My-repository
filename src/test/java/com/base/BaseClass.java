package com.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	public static void getDriver(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		
		case "IE":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
			
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		default:
			break;
		}
	}
	public static String getPropertyValue(String key) throws IOException {
		Properties properties=new Properties();
		
		FileInputStream stream=new FileInputStream("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\AdactinHotelAutomation\\src\\test\\resources\\config.properties");
		
		properties.load(stream);
		
		String value=(String)properties.get(key);
		
		return value;

	}
	public WebElement explicitWait(WebElement element) {
		WebDriverWait wait=new  WebDriverWait(driver,30);
		WebElement until = wait.until(ExpectedConditions.visibilityOf(element));
		
		return until;

	}

	public static void getUrl(String url) {
		driver.get(url);
		
	}
	public static void manageWindow() {
		driver.manage().window().maximize();
	}
	
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public void click(WebElement element) {
		element.click();
	}
	public void clear(WebElement element) {
		element.clear();
		

	}
	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	public void sendKeys(WebElement element,String text) {
		element.sendKeys(text);	
	}
	//Waits
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//Alerts
	
	public void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	
	}
	public void dismissAlert() {
		Alert al=driver.switchTo().alert();
		al.dismiss();	
	}
	//Prompt Alert
	public void sendKeyToAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}
	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	public void selectOptionByText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectOptionByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}


	public void setRow(String getSheet,int createRow,int setCell,String entercellValue)
			throws IOException {
		File file =new File
				("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\Automation\\Excel\\Junit.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(getSheet);
		
		Row row = sheet.createRow(createRow);
	
		Cell cell = row.createCell(setCell);
		cell.setCellValue(entercellValue);
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);		
	}
	
	public void updateRowCellValueSameSheetNew(String id,String value,String getSheet,int getRow,int setCell)
			throws IOException {
		WebElement element = driver.findElement(By.id(id));
		String attribute = element.getAttribute(value);
		File file =new File
				("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\Automation\\Excel\\Maven.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(getSheet);
		
		Row row = sheet.getRow(getRow);
		Cell cell = row.createCell(setCell);
		cell.setCellValue(attribute);
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);		
	}
	
	public void updateRowCellValue(String createSheet,int createRow,int createCell,String entercellValue)
			throws IOException {
		File file =new File
				("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\Automation\\Excel\\Junit.xlsx");
	
		Workbook workbook=new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet(createSheet);
		
		Row row = sheet.createRow(createRow);
		Cell cell = row.createCell(createCell);
		cell.setCellValue(entercellValue);
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);	
		
	}
	public void setCellValue(String getSheet,int getRow,int newCell,String newData)
			throws IOException {
		File file =new File
				("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\Automation\\Excel\\Maven.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet(getSheet);
		Row row = sheet.getRow(getRow);
		Cell cell = row.createCell(newCell);
		cell.setCellValue(newData);
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);
	}
	public void setCell(String getSheet,int getRow,int newCell,String newData)
			throws IOException {
		File file =new File
				("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\Automation\\Excel\\Junit.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet(getSheet);
		Row row = sheet.getRow(getRow);
		Cell cell = row.createCell(newCell);
		cell.setCellValue(newData);
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);
	}
		
	
	public void updateCell(String getSheet,int getRow,int getCell,String oldData,String newData)
			throws IOException {
		File file =new File
				("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\Automation\\Excel\\Maven.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet(getSheet);
		Row row = sheet.getRow(getRow);
		Cell cell = row.getCell(getCell);
		
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);	
		}
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);
		
		
		
	}
	public String getData(String getSheet,int getRow,int getCell) throws IOException {
		String data=null;
		
		File file=new File("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\Automation\\Excel\\Junit.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(getSheet);
		Row row = sheet.getRow(getRow);
		Cell cell = row.getCell(getCell);
		
		CellType Type = cell.getCellType();
		
		switch (Type) {
		case STRING:
			data = cell.getStringCellValue();
			System.out.println(data);
			
			break;
			
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) 
			{
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yy");
				data= dateFormat.format(date);
				System.out.println(data);
				
			} else {
				double d = cell.getNumericCellValue();
				BigDecimal b=BigDecimal.valueOf(d);
				data = b.toString();
				System.out.println(data);

			}
			break;
				
		default:
			break;
		}
		return data;	
	}
	
	
	

	public void enteredUrl(String Url) {
		driver.get(Url);
	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public WebElement findElementbyId(String attributeValue) {
		WebElement element=driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement dropdownSelection(String attributeValue,int index) {
		WebElement element=driver.findElement(By.name(attributeValue));
		Select select=new Select(element);
		select.selectByIndex(index);
		
		
		return element;

	}
	public void dropdownSeletionByIndex(String attributeValue,String sheet,int index,int rowIndex,int cellIndex) throws IOException {
		WebElement element=driver.findElement(By.name(attributeValue));
		
		Select select=new Select(element);
		File file =new File
				("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace\\Automation\\Excel\\Maven.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		
		Sheet sheet1 = workbook.getSheet(sheet);
		
		select.selectByIndex(index);
		List<WebElement> options = select.getOptions();
		WebElement webElement = options.get(index);
		
		String text = webElement.getText();
		Row row = sheet1.getRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(text);
		
		FileOutputStream out=new FileOutputStream(file);
		
		workbook.write(out);	

	}
	public WebElement sendKeysBytext(String attributeValue, String text) {
		WebElement element=driver.findElement(By.name(attributeValue));
		element.sendKeys(text);	
		
		return element;
	}
	
	public WebElement findElementByXpath(String tagName,String attributeName,String attributeValue) {
		WebElement element = driver.findElement
				(By.xpath("//"+tagName+"[@"+attributeName+"='"+attributeValue+"']"));
		return element;		
	}

	public void clickOption(WebElement element) {
		element.click();
		
	}
	public void waits() throws InterruptedException {
		Thread.sleep(5000);

	}

	
	
	
	
		
				
		
	

}
