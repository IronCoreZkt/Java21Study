package com.chapter16;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * lambda λ 表达式变量（访问）作用域测试
 * 
 * @author Iron Core
 * @date 2019年7月30日
 * @note Java中的lambda表达式（以及匿名类）只能访问封闭范围的最终（或实际上最终）变量。
 *       lambda表达式是一种语法糖，它是一种轻量化的内部匿名类。 仅当接口只有一个要实现的方法（如 {#link Runnable}，它只有方法
 *       run()）时，才能这样做。 在 Java中，只有一个方法的接口被称为函数式接口（@FunctionalInterface）。
 * 
 */
public class TestLambdaExpression extends JFrame {
	private static final long serialVersionUID = -8031939384110858127L;
	JButton harry, wade, hansel;
	int abc = 100;// 测试的成员变量

	public TestLambdaExpression() {
		super("Choose a cursor");
		int abc = 200;// 测试的局部变量
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
			if (e.getSource() == harry) {
				System.out.println(abc);
				System.out.println(this.abc);
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			} else if (e.getSource() == wade)
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
		new TestLambdaExpression();
	}

}
