package com.epam.testfailure.base.page;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.testfailure.base.NavigationEnterprise;

public class AbstractEnterprisePage
{

	@Autowired protected NavigationEnterprise navigation;

	public NavigationEnterprise getNavigation()
	{
		return navigation;
	}
}
