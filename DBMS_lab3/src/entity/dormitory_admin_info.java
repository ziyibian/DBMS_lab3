package entity;

import java.util.List;

public interface dormitory_admin_info {
	//add
    public void add(dormitory_admin dorm_admin);//���󷽷�û�з�����
    //�޸�
    public void update(String admin_num,dormitory_admin admin);
    //ɾ��
    public void delete(String admin_num);
    //��ѯ
    public List<dormitory_admin> findAll();
    //���ֲ�ѯ
    public dormitory_admin find(String admin_num);

}
