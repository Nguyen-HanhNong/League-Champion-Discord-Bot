package com.nguyenhanhnong.discordbot.commands;

import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.nguyenhanhnong.discordbot.randomizer.Randomizer;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class CommandFunctionality {
    public static void randomize(@NotNull SlashCommandInteractionEvent event) {
        Randomizer randomizer = new Randomizer();
        Champion randomChampion = randomizer.randomizedChampion();
        OptionMapping roleOption = event.getOption("role");

        if(roleOption != null) {
            String role = roleOption.getAsString();
            event.reply("Your random champion is " + randomChampion.getName() + " and your role is " + role).queue();
        }
        else {
            event.reply("Your random champion is " + randomChampion.getName()).queue();
        }
    }


}
