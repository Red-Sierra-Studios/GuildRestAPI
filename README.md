# Discord Guild | Rest API

A set of scripts to create a server that sends responses to multiple requests on your discord guild


**⚔️ How to use**
- You simply have to clone the remote repository on your computer with the following command

```
git clone https://github.com/Red-Sierra-Studios/DiscordGuildRestAPI.git
```
- Then, in the project directory run `gradle build`, this will start the process to run the program. Normally it will throw you an exception when not finding a token or valid guild id, to correct this you have to modify the class called "Secrets" and put your token that you got in the Discord developers page 
```java
public class Secrets {

    public static final String BOT_TOKEN = "HERE YOUR TOKEN";
    public static double userxp(Member member) {
        double fi = 1.00;
        return fi;
    }
}
```
- Once this is done, go to the Ready class where you will find the following methods to put the id of your GUILD
 ```java
 public void onReady(ReadyEvent event) {
        UserEndpoint userEndpoint = new UserEndpoint();
        userEndpoint.startEndpoint(Here your guild id);

        GuildEndpoint guildEndpoint = new GuildEndpoint();
        guildEndpoint.startEndpoint(Here your guild id);
    }
```
- And ready! Now you can run `gradle build` to execute your Rest API
