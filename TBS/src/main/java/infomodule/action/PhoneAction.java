package infomodule.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import infomodule.pojo.Account;
import infomodule.pojo.PageBean;
import infomodule.pojo.Phone;
import infomodule.service.PhoneService;
import util.DateUtil;

@WebServlet(urlPatterns="/phone/*")
public class PhoneAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PhoneService phoneService=new PhoneService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("phone---->");
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
		Phone phone=new Phone();
		phone.setTelephone(req.getParameter("telephone"));
		phone.setAddress(req.getParameter("address"));
		phone.setBankAccount(req.getParameter("bankAccount"));
		phoneService.insert(phone);
		System.out.println(phone);
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("delete---->");
		String id=req.getParameter("telephone");
		phoneService.delete(id);
		System.out.println(id);
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("update---->");
		Phone phone=new Phone();
		phone=phoneService.query(req.getParameter("telephone"));
		req.setAttribute("phone", phone);
		req.getRequestDispatcher("/jsps/phone-edit.jsp").forward(req, resp);
		phoneService.update(phone);
		System.out.println(phone);
	}
	
	public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("getAll---->");
		List<Phone> phones=new ArrayList<Phone>();
		phones=phoneService.getAllPhones();
		req.setAttribute("phones", phones);
		req.getRequestDispatcher("/jsps/phone-list.jsp").forward(req, resp);
		System.out.println(phones);
	}
	
	public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("query---->");
	}
	
	public void updated(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("updated---->");
		Phone phone=new Phone();
		phone.setTelephone(req.getParameter("telephone"));
		phone.setAddress(req.getParameter("address"));
		phone.setBankAccount(req.getParameter("bankAccount"));
		phoneService.update(phone);
		System.out.println(phone);
	}
	
	public void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("pageQuery--------->");
		PageBean pageBean=new PageBean();
		pageBean=phoneService.pageQuery(Integer.parseInt(req.getParameter("currentPage")), 
				Integer.parseInt(req.getParameter("pageSize")));
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/jsps/phone-list.jsp").forward(req, resp);
		System.out.println(pageBean.getList());
		System.out.println("总页数:"+pageBean.getTotalPage()+" "+pageBean.getAllRow()+" "+pageBean.getPageSize());
	}
}
