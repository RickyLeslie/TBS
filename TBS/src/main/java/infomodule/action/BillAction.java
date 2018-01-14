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
import infomodule.pojo.Bill;
import infomodule.pojo.PageBean;
import infomodule.pojo.Phone;
import infomodule.service.BillService;
import util.DateUtil;

@WebServlet(urlPatterns="/bill/*")
public class BillAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BillService billService=new BillService(); 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("bill---->");
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
		case "excelWrite":
			this.excelWrite(req, resp);
			break;
		case "excelRead":
			this.execlRead(req, resp);
			break;
		case "batchDelete":
			break;
		default:
			break;
		}
	}
	
	public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("insert----->");
		Bill bill=new Bill();
		Phone phone=(Phone)req.getSession().getAttribute("PHONE_IN_SESSION");
		System.out.println("phone: "+phone);
		bill.setId("B"+DateUtil.getDateFormat());
		bill.setMUID(phone.getTelephone());
		bill.setCUID(req.getParameter("CUID"));
		int time=Integer.parseInt(req.getParameter("time"));
		bill.setCallDuration(time);
		bill.setTelephoneCharge(billService.consume(time));
		System.out.println(bill);
		if(billService.insert(bill)!=0){
			resp.getWriter().write("{\"message\":\"添加成功\"}");
		}
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("delete----->");
		String id=req.getParameter("id");
		System.out.println(id);
		billService.delete(id);
		resp.getWriter().write("{\"message\":\"删除成功\"}");
		//resp.sendRedirect("/acc/getAll");
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("update----->");
		Bill bill=new Bill();
		bill=billService.query(req.getParameter("MUID"));
		req.setAttribute("bill", bill);
		System.out.println(bill);
		req.getRequestDispatcher("/jsps/bill-edit.jsp").forward(req, resp);
	}
	
	/*public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("getAll----->");
		List<Account> accounts=new ArrayList<Account>();
		String customer_id=req.getParameter("customer_id");
		accounts=billService.getAllAccounts(customer_id);
		req.setAttribute("accounts", accounts);
		req.getRequestDispatcher("/jsps/account-list.jsp").forward(req, resp);
	}*/
	
	public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("getAll----->");
		List<Bill> bills=new ArrayList<Bill>();
		bills=billService.getAllBills(req.getParameter("MUID"));
		req.setAttribute("bills", bills);
		req.getRequestDispatcher("/jsps/bill-list.jsp").forward(req, resp);
		System.out.println(bills);
	}
	
	public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("query----->");
	}
	
	public void updated(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("updated----->");
		Bill bill=new Bill();
		bill.setId(req.getParameter("id"));
		bill.setId(req.getParameter("MUiD"));
		bill.setId(req.getParameter("CUID"));
		bill.setId(req.getParameter("callDuration"));
		bill.setId(req.getParameter("telephoneCharge"));
		billService.update(bill);
		System.out.println(bill);
	}
	
	public void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("pageQuery------->");
		System.out.println(Integer.parseInt(req.getParameter("currentPage"))+" "+Integer.parseInt(req.getParameter("pageSize")));
		PageBean pageBean=new PageBean();
		pageBean=billService.pageQuery(Integer.parseInt(req.getParameter("currentPage")), 
				Integer.parseInt(req.getParameter("pageSize")));
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/jsps/bill-list.jsp").forward(req, resp);
		System.out.println(pageBean.getList());
		System.out.println("总页数:"+pageBean.getTotalPage()+" "+pageBean.getAllRow()+" "+pageBean.getPageSize());
	}
	
	public void excelWrite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("excelWrite-------->");
		//billService.excelWrite();
		req.getRequestDispatcher("${pageContext.request.contextPath}/acc/pageQuery?currentPage=1&pageSize=10").forward(req, resp);
	}
	
	public void execlRead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("excelRead--------->");
		//billService.excelRead();
	}
	
	public void batchDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("batchDelete---------->");
		
	}
	
}
