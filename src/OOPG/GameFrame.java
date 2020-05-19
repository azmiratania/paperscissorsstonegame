package OOPG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame implements ActionListener {

    private JLabel gameTitleLbl,  playerLbl,  computerLbl,  pickTitleLbl,  summaryLbl,  rdsPlayerLbl,  rdsPlayerWonLbl,  rdsComputerWonLbl,  rdsDrawnLbl;
    private JButton playerBtn,  computerBtn,  paperBtn,  scissorsBtn,  stoneBtn,  resetBtn,  showGameBtn,  exitBtn;
    private ButtonGroup btnGrp;
    private ImageIcon playerIcon,  computerIcon,  paperIcon,  scissorsIcon,  stoneIcon;
    private JTextArea clickTxt;
    private JPanel northPanel,  centerPanel,  playerPanel,  computerPanel,  pickPanel,  handPanel,  Panel1,  Panel2,  Panel3,  ButtonPanel,  summaryPanel;

   //Calling of methods from [Game]
    Game g1 = new Game();

        int roundsplayed = g1.getroundsplayed();
        int playerwon = g1.getplayerwon();
        int computerwon = g1.getcomputerwon();
        int draw = g1.getdraw();
        int paper = g1.getpaper();
        int scissors = g1.getscissors();
        int stone = g1.getstone();

    public GameFrame() {

        /* Creating of North Panel - Heading Title */
        northPanel = new JPanel(new FlowLayout());
        gameTitleLbl = new JLabel("Paper Scissors Stone Game", JLabel.CENTER);
        Font largeFont = new Font("TimesRoman", Font.BOLD, 35);
        gameTitleLbl.setFont(largeFont);
        gameTitleLbl.setForeground(Color.RED);
        northPanel.add(gameTitleLbl);

        add(northPanel, BorderLayout.NORTH);

        /* Creating of Player Panel */

        playerPanel = new JPanel(new BorderLayout());
        playerLbl = new JLabel("PLAYER:");
        playerIcon = new ImageIcon("images/pick.jpg");
        playerBtn = new JButton(playerIcon);

        playerPanel.add(playerLbl, BorderLayout.NORTH);
        playerPanel.add(playerBtn, BorderLayout.CENTER);

        /* Creating of Computer Panel */

        computerPanel = new JPanel(new BorderLayout());
        computerLbl = new JLabel("COMPUTER:");
        computerIcon = new ImageIcon("images/questionmark.jpg");
        computerBtn = new JButton(computerIcon);

        computerPanel.add(computerLbl, BorderLayout.NORTH);
        computerPanel.add(computerBtn, BorderLayout.CENTER);

        /* Panel 1 = Player Panel (combining with) Computer Panel */

        Panel1 = new JPanel(new GridLayout(1, 2));

        Panel1.add(playerPanel);
        Panel1.add(computerPanel);


        /* Creating of Pick Panel => Sub-Title of program */

        pickPanel = new JPanel(new BorderLayout(5, 5));
        pickTitleLbl = new JLabel("Please pick a hand!");
        Font pickFont = new Font("TimesRoman", Font.ITALIC, 30);
        pickTitleLbl.setFont(pickFont);
        pickTitleLbl.setForeground(Color.BLUE);

        pickPanel.add(pickTitleLbl, BorderLayout.NORTH);


        /* Creating of Hand Panel */

        handPanel = new JPanel(new GridLayout(1, 2, 5, 20));

        paperIcon = new ImageIcon("images/paper.jpg");
        paperBtn = new JButton(paperIcon);
        paperBtn.addActionListener(this);


        scissorsIcon = new ImageIcon("images/scissors.jpg");
        scissorsBtn = new JButton(scissorsIcon);
        scissorsBtn.addActionListener(this);


        stoneIcon = new ImageIcon("images/stone.jpg");
        stoneBtn = new JButton(stoneIcon);
        stoneBtn.addActionListener(this);


        handPanel.add(paperBtn);
        handPanel.add(scissorsBtn);
        handPanel.add(stoneBtn);


        /* Panel 2 = Pick Panel (combining with) Hand Panel */

        Panel2 = new JPanel(new BorderLayout());
        Panel2.add(pickPanel, BorderLayout.NORTH);
        Panel2.add(handPanel, BorderLayout.CENTER);


        /* Panel 3 - Creating of Summary Text Box */

        Panel3 = new JPanel(new BorderLayout());


        summaryPanel = new JPanel(new GridLayout(5, 1));


        summaryLbl = new JLabel("Summary: \n");
        rdsPlayerLbl = new JLabel("Number of rounds Played: " + roundsplayed);
        rdsPlayerWonLbl = new JLabel("Number of rounds that Player have won: " + playerwon);
        rdsComputerWonLbl = new JLabel("Number of rounds that Computer have won: " + computerwon);
        rdsDrawnLbl = new JLabel("Number of rounds that were drawn: " + draw);


        summaryPanel.add(summaryLbl);
        summaryPanel.add(rdsPlayerLbl);
        summaryPanel.add(rdsPlayerWonLbl);
        summaryPanel.add(rdsComputerWonLbl);
        summaryPanel.add(rdsDrawnLbl);
        Panel3.add(summaryPanel);


        /* Center Panel = Panel 1 + Panel 2 + Panel 3 (Placing of all 3 panels into the center panel)*/

        centerPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        centerPanel.add(Panel1);
        centerPanel.add(Panel2);
        centerPanel.add(Panel3);

        add(centerPanel, BorderLayout.CENTER);


        /*South Panel - Buttons which are placed in the bottom of the program*/

        btnGrp = new ButtonGroup();

        //resetbtn
        resetBtn = new JButton("Reset");
        resetBtn.setBackground(Color.CYAN);
        resetBtn.addActionListener(this);

        //showgamebtn
        showGameBtn = new JButton("Show Game Hands");
        showGameBtn.setBackground(Color.CYAN);
        showGameBtn.addActionListener(this);

        //exitbtn
        exitBtn = new JButton("Exit");
        exitBtn.setBackground(Color.CYAN);
        exitBtn.addActionListener(this);

        btnGrp.add(resetBtn);
        btnGrp.add(showGameBtn);
        btnGrp.add(exitBtn);

        ButtonPanel = new JPanel(new GridLayout(1, 3));

        ButtonPanel.add(resetBtn);
        ButtonPanel.add(showGameBtn);
        ButtonPanel.add(exitBtn);
        add(ButtonPanel, BorderLayout.SOUTH);


        //Setting up of Show Game Hand
        clickTxt = new JTextArea("Round:\t\tPlayer:\t\tComputer:", 10, 20);
        //Show Game Hand completed

    }//end of GameFrame

/***********************************Action Performed Statements***********************************************/

    public void actionPerformed(ActionEvent e) {

/*PICKING A HAND*/
        int chooseHand = g1.getchooseHand();


/*Player is Paper*/
        if (e.getSource() == paperBtn) {
            playerBtn.setIcon(paperIcon);

            if (chooseHand == paper) {
                computerBtn.setIcon(paperIcon);
                JOptionPane.showMessageDialog(null, "It's a Draw!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsDrawnLbl.setText("Number of rounds that were drawn: " + (++draw));
                clickTxt.append("\n" + ++roundsplayed + "\t\tpaper\t\tpaper"); //Show Game Hand Button

            } else if (chooseHand == stone) {
                computerBtn.setIcon(stoneIcon);
                JOptionPane.showMessageDialog(null, "You have WON!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsPlayerWonLbl.setText("Number of rounds that Player have won: " + (++playerwon));
                clickTxt.append("\n" + ++roundsplayed + "\t\tpaper\t\tstone"); //Show Game Hand Button

            } else if (chooseHand == scissors) {
                computerBtn.setIcon(scissorsIcon);
                JOptionPane.showMessageDialog(null, "You have LOST! Computer have Won!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsComputerWonLbl.setText("Number of rounds that Computer have won: " + (++computerwon));
                clickTxt.append("\n" + ++roundsplayed + "\t\tpaper\t\tscissors"); //Show Game Hand Button
            }

            rdsPlayerLbl.setText("Number of rounds Played: " + (roundsplayed));
        }//End of player is paper


/*Player is Scissors*/
        if (e.getSource() == scissorsBtn) {
            playerBtn.setIcon(scissorsIcon);

            if (chooseHand == paper) {
                computerBtn.setIcon(paperIcon);
                JOptionPane.showMessageDialog(null, "You have WON!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsPlayerWonLbl.setText("Number of rounds that Player have won: " + (++playerwon));
                clickTxt.append("\n" + ++roundsplayed + "\t\tscissors\t\tpaper"); //Show Game Hand Button

            } else if (chooseHand == stone) {
                computerBtn.setIcon(stoneIcon);
                JOptionPane.showMessageDialog(null, "You have LOST! Computer have Won!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsComputerWonLbl.setText("Number of rounds that Computer have won: " + (++computerwon));
                clickTxt.append("\n" + ++roundsplayed + "\t\tscissors\t\tstone"); //Show Game Hand Button

            } else if (chooseHand == scissors) {
                computerBtn.setIcon(scissorsIcon);
                JOptionPane.showMessageDialog(null, "It's a draw!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsDrawnLbl.setText("Number of rounds that were drawn: " + (++draw));
                clickTxt.append("\n" + ++roundsplayed + "\t\tscissors\t\tscissors"); //Show Game Hand Button
            }

            rdsPlayerLbl.setText("Number of rounds Played: " + (roundsplayed));

        }//end Player is scissors


/*Player is Stone*/
        if (e.getSource() == stoneBtn) {
            playerBtn.setIcon(stoneIcon);

            if (chooseHand == paper) {
                computerBtn.setIcon(paperIcon);
                JOptionPane.showMessageDialog(null, "You have Lost! Computer have Won!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsComputerWonLbl.setText("Number of rounds that Computer have won: " + (++computerwon));
                clickTxt.append("\n" + ++roundsplayed + "\t\tstone\t\tpaper"); //Show Game Hand Button


            } else if (chooseHand == stone) {
                computerBtn.setIcon(stoneIcon);
                JOptionPane.showMessageDialog(null, "It's a draw!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsDrawnLbl.setText("Number of rounds that were drawn: " + (++draw));
                clickTxt.append("\n" + ++roundsplayed + "\t\tstone\t\tstone"); //Show Game Hand Button


            } else if (chooseHand == scissors) {
                computerBtn.setIcon(scissorsIcon);
                JOptionPane.showMessageDialog(null, "You have WON!", "Paper Scissors Stone Game",
                        JOptionPane.INFORMATION_MESSAGE);
                rdsPlayerWonLbl.setText("Number of rounds that Player have won: " + (++playerwon));
                clickTxt.append("\n" + ++roundsplayed + "\t\tstone\t\tscissors"); //Show Game Hand Button

            }
            rdsPlayerLbl.setText("Number of rounds Played: " + (roundsplayed));
        }//end of Player is stone



        /*(BELOW) Creating the functions for Reset, Show Game Hand and Exit buttons */

/*SHOW GAME HAND BUTTON*/
        if (e.getSource() == showGameBtn) {
            JOptionPane.showMessageDialog(null, clickTxt);
        }//END OF SHOW GAME HAND BUTTON


/*EXIT BUTTON*/
        if (e.getSource() == exitBtn) {
            JOptionPane.showMessageDialog(null, "You are now exiting from " +
                    "\nPAPER SCISSORS STONE GAME!", "EXIT", JOptionPane.CLOSED_OPTION);
            System.exit(0);
        }//END OF EXIT BUTTON


/*RESET BUTTON*/
        if (e.getSource() == resetBtn) {
            roundsplayed = 0;
            playerwon = 0;
            computerwon = 0;
            draw = 0;
            playerBtn.setIcon(playerIcon);
            computerBtn.setIcon(computerIcon);
            summaryLbl.setText("Summary: \n");
            rdsPlayerLbl.setText("Number of rounds Played: 0");
            rdsPlayerWonLbl.setText("Number of rounds that Player have won: 0");
            rdsComputerWonLbl.setText("Number of rounds that Computer have won: 0");
            rdsDrawnLbl.setText("Number of rounds that were drawn: 0");
            clickTxt.setText("Round:\t\tPlayer:\t\tComputer:"); //Titlings for Show Game Hand

        }//END OF RESET BUTTON

    }//end of Action Performed

}//end of class
