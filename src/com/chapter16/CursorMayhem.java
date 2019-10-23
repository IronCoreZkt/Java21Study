package com.chapter16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 匿名内部类测试
 * 
 * @author Iron Core
 * @date 2019年7月30日
 * @note 局部内部类和匿名内部类访问的局部变量必须由final修饰，java8开始，可以不加final修饰符，由系统默认添加。
 * 
 */
public class CursorMayhem extends JFrame {
	private static final long serialVersionUID = -3793708928827346796L;
	JButton harry, wade, hansel;

	public CursorMayhem() {
		super("Choose a cursor");
		setLookAndFeel();
		setSize(400, 80);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		harry = new JButton("Crosshair");
		add(harry);
		wade = new JButton("Wait");
		add(wade);
		hansel = new JButton("Hand");
		add(hansel);
		// begin anonymous(匿名) inner class, 定义一个事件监听器
		ActionListener act = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 匿名内部类可以访问其所属类的方法和示例变量，但独立的辅助类没有这样的权限。
				if (e.getSource() == harry) {
					setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
				} else if (e.getSource() == wade)
					setCursor(new Cursor(Cursor.WAIT_CURSOR));
				else if (e.getSource() == hansel)
					setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		};
		// end anonymous inner class
		harry.addActionListener(act);
		wade.addActionListener(act);
		hansel.addActionListener(act);
		setVisible(true);

	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new CursorMayhem();
	}

}
