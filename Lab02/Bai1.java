import javax.swing.JOptionPane;

public class Bai1 {
	public static void main(String[] args) {
		int op = JOptionPane.showConfirmDialog(null, 
				"Do you want to change to the first ticket?");
		JOptionPane.showMessageDialog(null, "You 've chosen: "
				+ (op == JOptionPane.YES_OPTION? "Yes":"No"));
		System.exit(0);
	}
}