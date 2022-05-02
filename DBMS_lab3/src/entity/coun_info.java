package entity;

import java.util.List;

public interface coun_info {
	//add
    public void add(counselor coun);//抽象方法没有方法体
    //修改
    public void update(String teacher_id,counselor coun);
    //删除
    public void del(String teacher_id);
    //查询
    public counselor find(String teacher_id);

}