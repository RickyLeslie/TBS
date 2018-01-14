package util;

import java.io.*;
import java.util.ArrayList;

import infomodule.dao.AccountDao;
import infomodule.pojo.Account;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

public class ExcelUtil {
	
	public static ArrayList<Account> excelRead(File excelFile){
		ArrayList<Account> accounts=new ArrayList<Account>();
		AccountDao accountDao=new AccountDao();
		Workbook workbook = null;
		try {
			//获取工作薄对象
			workbook = Workbook.getWorkbook(excelFile);
			//获取所有共工作表
			Sheet[] sheets=workbook.getSheets();
			//遍历工作表
			if(sheets!=null){
				for(Sheet sheet : sheets){
					//获取行数
					int rows=sheet.getRows();
					//获取列数
					int cols=sheet.getColumns();
					//读取数据
					for(int row=1;row<rows;row++){
						Account account=new Account();
						account.setId(sheet.getCell(0,row).getContents());
						account.setCustomer_id(sheet.getCell(1,row).getContents());
						account.setBankAccount(sheet.getCell(2,row).getContents());
						account.setOpenBank(sheet.getCell(3,row).getContents());
						account.setReadyAmount(Double.parseDouble(sheet.getCell(4,row).getContents()));
						account.setCostAmount(Double.parseDouble(sheet.getCell(5,row).getContents()));
						account.setCostMonthAmount(Double.parseDouble(sheet.getCell(6,row).getContents()));
						accounts.add(account);
						accountDao.insertAccount(account);
					}
				}
			}
		} catch (IOException | BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭流
		workbook.close();
		return accounts;
	}
	
	public static void excelWrite(File excelFile,ArrayList<Account> accounts) throws RowsExceededException, WriteException{
		try {
			//创建一个工作薄
			WritableWorkbook workbook=Workbook.createWorkbook(excelFile);
			//创建一个表 sheet:表格
			WritableSheet sheet=workbook.createSheet("accountSheet", 0);
			sheet.addCell(new Label(0,0,"ID"));
			sheet.addCell(new Label(1,0,"客户ID"));
			sheet.addCell(new Label(2,0,"银行卡号"));
			sheet.addCell(new Label(3,0,"开户行"));
			sheet.addCell(new Label(4,0,"预留金额"));
			sheet.addCell(new Label(5,0,"消费额"));
			sheet.addCell(new Label(6,0,"当月消费额"));
			for(int row=1;row<=accounts.size();row++){
				//向工作表中添加数据
				sheet.addCell(new Label(0,row,accounts.get(row-1).getId()));
				sheet.addCell(new Label(1,row,accounts.get(row-1).getCustomer_id()));
				sheet.addCell(new Label(2,row,accounts.get(row-1).getBankAccount()));
				sheet.addCell(new Label(3,row,accounts.get(row-1).getOpenBank()));
				sheet.addCell(new Label(4,row,accounts.get(row-1).getReadyAmount().toString()));
				sheet.addCell(new Label(5,row,accounts.get(row-1).getCostAmount().toString()));
				sheet.addCell(new Label(6,row,accounts.get(row-1).getCostMonthAmount().toString()));
			}
			workbook.write();
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
