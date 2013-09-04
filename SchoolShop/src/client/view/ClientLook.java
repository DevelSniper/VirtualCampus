
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
import javax.swing.JTextField;


public class ClientLook implements ActionListener{
	private ClientLoginWindow clw;
	public JFrame clientWindow;
	public JTextField clientSearchMessage;
	private JButton goButton;
	public MyTable onSale;
	public JLabel comGoods;
	public ClientLook window;
	

	/**
	 * @param window
	 */
	public ClientLook(ClientLoginWindow clwIn) {
		this.clw = clwIn;
		clientWindow = new JFrame();
		clientWindow.setResizable(false);
		clientWindow.setTitle("School Shop");
		clientWindow.setBounds(100, 100, 927, 600);
		clientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientWindow.setLocationRelativeTo(clientWindow.getOwner());
		clwIn.frame.setVisible(false);
		
		//背景
		JPanel jp = new JPanel();
		jp.setOpaque(false);
		clientWindow.getContentPane().add(jp);
		((JPanel) clientWindow.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon(getClass().getResource("/res/shop4.jpg"));
		JLabel background = new JLabel(img);
		clientWindow.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		jp.setLayout(null);
		
		//搜索栏
		clientSearchMessage = new JTextField();
		clientSearchMessage.setBounds(600, 60, 250, 26);
		jp.add(clientSearchMessage);
		clientSearchMessage.setColumns(10);
		
		JButton goButton = new JButton(""); 
		goButton.setBorderPainted(false);	
		goButton.setIcon(new ImageIcon(getClass().getResource("/res/search.png")));
		goButton.setPressedIcon(new ImageIcon(
				"src/res/search1.png"));
		goButton.setBounds(860, 63, 30, 20);
		jp.add(goButton);
		goButton.addActionListener(this);
		

		
		
		//特价商品
	    final String[] Names ={"商品名称", "商品价格"};
		Object[][] gMessage = {{"曼可顿切片面包","      ￥4.0"},
				{"熊博士软糖","      ￥2.5"},
				{"洁丽雅方毛巾","      ￥18.0"},
				{"蒙牛大果粒草莓味酸奶","      ￥7.0"},
				};
		onSale = new MyTable(gMessage,Names);
		onSale.setBounds(80, 200,250, 190);
		jp.add(onSale);
		onSale.setRowHeight(30); 
		onSale.setShowGrid (false);
		
		JLabel onSaleLabel = new JLabel("今日特价");
		jp.add(onSaleLabel);
		onSaleLabel.setBounds(80,160,200,40);
		onSaleLabel.setForeground(Color.red);
	    Font font2 = new  Font("黑体",Font.BOLD, 18);
	    onSaleLabel.setFont(font2);
	    
	    JLabel foodImage = new JLabel(new ImageIcon(getClass().getResource("/res/food.jpg")));
	    jp.add(foodImage);
	    foodImage.setBounds(430, 140, 426, 307);
				
	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		SearchWindow sea = new SearchWindow(this);
		this.clientWindow.setVisible(false);
	}


}

