package desertry.content;

import arc.graphics.Color;
import mindustry.type.Liquid;


public class DLiquids {

    public static Liquid

    mud;

    public static void load() {

        mud = new Liquid("mud", Color.valueOf("#f5df9f")) {{
            gas = false;
            explosiveness = 0.0f;
            viscosity = 0.3f;
            temperature = 0.15f;
        }};

    }
}
