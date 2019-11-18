package votrix.Discord.commands.Miscellaneous;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import votrix.Discord.utils.Data;
import votrix.Discord.utils.StatusChecker;

public class Userinfo extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Data data = new Data();

        if (args[0].equalsIgnoreCase(data.getPrefix() + "userinfo")) {
            if (args.length < 2) {

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
            } else if (args.length > 1) {
                StatusChecker statuscheck = new StatusChecker();
                Member mentioned = event.getMessage().getMentionedMembers().get(0);
                String status = mentioned.getOnlineStatus().toString();
                if (status == "ONLINE") {
                    statuscheck.onlinementioned(event);
                } else if (status == "IDLE") {
                    statuscheck.awaymentioned(event);
                } else if (status == "DO_NOT_DISTURB") {
                    statuscheck.dndmentioned(event);
                } else if (status == "OFFLINE") {
                    statuscheck.invisiblementioned(event);
                } else {
                    statuscheck.nullstatusmentioned(event);
                }
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