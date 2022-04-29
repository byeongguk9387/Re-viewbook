package kh.semi.reviewBook.series.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesReCommentVo;
import kh.semi.reviewBook.series.model.vo.SeriesVo;

@WebServlet("/seriescommentupdate")
public class SeriesCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SeriesCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post: /seriescommentupdate");
		//글번호
		String wbnostr = request.getParameter("wbNo");
		//댓글번호
		String wbcnostr = request.getParameter("wbcNo");
		
		System.out.println("wbNo : "+wbcnostr);
		int wbNo = 0;
		int wbcNo = 0;
		try {
			wbNo = Integer.parseInt(wbnostr);
			wbcNo = Integer.parseInt(wbcnostr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(wbcNo < 1 && wbNo <1) { 
			//읽어올 게시글 번호가 이상할 경우 메인으로 보냄
			response.sendRedirect("seriesmain");
			//콘솔에서 확인
			System.out.println("wbNo < 1");
			System.out.println("wbcNo < 1");
		}
		//댓글내용
		String wbcContent = request.getParameter("wbcContent");
		
		//값 확인
		System.out.println(wbNo);
		System.out.println(wbcNo);
		System.out.println(wbcContent);
		
		SeriesReCommentVo srvo = new SeriesReCommentVo();
		srvo.setWbcNo(wbcNo);
		srvo.setWbcContent(wbcContent);
		
		int result = new SeriesService().updateSeriesBoardComment(srvo);
		 if(result<1) {//댓글 입력에 실패한 경우에도 메인으로 보냄
			 response.sendRedirect("seriesmain");
		 }else {
			 response.sendRedirect("seriesread?wbNo="+wbNo);
		 }
		
		
		
		
		
	}

}