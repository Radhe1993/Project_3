package browserfactory;

import org.openqa.selenium.By;

public class Utility extends BaseTest
{
    public void mousehover(By by)
    {
        driver.findElement(by).click();
    }
    public void remove(By by,String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);

    }
}
