package com.nguyenhanhnong.discordbot;

import com.nguyenhanhnong.discordbot.commands.CommandManager;
import com.nguyenhanhnong.discordbot.listeners.EventListener;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class LeagueBot {

    private final ShardManager shardManager;
    private final Dotenv config;
    public LeagueBot() throws LoginException {
        config = Dotenv.configure().ignoreIfMalformed().load();
        String token = config.get("DISCORD_BOT_TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching(" for commands from League of Legends players"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT);

        /* Cache all members and users of the bot */
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.enableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);

        shardManager = builder.build();

        //Register listeners
        shardManager.addEventListener(new EventListener(), new CommandManager());
    }

    public ShardManager getShardManager() {
        return shardManager;
    }
    public Dotenv getConfig() {
        return config;
    }

    public static void main(String[] args) {
        try {
            LeagueBot testBot = new LeagueBot();
        } catch (LoginException e) {
            System.out.println("ERROR: Provided bot token is invalid");
            e.printStackTrace();
        }
    }
}
