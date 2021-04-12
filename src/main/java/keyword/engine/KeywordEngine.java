package keyword.engine;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import keyword.base.Webdriver;

public class KeywordEngine{
	public Webdriver wd=new Webdriver();
	WebDriver driver;
	public WebElement ele;
	public static Workbook book;
	public static Sheet sheet;
	public  String keywordxlpath="E:\\WorkSpace\\KeyWordDriven\\src\\main\\java\\keyword\\scenario\\Keywords.xlsx";
	
	
	public void Start(String sheetname) {
		String locatorname="x";
		String locatorvalue="x";
	try{
		FileInputStream fi =new FileInputStream(keywordxlpath);
	book=new XSSFWorkbook(fi);
	}catch(IOException e){
		e.printStackTrace();
	}
	sheet=book.getSheet(sheetname);
	int rowcount=sheet.getLastRowNum();
	for(int i=1;i<=rowcount;i++){
		try{
		String locator=sheet.getRow(i).getCell(1).toString().trim();
		if(!locator.equalsIgnoreCase("NA")){
			String[] x=locator.split("=");
		  locatorname=x[0].toString();
		  locatorvalue=x[1].toString();
		}
		String action=sheet.getRow(i).getCell(2).toString().toString();
		String value=sheet.getRow(i).getCell(3).toString().toString();
		switch (action.toLowerCase()) {
		case "open browser":
	    driver=wd.launch(value);
			break;
		case "enter url":
			driver.get(value);
	   break;
		case "quit":
			Thread.sleep(3000);
			driver.close();
			break;
		default:
			break;
		}
		switch(locatorname){
		case "id":
			ele=driver.findElement(By.id(locatorvalue));
			if(action.equalsIgnoreCase("sendkeys")){
				ele.clear();
				ele.sendKeys(value);
				Thread.sleep(2000);
			}else if(action.equalsIgnoreCase("click")){
				ele.click();
				Thread.sleep(2000);
			}else if(action.equalsIgnoreCase("select")){
				Select sel=new Select(ele);
				sel.selectByVisibleText(value);
				Thread.sleep(2000);
			}
			break;
		case "name":
			ele=driver.findElement(By.name(locatorvalue));
			if(action.equalsIgnoreCase("sendkeys")){
				ele.sendKeys(value);
				Thread.sleep(4000);
			}else if(action.equalsIgnoreCase("click")){
				ele.click();
			}
			break;
		case "xpath":
			ele=driver.findElement(By.xpath(locatorvalue));
			if(action.equalsIgnoreCase("sendkeys")){
				ele.sendKeys(value);
				Thread.sleep(2000);
			}else if(action.equalsIgnoreCase("click")){
				ele.click();
			}
			break;
		case "linktext":
			ele=driver.findElement(By.linkText(locatorvalue));
			if(action.equalsIgnoreCase("sendkeys")){
				ele.clear();
				ele.sendKeys(value);
				Thread.sleep(2000);
			}else if(action.equalsIgnoreCase("click")){
				ele.click();
			}
			break;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
}