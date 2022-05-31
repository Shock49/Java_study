package level_2.lesson_1.game_two;

import level_2.lesson_1.common.CanvasListner;
import level_2.lesson_1.common.GameCanvas;
import level_2.lesson_1.common.GameObject;
import level_2.lesson_1.common.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements CanvasListner {
    private final int HEIGHT = 600;
    private final int WIDTH = 850;
    private GameObject[] gameObjects = new GameObject[1];
    private int lengthObject;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }


    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Party");
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        initGame();
        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if(e.getButton() == MouseEvent.BUTTON1) {
                    addObject(new Square(x,y));
                }else if(e.getButton() == MouseEvent.BUTTON3){
                    delObject();
                }
            }
        });
        setVisible(true);
    }
    private void addObject(GameObject sprite){
        if(gameObjects.length == lengthObject){
            GameObject[] newGameObject = new GameObject[lengthObject * 2];
            System.arraycopy(gameObjects,0,newGameObject,0,gameObjects.length);
            gameObjects = newGameObject;
        }
        gameObjects[lengthObject] = sprite;
        lengthObject ++;
    }

    private void delObject(){
        if(lengthObject > 1){
            gameObjects[lengthObject - 1] = null;
            lengthObject --;
        }

    }

    private void initGame(){
       addObject(new Back());
       addObject(new Sprite());
    }

    public void onDrowFrame(GameCanvas gameCanvas, Graphics g, float deltaTime){
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void render(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < lengthObject; i++) {
                gameObjects[i].render(gameCanvas, g);
        }
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < lengthObject; i++) {
                gameObjects[i].update(gameCanvas, deltaTime);

        }
    }

}
