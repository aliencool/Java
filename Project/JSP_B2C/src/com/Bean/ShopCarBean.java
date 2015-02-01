package com.Bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ShopCarBean {
	HashMap<Integer,ShopItemBean> hashmap_car=null;
	private int ItemCount=0;
	public ShopCarBean()
	{
		hashmap_car=new HashMap<Integer, ShopItemBean>();
	}
	
	//添加商品
	public synchronized boolean addcar(Integer key,ShopBean shopBean)
	{
		if(!hashmap_car.containsKey(key))//有这个商品不能添加了
		{
			//要把每个商品信息都添加进购物车的每条子目
			ShopItemBean shopItemBean=new ShopItemBean(shopBean);
			hashmap_car.put(key, shopItemBean);
			//得到购物车里面商品的个数
			ItemCount++;
			System.out.println(ItemCount);
			return true;
		}
		return false;
	}
	
	//删除每个商品
	public synchronized boolean deletecar(Integer key)
	{
		if(hashmap_car.containsKey(key))
		{
			hashmap_car.remove(key);
			ItemCount--;
			return true;
		}
		return false;
	}
	
	//得到购物车的数量
	public synchronized int getItemCount()
	{
		return ItemCount;
	}
	
	//清空购物车
	public synchronized void clear_All()
	{
		hashmap_car.clear();
		ItemCount=0;
	}
	
	
	//得到购物车中每个商品的数量是否符合
	public  synchronized ShopItemBean Amount(Integer key,int count)
	{
		ShopItemBean shopItemBean=null;
		if(hashmap_car.containsKey(key))
		{
			//得到条目
			 shopItemBean=hashmap_car.get(key);
			//判断是不是大于0
			if(shopItemBean.getCount()<=0) 
			{	
				hashmap_car.remove(key);
			}//没有就移除
			else
			{
				shopItemBean.setCount(count);//就设置购买数量
			}
		}
		return shopItemBean;
	}
	
	//得到总价为
	public synchronized float total_shoplist()
	{
		//总数:
		float total=0;
		//遍历
		Set<Integer> set=hashmap_car.keySet();
		Iterator<Integer> key=set.iterator();
		
		while(key.hasNext())
		{
			ShopItemBean shopItemBean=hashmap_car.get(key.next());
			total+=shopItemBean.total_price();
		}
		
		return total;
	}
	
	//得到加入全部商品
	public synchronized Collection<ShopItemBean> shopAllBeans()
	{
		return hashmap_car.values();
	}
	
	//判断是否已经加入购物车
	public synchronized boolean isExits(Integer key)
	{
		if(hashmap_car.containsKey(key))//有这个商品不能添加了
		{
			return true;
		}
		return false;
	}
	
}
