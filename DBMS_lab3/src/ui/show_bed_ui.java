package ui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import entity.Student;
import entity.Student_info;
import entity.Student_infoImpl;
import entity.acc_record;
import entity.bed;
import entity.bed_info;
import entity.bed_infoImpl;

public class show_bed_ui extends JFrame{
	private static final long serialVersionUID = 1L;
	public show_bed_ui(acc_record ar){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JScrollPane sp = new JScrollPane();
		JList<String> list = new JList<String>();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		dlm.addElement("床 位 ：");
		dlm.addElement("寝室号:"+ ar.getRoom_num());
		dlm.addElement("床号:"+ ar.getBed_num());
		bed_info bf = new bed_infoImpl();
		bed b = bf.find_(ar.getRoom_num(), ar.getBed_num());
		dlm.addElement("床的类型:"+ b.getBed_type());
		Student_info stu_info = new Student_infoImpl();
		if(ar != null)
		{
			String sno = ar.getSno();
			Student stu = stu_info.find(sno);
			dlm.addElement("学号:"+ stu.getSno());
			dlm.addElement("姓名:"+ stu.getSname());
		}
		
		list.setModel(dlm);
		list.setBounds(0, 0, 100, 100);
		sp.getViewport().add(list);
		this.getContentPane().add(sp);
	}

	public static void processing(acc_record ar) {

		show_bed_ui mainFrame = new show_bed_ui(ar);
		mainFrame.setSize(500, 300);
		mainFrame.setBounds(400, 200, 600, 200);
		mainFrame.setTitle("查询结果");
		mainFrame.setVisible(true);
	}

}
