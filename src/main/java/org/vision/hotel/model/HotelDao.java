package org.vision.hotel.model;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
// return boolean인경우 수정해야 함 : 메퍼에선 boolean을 리턴시킬 수 없다.
public interface HotelDao {
		// 해당되는 키의 자료 존재여부(인서트하거나 딜리트, 업데이트할때 먼저점검) 
		public int isExist(Integer key) throws SQLException;//★
		// 새로운 자료를 디비에 넣는 작업을 하고 입력여부 리턴 
		public int insert(Hotel vo) throws SQLException;//★
		// 해당키의 자료를 삭제하고 결과를 정수로 리턴 
		public int delete(Integer key) throws SQLException;//★
		// 맵에 들어있는 업데이트 요소들을 업데이트 하고 그결과를 정수로 리턴 
		public int update(Map<String,Object> map) 
				throws SQLException;//★
		// 모든 자료를 객체를 만들어 List에 담아 리턴 
		public List<Hotel> selectAll() throws SQLException;//★
		// key에 해당하는 자료들을 골라 List에 담아 리턴 
		public List<Hotel> selectKey(Integer key) throws SQLException;
		// key에 해당하는 하나의 자료를 vo로 리턴 
		public Hotel selectVO(Integer key) throws SQLException;//★
		// 카테고리 별 
		public List<Hotel> listByCategory(int category) throws SQLException;
		
		// 현재 자료수 파악 
		public int getAllCount() throws SQLException;//★
		// 시리얼번호 자동증가 값중 현재 기록된 최대값을 알아내기 
		public int getMaxNo()  throws SQLException;//★
		// 웹페이지 한 페이지의 분량의 자료만 가져오기 - 서비스에서 처리할것 
		//public List<Rentcar> selectPart(int start,int end)  
		//		throws SQLException;//★
		// 금방 생성된 시퀀스값을 얻어오기 
		public int getCurrval() throws SQLException;//★
		// 로그인판단
		public int login(Map<String,String> map) throws SQLException;
}
