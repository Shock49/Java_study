package level_2.lesson_1.game_one;

import level_2.lesson_1.common.GameCanvas;
import level_2.lesson_1.common.Sprite;

import java.awt.*;

public class Ball extends Sprite {
    private float vx = 150 + (float)(Math.random() * 200f);
    private float vy = 150 + (float)(Math.random() * 200f);
    private final Color color = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255));

    Ball(){
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
    }

    Ball(int x, int y){
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;

        if(getLeft() < gameCanvas.getLeft()){
            setLeft(gameCanvas.getLeft());
            vx = -vx;
        }
        if(getRight() > gameCanvas.getRight()){
            setRight(gameCanvas.getRight());
            vx = -vx;
        }
        if(getTop() < gameCanvas.getTop()){
            setTop(gameCanvas.getTop());
            vy = -vy;
        }
        if(getBottom() > gameCanvas.getBottom()){
            setBottom(gameCanvas.getBottom());
            vy = -vy;
        }
    }
}
