package selling;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ShowItems {
	public void getFrame(String username) throws FileNotFoundException {
		JFrame frame = new JFrame("Items");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File file = new File("C:\\Users\\ronaaltug\\workspace\\sellingProjeFinal\\items.txt"); 
		ArrayList<String> item_list = new ArrayList<String>();
		Scanner read = new Scanner(file);

		while (read.hasNextLine()) {
			String write = read.nextLine(); 
			item_list.add(write);
		}

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1024, 768);
		DefaultTableModel list1 = new DefaultTableModel();
		list1.addColumn("Barcode");
		list1.addColumn("Item");
		list1.addColumn("Colour");
		list1.addColumn("Size");
		list1.addColumn("Money");
		list1.addColumn("Stock");
		list1.addColumn("Avaliable");

		JTable table = new JTable(list1);
		table.setLayout(new BorderLayout());
		JScrollPane spanel = new JScrollPane(table);
		spanel.setSize(1020, 350);
		spanel.setLocation(0, 0);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
					JFrame frame = new JFrame("" + (String) table.getValueAt(table.getSelectedRow(), 0));
					JPanel panel = new JPanel(); 
					panel.setLayout(null); 
					panel.setBounds(0, 0, 400, 400); 

					JLabel Moneylbl = new JLabel("Money:");
					Moneylbl.setLocation(225, 30);
					Moneylbl.setSize(200, 70);
					panel.add(Moneylbl);
					Moneylbl.setForeground(Color.red);

					JLabel ShowMoneylbl = new JLabel("" + (String) table.getValueAt(table.getSelectedRow(), 4));
					ShowMoneylbl.setLocation(275, 30);
					ShowMoneylbl.setSize(200, 70);
					panel.add(ShowMoneylbl); 
					ShowMoneylbl.setForeground(Color.black);

					JLabel Sizelbl = new JLabel("Size:");
					Sizelbl.setLocation(225, 80);
					Sizelbl.setSize(200, 70); 
					panel.add(Sizelbl);
					Sizelbl.setForeground(Color.red);

					JLabel ShowSizelbl = new JLabel("" + (String) table.getValueAt(table.getSelectedRow(), 3));
					ShowSizelbl.setLocation(275, 80);
					ShowSizelbl.setSize(200, 70);
					panel.add(ShowSizelbl);
					ShowSizelbl.setForeground(Color.black);

					JLabel Stocklbl = new JLabel("Stock:");
					Stocklbl.setLocation(225, 130);
					Stocklbl.setSize(200, 70);
					panel.add(Stocklbl); 
		 			Stocklbl.setForeground(Color.red); 

					JLabel ShowStcoklbl = new JLabel("" + (String) table.getValueAt(table.getSelectedRow(), 5));
					ShowStcoklbl.setLocation(275, 130);
					ShowStcoklbl.setSize(200, 70); 
					panel.add(ShowStcoklbl);
					ShowStcoklbl.setForeground(Color.black);

					JLabel picture = new JLabel();
					picture.setLocation(20, 20);
					picture.setSize(200, 200);
					for (int i = 0; i < item_list.size(); i += 9) 
						if (item_list.get(i).equalsIgnoreCase((String) table.getValueAt(table.getSelectedRow(), 0))) {
							Icon image = new ImageIcon(item_list.get(i + 8));
							picture.setIcon(image);
						}
					panel.add(picture);
					frame.add(panel); 
					frame.setSize(400, 300);
					frame.setBackground(Color.gray); 
					frame.setLayout(null);
					frame.setVisible(true);
				

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		int c = 0;
		do {
			list1.addRow(new Object[] { item_list.get(c), item_list.get(c + 1), item_list.get(c + 2),
					item_list.get(c + 3), item_list.get(c + 4), item_list.get(c + 6), item_list.get(c + 7) });
			c += 9;
		} while (c < item_list.size());
		
        JLabel Sortlbl=new JLabel("Please Enter The 9 Digit Barcode:"); 
        Sortlbl.setLocation(180, 305);
        Sortlbl.setSize(400, 200);
		panel.add(Sortlbl);
		Sortlbl.setForeground(Color.black);
		
		JTextField sort=new  JTextField(); 
		sort.setLocation(400, 395);
		sort.setSize(150,30); 
		sort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				while(dm.getRowCount() > 0)
				{
				    dm.removeRow(0); 
				}
				ArrayList<String> Newlist=new ArrayList<String>();
				
				for(int a=0;a<item_list.size();a+=9)
				{	
					if(item_list.get(a).toUpperCase().equalsIgnoreCase(sort.getText().toUpperCase()))
					{	 
						Newlist.add(item_list.get(a));  
						Newlist.add(item_list.get(a+1));
						Newlist.add(item_list.get(a+2)); 
						Newlist.add(item_list.get(a+3));  
						Newlist.add(item_list.get(a+4)); 
						Newlist.add(item_list.get(a+6)); 
						Newlist.add(item_list.get(a+7));
					}
				} 
				
		         int y=0;
		         while(y < Newlist.size()) 
		         {list1.addRow(new Object[] {Newlist.get(y),Newlist.get(y+1),Newlist.get(y+2),Newlist.get(y+3),Newlist.get(y+4),item_list.get(y + 6),item_list.get(y + 7)});
		             y+=9; 
		         }			   
			}
		}); 

		JButton tb = new JButton("Turn Back");
		tb.setBackground(Color.yellow);
		tb.setLocation(400, 450); 
		tb.setSize(100, 30);
		tb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Interface a = new Interface();
				try {
					a.getFrame(false, username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		panel.add(spanel); 
		panel.add(sort);
		panel.add(tb);
		frame.add(panel);
		frame.setSize(1024, 540); 
		frame.setLayout(null);
		frame.setVisible(true);

	}
}
