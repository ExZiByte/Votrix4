package votrix.Discord.utils;


import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class ChannelCheck {

    public static boolean isStreamerChannel(GuildMessageReceivedEvent event){
        if(event.getChannel().equals(event.getGuild().getTextChannelById("594757517536526366"))) {
            return true;
        } else {
            return false;
        }
    }
}
