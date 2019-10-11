package votrix.Discord.commands.Music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MusicManager {
    private final AudioPlayerManager playerManager;

    public void loadAndPlay(final TextChannel channel, final String trackURL){
        GuildMusicManager manager = getGuildAudioPlayer(channel.getGuild());


    }

}
