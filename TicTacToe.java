import java.util.concurrent.TimeUnit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{
	Random random = new Random();
	JFrame frame = new JFrame("TicTacToe");
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(255,255,255));
		textfield.setText("Tic-Tac-Toe");
		textfield.setFont(new Font("Ink Free", Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,800);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);

    firstTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
    System.out.println("In actionPerformed method");
		System.out.println(e.getSource());
    for(int i = 0; i<9;i++){
      System.out.println("in loop to find matching button");
      if(e.getSource().equals( buttons[i])){
        System.out.println("Found the button");
        System.out.println(player1_turn);
        if(player1_turn){
          if(buttons[i].getText()==""){
            buttons[i].setForeground(new Color(0,0,255));
            buttons[i].setText("X");
            System.out.println("Changed button text to X");
          }else{
            System.out.println("Tile is already filled");
            textfield.setFont(new Font("Ink Free", Font.BOLD, 65));
            textfield.setText("Tile is already filled");
            try
            {
              Thread.sleep(500);
            }
            catch(InterruptedException ex)
            {
              Thread.currentThread().interrupt();
            }
            return;
          }
          player1_turn=false;
          textfield.setText("O's Turn");
          check();
        }else{
          if(buttons[i].getText()==""){
            buttons[i].setForeground(new Color(255,0,0));
            buttons[i].setText("O");
            System.out.println("Changed button text to O");
          }else{
            System.out.println("Tile is already filled");
            textfield.setFont(new Font("Ink Free", Font.BOLD, 65));
            textfield.setText("Tile is already filled");
            try
            {
              Thread.sleep(500);
            }
            catch(InterruptedException ex)
            {
              Thread.currentThread().interrupt();
            }
            textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
            return;
          }
          player1_turn=true;
          textfield.setText("X's Turn");
          check();
        }
      }
    }
    System.out.println("Can't find the button");
	}
	
	
	public void firstTurn() {
    

		if(random.nextInt(2)==0){
      player1_turn = true;
      textfield.setText("X's Turn");
      System.out.println("X Turn");
    }else{
      player1_turn=false;
      textfield.setText("O's Turn");
      System.out.println("O Turn");
    }
	}
	
	public void check() {
    if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()  =="X")){
      xWin(0,1,2);
    }
    else if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")){
      xWin(3,4,5);
    }
    else if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")){
      xWin(6,7,8);
    }
    else if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")){
      xWin(0,3,6);
    }
    else if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")){
      xWin(1,4,7);
    }
    else if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")){
      xWin(2,5,8);
    }
    else if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")){
      xWin(0,4,8);
    }
    else if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")){
      xWin(2,4,6);
    }
    else if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()  =="O")){
      oWin(0,1,2);
    }
    else if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")){
      oWin(3,4,5);
    }
    else if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")){
      oWin(6,7,8);
    }
    else if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O")){
      oWin(0,3,6);
    }
    else if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")){
      oWin(1,4,7);
    }
    else if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")){
      oWin(2,5,8);
    }
    else if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")){
      oWin(0,4,8);
    }
    else if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")){
      oWin(2,4,6);
    }

    if((buttons[0].getText()!="")&&(buttons[1].getText()!="")&&(buttons[2].getText()!="")&&(buttons[3].getText()!="")&&(buttons[4].getText()!="")&&(buttons[5].getText()!="")&&(buttons[6].getText()!="")&&(buttons[7].getText()!="")&&(buttons[8].getText()!="")){
    
      if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()  =="X")){
        
      }
      else if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")){
        
      }
      else if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")){
        
      }
      else if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")){
        
      }
      else if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")){
        
      }
      else if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")){
        
      }
      else if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")){
        
      }
      else if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")){
        
      }
      else if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()  =="O")){
        
      }
      else if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")){
        
      }
      else if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")){
        
      }
      else if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O")){
        
      }
      else if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")){
        
      }
      else if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")){
        
      }
      else if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")){
        
      }
      else if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")){
        
      }else{
        tie();
      }
    }
    System.out.println("All possibilities checked");
	}
	
	public void xWin(int a, int b, int c) {		
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);
    for(int i=0; i<9; i++){
      buttons[i].setEnabled(false);
    }
    textfield.setText("X WON!");
    JFrame popup = new JFrame("Game Over");
    JLabel winner = new JLabel();
    JButton reset = new JButton("Play Again");
    JPanel winner_panel = new JPanel();
    JPanel reset_panel = new JPanel();

    popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    popup.setVisible(true);
    popup.setSize(400, 200);
    popup.setResizable(false);
    popup.setLayout(new GridLayout(2,1));
    
    winner_panel.setLayout(new BorderLayout());
    winner_panel.setBackground(Color.LIGHT_GRAY);
    winner.setForeground(Color.BLUE);
    //X is BLUE

    reset_panel.setLayout(new BorderLayout());
    reset_panel.setBackground(Color.WHITE);

    winner.setText("X Won!");
    System.out.println("Setting up frame");
    winner.setFont(new Font("Ink Free", Font.BOLD, 60));
    winner.setHorizontalAlignment(JLabel.CENTER);

    reset.setSize(30,10);

    popup.add(winner_panel);
    popup.add(reset_panel);
    winner_panel.add(winner, BorderLayout.CENTER);
    reset_panel.add(reset, BorderLayout.CENTER);
    System.out.println("Finished Panel Setup");

    reset.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 9; i++){
          buttons[i].setText("");
          buttons[i].setEnabled(true);
          buttons[i].setBackground(Color.WHITE);
        }
        firstTurn();
        popup.setVisible(false);
      }
    });
    
	}
	public void oWin(int a, int b, int c) {		
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);
    for(int i=0; i<9; i++){
      buttons[i].setEnabled(false);
    }
    textfield.setText("O WON!");
    System.out.println("Setting up frame");
    JFrame popup = new JFrame("Game Over");
    JLabel winner = new JLabel();
    JButton reset = new JButton("Play Again");
    JPanel winner_panel = new JPanel();
    JPanel reset_panel = new JPanel();

    popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    popup.setVisible(true);
    popup.setSize(400, 200);
    popup.setResizable(false);
    popup.setLayout(new GridLayout(2,1));
    
    winner_panel.setLayout(new BorderLayout());
    winner_panel.setBackground(Color.LIGHT_GRAY);
    winner.setForeground(Color.RED);
    //X is BLUE

    reset_panel.setLayout(new BorderLayout());
    reset_panel.setBackground(Color.WHITE);

    winner.setText("O Won!");
    winner.setFont(new Font("Ink Free", Font.BOLD, 60));
    winner.setHorizontalAlignment(JLabel.CENTER);

    reset.setSize(30,10);

    popup.add(winner_panel);
    popup.add(reset_panel);
    winner_panel.add(winner, BorderLayout.CENTER);
    reset_panel.add(reset, BorderLayout.CENTER);
    System.out.println("Finished Panel Setup");
    
    reset.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 9; i++){
          buttons[i].setText("");
          buttons[i].setEnabled(true);
          buttons[i].setBackground(Color.WHITE);
        }
        firstTurn();
        popup.setVisible(false);
      }
    });
	}
	public void tie(){
    for(int i=0; i<9; i++){
      buttons[i].setEnabled(false);
    }
    textfield.setText("Tie");
    System.out.println("Setting up frame");
    JFrame popup = new JFrame("Game Over");
    JLabel winner = new JLabel();
    JButton reset = new JButton("Play Again");
    JPanel winner_panel = new JPanel();
    JPanel reset_panel = new JPanel();

    popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    popup.setVisible(true);
    popup.setSize(400, 200);
    popup.setResizable(false);
    popup.setLayout(new GridLayout(2,1));
    
    winner_panel.setLayout(new BorderLayout());
    winner_panel.setBackground(Color.LIGHT_GRAY);
    winner.setForeground(Color.BLACK);
    //X is BLUE

    reset_panel.setLayout(new BorderLayout());
    reset_panel.setBackground(Color.WHITE);

    winner.setText("):{ TIE }:(");
    winner.setFont(new Font("Ink Free", Font.BOLD, 60));
    winner.setHorizontalAlignment(JLabel.CENTER);

    reset.setSize(30,10);

    popup.add(winner_panel);
    popup.add(reset_panel);
    winner_panel.add(winner, BorderLayout.CENTER);
    reset_panel.add(reset, BorderLayout.CENTER);
    System.out.println("Finished Panel Setup");
    
    reset.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 9; i++){
          buttons[i].setText("");
          buttons[i].setEnabled(true);
          buttons[i].setBackground(Color.WHITE);
        }
        firstTurn();
        popup.setVisible(false);
      }
    });
  }
	
}
