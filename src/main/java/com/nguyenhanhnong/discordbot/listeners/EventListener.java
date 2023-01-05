package com.nguyenhanhnong.discordbot.listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("League Randomizer Bot is ready!");
        event.getJDA().getPresence().setActivity(net.dv8tion.jda.api.entities.Activity.playing("League of Legends"));
        event.getJDA().getPresence().setStatus(net.dv8tion.jda.api.OnlineStatus.ONLINE);
    }
}
