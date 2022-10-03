package Bombbomb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Bombbomb.GameMain.Myframe;

public class StartUI extends JFrame {	

	public StartUI(String title) {
	super(title);
	this.setLayout(new BorderLayout());
	this.setSize(630, 690);

	JPanel panelStart = new JPanel();
	panelStart.setPreferredSize(new Dimension(630,690));
	
	JLabel labelStartimage = new JLabel();
	labelStartimage.setIcon(changeImage("image.jpg", 630, 660));
	
	String text[] =  new String[] {"지","뢰","찾","기"}; 
	int[][] bounds = new int [4][4];
	bounds[0] = new int[] {158, 120, 100,100}; 
	bounds[1] = new int[] {280, 120, 100,100}; 
	bounds[2] = new int[] {280, 253, 100,100}; 
	bounds[3] = new int[] {410, 253, 100,100}; 
	
	JLabel titleM[] =  new JLabel[4];
	for (int i =0; i<4; i++) {
	titleM[i] = new JLabel(text[i]);
	titleM[i].setPreferredSize(null);
	titleM[i].setBounds(bounds[i][0],bounds[i][1],bounds[i][2],bounds[i][3]);
	titleM[i].setFont(new Font("font",Font.BOLD, 95));
	labelStartimage.add(titleM[i]);
	}
	
	JButton btnStart = new JButton("START");
	btnStart.setPreferredSize(null);
	btnStart.setBounds(425,565,180, 50);
	btnStart.setBackground(Color.red);
	btnStart.setFont(new Font("font",Font.BOLD,40));
	btnStart.setForeground(Color.white);
	btnStart.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] buttons = {"easy", "normal", "hard"};
		    int num = JOptionPane.showOptionDialog(null, "난이도를 선택하세요", "난이도 선택",
		            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "두 번째값");
		    GameMain gameMain = new GameMain();

			if (num == 0) {gameMain.bombnum = 20;
			}else if(num ==1){gameMain.bombnum = 30;
			}else if(num ==2) {gameMain.bombnum = 50;
			}else {System.exit(0);}
			new Myframe("지뢰찾기");
			dispose();
		}
	});
	labelStartimage.add(btnStart);
	
	
	panelStart.add(labelStartimage);
	this.add(panelStart);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
	
	
	//----------- 끝
	}
	
	static ImageIcon changeImage(String Filename, int width, int high) {// 파일 크기 변경 후 적용
		ImageIcon icon = new ImageIcon("./"+ Filename);
		Image originImage = icon.getImage();
		Image chagedImage = originImage.getScaledInstance(width, high, Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(chagedImage);
		
		return icon_new;
	}


}
