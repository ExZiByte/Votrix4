package votrix.Discord;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import votrix.Discord.commands.Fun.*;
import votrix.Discord.commands.Information.*;
import votrix.Discord.commands.Miscellaneous.*;
import votrix.Discord.commands.Moderation.*;
import votrix.Discord.commands.Settings.*;
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
                new Hug(),
                new Ree(),
                new DidYouKnow(),
                new Screenshare(),

                //Information
                new Help(),

                //Miscellaneous
                new Suggest(),
                new Userinfo(),

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
