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
	//设置一个Panel容器面板和Label标签存放背景图片
    private JPanel 
        contentPanel = new JPanel();
    private JLabel
        label;

    //设置按钮组件
    private JButton 
        login = new JButton("登录"),
        registered = new JButton("注册");

    //设置文本框组件
    private JTextField 
        admin = new JTextField();
    
	public login() {
		//初始化各组件
        admin.setText("账号");
        //实例化图片
        ImageIcon image1 = new ImageIcon("src/宿舍管理.jpg");

        JLabel backLabel = new JLabel();
        backLabel.setIcon(image1);

        label=new JLabel(image1);
        //设置标签大小与位置
        label.setBounds(0, 0,500,350);
        //在LayeredPane最底层上添加两个带图片的标签，并且label2在label上方  
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //将内容面板设置为透明，就能够看见添加在LayeredPane上的背景。
        ((JPanel)this.getContentPane()).setOpaque(false);
         
        String[] listData = new String[] { "学生", "管理员"};
		JComboBox<String> type1 = new JComboBox<String>(listData);
		type1.setSelectedIndex(-1);
        // 设置JComboBox可编辑
        type1.setEditable(true);
        /*
                * 添加组件到contentPanel容器中
                * 布局方式为自由布局。
         */
        contentPanel.setLayout(null);
        add(admin);
        add(type1);
        add(login);
        add(registered);

        /*
                 * 组件绝对位置
         */
        admin.setBounds(95,110,300,50);
        type1.setBounds(95, 170, 300, 40);
        registered.setBounds(95, 230, 90, 40);
        login.setBounds(315, 230, 90, 40);
		
        /*
                * 组件字体背景设置
         */
        admin.setFont(new Font(null, Font.BOLD, 18));
        type1.setFont(new Font(null, Font.BOLD, 18));
        type1.setBackground(Color.WHITE);
        login.setFont(new Font(null, Font.BOLD, 18));
        registered.setFont(new Font(null, Font.BOLD, 18));
        

        /*
               * 组件透明化
         */
        admin.setOpaque(false);
        type1.setOpaque(false);
        contentPanel.setOpaque(false);
        getContentPane().add(contentPanel);

        /*
                * 组件边框颜色
         */
        textSet(admin);

        /*
                * 监听事件
         */
        admin.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int c = e.getButton();
                if(c == MouseEvent.BUTTON1 && admin.getText().equals("账号") &&e.getClickCount()==1) {
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
                //标题
                reg.setTitle("注册信息");
                //设置
                reg.setSize(900,600);
                //窗口退出行为
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //设置窗口打开居中
                reg.setLocationRelativeTo(null);
                //展示窗口
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
                    // 获取JComboBox的列表的项数
                    int count = type1.getItemCount();
                    // 遍历列表，如果有值与输入框中相等，则将newItem设置为false，并将其设置为选中
                    for (int i = 0; i < count; i++) {
                        // System.out.println("第" + i + "个item:" + comboBox.getItemAt(i));
                        if (type1.getItemAt(i).equals(input)) {
                            newItem = false;
                            type1.setSelectedItem(input);
                            break;
                        }
                    }
                }
				if(input.equals("管理员"))
				{
					if(admin.getText().equals("admin"))
					{
						admin_ui adm = new admin_ui();
					}
					else {
						JOptionPane.showMessageDialog(null, "管理员账号不正确，请重新输入！");
						new_login();
					}
				}
				else if(input.equals("学生"))
				{
					String Sno = admin.getText();
					Student stu = new Student();
					Student_info stu_info=new Student_infoImpl();
					if(Sno.equals("1190200301"))
						System.out.println(true);
					stu = stu_info.find(Sno);
					if(stu==null)
					{
						JOptionPane.showMessageDialog(null, "未找到学生信息,请先注册！");
						new_login();
					}
					else {
						new stu_ui(stu);
					}
					
				}else if(input.isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入账号或选择身份信息！");
					new_login();
				}
				
			}
        	
        });
	}
	/*
     * JTextField文本框设置方法.
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
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
