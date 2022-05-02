package DBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class generate_data {
	private String familyName1 = "����Ǯ���������Ի��������������ֺι���������֣л���Ʒ��ڶ����̲�Ԭ��������������¬���ֶ̼�κѦҶ�����˶Ŵ����������ν�����ʯҦ̷���޽�½�¿װ׽�����";
	private String familyName2 = "ŷ����ľ�Ϲ�˾���������Ϲ��������ʸ���������Ľ�����볤������˾ͽ˾����ԯ�������";
    private String girlName = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼��";
    private String boyName = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    private List<String> dept = new ArrayList<String>(Arrays.asList("����ѧ��","����ѧԺ","����ѧԺ","����ѧԺ","����ѧԺ","����ѧԺ","����ѧԺ","����ѧԺ","����ѧԺ","��ѧѧԺ"));
    public String getFamilyName() {
        String str = "";
        int randNum = new Random().nextInt(2) + 1;
        int strLen = randNum == 1 ? familyName1.length() : familyName2.length();
        int index = new Random().nextInt(strLen);
        if (randNum == 1) {
            str = String.valueOf(familyName1.charAt(index));
        } else {
            str = (index & 1) == 0 ? familyName2.substring(index, index + 2) :
                    familyName2.substring(index - 1, index + 1);
        }
        return str;
    }
    public String get_fname (){
        String str = "";
        int strLen = familyName1.length();
        int index = new Random().nextInt(strLen);
        str = String.valueOf(familyName1.charAt(index));
        return str;
    }
    /**
        * ���ܣ��������18-24������
     *
     * @return
     */
    public int getAge() {
        return new Random().nextInt(6) + 18;
    }
  //��һ����̬������ר�����ɵ����ĺ���
    public String getPhoneNum() {
         //������ʵ�ĳ�ʼ�ŶΣ��Ŷ����ڰٶ�������ҵ���ʵ�Ŷ�
    	String[] start = {"133", "149", "153", "173", "177",
	              "180", "181", "189", "199", "130", "131", "132",
                   "145", "155", "156", "166", "171", "175", "176", "185", "186", "166", "134", "135",
                   "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "172",
                   "178", "182", "183", "184", "187", "188", "198", "170", "171"};
   
	      //�������ʵ�Ŷ�   ʹ�������length���ԣ�������鳤�ȣ�
         //ͨ��Math.random����*���鳤�Ȼ�������±꣬�Ӷ������ǰ��λ�ĺŶ�
	      String phoneFirstNum = start[(int) (Math.random() * start.length)];
          //�����ʣ�µ�8λ��
          String phoneLastNum = "";
           //����β�ţ�β����8λ
          final int LENPHONE = 8;
           //ѭ��ʣ�µ�λ��
           for (int i = 0; i < LENPHONE; i++) {
               //ÿ��ѭ������0~9��ѡһ�������
              phoneLastNum += (int) (Math.random() * 10);
           }
            //���ս��Ŷκ�β����������
           String phoneNum = phoneFirstNum + phoneLastNum;
           return phoneNum;
      }
    public void gen_coun() {
    	Connection con=DBUtil.getCon();
        String sql="insert into "+
                "counselor(teacher_id,name,sex,phone_number)"+" values(?,?,?,?)";
        for(int i=1;i<=50;i++)
        {
        	String name = get_fname() + "��";
        	String sex;
        	if(i%2 == 0)
        	{
        		sex = "��";
        	}
        	else
        	{
        		sex = "Ů";
        	}
        	String phone_num = getPhoneNum();
        	try{
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,Integer.toString(i));
                pst.setString(2,name);
                pst.setString(3,sex);
                pst.setString(4,phone_num);
                pst.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "δ�ɹ���Ӹ���Ա��Ϣ��");
            }
        }
        
    }
    public void gen_dormadm() {
    	Connection con=DBUtil.getCon();
        String sql="insert into "+
                "dormitory_adm(adm_id,name,age)"+" values(?,?,?)";
        for(int i=1;i<=50;i++)
        {
        	String name = get_fname() + "��";
        	try{
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,Integer.toString(i));
                pst.setString(2,name);
                pst.setInt(3,getAge()+25);
                pst.executeUpdate();
               
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "δ�ɹ�����޹� ��"+i);
            }
        }
        System.out.println("�ɹ�����޹�");
    }
	public void gen_stu() {
		Connection con=DBUtil.getCon();
		String sql="insert into "+
	                "Student(Sno,Sname,Ssex,Sage,Sdept,teacher_id)"+" values(?,?,?,?,?,?)";
		for(int i=1;i<=3000;i++)
        {
			String sex = "��";
			String name = getFamilyName();
	        int randNum = new Random().nextInt(2) + 1;
	        int strLen = sex.equals("��") ? boyName.length() : girlName.length();
	        int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) :
	                new Random().nextInt(strLen);
	        name = name + (sex.equals("��") ? boyName.substring(index, index + randNum) :
                girlName.substring(index, index + randNum));
	        String teacher_id = Integer.toString(new Random().nextInt(49) + 1);
	        String Sdept = dept.get((i-1)/300);
        	 try{
                 PreparedStatement pst=con.prepareStatement(sql);
                 pst.setString(1,Integer.toString(i));
                 pst.setString(2,name);
                 pst.setString(3,sex);
                 pst.setInt(4,getAge());
                 pst.setString(5,Sdept);
                 pst.setString(6, teacher_id);
                 pst.executeUpdate();
             }catch(SQLException e){
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "δ�ɹ����ѧ����Ϣ��");
             }
        }
		
	}
	public void gen_record() {
		Connection con=DBUtil.getCon();
        String sql1="insert into "+
                "dormitory(room_num,bed_sum)"+" values(?,?)";
        String sql2="insert into "+
                "bed(room_num,bed_num,bed_type)"+" values(?,?,?)";
        String sql3="insert into "+
                "acc_record(stay_num,room_num,bed_num,Sno)"+" values(?,?,?,?)";
        int k=1;
        for(int i=1;i<=7;i++)
        {
        	for(int j=1;j<99;j++)
        	{
        		String room_num=Integer.toString(i*100+j);
        		int bed_sum;
        		
        		String bed_num;
        		String bed_type;
        		
        		if(j%2 == 0)
        		{
        			bed_sum = 6;
        			bed_type = "������";
        		}
        		else
        		{
        			bed_sum = 4;
        			bed_type = "�ϴ�����";
        		}
        		 try{
     	            PreparedStatement pst1=con.prepareStatement(sql1);
     	            pst1.setString(1,room_num);
     	            pst1.setInt(2,bed_sum);
     	            pst1.executeUpdate();
     	        }catch(SQLException e){
     	            e.printStackTrace();
     	            JOptionPane.showMessageDialog(null, "δ�ɹ�������ᣡ");
     	        }
        		for(int m =1;m <=bed_sum;m++)
        		{
        			try {
        			PreparedStatement pst2=con.prepareStatement(sql2);
                    pst2.setString(1,room_num);
                    pst2.setString(2, Integer.toString(m));
                    pst2.setString(3,bed_type); 
                    pst2.executeUpdate();
        			}catch(SQLException e){
        	            e.printStackTrace();
        	            JOptionPane.showMessageDialog(null, "δ�ɹ���Ӵ�λ��");
        	        }
                    if(k<=3000)
                    {
                    	try {
                    	 PreparedStatement pst=con.prepareStatement(sql3);
                         pst.setString(1,Integer.toString(k));
                         pst.setString(2,room_num);
                         pst.setString(3,Integer.toString(m));
                         pst.setString(4,Integer.toString(k));
                         pst.executeUpdate();
                    	}catch(SQLException e){
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "δ�ɹ���Ӽ�¼��");
                        }
                    }
                    else
                    {
                    	System.out.println(room_num);
                    }
                   
        			k++;
        		}
        	    
        	}
        }
	}
	public void test() {
		String sex = "��";
		String name = getFamilyName();
        int randNum = new Random().nextInt(2) + 1;
        int strLen = sex.equals("��") ? boyName.length() : girlName.length();
        int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) :
                new Random().nextInt(strLen);
        name = name + (sex.equals("��") ? boyName.substring(index, index + randNum) :
            girlName.substring(index, index + randNum));
        System.out.println(name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate_data g= new generate_data();
//		String fname = g.get_fname();
//		System.out.println(fname);
//		System.out.println(g.getPhoneNum());
//		g.gen_coun();
//		g.gen_dormadm();
//		g.gen_stu();
//		g.gen_record();
		System.out.println("��ɣ�");
		
	}

}
