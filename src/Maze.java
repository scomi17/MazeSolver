import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Maze extends Panel implements ActionListener{
    private final int WIDTH_PANEL = 1000;
    private final int HEIGHT_PANEL = 800;
    int[][] maze = new int[60][60];
    //need to add buttons
    JButton createMaze = new JButton("Create Maze");
    JButton solve = new JButton("Solve");

    Maze(){
        this.setPreferredSize(new Dimension(WIDTH_PANEL, HEIGHT_PANEL));
        this.setFocusable(true);
        this.setBackground(new Color(100, 150, 230));


    }

    @Override
    public void paintComponents(Graphics g){
        super.paintComponents(g);
        paint(g);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(200, 100, 600, 600);

        //Creates the grid for the maze cubes
        g2d.setColor(Color.BLACK);
        for(int i = 20; i <= 80; i++){
            g2d.drawLine(i*10, 100, i*10, 700);
        }
        for(int i = 10; i <= 70; i++){
            g2d.drawLine(200, i*10, 800, i*10);
        }
        g2d.drawString("MAZE SOLVER", 450, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void create_maze(){
        Random rand = new Random();
        //Draws the maze walls
        for(int y = 0; y <= 60; y++){
            for(int x = 0; x <= 60; x++){
                int num = rand.nextInt() %2;
                maze[y][x] = num;
            }
        }
    }
}
