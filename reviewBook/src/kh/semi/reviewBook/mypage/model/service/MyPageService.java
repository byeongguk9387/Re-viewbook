package kh.semi.reviewBook.mypage.model.service;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;
import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.semi.reviewBook.mypage.model.dao.MyPageDao;
import kh.semi.reviewBook.mypage.model.vo.BuyListVo;
import kh.semi.reviewBook.mypage.model.vo.MyInformationVo;
import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;

public class MyPageService {
	private MyPageDao dao = new MyPageDao();
	
	// 구독권 조회
	public SubscribeVo selectSubscribe(String usId) {
		SubscribeVo result = null;
		Connection conn = getConnection();
		result = dao.selectSubscribe(conn, usId);
		close(conn);
		return result;
	}
	
	// 구매목록 조회
	public ArrayList<BuyListVo> selectBuyList(String usId) {
		ArrayList<BuyListVo> result = null;
		Connection conn = getConnection();
		result = dao.selectBuyList(conn, usId);
		close(conn);
		return result;
	}
	
	// 내정보 수정 전 기존 정보 가져오기
	public MyInformationVo selectMyInformation(String usId) {
		MyInformationVo result = null;
		Connection conn = getConnection();
		result = dao.selectMyInformation(conn, usId);
		close(conn);
		return result;
	}
	public int updateMyInformation(MyInformationVo iVo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.updateMyInformation(conn, iVo);
		close(conn);
		return result;
	}
}
