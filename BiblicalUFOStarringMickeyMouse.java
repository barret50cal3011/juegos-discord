import javax.swing.JFrame;

public class BiblicalUFOStarringMickeyMouse
{
	public JFrame frame;

	public Board board;

	public BiblicalUFOStarringMickeyMouse()
	{
		board = new Board();

		frame = new JFrame("Biblical UFO starring Miockey Mouse");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void main(String[] args)
	{
		new BiblicalUFOStarringMickeyMouse();
	}
}

