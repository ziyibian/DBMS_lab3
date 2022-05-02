package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import entity.Student;
import entity.Student_info;
import entity.Student_infoImpl;
import entity.coun_info;
import entity.coun_infoImpl;
import entity.dep_info;
import entity.dep_infoImpl;
import entity.dependent;
import entity.counselor;
public class stu_register_ui extends JFrame implements ActionListener{
	
	 private JPanel 
         contentPanel = new JPanel();
	 private JButton
	     confirm = new JButton("确认"),
	     ret = new JButton("返回");
	 private JTextField 
	     Sno = new JTextField(),
	     Sname = new JTextField(),
//	     Ssex = new JTextField(),
	     Sage = new JTextField(),
	     Sdept = new JTextField(),
	     
	     teacher_id = new JTextField(),
	     coun_name = new JTextField(),
	     
	     dep_name = new JTextField(),
//	     dep_sex = new JTextField(),
	     dep_relationship = new JTextField(),
	     dep_phone = new JTextField();
	 private JLabel
	     label,
	     point = new JLabel("请返回登录"),
	     Stu =new JLabel("学生信息"),
	     Sno_1 =new JLabel("学号"),
	     Sname_1 = new JLabel("学生姓名"),
	     Ssex_1 = new JLabel("性别"),
	     Sage_1 = new JLabel("年龄"),
	     Sdept_1 = new JLabel("院系"),
	     
	     counselor = new JLabel("辅导员"),
	     teacher_id_1 = new JLabel("教职工号"),
	     coun_name_1 = new JLabel("辅导员姓名"),
	     
	     dep = new JLabel("联系人"),
	     dep_name_1 = new JLabel("姓名"),
	     dep_sex_1 = new JLabel("性别"),
	     dep_relationship_1 = new JLabel("亲属关系"),
	     dep_phone_1 = new JLabel("联系方式");	     
	 
	     
    public stu_register_ui()
    {
    	//实例化图片
        ImageIcon image1 = new ImageIcon("src/back_1.jpg");
        JLabel backLabel = new JLabel();
        backLabel.setIcon(image1);

        label=new JLabel(image1);
        //设置标签大小与位置
        label.setBounds(0, 0,900,600);
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
        
//        JRadioButton radioBtn03 = new JRadioButton("男");
//        JRadioButton radioBtn04 = new JRadioButton("女");
//        ButtonGroup btnGroup_2 = new ButtonGroup();
//        btnGroup_2.add(radioBtn03);
//        btnGroup_2.add(radioBtn04);
//        
        JRadioButton radioBtn05 = new JRadioButton("男");
        JRadioButton radioBtn06 = new JRadioButton("女");
        ButtonGroup btnGroup_3 = new ButtonGroup();
        btnGroup_3.add(radioBtn05);
        btnGroup_3.add(radioBtn06);
        /*
                * 添加组件到contentPanel容器中
                * 布局方式为自由布局。
         */
        contentPanel.setLayout(null);
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
        add(confirm);
        add(ret);
        add(point);
        /*
                 * 组件绝对位置
         */
        Stu.setBounds(90,20,200,30);
        Stu.setFont(new Font(null, Font.BOLD, 18));
        
        Sno_1.setBounds(90,60,120,30);
        Sno_1.setFont(new Font(null, Font.BOLD, 18));
        Sno.setBounds(200,60,200,30);
        Sno.setFont(new Font(null, Font.BOLD, 18));
        
        
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
        
        //联系人
        dep.setBounds(490,20,200,30);
        dep.setFont(new Font(null, Font.BOLD, 18));
        
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
        //辅导员信息
        counselor.setBounds(90,280,200,30);
        counselor.setFont(new Font(null, Font.BOLD, 18));
        
        teacher_id_1.setBounds(90,320,120,30);
        teacher_id_1.setFont(new Font(null, Font.BOLD, 18));
        teacher_id.setBounds(200,320,200,30);
        teacher_id.setFont(new Font(null, Font.BOLD, 18));
        
        coun_name_1.setBounds(490,320,120,30);
        coun_name_1.setFont(new Font(null, Font.BOLD, 18));
        coun_name.setBounds(600,320,200,30);
        coun_name.setFont(new Font(null, Font.BOLD, 18));
        
        
        
        confirm.setBounds(90,450,120,30);
        confirm.setFont(new Font(null, Font.BOLD, 18));
        ret.setBounds(345,450,120,30);
        ret.setFont(new Font(null, Font.BOLD, 18));
        point.setBounds(490,450,200,30);
        point.setFont(new Font(null, Font.BOLD, 18));
        point.setForeground(Color.orange);
        
        
        /*
               * 组件透明化
        */
        contentPanel.setOpaque(false);
        getContentPane().add(contentPanel);
        
        /*
                * 监听事件
         */
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student stu=new Student();
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
					stu.setteacher_id(teacher_id.getText());
					
						
				    //联系人
					if(!dep_name.getText().equals(""))
					{
						dependent dep = new dependent();
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
						//辅导员
						if(teacher_id.getText().equals(""))
						{
							Student_info stu_info=new Student_infoImpl();
							stu.setteacher_id(null);
							stu_info.add(stu);
							
							dep_info df = new dep_infoImpl();
							df.add(dep);
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
								stu_info.add(stu);
								
								dep_info df = new dep_infoImpl();
								df.add(dep);
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
							stu_info.add(stu);
						}
						
					}
					else {
							if(teacher_id.getText().equals(""))
							{
								Student_info stu_info=new Student_infoImpl();
								stu.setteacher_id(null);
								stu_info.add(stu);
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
									stu_info.add(stu);
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
								stu_info.add(stu);
							}
					}
					
				}
		
			}
        	
        });
        ret.addActionListener(this);
        ret.addActionListener(new ActionListener() {

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

    }
    public void textSet(JTextField field) {  
        field.setBackground(new Color(255, 255, 255));  
        field.setPreferredSize(new Dimension(150, 28));  
        field.setFont(new Font(null, Font.BOLD, 18));
        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192,192));  
        field.setBorder(border);  
    }  
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    stu_register_ui f = new stu_register_ui();
                    f.pack();
                    //标题
                    f.setTitle("注册信息");
                    //设置
                    f.setSize(900,600);
                    //窗口退出行为
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //设置窗口打开居中
                    f.setLocationRelativeTo(null);
                    //展示窗口
                    f.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

	}

}
