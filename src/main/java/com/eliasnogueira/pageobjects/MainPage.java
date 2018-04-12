/*
 * Copyright 2018 Elias Nogueira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.eliasnogueira.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "label[title='Search Medium'] > span[class*='svgIcon--search']")
    private WebElement searchIcon;

    @FindBy(css = "input[type='search']")
    private WebElement searchInput;

    public MainPage(WebDriver driver) {
        this.driver = driver;

        driver.get("http://www.medium.com");

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, 5);
    }


    public void clickSearchIcon() {
        searchIcon.click();
    }

    public void fillSearch(String query) {
        searchInput.sendKeys(query);
    }

    public void selectPeople(String name) {
        By xpathExpression = By.xpath("//span[@class='avatar-text' and text()='" + name + "']");

        wait.until(ExpectedConditions.presenceOfElementLocated(xpathExpression));
        driver.findElement(xpathExpression).click();
    }
}
