package level_2.lesson_1;

import java.awt.*;

public class Sprite implements GameObject {
    float x;
    float y;
    float halfWidth;
    float halfHeight;

    float getLeft() { return x - halfWidth;}
    void setLeft(float left){ x = left + halfWidth;}
    float getRight() { return x + halfWidth;}
    void setRight(float right){ x = right - halfWidth;}
    float getTop(){ return y - halfHeight;}
    void setTop(float top){ y = top + halfHeight;}
    float getBottom(){ return y + halfHeight;}
    void setBottom(float bottom){ y = bottom - halfHeight;}

    public float getWidth() { return 2f * halfWidth;}
    public float getHeight() { return 2f * halfHeight;}

    public void render(GameCanvas gameCanvas, Graphics g){};
    public void update(GameCanvas gameCanvas, float deltaTime){};
}
