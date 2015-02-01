package com.Bean;

public class ShopBean {
	//商品的id
    private int shop_id;
    //商品的名字
    private String shop_name;
    //商品的数量
    private int shop_amount;
    //商品的价格
    private int shop_price;
    //商品图片
    private String shop_Image;
    //商品总类
    private String shop_category;
    //商品子类
    private String shop_soncategory;
    public ShopBean()
    {
    	
    }
    
    
	public ShopBean(int shopid,String shopName, int shopAmount, int shopPrice,
			String shopCategory, String shopSoncategory) {
		super();
		shop_id=shopid;
		shop_name = shopName;
		shop_amount = shopAmount;
		shop_price = shopPrice;
		shop_category = shopCategory;
		shop_soncategory = shopSoncategory;
	}


	public ShopBean(int shopId, String shopName, int shopAmount, int shopPrice,String shopImage) {
		super();
		shop_id = shopId;
		shop_name = shopName;
		shop_amount = shopAmount;
		shop_price = shopPrice;
		this.shop_Image=shopImage;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shopId) {
		shop_id = shopId;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shopName) {
		shop_name = shopName;
	}
	public int getShop_amount() {
		return shop_amount;
	}
	public void setShop_amount(int shopAmount) {
		shop_amount = shopAmount;
	}
	public int getShop_price() {
		return shop_price;
	}
	public void setShop_price(int shopPrice) {
		shop_price = shopPrice;
	}
	public String getShop_Image() {
		return shop_Image;
	}
	public void setShop_Image(String shopImage) {
		shop_Image = shopImage;
	}

	public String getShop_category() {
		return shop_category;
	}

	public void setShop_category(String shopCategory) {
		shop_category = shopCategory;
	}

	public String getShop_soncategory() {
		return shop_soncategory;
	}

	public void setShop_soncategory(String shopSoncategory) {
		shop_soncategory = shopSoncategory;
	}
    
}
