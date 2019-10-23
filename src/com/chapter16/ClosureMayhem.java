package com.chapter16;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * lambda λ 表达式测试
 * 
 * @author Iron Core
 * @date 2019年7月30日
 * @note 个人理解闭包（closure）是一种编程逻辑，它能让封闭作用域（比如方法，类）访问到外部作用域的信息。
 *       在Java中，闭包是通过“接口与内部类实现的”，内部类是面向对象的闭包，
 *       因为它不仅包含外围类对象(创建内部类的作用域)的信息，还自动拥有一个指向此外围类对象的引用，
 *       在此作用域内，内部类有权操作所有的成员，包括private成员。
 * 
 */
public class ClosureMayhem extends JFrame {
	private static final long serialVersionUID = -8031939384110858127L;
	JButton harry, wade, hansel;

	public ClosureMayhem() {
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
		// begin closure
		ActionListener act = (e) -> {
			if (e.getSource() == harry)
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			else if (e.getSource() == wade)
				setCursor(new Cursor(Cursor.WAIT_CURSOR));
			else if (e.getSource() == hansel)
				setCursor(new Cursor(Cursor.HAND_CURSOR));
		};
		// end closure
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
		new ClosureMayhem();
	}

}
