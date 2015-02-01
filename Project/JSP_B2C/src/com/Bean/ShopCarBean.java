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
	
	//�����Ʒ
	public synchronized boolean addcar(Integer key,ShopBean shopBean)
	{
		if(!hashmap_car.containsKey(key))//�������Ʒ���������
		{
			//Ҫ��ÿ����Ʒ��Ϣ����ӽ����ﳵ��ÿ����Ŀ
			ShopItemBean shopItemBean=new ShopItemBean(shopBean);
			hashmap_car.put(key, shopItemBean);
			//�õ����ﳵ������Ʒ�ĸ���
			ItemCount++;
			System.out.println(ItemCount);
			return true;
		}
		return false;
	}
	
	//ɾ��ÿ����Ʒ
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
	
	//�õ����ﳵ������
	public synchronized int getItemCount()
	{
		return ItemCount;
	}
	
	//��չ��ﳵ
	public synchronized void clear_All()
	{
		hashmap_car.clear();
		ItemCount=0;
	}
	
	
	//�õ����ﳵ��ÿ����Ʒ�������Ƿ����
	public  synchronized ShopItemBean Amount(Integer key,int count)
	{
		ShopItemBean shopItemBean=null;
		if(hashmap_car.containsKey(key))
		{
			//�õ���Ŀ
			 shopItemBean=hashmap_car.get(key);
			//�ж��ǲ��Ǵ���0
			if(shopItemBean.getCount()<=0) 
			{	
				hashmap_car.remove(key);
			}//û�о��Ƴ�
			else
			{
				shopItemBean.setCount(count);//�����ù�������
			}
		}
		return shopItemBean;
	}
	
	//�õ��ܼ�Ϊ
	public synchronized float total_shoplist()
	{
		//����:
		float total=0;
		//����
		Set<Integer> set=hashmap_car.keySet();
		Iterator<Integer> key=set.iterator();
		
		while(key.hasNext())
		{
			ShopItemBean shopItemBean=hashmap_car.get(key.next());
			total+=shopItemBean.total_price();
		}
		
		return total;
	}
	
	//�õ�����ȫ����Ʒ
	public synchronized Collection<ShopItemBean> shopAllBeans()
	{
		return hashmap_car.values();
	}
	
	//�ж��Ƿ��Ѿ����빺�ﳵ
	public synchronized boolean isExits(Integer key)
	{
		if(hashmap_car.containsKey(key))//�������Ʒ���������
		{
			return true;
		}
		return false;
	}
	
}
