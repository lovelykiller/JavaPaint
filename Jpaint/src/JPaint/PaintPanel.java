package JPaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener{
	private int paintBrushSize = 1;
	private Color paintColor = new Color(0,0,0);
	private List paintInfo = new ArrayList();
	private int toolFlag = 0;
	private BufferedImage paintImage;
	
	public PaintPanel() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void setToolFlag(int choice) {
		this.toolFlag = choice;
	}
	
	public List getPaintInfo() {
		return paintInfo;
	}
	
	public void setPaintColor(Color color) {
		paintColor = color;
	}
	public int getToolFlag() {
		return toolFlag;
	}

	public int getPaintBrushSize() {
		return paintBrushSize;
	}

	public void setPaintBrushSize(int paintBrushSize) {
		this.paintBrushSize = paintBrushSize;
	}

	public Color getPaintColor() {
		return paintColor;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
//		int endX = (int) e.getX();
//		int endY = (int) e.getY();
//		ShapeInfo info = (ShapeInfo) paintInfo.get(paintInfo.size() - 1);
//		switch(toolFlag) {
//		case Constants.ERASER:
//			break;
//		case Constants.PAINT_BRUSH:
//			break;
//		case Constants.RECTANGLE:
//			break;
//		}
//		System.out.println("This is mouseDragged");
//		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = (int) e.getX();
		int y = (int) e.getY();
		ShapeInfo info = new ShapeInfo();
		info.setX(x);
		info.setY(y);
		info.setColor(getPaintColor());
		paintInfo.add(info);
		System.out.println("This is mousePressed");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("This is mouseClicked");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("This is mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("This is mouseExited");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		ShapeInfo info = (ShapeInfo) paintInfo.get(paintInfo.size() - 1);
		int endX = e.getX();
		int endY = e.getY();
		switch(toolFlag) {
		case Constants.CIRCLE:
			int width = Math.abs(endX - info.getX());
			int height = Math.abs(endY - info.getY());
			decideRectagleCordinate(info, info.getX(), info.getY(), endX, endY);
			info.setShape(new Ellipse2D.Double(info.getX(), info.getY(), width, height));
			repaint();
			System.out.println("This is mouseReleased");
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("This is mouseMoved");
	}
	
	private void decideRectagleCordinate(ShapeInfo info, int x0, int y0, int x1, int y1) {
		int width = x1 -x0;
		int height = y1 - y0;
		if(width < 0 && height >0) {
			info.setX(x1);
			info.setY(y0);
		}else if(width > 0 && height < 0) {
			info.setX(x0);
			info.setY(y1);
		}else if(width < 0 && height < 0) {
			info.setX(x1);
			info.setY(y1);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("This is paintComponent");
		Graphics2D g2 = (Graphics2D)paintImage.getGraphics();
		Iterator iter = paintInfo.iterator();
		while(iter.hasNext()) {
			System.out.println("This is paintInfo");
			ShapeInfo info = (ShapeInfo) iter.next();
			if(info.getShape() != null) {
				g2.setColor(info.getColor());
				g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
				g2.draw(info.getShape());
			}
		}
		Graphics2D panelG2 = (Graphics2D)g;
		panelG2.drawImage(paintImage, 0, 0, null);
}

	public BufferedImage getPaintImage() {
		return paintImage;
	}

	public void setPaintImage(BufferedImage paintImage) {
		this.paintImage = paintImage;
	}

	public void setPaintInfo(List paintInfo) {
		this.paintInfo = paintInfo;
	}
}
