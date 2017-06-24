package project2;


import static project2.Util.read;
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTextField;
	import javax.swing.SwingUtilities;

	public class Screen2 extends JFrame{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private JPanel leftPanel,rightPanel,topPanel;
		private JButton searchBtn;
		private JButton homeBtn,aboutUsBtn,newVehiclesBtn,viewDealersBtn;
		private JComboBox<String> filterYear,filterModel,filterMake,filterType,filterPrice,filterCategory,filterSort;
		private JLabel topPicture,vehicleLabel;
		private JTextField searchBar;
        private Display[] panes;
        List<Vehicle> vehicles=new ArrayList<>();
        int i=0,x=10,y=8;
        GridBagConstraints gc2 = new GridBagConstraints();
                
		public Screen2() throws Exception{
			super("Vehicle Search Screen");
			setSize(1800,1000);
			setLocation(10,10);
		
			//Left, right and top panels
			leftPanel = new JPanel();
			rightPanel = new JPanel();
			topPanel=new JPanel();

			setLayout(new BorderLayout());
			add(leftPanel,BorderLayout.WEST);
			add(topPanel,BorderLayout.NORTH);

			leftPanel.setBackground(new Color(127,179,213));
			leftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			rightPanel.setBackground(new Color(127,179,213));
			rightPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			topPanel.setBackground(new Color(41, 128, 185));
			topPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

			//Scrollpane
			JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(scrollPane,BorderLayout.CENTER);
			scrollPane.setViewportView(rightPanel);
			
			//Dropdowns
			String[] year = {"Year:","<2014","2015","2016","2017",">2017"};
			filterYear = new JComboBox<String>(year);
			filterYear.setPreferredSize(new Dimension(180,26));

			String[] model = {"Model:","Model1","Model2","Model3","Model4","Model5"};
			filterModel = new JComboBox<String>(model);
			filterModel.setPreferredSize(new Dimension(180,26));

			String[] make = {"Make:","Make1","Make2","Make3","Make4","Make5"};
			filterMake = new JComboBox<String>(make);
			filterMake.setPreferredSize(new Dimension(180,26));

			String[] type = {"Type:","Type1","Type2","Type3","Type4","Type5"};
			filterType = new JComboBox<String>(type);
			filterType.setPreferredSize(new Dimension(180,26));

			String[] price = {"Price:","0-10,000","10,000-20,000","20,000-30,000","30,000-40,000","40,000-50,000","50,000-60,000"};
			filterPrice = new JComboBox<String>(price);
			filterPrice.setPreferredSize(new Dimension(180,26));

			String[] category = {"Category:","Category1","Category2","Category3","Category4","Category5"};
			filterCategory = new JComboBox<String>(category);
			filterCategory.setPreferredSize(new Dimension(180,26));

			String[] sortBy = {"Sort By:","Year","Model","Make","Price","Category"};
			filterSort = new JComboBox<String>(sortBy);
			filterSort.setPreferredSize(new Dimension(180,26));

			//Labels
			topPicture = new JLabel("Space for picture");topPicture.setFont(new Font("Serif", Font.PLAIN, 40));
			leftPanel.add(topPicture);

			vehicleLabel = new JLabel("Search Vehicles");
			vehicleLabel.setFont(new Font("Serif", Font.PLAIN, 20));

			searchBar= new JTextField(30);
			
                        
			//Buttons
			searchBtn = new JButton("Search");
			rightPanel.add(searchBtn);
			
			homeBtn = new JButton("Home");
			homeBtn.setBackground(new Color(127,179,213));homeBtn.setPreferredSize(new Dimension(150,30));
			aboutUsBtn = new JButton("About Us");
			aboutUsBtn.setBackground(new Color(127,179,213));aboutUsBtn.setPreferredSize(new Dimension(150,30));
			newVehiclesBtn = new JButton("New Vehicles");
			newVehiclesBtn.setBackground(new Color(127,179,213));newVehiclesBtn.setPreferredSize(new Dimension(150,30));
			viewDealersBtn = new JButton("View Dealers");
			viewDealersBtn.setBackground(new Color(127,179,213));viewDealersBtn.setPreferredSize(new Dimension(150,30));
			
			
			//Adding buttons to top panel
			topPanel.add(homeBtn);
			topPanel.add(newVehiclesBtn);
			topPanel.add(viewDealersBtn);
			topPanel.add(aboutUsBtn);
			
			//Setting the Layouts
			leftPanel.setLayout(new GridBagLayout());
			GridBagConstraints gc = new GridBagConstraints();

			gc.insets = new Insets(10,30,2,15);
			gc.anchor = GridBagConstraints.FIRST_LINE_START;
			gc.weightx = 0.5;
			gc.weighty = 0.5;

			gc.gridx = 0;gc.gridy = 3;
			leftPanel.add(vehicleLabel,gc);

			gc.gridx = 0;gc.gridy = 4;
			leftPanel.add(filterYear,gc);

			gc.gridx = 0;gc.gridy = 5;
			leftPanel.add(filterModel,gc);

			gc.gridx = 0;gc.gridy = 6;
			leftPanel.add(filterMake,gc);

			gc.gridx = 0;gc.gridy = 7;
			leftPanel.add(filterType,gc);

			gc.gridx = 0;gc.gridy = 8;
			leftPanel.add(filterPrice,gc);

			gc.gridx = 0;gc.gridy = 9;
			leftPanel.add(filterCategory,gc);

			gc.weighty = 30;
			gc.gridx = 0;gc.gridy = 10;
			leftPanel.add(filterSort,gc);

			topPanel.setLayout(new GridBagLayout());
			GridBagConstraints gc1 = new GridBagConstraints();

			gc1.insets = new Insets(40,25,20,50);

			gc1.weightx = 0.5;gc1.weighty = 0.5;

			gc1.anchor = GridBagConstraints.CENTER;

			gc.gridx = 0;gc.gridy = 2;
			topPanel.add(topPicture,gc);

			gc1.anchor = GridBagConstraints.LAST_LINE_END;
			gc1.gridx = 12;gc1.gridy = 4;
			topPanel.add(searchBar,gc1);

			gc1.anchor = GridBagConstraints.LAST_LINE_START;
			gc1.gridx = 14;gc1.gridy = 4;
			topPanel.add(searchBtn,gc1);

			gc1.gridx = 8;gc1.gridy = 4;
			topPanel.add(homeBtn,gc1);

			gc1.gridx = 9;gc1.gridy = 4;
			topPanel.add(newVehiclesBtn,gc1);

			gc1.gridx = 10;gc1.gridy = 4;
			topPanel.add(viewDealersBtn,gc1);

			gc1.gridx = 11;gc1.gridy = 4;
			topPanel.add(aboutUsBtn,gc1);

			rightPanel.setLayout(new GridBagLayout());
			

			gc2.insets = new Insets(3,3,2,5);

			gc2.weightx = 0.5;gc2.weighty = 0.5;

			gc2.anchor = GridBagConstraints.CENTER;

                        //Panes are printed here
                        
                        String msg=read("data/gmps-bresee");
                        msg=msg.substring(55);
                        String[] lines=msg.split("\n");
                        System.out.println(msg);
                        for(String line:lines){
                            try{
                            StringTokenizer st=new StringTokenizer(line,"~");
                            vehicles.add(new Vehicle(st.nextToken(),Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Float.parseFloat(st.nextToken())));
                            }catch(Exception e){}
                        }
                        panes=new Display[vehicles.size()];
                        
                        for(Vehicle v:vehicles){
                            panes[i]=new Display(v);
                            gc2.gridx = x;gc2.gridy = y;
                            rightPanel.add(panes[i],gc2);
                            i++;
                            y=y+2;
                        }      
                        filterYear.addItemListener (new ItemListener () {
                             public void itemStateChanged(ItemEvent event) {
                            if (event.getStateChange() == ItemEvent.SELECTED) {
                                Object item = event.getItem();
                                System.out.println(item);
                                i=0;x=10;y=8;
                                for(Display p:panes){
                                	p.setVisible(false);
                                	int yr=0;
                                	try{
                                		yr=Integer.valueOf((String)item).intValue();
                                		if (p.vehicle.getYear().intValue() == yr) {
                                        	p.setVisible(true);
                                        	System.out.println("yes");
                                        }
                                	}catch(Exception e){
                                		String sitem=((String)item);
                                		char op=sitem.charAt(0);
                                		if(sitem.charAt(0)=='<'){
                                			sitem=sitem.substring(1);
                                		}else{
                                			op='>';
                                			sitem=sitem.substring(0,4);
                                		}
                                		yr=Integer.valueOf(sitem).intValue();
                                		switch(op){
                                		case '<':
                                			if (p.vehicle.getYear().intValue() <= yr) {
                                            	p.setVisible(true);
                                            	System.out.println("yes");
                                            }
                                			break;
                                			
                                		case '>':
                                			if (p.vehicle.getYear().intValue() >= yr) {
                                            	p.setVisible(true);
                                            	System.out.println("yes");
                                            }
                                			break;
                                		
                                		}
                                	}
                        			
                                }
                            }
                            }
                        });
                        filterModel.addItemListener (new ItemListener () {
                             public void itemStateChanged(ItemEvent event) {
                            if (event.getStateChange() == ItemEvent.SELECTED) {
                                Object item = event.getItem();
                                System.out.println(item);
                                i=0;x=10;y=8;
                                for(Display p:panes){
                                	p.setVisible(false);
                        			if (p.vehicle.getModel() == (String)item) {
                                    	p.setVisible(true);
                                    }
                                }
                            }
                            }
                        });
                        filterMake.addItemListener (new ItemListener () {
                             public void itemStateChanged(ItemEvent event) {
                            if (event.getStateChange() == ItemEvent.SELECTED) {
                                Object item = event.getItem();
                                System.out.println(item);
                                i=0;x=10;y=8;
                                for(Display p:panes){
                                	p.setVisible(false);
                        			if (p.vehicle.getMake() == (String)item) {
                                    	p.setVisible(true);
                                    }
                                }
                            }
                            }
                        });
                        filterType.addItemListener (new ItemListener () {
                             public void itemStateChanged(ItemEvent event) {
                            if (event.getStateChange() == ItemEvent.SELECTED) {
                                Object item = event.getItem();
                                System.out.println(item);
                                i=0;x=10;y=8;
                                for(Display p:panes){
                                	p.setVisible(false);
                        			if (p.vehicle.getTrim() == (String)item) {
                                    	p.setVisible(true);
                                    }
                                }
                            }
                            }
                        });
                        filterPrice.addItemListener (new ItemListener () {
                             public void itemStateChanged(ItemEvent event) {
                            if (event.getStateChange() == ItemEvent.SELECTED) {
                                Object item = event.getItem();
                                System.out.println(item);
                                i=0;x=10;y=8;
                                for(Display p:panes){
                                	p.setVisible(false);
                        			if (p.vehicle.getPrice().intValue() == Float.valueOf((String)item).intValue()) {
                                    	p.setVisible(true);
                                    }
                                }
                            }
                            }
                        });
                        filterCategory.addItemListener (new ItemListener () {
                             public void itemStateChanged(ItemEvent event) {
                            if (event.getStateChange() == ItemEvent.SELECTED) {
                                Object item = event.getItem();
                                System.out.println(item);
                                i=0;x=10;y=8;
                                for(Display p:panes){
                                	p.setVisible(false);
                        			if (p.vehicle.getCategory().name() == (String)item) {
                                    	p.setVisible(true);
                                    }
                                }
                            }
                            }
                        });
                        filterSort.addItemListener (new ItemListener () {
                             public void itemStateChanged(ItemEvent event) {
                            if (event.getStateChange() == ItemEvent.SELECTED) {
                                Object item = event.getItem();
                                System.out.println(item);
                                
                            }
                            }
                        });
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

		}

		public static void main(String[] args){
			SwingUtilities.invokeLater(new Runnable(){

				@Override
				public void run() {
                                    try {
                                        new Screen2();
                                    } catch (Exception ex) {
                                        System.out.println(ex);
                                    }

				}

			});

		}

	}


