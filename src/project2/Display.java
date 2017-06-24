/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project2;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author iamsu
 */
public class Display extends Panel{
    private JLabel label,priceLabel,typeLabel,categoryLabel;
    private JButton viewDetails;
    
    Vehicle vehicle;

    public Display(Vehicle v) {
        vehicle=v;
        
        setBackground(new Color(235,245,251));
        setPreferredSize(new Dimension(1000, 120));
        setLayout(new GridBagLayout());
        
        
        label = new JLabel(v.getYear()+" "+v.getMake()+" "+v.getModel());
        label.setFont(new Font("Serif", Font.BOLD, 22));
        priceLabel = new JLabel("MSRP: $"+String.valueOf(v.getPrice()));
        priceLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        typeLabel = new JLabel("Type1: "+v.getBodyType());
        typeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        categoryLabel = new JLabel("Category1: "+"Cat");
        categoryLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        viewDetails = new JButton("View Details");viewDetails.setBackground(new Color(127,179,213));
        
        GridBagConstraints gc3 = new GridBagConstraints();
        gc3.anchor = GridBagConstraints.LAST_LINE_START;
        gc3.insets = new Insets(2,180,4,2);
        gc3.gridx = 3;gc3.gridy = 5;
        add(label,gc3);
        gc3.gridx = 4;gc3.gridy = 5;
        add(priceLabel,gc3);
        gc3.gridx = 4;gc3.gridy = 6;
        add(typeLabel,gc3);
        gc3.gridx = 4;gc3.gridy = 7;
        add(categoryLabel,gc3);
        gc3.anchor = GridBagConstraints.LAST_LINE_END;
        gc3.gridx = 8;gc3.gridy = 5;
        add(viewDetails,gc3);
    }
    public static void main(String[] arg){
        //Display d=new Display();
    }
}
