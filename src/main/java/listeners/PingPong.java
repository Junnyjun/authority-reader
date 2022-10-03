package listeners;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingPong extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("시로님"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("살려내..")
                    .queue(r1 -> r1.editMessageFormat("MR HAN은 죽은 서버를 살려내라")
                    .queue(r2 -> r2.editMessageFormat("당신이 즉였잖아")
                    .queue(r3 -> r3.editMessageFormat("2022 10 02 1643 REMEBER")
                    .queue(r4 -> r4.editMessageFormat("서버를 추모하라 ")
                            .queue(response2 -> response2.editMessageFormat("살려내..").queue())))));
        }
    }

}
