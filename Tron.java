import java.awt.event.*;
import java.awt.Color;


public class Tron implements MouseListener
{
    Screen  screen;

    
    
    public Tron()
    {
         screen = new Screen();
         screen.addMouseListener(this);
        SoundEffect.init();
        run();
    }
    
    
    public void mouseExited(MouseEvent e)
    {
    }
    
    public void mouseEntered(MouseEvent e)
    {
    }
    
    public void mouseReleased(MouseEvent e)
    {
    }
    
    public void mousePressed(MouseEvent e)
    {
    }
    
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        if(screen.getState() == 125)
        {
            for(int xc = 100; xc <= 320; xc += 110)
            {
                for(int yc = 300; yc < 720; yc+=60)
                {
                    int color = (yc - 300) / 60;
                    int lane = (xc - 100) / 110;
                    Color setTo;
                    if(
                    x >= xc
                    &&
                    x <= xc + 100
                    &&
                    y >= yc
                    &&
                    y <= yc + 50
                    )
                    {
                        SoundEffect.BUTTON.play();
            if(color == 0)
            setTo = Color.RED;
            else if(color == 1)
            setTo = new Color(250,105,33);
            else if(color == 2)
            setTo = Color.YELLOW;
            else if(color == 3)
            setTo = new Color(95,250,0);
            else if(color == 4)
            setTo = new Color(46,203,255);
            else if(color == 5)
            setTo = new Color(95,250,253);
            else if(color == 6)
            setTo = new Color(249,52,160);
            else setTo = Color.RED;
            
            if(lane == 0)
            {
                screen.p2.setBase(setTo);
                //screen.defaultP2 = setTo;
            }
            else if(lane == 1)
            {
                screen.p2.setSecondary(setTo);
                //screen.defaultP2 = setTo;
            }
            else if(lane == 2)
            {
                screen.p2.setTrail(setTo);
                screen.defaultP2 = setTo;
            }
        }
                }
            }
            
            
            for(int xc = screen.frame.getWidth() - 400; xc <= 1040 ; xc += 110)
            {
                    for(int yc = 300; yc < 720; yc+=60)
                    {
                    int color = (yc - 300) / 60;
                    int lane = (xc - (screen.frame.getWidth() - 400)) / 110;
                    Color setTo;
                    if(
                    x >= xc
                    &&
                    x <= xc + 100
                    &&
                    y >= yc
                    &&
                    y <= yc + 50
                    )
                    {
                        SoundEffect.BUTTON.play();
            if(color == 0)
            setTo = Color.RED;
            else if(color == 1)
            setTo = new Color(250,105,33);
            else if(color == 2)
            setTo = Color.YELLOW;
            else if(color == 3)
            setTo = new Color(95,250,0);
            else if(color == 4)
            setTo = new Color(46,203,255);
            else if(color == 5)
            setTo = new Color(95,250,253);
            else if(color == 6)
            setTo = new Color(249,52,160);
            else setTo = Color.RED;
            
            if(lane == 0)
            {
                screen.p1.setBase(setTo);
                //screen.defaultP1 = setTo;
            }
            else if(lane == 1)
            {
                screen.p1.setSecondary(setTo);
                //screen.defaultP1 = setTo;
            }
            else if(lane == 2)
            {
                screen.p1.setTrail(setTo);
                screen.defaultP1 = setTo;
            }
        }
                }
            }
        }
        
        
        
        if( screen.getState() != 100 &&  screen.getState() != 75 &&  screen.getState() != 50 && screen.getState() != 125)
        {
        if(
        x >= 10
        &&
        x<=  screen.frame.getWidth() / 2
        &&
        y >=  screen.frame.getHeight() - 90
        &&
        y <=  screen.frame.getHeight() - 10
        )
        if( screen.p2.getType().equals("AI"))
        {
            if( screen.soundOn) SoundEffect.BUTTON.play();
             screen.p2.setType("player");
        }
        else {
            if( screen.soundOn) SoundEffect.BUTTON.play();
             screen.p2.setType("AI");
        }
        else if(
        x >=  screen.frame.getWidth() / 2
        &&
        x<=  screen.frame.getWidth() - 10
        &&
        y >=  screen.frame.getHeight() - 90
        &&
        y <=  screen.frame.getHeight() - 10
        )
        if( screen.p1.getType().equals("AI"))
        {
            if( screen.soundOn) SoundEffect.BUTTON.play();
             screen.p1.setType("player");
        }
        else {
            if( screen.soundOn) SoundEffect.BUTTON.play();
             screen.p1.setType("AI");
        }
        }
        if( screen.getState() == 100)
        {
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 - 25
            &&
            y <=  screen.frame.getHeight() / 2 + 25
            )
            {
                if( screen.soundOn) SoundEffect.BUTTON.play();
                 screen.State = 0;
                 screen.p1Trail.clear();
                 Color previousBaseP1 = screen.p1.getBase();
                 Color previousBaseP2 = screen.p2.getBase();
                 Color previousSP1 = screen.p1.getSecondaryColor();
                 Color previousSP2 = screen.p2.getSecondaryColor();
                 screen.p1 = 
                    new Player( 
                        screen.frame.getWidth() - 10,
                        20 * 33, 
                        screen.defaultP1.getRed(), 
                        screen.defaultP1.getGreen(), 
                        screen.defaultP1.getBlue(), 
                        0,  
                        -screen.speed);
                 screen.p2 = new Player( 10,  10, screen.defaultP2.getRed(), screen.defaultP2.getGreen(), screen.defaultP2.getBlue(), 0, screen.speed);
                 screen.p2Trail.clear();
                 screen.p1.setBase(previousBaseP1);
                 screen.p1.setSecondary(previousSP1);
                 screen.p2.setBase(previousBaseP2);
                 screen.p2.setSecondary(previousSP2);
            }
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 + 35
            &&
            y <=  screen.frame.getHeight() / 2 + 85
            )
            {
                if( screen.soundOn) SoundEffect.BUTTON.play();
                 screen.State = 75;
            }
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 + 95
            &&
            y <=  screen.frame.getHeight() / 2 + 145
            )
            {
                if( screen.soundOn) SoundEffect.BUTTON.play();
                 screen.State = 50;
            }
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 + 155
            &&
            y <=  screen.frame.getHeight() / 2 + 205
            )
            {
                if( screen.soundOn) SoundEffect.BUTTON.play();
                screen.State = 125;
            }
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 + 215
            &&
            y <=  screen.frame.getHeight() / 2 + 265
            )
            {
                if( screen.soundOn) SoundEffect.BUTTON.play();
                System.exit(0);
            }
            
        }
        
        if( screen.getState() == 75)
        {
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 + 215
            &&
            y <=  screen.frame.getHeight() / 2 + 265
            )
            {
                 screen.defaultColors = ! screen.defaultColors;
                 screen.buttonColor = new Color( screen.random(255),  screen.random(255),  screen.random(255));
                 screen.buttonColor1 = new Color( screen.random(255),  screen.random(255),  screen.random(255));
                 screen.buttonColor2 = new Color( screen.random(255),  screen.random(255),  screen.random(255));
                 screen.buttonColor3 = new Color( screen.random(255),  screen.random(255),  screen.random(255));
                 screen.buttonColor4 = new Color( screen.random(255),  screen.random(255),  screen.random(255));
                 screen.createMenu();
                 screen.repaint();
                
                if( screen.soundOn) SoundEffect.BUTTON.play();
            }
            
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 + 95
            &&
            y <=  screen.frame.getHeight() / 2 + 145
            )
            {
                 screen.soundOn = ! screen.soundOn;
                 screen.repaint();
                
                if( screen.soundOn) SoundEffect.BUTTON.play();
            }
            
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 + 155
            &&
            y <=  screen.frame.getHeight() / 2 + 205
            )
            {
                 screen.crazyMenu = ! screen.crazyMenu;
                 screen.createMenu();
                 screen.repaint();
                
                if( screen.soundOn) SoundEffect.BUTTON.play();
            }
            
            if(
            x >=  screen.frame.getWidth() / 2 - 100
            &&
            x<=  screen.frame.getWidth() / 2 + 100
            &&
            y >=  screen.frame.getHeight() / 2 + 275
            &&
            y <=  screen.frame.getHeight() / 2 + 325
            )
            {
                 screen.p1Score = 0;
                 screen.p2Score = 0;
                 screen.repaint();
                
                if( screen.soundOn) SoundEffect.BUTTON.play();
            }
        }
        
         screen.repaint();
        //sound.playSound("Uzi.wav");
    }
    
    public void run()
    {
        for(int time = 0; ; time++)
        {
            if( screen.getState() == 100 ||  screen.getState() == 50 ||  screen.getState() == 75 || screen.getState() == 125)
            {
                try{
                for(int i = 0; i <  screen.p1Trail.size(); i++)
                {
                    if( screen.p1Trail.get(i).getX() >  screen.frame.getWidth())
                    {
                         screen.p1Trail.get(i).setX(0);
                    }
                    else 
                    if( screen.p1Trail.get(i).getY() >=  screen.frame.getHeight() ||  screen.p1Trail.get(i).getY() <= 0)
                    {
                         screen.p1Trail.get(i).setSpeedY(- screen.p1Trail.get(i).getSpeedY());
                         screen.p1Trail.get(i).setX( screen.p1Trail.get(i).getX() +  screen.p1Trail.get(i).getSpeed());
                         screen.p1Trail.get(i).setY( screen.p1Trail.get(i).getY() +  screen.p1Trail.get(i).getSpeedY());
                    }
                    else
                    {
                         screen.p1Trail.get(i).setX( screen.p1Trail.get(i).getX() +  screen.p1Trail.get(i).getSpeed());
                         screen.p1Trail.get(i).setY( screen.p1Trail.get(i).getY() +  screen.p1Trail.get(i).getSpeedY());
                    }
                }
                
                for(int i = 0; i <  screen.p2Trail.size(); i++)
                {
                    if( screen.p2Trail.get(i).getX() < 0)
                    {
                         screen.p2Trail.get(i).setX( screen.frame.getWidth());
                    }
                    else 
                    if( screen.p2Trail.get(i).getY() >=  screen.frame.getHeight() ||  screen.p2Trail.get(i).getY() <= 0)
                    {
                         screen.p2Trail.get(i).setSpeedY(- screen.p2Trail.get(i).getSpeedY());
                         screen.p2Trail.get(i).setX( screen.p2Trail.get(i).getX() +  screen.p2Trail.get(i).getSpeed());
                         screen.p2Trail.get(i).setY( screen.p2Trail.get(i).getY() +  screen.p2Trail.get(i).getSpeedY());
                    }
                    else
                    {
                         screen.p2Trail.get(i).setX( screen.p2Trail.get(i).getX() +  screen.p2Trail.get(i).getSpeed());
                         screen.p2Trail.get(i).setY( screen.p2Trail.get(i).getY() +  screen.p2Trail.get(i).getSpeedY());
                    }
                }
                Thread.sleep(5);
                 screen.repaint();
                }
                catch(InterruptedException ie)
                {}
            }
            //end of menu thread
            
            if( screen.getState() != 100 &&  screen.getState() != 75 &&  screen.getState() != 50 && screen.getState() != 125)
            {
            try
            {
                for(int i = 0; i < screen.p1Trail.size(); i++)
                {
                    if(screen.p1Trail.get(i).getLife() <= 0)
                    {
                        screen.p1Trail.remove(i);
                        i--;
                    }
                    else screen.p1Trail.get(i).updatelife();
                }
                
                for(int i = 0; i < screen.p2Trail.size(); i++)
                {
                    if(screen.p2Trail.get(i).getLife() <= 0)
                    {
                        screen.p2Trail.remove(i);
                        i--;
                    }
                    else screen.p2Trail.get(i).updatelife();
                }
                
                if( screen.getState() == 1)
                {
                    
                    if( screen.p2.getX() >=  screen.p1.getX() -  screen.speed//2
                        &&
                         screen.p2.getX() <=  screen.p1.getX() +  screen.speed//2
                        &&
                         screen.p2.getY() >=  screen.p1.getY() -  screen.speed//2
                        &&
                         screen.p2.getY() <=  screen.p1.getY() +  screen.speed//2
                        )
                        {
                             screen.State = 5;
                             screen.particles.clear();
                            screen.particles.clear(); createExplosion( screen.p2.getX(),  screen.p2.getY(), screen.p2.getTrail());
                            createExplosion(screen.p1.getX(), screen.p1.getY(), screen.p1.getTrail());
                            explosionThread( screen.p2.getX(),  screen.p2.getY(), Color.WHITE);
                            
                        }
                            
                        
                    if( screen.p1.getX() >=  screen.p2.getX() -  screen.speed//2
                        &&
                         screen.p1.getX() <=  screen.p2.getX() +  screen.speed//2
                        &&
                         screen.p1.getY() >=  screen.p2.getY() -  screen.speed//2
                        &&
                         screen.p1.getY() <=  screen.p2.getY() +  screen.speed//2
                        )
                        {
                             screen.State = 5;
                             screen.particles.clear();
                            screen.particles.clear(); createExplosion( screen.p2.getX(),  screen.p2.getY(), Color.WHITE);
                            explosionThread( screen.p2.getX(),  screen.p2.getY(), Color.WHITE);
                            
                        }
                        
                        
                    for(int i = 0; i <  screen.p1Trail.size(); i++)
                    {
                        
                        
                        
                        if(
                         screen.State == 1
                        &&
                         screen.p1.getX() >=  screen.p1Trail.get(i).getX() 
                        &&
                         screen.p1.getX() <=  screen.p1Trail.get(i).getX() +  screen.speed
                        &&
                         screen.p1.getY() >=  screen.p1Trail.get(i).getY()
                        &&
                         screen.p1.getY() <=  screen.p1Trail.get(i).getY() +  screen.speed
                        )
                        {
                             screen.State = 3;
                             screen.particles.clear();
                             screen.repaint();
                            screen.particles.clear(); createExplosion( screen.p1.getX(),  screen.p1.getY(),  screen.p1.getTrail());
                            explosionThread( screen.p1.getX(),  screen.p1.getY(),  screen.p1.getTrail());
                            
                            ;
                            
                             screen.p2Score+=1;
                            
                             screen.repaint();
                        }
                        
                        if(
                         screen.State == 1
                        &&
                         screen.p2.getX() >=  screen.p1Trail.get(i).getX() 
                        &&
                         screen.p2.getX() <=  screen.p1Trail.get(i).getX() +  screen.speed
                        &&
                         screen.p2.getY() >=  screen.p1Trail.get(i).getY()
                        &&
                         screen.p2.getY() <=  screen.p1Trail.get(i).getY() +  screen.speed
                        )
                        {
                             screen.State = 4;
                             screen.particles.clear();
                             screen.repaint();
                            screen.particles.clear(); createExplosion( screen.p2.getX(),  screen.p2.getY(),  screen.p2.getTrail());
                            explosionThread( screen.p2.getX(),  screen.p2.getY(),  screen.p2.getTrail());
                            
                            ;
                            
                             screen.p1Score+=1;
                            
                             screen.repaint();
                        }
                    }
                    
                    for(int i = 0; i <  screen.p2Trail.size(); i++)
                    {
                        if(
                         screen.State == 1
                        &&
                         screen.p1.getX() >=  screen.p2Trail.get(i).getX() 
                        &&
                         screen.p1.getX() <=  screen.p2Trail.get(i).getX() +  screen.speed
                        &&
                         screen.p1.getY() >=  screen.p2Trail.get(i).getY()
                        &&
                         screen.p1.getY() <=  screen.p2Trail.get(i).getY() +  screen.speed
                        )
                        {
                             screen.State = 3;
                             screen.particles.clear();
                             screen.repaint();
                            screen.particles.clear(); createExplosion( screen.p1.getX(),  screen.p1.getY(),  screen.p1.getTrail());
                            explosionThread( screen.p1.getX(),  screen.p1.getY(),  screen.p1.getTrail());
                            
                            ;
                            
                             screen.p2Score+=1;
                            
                             screen.repaint();
                        }
                        
                        if(
                         screen.State == 1
                        &&
                         screen.p2.getX() >=  screen.p2Trail.get(i).getX() 
                        &&
                         screen.p2.getX() <=  screen.p2Trail.get(i).getX() +  screen.speed
                        &&
                         screen.p2.getY() >=  screen.p2Trail.get(i).getY()
                        &&
                         screen.p2.getY() <=  screen.p2Trail.get(i).getY() +  screen.speed
                        )
                        {
                             screen.State = 4;
                             screen.particles.clear();
                             screen.repaint();
                            screen.particles.clear(); createExplosion( screen.p2.getX(),  screen.p2.getY(),  screen.p2.getTrail());
                            explosionThread( screen.p2.getX(),  screen.p2.getY(),  screen.p2.getTrail());
                            
                            ;
                            
                             screen.p1Score+=1;
                            
                             screen.repaint();
                        }
                    }
                  
                    
                    
                    
                    if(
                         screen.p2.getX() >=  screen.frame.getWidth() 
                        ||
                         screen.p2.getX() <= 0 
                        ||
                         screen.p2.getY() >=  screen.frame.getHeight() - 100
                        ||
                         screen.p2.getY() <= 0 
                        &&
                         screen.getState() == 1
                        )
                        {
                             screen.State = 4;
                             screen.particles.clear();
                             screen.repaint();
                            screen.particles.clear(); createExplosion( screen.p2.getX(),  screen.p2.getY(),  screen.p2.getTrail());
                            explosionThread( screen.p2.getX(),  screen.p2.getY(),  screen.p2.getTrail());
                            
                            ;
                            
                             screen.p1Score+=1;
                            
                        }
                        
                    if(
                         screen.p1.getX() >=  screen.frame.getWidth() 
                        ||
                         screen.p1.getX() <= 0 
                        ||
                         screen.p1.getY() >=  screen.frame.getHeight() - 100
                        ||
                         screen.p1.getY() <= 0 
                        &&
                         screen.getState() == 1
                        )
                        {
                             screen.State = 3;
                             screen.particles.clear();
                             screen.repaint();
                            screen.particles.clear(); createExplosion( screen.p1.getX(),  screen.p1.getY(),  screen.p1.getTrail());
                            explosionThread( screen.p1.getX(),  screen.p1.getY(),  screen.p1.getTrail());
                            
                            ;
                            
                             screen.p2Score+=1;
                            
                        }
                    
                    if( screen.p1.getType().equals("AI"))
                    {
                         screen.p1 = AI( screen.p1);
                    }
                    
                    if( screen.p2.getType().equals("AI"))
                    {
                         screen.p2 = AI( screen.p2);
                    }
                        
                        
                        
                        
                     screen.p1Trail.add(new Trail( screen.p1.getX() -  screen.p1.getDX(),  screen.p1.getY() -  screen.p1.getDY(),  screen.p1.getTrail(), 100));
                     screen.p2Trail.add(new Trail( screen.p2.getX() -  screen.p2.getDX(),  screen.p2.getY() -  screen.p2.getDY(),  screen.p2.getTrail(), 100));
                    
                    
                     screen.p1.move();
                     screen.p2.move();
                     screen.repaint();
                    Thread.sleep(18);
                }
                
                
            }
            catch(InterruptedException ie)
            {
                
            }
        }
        }
    }
    
    
    
    
    public Player AI(Player player)
    {
        String direction;
        boolean nextUp; //isValid(player.getX() + player.getDX(), player.getY() + player.getDY());
        boolean nextRight;
        boolean nextLeft;
        boolean nextDown;
        
        nextLeft = isValid(player.getX() -  screen.speed, player.getY(), player) && isValid(player.getX() -  screen.speed * 2, player.getY(), player);//left
        nextRight = isValid(player.getX() +  screen.speed, player.getY(), player) && isValid(player.getX() +  screen.speed * 2, player.getY(), player);//right
        nextUp = isValid(player.getX(), player.getY() -  screen.speed, player) && isValid(player.getX(), player.getY() -  screen.speed * 2, player);//up
        nextDown = isValid(player.getX(), player.getY() +  screen.speed, player) && isValid(player.getX(), player.getY() +  screen.speed * 2, player);//down*/
        
        
        if(player.getDX() ==  screen.speed)
        {
            direction = "right";
            //nextRight = isValid(player.getX() +  screen.speed, player.getY(), player) 
            //&& isValid(player.getX() +  screen.speed * 2, player.getY(), player);//right
        }
        else if(player.getDX() == - screen.speed)
        {
            direction = "left";
            //nextLeft = isValid(player.getX() -  screen.speed, player.getY(), player) 
            //&& isValid(player.getX() -  screen.speed * 2, player.getY(), player);//left
        }
        else if(player.getDY() ==  screen.speed)
        {
            direction = "down";
            //nextDown = isValid(player.getX(), player.getY() +  screen.speed, player) 
            //&& isValid(player.getX(), player.getY() +  screen.speed * 2, player);//down*/
        }
        else if(player.getDY() == - screen.speed)
        
        {
            direction = "up";
            //nextUp = isValid(player.getX(), player.getY() -  screen.speed, player) 
            //&& isValid(player.getX(), player.getY() -  screen.speed * 2, player);//up
        }
        else {
            direction = "";
        }
        
        
        
        
        if(player.getTurn() == 0)
        {
            if(direction.equals("up"))
            {
                if(nextRight && nextLeft)
                {
                    //if(Math.random() * 10 >= 5)
                    if(Math.random() * 10 >= Math.random() * 10)
                    playerTurn(player,  screen.speed, 0);
                    else playerTurn(player, - screen.speed, 0);
                }
                else if(nextRight)
                {
                    playerTurn(player,  screen.speed, 0);
                }
                else if(nextLeft)
                {
                    playerTurn(player, - screen.speed, 0);
                }
            }
            else if(direction.equals("down"))
            {
                if(nextRight && nextLeft)
                {
                    //if(Math.random() * 10 >= 5)
                    if(Math.random() * 10 >= Math.random() * 10)
                    playerTurn(player,  screen.speed, 0);
                    else playerTurn(player, - screen.speed, 0);
                }
                else if(nextRight)
                {
                    playerTurn(player,  screen.speed, 0);
                }
                else if(nextLeft)
                {
                    playerTurn(player, - screen.speed, 0);
                }
            }
            else if(direction.equals("right"))
            {
                if(nextUp && nextDown)
                {
                    //if(Math.random() * 10 >= 5)
                    if(Math.random() * 10 >= Math.random() * 10)
                    playerTurn(player, 0, - screen.speed);
                    else playerTurn(player, 0,  screen.speed);
                }
                else if(nextUp)
                {
                    playerTurn(player, 0, - screen.speed);
                }
                else if(nextDown)
                {
                    playerTurn(player, 0,  screen.speed);
                }
            }
            else if(direction.equals("left"))
            {
                if(nextUp && nextDown)
                {
                    //if(Math.random() * 10 >= 5)
                    if(Math.random() * 10 >= Math.random() * 10)
                    playerTurn(player, 0, - screen.speed);
                    else playerTurn(player, 0,  screen.speed);
                }
                else if(nextUp)
                {
                    playerTurn(player, 0, - screen.speed);
                }
                else if(nextDown)
                {
                    playerTurn(player, 0,  screen.speed);
                }
            }
            //player.setTime((int)(Math.random() * 100) + 10);
        }
        
        else {
            player.updateTime();
            
        
        
        
        if(direction.equals("up"))
        {
            if(!nextUp)
            {
                if(nextRight && nextLeft)
                {
                    if((int)(Math.random() * 10) >= 5)
                    {
                        player = playerTurn(player,  screen.speed, 0);
                    }
                    else {
                        player = playerTurn(player, - screen.speed, 0);
                    }
                }
                else if(nextRight && !nextLeft)
                {
                    player = playerTurn(player,  screen.speed, 0);
                }
                else if(!nextRight && nextLeft)
                {
                    player = playerTurn(player, - screen.speed, 0);
                }
                
            }
        }
        
        if(direction.equals("down"))
        {
            if(!nextDown)
            {
                if(nextRight && nextLeft)
                {
                    if((int)(Math.random() * 10) >= 5)
                    {
                        player = playerTurn(player,  screen.speed, 0);
                    }
                    else {
                        player = playerTurn(player, - screen.speed, 0);
                    }
                }
                else if(!nextRight && nextLeft)
                {
                    player = playerTurn(player, - screen.speed, 0);
                }
                else if(nextRight && !nextLeft)
                {
                    player = playerTurn(player,  screen.speed, 0);
                }
                
            }
        }
        
        if(direction.equals("right"))
        {
            if(!nextRight)
            {
                if(nextUp && nextDown)
                {
                    if((int)(Math.random() * 10) >= 5)
                    {
                        player = playerTurn(player, 0,  screen.speed);
                    }
                    else {
                        player = playerTurn(player, 0, - screen.speed);
                    }
                }
                else if(nextUp && !nextDown)
                {
                    player = playerTurn(player, 0, - screen.speed);
                }
                else if(!nextUp && nextDown)
                {
                    player = playerTurn(player, 0,  screen.speed);
                }
                
            }
        }
        
        if(direction.equals("left"))
        {
            if(!nextLeft)
            {
                if(nextUp && nextDown)
                {
                    if((int)(Math.random() * 10) >= 5)
                    {
                        player = playerTurn(player, 0,  screen.speed);
                    }
                    else {
                        player = playerTurn(player, 0, - screen.speed);
                    }
                }
                else if(nextUp && !nextDown)
                {
                    player = playerTurn(player, 0, - screen.speed);
                }
                else if(!nextUp && nextDown)
                {
                    player = playerTurn(player, 0,  screen.speed);
                }
                
            }
        }
    }
        //player.move();
        return player;
        
        
    }
    
    private boolean isValid(int x, int y, Player p)
    {
        int valid = 0;
        
                    for(int i = 0; i <  screen.p1Trail.size(); i++)
                    {
                        
                        
                        
                        if(
                        x >=  screen.p1Trail.get(i).getX()// -  screen.speed/2
                        &&
                        x <=  screen.p1Trail.get(i).getX() +  screen.speed //+  screen.speed/2
                        &&
                        y >=  screen.p1Trail.get(i).getY() -  screen.speed//2
                        &&
                        y <=  screen.p1Trail.get(i).getY() +  screen.speed// +  screen.speed/2
                        
                        )
                        {
                            valid = 1;
                        }
                        
                        
                    }
                    
                    
                    for(int z = 0; z <  screen.p2Trail.size(); z++)
                    {
                        
                        
                        if(
                        x >=  screen.p2Trail.get(z).getX()// -  screen.speed/2
                        &&
                        x <=  screen.p2Trail.get(z).getX() +  screen.speed// +  screen.speed/2
                        &&
                        y >=  screen.p2Trail.get(z).getY() -  screen.speed//2
                        &&
                        y <=  screen.p2Trail.get(z).getY() +  screen.speed// +  screen.speed/2
                        
                        )
                        {
                            valid = 1;
                        }
                    }
                    
                    
                        if(
                        x >=  screen.frame.getWidth() -  screen.speed 
                        ||
                        x <=  screen.speed 
                        ||
                        y >=  screen.frame.getHeight() - 110 -  screen.speed 
                        ||
                        y <=  screen.speed 
                        )
                        {
                            valid = 1;
                        }
                        
                        
                        
                        
        if(valid == 0)
        return true;
        else return false;
    }
    
    public Player playerTurn(Player p, int dX, int dY)
    {
                    //p.setX(p.getX() - p.getDX());
                    //p.setY(p.getY() - p.getDY());
                    if(p ==  screen.p1)
                     screen.p1Trail.add(new Trail(p.getX() - p.getDX(), p.getY() - p.getDY(), p.getTrail(), 250));
                    else  screen.p2Trail.add(new Trail(p.getX() - p.getDX(), p.getY() - p.getDY(), p.getTrail(), 250));
                    p.setDY(dY);
                    p.setDX(dX);
                    //p.move();
                    p.move();
                    p.setTime((int)(Math.random() * 100) + 30);
                    return p;
    }
    
    public static void main(String args[])
    {
        Tron start = new Tron();
    }
    
    public void createExplosion(int x, int y, Color c)
    {
         //screen.particles.clear();
        int dX;
        int dY;
        for(int i = 0; i < 360; i++)
        {
            
            dY = (int)(Math.sin(i) * Math.random() * 100 + 5);
            dX = (int)(Math.cos(i) * Math.random() * 100 + 5);
             screen.particles.add(new Trail(x+dX,y+dY, c,250));
             screen.particles.get(i).setSpeed(dX);
             screen.particles.get(i).setSpeedY(dY);
             screen.particles.get(i).setLife(50);
            
            dY = (int)(Math.sin(i) * Math.random() * 100 + 5);
            dX = (int)(Math.cos(i) * Math.random() * 100 + 5);
             screen.particles.add(new Trail(x+dX,y+dY, c,250));
             screen.particles.get(i).setSpeed(dX/2);
             screen.particles.get(i).setSpeedY(dY/2);
             screen.particles.get(i).setLife(50);
            
            dY = (int)(Math.sin(i) * Math.random() * 100);
            dX = (int)(Math.cos(i) * Math.random() * 100);
             screen.particles.add(new Trail(x+dX,y+dY, c,250));
             screen.particles.get(i+1).setSpeed(dX);
             screen.particles.get(i+1).setSpeedY(dY);
             screen.particles.get(i+1).setLife(50);
            
            dY = (int)(Math.sin(i) * Math.random() * 100);
            dX = (int)(Math.cos(i) * Math.random() * 100);
             screen.particles.add(new Trail(x+dX,y+dY, c,250));
             screen.particles.get(i+1).setSpeed(dX/2);
             screen.particles.get(i+1).setSpeedY(dY/2);
             screen.particles.get(i+1).setLife(50);
            
            dY = (int)(Math.sin(i) * Math.random() * 100 - 5);
            dX = (int)(Math.cos(i) * Math.random() * 100 - 5);
             screen.particles.add(new Trail(x+dX,y+dY, c,250));
             screen.particles.get(i+2).setSpeed(dX);
             screen.particles.get(i+2).setSpeedY(dY);
             screen.particles.get(i+2).setLife(50);
            
            dY = (int)(Math.sin(i) * Math.random() * 100 - 5);
            dX = (int)(Math.cos(i) * Math.random() * 100 - 5);
             screen.particles.add(new Trail(x+dX,y+dY, c,250));
             screen.particles.get(i+2).setSpeed(dX/2);
             screen.particles.get(i+2).setSpeedY(dY/2);
             screen.particles.get(i+2).setLife(50);
        }
    }
    
    public void explosionThread(int x, int y, Color c)
    {
        SoundEffect.CRASH.play();
       while( screen.State >= 3 &&  screen.State <= 5)
       try{
           
        if( screen.State == 3 ||  screen.State == 4 ||  screen.State == 5)
                {
                    for(int i = 0; i <  screen.particles.size(); i++)
                    {
                         screen.particles.get(i).setX( screen.particles.get(i).getX() +  screen.particles.get(i).getSpeed());
                         screen.particles.get(i).setY( screen.particles.get(i).getY() +  screen.particles.get(i).getSpeedY());
                        if( screen.particles.get(i).getLife() == 0)
                         screen.particles.remove(i);
                        else
                        {
                             screen.particles.get(i).updatelife();
                        }
                        
                    }
                    //createExplosion(x,y,c);
                    Thread.sleep(20);
                     screen.repaint();
                }
            }
            catch(InterruptedException ie) {}
    }
    

}