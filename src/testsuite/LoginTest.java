package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setBaseUrl()
    {
        openUrl();
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Verify the text ‘Welcome Back!’
        String expected = "Welcome Back!";
        String actual = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        System.out.println(actual);
        Assert.assertEquals(" should be display",expected,actual);
    }
    @Test
    public void verifyTheErrorMessage()
    {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("om@gmail.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("1122334455");
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message ‘Invalid email or password
        String expected = "Invalid email or password.";
        String actual =  driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        System.out.println(actual);
        Assert.assertEquals("Message is valid",expected,actual);
    }

}
