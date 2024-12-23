package desertry.maps.planets;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.Tmp;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.content.Loadouts;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Sector;
import mindustry.world.Block;

public class arkPlanetConstants extends PlanetGenerator {
    public float heightScl = 2f, octaves = 10, persistence = 0.9f, heightPow = 1.5f, heightMult = 1f;

    public static int crystalSeed = 83, crystalOct = 4;
    public static float crystalScl = 0.5f, crystalMag = 0.5f;

    Block[] terrain = {Blocks.salt, Blocks.sand, Blocks.basalt, Blocks.sand, Blocks.salt, Blocks.sand, Blocks.sand, Blocks.slag};

    {
        baseSeed = 2;
        defaultLoadout = Loadouts.basicBastion;
    }

    @Override
    public void generateSector(Sector sector) {
        //no bases right now
    }

    @Override
    public float getHeight(Vec3 position) {
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    @Override
    public Color getColor(Vec3 position) {
        Block block = getBlock(position);

        if (block == Blocks.slag) block = Blocks.salt;

        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }

    @Override
    public float getSizeScl() {
        return 2000 * 1.07f * 6f / 5f;
    }

    float rawHeight(Vec3 position) {
        return Simplex.noise3d(seed, octaves, persistence, 1f / heightScl, 15f + position.x, 15f + position.y, 10f + position.z);
    }

    float rawTemp(Vec3 position) {
        return position.dst(0, 0, 1) * 2.2f - Simplex.noise3d(seed, 4, 0.54f, 1.4f, 10f + position.x, 10f + position.y, 10f + position.z) * 2.9f;
    }

    Block getBlock(Vec3 position) {
        float ice = rawTemp(position);
        Tmp.v32.set(position);

        float height = rawHeight(position);
        Tmp.v31.set(position);
        height *= 1.2f;
        height = Mathf.clamp(height);

        Block result = terrain[Mathf.clamp((int) (height * terrain.length), 0, terrain.length - 1)];

        if (ice < 0.3 + Math.abs(Ridged.noise3d(seed + crystalSeed, position.x + 4f, position.y + 8f, position.z + 1f, crystalOct, crystalScl)) * crystalMag) {
            return Blocks.sand;
        }

        if (ice < 0.6) {
            if (result == Blocks.sand || result == Blocks.salt || result == Blocks.salt) {

                return Blocks.sand;
            }
        }



        return result;
    }


}