package com.nguyenhanhnong.discordbot.commands;

import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.nguyenhanhnong.discordbot.randomizer.Randomizer;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.utils.FileUpload;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;

public class CommandFunctionality {
    public static void randomize(@NotNull SlashCommandInteractionEvent event) {
        Randomizer randomizer = new Randomizer();
        Champion randomChampion = randomizer.randomizedChampion();
        OptionMapping roleOption = event.getOption("role");
        File localChampionImage = new File("src/main/resources/images/champion/" + randomChampion.getName() + ".png");
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.addField("Randomized Champion", randomChampion.getName(), true);

        if(roleOption != null) {
            embedBuilder.setTitle("Randomized Champion: " + randomChampion.getName() + " (" + roleOption.getAsString() + ")");
            embedBuilder.addField("Role", roleOption.getAsString(), true);
        }
        else {
            embedBuilder.setTitle("Randomized Champion: " + randomChampion.getName() + " (" + randomizer.randomizedRole() + ")");
            embedBuilder.addField("Role", randomizer.randomizedRole(), true);
        }

        embedBuilder.addField("Item Build: ", randomizer.randomizedFullBuild(), true);
        embedBuilder.setDescription("A random champion has been chosen for you.");
        embedBuilder.setAuthor("League of Legends Randomizer", "https://www.ultimate-bravery.net/", "https://static.wikia.nocookie.net/leagueoflegends/images/0/03/Season_2019_-_Iron_1.png");
        embedBuilder.setImage("https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + randomChampion.getName() + "_0.jpg");
        embedBuilder.setThumbnail("attachment://" + randomChampion.getName() + ".png");
        embedBuilder.setFooter("Data provided by Riot Games", "https://i.imgur.com/4Z0ZQ0x.png");
        embedBuilder.setColor(Color.GREEN);

        event.getChannel().sendMessageEmbeds(embedBuilder.build()).addFiles(FileUpload.fromData(localChampionImage,randomChampion.getName() + ".png")).queue();
    }
}
