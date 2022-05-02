package entity;

import java.util.List;

public interface dep_info {
	//add
    public void add(dependent dep);//抽象方法没有方法体
    //修改
    public void update(String Sno,String name,dependent dep);
    //删除
    public void delete(String Sno,String name);
    
    public void delete(String Sno);
    //查询
    public List<dependent> find(String Sno);
    
    public dependent find(String Sno,String name);

}
