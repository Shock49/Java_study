package level_2.lesson_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {
    private final int HEIGHT = 600;
    private final int WIDTH = 850;
    private final int BUTTON_LEFT = 1;
    private final int BUTTON_RIGHT = 3;
    private Sprite[] sprites = new Sprite[10];
    private Background background;
    private int lengthObject;
    private float mouseX;
    private float mouseY;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }

    public float getMouseX() {
        return mouseX;
    }

    public float getMouseY() {
        return mouseY;
    }

    private GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Party");
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        background = new Background();
        //initGame();
        lengthObject = 0;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                mouseX = e.getX();
                mouseY = e.getY();
                if(e.getButton() == BUTTON_LEFT) {
                    addObject();
                }else if(e.getButton() == BUTTON_RIGHT){
                    delObject();
                }
            }
        });
        setVisible(true);
    }
    private void addObject(){
        sprites[lengthObject] = new Ball(this);
        lengthObject ++;
    }

    private void delObject(){
        if(lengthObject > 0){
            sprites[lengthObject - 1] = null;
            lengthObject --;
        }

    }

    private void initGame(){
        for (int i = 0; i < sprites.length; i++) {
           sprites[i] = new Ball(this);
        }
    }

    void onDrowFrame(GameCanvas gameCanvas, Graphics g, float deltaTime){
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void render(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            if(sprites[i] != null) {
                sprites[i].render(gameCanvas, g);
            }
        }
        background.render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            if(sprites[i] != null) {
                sprites[i].update(gameCanvas, deltaTime);
            }
        }
        background.update(deltaTime);
    }

}
