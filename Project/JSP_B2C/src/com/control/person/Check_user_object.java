package com.control.person;

import com.Bean.DAOBean;
import com.localhost.Factory.DAOFACTORY;

public class Check_user_object {
	public static boolean  check_name(DAOBean daoBean)
	{
		return DAOFACTORY.getInstanceof().Cheack_user(daoBean);
	}
}
