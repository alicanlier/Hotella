package org.vision.hotel.common;

import org.vision.hotel.model.Hotel;

public class HotelParsing {
	public static Hotel parsing(String target) throws Exception{
		//"HILTON/5/150000/2/서울강남/0311112222/hilton.jpg"
		String[] tokens = target.split("/");
		Hotel hotel = new Hotel();
		String errormsg="";
		try {
			hotel.setNo(0);
			hotel.setName(tokens[0]);
			errormsg="카테고리번호는 1,2,3이어야 한다.";
			hotel.setCategory(Integer.parseInt(tokens[1]));
			errormsg="차량대여료 부분 숫자이어야 합니다.";
			hotel.setPrice(Integer.parseInt(tokens[2]));
			errormsg="탑승자수 부분 숫자이어야 합니다.";
			hotel.setUsepeople(Integer.parseInt(tokens[3]));
			hotel.setAddress(tokens[4]);
			hotel.setPhone(tokens[5]);
			hotel.setImg(tokens[6]);
		} catch (Exception e) {
			System.err.println(errormsg);
			e.printStackTrace();
		}
		return hotel;
	}

	public static void main(String[] args) throws Exception {
		String target = "HILTON/5/150000/2/서울강남/0311112222/hilton.jpg";
		Hotel x = HotelParsing.parsing(target);
		System.out.println(x);
		// 또다른 방식 공통모듈(common tool) Parsing4Batch의 활용 
		String[] setters = new String[] { 
				"setName", "setCategory", "setPrice", "setUsepeople", "setAdress", "setPhone",
				"setImg" };
		Parsing4Batch parser = new Parsing4Batch(Hotel.class, "/");
		Hotel y	 =(Hotel)parser.parsing(target, setters);
		System.out.println(y);
	}
}