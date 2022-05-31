package level_2.lesson_1.game_one;

import level_2.lesson_1.common.GameCanvas;
import level_2.lesson_1.common.GameObject;

import java.awt.*;

public class Background implements GameObject {

    private Color color;
    private float time;
    private final float AMPLITUDA_COLOR = 255 / 2f;

    @Override
    public void render(GameCanvas gameCanvas, Graphics g){
        gameCanvas.setBackground(color);
    }
    @Override
    public void update(GameCanvas gameCanvas, float deltaTime){
        time += deltaTime;
        int red = Math.round(AMPLITUDA_COLOR + AMPLITUDA_COLOR * (float) Math.sin(time));
        int green = Math.round(AMPLITUDA_COLOR + AMPLITUDA_COLOR * (float) Math.sin(time * 2));
        int blue = Math.round(AMPLITUDA_COLOR + AMPLITUDA_COLOR * (float) Math.sin(time * 3));
        color = new Color(red,green,blue);
    }
}
