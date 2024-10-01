package com.prometheus.selenium;

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
public class NavigateToURLTest {

    private WebDriver driver;
    
    @BeforeClass
    public void setUp() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        try {
            this.driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
            WebdriverEventListener eventListener = new WebdriverEventListener();
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
            this.driver = decorator.decorate(this.driver);
        } catch (Exception ex){
            throw ex;
        }
    }

    @Test
    public void shouldOpenUrl() {
        this.driver.get("https://the-internet.herokuapp.com/");
        Assert.assertEquals("Welcome to the-internet", this.driver.findElement(By.tagName("h1")).getText(),
                "Asserting header of the page");
    }

    @Test
    public void shouldAuthenticate() {
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
    }

}
