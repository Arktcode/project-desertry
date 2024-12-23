package desertry;

import desertry.content.DBlocks;
import desertry.content.DItems;
import desertry.content.DLiquids;
import desertry.content.DPlanets;
import dialogs.logues;
import mindustry.mod.Mod;


public class Desertry extends Mod{

    public Desertry(){
    }

    @Override
    public void loadContent(){

        //Poner load(); al final.

        DItems.load(); DLiquids.load();
        DBlocks.load();
        logues.load();
        DPlanets.load();
    }
    
}