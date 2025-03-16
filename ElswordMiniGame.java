import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElswordMiniGame extends JFrame implements ActionListener{
	/*
	 * 게임을 시작하는 단계, 던전을 선택하는 화면 출력
	 */
	public static final int WIDTH = 1280, HEIGHT = 720;
	private JButton dungeon1;
	private JButton dungeon2;
	private JButton dungeon3;
	private Font font = new Font("HY강B", Font.PLAIN, 20); 
	
	
	public ElswordMiniGame() {
		super();
		
		setSize(WIDTH, HEIGHT);
		setTitle("ELSWORD MINI GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		/*로고*/
		ImageIcon logo = new ImageIcon("image/로고.png");
		setIconImage(logo.getImage());
		
		/*프레임 위 캐릭터 선택 패널*/
		JPanel selectScreen = new JPanel(new BorderLayout());
		selectScreen.setBounds(0, 0, WIDTH, HEIGHT);
		
		
		/*문구
		 * sentencePanel: 
		 * */
		JPanel sentencePanel = new JPanel();
		JLabel sentence = new JLabel("던전을 선택하세요.");
		sentence.setFont(font);
		sentencePanel.add(sentence);
		selectScreen.add(sentencePanel, BorderLayout.NORTH);	//추가
		
		
		/*던전 선택*/
		JPanel dungeonSelect = new JPanel(new GridLayout(1,3));
		
		
		/*로쏘 던전입장 버튼 만들기*/
		dungeon1 = new JButton();
		ImageIcon bossIcon1 =  new ImageIcon("image/로쏘.png");
		
		Image img = bossIcon1.getImage();
		Image changeImg = img.getScaledInstance(500, HEIGHT, Image.SCALE_SMOOTH);
		bossIcon1 = new ImageIcon(changeImg);
		
		dungeon1.setIcon(bossIcon1);
		dungeon1.setBorderPainted(false);
		dungeon1.setContentAreaFilled(false);
		dungeon1.setFocusPainted(false);
		
		dungeonSelect.add(dungeon1);

		
		/*베르드 던전입장 버튼 만들기*/
		dungeon2 = new JButton();
		ImageIcon bossIcon2 = new ImageIcon("image/베르드.png");
		
		img = bossIcon2.getImage();
		changeImg = img.getScaledInstance(500, HEIGHT, Image.SCALE_SMOOTH);
		bossIcon2 = new ImageIcon(changeImg);
		
		dungeon2.setIcon(bossIcon2);
		dungeon2.setBorderPainted(false);
		dungeon2.setContentAreaFilled(false);
		dungeon2.setFocusPainted(false);
		
		dungeonSelect.add(dungeon2);
		
		
		/*란 던전입장 버튼 만들기*/
		dungeon3 = new JButton();
		ImageIcon bossIcon3 = new ImageIcon("image/란.png");
		
		img = bossIcon3.getImage();
		changeImg = img.getScaledInstance(500, HEIGHT, Image.SCALE_SMOOTH);
		bossIcon3 = new ImageIcon(changeImg);
		
		dungeon3.setIcon(bossIcon3);
		dungeon3.setBorderPainted(false);
		dungeon3.setContentAreaFilled(false);
		dungeon3.setFocusPainted(false);
		
		dungeonSelect.add(dungeon3);
		
		
		/*action 넣기*/
		dungeon1.addActionListener(this);
		dungeon2.addActionListener(this);
		dungeon3.addActionListener(this);
		
		selectScreen.add(dungeonSelect, BorderLayout.CENTER);
		
		
		/*던전 보스 소개*/
		JPanel level = new JPanel(new GridLayout(1,3));
		
		JPanel level1 = new JPanel();
		JLabel lv1 = new JLabel("Level 1 : 로쏘");
		JPanel level2 = new JPanel();
		JLabel lv2 = new JLabel("Level 2 : 베르드");
		JPanel level3 = new JPanel();
		JLabel lv3 = new JLabel("Level 3 : 란");
		
		lv1.setFont(font);
		lv2.setFont(font);
		lv3.setFont(font);
		level1.add(lv1);
		level2.add(lv2);
		level3.add(lv3);
		
		level.add(level1);
		level.add(level2);
		level.add(level3);
		
		selectScreen.add(level, BorderLayout.SOUTH);
		
		add(selectScreen);
		
		
		
		try {
			setVisible(true);
            Thread.sleep(1000);
          //로그인 화면 출력
    		LoginScreen idps = new LoginScreen();

        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
	}
	
	public void actionPerformed(ActionEvent e) {
		/*던전 선택 후 새로운 창 생성*/
		
		JButton clickedDungeon = (JButton)e.getSource();
		
		if(clickedDungeon == dungeon1) {
			setVisible(false);
	        Rosso rosso = new Rosso();
	        rosso.addWindowListener(new WindowAdapter() {
	            public void windowClosed(WindowEvent e) {
	                setVisible(true);		//첫 화면
	            }
	        });

		}
		else if(clickedDungeon == dungeon2) {
			setVisible(false);
			Berthe berthe = new Berthe();
			berthe.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					setVisible(true);
				}
			});
			
		}
		else {
			setVisible(false);
			Ran ran = new Ran();
			ran.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					setVisible(true);
				}
			});
		}
	}
	
	
	
	public static void main(String[] args) {
		//게임 실행
		ElswordMiniGame ClickGame = new ElswordMiniGame();
	}

}


class Rosso extends Boss{	
	public Rosso() {
		super("ELSWORD MINI GAME - 로쏘 던전", "image/로쏘-배경.png");
		Screen.add(hpBar);
	}
	
	public void bossPlay() {
		//로쏘 버튼
		boss = new JButton(new ImageIcon("image/로쏘 몬스터1.png"));
		Screen.add(boss);
				
		//버튼 외형
		boss.setBorderPainted(false);
		boss.setContentAreaFilled(false);
		boss.setFocusPainted(false);
				
		boss.setBounds(240, 40, 520, 345);
		boss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hp-=1;
				hp1[(int)hp].setBackground(Color.black);
				if(hp==50) {
					//danger 창 생성
					Danger danger = new Danger();
		            danger.setVisible(true);
		            
		            //로쏘 외형 변경
					boss.setVisible(false);
		            changeBoss = new JButton(new ImageIcon("image/로쏘 몬스터2.png"));
		            changeBoss.setBorderPainted(false);
		            changeBoss.setContentAreaFilled(false);
		            changeBoss.setFocusPainted(false);
					
					//변경된 로쏘 추가
					Screen.add(changeBoss);
					changeBoss.setBounds(300, 100, 400, 330);
					changeBoss.addActionListener(this);
				}
				if(hp==0) {
					changeBoss.setVisible(false);
					
					clearlabel = new JLabel("로쏘를 처치하였습니다!");
				    clearlabel.setFont(new Font("HY강B", Font.BOLD, 30));
				    clearlabel.setForeground(Color.YELLOW);
				    clearlabel.setBounds(200, 40, 400, 30);
					Screen.add(clearlabel);
					
					//로쏘 삭제 후 클리어 화면 출력
					Screen = new BossMap("image/로쏘 클리어.png");
					add(Screen);
					setSize(763, 630);
				}
			}
			
		});
				
		setVisible(true);
	}
	
}

class Berthe extends Boss{
	public Berthe() {
		super("ELSWORD MINI GAME - 베르드 던전", "image/베르드 배경.jpg");
		Screen.add(hpBar);
	}
	
	public void bossPlay() {
		//베르드 버튼
		boss = new JButton(new ImageIcon("image/베르드 몬스터1.png"));
		Screen.add(boss);
		
		//버튼 외형
		boss.setBorderPainted(false);
		boss.setContentAreaFilled(false);
		boss.setFocusPainted(false);
				
		boss.setBounds(310, 283, 539, 373);
		boss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hp-=1;
				hp1[(int)hp].setBackground(Color.black);
				if(hp==50) {
					//danger 창 생성
					Danger danger = new Danger();
		            danger.setVisible(true);
		            
		            //베르드 외형 변경
					boss.setVisible(false);
		            changeBoss = new JButton(new ImageIcon("image/베르드 몬스터.jpg"));
		            changeBoss.setBorderPainted(false);
		            changeBoss.setContentAreaFilled(false);
		            changeBoss.setFocusPainted(false);
					
		            //던전 장소 이동
		            icon = new ImageIcon("image/베르드 백귀.jpg");
		            img = icon.getImage();
		            Screen.setSize(1332, 412);
		            add(Screen);
		            setBounds(0,200,1332, 412);
		            hpBar.setLocation(150,0);
		            
					//변경된 베르드 추가
					Screen.add(changeBoss);
					changeBoss.setBounds(215, 0, 886, 410);
					changeBoss.addActionListener(this);
				}
				if(hp==0) {
					changeBoss.setVisible(false);
					
					clearlabel = new JLabel("베르드를 처치하였습니다!");
				    clearlabel.setFont(new Font("HY강B", Font.BOLD, 30));
				    clearlabel.setForeground(Color.YELLOW);
				    clearlabel.setBounds(200, 40, 400, 30);
					Screen.add(clearlabel);
					
					Screen = new BossMap("image/베르드 클리어.png");
					Screen.setSize(715, 504);
					add(Screen);
					setBounds(50, 50, 715, 504);
				}
			}
			
		});
				
		setVisible(true);
	}
}

class Ran extends Boss{
	private static boolean healhp = false;
	private JButton BerserkBoss;
	
	public Ran() {
		super("ELSWORD MINI GAME - 란 던전", "image/란 배경1.png");
		Screen.add(hpBar);
	}
	
	public void bossPlay() {
		//버튼
		boss = new JButton(new ImageIcon("image/란1.png"));
		Screen.add(boss);
				
		//버튼 외형
		boss.setBorderPainted(false);
		boss.setContentAreaFilled(false);
		boss.setFocusPainted(false);
				
		boss.setBounds(110, 20, 779, 720);
		boss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hp-=1;
				hp1[(int)hp].setBackground(Color.black);
				if((hp==50)&&(!healhp)) {
					//danger 창 생성
					Danger danger = new Danger();
		            danger.setVisible(true);
		            
		            //란 외형 변경
					boss.setVisible(false);
		            changeBoss = new JButton(new ImageIcon("image/란 몬스터2.png"));
		            changeBoss.setBorderPainted(false);
		            changeBoss.setContentAreaFilled(false);
		            changeBoss.setFocusPainted(false);
					
					 //던전 장소 이동
		            icon = new ImageIcon("image/란 배경2-1.png");
		            img = icon.getImage();
		            Screen.setSize(1000, 716);
		            add(Screen);
		            setBounds(0,0,1000, 716);
		            
					//변경된 란 버튼 추가
					Screen.add(changeBoss);
					changeBoss.setBounds(210, 100, 574, 600);
					changeBoss.addActionListener(this);
				}
				if((hp==1)&&(!healhp)) {
					//danger 창 생성
					Danger danger = new Danger();
		            danger.setVisible(true);
					
					healhp = true;
					hp = 100;
					for(int i=1;i<100;i++) {
						hp1[i].setBackground(Color.RED);
					}
					hpBar.setBounds(40,0,1000,20);
					Screen.add(hpBar);
					
					//란 외형 변경
					changeBoss.setVisible(false);
		            BerserkBoss = new JButton(new ImageIcon("image/괴물란1.png"));
		            BerserkBoss.setBorderPainted(false);
		            BerserkBoss.setContentAreaFilled(false);
		            BerserkBoss.setFocusPainted(false);
					
					 //던전 장소 이동
		            icon = new ImageIcon("image/란 배경3.png");
		            img = icon.getImage();
		            Screen.setSize(1098, 720);
		            add(Screen);
		            setBounds(0,0,1098, 720);
		            
					//변경된 란 버튼 추가
					Screen.add(BerserkBoss);
					BerserkBoss.setBounds(460, 20, 637, 700);
					BerserkBoss.addActionListener(this);
				}
				if((hp==0)&&(healhp)) {
					BerserkBoss.setVisible(false);
					
					clearlabel = new JLabel("란을 처치하였습니다!");
				    clearlabel.setFont(new Font("HY강B", Font.BOLD, 30));
				    clearlabel.setForeground(Color.YELLOW);
				    clearlabel.setBounds(200, 40, 400, 30);
					Screen.add(clearlabel);
					
					Screen = new BossMap("image/란 클리어.png");
					add(Screen);
					setSize(572, 438);
				}
			}
			
		});
				
		setVisible(true);

	}
}

class LoginScreen extends JFrame {
    private JTextField id;
    private JPasswordField password;

    public LoginScreen() {
        setTitle("로그인");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon logo = new ImageIcon("image/로고.png");
		setIconImage(logo.getImage());
        
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("아이디:");
        id = new JTextField(15);

        JLabel passwordLabel = new JLabel("비밀번호:");
        password = new JPasswordField(15);

        JButton logIn = new JButton("로그인");
        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = id.getText();
                String pw = new String(password.getPassword());
                setVisible(false);
                Hello login = new Hello(user);
            }
        });

        panel.add(idLabel);
        panel.add(id);
        panel.add(passwordLabel);
        panel.add(password);
        
        panel.add(new JLabel());
        panel.add(logIn);
        add(panel);
        setLocation(0,0);
        
        setVisible(true);
    }
    
    public class Hello extends JFrame implements ActionListener{
    	public Hello(String id) {
        	setTitle("환영합니다!");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(300, 200);
            setResizable(false);
            setLocationRelativeTo(null);
            
            ImageIcon logo = new ImageIcon("image/로고.png");
    		setIconImage(logo.getImage());
    		
    		/*아이디(이름) 출력*/
            JLabel label = new JLabel("안녕하세요, " + id + "님!");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            add(label);

            JButton ok = new JButton("확인");
            ok.addActionListener(this);
            add(ok, BorderLayout.SOUTH);
            
            setVisible(true);
    	}
    	
    	public void actionPerformed(ActionEvent e) {
    		dispose();
    	}
    }
}