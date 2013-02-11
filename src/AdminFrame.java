import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AdminFrame extends JFrame{
	public AdminFrame (String s,int w,int h){
		setTitle(s);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(w,h);
		JPanel JP=new JPanel();
		JTextField Tx=new JTextField(50);
		JP.add(Tx);
	
		
		
	
		
	}
}
