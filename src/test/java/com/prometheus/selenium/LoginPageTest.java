package com.prometheus.selenium;

import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ PrometheusListeners.class })
public class LoginPageTest {

    @BeforeClass
    public void setUp() throws MalformedURLException {

    }

    @Test
    public void shouldOpenUrl() {

    }

    @AfterClass
    public void tearDown() {

    }

}
