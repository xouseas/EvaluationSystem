import javax.swing.*;
import javax.swing.JMenuBar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Proion extends JFrame  {
	public Proion (String s,int w,int h){
		setTitle(s);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(w,h);
		Container C =getContentPane();
		setLayout(new GridBagLayout());
		
	
		
		setVisible(false);
	
		
	}
}


