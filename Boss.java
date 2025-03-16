import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Boss extends JFrame{
	int WIDTH = 1000, HEIGHT = 720;
	Image img;
	ImageIcon icon;
	JLabel hpState;
	JPanel hpBar;
	JPanel[] hp1;
	JButton boss, changeBoss;
	double hp = 100;
	BossMap Screen;
	JLabel clearlabel;
	
	public Boss(String title, String imageName) {
		//frame 생성

		setLayout(null);
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocation(0,0);
		setResizable(false);
		
		ImageIcon logo = new ImageIcon("image/로고.png");
		setIconImage(logo.getImage());
		
		//배경 panel 생성
		Screen = new BossMap(imageName);
		Screen.setLayout(null);
//		Image changeImg = img.getScaledInstance(500, HEIGHT, Image.SCALE_SMOOTH);
		Screen.setSize(WIDTH, HEIGHT);
		add(Screen);
		
		
		//hpBar - hp1을 저장할 panel, hp 1%를 나타냄
		JPanel hpFrame = new JPanel();
		hpBar = new JPanel(new GridLayout(1,100));
		hp1 = new JPanel[100];
		for(int i=0;i<100;i++) {
			hp1[i] = new JPanel();
			hp1[i].setBackground(Color.RED);
			hpBar.add(hp1[i]);
		}
		hpBar.setBounds(0, 0, WIDTH, 20);
		Screen.add(hpBar);
		
		setVisible(true);
		
		bossPlay();
	}

	public abstract void bossPlay();
	
	public class BossMap extends JPanel{
		public BossMap(String imageName) {
			icon = new ImageIcon(imageName);
			img = icon.getImage();
		}
		
		public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, null);
        }
		
	}
	
	
	public class Danger extends JFrame implements ActionListener{
		public Danger() {
            setTitle("DANGER!");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(300, 200);
            setLocationRelativeTo(null);

            JLabel label = new JLabel("보스 몬스터가 각성했습니다!");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            add(label, BorderLayout.CENTER);

            JButton ok = new JButton("확인");
            ok.addActionListener(this);
            add(ok, BorderLayout.SOUTH);
        }

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
	}
}
