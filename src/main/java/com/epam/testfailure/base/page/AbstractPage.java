package com.epam.testfailure.base.page;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.testfailure.base.Navigation;

public class AbstractPage
{

	@Autowired protected Navigation navigation;

	public Navigation getNavigation()
	{
		return navigation;
	}
}
