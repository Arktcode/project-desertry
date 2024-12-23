package desertry.content;

import arc.graphics.Color;
import static desertry.content.DItems.cobalt;
import static desertry.content.DItems.coltan;
import static desertry.content.DItems.tantalum;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import static mindustry.type.ItemStack.with;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.Prop;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;


public class DBlocks {
    public static Block

    //env

    gearcenter, gearcircle, gearplane, gearside, gearstar,

    testfloor, dunefloor, darkplate, cobaltOre, cactus,

    //core

    coreFrame,

    //production

    atmosfericCondenser, arcMelter;

    public static void load() {


        testfloor = new Floor("test-floor"){{

            variants = 0;
        }};

        gearcenter = new Floor ("gearcenter-plate"){{
 
            variants = 0;
        }};

        gearcircle = new Floor ("gearcircle-plate"){{
 
            variants = 0;
        }};

        gearplane = new Floor ("gearplane-plate"){{
 
            variants = 0;
        }};

        gearside = new Floor ("gearside-plate"){{
 
            variants = 0;
        }};

        gearstar = new Floor ("gearstar-plate"){{
 
            variants = 0;
        }};

        dunefloor = new Floor("dune-floor"){{

            variants = 3;
        }};

        darkplate = new Floor ("dark-plate"){{

         variants = 2;
        }};

        cobaltOre = new OreBlock ("cobalt-ore") {{

         itemDrop = cobalt;
         variants = 3;
        }};

        cactus = new Prop ("cactus"){{

         customShadow = true;
        }};
        
        atmosfericCondenser = new GenericCrafter("atmosferic-condenser"){{
        
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawRegion("-slide"),


                drawer = new DrawMulti(
                    new DrawRegion("-vent"){{
                        rotateSpeed = 19;
                        spinSprite = true;
                    }}
                ),
                new DrawRegion("-top")

            );

            hasLiquids = true;
            outputLiquid = new LiquidStack(Liquids.water, 0.1f / 1f);
            consumePower(1.2f);

            health = 560;
            size = 3;
            alwaysUnlocked = true;
            hasLiquids = true;
            liquidCapacity = 70;
            requirements(Category.liquid, with(tantalum, 1));
            squareSprite = false;
            craftTime = 600;

            itemCapacity = 50;
        

            craftEffect = Fx.vapor;

        }};

        arcMelter = new GenericCrafter("arc-melter"){{

            drawer = new DrawMulti(

            new DrawRegion("-bottom"),
        //new DrawRegion("-shield"),
            new DrawRegion("-topshield"),
            new DrawGlowRegion("-hot"){{
                
                Color.valueOf("#ffeae8");
                glowIntensity = 1.5f;

            }},
            new DrawGlowRegion("-overhot")

            );

            requirements(Category.crafting, with(cobalt, 5, coltan, 10));
            
            consumeItem(coltan, 5); consumePower(0.4f);
            outputItems = ItemStack.with(tantalum, 2);
            
            squareSprite =  false;
            craftTime = 120;
            requiresWater = false;
            liquidCapacity = 15;
            health = 500;
            size = 3;
            alwaysUnlocked = true;
            consumeLiquid(Liquids.water, 0.2f);


        }};

           coreFrame = new CoreBlock("core-frame"){{

                requirements(Category.effect, with(cobalt, 1000, tantalum, 1200, coltan, 900));

                unitType = UnitTypes.alpha;
                health = 8500;
                itemCapacity = 4000;
                size = 5;
                thrusterLength = 40/4f;
                armor = 10f;
                incinerateNonBuildable = true;
                buildCostMultiplier = 0.7f;
                squareSprite = false;
                lightColor = Color.valueOf("a8dfed");
                envRequired = Blocks.coreZone.envRequired;

                drawTeamOverlay = true;

            unitCapModifier = 10;
                researchCostMultipliers.put(coltan, 0.5f);
                researchCostMultiplier = 0.17f;
            }};




    }
}

//endregion
