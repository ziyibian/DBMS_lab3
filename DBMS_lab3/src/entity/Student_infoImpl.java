package entity;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DBMS.DBUtil;

import java.awt.*;
import java.sql.*;

public class Student_infoImpl implements Student_info{
    //添加学生信息
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="insert into "+
                "Student(Sno,Sname,Ssex,Sage,Sdept,teacher_id)"+" values(?,?,?,?,?,?)";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,student.getSno());
            pst.setString(2,student.getSname());
            pst.setString(3,student.getSsex());
            pst.setInt(4,student.getSage());
            pst.setString(5,student.getSdept());
            pst.setString(6, student.getteacher_id());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "添加成功！");
            System.out.println("成功添加学生:"+student.getSno()+student.getSname()+"的信息!");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功添加学生信息！");
        }
	}
    //更新学生信息
	@Override
	public void update(String Sno, Student student) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="update Student set "+
                "Sname=?,Ssex=?,Sage=?,Sdept=?,teacher_id=?"+" WHERE Sno=?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,student.getSname());
            pst.setString(2,student.getSsex());
            pst.setInt(3,student.getSage());
            pst.setString(4,student.getSdept());
            pst.setString(5, student.getteacher_id());
            pst.setString(6,Sno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "学生信息修改成功！");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功修改学生信息！");
        }
	}
    //删除学生信息
	@Override
	public void delete(String Sno) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getCon();
        String sql="delete from Student where Sno=?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,Sno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "学生信息删除成功！");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "未成功删除学生信息！");
        }
	}
    //查找所有学生
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		 List<Student> students=new ArrayList<Student>();
         Connection con=DBUtil.getCon();
         String sql="select * from Student";
         try{
             PreparedStatement pst=con.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
             while(rs.next()){
                 Student stu=new Student();
                 stu.setSno(rs.getString("Sno"));
                 
                 stu.setSname(rs.getString("Sname"));
                 
                 stu.setSsex(rs.getString("Ssex"));
                 
                 stu.setSage(rs.getInt("Sage"));
                 
                 stu.setSdept(rs.getString("Sdept"));
                 
                 stu.setteacher_id(rs.getString("teacher_id"));
                 students.add(stu);
             }
         }catch (SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "未找到学生信息！");
         }
         return students;
	}
    //找到学号为****的学生
	@Override
	public Student find(String Sno) {
		// TODO Auto-generated method stub
		Student stu=new Student();
        Connection con=DBUtil.getCon();
        String sql="select * from Student where Sno = ?";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, Sno);
            ResultSet rs=pst.executeQuery();
            rs.next();
           
            stu.setSno(rs.getString("Sno"));
                   
            stu.setSname(rs.getString("Sname"));
                   
            stu.setSsex(rs.getString("Ssex"));
                   
            stu.setSage(rs.getInt("Sage"));
                   
            stu.setSdept(rs.getString("Sdept"));
                   
            stu.setteacher_id(rs.getString("teacher_id"));
                   
            return stu;

        }catch (SQLException e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "未找到学生信息,请先注册！");
            System.out.println("未找到学生信息");
            return null;
        }
       
	}
	

}
