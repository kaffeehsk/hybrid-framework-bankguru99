package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected void openPageUrl(WebDriver driver, String url){
        driver.get(url);
    }

    protected void maximizeBrowser(WebDriver driver){
        driver.manage().window().maximize();
    }

    protected void refreshBrowser(WebDriver driver){
        driver.navigate().refresh();
    }

    protected void forwardBrowser(WebDriver driver){
        driver.navigate().forward();
    }

    protected void backBrowser(WebDriver driver){
        driver.navigate().back();
    }

    protected void switchToIframeByIndex(WebDriver driver, int indexOfIframe){
        driver.switchTo().frame(indexOfIframe);
    }

    protected void switchToIframeByName(WebDriver driver, String nameOfIframe){
        driver.switchTo().frame(nameOfIframe);
    }

    protected void switchToIframeByWebElement(WebDriver driver, String xpathLocator){
        driver.switchTo().frame(getElement(driver, xpathLocator));
    }

    protected void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    protected WebElement getElement(WebDriver driver, String xpathLocator){
        return driver.findElement(By.xpath(xpathLocator));
    }

    protected List<WebElement> getElementList(WebDriver driver, String xpathLocator){
        return driver.findElements(By.xpath(xpathLocator));
    }

    protected By getByLocator(WebDriver driver, String xpathLocator){
        return By.xpath(xpathLocator);
    }

    protected void openURL(WebDriver driver, String url){
        driver.get(url);
    }

    protected void getPageTitle(WebDriver driver){
        driver.getTitle();
    }

    protected String getPageUrl(WebDriver driver){
       return driver.getCurrentUrl();
    }

    protected String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }

    protected void switchToWindowByID(WebDriver driver){
       String windowID = driver.getWindowHandle();
       driver.switchTo().window(windowID);
    }

    protected void switchToWindowByTitle(WebDriver driver, String expectedPageTitle){
       Set<String> allWindowsID = driver.getWindowHandles();

       for(String windowID : allWindowsID){
           driver.switchTo().window(windowID);
           if(driver.getTitle().equals(expectedPageTitle)){
               break;
           }
       }
    }

    protected void sendkeyToElement(WebDriver driver, String xpathLocator, String expectedText){
        getElement(driver, xpathLocator).clear();
        getElement(driver, xpathLocator).sendKeys(expectedText);
    }

    protected void clickElement(WebDriver driver, String xpathLocator){
        getElement(driver, xpathLocator).click();
    }

    protected void getTextOfElement(WebDriver driver, String xpathLocator){
        getElement(driver, xpathLocator).getText();
    }

    protected String getAttributeOfElement(WebDriver driver, String xpathLocator, String attributeName){
        return getElement(driver, xpathLocator).getAttribute(attributeName);
    }

    protected boolean isElementEnabled(WebDriver driver, String xpathLocator){
        return getElement(driver, xpathLocator).isEnabled();
    }

    protected boolean isElementDisplayed(WebDriver driver, String xpathLocator){
       return getElement(driver, xpathLocator).isDisplayed();
    }

    protected boolean isElementSelected(WebDriver driver, String xpathLocator){
        return getElement(driver, xpathLocator).isSelected();
    }

    protected int getSizeOfElementList(WebDriver driver, String xpathLocator){
        return getElementList(driver, xpathLocator).size();
    }

    protected String getCssValue(WebDriver driver, String xpathLocator, String cssAttributeName){
        return getElement(driver, xpathLocator).getCssValue(cssAttributeName);
    }

    protected void waitForElementDisplayed(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = WebDriverWait(driver, Duration.ofSeconds());
    }
}
