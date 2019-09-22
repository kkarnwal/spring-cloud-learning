package learnspringcloudmsfasspassconsole;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@EnableBinding(TollSource.class)
public class TollPublisher {

	Random rand = new Random();

//	@InboundChannelAdapter(channel = "fasspasschannel", poller = @Poller(fixedDelay = "2000"))
	public Message<Toll> sendTollChanrge() {
		return MessageBuilder.withPayload(new Toll("20", "100", "2017-07-12T12:04:00"))
				.setHeader("speed", rand.nextInt(8) * 10).build();
//		return "{stationId: \"20\",customerId: \"100\",timestamp: \"2019-08-04T13:51:04.838Z\"}";
	}

	class Toll {
		public String stationId;
		public String customerId;
		public String timestamp;

		public Toll(String StationId, String CustomerId, String Timestamp) {
			this.stationId = StationId;
			this.customerId = CustomerId;
			this.timestamp = Timestamp;
		}
	}
}
