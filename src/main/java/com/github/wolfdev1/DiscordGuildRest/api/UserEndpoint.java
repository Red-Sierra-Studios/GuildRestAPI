package com.github.wolfdev1.DiscordGuildRest.api;

import com.github.wolfdev1.DiscordGuildRest.Secrets;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.OffsetDateTime;

import static com.github.wolfdev1.DiscordGuildRest.Main.b;
import static spark.Spark.get;

@SuppressWarnings("all")

public class UserEndpoint {

    public void startEndpoint(long guild_id) {
        Guild g = b.getGuildById(guild_id);

            get("/user", (req, res) -> {
               JSONObject object = new JSONObject();
                object.put("message", "You need to provide a valid user id ({address}/user/id)");
                object.put("status", "UNAVAILABLE");
                object.put("code", "404");

                res.type("application/json");
                return object.toJSONString();
            });

            get("/user/:id", (req, res) -> {
                if(g.getMemberById(req.params("id")) == null) {
                    JSONObject obj = new JSONObject();
                    obj.put("message", "The user with id " + req.params("id") + " does not exist");
                    obj.put("status", "UNAVAILABLE");
                    obj.put("code", "404");

                    res.type("application/json");
                    return obj.toJSONString();
                } else {
                    Member m = g.getMemberById(req.params("id"));
                    assert m != null;
                    return getJsonString(m);
                }});
    }
    private String getJsonString(Member member) {
        JSONObject o = new JSONObject();
        o.put("id", member.getId());
        o.put("tag", member.getUser().getAsTag());

        JSONArray l = new JSONArray();
        for (int i = 0; i < member.getRoles().size(); i++) { l.add(member.getRoles().get((i)).getId()); }

        o.put("roles", (member.getRoles().size() < 1 ? "No roles" : l));
        OffsetDateTime ofdt = member.getTimeJoined();
        o.put("joinedAt", ofdt.getYear() + "-" + ofdt.getMonthValue() + "-" + ofdt.getDayOfMonth());
        o.put("hasBoost", member.isBoosting());
        o.put("rank", Secrets.userxp(member));

        return o.toJSONString();
    }
}
