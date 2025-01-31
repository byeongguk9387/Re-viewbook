package kh.semi.reviewBook.admin.series.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


@WebServlet("/adseriesmain")
public class AdminSeriesMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminSeriesMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/// TODO : 관리자 로그인 정보 session에서 얻어와야함 
	
		System.out.println("doGet : /adseriesmain");
		
		//service, dao는 사용자 관리자 공통으로 사용 
		ArrayList<SeriesVo> slist = new SeriesService().listBoard();
		System.out.println(slist);
		

		request.setAttribute("slist",slist);
		

		//request.getRequestDispatcher("WEB-INF/view/admin/series/adseriesmain.jsp").forward(request, response);
		request.getRequestDispatcher("WEB-INF/view/admin/series/adseriesmainEl.jsp").forward(request, response);
		
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
