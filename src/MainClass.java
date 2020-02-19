import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MirrorImage test = new MirrorImage();
		
		System.out.println("Enter the path of image: ");
    	Scanner keyboard = new Scanner(System.in);
		
		test.setFilename(keyboard.nextLine());
		test.setWdith();
		test.setHeight();
		
		test.mirrorHorizontal();
		
	}

}
