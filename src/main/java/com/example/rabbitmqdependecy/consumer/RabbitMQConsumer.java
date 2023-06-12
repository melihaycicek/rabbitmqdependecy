@Component
public class RabbitMQConsumer {

    private static final String QUEUE_NAME = "your_queue_name";

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = QUEUE_NAME)
    public void handleMessage(Message message) {
        try {
            String jsonString = new String(message.getBody(), StandardCharsets.UTF_8);
            YourMessageType messageObject = objectMapper.readValue(jsonString, YourMessageType.class);

            // Mesajı işleme kodlarını buraya ekleyin
            System.out.println("Received message: " + messageObject);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
