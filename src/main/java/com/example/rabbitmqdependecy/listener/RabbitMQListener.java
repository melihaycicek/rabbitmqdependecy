@Component
public class RabbitMQListener {

    private static final String QUEUE_NAME = "your_queue_name";

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = QUEUE_NAME)
    public void handleMessage(Message message) {
        try {
            String jsonString = new String(message.getBody(), StandardCharsets.UTF_8);
            YourMessageType receivedMessage = objectMapper.readValue(jsonString, YourMessageType.class);

            // Mesajı işleyin
            System.out.println("Received message: " + receivedMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
