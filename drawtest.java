// prints parabola tracking projectile motion, took 35 min to code
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
public class drawtest
{
  public static void main(String args[])
  {
    DrawingPanel panel = new DrawingPanel(1000, 600);
    Graphics g = panel.getGraphics();
    Scanner sc = new Scanner(System.in);
    final double scalar = 1000.0 / 900.0 * 9.81;
    final double v = 30.0;
    System.out.print("Please enter the start angle in degrees: ");
    double iangle = sc.nextDouble();
    System.out.println();
    System.out.print("Please enter the final angle in degrees: ");
    double fangle = sc.nextDouble();
    System.out.println();
    System.out.print("Please enter the step size in degrees: ");
    double step = sc.nextDouble();
    System.out.println();
    for (double i = iangle; i <= fangle; i += step)
    {
      double angle = i * Math.PI / 180;
      double t = 0;
      double xv = v * Math.cos(angle);
      double yv = v * Math.sin(angle);
      for (int j = 0; j < 100; j++)
      {
        double x = xv * t;
        double y = yv * t + 0.5 * -9.81 * t * t;
        g.fillOval((int) (x * scalar), 600 - (int) (y * scalar), 2, 2);
        t += 2.0 * yv / 9.81 / 100;
      }
    }
  }
}