package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDao;
import entity.Cart;
import entity.Items;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/servlet/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private String action; //购物车动作 add，show,delete
	private ItemsDao idao = new ItemsDao(); //商品业务逻辑层对象
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("action") != null)
		{
			this.action = request.getParameter("action");
			if(action.equals("add")) //添加商品到购物车
			{
				if(addToCart(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			
			if(action.equals("show")) //显示购物车
			{
				request.getRequestDispatcher("/Cart.jsp").forward(request, response);
			}
			if(action.equals("delete"))
			{
				if(deleteFromCart(request, response))
				{
					request.getRequestDispatcher("/Cart.jsp").forward(request, response);
				}
			}
		}
		
	}

	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response)
	{
		String id= request.getParameter("id");
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		Items item = idao.getItemsById(Integer.parseInt(id));
		if(cart.removeGoodsFromCart(item))
		{
			return true;
		}
		return false;
	}

	private boolean addToCart(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Items item = idao.getItemsById( Integer.parseInt(id));
		
		//是否是第一次添加商品到购物车，需要new一个购物车对象
		if(request.getSession().getAttribute("cart") == null)
		{
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart.addGoodsInCart(item, Integer.parseInt(number)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
