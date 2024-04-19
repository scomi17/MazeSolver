import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Frame(){

        this.add(new Maze());
        this.setTitle("Maze Solver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

}
