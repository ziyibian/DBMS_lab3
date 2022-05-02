package entity;

import java.util.List;

public interface bed_info {
	//add
    public void add(bed bd);//抽象方法没有方法体
    //修改
    public void update(String room_num,String bed_num,bed bd);
    //删除
    public void delete(String room_num,String bed_num);
    //查询
    public List<bed> findAll();
    //部分查询
    public List<bed> find(String room_num);
    
	public bed find_(String room_num, String bed_num);

}
