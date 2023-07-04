package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GearTest extends Utility
{
    @Before
    public void setUpUrl()
    {
        openBrowser();
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //Mouse Hover on Gear Menu

        WebElement gesr = driver.findElement(By.xpath("//a[@id='ui-id-6']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        Actions action = new Actions(driver);
        action.moveToElement(gesr).build().perform();

        //Click on Bags
        mousehover(By.xpath("//span[contains(text(),'Bags')]"));

        //Click on Product Name ‘Overnight Duffle’
        mousehover(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        Thread.sleep(2000);

        //Verify the text ‘Overnight Duffle
        WebElement message = driver.findElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        System.out.println("message = " + message.getText());
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        Collections.sort(expected);
        Assert.assertTrue(actual.equals(expected));
        Thread.sleep(2000);

        //Change Qty 3
        remove(By.xpath("//input[@class='input-text qty']"),"3");
        //Click on ‘Add to Cart’ Button
        mousehover(By.xpath("//button[@id='product-addtocart-button']"));

        //Verify the text
        //‘You added Overnight Duffle to your shopping cart.’
        WebElement message1 = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        System.out.println("message = " + message1.getText());
        List<String> actual1 = new ArrayList<>();
        List<String> expected1 = new ArrayList<>();
        Collections.sort(expected1);
        Assert.assertTrue(actual1.equals(expected1));
        Thread.sleep(2000);

        //Click on ‘shopping cart’ Link into
        //message
        mousehover(By.xpath("//a[contains(text(),'shopping cart')]"));



        //Verify the Qty is ‘3’
        WebElement message4 = driver.findElement(By.id("cart-237877-qty"));
        List<String> actual4 = new ArrayList<>();
        List<String> expected4 = new ArrayList<>();
        Collections.sort(expected4);
        Assert.assertTrue(actual4.equals(expected4));
        Thread.sleep(2000);


        //Verify the product price ‘$135.00’
        WebElement message3 = driver.findElement(By.xpath("//span[@class='price']"));
        List<String> actual3 = new ArrayList<>();
        List<String> expected3 = new ArrayList<>();
        Collections.sort(expected3);
        Assert.assertTrue(actual3.equals(expected3));
        Thread.sleep(2000);

    

    }
    @After
    public void close()
    {
        closeBrowser();
    }
}

