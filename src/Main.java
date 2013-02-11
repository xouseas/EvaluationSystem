//
//
//			Πρέπει να γίνει resize στην πρώτη διεπαφή με το ποντίκι για να λειτουργήσει!)
//			Δεν γινόταν το export της βάσης.
//
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.Statement;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String[] tables1 = new String[4];
		int r=0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			} 
		catch (Exception e) { 
			e.printStackTrace(); }
		
		Connection conn= null;
		Statement stmt = null;  
		ResultSet rs= null; 
		try { 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl= "jdbc:mysql://localhost:3306/mydb";
			String connectionUser= "root"; 
			String connectionPassword= "1234";
			conn= DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt =  conn.createStatement();
			rs= stmt.executeQuery("show tables;");
			while(rs.next()){
				String tables =rs.getString("Tables_in_mydb");
				
				int i = 0 ;
				i=r;
				tables1[i]=tables;
				System.out.println(tables1[i]);
				i++;
				r++;
				
			}
			
			} 
		catch (Exception e) {
			e.printStackTrace();
			}
		finally { 
			try { if (rs!= null) rs.close();} catch (SQLException e) {
				e.printStackTrace(); }
			try { if (conn!= null) conn.close();} catch (SQLException e) {
				e.printStackTrace(); }

		}


		
		
		final JFrame F1=new FirstFrame("Arxiko Frame",700,700);
		JButton B1=new JButton ("User");
		JButton B2=new JButton ("Admin");
		F1.add(B1);
		F1.add(B2);
		final JFrame F2=new UserFrame("User Frame",700,700);
		JTextArea LT=new JTextArea(100,100);
		F2.add(LT);
		int size=tables1.length;
		for (int j=0;j<size;j++){
			LT.append(tables1[j]);
			LT.append("\n");
			B1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					F1.setVisible(false);
					F2.setVisible(true);
				}
			});
		}
		JMenuBar menuBar=new JMenuBar(); 			//menu
		F2.getRootPane().setJMenuBar(menuBar);
		JMenu menu=new JMenu("Proionta");
		menuBar.add(menu);

		for (int t=0; t<size; t++){
			JMenuItem buttonItem =new JMenuItem(tables1[t]);
			menu.add(buttonItem);
		
		buttonItem.addActionListener(new ActionListener(){
			public void actionPerformed1(ActionEvent e){
				final JFrame proion =new UserFrame("Proion",700,700);
				proion.setVisible(true);
				F2.setVisible(false);
				proion.show();
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {}
			
			
			
		});
		}
		
		//AdminFrame
		
		
		final JFrame F3=new AdminFrame("Admin Frame",700,700);
		final JTextField Tx=new JTextField(50);
		JPanel JP=new JPanel();
		F3.add(JP);
		JP.add(Tx);
		B2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				F1.setVisible(false);
				F3.setVisible(true);
			}
		});
		
		Tx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String input = Tx.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance() ;
					} 
				catch (Exception e1) { 
					e1.printStackTrace(); }
				
				Connection conn= null;
				Statement stmt = null;  
				ResultSet rs= null; 
				try { 
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl= "jdbc:mysql://localhost:3306/mydb";
					String connectionUser= "root"; 
					String connectionPassword= "1234";
					conn= DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
					stmt =  conn.createStatement();
					rs= stmt.executeQuery("create table "+input+"(id int,review varchar(100),rating int);");
					
					
					} 
				catch (Exception e1) {
					e1.printStackTrace();
					}
				finally { 
					try { if (rs!= null) rs.close();} catch (SQLException e1) {
						e1.printStackTrace(); }
					try { if (conn!= null) conn.close();} catch (SQLException e1) {
						e1.printStackTrace(); }

				}
				
			}
			
		});
		
		
		
		

	}

	

}
