package com.github.wolfdev1.DiscordGuildRest.event;

import com.github.wolfdev1.DiscordGuildRest.api.GuildEndpoint;
import com.github.wolfdev1.DiscordGuildRest.api.UserEndpoint;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ready extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        UserEndpoint userEndpoint = new UserEndpoint();
        userEndpoint.startEndpoint(972346928190861342L);

        GuildEndpoint guildEndpoint = new GuildEndpoint();
        guildEndpoint.startEndpoint(972346928190861342L);
    }

}
