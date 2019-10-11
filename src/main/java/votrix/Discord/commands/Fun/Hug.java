package votrix.Discord.commands.Fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import votrix.Discord.utils.Data;

import java.awt.*;
import java.time.Instant;
import java.util.Random;

public class Hug extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Data data = new Data();
        EmbedBuilder eb = new EmbedBuilder();
        String[] images = {
                "https://tenor.com/view/cuddle-hugs-otter-gif-12200735", //otters hugging
                "https://media.giphy.com/media/EvYHHSntaIl5m/giphy.gif", //sully hugging boo
                "https://tenor.com/view/dog-hug-bff-bestfriend-friend-gif-9512793", //dogs hugging
                "https://tenor.com/view/milk-and-mocha-hug-cute-kawaii-love-gif-12535134", //milk and mocha kawaii hug
                "https://media.giphy.com/media/kooPUWvhaGe7C/giphy.gif", //bubbles hugging cat
                "https://media.giphy.com/media/jMGxhWR7rtTNu/giphy.gif", //penguins hugging
                "https://tenor.com/view/hug-your-cat-day-hug-cat-gif-8723720", //hug your cat day
                "https://tenor.com/view/animated-love-hug-gif-8330882", //raccoon hug
                "https://tenor.com/view/polar-bears-hug-hugging-cuddle-comfortable-gif-3904776", //polar bear hugs
                "https://tenor.com/view/virtual-hug-random-hug-gif-7939558" //random hug
        };
        if(args[0].equalsIgnoreCase(data.getPrefix() + "hug")){
            Random random = new Random();
            int image = random.nextInt(images.length);
            if(args.length < 2){
                eb.setDescription("You narcissist.");
                eb.setImage(images[image]);
                eb.setFooter("Votrix Self Hug", data.getSelfAvatar(event));
                eb.setTimestamp(Instant.now());

                event.getChannel().sendMessage(eb.build()).queue((message) -> {
                    eb.clear();
                });
            } else if(args.length > 1){
                Member mentioned = event.getMessage().getMentionedMembers().get(0);
                eb.setDescription("**" + event.getMember().getEffectiveName() + "** hugged **" + mentioned.getEffectiveName() + "**");
                eb.setColor(new Color(data.getColor()));
                eb.setImage(images[image]);
                eb.setFooter("Votrix Hug", data.getSelfAvatar(event));
                eb.setTimestamp(Instant.now());

                event.getChannel().sendMessage(eb.build()).queue((message) -> {
                    eb.clear();
                });
            }
        }
    }
}
