package JPaint;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

public class JPaint extends JFrame{
	private PaintPanel paintPanel;
	private PaintToolBar toolBar;
	
	public JPaint(String s) {
		paintPanel = new PaintPanel();
		toolBar = new PaintToolBar(paintPanel, this);
		this.setTitle(s);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(toolBar, BorderLayout.WEST);
		this.getContentPane().add(paintPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		setVisible(true);
		BufferedImage paintImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)paintImage.getGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());
		paintPanel.setPaintImage(paintImage);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPaint jPaint = new JPaint("Java Paint");
	}

}
