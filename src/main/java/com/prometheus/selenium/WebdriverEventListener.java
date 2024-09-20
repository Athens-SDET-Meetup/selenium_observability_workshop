package com.prometheus.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class WebdriverEventListener implements WebDriverListener {

    public void beforeAnyCall(Object target, Method method, Object[] args) {
        System.out.println("Before calling method: " + method.getName());
    }

    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
    }

    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
    }

    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
    }

    public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
    }

    public void beforeGet(WebDriver driver, String url) {
    }

    public void afterGet(WebDriver driver, String url) {
    }

    public void beforeGetCurrentUrl(WebDriver driver) {
    }

    public void afterGetCurrentUrl(String result, WebDriver driver) {
    }

    public void beforeGetTitle(WebDriver driver) {
    }

    public void afterGetTitle(WebDriver driver, String result) {
    }

    public void beforeFindElement(WebDriver driver, By locator) {
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    }

    public void beforeFindElements(WebDriver driver, By locator) {
    }

    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
    }

    public void beforeGetPageSource(WebDriver driver) {
    }

    public void afterGetPageSource(WebDriver driver, String result) {
    }

    public void beforeClose(WebDriver driver) {
    }

    public void afterClose(WebDriver driver) {
    }

    public void beforeQuit(WebDriver driver) {
    }

    public void afterQuit(WebDriver driver) {
    }

    public void beforeGetWindowHandles(WebDriver driver) {
    }

    public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
    }

    public void beforeGetWindowHandle(WebDriver driver) {
    }

    public void afterGetWindowHandle(WebDriver driver, String result) {
    }

    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
    }

    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
    }

    public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {
    }

    public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {
    }

    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
    }

    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
    }

    public void beforeResetInputState(WebDriver driver) {
    }

    public void afterResetInputState(WebDriver driver) {
    }

    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
    }

    public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
    }

    public void beforeClick(WebElement element) {
    }

    public void afterClick(WebElement element) {
    }

    public void beforeSubmit(WebElement element) {
    }

    public void afterSubmit(WebElement element) {
    }

    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    }

    public void beforeClear(WebElement element) {
    }

    public void afterClear(WebElement element) {
    }

    public void beforeGetTagName(WebElement element) {
    }

    public void afterGetTagName(WebElement element, String result) {
    }

    public void beforeGetAttribute(WebElement element, String name) {
    }

    public void afterGetAttribute(WebElement element, String name, String result) {
    }

    public void beforeIsSelected(WebElement element) {
    }

    public void afterIsSelected(WebElement element, boolean result) {
    }

    public void beforeIsEnabled(WebElement element) {
    }

    public void afterIsEnabled(WebElement element, boolean result) {
    }

    public void beforeGetText(WebElement element) {
    }

    public void afterGetText(WebElement element, String result) {
    }

    public void beforeFindElement(WebElement element, By locator) {
    }

    public void afterFindElement(WebElement element, By locator, WebElement result) {
    }

    public void beforeFindElements(WebElement element, By locator) {
    }

    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
    }
}