package com.chapter16;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * 本类将滑块用作进度条，禁止用户在进度未达到100%时关闭主窗口。
 * 
 * @author Iron Core
 * @date 2019年7月25日
 * @note 匿名内部类不能包含构造函数，因此受到的限制比其他内部类和辅助类更大， 但熟练使用后你会发现它们既简洁又功能强大而灵活。
 * 
 */
public class ProgressMonitor2 extends JFrame {
	private static final long serialVersionUID = 1L;
	JProgressBar current;
	int num = 0;
	boolean done = false;

	public ProgressMonitor2() {
		super("Progress Monitor 2");
		setLookAndFeel();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// 匿名内部类
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// user has tried to close window
				if (done) {
					// allow it
					dispose();
					System.exit(0);
				}
			}
		});
		setSize(400, 100);
		setLayout(new FlowLayout());
		current = new JProgressBar(0, 2000);
		current.setValue(0);
		current.setStringPainted(true);
		current.setPreferredSize(new Dimension(360, 48));
		add(current);
		setVisible(true);
		iterate();

	}

	public final void iterate() {
		while (num < 2000) {
			current.setValue(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num += 95;
		}
		done = true;
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			System.out.println("Couldn't use the system " + "look and feel: " + e);
		}
	}

	public static void main(String[] args) {
		new ProgressMonitor2();
	}

}
