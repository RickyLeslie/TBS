package infomodule.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import infomodule.pojo.Customer;
import infomodule.pojo.PageBean;
import infomodule.service.CustomerService;
import util.DateUtil;

@WebServlet(urlPatterns="/cus/*")
public class CustomerAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerService customerService=new CustomerService(); 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("cus---->");
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(uri);
		System.out.println(action);
		switch (action) {
		case "insert":
			this.insert(req, resp);
			break;
		case "delete":
			this.delete(req, resp);
			break;
		case "update":
			this.update(req, resp);
			break;
		case "getAll":
			this.getAll(req, resp);
			break;
		case "query":
			this.query(req, resp);
			break;
		case "updated":
			this.updated(req, resp);
			break;
		case "pageQuery":
			this.pageQuery(req, resp);
			break;
		default:
			break;
		}
	}
	
	public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("insert---->");
		Customer customer=new Customer();
		customer.setId("C"+DateUtil.getDateFormat());
		customer.setCustomerName(req.getParameter("customerName"));
		customer.setCustomerType(req.getParameter("customerType"));
		customer.setLocation(req.getParameter("location"));
		customer.setManager(req.getParameter("manager"));
		customer.setIndustry(req.getParameter("industry"));
		System.out.println(customer.getCustomerType());
		customerService.insert(customer);
		//resp.sendRedirect("/TBS/jsps/customer-list.jsp");
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("delete------>");
		String id=req.getParameter("id");
		System.out.println(id);
		customerService.delete(id);
		resp.sendRedirect("/cus/getAll");
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("update------>");
		Customer customer=new Customer();
		customer=customerService.query(req.getParameter("id"));
		req.setAttribute("customer", customer);
		System.out.println(customer);
		req.getRequestDispatcher("/jsps/customer-edit.jsp").forward(req, resp);
	}
	
	public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("getAll---->");
		List<Customer> customers=new ArrayList<Customer>();
		customers=customerService.getAllCustomers();
		System.out.println(customers);
		req.setAttribute("customers", customers);
		req.getRequestDispatcher("/jsps/customer-list.jsp").forward(req, resp);
		System.out.println(req.getRequestURI());
	}
	
	public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("query---->");
		Customer customer=new Customer();
		customer=customerService.query(req.getParameter("id"));
		System.out.println(req.getParameter("id"));
		System.out.println(customer);
		if(customer!=null){
			System.out.println("--->");
			req.setAttribute("customer", customer);
			//req.getRequestDispatcher("/jsps/customer-one.jsp").forward(req, resp);
			resp.sendRedirect("/TBS/jsps/customer-one.jsp");
			System.out.println(req.getRequestURI());
		}
	}
	
	public void updated(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("updated---->");
		Customer customer=new Customer();
		customer.setId(req.getParameter("id"));
		customer.setCustomerName(req.getParameter("customerName"));
		customer.setCustomerType(req.getParameter("customerType"));
		customer.setLocation(req.getParameter("location"));
		customer.setManager(req.getParameter("manager"));
		customer.setIndustry(req.getParameter("industry"));
		System.out.println(customer);
		customerService.update(customer);
	}
	
	public void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("pageQuery----------->");
		PageBean pageBean=new PageBean();
		pageBean=customerService.pageQuery(Integer.parseInt(req.getParameter("currentPage")), 
				Integer.parseInt(req.getParameter("pageSize")));
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/jsps/customer-list.jsp").forward(req, resp);
		System.out.println(pageBean.getList());
		System.out.println("总页数:"+pageBean.getTotalPage()+" "+pageBean.getAllRow()+" "+pageBean.getPageSize());
	}
}
