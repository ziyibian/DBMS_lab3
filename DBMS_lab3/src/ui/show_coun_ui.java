package ui;


import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import entity.counselor;

public class show_coun_ui extends JFrame{
	private static final long serialVersionUID = 1L;
	public show_coun_ui(counselor c){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JScrollPane sp = new JScrollPane();
		JList<String> list = new JList<String>();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		dlm.addElement("�� �� Ա ��");
		dlm.addElement("��ְ����:"+ c.getTeacher_id());
		dlm.addElement("����:"+ c.getName());
		dlm.addElement("�Ա�:"+ c.getSex());
		dlm.addElement("��ϵ��ʽ:"+ c.getPhonenumber());
		list.setModel(dlm);
		list.setBounds(0, 0, 100, 100);
		sp.getViewport().add(list);
		this.getContentPane().add(sp);
	}

	public static void processing(counselor c) {

		show_coun_ui mainFrame = new show_coun_ui(c);
		mainFrame.setSize(500, 300);
		mainFrame.setBounds(400, 200, 600, 200);
		mainFrame.setTitle("��ѯ���");
		mainFrame.setVisible(true);
	}


}
