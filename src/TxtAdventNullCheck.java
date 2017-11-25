

import javax.swing.JOptionPane;
/*****************************************************************
 * Very simple class that checks if an input window is either cancelled or the X is pressed. If those are the cases, the program will end.
 *****************************************************************/

public class TxtAdventNullCheck {	
	
	public String nullCheck(String check) {
		String nullCheck = null;
	
		try {

			 if (!check.equals(null)) {
			
			nullCheck = check;
			}
		}
		catch (NullPointerException error) {
			
			JOptionPane.showMessageDialog(null, "Goodbye :)");
			System.exit(0);
		}
		return nullCheck;
  }
	
					
}

