/*
 * Created on 2013-8-26
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package administration.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.view.ClientLoginWindow;
import client.view.ClientLook;

/**
 * @author C5105
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdminiLook {

	public AdminiLook window;
	private ClientLoginWindow clw;
	public JFrame adminiWindow;
	
	public AdminiLook(ClientLoginWindow alwIn){
	this.clw = alwIn;
	adminiWindow = new JFrame();
	adminiWindow.setResizable(false);
	adminiWindow.setTitle("Administration");
	adminiWindow.setBounds(100, 100, 600, 500);
	adminiWindow.setLocationRelativeTo(adminiWindow.getOwner());
	alwIn.frame.setVisible(false);
	
	//背景
	JPanel jp = new JPanel();
	jp.setOpaque(false);
	adminiWindow.getContentPane().add(jp);
	((JPanel) adminiWindow.getContentPane()).setOpaque(false);
	ImageIcon img = new ImageIcon(getClass().getResource("/res/shop1.jpg"));
	JLabel background = new JLabel(img);
	adminiWindow.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	jp.setLayout(null);
	
	//普通商品信息修改
	JLabel gName = new JLabel("商品名称");
	gName.setBounds(70,80,100,50);
	jp.add(gName);
	JTextField gNameIn = new JTextField();
	gNameIn.setBounds(150,90,100,30);
	jp.add(gNameIn);
	
	JLabel gPrice = new JLabel("商品价格");
	gPrice.setBounds(300,80,100,50);
	jp.add(gPrice);
	JTextField gPriceIn = new JTextField();
	gPriceIn.setBounds(380,90,100,30);
	jp.add(gPriceIn);
	
	JLabel gDate = new JLabel("生产日期");
	gDate.setBounds(70,150,100,50);
	jp.add(gDate);
	JTextField gDateIn = new JTextField();
	gDateIn.setBounds(150,160,100,30);
	jp.add(gDateIn);
	
	JLabel gNumber = new JLabel("商品库存");
	gNumber.setBounds(300,150,100,50);
	jp.add(gNumber);
	JTextField gNumberIn = new JTextField();
	gNumberIn.setBounds(380,160,100,30);
	jp.add(gNumberIn);
	
	JButton add1 = new JButton("添加");
	jp.add(add1);
	add1.setBounds(200,230,60,30);
	JButton delete1 = new JButton("删除");
	jp.add(delete1);
	delete1.setBounds(320,230,60,30);
	
	JLabel comMessage = new JLabel("普通商品信息修改");
    jp.add(comMessage);
    comMessage.setBounds(50, 20, 180, 60);
    Font font1 = new  Font("宋体",Font.BOLD, 16);
    comMessage.setFont(font1);
	
    //特价商品信息修改
	JLabel onSale = new JLabel("特价商品信息修改");
    jp.add(onSale);
    onSale.setBounds(50, 280, 180, 60);
    Font font2 = new  Font("宋体",Font.BOLD, 16);
    onSale.setFont(font2);
    
    JLabel onName = new JLabel("特价商品名称");
    onName.setBounds(70,330,100,50);
	jp.add(onName);
	JTextField onNameIn = new JTextField();
	onNameIn.setBounds(160,340,100,30);
	jp.add(onNameIn);
	
	JLabel onPrice = new JLabel("特价商品价格");
	onPrice.setBounds(300,330,100,50);
	jp.add(onPrice);
	JTextField onPriceIn = new JTextField();
	onPriceIn.setBounds(390,340,100,30);
	jp.add(onPriceIn);
	
	JButton add2 = new JButton("添加");
	jp.add(add2);
	add2.setBounds(200,390,60,30);
	JButton delete2 = new JButton("删除");
	jp.add(delete2);
	delete2.setBounds(320,390,60,30);
	}

}
