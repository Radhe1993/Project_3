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

public class MenTest extends Utility
{
    @Before
    public void setUpUrl()
    {
        openBrowser();
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //Mouse Hover on Men Menu
        WebElement men = driver.findElement(By.xpath("//ul[@id='ui-id-2']//span[text()='Men']"));
        Actions action = new Actions(driver);
        action.moveToElement(men).build().perform();

        //Mouse Hover on Bottoms
        WebElement Bottom = driver.findElement(By.xpath("//a[@id='ui-id-18']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Bottom).build().perform();
        Thread.sleep(2000);
        //Click on Pants
        mousehover(By.xpath("//a[@id='ui-id-23']//span[text()='Pants']"));

        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size
        WebElement name = driver.findElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(name).build().perform();
        mousehover(By.cssSelector("#option-label-size-143-item-175"));
        Thread.sleep(2000);

        //* Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on colour
        //Black
        WebElement productName = driver.findElement(By.cssSelector("#option-label-color-93-item-49"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(productName).build().perform();
        Thread.sleep(2000);

        //Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on
        //‘Add To Cart’ Button.
        mousehover(By.xpath("//span[text()='Add to Cart']"));
        Thread.sleep(2000);
        mousehover(By.id("option-label-size-143-item-175"));
        mousehover(By.id("option-label-color-93-item-49"));
        mousehover(By.xpath("//span[text()='Add to Cart']"));


        //Verify the text
        //‘You added Cronus Yoga Pant to your shopping cart.’

        WebElement actual1 = driver.findElement(By.cssSelector("body.page-product-configurable.catalog-product-view.product-cronus-yoga-pant.page-layout-1column:nth-child(2) div.page-wrapper:nth-child(4) main.page-main div.page.messages:nth-child(2) div:nth-child(2) div.messages div.message-success.success.message > div:nth-child(1)"));
        System.out.println("message = " + actual1.getText());
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        Collections.sort(expected);
        Assert.assertTrue(actual.equals(expected));

        //Click on ‘shopping cart’ Link into
        //message
        mousehover(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Verify the text ‘Shopping Cart.’
        WebElement message = driver.findElement(By.xpath("//body/div[1]/main[1]/div[1]/h1[1]/span[1]"));
        System.out.println("message = " + message.getText());
        List<String> actual2 = new ArrayList<>();
        List<String> expected2 = new ArrayList<>();
        Collections.sort(expected);
        Assert.assertTrue(actual2.equals(expected2));

        //Verify the product name ‘Cronus Yoga Pant’
        WebElement message1 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]"));
        System.out.println("message = " + message1.getText());
        List<String> actual3 = new ArrayList<>();
        List<String> expected3 = new ArrayList<>();
        Collections.sort(expected);
        Assert.assertTrue(actual3.equals(expected2));

        //Verify the product size ‘32’
        WebElement message2 = driver.findElement(By.xpath("//dd[contains(text(),'32')]"));
        System.out.println("message = " + message2.getText());
        List<String> actual4 = new ArrayList<>();
        List<String> expected4 = new ArrayList<>();
        Collections.sort(expected);
        Assert.assertTrue(actual4.equals(expected2));

        //Verify the product colour ‘Black’
        WebElement message3 = driver.findElement(By.xpath("//dd[contains(text(),'Black')]"));
        System.out.println("message = " + message3.getText());
        List<String> actual5 = new ArrayList<>();
        List<String> expected5 = new ArrayList<>();
        Collections.sort(expected);
        Assert.assertTrue(actual5.equals(expected2));

    }
        @After
        public void close()
        {
            closeBrowser();
        }

}
