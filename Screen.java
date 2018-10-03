import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class Screen extends JPanel implements KeyListener
{
    public ArrayList<Trail> p1Trail;
    public ArrayList<Trail> p2Trail;
    public ArrayList<Trail> particles;
    JFrame frame;
    Player p1;
    Player p2;
    int State;
    int speed = 5;
    int p1Score = 0;
    int p2Score = 0;
    boolean defaultColors = true;
    boolean soundOn = true;
    boolean crazyMenu = false;
    Color buttonColor;
    Color buttonColor1;
    Color buttonColor2;
    Color buttonColor3;
    Color buttonColor4;
    int returnToMenu = 0;
    Color defaultP1 = new Color(255,135,20);
    Color defaultP2 = new Color(150,150,255);
    boolean p2Lock = false;
    boolean rigged = false;
    
    
    public ArrayList getp1Trail()
    {
        return p1Trail;
    }
    
    public ArrayList getp2Trail()
    {
        return p2Trail;
    }
    
    public Player getp1()
    {
        return p1;
    }
    
    public Player getp2()
    {
        return p2;
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
    public int getState()
    {
        return State;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public boolean getSound()
    {
        return soundOn;
    }
    
    public boolean getColors()
    {
        return defaultColors;
    }
    
    
    
    public Player turn(Player p, int dX, int dY)
    {
                    p.setX(p.getX() - p.getDX());
                    p.setY(p.getY() - p.getDY());
                    p.setDY(dY);
                    p.setDX(dX);
                    p.move();
                    p.move();
                    return p;
    }
    
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();
    if(key == KeyEvent.VK_SPACE && State != 100 && State != 75 && State != 50)
    {
        if(State != 0)
        {
        p1Trail.clear();
        p2Trail.clear();
        String previousPlayer1Type = p1.getType();
        String previousPlayer2Type = p2.getType();
        Color previousBaseP1 = p1.getBase();
        Color previousBaseP2 = p2.getBase();
        Color previousSP1 = p1.getSecondaryColor();
        Color previousSP2 = p2.getSecondaryColor();
        if(defaultColors)
        p2 = new Player(10,10, defaultP1.getRed(), defaultP1.getGreen(), defaultP1.getBlue(), 0, speed);
        else p2 = new Player(10,10, random(255), random(255), random(255), 0, speed);
        p2.setType(previousPlayer2Type);
        p2.setBase(previousBaseP2);
        p2.setSecondary(previousSP2);
        p2.setTime((int)(Math.random() * 10));
        if(defaultColors)
        p1 = new Player(frame.getWidth() - 10, 20*33, defaultP2.getRed(), defaultP2.getGreen(), defaultP2.getBlue(), 0, -speed);
        else p1 = new Player(frame.getWidth() / 2, frame.getHeight() - 125, random(255), random(255), random(255), 0, -speed);
        p1.setType(previousPlayer1Type);
        p1.setBase(previousBaseP1);
        p1.setSecondary(previousSP1);
        p1.setTime((int)(Math.random() * 10));
        p2Lock = false;
        /*p2.setTime(5000);
        p1.setTime(5000);*/
        /*try{
            Thread.sleep(500);
        }
        catch(InterruptedException ie){}*/
        State = 0;
        }
        else
        {

            try{Thread.sleep(25);}
            catch(InterruptedException ie){}
            
            if(soundOn)
            SoundEffect.ENGINESTART.play1();
            //if(soundOn)
            //Thread.sleep(920);
            State = 1;
            
           
        }
        repaint();
    }
    
    
    
        if(State == 1)
    {
        /*if(key == KeyEvent.VK_7)
        {
            rigged = !rigged;
            p2Lock = false;
        }*/
        if(!p1.getType().equals("AI"))
        {
            if(key == KeyEvent.VK_LEFT)
        {
            if(p1.getDX() != speed && p1.getDX() != -speed)
            {
            p1 = turn(p1, -speed, 0);
            }
            
        }
        else if(key == KeyEvent.VK_RIGHT)
        {
            if(p1.getDX() != -speed && p1.getDX() != speed)
            {
                p1 = turn(p1, speed, 0);
            }
        }
        else if(key == KeyEvent.VK_UP)
        {
            if(p1.getDY() != speed && p1.getDY() != -speed)
            {
                p1 = turn(p1, 0, -speed);
            }
            
        }
        else if(key == KeyEvent.VK_DOWN)
        {
            if(p1.getDY() != -speed && p1.getDY() != speed)
            {
                p1 = turn(p1, 0, speed);
            }
            
        }
        else if(key == KeyEvent.VK_SLASH && rigged)
        {
            p2Lock = !p2Lock;
        }
    }
        
         if(!p2.getType().equals("AI") && !p2Lock)
         {
        if(key == KeyEvent.VK_A)
        {
            if(p2.getDX() != speed && p2.getDX() != -speed)
            {
            p2 = turn(p2, -speed, 0);
            }
            
        }
        else if(key == KeyEvent.VK_D)
        {
            if(p2.getDX() != -speed && p2.getDX() != speed)
            {
            p2 = turn(p2, speed, 0);
            }
           
        }
        else if(key == KeyEvent.VK_W)
        {
            if(p2.getDY() != speed && p2.getDY() != -speed)
            {
            p2 = turn(p2, 0, -speed);
            }
            
        }
        else if(key == KeyEvent.VK_S)
        {
            if(p2.getDY() != -speed && p2.getDY() != speed)
            {
            p2 = turn(p2, 0, speed);
            }
            
        }
    }
    }
    
    if(key == KeyEvent.VK_ESCAPE)
    {
        
        if(State != 100 && State != 75 && State != 50 && State != 125)
        State = 0;
        
        if(State != 100 && soundOn)
        SoundEffect.BUTTON.play();
        
        try{Thread.sleep(25);}
        catch(InterruptedException ie){}
        
        if(State == 100 || State == 75 || State == 50 || State == 125)
        State = 100;
        
        if(State != 100 && State != 75 && State != 50 && State != 125)
        createMenu();
        
        State = 100;
        this.repaint();
        
        
    }
        
    }
    
    //not currently needed
    public void keyReleased(KeyEvent e) 
    {
        
    }
    //not currently needed
    public void keyTyped(KeyEvent e) 
    {
        
    }
    
    
    
    public Screen()
    {
        super();
        p1Trail = new ArrayList<Trail>();
        p2Trail = new ArrayList<Trail>();
        particles = new ArrayList<Trail>();
        State = 100;
        frame = new JFrame("Tron");
        frame.setSize(1220,778);
        frame.add(this);
        frame.setVisible(true);
        frame.getContentPane().add(this,BorderLayout.CENTER);
        frame.setResizable(false);
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p2 = new Player(10,10, 255, 135, 20, 0, speed);
        p1 = new Player(frame.getWidth() - 10, frame.getHeight() - 125, 150, 150, 255, 0, -speed);
        p2.setBase(new Color(0, 0, 255));
        p2.setSecondary(new Color(50, 50, 200));
        p1.setBase(new Color(255, 155,40));
        p1.setSecondary(new Color(0,0,255));
        createMenu();

        this.repaint();
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        if(State == 100)
        {
            g.setColor(new Color(0,0,55));
            g.fillRect(0,0,2000,1000);
            
            for(int i = 0; i < p1Trail.size(); i++)
        {
            g.setColor(p1Trail.get(i).getColor());
            g.fillOval(p1Trail.get(i).getX(), p1Trail.get(i).getY(), speed+(speed-1)/2-1, speed+(speed-1)/2-1);
        }
        
        for(int i = 0; i < p2Trail.size(); i++)
        {
            g.setColor(p2Trail.get(i).getColor());
            g.fillOval(p2Trail.get(i).getX(), p2Trail.get(i).getY(), speed+(speed-1)/2-1, speed+(speed-1)/2-1);
        }
            
            g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 - 25, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor1);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 - 15, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Play", frame.getWidth() / 2 - 10, frame.getHeight() / 2 + 5);
            
            g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 35, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor2);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 + 45, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Settings", frame.getWidth() / 2 - 20, frame.getHeight() / 2 + 65);
            
            g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 95, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor3);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 + 105, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Controls", frame.getWidth() / 2 - 20, frame.getHeight() / 2 + 125);
            
            g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 155, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor4);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 + 165, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Color Select", frame.getWidth() / 2 - 30, frame.getHeight() / 2 + 185);
            
            
            g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 215, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor2);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 + 225, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Quit", frame.getWidth() / 2 - 10, frame.getHeight() / 2 + 245);
            
            g.drawImage(LoadImage(), 300,-150, null);
        }
        
        
        
        
        if(State == 75)
        {
            g.setColor(new Color(0,0,55));
            g.fillRect(0,0,2000,1000);
            
            for(int i = 0; i < p1Trail.size(); i++)
        {
            g.setColor(p1Trail.get(i).getColor());
            g.fillOval(p1Trail.get(i).getX(), p1Trail.get(i).getY(), speed+(speed-1)/2-1, speed+(speed-1)/2-1);
        }
        
        for(int i = 0; i < p2Trail.size(); i++)
        {
            g.setColor(p2Trail.get(i).getColor());
            g.fillOval(p2Trail.get(i).getX(), p2Trail.get(i).getY(), speed - 1+(speed-1)/2, speed+(speed-1)/2-1);
        }
        
        String colors;
        if(defaultColors)
        colors = "ON";
        else colors = "OFF";
        g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 215, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 + 225, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Default Colors: " + colors, frame.getWidth() / 2 - 55, frame.getHeight() / 2 + 245);
            
        String sounds;
        if(soundOn)
        sounds = "ON";
        else sounds = "OFF";
        g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 95, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor2);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 + 105, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Sound Effects: " + sounds, frame.getWidth() / 2 - 55, frame.getHeight() / 2 + 125);
            
        String crazy;
        if(crazyMenu)
        crazy = "ON";
        else crazy = "OFF";
        g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 155, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor3);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 + 165, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Crazy Menu: " + crazy, frame.getWidth() / 2 - 55, frame.getHeight() / 2 + 185);
            
        
        
        
        g.setColor(new Color(100, 100, 250));
            g.fillRect(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 275, 200, 50);
            if(defaultColors)
            g.setColor(new Color(10,10,100));
            else g.setColor(buttonColor4);
            g.fillRect(frame.getWidth() / 2 - 90, frame.getHeight() / 2 + 285, 180, 30);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Reset Score", frame.getWidth() / 2 - 55, frame.getHeight() / 2 + 305);
        
        g.drawImage(LoadImage(), 300,-150, null);
        }
        
        
        
        
        if(State == 50)
        {
            g.setColor(new Color(0,0,55));
            g.fillRect(0,0,2000,1000);
            
            for(int i = 0; i < p1Trail.size(); i++)
        {
            g.setColor(p1Trail.get(i).getColor());
            g.fillOval(p1Trail.get(i).getX(), p1Trail.get(i).getY(), speed+(speed-1)/2-1, speed+(speed-1)/2-1);
        }
        
        for(int i = 0; i < p2Trail.size(); i++)
        {
            g.setColor(p2Trail.get(i).getColor());
            g.fillOval(p2Trail.get(i).getX(), p2Trail.get(i).getY(), speed+(speed-1)/2-1, speed+(speed-1)/2-1);
        }
            
            g.setColor(Color.WHITE);
            g.drawString("Player 1", frame.getWidth() / 2 - 20, frame.getHeight() / 2);
            g.drawString("Move Up: W", frame.getWidth() / 2, frame.getHeight() / 2 + 15);
            g.drawString("Move Left: A", frame.getWidth() / 2, frame.getHeight() / 2 + 30);
            g.drawString("Move Down: S", frame.getWidth() / 2, frame.getHeight() / 2 + 45);
            g.drawString("Move Right: D", frame.getWidth() / 2, frame.getHeight() / 2 + 60);
            
            g.drawString("Player 2", frame.getWidth() / 2 - 20, frame.getHeight() / 2 + 75);
            g.drawString("Move Up: Up Arrow", frame.getWidth() / 2, frame.getHeight() / 2 + 90);
            g.drawString("Move Left: Left Arrow", frame.getWidth() / 2, frame.getHeight() / 2 + 105);
            g.drawString("Move Down: Down Arrow", frame.getWidth() / 2, frame.getHeight() / 2 + 120);
            g.drawString("Move Right: Right Arrow", frame.getWidth() / 2, frame.getHeight() / 2 + 135);
            
            g.drawImage(LoadImage(), 300,-150, null);
        }
        
        if(State != 100 && State != 50 && State != 75 && State != 125)
        {
        g.setColor(new Color(0,0,55));
        g.fillRect(0,0,2000,1000);
        
        g.setColor(new Color(100, 100, 250));
        for(int x = 10; x <= 1110; x += 110)
        {
            for(int y = 10; y <= 560; y += 110)
            {
                g.fillRect(x, y, 100, 100);
            }
        }
        
        g.setColor(new Color(10, 10, 100));
        for(int x = 15; x <= 1115; x += 110)
        {
            for(int y = 15; y <= 565; y += 110)
            {
                g.fillRect(x, y, 90, 90);
            }
        }
        
        
        for(int i = 0; i < p1Trail.size(); i++)
        {
            g.setColor(p1Trail.get(i).getColor());
            g.fillRect(p1Trail.get(i).getX(), p1Trail.get(i).getY(), speed, speed);
        }
        
        for(int i = 0; i < p2Trail.size(); i++)
        {
            g.setColor(p2Trail.get(i).getColor());
            g.fillRect(p2Trail.get(i).getX(), p2Trail.get(i).getY(), speed, speed);
        }
        
        /*
        g.setColor(p1.getTrail());
        g.fillRect(p1.getX(), p1.getY(), speed, speed);
        
        g.setColor(p2.getTrail());
        g.fillRect(p2.getX(), p2.getY(), speed, speed);
        */
        g.setColor(Color.WHITE);
        if(State == 3)
        g.drawString("Player1 Wins!", frame.getWidth() / 2, frame.getHeight() / 2);
       
        
        if(State == 4)
        g.drawString("Player2 Wins!", frame.getWidth() / 2, frame.getHeight() / 2);
        
        if(State == 5)
        g.drawString("The Players Collided", frame.getWidth() / 2, frame.getHeight() / 2);
        
        
        g = paintPlayer(g, p1);
        g = paintPlayer(g, p2);
        
        if(State >= 3 && State <= 5)
        {
            for(int i = 0; i < particles.size(); i++)
            {
                if(State >= 3 && State <= 5)
                {
                g.setColor(particles.get(i).getColor());
                g.fillRect(particles.get(i).getX(), particles.get(i).getY(), speed, speed);
                }
            }
        }
        
        g.setColor(Color.WHITE);
        g.fillRect(0,frame.getHeight() - 100, frame.getWidth(), 100);
        
        if(!p2.getType().equals("AI"))
        g.setColor(p2.getTrail());
        else g.setColor(Color.RED);
        g.fillRect(10, frame.getHeight() - 90, frame.getWidth() / 2 - 10, 60);
        g.setColor(Color.BLACK);
        g.drawRect(10, frame.getHeight() - 90, frame.getWidth() / 2 - 10, 60);
        
        if(!p1.getType().equals("AI"))
        g.setColor(p1.getTrail());
        else g.setColor(Color.RED);
        g.fillRect(frame.getWidth() / 2, frame.getHeight() - 90, frame.getWidth() / 2 - 10, 60);
        g.setColor(Color.BLACK);
        g.drawRect(frame.getWidth() / 2, frame.getHeight() - 90, frame.getWidth() / 2 - 10, 60);
        
        if(p1.getType().equals("AI"))
        g.setColor(p1.getTrail());
        else g.setColor(new Color(255 - p1.getTrail().getRed(), 255 - p1.getTrail().getGreen(), 255 - p1.getTrail().getBlue()));
        if(p1.getType().equals("AI"))
        g.drawString("Player 2 is an AI", frame.getWidth() / 4 * 3 - 20, frame.getHeight() - 50);
        else g.drawString("Player 2 is a Player", frame.getWidth() / 4 * 3 - 20, frame.getHeight() - 50);
        
        if(p2.getType().equals("AI"))
        g.setColor(p2.getTrail());
        else g.setColor(new Color(255 - p2.getTrail().getRed(), 255 - p2.getTrail().getGreen(), 255 - p2.getTrail().getBlue()));
        if(p2.getType().equals("AI"))
        g.drawString("Player 1 is an AI", frame.getWidth() / 4 - 20, frame.getHeight() - 50);
        else g.drawString("Player 1 is a Player", frame.getWidth() / 4 - 20, frame.getHeight() - 50);
        
        if(State == 0)
        {
            g.setColor(new Color(255,255,255));
            g.drawString("Press the Spacebar to continue", frame.getWidth() / 2 - 80, frame.getHeight() / 2);
        }

        g.setColor(p2.getTrail());
        g.drawString("Player 1: " + p2Score, 10, frame.getHeight() - 105);
        
        g.setColor(p1.getTrail());
        g.drawString("Player 2: " + p1Score, frame.getWidth() - 70, frame.getHeight() - 105);
    }
    
    if(State == 125)
    {
        g.setColor(new Color(0,0,55));
            g.fillRect(0,0,2000,1000);
            
            for(int i = 0; i < p1Trail.size(); i++)
        {
            g.setColor(p1Trail.get(i).getColor());
            g.fillOval(p1Trail.get(i).getX(), p1Trail.get(i).getY(), speed+speed/2, speed+speed/2);
        }
        
        for(int i = 0; i < p2Trail.size(); i++)
        {
            g.setColor(p2Trail.get(i).getColor());
            g.fillOval(p2Trail.get(i).getX(), p2Trail.get(i).getY(), speed+speed/2, speed+speed/2);
        }
        
        
        for(int xx = 100; xx <= 320 ; xx += 110)
        {
        for(int i = 300; i < 720; i+=60)
        {
            int x = (i - 300) / 60;
            if(x == 0)
            g.setColor(Color.RED);
            else if(x == 1)
            g.setColor(new Color(250,105,33));
            else if(x == 2)
            g.setColor(Color.YELLOW);
            else if(x == 3)
            g.setColor(new Color(95,250,0));
            else if(x == 4)
            g.setColor(new Color(46,203,255));
            else if(x == 5)
            g.setColor(new Color(95,250,253));
            else if(x == 6)
            g.setColor(new Color(249,52,160));
            
            g.fillRect(xx,i,100,50);
            
        }
        }
        
        for(int xx = frame.getWidth() - 400; xx <= 1040 ; xx += 110)
        for(int i = 300; i < 720; i+=60)
        {
            int x = (i - 300) / 60;
            if(x == 0)
            g.setColor(Color.RED);
            else if(x == 1)
            g.setColor(new Color(250,105,33));
            else if(x == 2)
            g.setColor(Color.YELLOW);
            else if(x == 3)
            g.setColor(new Color(95,250,0));
            else if(x == 4)
            g.setColor(new Color(46,203,255));
            else if(x == 5)
            g.setColor(new Color(95,250,253));
            else if(x == 6)
            g.setColor(new Color(249,52,160));
            
            g.fillRect(xx,i,100,50);
        }
        g.setColor(Color.WHITE);
        g.drawString("Base",frame.getWidth() - 400,260);
        g.drawString("Second",frame.getWidth() - 400 + 110,260);
        g.drawString("Trail",frame.getWidth() - 400 + 220,260);
        g.drawString("Base",100,260);
        g.drawString("Second",210,260);
        g.drawString("Trail",320,260);
        g.drawImage(LoadImage(), 300,-150, null);
    }
    
    g.setColor(Color.WHITE);
    g.drawString("Press Ctrl + Esc to return to the main menu", 10, 20);
    }
    

    
    
    
    
    
    public int random(int n)
    {
        Random generator = new Random();
        return generator.nextInt(n);
    }
    
    public BufferedImage LoadImage()
    {
        BufferedImage img = null;
        URL url = this.getClass().getClassLoader().getResource("TRON_ Legacy (Original Motion Picture Soundtrack).png");
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
        }
        return img;
    }
    
    
    public void createMenu()
    {
        p1Trail.clear();
        int x = random(250) + 100;
        int newTrailX;
        int newTrailY;
        int newTrailSpeed;
        for(int i = 0; i < x; i++)
        {
            newTrailX = random(frame.getWidth());
            newTrailY = random(frame.getHeight());
            newTrailSpeed = random(5) + 1;
            int newTrailSpeedY = random(5) + 1;
            if(defaultColors)
            p1Trail.add(new Trail(newTrailX, newTrailY, new Color(150,150,255), 250));
            else p1Trail.add(new Trail(newTrailX, newTrailY, new Color(random(255),random(255),random(255)), 250));
            p1Trail.get(i).setSpeed(newTrailSpeed);
            if(!crazyMenu)
            p1Trail.get(i).setSpeedY(0);
            else p1Trail.get(i).setSpeedY(newTrailSpeedY);
        }
        
        p2Trail.clear();
        int y = random(250) + 100;
        for(int n = 0; n < y; n++)
        {
            newTrailX = random(frame.getWidth());
            newTrailY = random(frame.getHeight());
            newTrailSpeed = -1 * random(5) - 1;
            int newTrailSpeedY = -1 * random(5) - 1;
            if(defaultColors)
            p2Trail.add(new Trail(newTrailX, newTrailY, new Color(255,135,20), 250));
            else p2Trail.add(new Trail(newTrailX, newTrailY,  new Color(random(255),random(255),random(255)), 250));
            p2Trail.get(n).setSpeed(newTrailSpeed);
            if(!crazyMenu)
            p2Trail.get(n).setSpeedY(0);
            else p2Trail.get(n).setSpeedY(newTrailSpeedY);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    public Graphics facingRight(Player p , Graphics g)
    {
        g.setColor(p.getSecondaryColor());
        g.fillRect(p.getX() + 26 - 15, p.getY() - 11, 15, 27);
        g.fillRect(p.getX() + 21 - 5, p.getY() - 13, 5, 31);
        
        g.fillRect(p.getX() + 4 - 15, p.getY() - 11, 15, 27);
        g.fillRect(p.getX() - 1 - 5, p.getY() - 13, 5, 31);
        
        g.setColor(p.getBase());
        g.fillRect(p.getX() + 30 - 39, p.getY() - 4, 39, 13);
        g.fillRect(p.getX() + 26 - 39, p.getY() - 8, 39, 21);
        g.fillRect(p.getX() + 20 - 43, p.getY() - 2, 43, 9);
        
        g.setColor(p.getTrail());
        g.drawRect(p.getX() + 5 - 25, p.getY() - 2, 25, 1);
        g.drawRect(p.getX() + 5 - 25, p.getY() + 5, 25, 1);
        
        g.setColor(p.getSecondaryColor());
        g.fillRect(p.getX() + 21 - 5, p.getY() - 5, 5, 15);
        g.fillRect(p.getX() + 21 - 25, p.getY() - 5, 25, 1);
        g.fillRect(p.getX() + 21 - 25, p.getY() + 10, 25, 1);
        
        
        return g;
    }
    
    public Graphics facingLeft(Player p , Graphics g)
    {
        g.setColor(p.getSecondaryColor());
        g.fillRect(p.getX() - 26, p.getY() - 11, 15, 27);
        g.fillRect(p.getX() - 21, p.getY() - 13, 5, 31);
        
        g.fillRect(p.getX() - 4, p.getY() - 11, 15, 27);
        g.fillRect(p.getX() + 1, p.getY() - 13, 5, 31);
        
        g.setColor(p.getBase());
        g.fillRect(p.getX() - 30, p.getY() - 4, 39, 13);
        g.fillRect(p.getX() - 26, p.getY() - 8, 39, 21);
        g.fillRect(p.getX() - 20, p.getY() - 2, 43, 9);
        
        g.setColor(p.getTrail());
        g.drawRect(p.getX() - 5, p.getY() - 2, 25, 1);
        g.drawRect(p.getX() - 5, p.getY() + 5, 25, 1);
        
        g.setColor(p.getSecondaryColor());
        g.fillRect(p.getX() - 21, p.getY() - 5, 5, 15);
        g.fillRect(p.getX() - 21, p.getY() - 5, 25, 1);
        g.fillRect(p.getX() - 21, p.getY() + 10, 25, 1);
        
        
        return g;
    }
    
    public Graphics facingUp(Player p , Graphics g)
    {
        g.setColor(p.getSecondaryColor());
        g.fillRect(p.getX() - 11, p.getY() - 26, 27, 15);
        g.fillRect(p.getX() - 13, p.getY() - 21, 31, 5);
        
        g.fillRect(p.getX() - 11, p.getY() - 4, 27, 15);
        g.fillRect(p.getX() - 13, p.getY() + 1, 31, 5);
        
        g.setColor(p.getBase());
        g.fillRect(p.getX() - 4, p.getY() - 30, 13, 39);
        g.fillRect(p.getX() - 8, p.getY() - 26, 21, 39);
        g.fillRect(p.getX() - 2, p.getY() - 20, 9, 43);
        
        g.setColor(p.getTrail());
        g.drawRect(p.getX() - 2, p.getY() - 5, 1, 25);
        g.drawRect(p.getX() + 5, p.getY() - 5, 1, 25);
        
        g.setColor(p.getSecondaryColor());
        g.fillRect(p.getX() - 5, p.getY() - 21, 15, 5);
        g.fillRect(p.getX() - 5, p.getY() - 21, 1, 25);
        g.fillRect(p.getX() + 10, p.getY() - 21, 1, 25);
        
        
        return g;
    }
    
    public Graphics facingDown(Player p , Graphics g)
    {
        g.setColor(p.getSecondaryColor());
        g.fillRect(p.getX() - 11, p.getY() + 26 - 15, 27, 15);
        g.fillRect(p.getX() - 13, p.getY() + 21 - 5, 31, 5);
        
        g.fillRect(p.getX() - 11, p.getY() + 4 - 15, 27, 15);
        g.fillRect(p.getX() - 13, p.getY() - 1 - 5, 31, 5);
        
        g.setColor(p.getBase());
        g.fillRect(p.getX() - 4, p.getY() + 30 - 39, 13, 39);
        g.fillRect(p.getX() - 8, p.getY() + 26 - 39, 21, 39);
        g.fillRect(p.getX() - 2, p.getY() + 20 - 43, 9, 43);
        
        g.setColor(p.getTrail());
        g.drawRect(p.getX() - 2, p.getY() + 5 - 25, 1, 25);
        g.drawRect(p.getX() + 5, p.getY() + 5 - 25, 1, 25);
        
        g.setColor(p.getSecondaryColor());
        g.fillRect(p.getX() - 5, p.getY() + 21 - 5, 15, 5);
        g.fillRect(p.getX() - 5, p.getY() + 21 - 25, 1, 25);
        g.fillRect(p.getX() + 10, p.getY() + 21 - 25, 1, 25);
        
        
        return g;
    }
    
    public Graphics paintPlayer(Graphics g, Player p)
    {
        if(p.getDX() == speed)
        return facingRight(p, g);
        else if(p.getDX() == -speed)
        return facingLeft(p, g);
        else if(p.getDY() == speed)
        return facingDown(p, g);
        else return facingUp(p, g);
    }
    
}