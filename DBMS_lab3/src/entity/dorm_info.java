package entity;

import java.util.List;

public interface dorm_info {
	//add
    public void add(dormitory dorm);//���󷽷�û�з�����
    //�޸�
    public void update(String room_num,dormitory dorm);
    //ɾ��
    public void delete(String room_num);
    //��ѯ
    public List<dormitory> findAll();
    //���ֲ�ѯ
    public dormitory find(String room_num);
}
