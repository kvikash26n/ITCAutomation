package Desktop;

/*     */ import java.util.Iterator;
	/*     */ import java.util.List;
	/*     */ import java.util.Set;
	/*     */ import org.openqa.selenium.Alert;
	/*     */ import org.openqa.selenium.By;
	/*     */ import org.openqa.selenium.WebDriver;
	/*     */ import org.openqa.selenium.WebElement;
	/*     */ import org.openqa.selenium.interactions.Actions;
	/*     */ import org.openqa.selenium.support.ui.ExpectedConditions;
	/*     */ import org.openqa.selenium.support.ui.Select;
	/*     */ import org.openqa.selenium.support.ui.WebDriverWait;
	/*     */ /*     */

import com.accenture.omnichannelframework.api.MethodDataStore;
import com.accenture.omnichannelframework.api.OmnichannelFramework; 

public class Common {

	
	/*     */  static MethodDataStore methodDataStore=OmnichannelFramework.getMethodDataStore();
	/*     */
	/*     */ 
	/*     */ /*     */ 
	/*     */   public static WebElement findElementByXpath(WebDriver driver, String xpath)
	/*     */   {
	/*  23 */     return driver.findElement(By.xpath(methodDataStore.getValue(xpath)));
	/*     */   }
	/*     */   
	/*     */   public static WebElement findElementByName(WebDriver driver, String name) {
	/*  27 */     return driver.findElement(By.name(methodDataStore.getValue(name)));
	/*     */   }
	/*     */   
	/*     */   public static WebElement findElementById(WebDriver driver, String id) {
	/*  31 */     return driver.findElement(By.id(methodDataStore.getValue(id)));
	/*     */   }
	/*     */   
	/*     */   public static WebElement findElementByTagName(WebDriver driver, String tagName) {
	/*  35 */     return driver.findElement(By.tagName(methodDataStore.getValue(tagName)));
	/*     */   }
	/*     */   
	/*     */   public static WebElement findElementByLinkText(WebDriver driver, String linkText) {
	/*  39 */     return driver.findElement(By.linkText(methodDataStore.getValue(linkText)));
	/*     */   }
	/*     */   
	/*     */   public static WebElement findElementByPartialLinkText(WebDriver driver, String partialLinkText) {
	/*  43 */     return driver.findElement(By.partialLinkText(methodDataStore.getValue(partialLinkText)));
	/*     */   }
	/*     */   
	/*     */   public static WebElement findElementByCssSelector(WebDriver driver, String cssSelector) {
	/*  47 */     return driver.findElement(By.cssSelector(methodDataStore.getValue(cssSelector)));
	/*     */   }
	/*     */   
	/*     */   public static void waitForElementToBeVisible(WebDriver driver, String xpath, int timeout) {
	/*  51 */     WebDriverWait wait = new WebDriverWait(driver, timeout);
	/*  52 */     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(methodDataStore.getValue(xpath))));
	/*     */   }
	/*     */   
	/*     */   public static void waitForElementToBeClickable(WebDriver driver, String xpath, int timeout) {
	/*  56 */     WebDriverWait wait = new WebDriverWait(driver, timeout);
	/*  57 */     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(methodDataStore.getValue(xpath))));
	/*     */   }
	/*     */   
	/*     */   public static void waitForElementsToBeVisible(WebDriver driver, List<WebElement> listOfAllWebElements, int timeout)
	/*     */   {
	/*  62 */     WebDriverWait wait = new WebDriverWait(driver, timeout);
	/*  63 */     wait.until(ExpectedConditions.visibilityOfAllElements(listOfAllWebElements));
	/*     */   }
	/*     */   
	/*     */   public static void waitForElementsToBeClickable(WebDriver driver, List<WebElement> listOfAllWebElements, int timeout) {
	/*  67 */     WebDriverWait wait = new WebDriverWait(driver, timeout);
	/*  68 */     wait.until(ExpectedConditions.visibilityOfAllElements(listOfAllWebElements));
	/*     */   }
	/*     */   
	/*     */   public static void clickOnElementByXpath(WebDriver driver, String xpath) {
	/*  72 */     findElementByXpath(driver, methodDataStore.getValue(xpath)).click();
	/*     */   }
	/*     */   
	/*     */   public static void clickOnElementById(WebDriver driver, String id) {
	/*  76 */     findElementById(driver, methodDataStore.getValue(id)).click();
	/*     */   }
	/*     */   
	/*     */   public static void clickOnElementByName(WebDriver driver, String name) {
	/*  80 */     findElementByName(driver, methodDataStore.getValue(name)).click();
	/*     */   }
	/*     */   
	/*     */   public static void clickOnElementByCssSelector(WebDriver driver, String cssSelector) {
	/*  84 */     findElementByCssSelector(driver, methodDataStore.getValue(cssSelector)).click();
	/*     */   }
	/*     */   
	/*     */   public static void clickOnElementByLinkText(WebDriver driver, String linkText) {
	/*  88 */     findElementByLinkText(driver, methodDataStore.getValue(linkText)).click();
	/*     */   }
	/*     */   
	/*     */   public static void clickOnElementByPartialLinkText(WebDriver driver, String partialLinkText) {
	/*  92 */     findElementByPartialLinkText(driver, methodDataStore.getValue(partialLinkText)).click();
	/*     */   }
	/*     */   
	/*     */   public static void clickOnElementByTagName(WebDriver driver, String tagName) {
	/*  96 */     findElementByTagName(driver, methodDataStore.getValue(tagName)).click();
	/*     */   }
	/*     */   
	/*     */   public static void sleep(int sleepTime) throws InterruptedException
	/*     */   {
	/* 101 */     Thread.sleep(sleepTime);
	/*     */   }
	/*     */   
	/*     */   public static void sendTextUsingXpath(WebDriver driver, String text, String xpath) {
	/* 105 */     WebElement element = findElementByXpath(driver, methodDataStore.getValue(xpath));
	/* 106 */     element.sendKeys(new CharSequence[] { methodDataStore.getValue(text) });
	/*     */   }
	/*     */   
	/*     */   public static void sendTextUsingId(WebDriver driver, String text, String id) {
	/* 110 */     WebElement element = findElementById(driver, methodDataStore.getValue(id));
	/* 111 */     element.sendKeys(new CharSequence[] { methodDataStore.getValue(text) });
	/*     */   }
	/*     */   
	/*     */   public static void sendTextUsingName(WebDriver driver, String text, String name) {
	/* 115 */     WebElement element = findElementByName(driver, methodDataStore.getValue(name));
	/* 116 */     element.sendKeys(new CharSequence[] { methodDataStore.getValue(text) });
	/*     */   }
	/*     */   
	/*     */   public static void sendTextUsingCssSelector(WebDriver driver, String text, String cssSelector) {
	/* 120 */     WebElement element = findElementByCssSelector(driver, methodDataStore.getValue(cssSelector));
	/* 121 */     element.sendKeys(new CharSequence[] { methodDataStore.getValue(text) });
	/*     */   }
	/*     */   
	/*     */   public static void sendTextUsingTagName(WebDriver driver, String text, String tagName) {
	/* 125 */     WebElement element = findElementByTagName(driver, methodDataStore.getValue(tagName));
	/* 126 */     element.sendKeys(new CharSequence[] { methodDataStore.getValue(text) });
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingXpathAndVisibleText(WebDriver driver, String VisibleText, String xpath)
	/*     */   {
	/* 131 */     WebElement element = findElementByXpath(driver, methodDataStore.getValue(xpath));
	/* 132 */     Select dropDown = new Select(element);
	/* 133 */     dropDown.selectByVisibleText(methodDataStore.getValue(VisibleText));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingIdAndVisibleText(WebDriver driver, String VisibleText, String id) {
	/* 137 */     WebElement element = findElementById(driver, methodDataStore.getValue(id));
	/* 138 */     Select dropDown = new Select(element);
	/* 139 */     dropDown.selectByVisibleText(methodDataStore.getValue(VisibleText));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingNameAndVisibleText(WebDriver driver, String VisibleText, String name) {
	/* 143 */     WebElement element = findElementByName(driver, methodDataStore.getValue(name));
	/* 144 */     Select dropDown = new Select(element);
	/* 145 */     dropDown.selectByVisibleText(methodDataStore.getValue(VisibleText));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingCssSelectorAndVisibleText(WebDriver driver, String VisibleText, String cssSelector) {
	/* 149 */     WebElement element = findElementByCssSelector(driver, methodDataStore.getValue(cssSelector));
	/* 150 */     Select dropDown = new Select(element);
	/* 151 */     dropDown.selectByVisibleText(methodDataStore.getValue(VisibleText));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingTagNameAndVisibleText(WebDriver driver, String VisibleText, String tagName)
	/*     */   {
	/* 156 */     WebElement element = findElementByTagName(driver, methodDataStore.getValue(tagName));
	/* 157 */     Select dropDown = new Select(element);
	/* 158 */     dropDown.selectByVisibleText(methodDataStore.getValue(VisibleText));
	/*     */   }
	/*     */   
	/*     */ 
	/*     */   public static void selectDropDownUsingXpathAndValue(WebDriver driver, String value, String xpath)
	/*     */   {
	/* 164 */     WebElement element = findElementByXpath(driver, methodDataStore.getValue(xpath));
	/* 165 */     Select dropDown = new Select(element);
	/* 166 */     dropDown.selectByValue(methodDataStore.getValue(value));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingIdAndValue(WebDriver driver, String value, String id) {
	/* 170 */     WebElement element = findElementById(driver, methodDataStore.getValue(id));
	/* 171 */     Select dropDown = new Select(element);
	/* 172 */     dropDown.selectByValue(methodDataStore.getValue(value));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingNameAndValue(WebDriver driver, String value, String name) {
	/* 176 */     WebElement element = findElementByName(driver, methodDataStore.getValue(name));
	/* 177 */     Select dropDown = new Select(element);
	/* 178 */     dropDown.selectByValue(methodDataStore.getValue(value));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingCssSelectorAndValue(WebDriver driver, String value, String cssSelector) {
	/* 182 */     WebElement element = findElementByCssSelector(driver, methodDataStore.getValue(cssSelector));
	/* 183 */     Select dropDown = new Select(element);
	/* 184 */     dropDown.selectByValue(methodDataStore.getValue(value));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingTagNameAndValue(WebDriver driver, String value, String tagName)
	/*     */   {
	/* 189 */     WebElement element = findElementByTagName(driver, methodDataStore.getValue(tagName));
	/* 190 */     Select dropDown = new Select(element);
	/* 191 */     dropDown.selectByValue(methodDataStore.getValue(value));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingXpathAndIndex(WebDriver driver, String index, String xpath)
	/*     */   {
	/* 196 */     WebElement element = findElementByXpath(driver, methodDataStore.getValue(xpath));
	/* 197 */     Select dropDown = new Select(element);
	/* 198 */     dropDown.selectByIndex(Integer.parseInt(methodDataStore.getValue(index)));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingIdAndIndex(WebDriver driver, String index, String id) {
	/* 202 */     WebElement element = findElementById(driver, methodDataStore.getValue(id));
	/* 203 */     Select dropDown = new Select(element);
	/* 204 */     dropDown.selectByIndex(Integer.parseInt(methodDataStore.getValue(index)));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingNameAndIndex(WebDriver driver, String index, String name) {
	/* 208 */     WebElement element = findElementByName(driver, methodDataStore.getValue(name));
	/* 209 */     Select dropDown = new Select(element);
	/* 210 */     dropDown.selectByIndex(Integer.parseInt(methodDataStore.getValue(index)));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingCssSelectorAndIndex(WebDriver driver, String index, String cssSelector) {
	/* 214 */     WebElement element = findElementByCssSelector(driver, methodDataStore.getValue(cssSelector));
	/* 215 */     Select dropDown = new Select(element);
	/* 216 */     dropDown.selectByIndex(Integer.parseInt(methodDataStore.getValue(index)));
	/*     */   }
	/*     */   
	/*     */   public static void selectDropDownUsingTagNameAndIndex(WebDriver driver, String index, String tagName)
	/*     */   {
	/* 221 */     WebElement element = findElementByTagName(driver, methodDataStore.getValue(tagName));
	/* 222 */     Select dropDown = new Select(element);
	/* 223 */     dropDown.selectByIndex(Integer.parseInt(methodDataStore.getValue(index)));
	/*     */   }
	/*     */   
	/*     */ 
	/*     */   public static void mouseHoverOverElementByXpath(WebDriver driver, String xpath)
	/*     */   {
	/* 229 */     WebElement element = findElementByXpath(driver, methodDataStore.getValue(xpath));
	/* 230 */     Actions actions = new Actions(driver);
	/* 231 */     actions.moveToElement(element);
	/* 232 */     actions.perform();
	/*     */   }
	/*     */   
	/*     */   public static void mouseHoverOverElementByName(WebDriver driver, String name) {
	/* 236 */     WebElement element = findElementByName(driver, methodDataStore.getValue(name));
	/* 237 */     Actions actions = new Actions(driver);
	/* 238 */     actions.moveToElement(element);
	/* 239 */     actions.perform();
	/*     */   }
	/*     */   
	/*     */   public static void mouseHoverOverElementById(WebDriver driver, String id) {
	/* 243 */     WebElement element = findElementById(driver, methodDataStore.getValue(id));
	/* 244 */     Actions actions = new Actions(driver);
	/* 245 */     actions.moveToElement(element);
	/* 246 */     actions.perform();
	/*     */   }
	/*     */   
	/* 249 */   public static void mouseHoverOverElementByTagName(WebDriver driver, String tagName) { WebElement element = findElementByTagName(driver, methodDataStore.getValue(tagName));
	/* 250 */     Actions actions = new Actions(driver);
	/* 251 */     actions.moveToElement(element);
	/* 252 */     actions.perform();
	/*     */   }
	/*     */   
	/* 255 */   public static void mouseHoverOverElementByLinkText(WebDriver driver, String linkText) { WebElement element = findElementByLinkText(driver, methodDataStore.getValue(linkText));
	/* 256 */     Actions actions = new Actions(driver);
	/* 257 */     actions.moveToElement(element);
	/* 258 */     actions.perform();
	/*     */   }
	/*     */   
	/* 261 */   public static void mouseHoverOverElementByPartialLinkText(WebDriver driver, String partialLinkText) { WebElement element = findElementByPartialLinkText(driver, methodDataStore.getValue(partialLinkText));
	/* 262 */     Actions actions = new Actions(driver);
	/* 263 */     actions.moveToElement(element);
	/* 264 */     actions.perform();
	/*     */   }
	/*     */   
	/*     */   public static void mouseHoverOverElementCssSelector(WebDriver driver, String cssSelector) {
	/* 268 */     WebElement element = findElementByCssSelector(driver, methodDataStore.getValue(cssSelector));
	/* 269 */     Actions actions = new Actions(driver);
	/* 270 */     actions.moveToElement(element);
	/* 271 */     actions.perform();
	/*     */   }
	/*     */   
	/*     */   public static void switchToWindowByName(WebDriver driver, String targetWindowName) {
	/* 275 */     Set<String> windows = driver.getWindowHandles();
	/* 276 */     Iterator<String> itr = windows.iterator();
	/* 277 */     for (int i = 0; i < windows.size() - 1; i++) {
	/* 278 */       itr.next();
	/* 279 */       if (itr.next() == methodDataStore.getValue(targetWindowName)) {
	/* 280 */         driver.switchTo().window(methodDataStore.getValue(targetWindowName));
	/* 281 */         break;
	/*     */       }
	/*     */     }
	/*     */   }
	/*     */   
	/*     */   public static void switchToWindowByIndex(WebDriver driver, String targetWindowIndex) {
	/* 287 */     Set<String> windows = driver.getWindowHandles();
	/* 288 */     Iterator<String> itr = windows.iterator();
	/* 289 */     if ((Integer.parseInt(methodDataStore.getValue(targetWindowIndex))) == 0) {
	/* 290 */       System.out.println("Target window is also the parent window. Please increase the index.");
	/*     */     }
	/*     */     else {
	/* 293 */       for (int i = 0; i < windows.size() - 1; i++) {
	/* 294 */         String windowToBeSwitchedTo = null;
	/* 295 */         if (i == (Integer.parseInt(methodDataStore.getValue(targetWindowIndex)))) {
	/* 296 */           driver.switchTo().window(windowToBeSwitchedTo);
	/* 297 */           break;
	/*     */         }
	/*     */         
	/* 300 */         windowToBeSwitchedTo = (String)itr.next();
	/*     */       }
	/*     */     }
	/*     */   }
	/*     */   
	/*     */   public static void switchToWindow(WebDriver driver, String targetWindow)
	/*     */   {
	/* 307 */     driver.switchTo().window(methodDataStore.getValue(targetWindow));
	/*     */   }
	/*     */   
	/*     */   public static void acceptAlertBox(WebDriver driver) {
	/* 311 */     driver.switchTo().alert().accept();
	/*     */   }
	/*     */   
	/*     */   public static void dismissAlertBox(WebDriver driver) {
	/* 315 */     driver.switchTo().alert().dismiss();
	/*     */   }
	/*     */   
	/*     */   public static void sendTextToAlertBoxAndAccept(WebDriver driver, String text) {
	/* 319 */     Alert alertBox = driver.switchTo().alert();
	/* 320 */     alertBox.sendKeys(methodDataStore.getValue(text));
	/* 321 */     alertBox.accept();
	/*     */   }
	/*     */ }

	/* Location:           C:\Users\r.thilagavathi\Downloads\SeleniumLibrary\SeleniumLibrary.jar
	 * Qualified Name:     com.acc.library.Library
	 * Java Class Version: 8 (52.0)
	 * JD-Core Version:    0.7.1
	 */
