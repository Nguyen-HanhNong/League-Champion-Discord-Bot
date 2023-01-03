package com.nguyenhanhnong.discordbot.commands;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    public List<CommandData> initializeAllCommands() {
        List<CommandData> commandData = new ArrayList<>();

        OptionData roleOption = new OptionData(OptionType.STRING, "role", "The role you want to randomize", false).addChoice("Top", "Top").addChoice("Jungle", "Jungle").addChoice("Mid", "Mid").addChoice("ADC", "ADC").addChoice("Support", "Support");
        commandData.add(Commands.slash("randomize", "Return a randomized champion.").addOptions(roleOption));

        return commandData;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
       String commandName = event.getName();

       if(commandName.equals("randomize")) {
           CommandFunctionality.randomize(event);
       }
       else {
           event.reply("Command not found").queue();
       }
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        event.getGuild().updateCommands().addCommands(initializeAllCommands()).queue();
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        event.getGuild().updateCommands().addCommands(initializeAllCommands()).queue();
    }
}
