

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AppFrame implements ActionListener{
	
	JFrame frame;
	JButton compressButton;
	JButton decompressButton;
	JLabel background;
	
	AppFrame()
	{
		frame = new JFrame("Compressor and Decompressor");
		frame.setLayout(null);
		frame.setSize(1300,700);
		frame.setVisible(true);
		
		ImageIcon img = new ImageIcon("D:\\Eclipse\\Compressor_Decompressor\\Leaves.JPG");
		
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 1300, 700);
		
		compressButton = new JButton("Select a File to Compress");
		compressButton.setBounds(450, 250, 350, 60);
		compressButton.setBackground(Color.orange);
		compressButton.setFont(new Font("Calibri",Font.ITALIC,25));
		compressButton.addActionListener(this);
		
		
		decompressButton = new JButton("Select a File to Decompress");
		decompressButton.setBounds(450, 350, 350, 60);
		decompressButton.setBackground(Color.green);
		decompressButton.setFont(new Font("Calibri",Font.ITALIC,25));
		decompressButton.addActionListener(this);
		
		frame.add(compressButton);
		frame.add(decompressButton);
		frame.add(background);

		frame.getContentPane().setBackground(Color.red);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == compressButton) 
		{
			JFileChooser filechooser = new JFileChooser();
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) 
			{
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
				try 
				{
					compressor.method(file);
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee.toString());
				}
			}
		}
		
		if(e.getSource() == decompressButton) 
		{
			JFileChooser filechooser = new JFileChooser();
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) 
			{
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
				try 
				{
					decompressor.method(file);
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee.toString());
				}
			}
		}
	}
}
