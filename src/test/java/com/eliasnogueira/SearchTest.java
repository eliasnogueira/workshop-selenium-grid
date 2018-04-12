package com.eliasnogueira;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.*;

import com.eliasnogueira.utils.BaseTest;
import com.eliasnogueira.pageobjects.MainPage;
import com.eliasnogueira.pageobjects.PeoplePage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchValidPerson()  {
        String person = "Elias Nogueira";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearchIcon();
        mainPage.fillSearch(person);
        mainPage.selectPeople(person);

        PeoplePage peoplePage = new PeoplePage(driver);
        assertThat(peoplePage.getTitleName(), equalTo(person));
        assertThat(peoplePage.getDescription(), equalTo("Senior QA Engineer, Agile Coach and Trainer"));
        assertThat(peoplePage.getURLAddress(), containsString("@eliasnogueira"));
    }
    
}