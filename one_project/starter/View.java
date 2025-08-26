import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;

public class View extends JPanel
{
	private JButton b1;

	public View(Controller c)
	{
		b1 = new JButton("Don't push me!");
		b1.addActionListener(c);
		this.add(b1);
	}
}
