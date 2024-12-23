package desertry.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class DItems {
    public static Item
            tantalum, cobalt, coltan;
    public static final Seq<Item> DItems = new Seq<>();

    public static void load() {
        tantalum = new Item("tantalum", Color.valueOf("c5c7c9")) {{
            hardness = 1;
            charge = 1;
            cost = 1.0f;
            alwaysUnlocked = true;
        }};

        cobalt = new Item("cobalt", Color.valueOf("#5234eb")) {{
            hardness = 2;
            radioactivity = 0.05f;
            charge = 0.1f;
            alwaysUnlocked = true;
        }};

        coltan = new Item("coltan", Color.valueOf("#c2b797")) {{
            hardness = 1;
            alwaysUnlocked = true;
        }};

        DItems.addAll(
                tantalum, cobalt, coltan
        );

    }
}