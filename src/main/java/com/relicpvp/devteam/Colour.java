package com.relicpvp.devteam;

import org.bukkit.Color;

/**
 * Created by Taylor on 16/01/2016.
 */
public class Colour {

    public  Color c;
    static int r = 255;
    static int g = 0;
    static int b = 0;

    public  void createColour() {

        if (r == 255 && b == 0 && g != 255) {
            g += 10;
            if (g > 255) {
                g = 255;
            }
        }
        if (g == 255 && r > 0) {
            r -= 10;
            if (r < 0) {
                r = 0;
            }
        }
        if (r == 0 && b != 255) {
            b += 10;
            if (b > 255) {
                b = 255;
            }
        }
        if (b == 255 && g > 0) {
            g -= 10;
            if (g < 0) {
                g = 0;
            }
        }
        if (g == 0 && r != 255) {
            r += 10;
            if (r > 255) {
                r = 255;
            }
        }
        if (r == 255 && b > 0) {
            b -= 15;
            if (b < 0) {
                b = 0;
            }
        }


        c = Color.fromRGB(r, g, b);

    }
}
