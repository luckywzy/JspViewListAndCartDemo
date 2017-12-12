package entity;
/*
 * 购物车类
 */

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Cart
{
	//购买商品的集合
	private HashMap<Items, Integer> goods;
	//总价格
	private double totalPrice;
	
	public Cart()
	{
		goods = new HashMap<>();
		totalPrice = 0.0;
	}
	
	public HashMap<Items, Integer> getGoods()
	{
		return goods;
	}
	public void setGoods(HashMap<Items, Integer> goods)
	{
		this.goods = goods;
	}
	public double getTotalPrice()
	{
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	
	//添加商品
	public boolean addGoodsInCart(Items item, int number)
	{
		//需要判断是否是添加重复饿商品
		if(goods.containsKey(item))
		{
			goods.put(item, goods.get(item) + number);
		}
		else
		{
			goods.put(item, number);
			this.CalTotalPrice(); //重新计算总价
		}
		return true;
	}
	
	//删除商品
	public boolean removeGoodsFromCart(Items item)
	{
		goods.remove(item);
		this.CalTotalPrice(); //重新计算总价
		return true;
	}
	
	//统计总金额
	public double CalTotalPrice()
	{
		double sum = 0.0;
		
		Set<Items> keys = goods.keySet();
		for (Items item : keys)
		{
			sum += item.getPrice() * goods.get(item);
		}
		
		this.setTotalPrice(sum);
		
		return this.getTotalPrice();
	}
	
	public static void main(String[] args)
	{
		Items i1 = new Items(1,"阿迪鞋", "温州",123, 124,"001.jpg");
		Items i2 = new Items(2,"李宁鞋", "苏州",100, 200,"002.jpg");
		Items i3 = new Items(1,"阿迪鞋", "温州",123, 124,"001.jpg");

		Cart cart = new Cart();
		cart.addGoodsInCart(i1, 1);
		cart.addGoodsInCart(i2, 2);
		cart.addGoodsInCart(i3, 2);
		
		Set<Entry<Items, Integer>> items = cart.getGoods().entrySet();
		for (Entry<Items, Integer> entry : items)
		{
			System.out.println(entry);
		}
		System.out.println(cart.getTotalPrice());
	}
}

















