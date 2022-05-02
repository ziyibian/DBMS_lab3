package entity;

import java.util.List;

public interface record_info {
	//add
    public void add(acc_record ar);//抽象方法没有方法体
    

    //删除
    public void delete(String Sno);
    
    
    //部分查询
    public acc_record find(String Sno);
    
    public acc_record find(String room_num,String bed_num);
    
    public List<acc_record> find_(String room_num);

}
