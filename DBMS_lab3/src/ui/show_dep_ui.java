package ui;

import java.util.List;

import javax.swing.*;

import entity.dependent;
public class show_dep_ui extends JFrame{
	private static final long serialVersionUID = 1L;
	public show_dep_ui(List<dependent> deps){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JScrollPane sp = new JScrollPane();
		JList<String> list = new JList<String>();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		dlm.addElement("ѧ �� �� ϵ �� ��");
		int size = deps.size();
		for(int i=0;i<size;i++) {
			dependent dep = deps.get(i);
			dlm.addElement("��ϵ������:"+ dep.getName());
			dlm.addElement("��ϵ���Ա�:"+ dep.getSex());
			dlm.addElement("������ϵ:"+ dep.getRelationship());
			dlm.addElement("��ϵ��ʽ:"+ dep.getPhone_number());
			dlm.addElement("================================================");
			
		}
		list.setModel(dlm);
		list.setBounds(0, 0, 100, 100);
		sp.getViewport().add(list);
		this.getContentPane().add(sp);
	}

	public static void processing(List<dependent> deps) {

		show_dep_ui mainFrame = new show_dep_ui(deps);
		mainFrame.setSize(500, 300);
		mainFrame.setBounds(400, 200, 600, 200);
		mainFrame.setTitle("��ѯ���");
		mainFrame.setVisible(true);
	}

}
