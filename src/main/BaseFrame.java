package main;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BaseFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "SEM Authentication - Client";

	public BaseFrame() {

		super(TITLE);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000, 700));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.addTab("Blind Operation", new BlindingPanel());
		tabbedPane.addTab("Unbind Operation", new UnBlindingPanel());
		tabbedPane.addTab("Configurations", new ConfigurationPanel());
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            System.out.println("Tab: " + tabbedPane.getSelectedIndex());
	        }
	    });

		setLayout(new GridLayout(1, 1));
		add(tabbedPane);

	}

}
