//prints out a color wheel, took 2 hours to code (debugging)
import java.util.Scanner;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Collections;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.InterruptedException;
import java.lang.Math;
import java.lang.Object;
import java.lang.OutOfMemoryError;
import java.lang.SecurityException;
import java.lang.String;
import java.lang.System;
import java.lang.Thread;
import java.net.URL;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileFilter;
public class colorwheel{
	public static void main(String args[]){
    
	    DrawingPanel frame = new DrawingPanel(512, 512);
	    Graphics g = frame.getGraphics();
	    double[] rgb = {255,0,0}; // array with r,g,b values, this will be changed throughout the code
	    int rgbmin = 0,center = 0; // fillarc has an x and y center parameter, rgbmin is important because everytime we decrement radius rgbmin goes up, you can play with this on the color changer
	   	Color color = new Color((int)rgb[0],(int)rgb[1],(int)rgb[2]); //declaring a new color, we need to use (int)
	    int itr=2; // this corresponds to which of the values (r,g,b) we change
	    double change; // this is how much we will change one of those values by
	    for (int i = 512; i >= 0; i-=10){ // decrementing radius 
	    	rgb[0] = 255; rgb[1] = rgbmin; rgb[2] = rgbmin;change = ((255*6.4-6.4*rgbmin)/90);itr=2; // resetting all values everytime, we work from the outside inwards
	    	for (int angle = -270; angle < 90; angle+=4){ // we're going around the circle, you can play with the values in the loops to see what it changes
	    		color = new Color((int)rgb[0],(int)rgb[1],(int)rgb[2]);//setting the color
	    		g.setColor(color);
	    		g.fillArc(center,center,i,i,angle,4);//filling the arc after we set color
	    		rgb[itr] +=change; //changing the color
	    		Math.round(rgb[itr]);//since r g and b can have a max of 255 and min of 0, every time one reaches 255 or 0 we must change itr, you can see this pattern if you play with the link brucker sent 
	    		if (rgb[itr] > 255  || rgb[itr] < rgbmin){
	    			if (rgb[itr] < rgbmin){
	    				rgb[itr] = rgbmin;
	    			}
	    			else{
	    				rgb[itr] = 255;
	    			}
	    			itr = (itr+1)%3; // if it is r that reached a threshold, we start changing g, if g, then b, if b, then r. This is a modulo 3 pattern
	    			if (rgb[itr] == 255){
	    				change = -Math.abs(change); // if the next value is already max, we want to be decvreasing it 
	    			}
	    			else{
	    				change = Math.abs(change);
	    			}
	    		}
	    	}
	    	rgbmin+=5; // by changing rgb min, we essentially make the colors brighter once again you can see this by experimenting with the color adjuster brucker sent
	    	center+=5; // changing the center of the fillarc
	    }
	}
}