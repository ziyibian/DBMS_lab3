package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import entity.Student_info;
import entity.Student_infoImpl;
import entity.acc_record;
import entity.dormitory;
import entity.Student;
import entity.record_info;
import entity.record_infoImpl;


public class show_dorm_ui extends JFrame{
	private static final long serialVersionUID = 1L;
	public show_dorm_ui(dormitory d){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JScrollPane sp = new JScrollPane();
		JList<String> list = new JList<String>();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
	    acc_record ar = new acc_record();
	    List<acc_record> ar_list = new ArrayList<acc_record>();
		dlm.addElement("ËÞ Éá £º");
		dlm.addElement("ÇÞÊÒºÅ:"+ d.getRoom_num());
		dlm.addElement("´²Êý:"+ d.getBed_sum());
		dlm.addElement("================================================");
		record_info rf = new record_infoImpl();
		Student_info stu_info = new Student_infoImpl();
		ar_list = rf.find_(d.getRoom_num());
		int size = ar_list.size();
		System.out.println(size);
		for(int i=0;i<size;i++)
		{
			ar = ar_list.get(i);
			dlm.addElement("´²ºÅ:"+ ar.getBed_num());
			Student stu = stu_info.find(ar.getSno());
			dlm.addElement("Ñ§ºÅ:"+ ar.getSno());
			System.out.println(ar.getSno());
			dlm.addElement("ÐÕÃû:"+ stu.getSname());
			dlm.addElement("================================================");
		}
		list.setModel(dlm);
		list.setBounds(0, 0, 100, 100);
		sp.getViewport().add(list);
		this.getContentPane().add(sp);
	}

	public static void processing(dormitory d) {

		show_dorm_ui mainFrame = new show_dorm_ui(d);
		mainFrame.setSize(500, 300);
		mainFrame.setBounds(400, 200, 600, 200);
		mainFrame.setTitle("²éÑ¯½á¹û");
		mainFrame.setVisible(true);
	}

}
