import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame{
	public FirstFrame (String s,int w,int h){
	setTitle(s);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setSize(w,h);
	Container C =getContentPane();
	setLayout(new GridBagLayout());	
	
	
	
	setVisible(true);
	show();
	
	}
}
