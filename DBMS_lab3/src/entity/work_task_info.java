package entity;

public interface work_task_info {
	
	//add
    public void add(work_task wt);//���󷽷�û�з�����
    
    //find
    public work_task find(String adm_id);
    
    //delete
    public void delete(String wid);

}
