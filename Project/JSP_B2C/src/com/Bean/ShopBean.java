package com.Bean;

public class ShopBean {
	//��Ʒ��id
    private int shop_id;
    //��Ʒ������
    private String shop_name;
    //��Ʒ������
    private int shop_amount;
    //��Ʒ�ļ۸�
    private int shop_price;
    //��ƷͼƬ
    private String shop_Image;
    //��Ʒ����
    private String shop_category;
    //��Ʒ����
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
