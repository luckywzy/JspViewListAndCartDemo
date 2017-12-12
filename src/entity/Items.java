package entity;
//商品实体类
public class Items {
    private int id; //编号
    private String name;
    private String city;
    private int price;
    private int number; //库存
    private String picture;
    public Items()
    {
    	
    }
    public Items(int id, String name, String city, int price, int number, String picture)
	{
		// TODO Auto-generated constructor stub
    	this.id = id;
    	this.name = name;
    	this.city = city;
    	this.price = price;
    	this.picture = picture;
    	this.number = number;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public String toString()
    {
    	return "编号："+this.getId()+",名称："+this.getName();
    }
    
    //保证不添加重复的商品 
	@Override
	public int hashCode()
	{
		return this.getId() + this.getName().hashCode();
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (id == other.id && name.equals(other.name) )
			return true;
		else {
			return false;
		}
	}
    

    
    
}
