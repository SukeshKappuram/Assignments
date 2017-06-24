/*
 
  */
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMenuFrame extends JFrame  implements ActionListener{
   
    JButton playJb, instructionJb, winPercentJb, exitJb;
    
    
  GameMenuFrame(){
      super("GameMenu");
      playJb=new JButton("Play");
      instructionJb=new JButton("View Instruction");
      winPercentJb=new JButton ("View the Win Percentage");
      exitJb=new JButton("Exit");
      
      
      setLayout(null);
      
      playJb.setBounds(80,30,180,40);
      instructionJb.setBounds(80, 80, 180, 40);
      winPercentJb.setBounds(80,130,180,40);         
      exitJb.setBounds(80,180,180,40 );
      
      
      add(playJb);
      add(instructionJb);
      add(winPercentJb);
      add(exitJb);
      
      setSize(380,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      playJb.addActionListener(this);
      
      instructionJb.addActionListener(this);
      
      winPercentJb.addActionListener(this);
      
      exitJb.addActionListener(this);
      
     
  }  
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==playJb){
           InputFrame iframe=new InputFrame();
      }
      else if(ae.getSource()==instructionJb){
          JOptionPane.showMessageDialog(this, "Your goal is to be the first player to get 3 X's or O's in a row. (horizontally, diagonally, or vertically)");
      }
      else if(ae.getSource()==winPercentJb){
          GetScoreFrame gcf=new GetScoreFrame();
          
      }
      else{
           System.exit(0);
      }
  }
}
