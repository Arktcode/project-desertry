package dialogs;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import mindustry.game.EventType;
import mindustry.ui.dialogs.BaseDialog;


public class logues {

    public static void load() {


        Log.info("Log Test GO.");

        //Cargar algunos eventos
        Events.on(EventType.ClientLoadEvent.class, e -> {
            //El dialog.cont para runnear el texto etc
            Time.runTask(15f, () -> {
                BaseDialog dialog = new BaseDialog("Desert Propieties Log");
                dialog.cont.add("Actualizaciones [#fed17b]Importantes").row();
                dialog.cont.add("Implementaciones privadas [crimson]Parte [white](I)").row();
                dialog.cont.add("Creditos: [#499e4d]DylanMBG[white], [#daf595]AstroAlpha[white], [#d895f5]InterLix[white], [#fa8282]Pinparun").row();

                dialog.cont.add("[#515154]v0.05'released Note, Coltan & Cobalt Testings...").row();
                //buscar una imagen ejemplo el zinc para ello el (Core.atlas.find("(InternalModName-imagen)")
                dialog.cont.image(Core.atlas.find("dp-coltan")).pad(5f).row();

                dialog.cont.button("Cerrar", dialog::hide).size(100f, 50f).row();
                dialog.show();
            });




        });
    }

}
