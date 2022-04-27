package kh.semi.reviewBook.series.model.dao;


import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import kh.semi.reviewBook.series.model.vo.SeriesReCommentVo;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


public class SeriesDao {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 1.전체 게시글 게시글 수 가져오는 메소드
	public int countBoardList(Connection conn) {
		int result = 0;
		String sql = "select count(*) from writer_bbs";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 단일행 함수 - while문 x
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 2.전체 게시글 목록 나타내는 메소드
	public ArrayList<SeriesVo> listSeries(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo(); 

				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
				slist.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return slist;
	}

	// 3.검색한 단어와 일치하는 단어 검색해주는 메소드
	public ArrayList<SeriesVo> searchlistBoard(Connection conn, String searchText) {
		ArrayList<SeriesVo> slist = null;

		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_TITLE LIKE '%" + searchText + "%'" + "OR WB_WRITER like '%" + searchText
				+ "%' ORDER BY WB_NO DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
				slist.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return slist;

	}

	// 4-1.카테고리별 게시글 목록 나타내는 메소드(문학)
	public ArrayList<SeriesVo> listSeriesFiction(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_CATEGORY =" + "'" + "문학" + "'" + "ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
				slist.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return slist;
	}

	// 4-2.카테고리별 게시글 목록 나타내는 메소드(정보공유)
	public ArrayList<SeriesVo> listSeriesInfo(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_CATEGORY =" + "'" + "정보공유" + "'" + "ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
				slist.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return slist;
	}

	// 4-3.카테고리별 게시글 목록 나타내는 메소드(일상)
	public ArrayList<SeriesVo> listSeriesDaily(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_CATEGORY =" + "'" + "일상" + "'" + "ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
				slist.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return slist;
	}

	// 4-4.카테고리별 게시글 목록 나타내는 메소드(기타)
	public ArrayList<SeriesVo> listSeriesEtc(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_CATEGORY =" + "'" + "기타" + "'" + "ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
				slist.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return slist;
	}
	

	//5. 게시글 읽기
	public SeriesVo readSeries (Connection conn, int wbNo) {
		SeriesVo svo = null;
	String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WB_NO=?) reCommentCnt\r\n"
			+ "FROM WRITER_BBS WB WHERE WB_NO = ?";
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, wbNo);
		pstmt.setInt(2, wbNo);
		rs = pstmt.executeQuery();
		svo = new SeriesVo();
		
		if(rs.next()) {
			svo.setWbNo(rs.getInt("wb_No"));
			svo.setWbTitle(rs.getString("wb_Title"));
			svo.setWbContent(rs.getString("wb_Content"));
			svo.setWbCount(rs.getInt("wb_Count"));
			svo.setWbDate(rs.getString("wb_Date"));
			svo.setWbWriter(rs.getString("wb_Writer"));
			svo.setWbCategory(rs.getString("wb_Category"));
			svo.setUsId(rs.getString("us_Id"));
			svo.setReCommentCnt(rs.getInt("reCommentCnt"));
		
		}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}		
		return svo;
	}
	
	//6. 게시글에 달린 댓글 읽기
//	--WBC_NO      NOT NULL NUMBER         
//	--WBC_DATE    NOT NULL TIMESTAMP(6)   
//	--WBC_CONTENT          VARCHAR2(1024) 
//	--WBC_RATING           NUMBER         
//	--WB_NO       NOT NULL NUMBER         
//	--US_ID       NOT NULL VARCHAR2(30)   
//	--WBC_WRITER  NOT NULL VARCHAR2(45) 
	public ArrayList<SeriesReCommentVo> readSeriesComments(Connection conn, int wbNo) {
		ArrayList<SeriesReCommentVo> srlist = null;

		String sql = "SELECT * FROM WRITER_BBS_COMMENT WHERE WB_NO = ? ORDER BY WBC_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wbNo);
			rs = pstmt.executeQuery();

			srlist = new ArrayList<SeriesReCommentVo>();
			while (rs.next()) {
				SeriesReCommentVo srvo = new SeriesReCommentVo(rs.getInt("WBC_NO"), rs.getString("WBC_DATE"),
						rs.getString("WBC_CONTENT"), rs.getInt("WBC_RATING"), rs.getInt("WB_NO"), rs.getString("US_ID"),
						rs.getString("WBC_WRITER"));
				// (int rNo, int bNo, String rWriter, Timestamp rWriteDate, String rContent,
				// String mId)
				srlist.add(srvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return srlist;
	}
	
	
	//7. 댓글 작성
	public int insertSeriesComment(Connection conn, SeriesReCommentVo srvo) {
		String usId = "us222"; //member 로그인 구현 후 srvo.getUsId()수정 예정 
		String wbcWriter = "호랑이"; //member 로그인 구현 후 srvo.setWbcWriter()수정 예정 
		int result = 0;
		String sql = "INSERT INTO WRITER_BBS_COMMENT VALUES((SELECT NVL(MAX(WBC_NO),0)+1 FROM WRITER_BBS_COMMENT),"
				+ "SYSDATE, ? , ? ,?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			//제일 중요한 글번호 맨 앞으로 가져옴
			pstmt.setInt(3,srvo.getWbNo());
			//나머지 채워줌
			pstmt.setString(1, srvo.getWbcContent());
			pstmt.setInt(2, srvo.getWbcRating());
			pstmt.setString(4, usId); 
			pstmt.setString(5, wbcWriter);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	//8. 연재 게시글 작성
	public int insertSeriesBoard(Connection conn, SeriesVo svo) {
		String usId = "us111" ; //user 로그인 구현 후 svo.getUsId()수정 예정 
		String wbcWriter = "사자"; //user 로그인 구현 후 svo.setWbWriter()수정 예정 
		int result = 0;
		String sql = "INSERT INTO WRITER_BBS VALUES(SEQ_WB_NO.nextval, ? , ? , default, SYSTIMESTAMP, ? , ? , ? ) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getWbTitle());
			pstmt.setString(2, svo.getWbContent());
			pstmt.setString(3, wbcWriter);
			pstmt.setString(4, svo.getWbCategory());
			pstmt.setString(5, usId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
//	WB_NO       NOT NULL NUMBER         
//	WB_TITLE    NOT NULL VARCHAR2(60)   
//	WB_CONTENT  NOT NULL VARCHAR2(4000) 
//	WB_COUNT    NOT NULL NUMBER         
//	WB_DATE     NOT NULL TIMESTAMP(6)   
//	WB_WRITER   NOT NULL VARCHAR2(45)   
//	WB_CATEGORY NOT NULL VARCHAR2(20)   
//	US_ID       NOT NULL VARCHAR2(30)  
	
	//9-1. 업데이트 전 기존 글 가져오기(수정,삭제 시 사용)
	public SeriesVo readUpdateBoard(Connection conn, int wbNo) {
		SeriesVo svo = null;
		String sql = "SELECT * FROM WRITER_BBS WHERE WB_NO = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wbNo);
			rs = pstmt.executeQuery();
			
			rs = pstmt.executeQuery();
			svo = new SeriesVo();
			
			if(rs.next()) {
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
			
			}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}		
			return svo;
		}
	
	//9-2. 연재 게시물 수정
	public int updateSeriesBoard(Connection conn, SeriesVo svo) {
		String usId = "us111"; //member 로그인 구현 후 srvo.getUsId()수정 예정 
		String wbcWriter = "사자"; //member 로그인 구현 후 srvo.setWbcWriter()수정 예정 
		int result = 0;
		String sql = "UPDATE WRITER_BBS SET WB_TITLE =? , WB_CONTENT = ? , WB_CATEGORY = ? WHERE WB_NO =?";
		try {
			pstmt = conn.prepareStatement(sql);
			//제일 중요한 글 번호 맨 앞으로 가져옴
			pstmt.setInt(4, svo.getWbNo());
			//나머지 채워줌
			pstmt.setString(1, svo.getWbTitle());
			pstmt.setString(2, svo.getWbContent());
			pstmt.setString(3, svo.getWbCategory());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//9-3. 연재 게시물 삭제
	public int deleteSeriesBoard(Connection conn, SeriesVo svo) {
			int result = 0;
			String sql = "DELETE FROM WRITER_BBS WHERE WB_NO = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, svo.getWbNo());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}

			return result;
		}

	//10. 게시글 read 시 조회수 증가 (WB_COUNT    NOT NULL NUMBER)
	public int readUpdateCount (Connection conn, SeriesVo svo) {
		int result = 0;
		String sql = "UPDATE WRITER_BBS SET WB_COUNT = (WB_COUNT)+1 WHERE WB_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, svo.getWbNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
