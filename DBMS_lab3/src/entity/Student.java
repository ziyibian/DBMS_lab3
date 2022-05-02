package entity;

public class Student {
    private String Sno;
    private String Sname;
    private String Ssex;
    private int Sage;
    private String Sdept;
    private String teacher_id;
    public String getSno()
    {
    	return Sno;
    }
    public String getSname()
    {
    	return Sname;
    }
    public String getSsex()
    {
    	return Ssex;
    }
    public int getSage()
    {
    	return Sage;
    }
    public String getSdept()
    {
    	return Sdept;
    }
    public String getteacher_id() 
    {
    	return teacher_id;
    }
    public void setSno(String Sno)
    {
    	this.Sno=Sno;
    }
    public void setSname(String Sname)
    {
    	this.Sname=Sname;
    }
    public void setSsex(String Ssex)
    {
    	this.Ssex = Ssex;
    }
    public void setSage(int Sage)
    {
    	this.Sage = Sage;
    }
    public void setSdept(String Sdept)
    {
    	this.Sdept = Sdept;
    }
    public void setteacher_id(String teacher_id) 
    {
    	this.teacher_id = teacher_id;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
