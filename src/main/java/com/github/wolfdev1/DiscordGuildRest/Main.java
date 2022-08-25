package com.github.wolfdev1.DiscordGuildRest;


import com.github.wolfdev1.DiscordGuildRest.event.Ready;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import javax.security.auth.login.LoginException;


public class Main {

    public static JDA b;

    public static void main(String[] args) throws LoginException {

        // Final Result: http://localhost:4567/user/752585419417190511
        // Guild ID: 972346928190861342

         b = JDABuilder.createDefault(Secrets.BOT_TOKEN)
                .setStatus(OnlineStatus.ONLINE)
                 .setMemberCachePolicy(MemberCachePolicy.ALL)
                 .addEventListeners(new Ready())
                 .setChunkingFilter(ChunkingFilter.ALL)
                 .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .build();






    }
}