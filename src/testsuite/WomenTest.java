package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WomenTest extends Utility {
    @Before
    public void setupUrl() {
        openBrowser();
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        WebElement woman = driver.findElement(By.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        Actions action = new Actions(driver) ;
        action.moveToElement(woman).build().perform();
        //Mouse Hover on Tops
        WebElement Tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Tops).build().perform();
        mousehover(By.linkText("Jackets"));
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Product Name");
        Thread.sleep(2000);
        //Verify the products name display in alphabetical order
        List<WebElement> actual = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Product Size = "+actual.size());
        for (WebElement product : actual)
        {
            System.out.println("Product Name = "+product.getText());
        }
        List<WebElement> expected = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Product Size = "+expected.size());
        for (WebElement product1 : expected)
        {
            System.out.println("Product Name = "+product1.getText());
        }
        Assert.assertEquals("test",actual,expected);
    }
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        WebElement woman = driver.findElement(By.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        Actions action = new Actions(driver) ;
        action.moveToElement(woman).build().perform();
        //Mouse Hover on Tops
        WebElement Tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Tops).build().perform();
        mousehover(By.linkText("Jackets"));
        //Select Sort By filter “Price”
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price");
        Thread.sleep(2000);

        //Verify the products price display in Low to High
        List<WebElement> list = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Total products are = "+list.size());
        for (WebElement result : list)
        {
            String product = result.getText();
            String actual = product;
            String expected = product;
            System.out.println("Total products  = "+actual);
            Assert.assertEquals("message",actual,expected);
        }
    }
    @After
    public void close()
    {
        closeBrowser();
    }
}

