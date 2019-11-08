package votrix.Discord.commands.Fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import votrix.Discord.utils.Data;

import java.awt.*;
import java.time.Instant;
import java.util.Random;

public class Ree extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Data data = new Data();
        EmbedBuilder eb = new EmbedBuilder();

        String[] images = {
            "https://i.imgur.com/Y9md0N7.gif",
            "https://i.imgur.com/7OmRegl.gif"
        };

        if(args[0].equalsIgnoreCase(data.getPrefix() + "ree")){
            Random random = new Random();
            int image = random.nextInt(images.length);
            if(args.length < 2){
                eb.setDescription("**" + event.getMember().getEffectiveName() + "**" + " ree'd.");
                eb.setImage(images[image]);
                eb.setFooter("Votrix Self Ree", data.getSelfAvatar(event));
                eb.setTimestamp(Instant.now());

                event.getChannel().sendMessage(eb.build()).queue((message) -> {
                    eb.clear();
                });
            } else if(args.length > 1){
                Member mentioned = event.getMessage().getMentionedMembers().get(0);
                eb.setDescription("**" + event.getMember().getEffectiveName() + "** ree'd at **" + mentioned.getEffectiveName() + "**");
                eb.setColor(new Color(data.getColor()));
                eb.setImage(images[image]);
                eb.setFooter("Votrix Ree", data.getSelfAvatar(event));
                eb.setTimestamp(Instant.now());

                event.getChannel().sendMessage(eb.build()).queue((message) -> {
                    eb.clear();
                });
            }
        }
    }

    public String getName() {
        return "Ree";
    }

    public String getDescription() {
        return "If you want to let out a loud REEE!.";
    }

    public String getShortDescription() {
        return "REEEE!";
    }

    public String getRequiredRoles() {
        return "Everyone";
    }

    public String getCommandSyntax() {
        return "```\n" + Data.getPrefix() + "ree [@member]\n```";
    }

    public boolean isDisabled() {
        return false;
    }
}