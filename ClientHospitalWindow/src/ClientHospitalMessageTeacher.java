import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Vector;
public class ClientHospitalMessageTeacher {
	public ClientHospitalMessageTeacher(final Teacher testTeacher){
		Vector headOfTable = new Vector();
		final Vector dataOfTable = new Vector();
		headOfTable.addElement("留言人");
		headOfTable.addElement("留言内容");
		final JFrame frame=new JFrame("在线留言");
		Container c = frame.getContentPane();
		frame.setSize(500,300);
		JPanel pane = new JPanel();
		pane.setLayout(null);
		//内容
		Vector listOfName = new Vector();
		listOfName.addElement("谈晓伟");
	    Hashtable hashtable1=new Hashtable();
	    hashtable1.put("留言学生名单",listOfName);
	    Font font = new Font("Dialog", Font.PLAIN, 12);
	    final JTree tree=new JTree(hashtable1);
	    updateListOfName(listOfName,tree);//获取树的信息
	    JScrollPane scrollPane=new JScrollPane();
	    scrollPane.setViewportView(tree);
	    
	    pane.add(scrollPane);
		
		//内容
		final JTable tbMessage = new JTable(dataOfTable,headOfTable);
		JScrollPane spMessage = new JScrollPane(tbMessage); 
		final JTextArea taMessage = new JTextArea("输入内容");
		JButton btMessage = new JButton("提交留言");
		JButton btDeleteMessage = new JButton("删除留言");
		JButton btClose = new JButton("关闭");
		taMessage.setLineWrap(true);//textarea自动换行
		//监听器们
		//JTree的选中监听器
		tree.addTreeSelectionListener(new TreeSelectionListener(){//JTree的选中监听器
		    @Override  
		    public void valueChanged(TreeSelectionEvent e) {  
		        // TODO Auto-generated method stub  
		        DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();//返回最后选定的节点  
		        String selName = selectedNode.toString(); //获取选中的节点文字 
		        updateDataOfTable(selName,dataOfTable,tbMessage);
		    }
		}); 
		//教师添加留言按钮的监听器
		btMessage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//label1.setText("挂尼玛");
				DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();//返回最后选定的节点  
		        String selName = selectedNode.toString(); //获取树中选中的人名
		        String message=taMessage.getText();//获取留言内容
				try {
					new ClientHospitalOperateDB().leaveMessage(testTeacher.userName, selName, message);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				updateDataOfTable(selName,dataOfTable,tbMessage);//更新message table
			}
		});
		//关闭按钮监听
		btClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		
		//布局
		//tbMessage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbMessage.getColumnModel().getColumn(0).setPreferredWidth(60);//设置第一列“留言人”性质
		tbMessage.getColumnModel().getColumn(0).setMaxWidth(60);
		tbMessage.getColumnModel().getColumn(0).setMinWidth(60);
		tbMessage.getColumnModel().getColumn(1).setPreferredWidth(200);//设置第二列“留言信息”性质
		tbMessage.getColumnModel().getColumn(1).setMaxWidth(200);
		tbMessage.getColumnModel().getColumn(1).setMinWidth(200);
		//tbMessage.setAutoResizeMode(tbMessage.AUTO_RESIZE_OFF);
		//tbMessage.setCellSelectionEnabled(false);
		tbMessage.setPreferredScrollableViewportSize(new Dimension(100,100));
		taMessage.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));//设置留言框边框
		spMessage.setBounds(160, 10,260, 240);
		taMessage.setBounds(430,10,230,190);
		btMessage.setBounds(430,210,112,40);
		btClose.setBounds(550,210,112,40);
		//btDeleteMessage.setBounds(550, 210, 112, 40);
		scrollPane.setBounds(10, 10, 140, 240);
		pane.add(spMessage);
		pane.add(taMessage);
		pane.add(btMessage);
		pane.add(btClose);
		//pane.add(btDeleteMessage);
		c.add(pane);
		frame.setSize(690,300);
		//frame.setSize(690,300);
		frame.setVisible(true);
	}
	
	    
	
	protected void updateListOfName(Vector listOfName,JTree tree){
		try {
			new ClientHospitalOperateDB().getMessageNameList(listOfName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void updateDataOfTable(String Name,Vector dataOfTable,JTable tbMessage){
		try {
			new ClientHospitalOperateDB().getMessageOf(dataOfTable,Name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbMessage.updateUI();
	}


}
