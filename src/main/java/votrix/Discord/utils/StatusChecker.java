package votrix.Discord.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class StatusChecker {
    LocalDateTime ld = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
    String date = ld.format(dtf);
    Data data = new Data();

    public EmbedBuilder online(GuildMessageReceivedEvent event) {
        String roles = "";
        roles = event.getMember().getRoles().stream().map((rol) -> ", " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(2);

        String game = "";
        try {
            game = event.getMember().getActivities().get(0).getName();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder online = new EmbedBuilder();
        online.setColor(0x85f96d);
        online.setThumbnail(event.getMember().getUser().getAvatarUrl());
        online.addField("Username",
                event.getMember().getEffectiveName() + "#" + event.getMember().getUser().getDiscriminator(), true);
        online.addField("Nickname", event.getMember().getEffectiveName(), true);
        online.addField("Status", event.getGuild().getEmoteById("645713106428755968").getAsMention() + "Online", true);
        online.addField("Playing", game, true);
        online.addField("Joined Guild", event.getMember().getTimeJoined().format(dtf), true);
        online.addField("Joined Discord", event.getMember().getUser().getTimeCreated().format(dtf), true);
        online.addField("Roles", roles, true);
        online.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(online.build()).queue();
        return online;
    }

    public EmbedBuilder away(GuildMessageReceivedEvent event) {
        String roles = "";
        roles = event.getMember().getRoles().stream().map((rol) -> " , " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(3);

        String game = "";
        try {
            game = event.getMember().getActivities().get(0).getName();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder away = new EmbedBuilder();
        away.setColor(0x85f96d);
        away.setThumbnail(event.getMember().getUser().getAvatarUrl());
        away.addField("Username",
                event.getMember().getEffectiveName() + "#" + event.getMember().getUser().getDiscriminator(), true);
        away.addField("Nickname", event.getMember().getEffectiveName(), true);
        away.addField("Status", event.getGuild().getEmoteById("645713105900273701").getAsMention() + "Idle", true);
        away.addField("Playing", game, true);
        away.addField("Joined Guild", event.getMember().getTimeJoined().format(dtf), true);
        away.addField("Joined Discord", event.getMember().getUser().getTimeCreated().format(dtf), true);
        away.addField("Roles", roles, true);
        away.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(away.build()).queue();
        return away;
    }

    public EmbedBuilder dnd(GuildMessageReceivedEvent event) {
        String roles = "";
        roles = event.getMember().getRoles().stream().map((rol) -> " , " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(3);

        String game = "";
        try {
            game = event.getMember().getActivities().get(0).getName();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder dnd = new EmbedBuilder();
        dnd.setColor(0x85f96d);
        dnd.setThumbnail(event.getMember().getUser().getAvatarUrl());
        dnd.addField("Username",
                event.getMember().getEffectiveName() + "#" + event.getMember().getUser().getDiscriminator(), true);
        dnd.addField("Nickname", event.getMember().getEffectiveName(), true);
        dnd.addField("Status", event.getGuild().getEmoteById("645713106475155456").getAsMention() + "Do Not Disturb",
                true);
        dnd.addField("Playing", game, true);
        dnd.addField("Joined Guild", event.getMember().getTimeJoined().format(dtf), true);
        dnd.addField("Joined Discord", event.getMember().getUser().getTimeCreated().format(dtf), true);
        dnd.addField("Roles", roles, true);
        dnd.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(dnd.build()).queue();
        return dnd;
    }

    public EmbedBuilder invisible(GuildMessageReceivedEvent event) {
        String roles = "";
        roles = event.getMember().getRoles().stream().map((rol) -> " , " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(3);

        String game = "";
        try {
            game = event.getMember().getActivities().get(0).getName();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder invisible = new EmbedBuilder();
        invisible.setColor(0x85f96d);
        invisible.setThumbnail(event.getMember().getUser().getAvatarUrl());
        invisible.addField("Username",
                event.getMember().getEffectiveName() + "#" + event.getMember().getUser().getDiscriminator(), true);
        invisible.addField("Nickname", event.getMember().getEffectiveName(), true);
        invisible.addField("Status", event.getGuild().getEmoteById("645713106319966218").getAsMention() + "Offline",
                true);
        invisible.addField("Playing", game, true);
        invisible.addField("Joined Guild", event.getMember().getTimeJoined().format(dtf), true);
        invisible.addField("Joined Discord", event.getMember().getUser().getTimeCreated().format(dtf), true);
        invisible.addField("Roles", roles, true);
        invisible.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(invisible.build()).queue();
        return invisible;
    }

    public EmbedBuilder nullstatus(GuildMessageReceivedEvent event) {
        String roles = "";
        roles = event.getMember().getRoles().stream().map((rol) -> " , " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(3);

        String game = "";
        try {
            game = event.getMember().getActivities().get(0).getName();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder nullstatus = new EmbedBuilder();
        nullstatus.setColor(0x85f96d);
        nullstatus.setThumbnail(event.getMember().getUser().getAvatarUrl());
        nullstatus.addField("Username",
                event.getMember().getEffectiveName() + "#" + event.getMember().getUser().getDiscriminator(), true);
        nullstatus.addField("Nickname", event.getMember().getEffectiveName(), true);
        nullstatus.addField("Status", "Not Found", true);
        nullstatus.addField("Playing", game, true);
        nullstatus.addField("Joined Guild", event.getMember().getTimeJoined().format(dtf), true);
        nullstatus.addField("Joined Discord", event.getMember().getUser().getTimeCreated().format(dtf), true);
        nullstatus.addField("Roles", roles, true);
        nullstatus.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(nullstatus.build()).queue();
        return nullstatus;
    }

    public EmbedBuilder onlinementioned(GuildMessageReceivedEvent event) {
        Member mentioned = event.getMessage().getMentionedMembers().get(0);
        String roles = "";
        roles = mentioned.getRoles().stream().map((rol) -> ", " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(2);

        String game = "";
        try {
            game = mentioned.getActivities().get(0).getType().name();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder online = new EmbedBuilder();
        online.setColor(0x85f96d);
        online.setThumbnail(mentioned.getUser().getAvatarUrl());
        online.addField("Username",
                mentioned.getEffectiveName() + "#" + mentioned.getUser().getDiscriminator(), true);
        online.addField("Nickname", mentioned.getEffectiveName(), true);
        online.addField("Status", event.getGuild().getEmoteById("645713106428755968").getAsMention() + "Online", true);
        online.addField("Playing", game, true);
        online.addField("Joined Guild", mentioned.getTimeJoined().format(dtf), true);
        online.addField("Joined Discord", mentioned.getTimeCreated().format(dtf), true);
        online.addField("Roles", roles, true);
        online.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(online.build()).queue();
        return online;
    }

    public EmbedBuilder awaymentioned(GuildMessageReceivedEvent event) {
        Member mentioned = event.getMessage().getMentionedMembers().get(0);
        String roles = "";
        roles = mentioned.getRoles().stream().map((rol) -> " , " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(3);

        String game = "";
        try {
            game = mentioned.getActivities().get(0).getType().name();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder away = new EmbedBuilder();
        away.setColor(0x85f96d);
        away.setThumbnail(mentioned.getUser().getAvatarUrl());
        away.addField("Username",
                mentioned.getEffectiveName() + "#" + mentioned.getUser().getDiscriminator(), true);
        away.addField("Nickname", mentioned.getEffectiveName(), true);
        away.addField("Status", event.getGuild().getEmoteById("645713105900273701").getAsMention() + "Idle", true);
        away.addField("Playing", game, true);
        away.addField("Joined Guild", mentioned.getTimeJoined().format(dtf), true);
        away.addField("Joined Discord", mentioned.getTimeCreated().format(dtf), true);
        away.addField("Roles", roles, true);
        away.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(away.build()).queue();
        return away;
    }

    public EmbedBuilder dndmentioned(GuildMessageReceivedEvent event) {
        Member mentioned = event.getMessage().getMentionedMembers().get(0);
        String roles = "";
        roles = mentioned.getRoles().stream().map((rol) -> " , " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(3);

        String game = "";
        try {
            game = mentioned.getActivities().get(0).getType().name();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder dnd = new EmbedBuilder();
        dnd.setColor(0x85f96d);
        dnd.setThumbnail(mentioned.getUser().getAvatarUrl());
        dnd.addField("Username",
                mentioned.getEffectiveName() + "#" + mentioned.getUser().getDiscriminator(), true);
        dnd.addField("Nickname", mentioned.getEffectiveName(), true);
        dnd.addField("Status", event.getGuild().getEmoteById("645713106475155456").getAsMention() + "Do Not Disturb",
                true);
        dnd.addField("Playing", game, true);
        dnd.addField("Joined Guild", mentioned.getTimeJoined().format(dtf), true);
        dnd.addField("Joined Discord", mentioned.getTimeCreated().format(dtf), true);
        dnd.addField("Roles", roles, true);
        dnd.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(dnd.build()).queue();
        return dnd;
    }

    public EmbedBuilder invisiblementioned(GuildMessageReceivedEvent event) {
        Member mentioned = event.getMessage().getMentionedMembers().get(0);
        String roles = "";
        roles = mentioned.getRoles().stream().map((rol) -> " , " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(3);

        String game = "";
        try {
            game = mentioned.getActivities().get(0).getType().name();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder invisible = new EmbedBuilder();
        invisible.setColor(0x85f96d);
        invisible.setThumbnail(mentioned.getUser().getAvatarUrl());
        invisible.addField("Username",
                mentioned.getEffectiveName() + "#" + mentioned.getUser().getDiscriminator(), true);
        invisible.addField("Nickname", mentioned.getEffectiveName(), true);
        invisible.addField("Status", event.getGuild().getEmoteById("645713106319966218").getAsMention() + "Offline",
                true);
        invisible.addField("Playing", game, true);
        invisible.addField("Joined Guild", mentioned.getTimeJoined().format(dtf), true);
        invisible.addField("Joined Discord", mentioned.getTimeCreated().format(dtf), true);
        invisible.addField("Roles", roles, true);
        invisible.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(invisible.build()).queue();
        return invisible;
    }

    public EmbedBuilder nullstatusmentioned(GuildMessageReceivedEvent event) {
        Member mentioned = event.getMessage().getMentionedMembers().get(0);
        String roles = "";
        roles = mentioned.getRoles().stream().map((rol) -> " , " + rol.getName()).reduce(roles, String::concat);
        if (roles.isEmpty())
            roles = "None";
        else
            roles = roles.substring(3);

        String game = "";
        try {
            game = mentioned.getActivities().get(0).getType().name();
        } catch (NullPointerException e) {
            game = "Not Playing";
        }

        EmbedBuilder nullstatus = new EmbedBuilder();
        nullstatus.setColor(0x85f96d);
        nullstatus.setThumbnail(mentioned.getUser().getAvatarUrl());
        nullstatus.addField("Username",
                mentioned.getEffectiveName() + "#" + mentioned.getUser().getDiscriminator(), true);
        nullstatus.addField("Nickname", mentioned.getEffectiveName(), true);
        nullstatus.addField("Status", "Not Found", true);
        nullstatus.addField("Playing", game, true);
        nullstatus.addField("Joined Guild", mentioned.getTimeJoined().format(dtf), true);
        nullstatus.addField("Joined Discord", mentioned.getTimeCreated().format(dtf), true);
        nullstatus.addField("Roles", roles, true);
        nullstatus.setFooter("Votrix Userinfo", data.getSelfAvatar(event));
        event.getChannel().sendMessage(nullstatus.build()).queue();
        return nullstatus;
    }
}