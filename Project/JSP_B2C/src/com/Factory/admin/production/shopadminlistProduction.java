package com.Factory.admin.production;

import com.admin.page.shopadminlistControl;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;

public class shopadminlistProduction implements Shop_Factory{

	public Shop_cr createShop_ab() {
		// TODO Auto-generated method stub
		return new shopadminlistControl();
	}
	

}
