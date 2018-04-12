package com.eliasnogueira.utils;

import com.eliasnogueira.exception.BrowserNotSupportedException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.eliasnogueira.utils.Utils.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void preCondicao(@Optional("chromee") String browser) throws MalformedURLException, BrowserNotSupportedException {
        driver = getDriver(browser);
    }

    @AfterMethod
    public void posCondicao() {
        driver.quit();
    }

    /**
     * Return a new RemoteWebDriver instance based on the grid for a given browser
     * @param browser a browser that will run the test
     * @return a new RemoteWebDriver instance
     * @throws Exception if the browser is not mapped
     */
    private static WebDriver getDriver(String browser) throws BrowserNotSupportedException, MalformedURLException {

        // a composition of the target grid address and port
        String gridURL;

        if (getValueFromConf("grid.port").isEmpty()) {
            gridURL = getValueFromConf("grid.url") + "/wd/hub";
        } else {
            gridURL = getValueFromConf("grid.url") + ":" + getValueFromConf("grid.port") + "/wd/hub";
        }

        return new RemoteWebDriver(new URL(gridURL), returnCapability(browser));
    }

    /**
     * Return a DesiredCapability for a given browser
     * @param browser the browser name. Allowed browsers are: chrome, firefox, ie-11
     * @return a DesiredCapability
     * @throws Exception if the browser is not mapped
     */
    private static DesiredCapabilities returnCapability(String browser) throws BrowserNotSupportedException {
        DesiredCapabilities desiredCapabilities;

        switch (browser.toLowerCase()) {

            case "chrome":
                desiredCapabilities = DesiredCapabilities.chrome();
                break;

            case "firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                break;

            case "ie-11":
                desiredCapabilities = DesiredCapabilities.internetExplorer();
                desiredCapabilities.setPlatform(Platform.WINDOWS);
                break;

            default:
                throw new BrowserNotSupportedException("Browser not supported or misspelled: " + browser);
        }

        return desiredCapabilities;
    }
}
