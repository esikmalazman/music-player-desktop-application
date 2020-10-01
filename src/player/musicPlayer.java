package player;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class musicPlayer {

	private JFrame frmGmiPlayer;
	private JTextField txtSongPath;
	private String songFile;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getLookAndFeel()); // make app look like native OS
					musicPlayer window = new musicPlayer();
					window.frmGmiPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public musicPlayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGmiPlayer = new JFrame();
		frmGmiPlayer.setForeground(new Color(0, 0, 0));
		frmGmiPlayer.setBackground(new Color(0, 0, 0));
		frmGmiPlayer.getContentPane().setBackground(new Color(233, 150, 122));
		frmGmiPlayer.getContentPane().setForeground(SystemColor.controlHighlight);
		frmGmiPlayer.setTitle("GMI Player");
		frmGmiPlayer.setBounds(100, 100, 450, 300);
		frmGmiPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGmiPlayer.setLocationRelativeTo(null); //set app in centre when opens
		frmGmiPlayer.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setIcon(new ImageIcon("/Users/esikmalazman/Downloads/play-button.png"));
		btnStart.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnStart.setBackground(new Color(255, 127, 80));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Player a = new Player(new FileInputStream(songFile));
					new Thread() { //to prevent GUI freeze while play music
						public void run(){
							try {
								a.play();
							} catch (JavaLayerException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}.start();
					
				}catch(Exception e2){
					e2.printStackTrace();
				}
				
			}
		});
		btnStart.setBounds(170, 166, 117, 29);
		frmGmiPlayer.getContentPane().add(btnStart);
		
		txtSongPath = new JTextField();
		txtSongPath.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtSongPath.setEditable(false);
		txtSongPath.setText("Song Path");
		txtSongPath.setBounds(73, 87, 200, 26);
		frmGmiPlayer.getContentPane().add(txtSongPath);
		txtSongPath.setColumns(10);
		if(txtSongPath.equals(FileInputStream(songFile))) {
			txtSongPath.setText(songFile);
		}
		
		JButton btnOpen = new JButton(" Open");
		btnOpen.setIcon(new ImageIcon("/Users/esikmalazman/Downloads/folder.png"));
		btnOpen.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser fc = new JFileChooser(); // add files chooser/selector f(x)
					fc.setDialogTitle("Choose your songs "); //title of window after btnOpen
					fc.showOpenDialog(null);
					songFile = fc.getSelectedFile().toString();
					String name =("Files "+songFile+" selected");
					System.out.println(name);
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
					
				}
			}
		});
		btnOpen.setBounds(299, 87, 117, 29);
		frmGmiPlayer.getContentPane().add(btnOpen);
	}

	private Object FileInputStream(String songFile2) {
		// TODO Auto-generated method stub
		return null;
	}
}
