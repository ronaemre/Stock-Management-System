package selling;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class deleting extends Methodlar {

	public void getFrame() throws FileNotFoundException {
		JFrame frame = new JFrame("Deleting Page");
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
		
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("C:\\Users\\ronaaltug\\workspace\\sellingProjeFinal\\Frame-Images\\delete.png");
		label.setSize(800, 300);
		label.setLocation(-300, 0);
		label.setIcon(icon); 

		JLabel Barcodelbl = new JLabel("Please Enter 9 Digit Barcode:");
		Barcodelbl.setLocation(10, 10);
		Barcodelbl.setSize(300, 200);
		panel.add(Barcodelbl);
		Barcodelbl.setForeground(Color.yellow);
		Barcodelbl.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		JTextField barcode = new JTextField();
		barcode.setLocation(300, 100);
		barcode.setSize(150, 30);
		panel.add(barcode); 

		JButton delete = new JButton("Delete Item");
		delete.setLocation(180, 35);
		delete.setSize(140, 50);
		delete.setBackground(Color.red);
		delete.setForeground(Color.white);
		delete.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean control = false;
				for (int i = 0; i < item_list.size(); i += 9) {

					if (item_list.get(i).equals(barcode.getText())) {

						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);

						writeitemfile(item_list, file);
						control = true;
						JOptionPane.showMessageDialog(frame, " Deleting is complete.");
						break;
					}
				}
				if (control == false) {
					JOptionPane.showMessageDialog(frame, " Item didn't found.");
				}

			}
		});

		JButton tb = new JButton("Turn Back");
		tb.setLocation(10, 250);
		tb.setSize(100, 30);
		tb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Interface Interface = new Interface();
				try {
					Interface.getFrame(true, null);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(delete);
		panel.add(label);
		frame.add(tb);
		frame.add(panel);
		frame.setSize(500, 340);
		frame.setVisible(true);
	}
}
