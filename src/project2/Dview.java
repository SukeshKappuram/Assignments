package project2;

import java.awt.*;

import javax.swing.*;

public class Dview extends JFrame{
	CardLayout card;  
	JLabel logo,search,searchLabel;  
	Container c;
	Panel main,content,right,left;
	
	Dview(){
		c=getContentPane();  
        c.setLayout(new BorderLayout());
        setSize(500,30);
        logo=new JLabel("Logo Here");
        c.add(logo,BorderLayout.NORTH);
        
        main=new Panel();
        main.setLayout(new BorderLayout());
        
        search=new JLabel("search Here");
        searchLabel=new JLabel("Search Vechiles");
        main.add(search,BorderLayout.EAST);
        main.add(searchLabel,BorderLayout.WEST);
        
        content=new Panel();
        content.setLayout(new GridBagLayout());
        
        left=new Panel(new FlowLayout());
        right=new Panel(new FlowLayout());
        
        
        
        
        
        content.add(left);
        content.add(right);
        
        c.add(main,BorderLayout.CENTER);
        c.add(content,BorderLayout.SOUTH);
	}		

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Dview d=new Dview();
		d.setSize(500,500);
		d.setVisible(true);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
}
