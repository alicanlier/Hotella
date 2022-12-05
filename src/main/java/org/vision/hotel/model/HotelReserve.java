package org.vision.hotel.model;

public class HotelReserve {
	private int regno;// 예약번호
	private int no;// 렌트차량등록번호
	private int qty;//대여수량 
	private int dday;//대여일자수(기간) 
	private String rday;//대여할 날짜 
	private String memid; // 예약자(고객) 아이디 
	
	public HotelReserve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getDday() {
		return dday;
	}

	public void setDday(int dday) {
		this.dday = dday;
	}

	public String getRday() {
		return rday;
	}

	public void setRday(String rday) {
		this.rday = rday;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	@Override
	public String toString() {
		return "HotelReserve [regno=" + regno + ", no=" + no + ", qty=" + qty + ", dday=" + dday + ", rday=" + rday
				+ ", memid=" + memid + "]";
	}
	

}
