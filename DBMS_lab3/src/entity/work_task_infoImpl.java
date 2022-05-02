package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DBMS.DBUtil;

public class work_task_infoImpl implements work_task_info{

	@Override
	public void add(work_task wt) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="insert into "+
                "work_task(work_task_num,room_num,adm_id,supply)"+" values(?,?,?,?)";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,wt.getWork_task_num());
            pst.setString(2,wt.getRoom_num());
            pst.setString(3,wt.getAdm_id());
            pst.setString(4,wt.getSupply());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "��ӳɹ���");
            
            System.out.println("�ɹ����乤������!");
            
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ�ɹ���������");
        }
	}

	@Override
	public work_task find(String adm_id) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
		work_task wt = new work_task();
        String sql="select * from work_task where adm_id = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, adm_id);
            ResultSet rs=pst.executeQuery();
            rs.next();
           
            wt.setWork_task_num(rs.getString("work_task_num"));
            wt.setRoom_num(rs.getString("room_num"));
            wt.setAdm_id(rs.getString("adm_id"));
            wt.setSupply(rs.getString("supply"));
            
            return wt;

        }catch (SQLException e){
//            e.printStackTrace();
            System.out.println("δ�ҵ���������");
            return null;
        }
	}

	@Override
	public void delete(String wid) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from work_task where work_task_num=?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,wid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ�ɹ�ɾ����������");
        }
	}

}
