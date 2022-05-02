package ui;

import javax.swing.*;


import entity.Student;
import entity.Student_info;
import entity.Student_infoImpl;
import entity.bed_info;
import entity.bed_infoImpl;
import entity.coun_info;
import entity.coun_infoImpl;
import entity.counselor;
import entity.dorm_info;
import entity.dorm_infoImpl;
import entity.dormitory;
import entity.dormitory_admin;
import entity.dormitory_admin_info;
import entity.dormitory_admin_infoImpl;
import entity.record_info;
import entity.record_infoImpl;
import entity.work_task_info;
import entity.work_task_infoImpl;
import entity.bed;
import entity.acc_record;
import entity.work_task;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.login;

public class admin_ui extends JFrame implements ActionListener{
	private JTabbedPane jtp;
	private JPanel
	    jp1=new JPanel(),
	    jp2=new JPanel(),
	    jp3=new JPanel();
	 private JLabel
        label,
        label1,
        label2,
        label3,
        log_out = new JLabel("点击此处返回登陆界面"),
//        line = new JLabel("***********************************************************************"
//        		+ "*********************************************************************************"),
//        line_1 = line,
        Stu =new JLabel("学生"),
        counselor = new JLabel("辅导员"),
        dorm_adm = new JLabel("宿管"),
        Sno_1 = new JLabel("学号"),
        Sname_1 = new JLabel("姓名"),
        Ssex_1 = new JLabel("性别"),
        Sage_1 = new JLabel("年龄"),
        Sdept_1 = new JLabel("院系"),
             
        teacher_id_1 = new JLabel("教职工号"),
        coun_name_1 = new JLabel("姓名"),
        coun_sex_1	= new JLabel("性别"),
        coun_phone_1 = new JLabel("联系方式"),
                
        adm_id_1 = new JLabel("宿管号"),
        adm_name_1 = new JLabel("姓名"),
        adm_age_1 = new JLabel("年龄"),
        
        //jp2
        dorm = new JLabel("宿舍"),
        room_num1_1 = new JLabel("寝室号"),
        bed_sum_1 = new JLabel("床位数"),
        
        bed = new JLabel("床"),
        room_num2_1 = new JLabel("寝室号"),
        bed_num_1 = new JLabel("床号"),
        bed_type_1 = new JLabel("床的类型"),
        
        acc_record = new JLabel("安排床位"),
        stay_num_1 = new JLabel("入住编号"),
        room_num3_1 = new JLabel("寝室号"),
        bed_num1_1 = new JLabel("床号"),
        Sno1_1 = new JLabel("学号"),
        
        //jp3
        work_task = new JLabel("工作任务"),
        work_task_num_1 = new JLabel("任务编号"),
        room_num4_1 = new JLabel("寝室号"),
        adm_id1_1 = new JLabel("宿管号"),
        supply_1 = new JLabel("保修品");
        
        
        
        
        
	 
	 private JTextField 
         Sno = new JTextField(),
         Sname = new JTextField(),
         Sage = new JTextField(),
         Sdept = new JTextField(),
      
         teacher_id = new JTextField(),
         coun_name = new JTextField(),
         coun_phone = new JTextField(),
         
         adm_id = new JTextField(),
         adm_name = new JTextField(),
         adm_age = new JTextField(),
         
         //jp2
         room_num1 = new JTextField(),
         bed_sum = new JTextField(),
         
         room_num2 = new JTextField(),
         bed_num = new JTextField(),
         bed_type = new JTextField(),
         
         stay_num = new JTextField(),
         room_num3 = new JTextField(),
         bed_num1 = new JTextField(),
         Sno1 = new JTextField(),
         
         //jp3
         work_task_num = new JTextField(),
         room_num4 = new JTextField(),
         adm_id1 = new JTextField(),
         supply = new JTextField();
         
         
     
        
      private JButton
         add_coun = new JButton("保存导员"),
         add_stu = new JButton("保存学生"),
         add_dorm_admin = new JButton("保存宿管"),
         del_stu = new JButton("删除"),
         del_coun = new JButton("删除"),
         del_adm = new JButton("删除"),
         find_stu = new JButton("查询"),
         find_coun = new JButton("查询"),
         find_adm = new JButton("查询"),
         logout = new JButton("退出登录"),
         
         add_dorm = new JButton("添加宿舍"),
         add_bed = new JButton("添加床位"),
         add_acc_record = new JButton("分配床位"),
         find_dorm = new JButton("查询"),
         find_record_by_Sno = new JButton("按学号查询"),
         find_record_by_rab = new JButton("按床位查询"),
         del_dorm = new JButton("删除"),
         del_bed = new JButton("删除"),
         
         add_work_task = new JButton("添加任务"),
         del_work_task = new JButton("删除");
         
         
	    
	public admin_ui()
	{
		super("管理员界面");
		setSize(1000,900);
		Container c = getContentPane();
		c.add(logout);
		logout.setBounds(90,800,120,30);
	    logout.setFont(new Font(null, Font.BOLD, 18));
	    
	    c.add(log_out);
	    log_out.setBounds(250,800,200,30);
	    log_out.setFont(new Font(null, Font.BOLD, 18));
	    log_out.setForeground(Color.orange);
		//创建选项卡面板对象
		jtp = new JTabbedPane(JTabbedPane.TOP);
		
		//jp1 人事管理
		
		 JRadioButton radioBtn01 = new JRadioButton("男");
	     JRadioButton radioBtn02 = new JRadioButton("女");

	        // 创建按钮组，把两个单选按钮添加到该组
	        ButtonGroup btnGroup_1 = new ButtonGroup();
	        btnGroup_1.add(radioBtn01);
	        btnGroup_1.add(radioBtn02);
	        
	        JRadioButton radioBtn03 = new JRadioButton("男");
	        JRadioButton radioBtn04 = new JRadioButton("女");
	        ButtonGroup btnGroup_2 = new ButtonGroup();
	        btnGroup_2.add(radioBtn03);
	        btnGroup_2.add(radioBtn04);
	        
	    //学生    
		jp1.setLayout(null);
		jp1.add(Stu);
		jp1.add(Sno_1);
		jp1.add(Sno);
		jp1.add(find_stu);
		jp1.add(del_stu);
		jp1.add(Sname_1);
		jp1.add(Sname);
		jp1.add(Ssex_1);
	    jp1.add(radioBtn01);
	    jp1.add(radioBtn02);
		jp1.add(Sage_1);
		jp1.add(Sage);
		jp1.add(Sdept_1);
		jp1.add(Sdept);
		jp1.add(add_stu);
//		jp1.add(line);
		
		
		jp1.add(counselor);
		jp1.add(teacher_id_1);
		jp1.add(teacher_id);
		jp1.add(find_coun);
		jp1.add(del_coun);
		jp1.add(coun_name_1);
		jp1.add(coun_name);
		jp1.add(coun_sex_1);
		jp1.add(radioBtn03);
	    jp1.add(radioBtn04);
		jp1.add(coun_phone_1);
		jp1.add(coun_phone);
		jp1.add(add_coun);
//		jp1.add(line_1);
		
		jp1.add(dorm_adm);
		jp1.add(adm_id_1);
		jp1.add(adm_id);
	    jp1.add(find_adm);
	    jp1.add(del_adm);
		jp1.add(adm_name_1);
		jp1.add(adm_name);
		jp1.add(adm_age_1);
		jp1.add(adm_age);
		jp1.add(add_dorm_admin);
		
		
		/*
                * 组件绝对位置
        */
		//学生
		    Stu.setBounds(90,20,200,30);
	        Stu.setFont(new Font(null, Font.BOLD, 22));
	        Stu.setForeground(Color.BLUE);
	        
	        Sno_1.setBounds(90,60,120,30);
	        Sno_1.setFont(new Font(null, Font.BOLD, 18));
	        Sno.setBounds(200,60,200,30);
	        Sno.setFont(new Font(null, Font.BOLD, 18));
	        
	        find_stu.setBounds(490,60,120,30);
	        find_stu.setFont(new Font(null, Font.BOLD, 18));
	        del_stu.setBounds(650,60,120,30);
	        del_stu.setFont(new Font(null, Font.BOLD, 18));
	        
	        Sname_1.setBounds(90,100,120,30);
	        Sname_1.setFont(new Font(null, Font.BOLD, 18));
	        Sname.setBounds(200,100,200,30);
	        Sname.setFont(new Font(null, Font.BOLD, 18));
	        
	        Ssex_1.setBounds(90,140,50,30);
	        Ssex_1.setFont(new Font(null, Font.BOLD, 18));
	        radioBtn01.setBounds(200,140,50,30);
	        radioBtn01.setBackground(Color.WHITE);
	        radioBtn01.setFont(new Font(null, Font.BOLD, 18));
	        radioBtn02.setBounds(250,140,50,30);
	        radioBtn02.setBackground(Color.WHITE);
	        radioBtn02.setFont(new Font(null, Font.BOLD, 18));
	        
	        Sage_1.setBounds(90,180,120,30);
	        Sage_1.setFont(new Font(null, Font.BOLD, 18));
	        Sage.setBounds(200,180,200,30);
	        Sage.setFont(new Font(null, Font.BOLD, 18));
	        
	        Sdept_1.setBounds(90,220,120,30);
	        Sdept_1.setFont(new Font(null, Font.BOLD, 18));
	        Sdept.setBounds(200,220,200,30);
	        Sdept.setFont(new Font(null, Font.BOLD, 18));
	        
	        add_stu.setBounds(490,220,120,30);
	        add_stu.setFont(new Font(null, Font.BOLD, 18));
//	        line.setBounds(90,260,1000,30);
	        
	        //辅导员
	        counselor.setBounds(90,300,200,30);
	        counselor.setFont(new Font(null, Font.BOLD, 22));
	        counselor.setForeground(Color.BLUE);
	        
	        teacher_id_1.setBounds(90,340,120,30);
	        teacher_id_1.setFont(new Font(null, Font.BOLD, 18));
	        teacher_id.setBounds(200,340,200,30);
	        teacher_id.setFont(new Font(null, Font.BOLD, 18));
	        
	        find_coun.setBounds(490,340,120,30);
	        find_coun.setFont(new Font(null, Font.BOLD, 18));
	        del_coun.setBounds(650,340,120,30);
	        del_coun.setFont(new Font(null, Font.BOLD, 18));
	        
	        coun_name_1.setBounds(90,380,120,30);
	        coun_name_1.setFont(new Font(null, Font.BOLD, 18));
	        coun_name.setBounds(200,380,200,30);
	        coun_name.setFont(new Font(null, Font.BOLD, 18));
	        
	        coun_sex_1.setBounds(90,420,50,30);
	        coun_sex_1.setFont(new Font(null, Font.BOLD, 18));
	        radioBtn03.setBounds(200,420,50,30);
	        radioBtn03.setBackground(Color.WHITE);
	        radioBtn03.setFont(new Font(null, Font.BOLD, 18));
	        radioBtn04.setBounds(250,420,50,30);
	        radioBtn04.setBackground(Color.WHITE);
	        radioBtn04.setFont(new Font(null, Font.BOLD, 18));
	        
	        coun_phone_1.setBounds(90,460,120,30);
	        coun_phone_1.setFont(new Font(null, Font.BOLD, 18));
	        coun_phone.setBounds(200,460,200,30);
	        coun_phone.setFont(new Font(null, Font.BOLD, 18));
	        
	        add_coun.setBounds(490,460,120,30);
	        add_coun.setFont(new Font(null, Font.BOLD, 18));
//	        line_1.setBounds(90,500,1000,30);
	        
	        //宿管
		
	        dorm_adm.setBounds(90,540,200,30);
	        dorm_adm.setFont(new Font(null, Font.BOLD, 22));
	        dorm_adm.setForeground(Color.BLUE);
	        
	        adm_id_1.setBounds(90,580,120,30);
	        adm_id_1.setFont(new Font(null, Font.BOLD, 18));
	        adm_id.setBounds(200,580,200,30);
	        adm_id.setFont(new Font(null, Font.BOLD, 18));
	        
	        find_adm.setBounds(490,580,120,30);
	        find_adm.setFont(new Font(null, Font.BOLD, 18));
	        del_adm.setBounds(650,580,120,30);
	        del_adm.setFont(new Font(null, Font.BOLD, 18));
	        
	        adm_name_1.setBounds(90,620,120,30);
	        adm_name_1.setFont(new Font(null, Font.BOLD, 18));
	        adm_name.setBounds(200,620,200,30);
	        adm_name.setFont(new Font(null, Font.BOLD, 18));
	        
	        adm_age_1.setBounds(90,660,120,30);
	        adm_age_1.setFont(new Font(null, Font.BOLD, 18));
	        adm_age.setBounds(200,660,200,30);
	        adm_age.setFont(new Font(null, Font.BOLD, 18));
	        
	        add_dorm_admin.setBounds(490,660,120,30);
	        add_dorm_admin.setFont(new Font(null, Font.BOLD, 18));
		
		//jp2
	        jp2.setLayout(null);
	        jp2.add(dorm);
	        jp2.add(room_num1_1);
	        jp2.add(room_num1);
	        jp2.add(find_dorm);//查询宿舍信息
	        jp2.add(del_dorm);//外键约束
	        jp2.add(bed_sum_1);
	        jp2.add(bed_sum);
	        jp2.add(add_dorm);//需要判断房间是否已存在
	        
	        jp2.add(bed);
	        jp2.add(room_num2_1);
	        jp2.add(room_num2);
	        jp2.add(bed_num_1);
	        jp2.add(bed_num);  
	        jp2.add(del_bed);//外键约束
	        jp2.add(bed_type_1);
	        jp2.add(bed_type);
	        jp2.add(add_bed);//需要判断是否房间满足
	        
	        jp2.add(acc_record);
	        jp2.add(stay_num_1);
	        jp2.add(stay_num);
	        jp2.add(room_num3_1);
	        jp2.add(room_num3);
	        jp2.add(bed_num1_1);
	        jp2.add(bed_num1);
	        jp2.add(find_record_by_rab);//按床位查询
	        jp2.add(Sno1_1);
	        jp2.add(Sno1);
	        jp2.add(find_record_by_Sno);
	        jp2.add(add_acc_record);
	        
	        /*
	                *     组件绝对位置
	         */
	        //宿舍
	        dorm.setBounds(90,20,200,30);
	        dorm.setFont(new Font(null, Font.BOLD, 22));
	        dorm.setForeground(Color.BLUE);
	        
	        room_num1_1.setBounds(90,60,120,30);
	        room_num1_1.setFont(new Font(null, Font.BOLD, 18));
	        room_num1.setBounds(200,60,200,30);
	        room_num1.setFont(new Font(null, Font.BOLD, 18));
	        
	        find_dorm.setBounds(490,60,120,30);
	        find_dorm.setFont(new Font(null, Font.BOLD, 18));
	        del_dorm.setBounds(650,60,120,30);
	        del_dorm.setFont(new Font(null, Font.BOLD, 18));
	        
	        bed_sum_1.setBounds(90,100,120,30);
	        bed_sum_1.setFont(new Font(null, Font.BOLD, 18));
	        bed_sum.setBounds(200,100,200,30);
	        bed_sum.setFont(new Font(null, Font.BOLD, 18));
	        
	        add_dorm.setBounds(490,100,120,30);
	        add_dorm.setFont(new Font(null, Font.BOLD, 18));
	        
	        //床位
	        bed.setBounds(90,180,200,30);
	        bed.setFont(new Font(null, Font.BOLD, 22));
	        bed.setForeground(Color.BLUE);
	        
	        room_num2_1.setBounds(90,220,120,30);
	        room_num2_1.setFont(new Font(null, Font.BOLD, 18));
	        room_num2.setBounds(200,220,200,30);
	        room_num2.setFont(new Font(null, Font.BOLD, 18));
	        
	        bed_num_1.setBounds(90,260,120,30);
	        bed_num_1.setFont(new Font(null, Font.BOLD, 18));
	        bed_num.setBounds(200,260,200,30);
	        bed_num.setFont(new Font(null, Font.BOLD, 18));
	        
	        del_bed.setBounds(490,260,120,30);
	        del_bed.setFont(new Font(null, Font.BOLD, 18));
	        
	        bed_type_1.setBounds(90,300,120,30);
	        bed_type_1.setFont(new Font(null, Font.BOLD, 18));
	        bed_type.setBounds(200,300,200,30);
	        bed_type.setFont(new Font(null, Font.BOLD, 18));
	        
	        add_bed.setBounds(490,300,120,30);
	        add_bed.setFont(new Font(null, Font.BOLD, 18));
	        
	        //分配床位
	        //床位
	        acc_record.setBounds(90,380,200,30);
	        acc_record.setFont(new Font(null, Font.BOLD, 22));
	        acc_record.setForeground(Color.BLUE);
	        
	        stay_num_1.setBounds(90,420,120,30);
	        stay_num_1.setFont(new Font(null, Font.BOLD, 18));
	        stay_num.setBounds(200,420,200,30);
	        stay_num.setFont(new Font(null, Font.BOLD, 18));
	        
	        room_num3_1.setBounds(90,460,120,30);
	        room_num3_1.setFont(new Font(null, Font.BOLD, 18));
	        room_num3.setBounds(200,460,200,30);
	        room_num3.setFont(new Font(null, Font.BOLD, 18));
	        
	        bed_num1_1.setBounds(90,500,120,30);
	        bed_num1_1.setFont(new Font(null, Font.BOLD, 18));
	        bed_num1.setBounds(200,500,200,30);
	        bed_num1.setFont(new Font(null, Font.BOLD, 18));
	        
	        find_record_by_rab.setBounds(490,500,250,30);
	        find_record_by_rab.setFont(new Font(null, Font.BOLD, 18));
	        
	        Sno1_1.setBounds(90,540,120,30);
	        Sno1_1.setFont(new Font(null, Font.BOLD, 18));
	        Sno1.setBounds(200,540,200,30);
	        Sno1.setFont(new Font(null, Font.BOLD, 18));
	        
	        find_record_by_Sno.setBounds(490,540,250,30);
	        find_record_by_Sno.setFont(new Font(null, Font.BOLD, 18));
		
	        add_acc_record.setBounds(200,600,120,30);
	        add_acc_record.setFont(new Font(null, Font.BOLD, 18));
	     //jp3
	        jp3.setLayout(null);
	        jp3.add(work_task);
	        jp3.add(work_task_num_1);
	        jp3.add(work_task_num);
	        jp3.add(del_work_task);
	        jp3.add(room_num4_1);
	        jp3.add(room_num4);
	        jp3.add(adm_id1_1);
	        jp3.add(adm_id1);
	        jp3.add(supply_1);
	        jp3.add(supply);
	        jp3.add(add_work_task);
	        
	      //组件绝对位置
	        work_task.setBounds(90,20,200,30);
	        work_task.setFont(new Font(null, Font.BOLD, 22));
	        work_task.setForeground(Color.BLUE);
	        
	        work_task_num_1.setBounds(90,60,120,30);
	        work_task_num_1.setFont(new Font(null, Font.BOLD, 18));
	        work_task_num.setBounds(200,60,200,30);
	        work_task_num.setFont(new Font(null, Font.BOLD, 18));
	        
	        del_work_task.setBounds(490,60,120,30);
	        del_work_task.setFont(new Font(null, Font.BOLD, 18));
	        
	        room_num4_1.setBounds(90,100,120,30);
	        room_num4_1.setFont(new Font(null, Font.BOLD, 18));
	        room_num4.setBounds(200,100,200,30);
	        room_num4.setFont(new Font(null, Font.BOLD, 18));
	        
	        adm_id1_1.setBounds(90,140,120,30);
	        adm_id1_1.setFont(new Font(null, Font.BOLD, 18));
	        adm_id1.setBounds(200,140,200,30);
	        adm_id1.setFont(new Font(null, Font.BOLD, 18));
	        
	        supply_1.setBounds(90,180,120,30);
	        supply_1.setFont(new Font(null, Font.BOLD, 18));
	        supply.setBounds(200,180,200,30);
	        supply.setFont(new Font(null, Font.BOLD, 18));
	        
	        
	        add_work_task.setBounds(90,240,120,30);
	        add_work_task.setFont(new Font(null, Font.BOLD, 18));
		//添加选项卡面板
		jtp.add("人事管理", jp1);
		jtp.add("宿舍/床位", jp2);
		jtp.add("任务安排", jp3);
		c.add(jtp);
		ImageIcon image1 = new ImageIcon("src/back_1.jpg");
		label=new JLabel(image1);
        //设置标签大小与位置
        label.setBounds(0, 0,1000,100);
	     //在LayeredPane最底层上添加带图片的标签
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //将内容面板设置为透明，就能够看见添加在LayeredPane上的背景。
        ((JPanel)c).setOpaque(false);
        
        ImageIcon image2 = new ImageIcon("src/back_2.jpg");
        label1=new JLabel(image2);
        //设置标签大小与位置
        label1.setBounds(0, 0,1000,900);
	     //在LayeredPane最底层上添加带图片的标签
        this.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        
        label2=new JLabel(image2);
        //设置标签大小与位置
        label2.setBounds(0, 0,1000,900);
	     //在LayeredPane最底层上添加带图片的标签
        this.getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE));
        
        label3=new JLabel(image2);
        //设置标签大小与位置
        label3.setBounds(0, 0,1000,900);
	     //在LayeredPane最底层上添加带图片的标签
        this.getLayeredPane().add(label3,new Integer(Integer.MIN_VALUE));
        
        jp1.add(label1);
        jp2.add(label2);
        jp3.add(label3);
		
        setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//监听事件
		//退出登录
		logout.addActionListener(this);
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				login f = new login();
				f.pack();
		        //标题
		        f.setTitle("登录界面");
		        //设置
		        f.setSize(500,350);
		        //窗口退出行为
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        //设置窗口打开居中
		        f.setLocationRelativeTo(null);
		        //展示窗口
		        f.setVisible(true);
			}
			
		});
		
//		 add_coun = new JButton("添加导员"),
//		         add_stu = new JButton("添加学生"),
//		         add_dorm_admin = new JButton("添加宿管"),
//		         del_stu = new JButton("删除"),
//		         del_coun = new JButton("删除"),
//		         del_adm = new JButton("删除"),
//		         find_stu = new JButton("查询"),
//		         find_coun = new JButton("查询"),
//		         find_adm = new JButton("查询"),
//		         logout = new JButton("退出登录"),
//		         
//		         add_dorm = new JButton("添加宿舍"),
//		         add_bed = new JButton("添加床位"),
//		         add_acc_record = new JButton("分配床位"),
//		         find_dorm = new JButton("查询"),
//		         find_bed = new JButton("查询"),
//		         find_record_by_Sno = new JButton("按学号查询"),
//		         find_record_by_rab = new JButton("按床位查询"),
//		         del_dorm = new JButton("删除"),
//		         del_bed = new JButton("删除");
		
		
		find_stu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String sno = Sno.getText();
				System.out.println(sno);
				Student_info s = new Student_infoImpl();
				Student stu = new Student();
				stu = s.find(sno);
				//还差显示学生信息的界面
				if(stu  == null) {
					JOptionPane.showMessageDialog(null, "该学生不存在！");
				}
				else
				{
					new show_stuinfo(stu);
				}
				
			}
			
		});
		
		del_stu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String sno = Sno.getText();
				System.out.println("删除"+sno);
				Student_info s = new Student_infoImpl();
				s.delete(sno);
				
			}
			
		});
		
		add_stu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Sno.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "学号不能为空！");
				}
				else if(Sname.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善学生姓名信息！");
				}
				else if(Sage.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善学生年龄信息！");
				}
				else {
					Student stu = new Student();
					Student stu1 = new Student();
					stu.setSno(Sno.getText());
					stu.setSname(Sname.getText());
					if(radioBtn01.isSelected())//不选默认为女
					{
						stu.setSsex("男");
					}else {
						stu.setSsex("女");
					}
					stu.setSage(Integer.parseInt(Sage.getText()));
					stu.setSdept(Sdept.getText());
					stu.setteacher_id(null);
					
					Student_info stu_info=new Student_infoImpl();
					stu1 = stu_info.find(Sno.getText());
					if(stu1 == null) {
						stu_info.add(stu);
					}
					else {
						stu_info.update(Sno.getText(), stu);
					}
				}
			}
		});
		
		find_coun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String tid = teacher_id.getText();
				System.out.println(tid);
				coun_info cf = new coun_infoImpl();
				counselor c= new counselor();
				c = cf.find(tid);
				//还差显示辅导员信息的界面
				if(c == null)
				{
					JOptionPane.showMessageDialog(null, "该辅导员不存在！");
				}
				show_coun_ui.processing(c);
			}
			
		});
		
		del_coun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tid = teacher_id.getText();
				System.out.println(tid);
				coun_info cf = new coun_infoImpl();
				cf.del(teacher_id.getText());
			}
		});
		add_coun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(teacher_id.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "教职工号不能为空!");
				}
				else if(coun_name.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善姓名信息!");
				}
				else if(coun_phone.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善联系方式！");
				}
				else
				{
					coun_info cf = new coun_infoImpl();
					counselor c = new counselor();
					counselor c1 = new counselor();
					c.setTeacher_id(teacher_id.getText());
					c.setName(coun_name.getText());
					if(radioBtn01.isSelected())//不选默认为女
					{
						c.setSex("男");
					}else {
						c.setSex("女");
					}
					c.setPhonenumber(coun_phone.getText());
					c1=cf.find(teacher_id.getText());
					if(c1==null)
					{
						cf.add(c);
					}
					else
					{
						cf.update(teacher_id.getText(), c);
					}
				}
			}	
		});
		
		find_adm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String aid = adm_id.getText();
				System.out.println(aid);
				dormitory_admin_info df = new dormitory_admin_infoImpl();
				dormitory_admin da= new dormitory_admin();
				da = df.find(aid);
				//差查询界面
				if(da == null)
				{
					JOptionPane.showMessageDialog(null, "该宿管不存在！");
				}
				else
				{
					show_dorm_adm_ui.processing(da);
				}
			}
		});
		
		del_adm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String aid = adm_id.getText();
				System.out.println(aid);
				dormitory_admin_info df = new dormitory_admin_infoImpl();
				df.delete(aid);
			}
			
		});
		
	    add_dorm_admin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(adm_id.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "宿管号不能为空!");
				}
				else if(adm_name.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善姓名信息!");
				}
				else if(adm_age.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善年龄信息！");
				}
				else
				{
					dormitory_admin_info df = new dormitory_admin_infoImpl();
					dormitory_admin d= new dormitory_admin();
					dormitory_admin d1= new dormitory_admin();
					d.setAdm_id(adm_id.getText());
					d.setName(adm_name.getText());
					d.setAge(Integer.parseInt(adm_age.getText()));
					
					System.out.println(adm_id.getText());
					d1 = df.find(adm_id.getText());

					if(d1==null)
					{
						df.add(d);
					}
					else
					{
						df.update(adm_id.getText(), d);
					}
					
				}
				
			}
	    	
	    });
	    //宿舍房间
	    find_dorm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String rid = room_num1.getText();
				System.out.println(rid);
				dorm_info df = new dorm_infoImpl();
				dormitory d = new dormitory();
				d = df.find(room_num1.getText());
				if(d == null)
				{
					JOptionPane.showMessageDialog(null, "该宿舍不存在！");
				}
				//还差显示界面
				else
				{
					show_dorm_ui.processing(d);
				}
			}
	    	
	    });
	    
	    del_dorm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String rid = room_num1.getText();
				System.out.println(rid);
				dorm_info df = new dorm_infoImpl();
				df.delete(room_num1.getText());
			}    	
	    });
	    
	    add_dorm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(room_num1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "寝室号不能为空!");
				}
				else if(bed_sum.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善信息!");
				}
				else {

					dorm_info df = new dorm_infoImpl();
					dormitory d = new dormitory();
					dormitory d1 = new dormitory();
					
					d.setRoom_num(room_num1.getText());
					d.setBed_sum(Integer.parseInt(bed_sum.getText()));
					d1 = df.find(room_num1.getText());
					if(d1==null)
					{
						df.add(d);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "重复添加！");
					}
				}
			}
	    });
	    
	    //床位
	   del_bed.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String rid = room_num2.getText();
			String bid = bed_num.getText();
			System.out.println(rid+"室:"+bid);
			bed_info bf = new bed_infoImpl();
			bf.delete(rid, bid);
		}
	   });
	   add_bed.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(room_num2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "寝室号不能为空!");
			}
			else if(bed_num.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "床号不能为空!");
			}
			else if(bed_type.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "请完善床的信息!");
			}
			else {

				bed_info bf = new bed_infoImpl();
				bed b= new bed();
				bed b1=new bed();
				
				b.setRoom_num(room_num2.getText());
				b.setBed_num(bed_num.getText());
				b.setBed_type(bed_type.getText());
				
				b1 = bf.find_(room_num1.getText(),bed_num.getText());
				if(b1==null)
				{
					bf.add(b);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "重复添加！");
				}
			}
		}
	   });
	   add_acc_record.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(stay_num.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "编号不能为空!");
			}
		    else if(room_num3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "寝室号不能为空!");
			}
			else if(bed_num1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "床号不能为空!");
			}
			else if(Sno1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "请完善学号信息!");
			}
			else {

				record_info rf = new record_infoImpl();
				acc_record a= new acc_record();
				acc_record a1= new acc_record();
				acc_record a2= new acc_record();
				
				a.setStay_num(stay_num.getText());
				a.setRoom_num(room_num3.getText());
				a.setBed_num(bed_num1.getText());
				a.setSno(Sno1.getText());
				
				a1 = rf.find(room_num3.getText(),bed_num1.getText());
				a2 = rf.find(Sno1.getText());
				
				if(a1==null && a2==null)
				{
					rf.add(a);
				}
				else if(a1!=null)
				{
					JOptionPane.showMessageDialog(null, "该床位已分配！");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "该同学已分配床位！");
				}
			}
		}
		   
	   });
	   
	   find_record_by_rab.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			record_info rf = new record_infoImpl();
			acc_record a= new acc_record();
			a = rf.find(room_num3.getText(),bed_num1.getText());
			//显示界面
			if(a == null)
			{
				JOptionPane.showMessageDialog(null, "该床号未分配！");
			}
			else
			{
				show_bed_ui.processing(a);
			}
		}
		   
	   });
	   
	   find_record_by_Sno.addActionListener(new ActionListener() {
		   
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				record_info rf = new record_infoImpl();
				acc_record a= new acc_record();
				a = rf.find(Sno1.getText());
				//显示界面
				if(a == null)
				{
					JOptionPane.showMessageDialog(null, "该学号未分配床位！");
				}
				else
				{
					show_bed_ui.processing(a);
				}
			}
		
	   });
	   
	   add_work_task.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(work_task_num.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "编号不能为空!");
			}
		    else if(room_num4.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "寝室号不能为空!");
			}
			else if(adm_id1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "宿管号不能为空!");
			}
			else if(supply.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "请完善物品信息!");
			}
			else {

				work_task_info wf = new work_task_infoImpl();
				work_task w = new work_task();
				
				w.setWork_task_num(work_task_num.getText());
				w.setRoom_num(room_num4.getText());
				w.setAdm_id(adm_id1.getText());
				w.setSupply(supply.getText());
				
				wf.add(w);
			}
		}
		   
	   });
	   del_work_task.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			work_task_info wf = new work_task_infoImpl();
			String wid =work_task_num.getText();
			System.out.println(wid);
			wf.delete(wid);
		}
		   
	   });
	    
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new admin_ui();

	}


}
