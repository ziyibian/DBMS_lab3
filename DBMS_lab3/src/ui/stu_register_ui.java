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
	     confirm = new JButton("ȷ��"),
	     ret = new JButton("����");
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
	     point = new JLabel("�뷵�ص�¼"),
	     Stu =new JLabel("ѧ����Ϣ"),
	     Sno_1 =new JLabel("ѧ��"),
	     Sname_1 = new JLabel("ѧ������"),
	     Ssex_1 = new JLabel("�Ա�"),
	     Sage_1 = new JLabel("����"),
	     Sdept_1 = new JLabel("Ժϵ"),
	     
	     counselor = new JLabel("����Ա"),
	     teacher_id_1 = new JLabel("��ְ����"),
	     coun_name_1 = new JLabel("����Ա����"),
	     
	     dep = new JLabel("��ϵ��"),
	     dep_name_1 = new JLabel("����"),
	     dep_sex_1 = new JLabel("�Ա�"),
	     dep_relationship_1 = new JLabel("������ϵ"),
	     dep_phone_1 = new JLabel("��ϵ��ʽ");	     
	 
	     
    public stu_register_ui()
    {
    	//ʵ����ͼƬ
        ImageIcon image1 = new ImageIcon("src/back_1.jpg");
        JLabel backLabel = new JLabel();
        backLabel.setIcon(image1);

        label=new JLabel(image1);
        //���ñ�ǩ��С��λ��
        label.setBounds(0, 0,900,600);
        //��LayeredPane��ײ������������ͼƬ�ı�ǩ������label2��label�Ϸ�  
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //�������������Ϊ͸�������ܹ����������LayeredPane�ϵı�����
        ((JPanel)this.getContentPane()).setOpaque(false);
         
        
        // ��ѡ��
        // ����������ѡ��ť
        JRadioButton radioBtn01 = new JRadioButton("��");
        JRadioButton radioBtn02 = new JRadioButton("Ů");

        // ������ť�飬��������ѡ��ť��ӵ�����
        ButtonGroup btnGroup_1 = new ButtonGroup();
        btnGroup_1.add(radioBtn01);
        btnGroup_1.add(radioBtn02);
        
//        JRadioButton radioBtn03 = new JRadioButton("��");
//        JRadioButton radioBtn04 = new JRadioButton("Ů");
//        ButtonGroup btnGroup_2 = new ButtonGroup();
//        btnGroup_2.add(radioBtn03);
//        btnGroup_2.add(radioBtn04);
//        
        JRadioButton radioBtn05 = new JRadioButton("��");
        JRadioButton radioBtn06 = new JRadioButton("Ů");
        ButtonGroup btnGroup_3 = new ButtonGroup();
        btnGroup_3.add(radioBtn05);
        btnGroup_3.add(radioBtn06);
        /*
                * ��������contentPanel������
                * ���ַ�ʽΪ���ɲ��֡�
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
                 * �������λ��
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
        
        //��ϵ��
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
        //����Ա��Ϣ
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
               * ���͸����
        */
        contentPanel.setOpaque(false);
        getContentPane().add(contentPanel);
        
        /*
                * �����¼�
         */
        confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student stu=new Student();
				if(Sno.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ�գ�");
				}
				else if(Sname.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "������ѧ��������Ϣ��");
				}
				else if(Sage.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "������ѧ��������Ϣ��");
				}
				else {
					stu.setSno(Sno.getText());
					stu.setSname(Sname.getText());
					if(radioBtn01.isSelected())//��ѡĬ��ΪŮ
					{
						stu.setSsex("��");
					}else {
						stu.setSsex("Ů");
					}
					stu.setSage(Integer.parseInt(Sage.getText()));
					stu.setSdept(Sdept.getText());
					stu.setteacher_id(teacher_id.getText());
					
						
				    //��ϵ��
					if(!dep_name.getText().equals(""))
					{
						dependent dep = new dependent();
						dep.setSno(Sno.getText());
						dep.setName(dep_name.getText());
						if(radioBtn05.isSelected())
						{
							dep.setSex("��");
						}else {
							dep.setSex("Ů");
						}
						dep.setRelationship(dep_relationship.getText());
						dep.setPhone_number(dep_phone.getText());
						//����Ա
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
								JOptionPane.showMessageDialog(null, "����Ա�����ڣ�");
							}
							if(!coun.getName().equals(coun_name.getText()))
							{
								JOptionPane.showMessageDialog(null, "����Ա��Ϣ������");
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
								JOptionPane.showMessageDialog(null, "����Ա�����ڣ�");
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
									JOptionPane.showMessageDialog(null, "����Ա�����ڣ�");
								}
								if(!coun.getName().equals(coun_name.getText()))
								{
									JOptionPane.showMessageDialog(null, "����Ա��Ϣ������");
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
									JOptionPane.showMessageDialog(null, "����Ա�����ڣ�");
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
                //����
                f.setTitle("��¼����");
                //����
                f.setSize(500,350);
                //�����˳���Ϊ
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //���ô��ڴ򿪾���
                f.setLocationRelativeTo(null);
                //չʾ����
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
                    //����
                    f.setTitle("ע����Ϣ");
                    //����
                    f.setSize(900,600);
                    //�����˳���Ϊ
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //���ô��ڴ򿪾���
                    f.setLocationRelativeTo(null);
                    //չʾ����
                    f.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

	}

}
