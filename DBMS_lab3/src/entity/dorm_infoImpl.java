package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DBMS.DBUtil;

public class dorm_infoImpl implements dorm_info {

	@Override
	public void add(dormitory dorm) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="insert into "+
                "dormitory(room_num,bed_sum)"+" values(?,?)";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,dorm.getRoom_num());
            pst.setInt(2,dorm.getBed_sum());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "添加成功！");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功添加宿舍！");
        }
		
	}

	@Override
	public void update(String room_num, dormitory dorm) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="update dormitory set "+
                "bed_sum = ?"+" WHERE room_num = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,dorm.getBed_sum());
            pst.setString(2,room_num);
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功修改宿舍信息!");
        }
	}

	@Override
	public void delete(String room_num) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from dormitory where room_num= ? ";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,room_num);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "删除成功！");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功删除宿舍房间！");
        }
	}

	@Override
	public List<dormitory> findAll() {
		// TODO Auto-generated method stub
		List<dormitory> dorms=new ArrayList<dormitory>();
        Connection con=DBUtil.getCon();
        String sql="select * from dormitory";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                dormitory dorm=new dormitory();
                dorm.setRoom_num(rs.getString("room_num"));
                
                dorm.setBed_sum(rs.getInt("bed_sum"));
                dorms.add(dorm);
            }
        }catch (SQLException e){
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未添加宿舍信息！");
        }
        return dorms;
	}

	@Override
	public dormitory find(String room_num) {
		// TODO Auto-generated method stub
		 dormitory dorm = new dormitory();
		 Connection con=DBUtil.getCon();
	     String sql="select * from dormitory where room_num = ?";
	     try{
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1,room_num);
	            ResultSet rs=pst.executeQuery();
	            rs.next();
	            dorm.setRoom_num(rs.getString("room_num"));
	            dorm.setBed_sum(rs.getInt("bed_sum"));
	            return dorm;
	        }catch (SQLException e){
//	            e.printStackTrace();
//	            JOptionPane.showMessageDialog(null, "该宿舍还未添加，请先添加该宿舍！");
	        	System.out.println( "未找到该宿舍！");
	        	return null;
	        }
	     
	}

}
