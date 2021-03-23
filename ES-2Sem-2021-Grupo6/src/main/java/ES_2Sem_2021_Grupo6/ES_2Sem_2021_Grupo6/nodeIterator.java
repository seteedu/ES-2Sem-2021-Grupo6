package ES_2Sem_2021_Grupo6.ES_2Sem_2021_Grupo6;

import com.github.javaparser.ast.Node;

public class nodeIterator {
    public interface NodeHandler {
        boolean handle(Node node);
    }
    private NodeHandler nodeHandler;
    public nodeIterator(NodeHandler nodeHandler) {
        this.nodeHandler = nodeHandler;
    }
    public void explore(Node node) {
        if (nodeHandler.handle(node)) {
            for (Node child : node.getChildNodes()) {
                explore(child);
            }
        }
    }
}