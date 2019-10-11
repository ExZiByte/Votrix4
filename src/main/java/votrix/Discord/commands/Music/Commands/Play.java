package votrix.Discord.commands.Music.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import votrix.Discord.utils.Data;

import java.awt.*;
import java.time.Instant;

public class Play extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Data data = new Data();
        EmbedBuilder eb = new EmbedBuilder();
        if(args[0].equalsIgnoreCase(data.getPrefix() + "play")){
            if(args.length < 2){
                eb.setDescription("You need to supply a link to a song for me to play");
                eb.setColor(new Color(data.getColor()));
                eb.setTimestamp(Instant.now());
                eb.setFooter("Insufficient Arguments", data.getSelfAvatar(event));

                event.getChannel().sendMessage(eb.build()).queue();
            } else if(args.length == 2){
                
            }
        }
    }
}
