import javax.swing.JOptionPane;


public class TxtAdventNullCheck {	
	TxtAdventMainFloor mainFlr = new TxtAdventMainFloor();
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
