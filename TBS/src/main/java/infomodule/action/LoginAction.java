package infomodule.action;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import infomodule.dao.StaffDao;
import infomodule.pojo.Phone;
import infomodule.pojo.Staff;
import infomodule.pojo.StaffLog;
import infomodule.service.LoginService;
import infomodule.service.StaffLogService;
import infomodule.service.StaffService;

@WebServlet(urlPatterns="/login/*")
public class LoginAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService=new LoginService();
	private StaffLogService logService =new StaffLogService(); 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri=req.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(action);
		switch (action) {
		case "staff":
			this.login(req, resp);
			break;
		case "phone":
			this.phoneLogin(req, resp);
			break;
		default:
			resp.sendRedirect("login.html");
			break;
		}
	}
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session=req.getSession();
		Staff staff =null;
		String id=req.getParameter("username");
		String password=req.getParameter("password");
		staff=loginService.login(id, password);
		System.out.println("----"+staff);
		if(staff!=null){
			/*StaffLog log=new StaffLog();
			log.setStaff_id(staff.getId());
			log.setLog_type("员工表");
			//log.setLog_time(password);
			log.setLog_object("login");
			log.setLog_text("员工登陆");
			logService.insert(log);*/
			//req.getRequestDispatcher("/TBS/jsps/index.jsp").forward(req, resp);
			resp.sendRedirect("/TBS/jsps/index.jsp");
		}else{
			resp.sendRedirect("/TBS/login.jsp");
		}
	}
	
	public void phoneLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("phone---------->");
		HttpSession session=req.getSession();
		Phone phone =null;
		String id=req.getParameter("username");
		String password=req.getParameter("password");
		phone=loginService.phoneLogin(id, password);
		System.out.println("----"+phone);
		if(phone!=null){
			session.setAttribute("PHONE_IN_SESSION", phone);
			/*StaffLog log=new StaffLog();
			log.setStaff_id(staff.getId());
			log.setLog_type("员工表");
			//log.setLog_time(password);
			log.setLog_object("login");
			log.setLog_text("员工登陆");
			logService.insert(log);*/
			//req.getRequestDispatcher("/TBS/jsps/index.jsp").forward(req, resp);
			resp.sendRedirect("/TBS/jsps/phone-index.jsp");
		}else{
			resp.sendRedirect("/TBS/login.jsp");
		}
	}
}
