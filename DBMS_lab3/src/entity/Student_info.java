package entity;

import java.util.List;

public interface Student_info {
	
	//add
    public void add(Student student);//抽象方法没有方法体
    //修改
    public void update(String Sno,Student student);
    //删除
    public void delete(String Sno);
    //查询
    public List<Student> findAll();
    //部分查询
    public Student find(String Sno);

}
