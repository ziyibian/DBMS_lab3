package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DBMS.DBUtil;

public class record_infoImpl implements record_info{

	@Override
	public void add(acc_record ar) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="insert into "+
                "acc_record(stay_num,room_num,bed_num,Sno)"+" values(?,?,?,?)";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ar.getStay_num());
            pst.setString(2,ar.getRoom_num());
            pst.setString(3,ar.getBed_num());
            pst.setString(4,ar.getSno());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "��ӳɹ���");
            System.out.println("�ɹ����ѧ��:"+ar.getSno()+"����ס��¼!");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "�������Լ����δ�ɹ���Ӽ�¼��");
        }
	}

	@Override
	public void delete(String Sno) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from acc_record where Sno=?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,Sno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "��ס��¼ɾ���ɹ���");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ�ɹ�ɾ����ס��¼��");
        }
	}

	@Override
	public acc_record find(String Sno) {
		// TODO Auto-generated method stub
		acc_record ar = new acc_record();
        Connection con=DBUtil.getCon();
        String sql="select * from acc_record where Sno = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, Sno);
            ResultSet rs=pst.executeQuery();
            rs.next();
           
        	ar.setStay_num(rs.getString("stay_num"));
        	ar.setRoom_num(rs.getString("room_num"));
        	ar.setBed_num(rs.getString("bed_num"));
        	ar.setSno(rs.getString("Sno"));
           
            return ar;

        }catch (SQLException e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "δ�ҵ�ѧ����Ϣ,����ע�ᣡ");
            System.out.println("δ�ҵ���ѧ����ס��¼");
            return null;
        }
	}

	@Override
	public acc_record find(String room_num, String bed_num) {
		// TODO Auto-generated method stub
		acc_record ar = new acc_record();
        Connection con=DBUtil.getCon();
        String sql="select * from acc_record where room_num = ? and bed_num=?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, room_num);
            pst.setString(2, bed_num);
            ResultSet rs=pst.executeQuery();
            rs.next();
        	ar.setStay_num(rs.getString("stay_num"));
        	ar.setRoom_num(rs.getString("room_num"));
        	ar.setBed_num(rs.getString("bed_num"));
        	ar.setSno(rs.getString("Sno"));
        	return ar;

        }catch (SQLException e){
//            e.printStackTrace();
            System.out.println("δ�ҵ��ô�λ��ס��¼");
            return null;
        }
	}
	
	@Override
	public List<acc_record> find_(String room_num) {
		// TODO Auto-generated method stub
		
		List<acc_record> ar_list = new ArrayList<acc_record>();
        Connection con=DBUtil.getCon();
        String sql="select * from acc_record where room_num = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, room_num);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
            	acc_record ar = new acc_record();
            	ar.setStay_num(rs.getString("stay_num"));
            	ar.setRoom_num(rs.getString("room_num"));
            	ar.setBed_num(rs.getString("bed_num"));
            	ar.setSno(rs.getString("Sno"));
            	ar_list.add(ar);
            }
           
        	return ar_list;

        }catch (SQLException e){
//            e.printStackTrace();
            System.out.println("δ�ҵ��ô�λ��ס��¼");
            return null;
        }
	}

}
