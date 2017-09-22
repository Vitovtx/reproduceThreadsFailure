package com.epam.testfailure.testlogic.step.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.epam.testfailure.testlogic.page.login.BasePage;

import cucumber.api.java.en.When;

@ContextConfiguration("classpath:cucumber.xml")
public class UserLoginStep
{
	@Autowired
	BasePage basePage;

	@When("^I open test page$")
	public void loginDataTable()
	{
		basePage.getNavigation().goHome();
	}

}
