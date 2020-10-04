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
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.DefaultButtonModel;
public class musicPlayer {

	private JFrame frmGmiPlayer;
	private JTextField txtSongPath;
	private String songFile;
	private String fileName;
	private String play;
	private static Player a; // make object public //https://stackoverflow.com/questions/24379298/can-a-object-be-private-and-public
	JFileChooser fc = new JFileChooser(); // add files chooser/selector f(x)
	private JButton btnStop;

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
		
		JButton btnStart = new JButton();
		btnStart.setText("Start");
		btnStart.setForeground(new Color(0, 0, 0));
		btnStart.setIcon(new ImageIcon("/Users/esikmalazman/Desktop/Development/JAVA/Audio Player(PBL1  JAVA)/icon/play-button.png"));
		btnStart.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnStart.setBackground(Color.WHITE);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					 a = new Player(new FileInputStream(songFile));
				
					new Thread() {
						public void run(){
							try {
								a.play();
								
//								if(btnStart.isEnabled()) {
//									btnStart.setText("Stop");
//									btnStart.setIcon(new ImageIcon("/Users/esikmalazman/Desktop/Development/JAVA/Audio Player(PBL1  JAVA)/icon/stop.png"));
//									if(btnStart.getModel().isPressed()) {
//										a.close();
//									}
//									
//									
//									
//								}
								

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
		btnStart.setBounds(18, 194, 204, 29);
		frmGmiPlayer.getContentPane().add(btnStart);
		
		txtSongPath = new JTextField();
		txtSongPath.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtSongPath.setText("Song Path");
		txtSongPath.setBounds(18, 84, 299, 26);
		frmGmiPlayer.getContentPane().add(txtSongPath);
		txtSongPath.setColumns(10);
		if(txtSongPath.equals(FileInputStream(songFile))) {
			txtSongPath.setText(songFile);
		}
		
		JButton btnOpen = new JButton(" Open");
		btnOpen.setIcon(new ImageIcon("/Users/esikmalazman/Desktop/Development/JAVA/Audio Player(PBL1  JAVA)/icon/folder.png"));
		btnOpen.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fc.setDialogTitle("Choose your songs "); //title of window after btnOpen
					fc.showOpenDialog(null);
					songFile = fc.getSelectedFile().toString();
					fileName =("Files "+songFile+" selected");
					txtSongPath.setText(songFile);
					System.out.println(fileName);
					}
				catch(Exception e1){
					e1.printStackTrace();
					
				}
			}
		});
		btnOpen.setBounds(327, 83, 117, 29);
		frmGmiPlayer.getContentPane().add(btnOpen);
		
		btnStop = new JButton("Stop");
		btnStop.setIcon(new ImageIcon("/Users/esikmalazman/Desktop/Development/JAVA/Audio Player(PBL1  JAVA)/icon/stop.png"));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.close();
			}
		});
		btnStop.setBounds(242, 195, 202, 29);
		frmGmiPlayer.getContentPane().add(btnStop);
	}

	private Object FileInputStream(String songFile2) {
		// TODO Auto-generated method stub
		return null;
	}
}
