package votrix.Discord.commands.Moderation;

import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import votrix.Discord.utils.Data;
import votrix.Discord.utils.RoleCheck;

public class Ban extends ListenerAdapter {

    RoleCheck rc = new RoleCheck();

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Data data = new Data();
        EmbedBuilder eb = new EmbedBuilder();
        EmbedBuilder banned = new EmbedBuilder();
        if (args[0].equalsIgnoreCase(data.getPrefix() + "ban")) {
            if (rc.isOwner(event) || rc.isDeveloper(event)) {
                if (args.length < 2) {
                    eb.setDescription("You didn't specify enough arguments");
                    eb.setColor(0xff5555);
                    eb.setFooter("Insufficient Arguments", data.getSelfAvatar(event));
                    eb.setTimestamp(Instant.now());

                    event.getChannel().sendMessage(eb.build()).queue((message) -> {
                        message.delete().queueAfter(15, TimeUnit.SECONDS);
                        event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                        eb.clear();
                    });
                } else if (args.length < 3) {
                    Member mentioned = event.getMessage().getMentionedMembers().get(0);

                    banned.setDescription("You've been banned from: " + event.getGuild().getName()
                            + "\n\nReason: \n```\nThere was no reason specified\n```");
                    banned.setColor(0xff5555);
                    banned.setFooter(event.getJDA().getSelfUser().getName() + " Banned",
                            data.getSelfAvatar(event));
                    banned.setTimestamp(Instant.now());

                    eb.setDescription("You've banned: " + mentioned.getAsMention() + "\n\nReason:\n```\nNo reason specified\n```");
                    eb.setColor(0x4fff45);
                    eb.setFooter(event.getJDA().getSelfUser().getName() + " Ban",
                            data.getSelfAvatar(event));
                    eb.setTimestamp(Instant.now());

                    mentioned.getUser().openPrivateChannel().queue((channel) -> {
                        channel.sendMessage(banned.build()).queue();
                        banned.clear();

                        event.getChannel().sendMessage(eb.build()).queue((message) -> {
                            message.delete().queueAfter(20, TimeUnit.SECONDS);
                            event.getMessage().delete().queueAfter(20, TimeUnit.SECONDS);
                            eb.clear();
                            event.getGuild().ban(mentioned, 7, "No Reason Specified").queue();
                        });
                    });

                } else {
                    Member mentioned = event.getMessage().getMentionedMembers().get(0);
                    String reason = Arrays.stream(args).skip(2).collect(Collectors.joining(" "));

                    banned.setDescription("You've been banned from: " + event.getGuild().getName() + "\n\nReason:\n```\n" + reason + "\n```");
                    banned.setColor(0xff5555);
                    banned.setFooter(event.getJDA().getSelfUser().getName() + " Banned",
                            data.getSelfAvatar(event));
                    banned.setTimestamp(Instant.now());

                    eb.setDescription("You've banned: " + mentioned.getAsMention() + " \n\nReason: \n```\n" + reason + "\n```");
                    eb.setColor(0x4fff45);
                    eb.setFooter(event.getJDA().getSelfUser().getName() + " Ban",
                            data.getSelfAvatar(event));
                    eb.setTimestamp(Instant.now());

                    mentioned.getUser().openPrivateChannel().queue((channel) -> {
                        channel.sendMessage(banned.build()).queue();
                        banned.clear();

                        event.getChannel().sendMessage(eb.build()).queue((message) -> {
                            message.delete().queueAfter(20, TimeUnit.SECONDS);
                            event.getMessage().delete().queueAfter(20, TimeUnit.SECONDS);
                            eb.clear();
                            event.getGuild().ban(mentioned, 7, reason).queue();
                        });
                    });

                }
            } else {
                eb.setDescription(event.getMember().getAsMention()
                        + ", You dont have the permission to ban members from this guild.");
                eb.setColor(0xff5555);
                eb.setFooter("Insufficient Permissions", data.getSelfAvatar(event));
                eb.setTimestamp(Instant.now());
                event.getChannel().sendMessage(eb.build()).queue((message) -> {
                    message.delete().queueAfter(15, TimeUnit.SECONDS);
                    event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                    eb.clear();
                });
            }
        }
    }

    public String getName(){
        return "Ban";
    }

    public String getDescription() {
        return "Bans the specified member for the specified reason if no reason is specified then the member is banned for \"No Reason Specified\".";
    }

    public String getShortDescription() {
        return "Bans the specified member";
    }

    public String getRequiredRoles() {
        return "Owner, Developer";
    }

    public String getCommandSyntax() {
        return "```\n" + Data.getPrefix() + "ban {@member} [reason]\n```";
    }

    public boolean isDisabled() {
        return false;
    }

}
