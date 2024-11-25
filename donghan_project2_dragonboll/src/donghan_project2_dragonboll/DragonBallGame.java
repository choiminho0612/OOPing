package donghan_project2_dragonboll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragonBallGame {

    public static void main(String[] args) {
        new MainMenu();
    }
}

class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("드래곤볼 게임");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 메인 패널 생성
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 배경 이미지 또는 드래곤이 헤엄치는 모습 그리기
                g.setColor(Color.CYAN);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.ORANGE);
                g.fillOval(300, 200, 200, 100); // 간단히 드래곤 모양 표현
                g.setColor(Color.BLACK);
                g.drawString("용이 헤엄치는 모습", 350, 250);
            }
        };
        panel.setLayout(null);

        // 버튼 생성
        JButton startButton = new JButton("게임 시작");
        JButton settingsButton = new JButton("설정");
        JButton rankingButton = new JButton("랭킹");
        JButton exitButton = new JButton("종료");

        startButton.setBounds(350, 300, 100, 50);
        settingsButton.setBounds(350, 360, 100, 50);
        rankingButton.setBounds(350, 420, 100, 50);
        exitButton.setBounds(350, 480, 100, 50);

        panel.add(startButton);
        panel.add(settingsButton);
        panel.add(rankingButton);
        panel.add(exitButton);

        // 버튼 동작 추가
        startButton.addActionListener(e -> {
            new CharacterSelection();
            dispose();
        });

        exitButton.addActionListener(e -> System.exit(0));

        add(panel);
        setVisible(true);
    }
}

class CharacterSelection extends JFrame {

    public CharacterSelection() {
        setTitle("캐릭터 선택");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JButton gokuButton = new JButton("손오공");
        JButton saohjungButton = new JButton("사오정");
        JButton zhubajieButton = new JButton("저팔계");
        JButton monkButton = new JButton("삼장법사");

        panel.add(gokuButton);
        panel.add(saohjungButton);
        panel.add(zhubajieButton);
        panel.add(monkButton);

        gokuButton.addActionListener(e -> showStory("손오공", "손오공은 드래곤볼을 모으기 위해 길을 떠납니다"));
        saohjungButton.addActionListener(e -> showStory("사오정", "사오정은 특별한 능력으로 드래곤볼을 모으기 시작합니다."));
        zhubajieButton.addActionListener(e -> showStory("저팔계", "저팔계는 배고픔을 참으며 모험을 떠납니다."));
        monkButton.addActionListener(e -> showStory("삼장법사", "삼장법사는 지혜로 드래곤볼을 모읍니다."));

        add(panel);
        setVisible(true);
    }

    private void showStory(String character, String story) {
        JOptionPane.showMessageDialog(this, character + " 선택!\n" + story);
        dispose();
        // 다음 화면으로 이동할 코드 추가 가능
    }
}
