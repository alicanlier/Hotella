package org.vision.hotel.model;
/**
 * 오라클 view 만들기 소스 
 SELECT 
    REGNO,
    MEMID,IMG,NAME,RDAY,DDAY,QTY,PRICE,
    DDAY*QTY*PRICE AS TOTAL
  
FROM HOTEL, HOTEL_RESERVE 
WHERE HOTEL.NO = HOTEL_RESERVE.NO;
 */

public class RESERVE_VIEW {
	private int regno;
	private int hotelno;
	private String memid;
	private String img;
	private String name;
	private String rday;
	private int dday;
	private int qty;
	private int price;
	private int total;
	//private int fee;
	//private int insurance;
	//private int insu_fee;
	//private int wifi;
	//private int wifi_fee;
	//private int navigation;
	//private int babyseat;
	//private int baby_fee;
	
	public RESERVE_VIEW() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RESERVE_VIEW(int regno, int hotelno, String memid, String img, String name, String rday, int dday, int qty,
			int price, int total) {
		super();
		this.regno = regno;
		this.hotelno = hotelno;
		this.memid = memid;
		this.img = img;
		this.name = name;
		this.rday = rday;
		this.dday = dday;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public int getHotelno() {
		return hotelno;
	}

	public void setHotelno(int hotelno) {
		this.hotelno = hotelno;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRday() {
		return rday;
	}

	public void setRday(String rday) {
		this.rday = rday;
	}

	public int getDday() {
		return dday;
	}

	public void setDday(int dday) {
		this.dday = dday;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "RESERVE_VIEW [regno=" + regno + ", hotelno=" + hotelno + ", memid=" + memid + ", img=" + img + ", name="
				+ name + ", rday=" + rday + ", dday=" + dday + ", qty=" + qty + ", price=" + price + ", total=" + total
				+ "]";
	}
	
}