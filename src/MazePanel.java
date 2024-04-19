import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Maze extends JPanel implements ActionListener{
    private final int WIDTH_PANEL = 1000;
    private final int HEIGHT_PANEL = 750;
    int[][] maze = new int[60][60];
    private boolean gridDone = false;
    //need to add buttons
    JButton createMaze = new JButton("Create Maze");
    JButton solve = new JButton("Solve");
    Color bg = new Color(100, 150, 230);

    Maze(){
        this.setPreferredSize(new Dimension(WIDTH_PANEL, HEIGHT_PANEL));
        this.setFocusable(true);

        createMaze();

        createMaze.addActionListener(e -> {
            clearMaze();
            createMaze();
            repaint();
        });

        this.add(createMaze);
        this.add(solve);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        paint(g);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bg);
        g2d.fillRect(0, 0, 1000, 800);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(200, 100, 600, 600);
        //Creates the grid for the maze cubes
        if(!gridDone) {
            g2d.setColor(Color.BLACK);
            for (int i = 20; i <= 80; i++) {
                g2d.drawLine(i * 10, 100, i * 10, 700);
            }
            for (int i = 10; i <= 70; i++) {
                g2d.drawLine(200, i * 10, 800, i * 10);
            }
            g2d.drawString("MAZE SOLVER", 450, 50);
        }
        for(int y = 0; y < 60; y++){
            for(int x = 0; x < 60; x++){
                if(maze[y][x] == 1){
                    g2d.setColor(Color.blue);
                    g2d.fillRect((x+20)*10, (y+10)*10, 10, 10);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void createMaze(){
        Random rand = new Random();
        //Draws the maze walls
        for(int y = 0; y < 60; y++){
            for(int x = 0; x < 60; x++){
                if(rand.nextInt() % 2 == 0) {
                    int num = Math.abs(rand.nextInt() % 2);
                    maze[y][x] = num;
                }
            }
        }
    }

    public void clearMaze(){
        maze = new int[60][60];
    }

}
