package entity;

import java.util.List;

public interface dep_info {
	//add
    public void add(dependent dep);//���󷽷�û�з�����
    //�޸�
    public void update(String Sno,String name,dependent dep);
    //ɾ��
    public void delete(String Sno,String name);
    
    public void delete(String Sno);
    //��ѯ
    public List<dependent> find(String Sno);
    
    public dependent find(String Sno,String name);

}
