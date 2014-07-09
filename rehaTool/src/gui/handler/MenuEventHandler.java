package gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEventHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Beenden")) {
			System.exit(0);
		}
	}

}
