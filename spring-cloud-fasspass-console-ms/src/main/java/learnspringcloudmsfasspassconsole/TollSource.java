package learnspringcloudmsfasspassconsole;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TollSource {

	@Output("fasspasschannel")
	MessageChannel fassPassToll();

	@Output("standardchannel")
	MessageChannel standardToll();

}
