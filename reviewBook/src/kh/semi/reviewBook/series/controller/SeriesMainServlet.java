package kh.semi.reviewBook.series.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


@WebServlet("/seriesmain")
public class SeriesMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SeriesMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /seriesmain");
		

		ArrayList<SeriesVo> slist = new SeriesService().listBoard();
		System.out.println(slist);
		

		request.setAttribute("slist",slist);
		

		request.getRequestDispatcher("WEB-INF/view/user/series/seriesmain.jsp").forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
