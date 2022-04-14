import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Starter 
{
	
	public static BufferedImage newImage;
	
	//Instantiates the Jframe
	public static void main(String[] args){

		Animator.Framer();
		
		}
		
	//Corrupts all the colors of the image
	public static BufferedImage Wacky()
    {
		for (int x = 0; x < newImage.getWidth(); x++) {
			for (int y = 0; y < newImage.getHeight(); y++) {
				newImage.setRGB(x, y, (newImage.getRGB(x, y)) / 2);
			}
		}
		return newImage;
	}
	
	//Takes two images and averages them together such that both are visibile
	public static BufferedImage Averages(String input_text) throws IOException
	{
		BufferedImage input2;
		input2 = ImageIO.read(new File(input_text));
		
		if (newImage.getWidth() == input2.getWidth() && newImage.getHeight() == input2.getHeight()) {
			for (int x = 0; x < newImage.getWidth(); x++) {
				for (int y = 0; y < newImage.getHeight(); y++) {

					if (newImage.getRGB(x, y) != input2.getRGB(x, y)) {
						Color c1 = new Color(newImage.getRGB(x, y));
						Color c2 = new Color(input2.getRGB(x, y));
						Color color = new Color((c1.getRed() + c2.getRed()) / 2, (c1.getGreen() + c2.getGreen()) / 2, (c1.getBlue() + c2.getBlue()) / 2);
						newImage.setRGB(x, y, color.getRGB());
					}
				}
			}
		}
		else
		{
			System.out.println("Both images must be of the same size");
		}
		return newImage;
	}

	//Darkens or lightens the image
	public static BufferedImage Gamma(char z)
	{
		     for (int x = 0; x < newImage.getWidth(); x++) {
		    	 
		         for (int y = 0; y < newImage.getHeight(); y++) {

		        	 Color c1 = new Color(newImage.getRGB(x,y));
	        		 Color color = new Color(Color_adder(c1.getRed(),z),Color_adder(c1.getGreen(),z),Color_adder(c1.getBlue(),z));
	        		 newImage.setRGB(x, y, color.getRGB());
	        		 
		         }

		}
		     return newImage;
	 	}
	
	//Attempts to create a new image with only the outlines of the image
	public static BufferedImage Outlines()
	{
		Color color = new Color(0,0,0);
		
		     for (int x = 0; x < newImage.getWidth(); x++) {
		    	 
		         for (int y = 0; y < newImage.getHeight(); y++) {

		        	 Color c1 = new Color(newImage.getRGB(x,y));
		        	 
	        		 if(c1.getRed() < color.getRed() && (c1.getGreen() < color.getGreen()) && (c1.getBlue() < color.getBlue())) {
                       color = c1;
		         }

		}
		     }
		     
		     
		     for (int x = 0; x < newImage.getWidth(); x++) {
		    	 
		         for (int y = 0; y < newImage.getHeight(); y++) {

		        	 Color c1 = new Color(newImage.getRGB(x,y));
		        	 
	        		 if(c1.getRed() > color.getRed()+100 && (c1.getGreen() > color.getGreen()+100) && (c1.getBlue() > color.getBlue()+100)) {
	        			 newImage.setRGB(x, y, -1);
		         }
	        		 else {
	        			 newImage.setRGB(x, y, -16777216);
	        		 }

		}
		     }
		     
return newImage;
	 	}
	
	//adds a new BufferedImage to the Jframe
	public static BufferedImage New_Jpg(String input_text) throws IOException {
		
		newImage = ImageIO.read(new File(input_text));
		return newImage;

	}
	
	//Writes the Jpeg to a file
	public static void Writes(String input_text)
	 	{
	 		try {
			     File file = new File(input_text);
			     ImageIO.write(newImage, "jpg", file);
			    
	 		} catch (IOException e) {
	 			 e.printStackTrace();
	 		}

	 	}
	
	//Adds an arbitrary value to a specified RGB value and checks to make sure it is not over 255
	public static int Color_adder(int color, char z) 
	{
	  if(z == 'l') {
		  color+=20;
	      if(color > 255) {
	    	  color = 255;
	      }
		  
	  }
	  if(z == 'd') {
		  color-=20;
	      if(color < 0) {
	    	  color = 0;
	      }
	  }
		
		return color;
	}
	

	
}
