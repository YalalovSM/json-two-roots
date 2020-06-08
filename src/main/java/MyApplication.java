import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyApplication {
    public static void main(String[] args) throws JsonProcessingException {
        final String source = "{\n" +
                "  \"user\":\n" +
                "    {\n" +
                "      \"name\":\"Sam Smith\",\n" +
                "      \"age\":1\n" +
                "    },\n" +
                "  \"timestamp\":\n" +
                "    {\n" +
                "      \"clickpoint\":\"AE12\",\n" +
                "      \"purchasable\":\"false\"\n" +
                "    }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.reader().readTree(source);

        User user = mapper.treeToValue(node.get("user"), User.class);
        Timestamp timestamp = mapper.treeToValue(node.get("timestamp"), Timestamp.class);

        System.out.println(user.getName());
        System.out.println(timestamp.getClickpoint());
    }
}
