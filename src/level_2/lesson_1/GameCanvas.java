package level_2.lesson_1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private final GameWindow gameWindow;
    private long lastFrameTime;

    public GameCanvas(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        lastFrameTime = System.nanoTime();
        setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        gameWindow.onDrowFrame(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    int getLeft(){ return 0;}
    int getRight(){ return getWidth() - 1;}
    int getTop(){ return 0;}
    int getBottom(){ return getHeight() - 1;}
}
