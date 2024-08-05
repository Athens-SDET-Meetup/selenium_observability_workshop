package com.prometheus.selenium;
import pl.mjaron.tinyloki.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ PrometheusListeners.class })
public class LoginPageTest {

    private WebDriver driver;

    private LogController logController = TinyLoki
        .withUrl("http://localhost:3100/loki/api/v1/push")
        .start();

    private ILogStream stream = logController.stream()
        .info()
        .l("conference", "AutomationStar")
        .build();



    @BeforeClass
    public void setUp() throws MalformedURLException {
        ChromeOptions chrome = new ChromeOptions();
        stream.log("About to initialize chrome instance in Selenium Grid");
        try {
            this.driver = new RemoteWebDriver(new URL("http://localhost:4444"), chrome);
            stream.log("Chrome instance initialized");
            WebdriverEventListener eventListener = new WebdriverEventListener();
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
            this.driver = decorator.decorate(this.driver);
        } catch (Exception ex){
            stream.log(String.format("Selenium Grid Issue %s!!", ex.getMessage()));
            throw ex;
        }

    }

    @Test
    public void shouldOpenUrl() {
        this.driver.get("https://the-internet.herokuapp.com/login");

        this.driver.findElement(By.id("username")).sendKeys("tomsmith");
        this.driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        this.driver.findElement(By.cssSelector("[type='submit']")).click();
        Assert.assertEquals("Secure Area", this.driver.findElement(By.tagName("h2")).getText(),
                "Asserting header of the page");
    }

    @AfterClass
    public void tearDown() {
        this.driver.close();
        logController.softStop().hardStop();
    }

}
