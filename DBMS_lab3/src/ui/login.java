package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import entity.Student_info;
import entity.Student_infoImpl;
import entity.Student;

public class login extends JFrame implements ActionListener{
	//����һ��Panel��������Label��ǩ��ű���ͼƬ
    private JPanel 
        contentPanel = new JPanel();
    private JLabel
        label;

    //���ð�ť���
    private JButton 
        login = new JButton("��¼"),
        registered = new JButton("ע��");

    //�����ı������
    private JTextField 
        admin = new JTextField();
    
	public login() {
		//��ʼ�������
        admin.setText("�˺�");
        //ʵ����ͼƬ
        ImageIcon image1 = new ImageIcon("src/�������.jpg");

        JLabel backLabel = new JLabel();
        backLabel.setIcon(image1);

        label=new JLabel(image1);
        //���ñ�ǩ��С��λ��
        label.setBounds(0, 0,500,350);
        //��LayeredPane��ײ������������ͼƬ�ı�ǩ������label2��label�Ϸ�  
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //�������������Ϊ͸�������ܹ����������LayeredPane�ϵı�����
        ((JPanel)this.getContentPane()).setOpaque(false);
         
        String[] listData = new String[] { "ѧ��", "����Ա"};
		JComboBox<String> type1 = new JComboBox<String>(listData);
		type1.setSelectedIndex(-1);
        // ����JComboBox�ɱ༭
        type1.setEditable(true);
        /*
                * ��������contentPanel������
                * ���ַ�ʽΪ���ɲ��֡�
         */
        contentPanel.setLayout(null);
        add(admin);
        add(type1);
        add(login);
        add(registered);

        /*
                 * �������λ��
         */
        admin.setBounds(95,110,300,50);
        type1.setBounds(95, 170, 300, 40);
        registered.setBounds(95, 230, 90, 40);
        login.setBounds(315, 230, 90, 40);
		
        /*
                * ������屳������
         */
        admin.setFont(new Font(null, Font.BOLD, 18));
        type1.setFont(new Font(null, Font.BOLD, 18));
        type1.setBackground(Color.WHITE);
        login.setFont(new Font(null, Font.BOLD, 18));
        registered.setFont(new Font(null, Font.BOLD, 18));
        

        /*
               * ���͸����
         */
        admin.setOpaque(false);
        type1.setOpaque(false);
        contentPanel.setOpaque(false);
        getContentPane().add(contentPanel);

        /*
                * ����߿���ɫ
         */
        textSet(admin);

        /*
                * �����¼�
         */
        admin.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int c = e.getButton();
                if(c == MouseEvent.BUTTON1 && admin.getText().equals("�˺�") &&e.getClickCount()==1) {
                    admin.setText(null);
                }
            }
        });

        admin.addCaretListener(new CaretListener(){
            public void caretUpdate(CaretEvent e){
            }
        });
        registered.addActionListener(this);
        registered.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stu_register_ui reg = new stu_register_ui();
				reg.pack();
                //����
                reg.setTitle("ע����Ϣ");
                //����
                reg.setSize(900,600);
                //�����˳���Ϊ
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //���ô��ڴ򿪾���
                reg.setLocationRelativeTo(null);
                //չʾ����
                reg.setVisible(true);
                
			}
        	
        });
        login.addActionListener(this);
        login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JTextField field = (JTextField)type1.getEditor().getEditorComponent();
                String input = field.getText();
				boolean newItem = true;
				if (input == null || input.length() == 0) {
                    newItem = false;
                } else {
                    // ��ȡJComboBox���б������
                    int count = type1.getItemCount();
                    // �����б������ֵ�����������ȣ���newItem����Ϊfalse������������Ϊѡ��
                    for (int i = 0; i < count; i++) {
                        // System.out.println("��" + i + "��item:" + comboBox.getItemAt(i));
                        if (type1.getItemAt(i).equals(input)) {
                            newItem = false;
                            type1.setSelectedItem(input);
                            break;
                        }
                    }
                }
				if(input.equals("����Ա"))
				{
					if(admin.getText().equals("admin"))
					{
						admin_ui adm = new admin_ui();
					}
					else {
						JOptionPane.showMessageDialog(null, "����Ա�˺Ų���ȷ�����������룡");
						new_login();
					}
				}
				else if(input.equals("ѧ��"))
				{
					String Sno = admin.getText();
					Student stu = new Student();
					Student_info stu_info=new Student_infoImpl();
					if(Sno.equals("1190200301"))
						System.out.println(true);
					stu = stu_info.find(Sno);
					if(stu==null)
					{
						JOptionPane.showMessageDialog(null, "δ�ҵ�ѧ����Ϣ,����ע�ᣡ");
						new_login();
					}
					else {
						new stu_ui(stu);
					}
					
				}else if(input.isEmpty()) {
					JOptionPane.showMessageDialog(null, "�������˺Ż�ѡ�������Ϣ��");
					new_login();
				}
				
			}
        	
        });
	}
	/*
     * JTextField�ı������÷���.
     */
    public void textSet(JTextField field) {  
        field.setBackground(new Color(255, 255, 255));  
        field.setPreferredSize(new Dimension(150, 28));  
        field.setFont(new Font(null, Font.BOLD, 18));
        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192,192));  
        field.setBorder(border);  
    }  
    public void new_login()
    {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

}
