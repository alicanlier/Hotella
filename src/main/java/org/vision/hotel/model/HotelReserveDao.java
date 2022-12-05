package org.vision.hotel.model;

import java.sql.SQLException;
import java.util.List;
//return boolean인경우 수정해야 함 : 메퍼에선 boolean을 리턴시킬 수 없다.
public interface HotelReserveDao {
	public int insert(HotelReserve vo) throws SQLException;
	public int getCurrval() throws SQLException ;
	public List<HotelReserve> selectAll() throws SQLException;
	public List<HotelReserve> queryForList(String memid) throws SQLException;
	public List<RESERVE_VIEW> getReserveViewData(String memid) throws SQLException;
	public List<RESERVE_VIEW> getAllReserveViewData() throws SQLException;
	// 예약취소 
	public int reserveCancel(int regno) throws SQLException;
	public HotelReserve queryForObject(int regno) throws SQLException;
	public int update(HotelReserve bean) throws SQLException;
}
