package review;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LabSessionPractice {
    public static void main(String[] args) {
    	
            
    	// Setup the WebDriver manager       
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://ksrtc.in/oprs-web/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement crm = driver.findElement(By.xpath("//p[text()='CRM']"));
        timeWait();
        System.out.println(driver.getTitle() + " before clicking on CRM");
        
        crm.click();
        
        
        
        
        /*         * In Selenium if we need to switch from one window to another window     
         *      * we need to use a method called WindowHandles and the return type of      
         *          * this method is Set         *        
         *            
         *            */  
        
        Set<String> handles = driver.getWindowHandles();
        
        // we use Iterator Interface to iterate through the Set of Widow Handles  
         // and we use .next method to store the value of the set.   
         // syntax for Iterator: Iterator<dataType> variableName = Variable Name of Collection.iterator Method 
         
         
        Iterator <String> iterator = handles.iterator();
        String parentWindowID = iterator.next();
        String childWindowID = iterator.next();
        System.out.println(parentWindowID + " parent");
        System.out.println(childWindowID+ " child");
        driver.switchTo().window(childWindowID);
        System.out.println(driver.getTitle() + " after clicking on CRM");
        
        // challenge : close the current tab and switch back to parent and print        
        // title of parent page. - 3 min   
        
        driver.close();
        driver.switchTo().window(parentWindowID);
        System.out.println(driver.getTitle()+ " back to parent window");
        
        // click on Search button         
        
        WebElement search = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking']"));
        search.click();
        
        
        // in Selenium WebDriver there is a method called switchTo().Alert()        
        // .accept()            .dismiss()          getText 
        
        driver.switchTo().alert().accept();
        
        // in Selenium we can automate WebBased Authentication by passing username       
        // and password with in the url following below syntax:       
        // http://userName:password@baseURL       
        // website: http://the-internet.herokuapp.com/basic_auth       
        // userName: admin         // password: admin      
        // http://admin:admin@the-internet.herokuapp.com/basic_auth      
        // for example: https:tekschool.us student  1234        
        // https://student:1234@tekschool.us   
        
        
        driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
    public static void timeWait() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
                     
        	e.printStackTrace();
        }
    }
}