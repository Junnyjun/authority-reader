import config.ConfigProperties;
import listeners.MessageListener;
import listeners.PingPong;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

import static net.dv8tion.jda.api.requests.GatewayIntent.*;

public class Main {
    static ConfigProperties configProperties = ConfigProperties.properties();

    public static void main(String[] args) throws LoginException {
        JDA hello = JDABuilder.createDefault(configProperties.Token())
                .enableIntents(
                        DIRECT_MESSAGES) // enables explicit access to message.getContentDisplay()
                .setActivity(Activity.watching("hello"))
                .setMaxBufferSize(Integer.MAX_VALUE)
                .setStatus(OnlineStatus.ONLINE)
                .setEnabledIntents(DIRECT_MESSAGES, GUILD_VOICE_STATES, GUILD_EMOJIS, GUILD_MESSAGES, GUILD_MESSAGE_REACTIONS,GUILD_WEBHOOKS,GUILD_MESSAGE_TYPING,GUILD_MESSAGE_TYPING)
                .build();

        hello.addEventListener(new MessageListener());
        hello.addEventListener(new PingPong());
    }
}
