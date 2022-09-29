import config.ConfigProperties;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main extends ListenerAdapter {
  static ConfigProperties configProperties = ConfigProperties.properties();

  public static void main(String[] args) throws LoginException {
    JDA jda = JDABuilder.createDefault(configProperties.Token())
        .enableIntents(
            GatewayIntent.DIRECT_MESSAGES) // enables explicit access to message.getContentDisplay()
        .build();
    //You can also add event listeners to the already built JDA instance
    // Note that some events may not be received if the listener is added after calling build()
    // This includes events such as the ReadyEvent
    jda.getPresence().setStatus(OnlineStatus.ONLINE);
    jda.addEventListener(new Main());
  }

  @Override
  public void onMessageReceived(MessageReceivedEvent event) {
    if (event.getAuthor().isBot()) {
      return;
    }

    if (event.isFromType(ChannelType.PRIVATE)) {
      System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
          event.getMessage().getContentDisplay());
    } else {
      System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
          event.getTextChannel().getName(), event.getMember().getEffectiveName(),
          event.getMessage().getContentDisplay());
    }
  }
}
