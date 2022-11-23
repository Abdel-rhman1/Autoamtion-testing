package demo;

import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

    String path = "F:\\Fourth_Level Second Term\\Software Testing\\Assigment#2\\Assigment#2_20180158_20180119\\Task_2\\Task_2\\";
    
    public String getCellData(int row, int col) throws Exception {
        XSSFSheet ExcelWSheet;
        XSSFWorkbook ExcelWBook;
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(path + "Login.xlsx");
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
            String cellData = ExcelWSheet.getRow(row).getCell(col).getStringCellValue();
            ExcelWBook.close();
            return cellData;
        }
        catch (IOException e){
            return "Error in opening the file";
        }
    }
    
    @Test
    public void FirefoxInvalidTest() throws Exception {

    	String username = getCellData(1, 0);
    	String password = getCellData(1, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://backoffice.rage3fady.com/ar/login");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div/div[2]/ul/li[2]/a")).click();

        // Enter the username and password
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[1]/div/input")).sendKeys(username);
        // Click on next
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/main/div/div[4]/div[2]/div[2]/div[2]/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div/input")).sendKeys(password);
        // Click on next
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
                      

        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false ,driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(500);
        driver.close();
    }

    @Test
    public void FirefoxValidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://backoffice.rage3fady.com/ar/login");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div/div[2]/ul/li[2]/a")).click();

        // Enter the username and password
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[1]/div/input")).sendKeys(username);
        // Click on next
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/main/div/div[4]/div[2]/div[2]/div[2]/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div/input")).sendKeys(password);
        // Click on next
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
        // Check whether a certain element appears which confirms that the login was successful
        
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true ,driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
//        assertEquals(true, driver.findElement(By.xpath("//*[@id=\\\"main-wrapper\\\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        Thread.sleep(500);
        // click test
        driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[1]/a")).click();
        Thread.sleep(500);
        // click start test
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div/a")).click();
        
      //*[@id="main-wrapper"]/app-sidbar/aside/div/nav/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[3]/p-panelmenusub/ul/li[3]/a
        driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/nav/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[3]/p-panelmenusub/ul/li[3]/a")).click();
        Thread.sleep(10000);
        driver.close();
    }
    
    @Test
    public void ChromeInvalidTest() throws Exception {

    	String username = getCellData(1, 0);
    	String password = getCellData(1, 1);

        // Set Google Chrome Web Driver
    	System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
    	WebDriver driver = new ChromeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://backoffice.rage3fady.com/ar/login");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div/div[2]/ul/li[2]/a")).click();

        // Enter the username and password
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[1]/div/input")).sendKeys(username);
        // Click on next
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/main/div/div[4]/div[2]/div[2]/div[2]/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div/input")).sendKeys(password);
        // Click on next
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
                      

        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false ,driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(500);
        driver.close();

    }

    @Test
    public void ChromeValidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Google Chrome Web Driver
    	System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
    	WebDriver driver = new ChromeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://backoffice.rage3fady.com/ar/login");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div/div[2]/ul/li[2]/a")).click();

        // Enter the username and password
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[1]/div/input")).sendKeys(username);
        // Click on next
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/main/div/div[4]/div[2]/div[2]/div[2]/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div/input")).sendKeys(password);
        // Click on next
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
        // Check whether a certain element appears which confirms that the login was successful
        
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true ,driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
//        assertEquals(true, driver.findElement(By.xpath("//*[@id=\\\"main-wrapper\\\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        Thread.sleep(500);
        // click test
        driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[1]/a")).click();
        Thread.sleep(500);
        // click start test
        driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/nav/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[3]/p-panelmenusub/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void EdgeInvalidTest() throws Exception {

    	String username = getCellData(1, 0);
    	String password = getCellData(1, 1);

        // Set Edge Web Driver
    	System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
     // Launch website
        driver.navigate().to("https://backoffice.rage3fady.com/ar/login");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div/div[2]/ul/li[2]/a")).click();

        // Enter the username and password
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[1]/div/input")).sendKeys(username);
        // Click on next
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/main/div/div[4]/div[2]/div[2]/div[2]/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div/input")).sendKeys(password);
        // Click on next
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
                      

        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false ,driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(500);
        driver.close();
    }

    @Test
    public void EdgeValidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Edge Web Driver
    	System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://backoffice.rage3fady.com/ar/login");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/header/div/div[2]/ul/li[2]/a")).click();

        // Enter the username and password
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[1]/div/input")).sendKeys(username);
        // Click on next
        //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/main/div/div[4]/div[2]/div[2]/div[2]/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div/input")).sendKeys(password);
        // Click on next
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
        // Check whether a certain element appears which confirms that the login was successful
        
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true ,driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
//        assertEquals(true, driver.findElement(By.xpath("//*[@id=\\\"main-wrapper\\\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[1]/a")).isDisplayed());
        Thread.sleep(500);
        // click test
        driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/app-sidbar/aside/div/div[1]/nav/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[1]/a")).click();
        Thread.sleep(500);
        // click start test
      //*[@id="main-wrapper"]/app-sidbar/aside/div/nav/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[3]/p-panelmenusub/ul/li[3]/a
        Thread.sleep(10000);
        driver.close();
    }
	
}
