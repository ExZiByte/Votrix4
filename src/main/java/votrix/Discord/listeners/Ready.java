package votrix.Discord.listeners;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ready extends ListenerAdapter {

    public void onReady(ReadyEvent event){
    event.getJDA().getPresence().setStatus(OnlineStatus.ONLINE);
    Activity[] games = { Activity.playing("with Somato Setchup"), Activity.playing("with Biscuits"), Activity.watching("Toe Tucks") };
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(() -> {
        Random random = new Random();
        int game = random.nextInt(games.length);
        event.getJDA().getPresence().setActivity(games[game]);
    }, 0, 2, TimeUnit.MINUTES);

}
}
