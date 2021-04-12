package keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webdriver {
	public  WebDriver driver;
	public Properties prop;
	public WebDriver launch(String browsername){
		switch(browsername){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "E:\\WorkSpace\\Drivers&API's\\chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		     break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "E:\\WorkSpace\\Drivers&API's\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		     break;
		default:
			break;
	}
		return driver;
	}
	
	public Properties init_prop(){
		try{
		FileInputStream fi=new FileInputStream("E:\\WorkSpace\\KeyWordDriven\\src"
				+ "\\main\\java\\keyword\\scenario\\Keywords.xlsx");
		prop=new Properties();
		prop.load(fi);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException i){
		i.printStackTrace();
	}
		return prop;
	}
}
