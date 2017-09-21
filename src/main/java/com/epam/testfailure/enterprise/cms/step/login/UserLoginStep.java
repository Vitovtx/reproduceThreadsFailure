package com.epam.testfailure.enterprise.cms.step.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.epam.testfailure.base.step.AbstractStepDefinition;
import com.epam.testfailure.enterprise.cms.page.login.LoginPage;

import cucumber.api.java.en.When;

@ContextConfiguration("classpath:cucumber.xml")
public class UserLoginStep extends AbstractStepDefinition
{
	@Autowired
	LoginPage loginPage;

	@When("^I open test page$")
	public void loginDataTable()
	{
		loginPage.getNavigation().goHome();
	}

}
