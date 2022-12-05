package org.vision.hotel.model;

import java.sql.SQLException;
import java.util.List;
public interface HotelBoardDao {
	public int insert(HotelBoard bean) throws SQLException;
	public List<HotelBoard> selectAll() throws SQLException;
	public HotelBoard select(int num) throws SQLException;
	public int upHit(int num) throws SQLException;
	public int insert2(HotelBoard bean) throws SQLException;
	public int update(HotelBoard bean) throws SQLException;
	public int delete(int key) throws SQLException;
	public int getAllCount() throws SQLException;
}
