import java.awt.Color;

public class Trail
{
    private int x;
    private int y;
    private Color trailColor;
    private int speed;
    private int speedY;
    private int life;
    
    public Trail(int setX, int setY, Color c, int l)
    {
        x = setX;
        y = setY;
        trailColor = c;
        life = l;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public Color getColor()
    {
        return trailColor;
    }
    
    public void setX(int x1)
    {
        x = x1;
    }
    
    public void setY(int y1)
    {
        y = y1;
    }
    
    public void setSpeed(int s)
    {
        speed = s;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public void setSpeedY(int s)
    {
        speedY = s;
    }
    
    public int getSpeedY()
    {
        return speedY;
    }
    
    public void updatelife()
    {
        life -= 1;
    }
    
    public void setLife(int l)
    {
        life = l;
    }
    
    public int getLife()
    {
        return life;
    }
    
}