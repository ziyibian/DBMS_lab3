package entity;

public interface work_task_info {
	
	//add
    public void add(work_task wt);//抽象方法没有方法体
    
    //find
    public work_task find(String adm_id);
    
    //delete
    public void delete(String wid);

}
