package votrix.Discord;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import votrix.Discord.listeners.Ready;

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
                new Ready()
        );

        votrix.build();

    }

}
