import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPanel;
    JPanel topPanel;
    JPanel displayPanel;
    JPanel controlPanel;
    JPanel statsPanel;

    JTextArea display;
    JScrollPane scroll;

    JLabel title;
    ImageIcon image;

    JButton rockButton;
    ImageIcon rockImage;
    JButton paperButton;
    ImageIcon paperImage;
    JButton scissorsButton;
    ImageIcon scissorsImage;
    JButton quitButton;

    JTextField playerWinsCount;
    int playerWinsInt;
    JTextField computerWinsCount;
    int computerWinsInt;
    JTextField tiesCount;
    int tiesCountInt;


    Random rnd = new Random(3);
    ArrayList<String> choices = new ArrayList();
    int index = 0;
    String computerChoice = "";


    private void createChoices() {
        choices.add("Rock");
        choices.add("Paper");
        choices.add("Scissors");

    }

    public RockPaperScissorsFrame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = (int) (screenSize.width/4);
        int height = (int) (screenSize.height*0.10);

        setLocation(width, height);

        createTopPanel();
        mainPanel.add(topPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Optional spacing

        createDisplayPanel();
        mainPanel.add(displayPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        createStatsPanel();
        mainPanel.add(statsPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        createControlPanel();
        mainPanel.add(controlPanel);

        createChoices();

        add(mainPanel);
        setSize(600,630);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPanel() {
        topPanel = new JPanel();
        image = new ImageIcon("src/RockPaperScissors.jpg");
        title = new JLabel("Play Rock Paper Scissors!",image,JLabel.CENTER);
        title.setFont(new Font ("Monospaced",Font.BOLD,36));
        title.setVerticalTextPosition(SwingConstants.BOTTOM);
        title.setHorizontalTextPosition(SwingConstants.CENTER);

        topPanel.add(title);
    }

    private void createDisplayPanel() {
        displayPanel = new JPanel();
        display = new JTextArea(13, 25);
        display.setEditable(false);
        display.setFont(new Font ("Times New Roman",Font.PLAIN,14));
        scroll = new JScrollPane(display);

        displayPanel.add(scroll);
    }

    private void createStatsPanel(){
        statsPanel = new JPanel();

        JLabel playerWins = new JLabel("Player Wins:");
        playerWinsCount = new JTextField(" 0 ");
        playerWinsCount.setEditable(false);
        playerWinsInt = 0;

        JLabel computerWins = new JLabel("Computer Wins:");
        computerWinsCount = new JTextField(" 0 ");
        computerWinsCount.setEditable(false);
        computerWinsInt = 0;

        JLabel ties = new JLabel("Ties:");
        tiesCount= new JTextField(" 0 ");
        tiesCount.setEditable(false);
        tiesCountInt = 0;

        statsPanel.add(playerWins);
        statsPanel.add(playerWinsCount);
        statsPanel.add(computerWins);
        statsPanel.add(computerWinsCount);
        statsPanel.add(ties);
        statsPanel.add(tiesCount);
    }

    private void createControlPanel() {

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout());

        rockImage = new ImageIcon("src/RockPic.png");
        Image rockScaledImage = rockImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon rock = new ImageIcon(rockScaledImage);
        rockButton = new JButton("Rock", rock);
        rockButton.setFont(new Font ("Arial",Font.BOLD,14));
        rockButton.setVerticalTextPosition(SwingConstants.TOP);
        rockButton.setHorizontalTextPosition(SwingConstants.CENTER);

        rockButton.addActionListener((ActionEvent ae) ->
        {
            index = rnd.nextInt(choices.size());
            computerChoice = choices.get(index);

            if(computerChoice.equals("Rock")){
                tiesCountInt += 1;
                tiesCount.setText(String.valueOf(tiesCountInt));
                display.append("Rock & Rock (Tie)\n");
            }
            else if(computerChoice.equals("Paper")){
                computerWinsInt += 1;
                computerWinsCount.setText(String.valueOf(computerWinsInt));
                display.append("Paper covers Rock (Computer Wins)\n");
            }
            else{
                playerWinsInt += 1;
                playerWinsCount.setText(String.valueOf(playerWinsInt));
                display.append("Rock breaks Scissors (Player Wins)\n");
            }
        });


        paperImage = new ImageIcon("src/PaperPic.png");
        Image paperScaledImage = paperImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon paper = new ImageIcon(paperScaledImage);
        paperButton = new JButton("Paper", paper);
        paperButton.setFont(new Font ("Arial",Font.BOLD,14));
        paperButton.setVerticalTextPosition(SwingConstants.TOP);
        paperButton.setHorizontalTextPosition(SwingConstants.CENTER);

        paperButton.addActionListener((ActionEvent ae) -> {
            index = rnd.nextInt(choices.size());
            computerChoice = choices.get(index);

            if(computerChoice.equals("Paper")){
                tiesCountInt += 1;
                tiesCount.setText(String.valueOf(tiesCountInt));
                display.append("Paper & Paper (Tie)\n");
            }
            else if(computerChoice.equals("Scissor")){
                computerWinsInt += 1;
                computerWinsCount.setText(String.valueOf(computerWinsInt));
                display.append("Scissor cuts Paper (Computer Wins)\n");
            }
            else{
                playerWinsInt += 1;
                playerWinsCount.setText(String.valueOf(playerWinsInt));
                display.append("Paper covers Rock (Player Wins)\n");
            }
        });


        scissorsImage = new ImageIcon("src/ScissorsPic.png");
        Image scissorsScaledImage = scissorsImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scissors = new ImageIcon(scissorsScaledImage);
        scissorsButton = new JButton("Scissors", scissors);
        scissorsButton.setFont(new Font ("Arial",Font.BOLD,14));
        scissorsButton.setVerticalTextPosition(SwingConstants.TOP);
        scissorsButton.setHorizontalTextPosition(SwingConstants.CENTER);

        scissorsButton.addActionListener((ActionEvent ae) -> {
            index = rnd.nextInt(choices.size());
            computerChoice = choices.get(index);

            if(computerChoice.equals("Scissors")){
                tiesCountInt += 1;
                tiesCount.setText(String.valueOf(tiesCountInt));
                display.append("Scissors & Scissors (Tie)\n");
            }
            else if(computerChoice.equals("Rock")){
                computerWinsInt += 1;
                computerWinsCount.setText(String.valueOf(computerWinsInt));
                display.append("Rock breaks Scissors (Computer Wins)\n");
            }
            else{
                playerWinsInt += 1;
                playerWinsCount.setText(String.valueOf(playerWinsInt));
                display.append("Scissors cuts Paper (Player Wins)\n");
            }
        });

        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));
        quitButton.setFont(new Font ("Arial",Font.BOLD,14));

        controlPanel.add(rockButton);
        controlPanel.add(paperButton);
        controlPanel.add(scissorsButton);
        controlPanel.add(quitButton);

        controlPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));

    }

}
