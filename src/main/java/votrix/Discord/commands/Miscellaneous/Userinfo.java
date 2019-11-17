package votrix.Discord.commands.Miscellaneous;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import votrix.Discord.utils.Data;
import votrix.Discord.utils.StatusChecker;

public class Userinfo extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Data data = new Data();

        if (args[0].equalsIgnoreCase(data.getPrefix() + "userinfo")) {

            StatusChecker statuscheck = new StatusChecker();
            String status = event.getMember().getOnlineStatus().toString();
            if (status == "ONLINE") {
                statuscheck.online(event);
            } else if (status == "IDLE") {
                statuscheck.away(event);
            } else if (status == "DO_NOT_DISTURB") {
                statuscheck.dnd(event);
            } else if (status == "OFFLINE") {
                statuscheck.invisible(event);
            } else {
                statuscheck.nullstatus(event);
            }
        }
    }

    public String getName() {
        return "Userinfo";
    }

    public String getDescription() {
        return "Lets you check your user information.";
    }

    public String getShortDescription() {
        return "Check your user information";
    }

    public String getRequiredRoles() {
        return "Everyone";
    }

    public String getCommandSyntax() {
        return "```\n" + Data.getPrefix() + "userinfo\n```";
    }

    public boolean isDisabled() {
        return false;
    }
}