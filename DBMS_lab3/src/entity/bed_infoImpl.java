package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

import DBMS.DBUtil;
import entity.bed;
import entity.dormitory;

public class bed_infoImpl implements bed_info{

	@Override
	public void add(bed bd) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="insert into "+
                "bed(room_num,bed_num,bed_type)"+" values(?,?,?)";
        try{
        	
        	//��Ӵ�λ֮ǰ��Ҫ�ȼ�����ᴲλ�Ƿ�����
        	dorm_info dm = new dorm_infoImpl();
        	dormitory dorm = new dormitory();
        	dorm=dm.find(bd.getRoom_num());
        	int bed_count=dorm.getBed_sum();
        	
        	bed_info bf = new bed_infoImpl();
        	List<bed> bds= new ArrayList<bed>();
        	bds=bf.find(bd.getRoom_num());
        	int bed_now_count=bds.size();
        	if(bed_count == bed_now_count)
        	{
        		JOptionPane.showMessageDialog(null, "�����������޷����Ӵ�λ��");
        	}
        	else {
        		PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,bd.getRoom_num());
                pst.setString(2, bd.getBed_num());
                pst.setString(3,bd.getBed_type());
                pst.executeUpdate();
                System.out.println("��ӳɹ�!");
        	}
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "�������Լ����δ�ɹ�������ᣡ");
        }
		
	}

	@Override
	public void update(String room_num, String bed_num,bed bd) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="update bed set "+
                "bed_type = ?"+" WHERE room_num = ? and bed_num =?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,bd.getBed_type());
            pst.setString(2,room_num);
            pst.setString(3,bed_num);
            
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ�ɹ��޸Ĵ�λ��Ϣ!");
        }
	}

	@Override
	public void delete(String room_num, String bed_num) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from bed where room_num= ? and bed_num=?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,room_num);
            pst.setString(2, bed_num);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "���Լ����δ�ɹ�ɾ����λ��");
        }
	}

	@Override
	public List<bed> findAll() {
		// TODO Auto-generated method stub
		List<bed> beds=new ArrayList<bed>();
        Connection con=DBUtil.getCon();
        String sql="select * from bed";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                bed bd = new bed();
                bd.setRoom_num(rs.getString("room_num"));
                bd.setBed_num(rs.getString("bed_num"));
                bd.setBed_type(rs.getString("bed_type"));
                beds.add(bd);
            }
        }catch (SQLException e){
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ��Ӵ�λ��Ϣ��");
        }
        return beds;
		
	}

	@Override
	public List<bed> find(String room_num) {
		// TODO Auto-generated method stub
		 List<bed> beds=new ArrayList<bed>();
		 Connection con=DBUtil.getCon();
	     String sql="select * from bed where room_num = ?";
	     try{
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1,room_num);
	            ResultSet rs=pst.executeQuery();
	            while(rs.next()){
	                bed bd = new bed();
	                bd.setRoom_num(rs.getString("room_num"));
	                bd.setBed_num(rs.getString("bed_num"));
	                bd.setBed_type(rs.getString("bed_type"));
	                beds.add(bd);
	            }
	            return beds;
	        }catch (SQLException e){
//	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "δ��Ӵ�λ��Ϣ��");
	            return null;
	        }
	        
	}
	
	@Override
	public bed find_(String room_num,String bed_num) {
		// TODO Auto-generated method stub
		bed bd = new bed();
		 Connection con=DBUtil.getCon();
	     String sql="select * from bed where room_num = ? and bed_num = ?";
	     try{
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1,room_num);
	            pst.setString(2, bed_num);
	            ResultSet rs=pst.executeQuery();
	            rs.next();
                bd.setRoom_num(rs.getString("room_num"));
                bd.setBed_num(rs.getString("bed_num"));
                bd.setBed_type(rs.getString("bed_type"));
	            return bd;
	        }catch (SQLException e){
//	            e.printStackTrace();
//	            JOptionPane.showMessageDialog(null, "δ�ҵ��ô�λ��");
	        	System.out.println("δ�ҵ��ô�λ!");
	            return null;
	        }
	        
	}

}
