package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DBMS.DBUtil;

public class coun_infoImpl implements coun_info{

	@Override
	public void add(counselor coun) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="insert into "+
                "counselor(teacher_id,name,sex,phone_number)"+" values(?,?,?,?)";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,coun.getTeacher_id());
            pst.setString(2,coun.getName());
            pst.setString(3,coun.getSex());
            pst.setString(4,coun.getPhonenumber());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "��ӳɹ���");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ�ɹ���Ӹ���Ա��Ϣ��");
        }
	}

	@Override
	public void update(String teacher_id, counselor coun) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
		 String sql="update counselor set "+
	                "name = ?,sex = ?,phone_number = ?"+" WHERE teacher_id=?";
		 try{
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1,coun.getName());
	            pst.setString(2,coun.getSex());
	            pst.setString(3,coun.getPhonenumber());
	            pst.setString(4,teacher_id);
	            pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "����Ա��Ϣ�޸ĳɹ���");
	        }catch (SQLException e){
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "δ�ɹ����¸���Ա��Ϣ��");
	        }
	}

	@Override
	public counselor find(String teacher_id) {
		// TODO Auto-generated method stub
		counselor coun=new counselor();
        Connection con=DBUtil.getCon();
        String sql="select * from counselor where teacher_id = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, teacher_id);
            ResultSet rs=pst.executeQuery();
            rs.next();
            coun.setTeacher_id(rs.getString("teacher_id"));
            coun.setName(rs.getString("name"));
            coun.setSex(rs.getString("sex"));
            coun.setPhonenumber(rs.getString("phone_number"));
            return coun;
        }catch (SQLException e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "δ�ҵ�����Ա��Ϣ��");
        	System.out.println("δ�ҵ�����Ա��Ϣ��");
        	return null;
        }
        
	}

	@Override
	public void del(String teacher_id) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from counselor where teacher_id=?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,teacher_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
        }catch (SQLException e){
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "�������Լ����δ�ɹ�ɾ������Ա��Ϣ��");
        }
	}

}
