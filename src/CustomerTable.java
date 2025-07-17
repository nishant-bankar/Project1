import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class CustomerTable
{
	static JFrame f=new JFrame("Database Records");
	static DefaultTableModel dtmCustomer;
	static JTable tbCustomer;
	static JScrollPane jspTable;
	
	static Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

	static void populateArray (String rows[][])
	{
		JPanel jpShow = new JPanel ();

		int row = 0;
		int total = 0;

		f.setSize (d.width,d.height);
		f.setLocation(0,0);
		f.setResizable(false);
		//f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		f.addWindowListener(new WindowAdapter()
    	{
    		public void windowClosing(WindowEvent e)
    		{
    			//f1.setVisible(false);
    			MainFrame.frame.setVisible(true);
    			f.dispose();
    		}
    	});

		tbCustomer = makeTable (rows);
		jspTable = new JScrollPane (tbCustomer);
		jspTable.setBounds (0,0,d.width,d.height);

		jpShow.add (jspTable);
		jpShow.setLayout (null);

		f.getContentPane().add (jpShow);
        f.setAlwaysOnTop(true);
		f.setVisible (true);
	}

	private static JTable makeTable (String rowData[][])
	{
		String cols[] = {"ID", " Customer Name", "Email","Moblie","Address","Budget","Model","Payment","Date","E-mail Status"};

		dtmCustomer  = new DefaultTableModel (rowData, cols);

		tbCustomer = new JTable (dtmCustomer)
		{
			public boolean isCellEditable (int iRow, int iCol)
			{
				return false;	//Disable All Columns of Table.
			}
		};
		(tbCustomer.getColumnModel().getColumn(0)).setPreferredWidth (50);

		(tbCustomer.getColumnModel().getColumn(1)).setPreferredWidth (100);
		(tbCustomer.getColumnModel().getColumn(2)).setPreferredWidth (100);
		(tbCustomer.getColumnModel().getColumn(3)).setPreferredWidth (50);
		(tbCustomer.getColumnModel().getColumn(4)).setPreferredWidth (100);
		(tbCustomer.getColumnModel().getColumn(5)).setPreferredWidth (50);
		(tbCustomer.getColumnModel().getColumn(6)).setPreferredWidth (50);
		(tbCustomer.getColumnModel().getColumn(7)).setPreferredWidth (50);
		(tbCustomer.getColumnModel().getColumn(8)).setPreferredWidth (50);
		(tbCustomer.getColumnModel().getColumn(9)).setPreferredWidth (50);
		tbCustomer.setRowHeight (30);
		tbCustomer.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		return tbCustomer;
	}

}
