@Component
public class RabbitMQProducer {

    private static final String EXCHANGE_NAME = "your_exchange_name";
    private static final String ROUTING_KEY = "your_routing_key";

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(YourMessageType message) {
        try {
            String jsonString = objectMapper.writeValueAsString(message);
            byte[] messageBytes = jsonString.getBytes(StandardCharsets.UTF_8);

            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);

            Message rabbitMessage = new Message(messageBytes, messageProperties);
            rabbitTemplate.send(EXCHANGE_NAME, ROUTING_KEY, rabbitMessage);

            System.out.println("Sent message: " + message);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
