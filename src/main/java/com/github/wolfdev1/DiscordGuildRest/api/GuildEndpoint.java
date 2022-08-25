package com.github.wolfdev1.DiscordGuildRest.api;

import net.dv8tion.jda.api.entities.Guild;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static com.github.wolfdev1.DiscordGuildRest.Main.b;
import static spark.Spark.get;

public class GuildEndpoint {

    public void startEndpoint(long guild_id) {

        Guild g = b.getGuildById(guild_id);

        assert g != null;
        get("/guild", (req, res) -> {

            res.type("application/json");
            return getJsonString(g);
        });
    }

    private String getJsonString(Guild guild) {
        JSONObject o = new JSONObject();
        o.put("id", guild.getId());
        o.put("name", guild.getName());
        o.put("ownerId", guild.getOwner().getId());
        o.put("ownerName", guild.getOwner().getUser().getAsTag());

        JSONArray l = new JSONArray();
        for (int i = 0; i < guild.getTextChannels().size(); i++) {
            l.add(guild.getTextChannels().get(i).getId());
        }
        o.put("textChannels", (guild.getTextChannels().size() < 1 ? "No channels" : l));

        JSONArray lv = new JSONArray();
        for (int i = 0; i < guild.getVoiceChannels().size(); i++) {
            lv.add(guild.getVoiceChannels().get(i).getId());
        }
        o.put("voiceChannels", (guild.getVoiceChannels().size() < 1 ? "No voice channels" : lv));

        JSONArray le = new JSONArray();
        for (int i = 0; i < guild.getEmojis().size(); i++) {
            le.add(guild.getEmojis().get(i).getName());
        }
        o.put("emojis", (guild.getEmojis().size() < 1 ? "No emojis" : le));

        return o.toJSONString();
    }

}
