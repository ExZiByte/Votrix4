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
                "https://i.imgur.com/R8TWjFy.gif",
                "https://i.imgur.com/sYoYQ9q.gif",
                "https://i.imgur.com/ePMOR3R.gif",
                "https://i.imgur.com/iHNej6L.gif",
                "https://i.imgur.com/VRcglCR.gif",
                "https://i.imgur.com/aBpkK7x.gif",
                "https://i.imgur.com/xQudAlA.gif",
                "https://i.imgur.com/3trtPPo.gif",
                "https://i.imgur.com/TikwgIF.gif",
                "https://i.imgur.com/Cd4E0FF.gif",
                "https://i.imgur.com/44rFDFH.gif",
                "https://i.imgur.com/bNNXdrk.gif",
                "https://i.imgur.com/e2uA9C1.gif",
                "https://i.imgur.com/IJx0HdC.gif",
                "https://i.imgur.com/3nk9hka.gif",
                "https://i.imgur.com/VYJUSJL.gif",
                "https://i.imgur.com/SpHj56t.gif",
                "https://i.imgur.com/BYqstBh.gif"
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

    public String getName() {
        return "Hug";
    }

    public String getDescription() {
        return "Allows to give others a friendly hug or yourself.";
    }

    public String getShortDescription() {
        return "Give a friendly hug.";
    }

    public String getRequiredRoles() {
        return "Everyone";
    }

    public String getCommandSyntax() {
        return "```\n" + Data.getPrefix() + "hug [@member]\n```";
    }

    public boolean isDisabled() {
        return false;
    }
}
