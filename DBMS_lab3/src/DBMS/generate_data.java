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
	private String familyName1 = "李王钱张刘陈杨赵黄周吴徐孙胡朱高林何郭马罗梁宋郑谢韩唐冯于董萧程曹袁邓许傅沈曾彭吕苏卢蒋蔡贾丁魏薛叶阎余潘杜戴夏钟汪田任姜范方石姚谭廖邹金陆郝孔白晋楚闫";
	private String familyName2 = "欧阳端木上官司马东方独孤南宫诸葛赫连皇甫宗政公孙慕容钟离长孙宇文司徒司空轩辕令狐百里";
    private String girlName = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";
    private String boyName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    private List<String> dept = new ArrayList<String>(Arrays.asList("计算学部","电信学院","外语学院","材料学院","化工学院","环境学院","航天学院","管理学院","机电学院","数学学院"));
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
        * 功能：随机产生18-24的整数
     *
     * @return
     */
    public int getAge() {
        return new Random().nextInt(6) + 18;
    }
  //定一个静态方法，专门生成单个的号码
    public String getPhoneNum() {
         //给予真实的初始号段，号段是在百度上面查找的真实号段
    	String[] start = {"133", "149", "153", "173", "177",
	              "180", "181", "189", "199", "130", "131", "132",
                   "145", "155", "156", "166", "171", "175", "176", "185", "186", "166", "134", "135",
                   "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "172",
                   "178", "182", "183", "184", "187", "188", "198", "170", "171"};
   
	      //随机出真实号段   使用数组的length属性，获得数组长度，
         //通过Math.random（）*数组长度获得数组下标，从而随机出前三位的号段
	      String phoneFirstNum = start[(int) (Math.random() * start.length)];
          //随机出剩下的8位数
          String phoneLastNum = "";
           //定义尾号，尾号是8位
          final int LENPHONE = 8;
           //循环剩下的位数
           for (int i = 0; i < LENPHONE; i++) {
               //每次循环都从0~9挑选一个随机数
              phoneLastNum += (int) (Math.random() * 10);
           }
            //最终将号段和尾数连接起来
           String phoneNum = phoneFirstNum + phoneLastNum;
           return phoneNum;
      }
    public void gen_coun() {
    	Connection con=DBUtil.getCon();
        String sql="insert into "+
                "counselor(teacher_id,name,sex,phone_number)"+" values(?,?,?,?)";
        for(int i=1;i<=50;i++)
        {
        	String name = get_fname() + "导";
        	String sex;
        	if(i%2 == 0)
        	{
        		sex = "男";
        	}
        	else
        	{
        		sex = "女";
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
                JOptionPane.showMessageDialog(null, "未成功添加辅导员信息！");
            }
        }
        
    }
    public void gen_dormadm() {
    	Connection con=DBUtil.getCon();
        String sql="insert into "+
                "dormitory_adm(adm_id,name,age)"+" values(?,?,?)";
        for(int i=1;i<=50;i++)
        {
        	String name = get_fname() + "姨";
        	try{
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,Integer.toString(i));
                pst.setString(2,name);
                pst.setInt(3,getAge()+25);
                pst.executeUpdate();
               
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "未成功添加宿管 ！"+i);
            }
        }
        System.out.println("成功添加宿管");
    }
	public void gen_stu() {
		Connection con=DBUtil.getCon();
		String sql="insert into "+
	                "Student(Sno,Sname,Ssex,Sage,Sdept,teacher_id)"+" values(?,?,?,?,?,?)";
		for(int i=1;i<=3000;i++)
        {
			String sex = "男";
			String name = getFamilyName();
	        int randNum = new Random().nextInt(2) + 1;
	        int strLen = sex.equals("男") ? boyName.length() : girlName.length();
	        int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) :
	                new Random().nextInt(strLen);
	        name = name + (sex.equals("男") ? boyName.substring(index, index + randNum) :
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
                 JOptionPane.showMessageDialog(null, "未成功添加学生信息！");
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
        			bed_type = "上下铺";
        		}
        		else
        		{
        			bed_sum = 4;
        			bed_type = "上床下桌";
        		}
        		 try{
     	            PreparedStatement pst1=con.prepareStatement(sql1);
     	            pst1.setString(1,room_num);
     	            pst1.setInt(2,bed_sum);
     	            pst1.executeUpdate();
     	        }catch(SQLException e){
     	            e.printStackTrace();
     	            JOptionPane.showMessageDialog(null, "未成功添加宿舍！");
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
        	            JOptionPane.showMessageDialog(null, "未成功添加床位！");
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
                            JOptionPane.showMessageDialog(null, "未成功添加记录！");
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
		String sex = "男";
		String name = getFamilyName();
        int randNum = new Random().nextInt(2) + 1;
        int strLen = sex.equals("男") ? boyName.length() : girlName.length();
        int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) :
                new Random().nextInt(strLen);
        name = name + (sex.equals("男") ? boyName.substring(index, index + randNum) :
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
		System.out.println("完成！");
		
	}

}
