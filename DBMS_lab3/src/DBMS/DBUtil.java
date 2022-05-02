package DBMS;
import java.sql.*;

import javax.swing.*;

import ui.login;
public class DBUtil {
	static String url="jdbc:mysql:"+"//localhost:3306/domitory_manage?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    static String root="root";
    static String password="12345bzy";
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getCon(){
        Connection con=null;
        try{
            con=DriverManager.getConnection(url,root,password);
            System.out.println("hello,Mysql连接成功");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未连接到数据库！");
        }
        return con;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
		login f = new login();
		f.pack();
        //标题
        f.setTitle("登录界面");
        //设置
        f.setSize(500,350);
        //窗口退出行为
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口打开居中
        f.setLocationRelativeTo(null);
        //展示窗口
        f.setVisible(true);
	}

}
