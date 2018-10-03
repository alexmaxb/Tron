import java.awt.Color;

public class Player
{
    private int x;
    private int y;
    private Color trail; // color that the trail will be when it is created
    private String type; // either actual player or AI
    private int directionX;
    private int directionY;
    private int tillTurn; // time until the player will turn if it is an AI
    private Color base;
    private Color secondaryC;
    
    
    public Player(int primaryX, int primaryY, int r, int g, int b, int dX, int dY)
    {
        x = primaryX;
        y = primaryY;
        trail = new Color(r, g, b);
        directionX = dX;
        directionY = dY;
        type = "";
        base = Color.BLUE;
        secondaryC = Color.BLUE;
    }
    
    public void move()
    {
        setX(x + directionX);
        setY(y + directionY);
    }
    
    
    //accessors
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getDX()
    {
        return directionX;
    }
    
    public int getDY()
    {
        return directionY;
    }
    
    public Color getTrail()
    {
        return trail;
    }
    
    public String getType()
    {
        return type;
    }
    
    public int getTurn()
    {
        return tillTurn;
    }
    
    //reset the direction in which the player is moving
    public void setDX(int newXMove)
    {
        directionX = newXMove;
    }
    
    public void setDY(int newYMove)
    {
        directionY = newYMove;
    }
    
    public void setType(String t)
    {
        type = t;
    }
    
    public void setX(int x2)
    {
        x = x2;
    }
    
    public void setY(int y2)
    {
        y = y2;
    }
    
    public void setTime(int time)
    {
        tillTurn = time;
    }
    
    public void updateTime()
    {
        tillTurn -= 1;
    }
    
    public void setTrail(Color c)
    {
        trail = c;
    }
    
    public void setBase(Color c)
    {
        base = c;
    }
    
    public void setSecondary(Color c)
    {
        secondaryC = c;
    }
    
    public Color getBase()
    {
        return base;
    }
    
    public Color getSecondaryColor()
    {
        return secondaryC;
    }
}