package entity;

import java.util.List;

public interface bed_info {
	//add
    public void add(bed bd);//���󷽷�û�з�����
    //�޸�
    public void update(String room_num,String bed_num,bed bd);
    //ɾ��
    public void delete(String room_num,String bed_num);
    //��ѯ
    public List<bed> findAll();
    //���ֲ�ѯ
    public List<bed> find(String room_num);
    
	public bed find_(String room_num, String bed_num);

}
