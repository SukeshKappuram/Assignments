package assignment10;

import java.awt.*;
import java.awt.event.*;

public class TwoNumbersCalculator extends Frame implements ActionListener
	{
		Label l1,l2,l3;
		TextField t1,t2,t3;
		Checkbox b1,b2,b3,b4;
		CheckboxGroup cbg;
		Panel p1;
		Button b5,b6;
		TwoNumbersCalculator()
		{
			super("TwoNumbersCalculator");
			l1= new Label("FirstNo");
			l2= new Label("SecondNo");
			l3= new Label("Result");

			t1= new TextField(20);
			t2= new TextField(20);
			t3= new TextField(20);
			
			cbg= new CheckboxGroup();
			
			b1= new Checkbox("+",cbg,true);
			b2= new Checkbox("-",cbg,false);
			b3= new Checkbox("*",cbg,false);
			b4= new Checkbox("/",cbg,false);

			p1=new Panel();
			p1.add(b1);p1.add(b2);p1.add(b3);p1.add(b4);
			
			b5= new Button("Calculate");
			b6= new Button("Clear");

			setLayout(new FlowLayout());
			add(l1);add(t1);
			add(l2);add(t2);
			add(l3);add(t3);
			add(p1);
			add(b5);add(b6);

			b5.addActionListener(this);
			b6.addActionListener(this);		
		}
		public void actionPerformed(ActionEvent ae)
		{
			String s= ae.getActionCommand();
			
			if(s.equals("Clear"))
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
			else
			{
				try
				{
					double x=Double.parseDouble(t1.getText());
					double y=Double.parseDouble(t2.getText());
					if(b1.getState())
					{
					        t3.setText(String.valueOf(x+y));
					}
					else if(b2.getState())
					{
					        t3.setText(String.valueOf(x-y));
					}
					else if(b3.getState())
					{
					        t3.setText(String.valueOf(x*y));
					}
					else 
					{
					        t3.setText(String.valueOf(x/y));
					}
				}
				catch(Exception e)	
				{	
					if(b1.getState())
					{
					  t3.setText(t1.getText()+t2.getText());
					}
					else
					{
						t1.setText("");
						t2.setText("");
						t3.setText("");
					}
				}
			}
		}
	
		public static void main(String args[])
		{
			TwoNumbersCalculator a= new TwoNumbersCalculator();
			a.setSize(200,300);
			a.setVisible(true);
		}
}
