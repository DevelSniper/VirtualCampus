/*
 * Created on 2013-8-26
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author C5105
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchWindow implements ActionListener{
	private static final String ClientLook = null;
	public JFrame searchFrame;
	private ClientLook cl;
	/**
	 * @param b
	 */
	
	public SearchWindow(ClientLook clIn){
		this.cl=clIn;
		searchFrame = new JFrame();
		searchFrame.setTitle("Search Result");
		searchFrame.setBounds(100, 100, 700, 500);
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchFrame.setVisible(true);

		JPanel searchPanel = new JPanel();
		searchPanel.setOpaque(false);
		searchFrame.getContentPane().add(searchPanel);
		((JPanel) searchFrame.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon(getClass().getResource("/res/shop.jpg"));
		JLabel background = new JLabel(img);
		searchFrame.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		searchPanel.setLayout(null);

		//搜索得到的商品表
		MyTable gMessage = new MyTable(10,4);
		gMessage.setBounds(100, 100,500, 300);
		searchPanel.add(gMessage);
		gMessage.setRowHeight(30); 
		
		JLabel SearchResultLabel = new JLabel("为您搜索到的结果……");
		searchPanel.add(SearchResultLabel);
		SearchResultLabel.setBounds(60,20,200, 60);
		SearchResultLabel.setForeground(Color.orange);
	    Font font2 = new  Font("宋体",Font.BOLD, 18);
	    SearchResultLabel.setFont(font2);
	    
	    JButton back = new JButton("返回主页");
	    searchPanel.add(back);
	    back.setBounds(390, 420,120, 30);
	    back.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
        this.searchFrame.dispose();
        this.cl.clientWindow.setVisible(true);
	}
}
