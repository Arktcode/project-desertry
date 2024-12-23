package desertry.content;

import arc.graphics.Color;
import desertry.maps.planets.ScarashaPlanetGenerator;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.type.Planet;
import mindustry.world.meta.Env;

public class DPlanets {
    public static Planet
            Gios,
            Scarasha;


    public static void load() {
        Gios = new Planet("Gios", null, 30f) {{

            accessible = false;
            visible = true;
            bloom = true;

            meshLoader = () -> new SunMesh(
                    this, 5,
                    10, 0.5, 1.7, 1.2, 2,
                    1f,
                    Color.valueOf("cce0ff"),
                    Color.valueOf("cce0ff"),
                    Color.valueOf("f2fcff"),
                    Color.valueOf("f2fcff"),
                    Color.valueOf("ccf4ff"),
                    Color.valueOf("ccf4ff")
            );
        }};

        Scarasha = new Planet("Scarasha", Gios, 1f, 3){{
            bloom = true;
            generator = new ScarashaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 10, 4f, 0.15f, 4, Color.valueOf("c7d4ce").mul(0.9f).a(0.9f), 3, 0.50f, 1.0f, 0.39f),
                    new HexSkyMesh(this, 2, 1f, 0.18f, 6, Color.valueOf("bce2f5").a(0.75f), 2, 0.42f, 1f, 0.43f)
            );
            iconColor = Color.valueOf("96c6eb");
            defaultEnv = Env.groundOil | Env.terrestrial;
            atmosphereColor = Color.valueOf("f2fcff");
            atmosphereColor = Color.valueOf("a5e7fa");
            atmosphereRadIn = 0.10f;
            atmosphereRadOut = 0.155f;
            startSector = 1;
            landCloudColor = Color.valueOf("ffef75").a(0.6f);
            hiddenItems.addAll(Items.erekirItems).addAll(Items.serpuloItems);

            defaultCore = Blocks.coreAcropolis;

            alwaysUnlocked = true;
            accessible = true;
            visible = true;
            tidalLock = true;
            

            orbitSpacing = 100;
            orbitRadius = 150;
            drawOrbit = true;


            }
        };
    }
}
