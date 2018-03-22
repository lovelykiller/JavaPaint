package JPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

public class ShapeInfo {
	private int x;
	private int y;
	private Color color;
	private Shape shape;
	public Shape getShape() {
		return shape;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
