package entity;

import java.util.List;

public interface Student_info {
	
	//add
    public void add(Student student);//���󷽷�û�з�����
    //�޸�
    public void update(String Sno,Student student);
    //ɾ��
    public void delete(String Sno);
    //��ѯ
    public List<Student> findAll();
    //���ֲ�ѯ
    public Student find(String Sno);

}
