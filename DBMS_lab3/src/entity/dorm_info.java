package entity;

import java.util.List;

public interface dorm_info {
	//add
    public void add(dormitory dorm);//抽象方法没有方法体
    //修改
    public void update(String room_num,dormitory dorm);
    //删除
    public void delete(String room_num);
    //查询
    public List<dormitory> findAll();
    //部分查询
    public dormitory find(String room_num);
}
