package assignment10;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class CelsiusFahrenheitConverter extends Frame implements ActionListener{
	
	Label l1,l2;
	TextField t1;
	Button b1;
	
	public CelsiusFahrenheitConverter() {
		super("Celsius - Fahrenheit Converter");
		l1= new Label("Temperature ");
		l2= new Label("  ");
		t1= new TextField(20);
		b1= new Button("Convert");
		
		setLayout(new FlowLayout());
		add(l1);add(t1);
		add(l2);
		add(b1);
		
		b1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str=t1.getText().toString();
		float temp=Float.parseFloat(str.substring(0, str.indexOf(' ')));
		if(str.contains("C")){
			l2.setText((temp*1.8)+32+" Fahrenheit");
		}else{
			l2.setText(((temp-32)/1.8)+" Celsius");
		}
				
	}
	
	public static void main(String[] args)
	{
		CelsiusFahrenheitConverter c=new CelsiusFahrenheitConverter();
		c.setSize(200,300);
		c.setVisible(true);
	}
}
