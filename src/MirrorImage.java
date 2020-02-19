
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MirrorImage extends Canvas{
	
	@Override
	public String getFilename() {
		return filename;
	}

	@Override
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Override
	public int getWdith() {
		return width;
	}

	@Override
	public void setWdith() {
		BufferedImage simg = null;
	    //File object
	    File f = null;
	    //read source image file
	    try{
	      f = new File(this.filename);
	      simg = ImageIO.read(f);
	      this.width = simg.getWidth();
	    }catch(Exception e){
	      System.out.println("Error(Set Filename first): " + e);
	    }
	    
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight() {
		BufferedImage simg = null;
	    //File object
	    File f = null;
	    //read source image file
	    try{
	      f = new File(this.filename);
	      simg = ImageIO.read(f);
	      this.height = simg.getHeight();
	    }catch(IOException e){
	      System.out.println("Error(Set Filename first): " + e);
	    }
	    
	}
	
	public void mirrorHorizontal() {
		
		BufferedImage simg = null;
	    //File object
	    File f = null;
	    //read source image file
	    try{
	      f = new File(this.filename);
	      simg = ImageIO.read(f);
	    }catch(IOException e){
	      System.out.println("Error: " + e);
	    }
		
//	    BufferedImage for mirror image
	    BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
	    //create mirror image pixel by pixel
	    for(int y = 0; y < height; y++){
	      for(int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--){
	        //lx starts from the left side of the image
	        //rx starts from the right side of the image
	        //get source pixel value
	        int p = simg.getRGB(lx, y);
	        //set mirror image pixel value - both left and right
	        mimg.setRGB(lx, y, p);
	        mimg.setRGB(rx, y, p);
	      }
	    }
	    //save mirror image
	    try{
	    	System.out.println("Enter a name for the output image: ");
	    	Scanner keyboard = new Scanner(System.in);
	    	String output = keyboard.nextLine();
	    	
	        String outputPath = this.filename.substring(0, this.filename.lastIndexOf('\\')) +"\\"+ output ;
	    	
	    	f = new File(outputPath +".bmp");
	    	
	    	ImageIO.write(mimg, "png", f);
	    }catch(IOException e){
	      System.out.println("Error: " + e);
	    }
		
	}
	
	public void mirrorVertical() {
		
		BufferedImage simg = null;
	    //File object
	    File f = null;
	    //read source image file
	    try{
	      f = new File(this.filename);
	      simg = ImageIO.read(f);
	    }catch(IOException e){
	      System.out.println("Error: " + e);
	    }
		
//	    BufferedImage for mirror image
	    BufferedImage mimg = new BufferedImage(width, height*2, BufferedImage.TYPE_INT_ARGB);
	    //create mirror image pixel by pixel
	    for(int x = 0; x < width; x++){
	      for(int uy = 0, dy = height*2 - 1; uy < height; uy++, dy--){
	        //lx starts from the left side of the image
	        //rx starts from the right side of the image
	        //get source pixel value
	        int p = simg.getRGB(x, uy);
	        //set mirror image pixel value - both left and right
	        mimg.setRGB(x, uy, p);
	        mimg.setRGB(x, dy, p);
	      }
	    }
	    //save mirror image
	    try{
	    	System.out.println("Enter a name for the output image: ");
	    	Scanner keyboard = new Scanner(System.in);
	    	String output = keyboard.nextLine();
	    	
	        String outputPath = this.filename.substring(0, this.filename.lastIndexOf('\\')) +"\\"+ output ;
	    	
	    	f = new File(outputPath +".bmp");
	    	
	    	ImageIO.write(mimg, "png", f);
	    }catch(IOException e){
	      System.out.println("Error: " + e);
	    }
		
	}
	
	
}//class ends here