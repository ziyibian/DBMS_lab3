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
            System.out.println("hello,Mysql���ӳɹ�");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ���ӵ����ݿ⣡");
        }
        return con;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
		login f = new login();
		f.pack();
        //����
        f.setTitle("��¼����");
        //����
        f.setSize(500,350);
        //�����˳���Ϊ
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ô��ڴ򿪾���
        f.setLocationRelativeTo(null);
        //չʾ����
        f.setVisible(true);
	}

}
