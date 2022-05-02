package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DBMS.DBUtil;

public class dormitory_admin_infoImpl implements dormitory_admin_info{

	@Override
	public void add(dormitory_admin dorm_admin) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="insert into "+
                "dormitory_adm(adm_id,name,age)"+" values(?,?,?)";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,dorm_admin.getAdm_id());
            pst.setString(2,dorm_admin.getName());
            pst.setInt(3,dorm_admin.getAge());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "��ӳɹ� ��");
            
            System.out.println("�ɹ�����޹�:"+dorm_admin.getAdm_id()+dorm_admin.getName()+"����Ϣ!");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ�ɹ�����޹� ��");
        }
	}

	@Override
	public void update(String admin_num, dormitory_admin admin) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="update dormitory_adm set "+
                "name=?,age=?"+" WHERE adm_id=?";
        try{
//        	dormitory_admin ad = find(admin.getAdm_id());
//        	if(ad == null)
//        	{
//        		System.out.println("δ�ҵ����޹ܣ��޷��޸ģ�");
//        	}
        	PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,admin.getName());
            pst.setInt(2,admin.getAge());
            pst.setString(3, admin_num);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
            
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δ�ɹ��޸��޹���Ϣ��");
        }
	}

	@Override
	public void delete(String admin_num) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from dormitory_adm where adm_id=?";
        try{
        	 PreparedStatement pst=con.prepareStatement(sql);
             pst.setString(1,admin_num);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "ɾ���ɹ���");

           
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "δɾ���޹�,�������Լ����");
        }
	}

	@Override
	public List<dormitory_admin> findAll() {
		// TODO Auto-generated method stub
		 List<dormitory_admin> admins=new ArrayList<dormitory_admin>();
         Connection con=DBUtil.getCon();
         String sql="select * from dormitory_adm";
         try{
             PreparedStatement pst=con.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
             while(rs.next()){
                 dormitory_admin ad = new dormitory_admin();
                 ad.setAdm_id(rs.getString("admin_id"));
                 ad.setName(rs.getString("name"));
                 ad.setAge(rs.getInt("age"));
                 admins.add(ad);
             }
             return admins;
         }catch (SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "��������޹���Ϣ��");
             return null;
         }
         
	}

	@Override
	public dormitory_admin find(String admin_num) {
		// TODO Auto-generated method stub
		  dormitory_admin ad = new dormitory_admin();
		  Connection con=DBUtil.getCon();
	      String sql="select * from dormitory_adm where adm_id = ?";
	        try{
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1, admin_num);
	            ResultSet rs=pst.executeQuery();
	            rs.next();
	            ad.setAdm_id(rs.getString("adm_id"));
                ad.setName(rs.getString("name"));
                
                System.out.println(ad.getName());
                
                ad.setAge(rs.getInt("age"));
                
                return ad;
	        }catch (SQLException e){
//	            e.printStackTrace();
//	            JOptionPane.showMessageDialog(null, "δ�ҵ����޹ܣ�");
	        	System.out.println("δ�ҵ����޹ܣ�");
	            return null;
	        }
	}

}
