package votrix.Discord;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import votrix.Discord.commands.Fun.CleverBot;
import votrix.Discord.commands.Fun.Screenshare;
import votrix.Discord.commands.Information.Help;
import votrix.Discord.commands.Miscellaneous.Suggest;
import votrix.Discord.commands.Moderation.*;
import votrix.Discord.commands.Settings.SetPrefix;
import votrix.Discord.listeners.*;

import javax.security.auth.login.LoginException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Votrix {

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException{
        //Disable MongoDB Java Driver Logs Console Spam
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.OFF);

        //Build JDA Bot Instance
        final JDABuilder votrix = new JDABuilder(AccountType.BOT).setToken(System.getenv("VOTRIXTOKEN"));

        votrix.setActivity(Activity.watching("the loading bar!"));
        votrix.setStatus(OnlineStatus.DO_NOT_DISTURB);

        votrix.addEventListeners(
                //Fun
                new CleverBot(),
                new Screenshare(),

                //Information
                new Help(),

                //Miscellaneous
                new Suggest(),

                //Moderation
                new Ban(),
                new Clear(),
                new Kick(),
                new Mute(),
                new RoleAdd(),
                new RoleRemove(),
                new Softban(),
                new Tempmute(),
                new Unmute(),

                //Settings
                new SetPrefix(),

                //Misc
                new Ready(),
                new AltRejoin(),
                new GuildMemberJoin(),
                new GuildMemberLeave(),
                new SuggestionReactAdd()
        );

        votrix.build();

    }

}
