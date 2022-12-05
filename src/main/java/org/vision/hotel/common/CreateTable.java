package org.vision.hotel.common;

import org.vision.hotel.model.Hotel;

import com.sung.jdbc.dbtools.DBTableGenerator;


public class CreateTable {

	public static void main(String[] args) {
		DBTableGenerator.dbGenerate("oracle",new Class[]{ Hotel.class}, true);

	}

}
