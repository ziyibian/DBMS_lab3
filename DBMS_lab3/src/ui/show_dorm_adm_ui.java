package ui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import entity.dormitory_admin;

public class show_dorm_adm_ui extends JFrame{
	private static final long serialVersionUID = 1L;
	public show_dorm_adm_ui(dormitory_admin da){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JScrollPane sp = new JScrollPane();
		JList<String> list = new JList<String>();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		dlm.addElement("�� �� ��");
		dlm.addElement("�޹ܺ�:"+ da.getAdm_id());
		dlm.addElement("����:"+ da.getName());
		dlm.addElement("����:"+ da.getAge());
		list.setModel(dlm);
		list.setBounds(0, 0, 100, 100);
		sp.getViewport().add(list);
		this.getContentPane().add(sp);
	}

public static void processing(dormitory_admin da) {

	show_dorm_adm_ui mainFrame = new show_dorm_adm_ui(da);
	mainFrame.setSize(400,300);
	mainFrame.setBounds(400, 200, 600, 200);
	mainFrame.setTitle("��ѯ���");
	mainFrame.setVisible(true);
}


}
