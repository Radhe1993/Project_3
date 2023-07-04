package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    public String baseUrl = "https://magento.softwaretestingboard.com/";
    public WebDriver driver;
    public void openBrowser()
    {
        //Open browser
        driver=new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser()
    {
        driver.close();
    }


}
