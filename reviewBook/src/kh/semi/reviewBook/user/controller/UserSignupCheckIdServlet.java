package kh.semi.reviewBook.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.user.model.service.UserService;

/**
 * Servlet implementation class UserSignupCheckIdServlet
 */
@WebServlet("/signup_check")
public class UserSignupCheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSignupCheckIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getRequestDispatcher("WEB-INF/view/user/signup/signup_input.jsp").forward(request, response);
		request.setCharacterEncoding("UTF-8");
		String usId = request.getParameter("usId");

		int result = new UserService().SignupIdCheck(usId);
		PrintWriter script = response.getWriter();
		if (result == 0) {
			System.out.println("사용중인 아이디입니다.");
			script.println("<script>");
			script.println("alert('사용중인 아이디입니다. 다른 아이디 입력 후 다시 중복확인 해주세요.')");
			script.println("window.close();");
			script.println("</script>");
			

		} else if (result == 1) {
			System.out.print("사용가능한 아이디입니다");
			script.println("<script>");
			script.println("alert('사용가능한 아이디입니다.')");
			script.println("window.close();");
			script.println("</script>");

		} else {
			System.out.println("데이터베이스 오류");
			script.println("<script>");
			script.println("alert('시스템 오류입니다. 관리자에게 문의하세요.')");
			script.println("window.close();");
			script.println("</script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
