package ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import entity.Student;
import entity.Student_info;
import entity.Student_infoImpl;
import entity.acc_record;
import entity.bed_info;
import entity.bed_infoImpl;
import entity.coun_info;
import entity.coun_infoImpl;
import entity.counselor;
import entity.record_info;
import entity.record_infoImpl;
import entity.dep_info;
import entity.dep_infoImpl;
import entity.dependent;
import entity.bed;

public class stu_ui extends JFrame implements ActionListener{
	private JPanel 
         jp = new JPanel();
	private JButton 
	    ret = new JButton("退出登录"),
	    confirm = new JButton("保存"),
	    show_dep = new JButton("查看全部联系人"),
	    del_stu = new JButton("删除账号");
	private JTextField 
        Sno = new JTextField(),
        Sname = new JTextField(),
//      Ssex = new JTextField(),
        Sage = new JTextField(),
        Sdept = new JTextField(),
    
        teacher_id = new JTextField(),
        coun_name = new JTextField(),
//      coun_sex = new JTextField(),
        coun_phone = new JTextField(),
    
        dep_name = new JTextField(),
//      dep_sex = new JTextField(),
        dep_relationship = new JTextField(),
        dep_phone = new JTextField(),
	    
	    room_num = new JTextField(),
	    bed_num = new JTextField(),
	    bed_type = new JTextField();
	private JLabel
	    label,
        point = new JLabel("点击此处返回登录界面"),
        point1 = new JLabel("如若修改请点击保存"),
        point2 = new JLabel("请勿随意点击"),
        Stu =new JLabel("学生信息"),
        Sno_1 =new JLabel("学号"),
        Sname_1 = new JLabel("学生姓名"),
        Ssex_1 = new JLabel("性别"),
        Sage_1 = new JLabel("年龄"),
        Sdept_1 = new JLabel("院系"),
    
        counselor = new JLabel("辅导员"),
        teacher_id_1 = new JLabel("教职工号"),
        coun_name_1 = new JLabel("辅导员姓名"),
        coun_sex_1 = new JLabel("性别"),
        coun_phone_1 = new JLabel("联系方式"),
    
        dep = new JLabel("联系人"),
        dep_name_1 = new JLabel("姓名"),
        dep_sex_1 = new JLabel("性别"),
        dep_relationship_1 = new JLabel("亲属关系"),
        dep_phone_1 = new JLabel("联系方式"),
	    
        bed = new JLabel ("床位分配"),
	    room_num_1 = new JLabel("寝室号"),
	    bed_num_1 = new JLabel("床位"),
	    bed_type_1 = new JLabel("床的类型");

    public stu_ui(Student stu)
    {
    	super("学生界面");
		setSize(900,800);
		Container c = getContentPane();
		
        //实例化图片
        ImageIcon image1 = new ImageIcon("src/back_2.jpg");
        JLabel backLabel = new JLabel();
        backLabel.setIcon(image1);

		label=new JLabel(image1);
		//设置标签大小与位置
		label.setBounds(0, 0,900,800);
		//在LayeredPane最底层上添加两个带图片的标签，并且label2在label上方  
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		//将内容面板设置为透明，就能够看见添加在LayeredPane上的背景。
		((JPanel)this.getContentPane()).setOpaque(false);
		 
		
		// 单选框
		// 创建两个单选按钮
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
		
		JRadioButton radioBtn05 = new JRadioButton("男");
		JRadioButton radioBtn06 = new JRadioButton("女");
		ButtonGroup btnGroup_3 = new ButtonGroup();
		btnGroup_3.add(radioBtn05);
		btnGroup_3.add(radioBtn06);
		/*
		        * 添加组件到contentPanel容器中
		        * 布局方式为自由布局。
		 */
		jp.setLayout(null);
		add(Stu);
		add(Sno_1);
		add(Sno);
		add(Sname_1);
		add(Sname);
		add(Ssex_1);
		add(radioBtn01);
		add(radioBtn02);
		add(Sage_1);
		add(Sage);
		add(Sdept_1);
		add(Sdept);
		
		add(counselor);
		add(teacher_id_1);
		add(teacher_id);
		add(coun_name_1);
		add(coun_name);
		add(coun_sex_1);
		add(radioBtn03);
		add(radioBtn04);
		add(coun_phone_1);
		add(coun_phone);
		
		
		add(dep);
		add(dep_name_1);
		add(dep_name);
		add(dep_sex_1);
		add(radioBtn05);
		add(radioBtn06);
		add(dep_relationship_1);
		add(dep_relationship);
		add(dep_phone_1);
		add(dep_phone);
		add(show_dep);
		
		add(bed);
		add(room_num_1);
		add(room_num);
		add(bed_num_1);
		add(bed_num);
		add(bed_type_1);
		add(bed_type);
		
		add(confirm);
		add(point1);
		add(ret);
		add(point);
		add(del_stu);
		add(point2);
		/*
		         * 组件绝对位置
		 */
		Stu.setBounds(90,20,200,30);
		Stu.setFont(new Font(null, Font.BOLD, 22));
		Stu.setForeground(Color.BLUE);
		
		Sno_1.setBounds(90,60,120,30);
		Sno_1.setFont(new Font(null, Font.BOLD, 18));
		Sno.setBounds(200,60,200,30);
		Sno.setFont(new Font(null, Font.BOLD, 18));
		Sno.setText(stu.getSno());
		Sno.setEditable(false);
		
		
		Sname_1.setBounds(90,100,120,30);
		Sname_1.setFont(new Font(null, Font.BOLD, 18));
		Sname.setBounds(200,100,200,30);
		Sname.setFont(new Font(null, Font.BOLD, 18));
		Sname.setText(stu.getSname());
		
		Ssex_1.setBounds(90,140,50,30);
		Ssex_1.setFont(new Font(null, Font.BOLD, 18));
		radioBtn01.setBounds(200,140,50,30);
		radioBtn01.setBackground(Color.WHITE);
		radioBtn01.setFont(new Font(null, Font.BOLD, 18));
		radioBtn02.setBounds(250,140,50,30);
		radioBtn02.setBackground(Color.WHITE);
		radioBtn02.setFont(new Font(null, Font.BOLD, 18));
		if(stu.getSsex().equals("男"))
		{
			radioBtn01.setSelected(true);
		}
		else
		{
			radioBtn02.setSelected(true);
		}
		Sage_1.setBounds(90,180,120,30);
		Sage_1.setFont(new Font(null, Font.BOLD, 18));
		Sage.setBounds(200,180,200,30);
		Sage.setFont(new Font(null, Font.BOLD, 18));
		System.out.println(Integer.toString(stu.getSage()));
		Sage.setText(Integer.toString(stu.getSage()));
		
		Sdept_1.setBounds(90,220,120,30);
		Sdept_1.setFont(new Font(null, Font.BOLD, 18));
		Sdept.setBounds(200,220,200,30);
		Sdept.setFont(new Font(null, Font.BOLD, 18));
		Sdept.setText(stu.getSdept());
		
		//联系人
		dep.setBounds(490,20,200,30);
		dep.setFont(new Font(null, Font.BOLD, 22));
		dep.setForeground(Color.BLUE);
		
		dep_name_1.setBounds(490,60,120,30);
		dep_name_1.setFont(new Font(null, Font.BOLD, 18));
		dep_name.setBounds(600,60,200,30);
		dep_name.setFont(new Font(null, Font.BOLD, 18));
		
		
		dep_sex_1.setBounds(490,100,50,30);
		dep_sex_1.setFont(new Font(null, Font.BOLD, 18));
		radioBtn05.setBounds(600,100,50,30);
		radioBtn05.setBackground(Color.WHITE);
		radioBtn05.setFont(new Font(null, Font.BOLD, 18));
		radioBtn06.setBounds(650,100,50,30);
		radioBtn06.setBackground(Color.WHITE);
		radioBtn06.setFont(new Font(null, Font.BOLD, 18));
		
		dep_relationship_1.setBounds(490,140,120,30);
		dep_relationship_1.setFont(new Font(null, Font.BOLD, 18));
		dep_relationship.setBounds(600,140,200,30);
		dep_relationship.setFont(new Font(null, Font.BOLD, 18));
		
		dep_phone_1.setBounds(490,180,120,30);
		dep_phone_1.setFont(new Font(null, Font.BOLD, 18));
		dep_phone.setBounds(600,180,200,30);
		dep_phone.setFont(new Font(null, Font.BOLD, 18));
		
		show_dep.setBounds(490,220,200,30);
		show_dep.setFont(new Font(null, Font.BOLD, 18));
		//辅导员信息
		coun_info cf = new coun_infoImpl();
		counselor co = new counselor();
		if(stu.getteacher_id()!=null) {
			co = cf.find(stu.getteacher_id());
		}
		
		counselor.setBounds(90,280,200,30);
		counselor.setFont(new Font(null, Font.BOLD, 22));
		counselor.setForeground(Color.BLUE);
		
		teacher_id_1.setBounds(90,320,120,30);
		teacher_id_1.setFont(new Font(null, Font.BOLD, 18));
		teacher_id.setBounds(200,320,200,30);
		teacher_id.setFont(new Font(null, Font.BOLD, 18));
		
		coun_name_1.setBounds(490,320,120,30);
		coun_name_1.setFont(new Font(null, Font.BOLD, 18));
		coun_name.setBounds(600,320,200,30);
		coun_name.setFont(new Font(null, Font.BOLD, 18));
		
		
		coun_sex_1.setBounds(90,360,120,30);
		coun_sex_1.setFont(new Font(null, Font.BOLD, 18));
		radioBtn03.setBounds(200,360,50,30);
		radioBtn03.setBackground(Color.WHITE);
		radioBtn03.setFont(new Font(null, Font.BOLD, 18));
		radioBtn04.setBounds(250,360,50,30);
		radioBtn04.setBackground(Color.WHITE);
		radioBtn04.setFont(new Font(null, Font.BOLD, 18));
		
		coun_phone_1.setBounds(490,360,120,30);
		coun_phone_1.setFont(new Font(null, Font.BOLD, 18));
		coun_phone.setBounds(600,360,200,30);
		coun_phone.setFont(new Font(null, Font.BOLD, 18));
		
		if(stu.getteacher_id()!=null)
		{
			teacher_id.setText(co.getTeacher_id());
			coun_name.setText(co.getName());
			if(co.getSex().equals("男"))
			{
				radioBtn03.setSelected(true);
			}
			else
			{
				radioBtn04.setSelected(true);
			}
			coun_phone.setText(co.getPhonenumber());
		}
		record_info rf = new record_infoImpl();
		bed_info bf=new bed_infoImpl();
		acc_record ar = new acc_record();
		bed bd = new bed();
		ar = rf.find(stu.getSno());
		
		
		bed.setBounds(90,420,120,30);
		bed.setFont(new Font(null, Font.BOLD, 22));
		bed.setForeground(Color.BLUE);
		
		
		room_num_1.setBounds(90,460,200,30);
		room_num_1.setFont(new Font(null, Font.BOLD, 18));
		room_num.setBounds(200,460,200,30);
		room_num.setFont(new Font(null, Font.BOLD, 18));
		
		bed_num_1.setBounds(490,460,200,30);
		bed_num_1.setFont(new Font(null, Font.BOLD, 18));
		bed_num.setBounds(600,460,200,30);
		bed_num.setFont(new Font(null, Font.BOLD, 18));
		
		bed_type_1.setBounds(90,500,200,30);
		bed_type_1.setFont(new Font(null, Font.BOLD, 18));
		bed_type.setBounds(200,500,200,30);
		bed_type.setFont(new Font(null, Font.BOLD, 18));
		
		if(ar!=null)
		{
			bd=bf.find_(ar.getRoom_num(), ar.getBed_num());
			room_num.setText(ar.getRoom_num());
			bed_num.setText(ar.getBed_num());
			bed_type.setText(bd.getBed_type());
			room_num.setEditable(false);
			bed_num.setEditable(false);
			bed_type.setEditable(false);
		}
		confirm.setBounds(90,600,120,30);
		confirm.setFont(new Font(null, Font.BOLD, 18));
		point1.setBounds(90,640,300,30);
		point1.setFont(new Font(null, Font.BOLD, 18));
		point1.setForeground(Color.ORANGE);
		ret.setBounds(345,600,120,30);
		ret.setFont(new Font(null, Font.BOLD, 18));
		point.setBounds(345,640,300,30);
		point.setFont(new Font(null, Font.BOLD, 18));
		point.setForeground(Color.ORANGE);
		del_stu.setBounds(600,600,120,30);
		del_stu.setFont(new Font(null, Font.BOLD, 18));
		
		point2.setBounds(600,640,300,30);
		point2.setFont(new Font(null, Font.BOLD, 18));
		point2.setForeground(Color.ORANGE);
		
		
		
		
		c.add(jp);
		jp.setOpaque(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//监听事件
		
		ret.addActionListener(this);
		ret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				login f= new login();
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
		show_dep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dep_info df = new dep_infoImpl();
				List<dependent> deps = new ArrayList<dependent>();
				deps = df.find(Sno.getText());
				if(deps == null)
				{
					JOptionPane.showMessageDialog(null, "该学生还未添加联系人信息！");
				}
				else {
					show_dep_ui.processing(deps);
				}
				
			}
			
		});
		del_stu.addActionListener(this);
		del_stu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				rf.delete(stu.getSno());//先删除入住记录
				Student_info sf = new Student_infoImpl();
				dep_info df = new dep_infoImpl();
				df.delete(stu.getSno());//删除联系人
				sf.delete(stu.getSno());//删除学生
			}
			
		});
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Student stu1=new Student();
				if(Sname.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善学生姓名信息！");
				}
				else if(Sage.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请完善学生年龄信息！");
				}
				else {
					stu1.setSno(Sno.getText());
					stu1.setSname(Sname.getText());
					if(radioBtn01.isSelected())//不选默认为女
					{
						stu1.setSsex("男");
					}else {
						stu1.setSsex("女");
					}
					stu1.setSage(Integer.parseInt(Sage.getText()));
					stu1.setSdept(Sdept.getText());
					stu1.setteacher_id(teacher_id.getText());
					
						
				    //联系人
					if(!dep_name.getText().equals(""))//填写了联系人信息
					{
						dependent dep = new dependent();
						dependent dep1 = new dependent();
						dep.setSno(Sno.getText());
						dep.setName(dep_name.getText());
						if(radioBtn05.isSelected())
						{
							dep.setSex("男");
						}else {
							dep.setSex("女");
						}
						dep.setRelationship(dep_relationship.getText());
						dep.setPhone_number(dep_phone.getText());
						dep_info df = new dep_infoImpl();
						dep1 = df.find(stu.getSno(),dep_name.getText());
						//辅导员
						if(teacher_id.getText().equals(""))
						{
							Student_info stu_info=new Student_infoImpl();
							stu1.setteacher_id(null);
							stu_info.update(stu.getSno(), stu1);
							if(dep1 == null)
							{
								df.add(dep);
							}
							else
							{
								df.update(stu.getSno(), dep_name.getText(), dep);
							}
							
						}
						if(!teacher_id.getText().equals("") && !coun_name.getText().equals(""))
						{
							counselor coun = new counselor();
							coun_info cf = new coun_infoImpl();
							coun=cf.find(teacher_id.getText());
							if(coun == null) {
								JOptionPane.showMessageDialog(null, "辅导员不存在！");
							}
							if(!coun.getName().equals(coun_name.getText()))
							{
								JOptionPane.showMessageDialog(null, "辅导员信息不符！");
							}
							else
							{
								Student_info stu_info=new Student_infoImpl();
								stu_info.update(stu.getSno(), stu1);
								if(dep1 == null)
								{
									df.add(dep);
								}
								else
								{
									df.update(stu.getSno(), dep_name.getText(), dep);
								}
							}
						}
						else {
							counselor coun = new counselor();
							coun_info cf = new coun_infoImpl();
							coun=cf.find(teacher_id.getText());
							if(coun == null) {
								JOptionPane.showMessageDialog(null, "辅导员不存在！");
							}
							Student_info stu_info=new Student_infoImpl();
							stu_info.update(stu.getSno(), stu1);
							if(dep1 == null)
							{
								df.add(dep);
							}
							else
							{
								df.update(stu.getSno(), dep_name.getText(), dep);
							}
						}
						
					}
					else {//未填写联系人信息
							if(teacher_id.getText().equals(""))
							{
								Student_info stu_info=new Student_infoImpl();
								stu1.setteacher_id(null);
								stu_info.update(stu.getSno(), stu1);
							}
							if(!teacher_id.getText().equals("") && !coun_name.getText().equals(""))
							{
								counselor coun = new counselor();
								coun_info cf = new coun_infoImpl();
								coun=cf.find(teacher_id.getText());
								if(coun == null) {
									JOptionPane.showMessageDialog(null, "辅导员不存在！");
								}
								if(!coun.getName().equals(coun_name.getText()))
								{
									JOptionPane.showMessageDialog(null, "辅导员信息不符！");
								}
								else
								{
									Student_info stu_info=new Student_infoImpl();
									stu_info.update(stu.getSno(), stu1);
								}
							}
							else {
								counselor coun = new counselor();
								coun_info cf = new coun_infoImpl();
								coun=cf.find(teacher_id.getText());
								if(coun == null) {
									JOptionPane.showMessageDialog(null, "辅导员不存在！");
								}
								Student_info stu_info=new Student_infoImpl();
								stu_info.update(stu.getSno(), stu1);
							}
					}
					
				}
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
		Student stu = new Student();
		stu.setSno("1190200301");
		stu.setSsex("女");
		stu.setSage(20);
		new stu_ui(stu);

	}

}
