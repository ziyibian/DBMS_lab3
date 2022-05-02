package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DBMS.DBUtil;

public class dep_infoImpl implements dep_info{

	@Override
	public void add(dependent dep) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="insert into "+
                "dependent(Sno,name,sex,relationship,phone_number)"+" values(?,?,?,?,?)";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,dep.getSno());
            pst.setString(2,dep.getName());
            pst.setString(3,dep.getSex());
            pst.setString(4,dep.getRelationship());
            pst.setString(5,dep.getPhone_number());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "联系人添加成功！");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功添加联系人信息！");
        }
	}

	@Override
	public void update(String Sno, String name, dependent dep) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="update dependent set "+
                "name=?,sex=?,relationship = ?,phone_number = ?"+" WHERE Sno=? and name= ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, dep.getName());
            pst.setString(2,dep.getSex());
            pst.setString(3,dep.getRelationship());
            pst.setString(4,dep.getPhone_number());
            pst.setString(5, Sno);
            pst.setString(6,name);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "联系人修改成功！");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功更新联系人信息！");
        }
	}

	@Override
	public void delete(String Sno, String name) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from dependeent where Sno=? and name = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,Sno);
            pst.setString(2,name);
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功删除联系人信息！");
        }
	}

	@Override
	public List<dependent> find(String Sno) {
		// TODO Auto-generated method stub
		List<dependent> deps=new ArrayList<dependent>();
        Connection con=DBUtil.getCon();
        String sql="select * from dependent where Sno = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, Sno);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                dependent dep=new dependent();
                dep.setSno(rs.getString("Sno"));
                
                dep.setName(rs.getString("name"));
                
                dep.setSex(rs.getString("sex"));
                
                dep.setRelationship(rs.getString("relationship"));
                
                dep.setPhone_number(rs.getString("phone_number"));
                
                deps.add(dep);
               
            }
            return deps;
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未找到该联系人信息！");
            return null;
        }
       
	}
	@Override
	public dependent find(String Sno, String name) {
		// TODO Auto-generated method stub
		dependent dep=new dependent();
        Connection con=DBUtil.getCon();
        String sql="select * from dependent where Sno = ? and name = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,Sno);
            pst.setString(2, name);
            ResultSet rs=pst.executeQuery();
            
            	rs.next();
                dep.setSno(rs.getString("Sno"));
                
                dep.setName(rs.getString("name"));
                
                dep.setSex(rs.getString("sex"));
                
                dep.setRelationship(rs.getString("relationship"));
                
                dep.setPhone_number(rs.getString("phone_number"));
                return dep;
        }catch (SQLException e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "未找到该联系人信息！");
            System.out.println("未找到该联系人信息！");
            return null;
        }
	}

	@Override
	public void delete(String Sno) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from dependent where Sno=?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,Sno);
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功删除联系人信息！");
        }
	}

	

}
