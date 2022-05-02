package entity;

import java.util.List;

public interface dormitory_admin_info {
	//add
    public void add(dormitory_admin dorm_admin);//抽象方法没有方法体
    //修改
    public void update(String admin_num,dormitory_admin admin);
    //删除
    public void delete(String admin_num);
    //查询
    public List<dormitory_admin> findAll();
    //部分查询
    public dormitory_admin find(String admin_num);

}
