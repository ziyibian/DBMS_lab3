package entity;

import java.util.List;

public interface coun_info {
	//add
    public void add(counselor coun);//���󷽷�û�з�����
    //�޸�
    public void update(String teacher_id,counselor coun);
    //ɾ��
    public void del(String teacher_id);
    //��ѯ
    public counselor find(String teacher_id);

}