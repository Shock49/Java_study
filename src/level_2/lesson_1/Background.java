package level_2.lesson_1;

import java.awt.*;

public class Background {
    private float red;
    private float green;
    private float blue;
    private float step_color;

    Background(){
        red = (float) (Math.random() * 255);
        green = (float) (Math.random() * 255);
        blue = (float) (Math.random() * 255);
        step_color = 100f;
    }
    private float changeColor(float color, float deltaTime){
        color = color + step_color * (float) (Math.sin(Math.random()*361)) * deltaTime;
        if (color >= 255){
            step_color = (float) (Math.random()*10f + 1);
            return  255;
        }else if (color <= 0){
            step_color = (float) (Math.random()*10f + 1);
           return  1;
        }
        return color;
    }

    void render(GameCanvas gameCanvas, Graphics g){
        gameCanvas.setBackground(new Color((int)red,(int)green,(int)blue));
    }
    void update(float deltaTime){
        red = changeColor(red, deltaTime);
        green = changeColor(green, deltaTime);
        blue = changeColor(blue, deltaTime);
    }
}
