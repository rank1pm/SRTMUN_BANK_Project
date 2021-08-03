package srtmunBank;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.*;

public class BankFunctions {
	private static Connection databaseConnection=DBHelper.dbConnect();
	
	//Loging Check Credintials
	public static String login(String userIdText,String password) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM ADMIN WHERE  USER_ID=? AND PASSWORD=?");
			pst.setString(1,userIdText);
			pst.setString(2,password);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				String desig=r.getString("DESIGNATION"),m="M",c="C";
				JOptionPane.showMessageDialog(null, desig);
				if(desig.equals(m)) {
					return "M";
				}else if(desig.equals(c)) {
					return "C";
				}
				else
					return null;
			}else {
				JOptionPane.showMessageDialog(null, userIdText+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//getName of User using Account Number
	public static String getName(String account) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT CUSTOMER_NAME FROM CUSTOMER WHERE  ACCOUNT_NUMBER=?");
			pst.setString(1,account);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				return (r.getString("CUSTOMER_NAME"));
			}else {
				JOptionPane.showMessageDialog(null, account+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	
	} 

	//get Account Number of User
	public static String getAccountNumber(String userIdText) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM CUSTOMER WHERE  USER_ID=?");
			pst.setString(1,userIdText);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				return (r.getString(4));
			}else {
				JOptionPane.showMessageDialog(null, userIdText+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//get Current Balance of User using Account Number
	public static String getAvailableBalance(String account) {
			try {
				PreparedStatement pst=databaseConnection.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE  ACCOUNT_NUMBER=?");
				pst.setString(1,account);
				ResultSet r=pst.executeQuery();
				if(r.next()) {
					return (r.getString("BALANCE"));
				}else {
					JOptionPane.showMessageDialog(null, account+" not found in Bank Records");
					return null;
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,e);
				return null;
			}
		
	} 
	
	//get Account Status of User
	public static String getAccountStatus(String userIdText) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM CUSTOMER WHERE  USER_ID=?");
			pst.setString(1,userIdText);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				return (r.getString(12));
			}else {
				JOptionPane.showMessageDialog(null, userIdText+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	
} 
	
	//get Address of User
	public static String getAddress(String userIdText) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM CUSTOMER WHERE  USER_ID=?");
			pst.setString(1,userIdText);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				return (r.getString(5));
			}else {
				JOptionPane.showMessageDialog(null, userIdText+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//get Mobile Number of User
	public static String getPhoneNumber(String userIdText) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM CUSTOMER WHERE  USER_ID=?");
			pst.setString(1,userIdText);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				return (r.getString(6));
			}else {
				JOptionPane.showMessageDialog(null, userIdText+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//get Email Address of User
	public static String getEmail(String userIdText) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM CUSTOMER WHERE  USER_ID=?");
			pst.setString(1,userIdText);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				return (r.getString(7));
			}else {
				JOptionPane.showMessageDialog(null, userIdText+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//get Emi status of User
	public static String getEmiStatus(String userIdText) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM CUSTOMER WHERE  USER_ID=?");
			pst.setString(1,userIdText);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				return (r.getString(5));
			}else {
				JOptionPane.showMessageDialog(null, userIdText+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//getDesignation of User
	public static String getDesignation(String userIdText) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM ADMIN WHERE  USER_ID=?");
			pst.setString(1,userIdText);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				return (r.getString(5));
			}else {
				JOptionPane.showMessageDialog(null, userIdText+" not found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

	//getColumnName of Customer Database
	public static Object[] getColumName(String dbName){
		
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM "+dbName);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				ResultSetMetaData rsmd=r.getMetaData();
				int columnCount=rsmd.getColumnCount();
				Object[] columnNameList=new Object[columnCount];
				for(int i=1;i<=columnCount;i++) {
					columnNameList[i-1]=rsmd.getColumnName(i);
				}
				return columnNameList;
			}else {
				JOptionPane.showMessageDialog(null, "No Databse of "+dbName+" found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//getColum Name of Transactions Table
	public static Object[] getTransactionColumn(String dbName){
		
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM "+dbName);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				ResultSetMetaData rsmd=r.getMetaData();
				int columnCount=rsmd.getColumnCount();
				Object[] columnNameList=new Object[columnCount];
				for(int i=1;i<=columnCount;i++) {
					columnNameList[i-1]=rsmd.getColumnName(i);
				}
				return columnNameList;
			}else {
				JOptionPane.showMessageDialog(null, "No Databse of "+dbName+" found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//viewAllCustomers Record
	public static Object[][] getAllData(String dbName){
		
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM "+dbName);
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				ResultSetMetaData rsmd=r.getMetaData();
				int columnCount=rsmd.getColumnCount();
				r.last();
				int rowCount=r.getRow();
				r.first();
				Object[][] columnNameList=new Object[rowCount][columnCount];
				int j=1;
				while(j<=rowCount){
				for(int i=1;i<=columnCount;i++) {
					columnNameList[j-1][0]=j;
					columnNameList[j-1][i-1]=r.getString(i);
				}
				r.next();
				j++;
				}
				return columnNameList;
			}else {
				JOptionPane.showMessageDialog(null, "No Databse of "+dbName+" found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//view Customers Record in Transaction
	public static Object[][] getAllTransactionData(String dbName,String account){
			
			try {
				PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM "+dbName+" WHERE ACCOUNT_NUMBER=?");
				pst.setString(1,account);
				ResultSet r=pst.executeQuery();
				if(r.next()) {
					ResultSetMetaData rsmd=r.getMetaData();
					int columnCount=rsmd.getColumnCount();
					r.last();
					int rowCount=r.getRow();
					r.first();
					Object[][] columnNameList=new Object[rowCount][columnCount];
					int j=1;
					while(j<=rowCount){
					for(int i=1;i<=columnCount;i++) {
						columnNameList[j-1][0]=j;
						columnNameList[j-1][i-1]=r.getString(i);
					}
					r.next();
					j++;
					}
					return columnNameList;
				}else {
					JOptionPane.showMessageDialog(null, "No Databse of "+dbName+" found in Bank Records");
					return null;
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,e);
				return null;
			}
		}
	
	//getEmiReports of all Customers
	public static Object[][] getAllEmiReport(String dbName){
		
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM "+dbName+" WHERE EMI_STATUS=?");
			pst.setString(1, "YES");
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				r.last();
				int rowCount=r.getRow();
				r.first();
				Object[][] columnNameList=new Object[rowCount][5];
				int j=1;
				while(j<=rowCount){
					columnNameList[j-1][0]=j;
					columnNameList[j-1][1]=r.getString("CUSTOMER_NAME");
					columnNameList[j-1][2]=r.getString("ACCOUNT_NUMBER");
					columnNameList[j-1][3]=r.getString("EMI_STATUS");
					columnNameList[j-1][4]=r.getString("REMAINING_EMI");
					r.next();
					j++;
				}
				return columnNameList;
			}else {
				JOptionPane.showMessageDialog(null, "No Databse of "+dbName+" found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	//getEmiReport Column Name
	public static Object[] getAllEmiReportColumn() {
		Object[] columnName= {"SR NO","CUSTOMER_NAME","ACCOUNT_NUMBER","EMI_STATUS","REMAINING_EMI"};
		return columnName;
	}

	//getCheckBookRequestCoumn Name
	public static Object[] getAllCheckBookColumnName() {
		Object[] columnName= {"SR NO","CUSTOMER_NAME","ACCOUNT_NUMBER","BALANCE","CHECK_BOOK_REQUEST","ACCOUNT_STATUS"};
		return columnName;
	}

	//getAllCheckBook Status Report
	public static Object[][] getCheckBookStatusReport(String string) {
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT * FROM "+string+" WHERE CHECK_BOOK_STATUS=?");
			pst.setString(1, "YES");
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				r.last();
				int rowCount=r.getRow();
				r.first();
				Object[][] columnNameList=new Object[rowCount][6];
				int j=1;
				while(j<=rowCount){
					columnNameList[j-1][0]=j;
					columnNameList[j-1][1]=r.getString("CUSTOMER_NAME");
					columnNameList[j-1][2]=r.getString("ACCOUNT_NUMBER");
					columnNameList[j-1][3]=r.getString("BALANCE");
					columnNameList[j-1][4]=r.getString("CHECK_BOOK_STATUS");
					columnNameList[j-1][5]=r.getString("ACCOUNT_STATUS");
					r.next();
					j++;
				}
				return columnNameList;
			}else {
				JOptionPane.showMessageDialog(null, "No Databse of "+string+" found in Bank Records");
				return null;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

	//Open New Account
	public static boolean openNewAccount(String cName, String cUserId, String cAccount, String cAddress, String cMobile,
			String cEmail,double cBalance, String cCheck, String cEmiStatus, String cAccountStatus) {
		boolean success=false;
		try {
		PreparedStatement pst=databaseConnection.prepareStatement("INSERT INTO CUSTOMER(CUSTOMER_NAME,USER_ID,ACCOUNT_NUMBER,ADDRESS,MOBILE,EMAIL,BALANCE,CHECK_BOOK_STATUS,EMI_STATUS,ACCOUNT_STATUS) VALUES (?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1,cName);
		pst.setString(2, cUserId);
		pst.setString(3, cAccount);
		pst.setString(4, cAddress);
		pst.setString(5, cMobile);
		pst.setString(6, cEmail);
		pst.setDouble(7, cBalance);
		pst.setString(8, cCheck);
		pst.setString(9, cEmiStatus);
		pst.setString(10, cAccountStatus);
		int a=pst.executeUpdate();
		if(a!=0){
			success=true;
		}else
			success=false;
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
		return success;
	}
	
	//ProvideSelfBanking 
	public static boolean selfBankingCredentialAdd(String account,String userId,String name,String designation) {
		boolean success=false;
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("INSERT INTO ADMIN(ACCOUNT_NUMBER,USER_ID,PASSWORD,DESIGNATION) VALUES (?,?,?,?)");
			pst.setString(2,userId);
			pst.setString(1,account);
			pst.setString(3,userId+"@SRTMUN");
			pst.setString(4, designation);
			int a=pst.executeUpdate();
			if(a!=0) {
				success=true;
			}else
				success=false;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return success;
	}

	//changePrevious Password
	public static boolean changePassword(String userId,String oldPassword,String newPassword) {
		boolean success=false;
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT PASSWORD FROM ADMIN WHERE USER_ID=?");
			pst.setString(1,userId);
			String password=null;
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				password=r.getString("PASSWORD");
			}
			JOptionPane.showMessageDialog(null, password);
			if(password.equals(oldPassword)) {
				PreparedStatement ust=databaseConnection.prepareStatement("UPDATE ADMIN SET PASSWORD='"+newPassword+"' WHERE USER_ID=?");
				ust.setString(1,userId);
				int a=ust.executeUpdate();
				if(a!=0)
					success=true;
				else
					success=false;
			}else {
				success=false;
				JOptionPane.showMessageDialog(null,"Old Password is wrong...\n\nPlease Check the password and try again");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return success;
	}

	//Close Account of Specific Customer
	public static boolean closeAccount(String account, String name) {
		boolean success=false;
		try {
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT CUSTOMER_NAME FROM CUSTOMER WHERE ACCOUNT_NUMBER=?");
			pst.setString(1,account);
			String cName=null;
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				cName=r.getString("CUSTOMER_NAME");
			}
			JOptionPane.showMessageDialog(null, cName);
			if(cName.equals(name)) {
				PreparedStatement ust=databaseConnection.prepareStatement("DELETE FROM CUSTOMER WHERE ACCOUNT_NUMBER=?");
				ust.setString(1,account);
				int a=ust.executeUpdate();
				PreparedStatement ast=databaseConnection.prepareStatement("DELETE FROM ADMIN WHERE ACCOUNT_NUMBER=?");
				ast.setString(1,account);
				ast.executeUpdate();
				if(a!=0)
					success=true;
				else
					success=false;
			}else {
				success=false;
				JOptionPane.showMessageDialog(null,"Name of Customer is not Matched.....\n\n Please try again..\n\n");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return success;
	}

	//sending/Transfer Money to the same Bank
	public static boolean sendWithinBank(String accountSender,String date, String accountReciever,double amount,String resource) {
		boolean success=false;
		try {
			
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE ACCOUNT_NUMBER=?");
			pst.setString(1,accountSender);
			ResultSet r=pst.executeQuery();
			String cAmount=null;
			if(r.next()) {
				cAmount=r.getString("BALANCE");
			}
			double cBalance=Double.parseDouble(cAmount);
			JOptionPane.showMessageDialog(null, cBalance);
			if(cBalance>=amount) {				
				PreparedStatement ust=databaseConnection.prepareStatement("INSERT INTO TRANSACTIONS(ACCOUNT_NUMBER,DATE,WITHDRAWL,BALANCE,TYPE_W_D) VALUES(?,?,?,?,?)");
				ust.setString(1,accountSender);
				ust.setString(2,date);
				ust.setDouble(3,amount);
				ust.setDouble(4,cBalance-amount);
				ust.setString(5,"Transfer Money to "+accountReciever+" by "+resource);				
				int a=ust.executeUpdate();
				PreparedStatement ast=databaseConnection.prepareStatement("UPDATE CUSTOMER SET BALANCE='"+(cBalance-amount)+"' WHERE ACCOUNT_NUMBER=?");
				ast.setString(1,accountSender);
				ast.executeUpdate();
				if(a!=0)
				{
					PreparedStatement bst=databaseConnection.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE ACCOUNT_NUMBER=?");
					bst.setString(1,accountReciever);
					ResultSet r1=bst.executeQuery();
					if(r1.next()) {
						cBalance=r1.getDouble("BALANCE");
					}
					JOptionPane.showMessageDialog(null, cBalance);
					PreparedStatement gst=databaseConnection.prepareStatement("INSERT INTO TRANSACTIONS(ACCOUNT_NUMBER,DATE,DEPOSIT,BALANCE,TYPE_W_D) VALUES(?,?,?,?,?)");
					gst.setString(1,accountReciever);
					gst.setString(2,date);
					gst.setDouble(3,amount);
					gst.setDouble(4,cBalance+amount);
					gst.setString(5,"Recieved Money from "+accountSender);
					gst.executeUpdate();
					
					
					PreparedStatement rst=databaseConnection.prepareStatement("UPDATE CUSTOMER SET BALANCE='"+(cBalance+amount)+"' WHERE ACCOUNT_NUMBER=?");
					rst.setString(1,accountReciever);
					rst.executeUpdate();
					
					success=true;
				}else
					success=false;
			}else {
				success=false;
				JOptionPane.showMessageDialog(null,"Insufficient Balance in Account.....\n\n Please try again..\n\n");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return success;
	}
	
	//Send or Transfer Money to other Bank
	public static boolean sendOtherBank(String accountSender,String date, String accountReciever,double amount,String resource) {
		boolean success=false;
		try {
			
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE ACCOUNT_NUMBER=?");
			pst.setString(1,accountSender);
			ResultSet r=pst.executeQuery();
			String cAmount=null;
			if(r.next()) {
				cAmount=r.getString("BALANCE");
			}
			double cBalance=Double.parseDouble(cAmount);
			JOptionPane.showMessageDialog(null, cBalance);
			if(cBalance>=amount) {				
				PreparedStatement ust=databaseConnection.prepareStatement("INSERT INTO TRANSACTIONS(ACCOUNT_NUMBER,DATE,WITHDRAWL,BALANCE,TYPE_W_D) VALUES(?,?,?,?,?)");
				ust.setString(1,accountSender);
				ust.setString(2,date);
				ust.setDouble(3,amount);
				ust.setDouble(4,cBalance-amount);
				ust.setString(5,"Transfer Money to "+accountReciever+" by "+resource);				
				int a=ust.executeUpdate();
				if(a!=0)
				{	
					PreparedStatement ast=databaseConnection.prepareStatement("UPDATE CUSTOMER SET BALANCE='"+(cBalance-amount)+"' WHERE ACCOUNT_NUMBER=?");
					ast.setString(1,accountSender);
					ast.executeUpdate();
					success=true;
				}else
					success=false;
			}else {
				success=false;
				JOptionPane.showMessageDialog(null,"Insufficient Balance in Account.....\n\n Please try again..\n\n");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return success;
	}

	//Money Deposit by Branch
	public static boolean deposit(String account, String name, double amount, String today, String resource) {
		boolean success=false;
		try {
			
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE ACCOUNT_NUMBER=?");
			pst.setString(1,account);
			ResultSet r=pst.executeQuery();
			double cBalance=0.0;
			if(r.next()) {
				cBalance=r.getDouble("BALANCE");
			}
			JOptionPane.showMessageDialog(null, cBalance);	
				PreparedStatement ust=databaseConnection.prepareStatement("INSERT INTO TRANSACTIONS(ACCOUNT_NUMBER,DATE,DEPOSIT,BALANCE,TYPE_W_D) VALUES(?,?,?,?,?)");
				ust.setString(1,account);
				ust.setString(2,today);
				ust.setDouble(3,amount);
				ust.setDouble(4,cBalance+amount);
				ust.setString(5,"Deposited Money to "+account+" by "+resource+" at Branch");				
				int a=ust.executeUpdate();
				if(a!=0)
				{	
					PreparedStatement ast=databaseConnection.prepareStatement("UPDATE CUSTOMER SET BALANCE='"+(cBalance+amount)+"' WHERE ACCOUNT_NUMBER=?");
					ast.setString(1,account);
					ast.executeUpdate();
					success=true;
				}else
					success=false;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return success;
	}

	
	//Money WithDrawn At Branch
	public static boolean withdraw(String account, String name, double amount, String today, String resource) {
		boolean success=false;
		try {
			
			PreparedStatement pst=databaseConnection.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE ACCOUNT_NUMBER=?");
			pst.setString(1,account);
			ResultSet r=pst.executeQuery();
			double cBalance=0.0;
			if(r.next()) {
				cBalance=r.getDouble("BALANCE");
			}
			JOptionPane.showMessageDialog(null, cBalance);
			if(amount<=cBalance) {
				PreparedStatement ust=databaseConnection.prepareStatement("INSERT INTO TRANSACTIONS(ACCOUNT_NUMBER,DATE,WITHDRAWL,BALANCE,TYPE_W_D) VALUES(?,?,?,?,?)");
				ust.setString(1,account);
				ust.setString(2,today);
				ust.setDouble(3,amount);
				ust.setDouble(4,cBalance-amount);
				ust.setString(5,"WithDrwan Money from "+account+" by "+resource+" at Branch");				
				int a=ust.executeUpdate();
				if(a!=0)
				{	
					PreparedStatement ast=databaseConnection.prepareStatement("UPDATE CUSTOMER SET BALANCE='"+(cBalance-amount)+"' WHERE ACCOUNT_NUMBER=?");
					ast.setString(1,account);
					ast.executeUpdate();
					success=true;
				}else
					success=false;
			}else
				JOptionPane.showMessageDialog(null,"Available amount is low Please withdrawal within Limit");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return success;
	}


}
