package assets;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    public BufferedImage sheet;
    public SpriteSheet(String path) {
        
    }
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}