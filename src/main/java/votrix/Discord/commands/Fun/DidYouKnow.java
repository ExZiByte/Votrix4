package votrix.Discord.commands.Fun;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import votrix.Discord.utils.Data;
import votrix.Discord.utils.Facts;

public class DidYouKnow extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Data data = new Data();
        Facts facts = new Facts();
        EmbedBuilder eb = new EmbedBuilder();

        if (args[0].equalsIgnoreCase(data.getPrefix() + "didyouknow")) {
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
                if (args[1].equalsIgnoreCase("animals")) {
                    Random random = new Random();
                    int animals = random.nextInt(facts.getAnimals().length);
                    eb.setDescription("`Did you know " + facts.getAnimals()[animals] + "`");
                    eb.setColor(0xff5555);
                    eb.setFooter("Votrix Did You Know", data.getSelfAvatar(event));
                    eb.setTimestamp(Instant.now());

                    event.getChannel().sendMessage(eb.build()).queue((message) -> {
                        message.delete().queueAfter(15, TimeUnit.SECONDS);
                        event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                        eb.clear();
                    });
                } else if (args.length < 3) {
                    if (args[1].equalsIgnoreCase("food")) {
                        Random random = new Random();
                        int food = random.nextInt(facts.getFood().length);
                        eb.setDescription("`Did you know " + facts.getAnimals()[food] + "`");
                        eb.setColor(0xff5555);
                        eb.setFooter("Votrix Did You Know", data.getSelfAvatar(event));
                        eb.setTimestamp(Instant.now());

                        event.getChannel().sendMessage(eb.build()).queue((message) -> {
                            message.delete().queueAfter(15, TimeUnit.SECONDS);
                            event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                            eb.clear();
                        });
                    }
                } else if (args.length < 3) {
                    if (args[1].equalsIgnoreCase("space")) {
                        Random random = new Random();
                        int space = random.nextInt(facts.getAnimals().length);
                        eb.setDescription("`Did you know " + facts.getSpace()[space] + "`");
                        eb.setColor(0xff5555);
                        eb.setFooter("Votrix Did You Know", data.getSelfAvatar(event));
                        eb.setTimestamp(Instant.now());

                        event.getChannel().sendMessage(eb.build()).queue((message) -> {
                            message.delete().queueAfter(15, TimeUnit.SECONDS);
                            event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                            eb.clear();
                        });
                    }
                } else if (args.length < 3) {
                    if (args[1].equalsIgnoreCase("countries")) {
                        Random random = new Random();
                        int countries = random.nextInt(facts.getCountries().length);
                        eb.setDescription("`Did you know " + facts.getCountries()[countries] + "`");
                        eb.setColor(0xff5555);
                        eb.setFooter("Votrix Did You Know", data.getSelfAvatar(event));
                        eb.setTimestamp(Instant.now());

                        event.getChannel().sendMessage(eb.build()).queue((message) -> {
                            message.delete().queueAfter(15, TimeUnit.SECONDS);
                            event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                            eb.clear();
                        });
                    }
                } else if (args.length < 3) {
                    if (args[1].equalsIgnoreCase("history")) {
                        Random random = new Random();
                        int history = random.nextInt(facts.getHistory().length);
                        eb.setDescription("`Did you know " + facts.getHistory()[history] + "`");
                        eb.setColor(0xff5555);
                        eb.setFooter("Votrix Did You Know", data.getSelfAvatar(event));
                        eb.setTimestamp(Instant.now());

                        event.getChannel().sendMessage(eb.build()).queue((message) -> {
                            message.delete().queueAfter(15, TimeUnit.SECONDS);
                            event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                            eb.clear();
                        });
                    }
                } else if (args.length < 3) {
                    if (args[1].equalsIgnoreCase("movies")) {
                        Random random = new Random();
                        int movies = random.nextInt(facts.getMovies().length);
                        eb.setDescription("`Did you know " + facts.getMovies()[movies] + "`");
                        eb.setColor(0xff5555);
                        eb.setFooter("Votrix Did You Know", data.getSelfAvatar(event));
                        eb.setTimestamp(Instant.now());

                        event.getChannel().sendMessage(eb.build()).queue((message) -> {
                            message.delete().queueAfter(15, TimeUnit.SECONDS);
                            event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                            eb.clear();
                        });
                    }
                } else if (args.length < 3) {
                    if (args[1].equalsIgnoreCase("sports")) {
                        Random random = new Random();
                        int sports = random.nextInt(facts.getSports().length);
                        eb.setDescription("`Did you know " + facts.getSports()[sports] + "`");
                        eb.setColor(0xff5555);
                        eb.setFooter("Votrix Did You Know", data.getSelfAvatar(event));
                        eb.setTimestamp(Instant.now());

                        event.getChannel().sendMessage(eb.build()).queue((message) -> {
                            message.delete().queueAfter(15, TimeUnit.SECONDS);
                            event.getMessage().delete().queueAfter(15, TimeUnit.SECONDS);
                            eb.clear();
                        });
                    }
                }
            }
        }
    }

    public String getName() {
        return "Did You Know";
    }

    public String getDescription() {
        return "Random facts about the selected categories.";
    }

    public String getShortDescription() {
        return "Something you might not know";
    }

    public String getCategory() {
        return "Animals, Food, Space, Countries, History, Movies & Sports";
    }

    public String getRequiredRoles() {
        return "Everyone";
    }

    public String getCommandSyntax() {
        return "```\n" + Data.getPrefix() + "didyouknow {category}\n```";
    }

    public boolean isDisabled() {
        return false;
    }
}