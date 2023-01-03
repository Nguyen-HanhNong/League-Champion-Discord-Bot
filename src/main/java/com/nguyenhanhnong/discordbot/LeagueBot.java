package com.nguyenhanhnong.discordbot;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManager;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;


public class LeagueBot {

    private final ShardManager shardManager;

    public LeagueBot() throws LoginException {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("DISCORD_BOT_TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Waiting for commands from League of Legends players"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
