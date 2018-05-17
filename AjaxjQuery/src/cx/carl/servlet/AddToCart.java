package cx.carl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import cx.carl.bean.ShoppingCart;

public class AddToCart extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookName = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session
				.getAttribute("shoppingCart");
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		shoppingCart.addToCart(bookName, price);
//		StringBuilder result = new StringBuilder();
//		result.append("{")
//				.append("\"bookName\":\"" + bookName + "\"")
//				.append(",")
//				.append("\"totalBookNumber\":"
//						+ shoppingCart.getTotalBookNumber()).append(",")
//				.append("\"totalMoney\":" + shoppingCart.getTotalMoney())
//				.append("}");
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(shoppingCart);
		System.out.println(result);
		
		response.setContentType("text/javascript");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
//		response.getWriter().print(result.toString());
		response.getWriter().print(result);
	}

}
