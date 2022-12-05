package org.vision.hotel.model;

import java.sql.SQLException;
import java.util.List;

public interface HotelMemberDao {
	public int insert(HotelMember dto) throws SQLException;
	public int delete(String key) throws SQLException;
	public int update(HotelMember dto) throws SQLException;
	public HotelMember select(String key) throws SQLException;
	public List<HotelMember> selectAll() throws SQLException;
	public String getPassword(final String id) throws SQLException;
	public int getAllCount() throws SQLException;
	//public List<RentMember> selectPart(int start,int end) throws SQLException;
	public int batch(List<HotelMember> list) throws SQLException;
}
