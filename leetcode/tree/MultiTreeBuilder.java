package leetcode.tree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import leetcode.DFSBFS.Node;

import java.util.Iterator;
import java.util.List;

public class MultiTreeBuilder {
    String s;
    private Node root;

    public static void main(String[] args) throws JsonProcessingException {
        String s = "{\"$id\":\"1\",\"children\":[{\"$id\":\"2\",\"children\":[{\"$id\":\"5\",\"children\":[],\"val\":5},{\"$id\":\"6\",\"children\":[],\"val\":6}],\"val\":3},{\"$id\":\"3\",\"children\":[],\"val\":2},{\"$id\":\"4\",\"children\":[],\"val\":4}],\"val\":1}";
        new MultiTreeBuilder().String2Tree(s);
    }

    /**
     * @param s {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
     * @return
     */
    private Node String2Tree(String s) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(s);
        root = JsonNode2NodeTree(jsonNode);
        return root;
    }

    private Node JsonNode2NodeTree(JsonNode jsonNode) {
        Node node = new Node();
        Iterator<String> fields = jsonNode.fieldNames();
        while (fields.hasNext()) {
            fields.next();
            List<JsonNode> children = jsonNode.get(fields.next()).findValues("children");
            children = children.get(0).findValues("children");
            for (JsonNode jNode : children) {
                Node child = JsonNode2NodeTree(jNode);
                node.children.add(child);

            }
            node.val = jsonNode.get(fields.next()).intValue();
        }
        return node;
    }
}
