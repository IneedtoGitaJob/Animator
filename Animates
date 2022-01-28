import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//EpUICH6WEAEb1pM.jpg


public class Animator{
	public static int Authorize = 0;
	//Creates the Jframe to hold the buffered image and to take in input
	public static void Framer(){

		//Creates the Jframe and adds a textbox and an area for the buffered image to be displayed
		JLabel Instructions = new JLabel("Input:");
		JFrame frame = new JFrame("Art");
		JPanel Pan = new JPanel();
		JTextField Text = new JTextField(10);
		
		Pan.add(Text);

		frame.add(Instructions);
		frame.add(Pan);
		frame.setLayout(new FlowLayout());
		frame.pack();
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//On enter takes in the input from the user
		Text.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//get user input
				String input_text = Text.getText();
				
				//if there is no input
				if(input_text.equals("")) {
					System.out.println("error");
				}
				else {
					//get first char which is the instructions
					char instructions = input_text.charAt(0);

					switch(instructions) 
		            {
		//Averages
		case '1':
            if(Authorize == 1) {
			try {
				if(input_text.length() > 1) {
					
					input_text = input_text.substring(1);
					frame.add(new JLabel(new ImageIcon(Starter.Averages(input_text))));

					
				}
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
                        
            }		
			break;

			//Wacky
		case '2':if(Authorize == 1) {
							frame.add(new JLabel(new ImageIcon(Starter.Wacky())));
		}
			break;
			//Change Gamma
		case '3':
			if(Authorize == 1) {
							if(input_text.length() > 1) {
								
								char z = input_text.charAt(1);
								if(z == 'l' || z == 'd') {
									frame.add(new JLabel(new ImageIcon(Starter.Gamma(z))));
								}
								
							}
			}
			break;
			//Outlines
		case '4':
			if(Authorize == 1) {
							frame.add(new JLabel(new ImageIcon(Starter.Outlines())));
			}
			break;
			//Writes to a new file
		case '5':
			if(Authorize == 1) {
			Starter.Writes(input_text);	
			}
			break;
		//Gets a new image
		case '6':
			input_text = input_text.replaceFirst("6","");
						try {
							frame.add(new JLabel(new ImageIcon(Starter.New_Jpg(input_text))));
							Authorize = 1;
						} catch (IOException e1) {
							e1.printStackTrace();
							Authorize = 0;
						}
						
			break;
			//if an improper instruction is given
		 default:
			 System.out.println("Invalid instruction");
		            }
				}
					//reset text box
					Text.setText("");
				
				//Updates frame automatically whenever enter is pressed
				frame.update(frame.getGraphics());
				
			}
		});
		

		
	}
	
	





}

