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
import infomodule.pojo.Customer;
import infomodule.pojo.PageBean;
import infomodule.service.AccountService;
import util.DateUtil;

@WebServlet(urlPatterns="/acc/*")
public class AcocuntAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accountSerive=new AccountService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("acc---->");
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
		Account account=new Account();
		account.setId("A"+DateUtil.getDateFormat());
		account.setCustomer_id(req.getParameter("customer_id"));
		account.setBankAccount(req.getParameter("bankAccount"));
		account.setOpenBank(req.getParameter("openBank"));
		account.setReadyAmount(Double.parseDouble(req.getParameter("readyAmount")));
		account.setCostAmount(Double.parseDouble(req.getParameter("costAmount")));
		account.setCostMonthAmount(Double.parseDouble(req.getParameter("costMonthAmount")));
		//accountSerive.insert(account);
		System.out.println(account);
		int result = accountSerive.insert(account);
		if (result != 0) {
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().print("{\"message\":\"添加成功！\"}");
		} else {
			resp.getWriter().write("{\"message\":\"添加失败！\"}");
		}
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("delete----->");
		String id=req.getParameter("id");
		System.out.println(id);
		accountSerive.delete(id);
		resp.getWriter().write("{\"message\":\"删除成功\"}");
		//resp.sendRedirect("/acc/getAll");
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("update----->");
		Account account=new Account();
		account=accountSerive.query(req.getParameter("id"));
		req.setAttribute("account", account);
		System.out.println(account);
		req.getRequestDispatcher("/jsps/account-edit.jsp").forward(req, resp);
	}
	
	/*public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("getAll----->");
		List<Account> accounts=new ArrayList<Account>();
		String customer_id=req.getParameter("customer_id");
		accounts=accountSerive.getAllAccounts(customer_id);
		req.setAttribute("accounts", accounts);
		req.getRequestDispatcher("/jsps/account-list.jsp").forward(req, resp);
	}*/
	
	public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("getAll----->");
		List<Account> accounts=new ArrayList<Account>();
		accounts=accountSerive.getAllAccounts();
		req.setAttribute("accounts", accounts);
		req.getRequestDispatcher("/jsps/account-list.jsp").forward(req, resp);
		System.out.println(accounts);
	}
	
	public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("query----->");
	}
	
	public void updated(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("updated----->");
		Account account=new Account();
		account.setId(req.getParameter("id"));
		account.setCustomer_id(req.getParameter("customer_id"));
		account.setBankAccount(req.getParameter("bankAccount"));
		account.setOpenBank(req.getParameter("openBank"));
		account.setReadyAmount(Double.valueOf(req.getParameter("readyAmount")));
		account.setCostAmount(Double.valueOf(req.getParameter("costAmount")));
		account.setCostMonthAmount(Double.valueOf(req.getParameter("costMonthAmount")));
		accountSerive.update(account);
		System.out.println(account);
	}
	
	public void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("pageQuery------->");
		System.out.println(Integer.parseInt(req.getParameter("currentPage"))+" "+Integer.parseInt(req.getParameter("pageSize")));
		PageBean pageBean=new PageBean();
		pageBean=accountSerive.pageQuery(Integer.parseInt(req.getParameter("currentPage")), 
				Integer.parseInt(req.getParameter("pageSize")));
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/jsps/account-list.jsp").forward(req, resp);
		System.out.println(pageBean.getList());
		System.out.println("总页数:"+pageBean.getTotalPage()+" "+pageBean.getAllRow()+" "+pageBean.getPageSize());
	}
	
	public void excelWrite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("excelWrite-------->");
		accountSerive.excelWrite();
		req.getRequestDispatcher("${pageContext.request.contextPath}/acc/pageQuery?currentPage=1&pageSize=10").forward(req, resp);
	}
	
	public void execlRead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("excelRead--------->");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String excelPath=req.getParameter("excelPath");
		System.out.println(excelPath.toString());
		accountSerive.excelRead();
	}
	
	public void batchDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("batchDelete---------->");
		
	}
}
