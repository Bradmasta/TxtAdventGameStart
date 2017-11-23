
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public  class TxtAdventDragonKeep extends JFrame implements ActionListener, WindowListener  {
	JFrame myWindow = new JFrame("Question");
	JPanel temp = new JPanel(); 

	TxtAdventUpperFloor upFlr = new TxtAdventUpperFloor();
	TxtAdventDungeon dgFlr = new TxtAdventDungeon();
	TxtAdventRandNum newRand = new TxtAdventRandNum();
	TxtAdventPrompts newPrompt = new TxtAdventPrompts();
	
	int roomCurrent = 0;
	String[] roomNameCurrent = null;
	int[][] whereToGoCurrent = null;
	String[] directionsCurrent = null;
	int[] myStatsCurrent = null;
	int[] invoCurrent = null;
	int[] flagsCurrent = null;
	
	int questionNum = 0;
	


		TextField text = new TextField(20);
        Button a;
        Button b;
        Button c;
        Button d;
       
       
        public void DragonKeepStart(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
        	questionNum = newRand.randDragonKeepQuestion();
        	roomCurrent = room;
        	roomNameCurrent = roomName;
        	whereToGoCurrent = whereToGo;
        	directionsCurrent = directions;
        	myStatsCurrent = myStats;
        	invoCurrent = invo;
        	flagsCurrent = flags;
            
            myWindow.setSize(500,300);
            myWindow.setLocationRelativeTo(null);
            setContentPane(temp);
            
            myWindow.setLayout(new FlowLayout());
            myWindow.addWindowListener(this);
            myWindow.setLayout(new GridBagLayout());
            GridLayout layout = new GridLayout(0,1);
            layout.setHgap(10);
            layout.setVgap(10);
            myWindow.setLayout(layout);
            
    		JOptionPane.showMessageDialog(null, "Here is your question: ");
    		switch (questionNum) {
    		case 1:
    			JLabel label = new JLabel("How many miles away is the sun from the earth (Approximately)?", SwingConstants.CENTER);
    			a = new Button("90 Million");
                b = new Button("97 Million");
                c = new Button("93 Million");
                d = new Button("85 Million");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
    		
    		
        	case 2:

        		label = new JLabel("Which of these colors is not on the Rubik's Cube?", SwingConstants.CENTER);
        		a = new Button("Blue");
        		b = new Button("Purple");
        		c = new Button("Yellow");
        		d = new Button("Green");
     
            
        		myWindow.add(label);
        		myWindow.add(a, layout);

        		myWindow.add(b, layout);

        		myWindow.add(c, layout);

        		myWindow.add(d, layout);
        		myWindow.setVisible(true);
        		a.addActionListener(this);
        		b.addActionListener(this);
        		c.addActionListener(this);
        		d.addActionListener(this);
        		break;
            
        	case 3:

            	label = new JLabel("What does \"RAM\" stand for?", SwingConstants.CENTER);
            	a = new Button("Random Available Memory");
                b = new Button("Readily Available Memory");
                c = new Button("Run All Memory ");
                d = new Button("Random Access Memory");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
                
        	case 4:
            	label = new JLabel("Which of these Intel Cores types doesn't exist? ", SwingConstants.CENTER);
            	a = new Button("I-1");
                b = new Button("I-3");
                c = new Button("I-5");
                d = new Button("I-7");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
                
        	case 5:
            	label = new JLabel("Which month(s) have(has) 28 days?", SwingConstants.CENTER);
            	a = new Button("6 months");
                b = new Button("7 months");
                c = new Button("1 month");
                d = new Button("All of them");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
                
        	case 6:
            	label = new JLabel("How many NFL teams are there?", SwingConstants.CENTER);
            	a = new Button("29");
                b = new Button("30");
                c = new Button("32");
                d = new Button("42");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
                
        	case 7:
            	label = new JLabel("What type of programming language is \"Java\"?", SwingConstants.CENTER);
            	a = new Button("Object Creating");
                b = new Button("Object Oriented");
                c = new Button("Scripted");
                d = new Button("Low Level");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
                
        	case 8:
            	label = new JLabel("How many stomachs does a Cow have?", SwingConstants.CENTER);
            	a = new Button("2");
                b = new Button("6");
                c = new Button("1");
                d = new Button("4");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
                
        	case 9:
            	label = new JLabel("How many bones does a fully grown adult have?", SwingConstants.CENTER);
            	a = new Button("200");
                b = new Button("150");
                c = new Button("206");
                d = new Button("214");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
                
        	case 10:
            	label = new JLabel("How many buttons does a Guitar Hero controller have?", SwingConstants.CENTER);
            	a = new Button("3");
                b = new Button("4");
                c = new Button("5");
                d = new Button("6");
         
                
                myWindow.add(label);
                myWindow.add(a, layout);

                myWindow.add(b, layout);

                myWindow.add(c, layout);

                myWindow.add(d, layout);
                myWindow.setVisible(true);
                a.addActionListener(this);
                b.addActionListener(this);
                c.addActionListener(this);
                d.addActionListener(this);
                break;
                default:
                break;

		
		}
        }


		public void actionPerformed (ActionEvent answer) {
			switch(questionNum) {
			case 1:
       	 if (answer.getSource()==c) {
       		myWindow.dispose();
          	 newPrompt.PromptQRightWrong(0);
   			 flagsCurrent[15] = 2;
   	
   			try {
   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
   			} catch (Exception e) {

   				e.printStackTrace();
   			}
   		

            }
        else {
       	 myWindow.dispose();
       	 newPrompt.PromptQRightWrong(1);
				myStatsCurrent[0] =  myStatsCurrent[0] / 2;
			flagsCurrent[15] = 1;
			roomCurrent = whereToGoCurrent[25][6];
			try {
				dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
			} catch (Exception e) {
				e.printStackTrace();
			}

            }
       	 break;
			case 2:
				if (answer.getSource()==b) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			case 3:
				if (answer.getSource()==d) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			case 4:
				if (answer.getSource()==a) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			case 5:
				if (answer.getSource()==d) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			case 6:
				if (answer.getSource()==c) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			case 7:
				if (answer.getSource()==b) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			case 8:
				if (answer.getSource()==d) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			case 9:
				if (answer.getSource()==c) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			case 10:
				if (answer.getSource()==c) {
		       		myWindow.dispose();
		          	 newPrompt.PromptQRightWrong(0);
		   			 flagsCurrent[15] = 2;
		   	
		   			try {
		   				upFlr.UpperRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
		   			} catch (Exception e) {

		   				e.printStackTrace();
		   			}
		   		

		            }
		        else {
		       	 myWindow.dispose();
		       	 newPrompt.PromptQRightWrong(1);
						myStatsCurrent[0] =  myStatsCurrent[0] / 2;
					flagsCurrent[15] = 1;
					roomCurrent = whereToGoCurrent[25][6];
					try {
						dgFlr.DunRooms(roomCurrent, roomNameCurrent, whereToGoCurrent, directionsCurrent, myStatsCurrent, invoCurrent, flagsCurrent);
					} catch (Exception e) {
						e.printStackTrace();
					}

		            }
		       	 break;
			default:
				break;
			}


        }
       
        public void windowClosing(WindowEvent e) {
        	
        	myWindow.dispose();
                System.exit(0);
        }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

       


			
		}

