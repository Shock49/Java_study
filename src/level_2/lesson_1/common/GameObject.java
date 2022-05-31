package level_2.lesson_1.common;

import java.awt.*;

public interface GameObject {
    void render(GameCanvas gameCanvas, Graphics g);
    void update(GameCanvas gameCanvas, float deltaTime);
}
