package JPaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class PaintToolBar extends JToolBar implements ActionListener, ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame parentFrame;
	private PaintPanel paintPanel;
	private JComboBox colChoice;
	private JComboBox sizeChoice;
	private JButton clear;
	private JButton eraser;
	private JButton pen;
	private JButton drLine;
	private JButton drCircle;
	private JButton drRect;
	private JButton openPic;
	private JButton savePic;
	private JButton colchooser;
	private JButton openPicture;
	private JFileChooser openPictureDialog;
	private JFileChooser savePictureDialog;
	
	public PaintToolBar(PaintPanel paintPanel, JFrame parentFrame) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.parentFrame = parentFrame;
		this.paintPanel = paintPanel;
		
		clear = new JButton("Clear");
		clear.addActionListener(this);
		eraser = new JButton("Eraser");
		eraser.addActionListener((ActionListener) this);
		pen = new JButton("Pen");
		pen.addActionListener((ActionListener) this);
		drLine = new JButton("Line");
		drLine.addActionListener((ActionListener) this);
		drCircle = new JButton("Circle");
		drCircle.addActionListener((ActionListener) this);
		drRect = new JButton("Rect");
		drRect.addActionListener((ActionListener) this);
		colchooser = new JButton("Colour");
		colchooser.addActionListener((ActionListener) this);
		openPicture = new JButton("OPEN");
		openPicture.addActionListener(this);
		
//		this.add(openPic);
//		this.add(savePic);
		this.add(pen);
		this.add(drLine);
		this.add(drCircle);
		this.add(drRect);
		this.add(getColChoice());
//		this.add(getSizeChoice());
		this.add(eraser);
		this.add(clear);
		this.add(openPicture);
	}	
	
	public JComboBox getColChoice() {
		if(colChoice == null) {
			colChoice = new JComboBox();
			colChoice.setMaximumSize(new Dimension(40, 25));
			colChoice.setToolTipText("ColChoice");
			colChoice.addItem(Constants.BLACK_PAINT_BRUSH);
			colChoice.addItem(Constants.BLUE_PAINT_BRUSH);
			colChoice.addItem(Constants.GREEN_PAINT_BRUSH);
			colChoice.addItem(Constants.RED_PAINT_BRUSH);
		}
		colChoice.addItemListener((ItemListener) this);
		return colChoice;
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == colChoice) {
			String name = (String)colChoice.getSelectedItem();
			if(name.equals(Constants.BLACK_PAINT_BRUSH)) {
				paintPanel.setPaintColor(new Color(0,0,0));
			}else if(name.equals(Constants.RED_PAINT_BRUSH)) {
				paintPanel.setPaintColor(new Color(255,0,0));
			}else if(name.equals(Constants.GREEN_PAINT_BRUSH)) {
				paintPanel.setPaintColor(new Color(0,255,0));
			}else if(name.equals(Constants.BLUE_PAINT_BRUSH)) {
				paintPanel.setPaintColor(new Color(0,0,255));
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pen) {
			paintPanel.setToolFlag(Constants.PAINT_BRUSH);
		}else if(e.getSource() == eraser) {
			paintPanel.setToolFlag(Constants.ERASER);
		}else if(e.getSource() == clear) {
			paintPanel.setToolFlag(Constants.CLEAR);
			paintPanel.getPaintInfo().clear();
			paintPanel.repaint();
		}else if(e.getSource() == drLine) {
			paintPanel.setToolFlag(Constants.LINE);
		}else if(e.getSource() == drCircle) {
			paintPanel.setToolFlag(Constants.CIRCLE);
		}else if(e.getSource() == drRect) {
			paintPanel.setToolFlag(Constants.RECTANGLE);
		}else if(e.getSource() == openPicture) {
			getOpenPictureDialog().showOpenDialog(parentFrame);
		}
	}
	
	public JFileChooser getOpenPictureDialog() {
		if(openPictureDialog == null) {
			openPictureDialog = new JFileChooser();
		}
		return openPictureDialog;
	}
	
}

