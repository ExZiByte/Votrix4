package votrix.Discord.commands.Fun;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import votrix.Discord.utils.Data;
import votrix.Discord.utils.Facts;

public class DidYouKnow extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Data data = new Data();
        Facts facts = new Facts();
        EmbedBuilder eb = new EmbedBuilder();

        if(args[0].equalsIgnoreCase(data.getPrefix() + "didyouknow")){
            if (args.length < 2) {
                eb.setDescription("You didn't specify enough arguments");
                eb.setColor(0xff5555);
                eb.setFooter("Insufficient Arguments", data.getSelfAvatar(event));
                eb.setTimestamp(Instant.now());

                event.getChannel().sendMessage(eb.build()).queue((message) -> {
                    message.delete().queueAfter(15, TimeUnit.SECONDS);
                    event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                    eb.clear();
                });
            } else if (args.length < 3) {
                if (args[1].equalsIgnoreCase("nature")) {
                    eb.setDescription("`" + facts.getNature() + "`");
                    eb.setColor(0xff5555);
                    eb.setFooter("Votrix Did You Know", data.getSelfAvatar(event));
                    eb.setTimestamp(Instant.now());

                    event.getChannel().sendMessage(eb.build()).queue((message) -> {
                        message.delete().queueAfter(15, TimeUnit.SECONDS);
                        event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                        eb.clear();
                    });
                }
            }
        }
    }
}