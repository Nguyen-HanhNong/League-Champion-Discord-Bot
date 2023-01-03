package com.nguyenhanhnong.discordbot.listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        User user = event.getUser();
        String emoji = event.getReaction().getEmoji().getAsReactionCode();
        String channelMention = event.getChannel().getAsMention();
        String jumpLink = event.getJumpUrl();

        String message = user.getAsTag() + " reacted with " + emoji + " to a message in " + channelMention + ":\n" + jumpLink;
        event.getGuild().getDefaultChannel().asTextChannel().sendMessage(message).queue();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if(message.contains("pong")) {
            event.getChannel().sendMessage("ping").queue();
        }
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        String avatar = event.getUser().getEffectiveAvatarUrl();
        System.out.println(avatar);
    }
}
