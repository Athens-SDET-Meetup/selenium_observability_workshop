package com.prometheus.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import pl.mjaron.tinyloki.ILogStream;
import pl.mjaron.tinyloki.LogController;
import pl.mjaron.tinyloki.TinyLoki;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class WebdriverEventListener implements WebDriverListener {

    private LogController logController = TinyLoki
        .withUrl("http://localhost:3100/loki/api/v1/push")
        .start();

    private ILogStream stream = logController.stream()
        .info()
        .l("conference", "AutomationStar")
        .build();

    public void beforeAnyCall(Object target, Method method, Object[] args) {
        System.out.println("Before calling method: " + method.getName());
        stream.log("Before calling method: " + method.getName());
    }

    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
        stream.log("After calling method: " + method.getName());
    }

    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        stream.log("Error while calling method: " + method.getName() + " - " + e.getMessage());
    }

    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
        stream.log("Before calling WebDriver method: " + method.getName());
    }

    public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
        stream.log("After calling WebDriver method: " + method.getName());
    }

    public void beforeGet(WebDriver driver, String url) {
        stream.log("Before navigating to URL: " + url);
    }

    public void afterGet(WebDriver driver, String url) {
        stream.log("After navigating to URL: " + url);
    }

    public void beforeGetCurrentUrl(WebDriver driver) {
        stream.log("Before getting current URL.");
    }

    public void afterGetCurrentUrl(String result, WebDriver driver) {
        stream.log("After getting current URL: " + result);
    }

    public void beforeGetTitle(WebDriver driver) {
        stream.log("Before getting page title.");
    }

    public void afterGetTitle(WebDriver driver, String result) {
        stream.log("After getting page title: " + result);
    }

    public void beforeFindElement(WebDriver driver, By locator) {
        stream.log("Before finding element by: " + locator);
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        stream.log("After finding element by: " + locator);
    }

    public void beforeFindElements(WebDriver driver, By locator) {
        stream.log("Before finding elements by: " + locator);
    }

    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        stream.log("After finding elements by: " + locator);
    }

    public void beforeGetPageSource(WebDriver driver) {
        stream.log("Before getting page source.");
    }

    public void afterGetPageSource(WebDriver driver, String result) {
        stream.log("After getting page source.");
    }

    public void beforeClose(WebDriver driver) {
        stream.log("Before closing the WebDriver.");
    }

    public void afterClose(WebDriver driver) {
        stream.log("After closing the WebDriver.");
    }

    public void beforeQuit(WebDriver driver) {
        stream.log("Before quitting the WebDriver.");
    }

    public void afterQuit(WebDriver driver) {
        stream.log("After quitting the WebDriver.");
    }

    public void beforeGetWindowHandles(WebDriver driver) {
        stream.log("Before getting window handles.");
    }

    public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
        stream.log("After getting window handles.");
    }

    public void beforeGetWindowHandle(WebDriver driver) {
        stream.log("Before getting window handle.");
    }

    public void afterGetWindowHandle(WebDriver driver, String result) {
        stream.log("After getting window handle.");
    }

    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
        stream.log("Before executing script: " + script);
    }

    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
        stream.log("After executing script: " + script);
    }

    public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {
        stream.log("Before executing async script: " + script);
    }

    public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {
        stream.log("After executing async script: " + script);
    }

    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
        stream.log("Before performing actions.");
    }

    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
        stream.log("After performing actions.");
    }

    public void beforeResetInputState(WebDriver driver) {
        stream.log("Before resetting input state.");
    }

    public void afterResetInputState(WebDriver driver) {
        stream.log("After resetting input state.");
    }

    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
        stream.log("Before calling WebElement method: " + method.getName());
    }

    public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
        stream.log("After calling WebElement method: " + method.getName());
    }

    public void beforeClick(WebElement element) {
        stream.log("Before clicking on element.");
    }

    public void afterClick(WebElement element) {
        stream.log("After clicking on element.");
    }

    public void beforeSubmit(WebElement element) {
        stream.log("Before submitting a form element.");
    }

    public void afterSubmit(WebElement element) {
        stream.log("After submitting a form element.");
    }

    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        stream.log("Before sending keys to element.");
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        stream.log("After sending keys to element.");
    }

    public void beforeClear(WebElement element) {
        stream.log("Before clearing the text of an element.");
    }

    public void afterClear(WebElement element) {
        stream.log("After clearing the text of an element.");
    }

    public void beforeGetTagName(WebElement element) {
        stream.log("Before getting the tag name of an element.");
    }

    public void afterGetTagName(WebElement element, String result) {
        stream.log("After getting the tag name of an element: " + result);
    }

    public void beforeGetAttribute(WebElement element, String name) {
        stream.log("Before getting an attribute of an element: " + name);
    }

    public void afterGetAttribute(WebElement element, String name, String result) {
        stream.log("After getting an attribute of an element: " + name);
    }

    public void beforeIsSelected(WebElement element) {
        stream.log("Before checking if element is selected.");
    }

    public void afterIsSelected(WebElement element, boolean result) {
        stream.log("After checking if element is selected: " + result);
    }

    public void beforeIsEnabled(WebElement element) {
        stream.log("Before checking if element is enabled.");
    }

    public void afterIsEnabled(WebElement element, boolean result) {
        stream.log("After checking if element is enabled: " + result);
    }

    public void beforeGetText(WebElement element) {
        stream.log("Before getting text from element.");
    }

    public void afterGetText(WebElement element, String result) {
        stream.log("After getting text from element: " + result);
    }

    public void beforeFindElement(WebElement element, By locator) {
        stream.log("Before finding element within element: " + locator);
    }

    public void afterFindElement(WebElement element, By locator, WebElement result) {
        stream.log("After finding element within element: " + locator);
    }

    public void beforeFindElements(WebElement element, By locator) {
        stream.log("Before finding elements within element: " + locator);
    }

    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        stream.log("After finding elements within element: " + locator);
    }
}