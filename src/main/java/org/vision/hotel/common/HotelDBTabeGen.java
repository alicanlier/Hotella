package org.vision.hotel.common;

import org.vision.hotel.model.HotelReserve;

import com.sung.jdbc.dbtools.DBTableGenerator;


public class HotelDBTabeGen {

	public static void main(String[] args) {
		//DBTableGenerator.generateDBTable(HotelReserve.class, "oracle");
		//System.out.println("테이블생성완료");
		DBTableGenerator.dbGenerate("oracle", new Class[]{HotelReserve.class}, true); 
	}

}
