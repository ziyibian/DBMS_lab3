package entity;

import java.util.List;

public interface record_info {
	//add
    public void add(acc_record ar);//���󷽷�û�з�����
    

    //ɾ��
    public void delete(String Sno);
    
    
    //���ֲ�ѯ
    public acc_record find(String Sno);
    
    public acc_record find(String room_num,String bed_num);
    
    public List<acc_record> find_(String room_num);

}
