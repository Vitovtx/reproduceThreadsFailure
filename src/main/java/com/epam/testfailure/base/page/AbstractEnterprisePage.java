package com.epam.testfailure.base.page;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.testfailure.base.NavigationEnterprise;
import com.epam.testfailure.base.BaseWebDriver;

public class AbstractEnterprisePage
{
//	@Autowired protected BaseWebDriver webDriver;

	@Autowired protected NavigationEnterprise navigation;

	public NavigationEnterprise getNavigation()
	{
		return navigation;
	}
}
