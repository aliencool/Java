package com.Bean;

public class ShopItemBean {
   private ShopBean shopBean;
   private int count=1;//每个商品数量
   
   
   public int getCount() {
	return count;
   }
   
   public void setCount(int count) {
	this.count = count;
   }
    
   public ShopBean getShopBean() {
	return shopBean;
}

   public void setShopBean(ShopBean shopBean) {
	this.shopBean = shopBean;
   }

   public ShopItemBean()
   {
   }
   
   
   public ShopItemBean(ShopBean shopBean) {
	this.shopBean = shopBean;
   }
   
   public float total_price()
   {
	   
	   long price=Math.round(shopBean.getShop_price()*count);
	   return price;
   }
}
