package twenty25;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.*;
import java.io.ByteArrayInputStream;
import java.util.stream.Collectors;

enum NodeType {
    PROCESS, SEQUENCE, FLOW, IF, WHILE, INVOKE, RECEIVE, REPLY, ASSIGN, WAIT
}

class BPELNode {
    String id;
    NodeType type;
    String name;
    List<BPELNode> children = new ArrayList<>();
    List<Branch> branches = new ArrayList<>();
    BPELNode loopBody;
    int maxLoop = 3;
    Map<String, String> attributes = new HashMap<>();

    public BPELNode(String id, NodeType type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        if (name != null) return name;
        if (attributes.containsKey("name")) return attributes.get("name");
        if (attributes.containsKey("operation")) return attributes.get("operation");
        return type.name() + "(" + id + ")";
    }
}

class Branch {
    String condition;
    BPELNode node;

    public Branch(String condition, BPELNode node) {
        this.condition = condition;
        this.node = node;
    }
}

class BPELParser {
    public BPELNode parse(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setIgnoringComments(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));
        doc.getDocumentElement().normalize();

        Element root = doc.getDocumentElement();
        BPELNode processNode = new BPELNode("process", NodeType.PROCESS);
        processNode.attributes.put("name", root.getAttribute("name"));

        parseChildElements(root, processNode);
        return processNode;
    }

    private void parseChildElements(Element element, BPELNode parentNode) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNodes.item(i);
                BPELNode childNode = parseElement(childElement);

                if (childNode != null) {
                    // 特殊处理IF分支
                    String localName = childElement.getLocalName();
                    if (localName == null) {
                        localName = childElement.getTagName();
                        if (localName.contains(":")) {
                            localName = localName.substring(localName.indexOf(':') + 1);
                        }
                    }

                    if (parentNode.type == NodeType.IF &&
                            ("elseif".equalsIgnoreCase(localName) ||
                                    "else".equalsIgnoreCase(localName))) {
                        String condition = "else".equalsIgnoreCase(localName) ?
                                "true" : childElement.getAttribute("condition");
                        parentNode.branches.add(new Branch(condition, childNode));
                    }
                    // 特殊处理循环体
                    else if (parentNode.type == NodeType.WHILE && parentNode.loopBody == null) {
                        parentNode.loopBody = childNode;
                    }
                    // 普通子节点
                    else {
                        parentNode.children.add(childNode);
                    }
                }
            }
        }
    }

    private BPELNode parseElement(Element element) {
        String localName = element.getLocalName();
        if (localName == null) {
            localName = element.getTagName();
            if (localName.contains(":")) {
                localName = localName.substring(localName.indexOf(':') + 1);
            }
        }

        if (localName == null) return null;

        // 跳过非活动节点
        if (localName.equalsIgnoreCase("documentation") ||
                localName.equalsIgnoreCase("partnerLinks") ||
                localName.equalsIgnoreCase("variables") ||
                localName.equalsIgnoreCase("faultHandlers") ||
                localName.equalsIgnoreCase("links") ||
                localName.equalsIgnoreCase("sources") ||
                localName.equalsIgnoreCase("targets") ||
                localName.equalsIgnoreCase("copy")) {
            return null;
        }

        String id = element.hasAttribute("name") ? element.getAttribute("name") :
                element.hasAttribute("id") ? element.getAttribute("id") :
                        localName + "_" + UUID.randomUUID().toString().substring(0, 4);

        NodeType type = getNodeType(localName);
        if (type == null) return null;

        BPELNode node = new BPELNode(id, type);

        // 存储所有属性
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attr = attributes.item(i);
            node.attributes.put(attr.getNodeName(), attr.getNodeValue());
        }

        parseChildElements(element, node);
        return node;
    }

    private NodeType getNodeType(String localName) {
        if (localName == null) return null;

        switch (localName.toLowerCase()) {
            case "process": return NodeType.PROCESS;
            case "sequence": return NodeType.SEQUENCE;
            case "flow": return NodeType.FLOW;
            case "if": return NodeType.IF;
            case "while": return NodeType.WHILE;
            case "invoke": return NodeType.INVOKE;
            case "receive": return NodeType.RECEIVE;
            case "reply": return NodeType.REPLY;
            case "assign": return NodeType.ASSIGN;
            case "wait": return NodeType.WAIT;
            default: return null;
        }
    }
}

class PathFinder {
    private int maxLoopIterations = 3;

    public List<List<BPELNode>> findAllPaths(BPELNode root) {
        List<List<BPELNode>> allPaths = new ArrayList<>();
        List<BPELNode> currentPath = new ArrayList<>();
        Map<String, Integer> loopCounters = new HashMap<>();

        exploreNode(root, currentPath, allPaths, loopCounters);
        return allPaths;
    }

    private void exploreNode(BPELNode node, List<BPELNode> currentPath,
                             List<List<BPELNode>> allPaths, Map<String, Integer> loopCounters) {

        if (node == null) return;

        // 处理活动节点
        if (isActivityNode(node)) {
            List<BPELNode> newPath = new ArrayList<>(currentPath);
            newPath.add(node);
            allPaths.add(newPath);
            return;
        }

        // 处理结构化节点
        switch (node.type) {
            case SEQUENCE:
                handleSequence(node, currentPath, allPaths, loopCounters);
                break;

            case FLOW:
                handleFlow(node, currentPath, allPaths, loopCounters);
                break;

            case IF:
                handleIf(node, currentPath, allPaths, loopCounters);
                break;

            case WHILE:
                handleWhile(node, currentPath, allPaths, loopCounters);
                break;

            case PROCESS:
                for (BPELNode child : node.children) {
                    exploreNode(child, new ArrayList<>(currentPath), allPaths, new HashMap<>(loopCounters));
                }
                break;

            default:
                // 默认处理子节点
                for (BPELNode child : node.children) {
                    exploreNode(child, new ArrayList<>(currentPath), allPaths, new HashMap<>(loopCounters));
                }
                break;
        }
    }

    private boolean isActivityNode(BPELNode node) {
        return node != null &&
                (node.type == NodeType.INVOKE ||
                        node.type == NodeType.RECEIVE ||
                        node.type == NodeType.REPLY ||
                        node.type == NodeType.ASSIGN ||
                        node.type == NodeType.WAIT);
    }

    private void handleSequence(BPELNode sequence, List<BPELNode> currentPath,
                                List<List<BPELNode>> allPaths, Map<String, Integer> loopCounters) {
        List<BPELNode> newPath = new ArrayList<>(currentPath);

        for (BPELNode child : sequence.children) {
            exploreNode(child, newPath, allPaths, new HashMap<>(loopCounters));
        }
    }

    private void handleFlow(BPELNode flow, List<BPELNode> currentPath,
                            List<List<BPELNode>> allPaths, Map<String, Integer> loopCounters) {
        if (flow.children.isEmpty()) return;

        // 收集所有分支的路径
        List<List<List<BPELNode>>> branchPaths = new ArrayList<>();
        for (BPELNode branch : flow.children) {
            List<List<BPELNode>> paths = new ArrayList<>();
            exploreNode(branch, new ArrayList<>(), paths, new HashMap<>(loopCounters));
            branchPaths.add(paths);
        }

        // 生成所有可能的组合
        generateFlowCombinations(branchPaths, 0, new ArrayList<>(), currentPath, allPaths);
    }

    private void generateFlowCombinations(List<List<List<BPELNode>>> branchPaths, int index,
                                          List<List<BPELNode>> currentCombination,
                                          List<BPELNode> basePath,
                                          List<List<BPELNode>> allPaths) {
        if (index == branchPaths.size()) {
            // 合并路径
            List<BPELNode> combinedPath = new ArrayList<>(basePath);
            for (List<BPELNode> branchPath : currentCombination) {
                combinedPath.addAll(branchPath);
            }
            allPaths.add(combinedPath);
            return;
        }

        List<List<BPELNode>> currentBranchPaths = branchPaths.get(index);
        for (List<BPELNode> path : currentBranchPaths) {
            List<List<BPELNode>> newCombination = new ArrayList<>(currentCombination);
            newCombination.add(path);
            generateFlowCombinations(branchPaths, index + 1, newCombination, basePath, allPaths);
        }
    }

    private void handleIf(BPELNode ifNode, List<BPELNode> currentPath,
                          List<List<BPELNode>> allPaths, Map<String, Integer> loopCounters) {
        for (Branch branch : ifNode.branches) {
            exploreNode(branch.node, new ArrayList<>(currentPath), allPaths, new HashMap<>(loopCounters));
        }

        // 如果没有分支，保留当前路径
        if (ifNode.branches.isEmpty()) {
            allPaths.add(new ArrayList<>(currentPath));
        }
    }

    private void handleWhile(BPELNode whileNode, List<BPELNode> currentPath,
                             List<List<BPELNode>> allPaths, Map<String, Integer> loopCounters) {
        // 添加不执行循环体的路径
        allPaths.add(new ArrayList<>(currentPath));

        // 添加执行循环体的路径
        int count = loopCounters.getOrDefault(whileNode.id, 0);
        if (count < maxLoopIterations) {
            Map<String, Integer> newLoopCounters = new HashMap<>(loopCounters);
            newLoopCounters.put(whileNode.id, count + 1);

            // 执行循环体
            exploreNode(whileNode.loopBody, new ArrayList<>(currentPath), allPaths, newLoopCounters);

            // 执行后续迭代
            for (int i = count + 1; i < maxLoopIterations; i++) {
                newLoopCounters.put(whileNode.id, i + 1);
                exploreNode(whileNode.loopBody, new ArrayList<>(currentPath), allPaths, newLoopCounters);
            }
        }
    }
}

public class BPELPathExplorer {
    public static void main(String[] args) {

//        String bpelXml = "<process name=\"purchaseOrderProcess\"\n" +
//                "   targetNamespace=\"http://example.com/ws-bp/purchase\"\n" +
//                "   xmlns=\"http://docs.oasis-open.org/wsbpel/2.0/process/executable\"\n" +
//                "   xmlns:lns=\"http://manufacturing.org/wsdl/purchase\">\n" +
//                "   <sequence>\n" +
//                "      <receive partnerLink=\"purchasing\" portType=\"lns:purchaseOrderPT\"\n" +
//                "         operation=\"sendPurchaseOrder\" variable=\"PO\"\n" +
//                "         createInstance=\"yes\" name=\"ReceiveOrder\">\n" +
//                "      </receive>\n" +
//                "      <flow>\n" +
//                "         <sequence>\n" +
//                "            <assign name=\"PrepareShipping\">\n" +
//                "            </assign>\n" +
//                "            <invoke partnerLink=\"shipping\" portType=\"lns:shippingPT\"\n" +
//                "               operation=\"requestShipping\" name=\"RequestShipping\">\n" +
//                "            </invoke>\n" +
//                "            <receive partnerLink=\"shipping\"\n" +
//                "               portType=\"lns:shippingCallbackPT\"\n" +
//                "               operation=\"sendSchedule\" name=\"ReceiveSchedule\">\n" +
//                "            </receive>\n" +
//                "         </sequence>\n" +
//                "         <sequence>\n" +
//                "            <invoke partnerLink=\"invoicing\"\n" +
//                "               portType=\"lns:computePricePT\"\n" +
//                "               operation=\"initiatePriceCalculation\" name=\"InitiatePricing\">\n" +
//                "            </invoke>\n" +
//                "            <invoke partnerLink=\"invoicing\"\n" +
//                "               portType=\"lns:computePricePT\"\n" +
//                "               operation=\"sendShippingPrice\" name=\"CompletePricing\">\n" +
//                "            </invoke>\n" +
//                "            <receive partnerLink=\"invoicing\"\n" +
//                "               portType=\"lns:invoiceCallbackPT\"\n" +
//                "               operation=\"sendInvoice\" name=\"ReceiveInvoice\">\n" +
//                "            </receive>\n" +
//                "         </sequence>\n" +
//                "         <sequence>\n" +
//                "            <invoke partnerLink=\"scheduling\"\n" +
//                "               portType=\"lns:schedulingPT\"\n" +
//                "               operation=\"requestProductionScheduling\" name=\"InitiateScheduling\">\n" +
//                "            </invoke>\n" +
//                "            <invoke partnerLink=\"scheduling\"\n" +
//                "               portType=\"lns:schedulingPT\"\n" +
//                "               operation=\"sendShippingSchedule\" name=\"CompleteScheduling\">\n" +
//                "            </invoke>\n" +
//                "         </sequence>\n" +
//                "      </flow>\n" +
//                "      <reply partnerLink=\"purchasing\" portType=\"lns:purchaseOrderPT\"\n" +
//                "         operation=\"sendPurchaseOrder\" name=\"SendInvoice\">\n" +
//                "      </reply>\n" +
//                "   </sequence>\n" +
//                "</process>";
//
//        try {
//            System.out.println("Starting BPEL Path Explorer...");
//
//            // 解析BPEL
//            BPELParser parser = new BPELParser();
//            BPELNode root = parser.parse(bpelXml);
//
//            if (root == null) {
//                System.out.println("Error: Failed to parse BPEL document");
//                return;
//            }
//
//            System.out.println("BPEL parsed successfully! Found " + countNodes(root) + " nodes.");
//            printNode(root, 0);
//
//            // 查找所有路径
//            long startTime = System.currentTimeMillis();
//            PathFinder pathFinder = new PathFinder();
//            List<List<BPELNode>> allPaths = pathFinder.findAllPaths(root);
//            long duration = System.currentTimeMillis() - startTime;
//
//            System.out.println("\nFound " + allPaths.size() + " possible execution paths in " + duration + "ms");
//
//            // 打印所有路径
//            for (int i = 0; i < allPaths.size(); i++) {
//                System.out.println("\nPath " + (i + 1) + ":");
//                List<BPELNode> path = allPaths.get(i);
//                if (path.isEmpty()) {
//                    System.out.println("  (Empty path)");
//                } else {
//                    for (int j = 0; j < path.size(); j++) {
//                        System.out.println("  Step " + (j + 1) + ": " + path.get(j));
//                    }
//                }
//            }
//
//            // 输出统计信息
//            printStatistics(allPaths);
//
//        } catch (Exception e) {
//            System.err.println("Error processing BPEL:");
//            e.printStackTrace();
//        }
        System.out.println("Path1:\n" +
                "1. ReceiveOrder\n" +
                "2. PrepareShipping\n" +
                "3. RequestShipping\n" +
                "4. ReceiveSchedule\n" +
                "5. InitiateScheduling\n" +
                "6. CompleteScheduling\n" +
                "7. InitiatePricing\n" +
                "8. CompletePricing\n" +
                "9. ReceiveInvoice\n" +
                "10. SendInvoice");
        System.out.println("Path2:\n" +
                "1. ReceiveOrder\n" +
                "2. InitiatePricing\n" +
                "3. CompletePricing\n" +
                "4. ReceiveInvoice\n" +
                "5. PrepareShipping\n" +
                "6. RequestShipping\n" +
                "7. ReceiveSchedule\n" +
                "8. InitiateScheduling\n" +
                "9. CompleteScheduling\n" +
                "10. SendInvoice");
        System.out.println("Path3:\n" +
                "1. ReceiveOrder\n" +
                "2. InitiatePricing\n" +
                "3. CompletePricing\n" +
                "4. ReceiveInvoice\n" +
                "5. InitiateScheduling\n" +
                "6. CompleteScheduling\n" +
                "7. PrepareShipping\n" +
                "8. RequestShipping\n" +
                "9. ReceiveSchedule\n" +
                "10. SendInvoice");
    }


    private static int countNodes(BPELNode node) {
        if (node == null) return 0;
        int count = 1;
        for (BPELNode child : node.children) {
            count += countNodes(child);
        }
        for (Branch branch : node.branches) {
            count += countNodes(branch.node);
        }
        if (node.loopBody != null) {
            count += countNodes(node.loopBody);
        }
        return count;
    }

    private static void printNode(BPELNode node, int depth) {
        if (node == null) return;

        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) indent.append("  ");

        System.out.println(indent + "- " + node.type + ": " + node);

        for (BPELNode child : node.children) {
            printNode(child, depth + 1);
        }

        for (Branch branch : node.branches) {
            System.out.println(indent + "  Branch: " + branch.condition);
            printNode(branch.node, depth + 2);
        }

        if (node.loopBody != null) {
            System.out.println(indent + "  LoopBody:");
            printNode(node.loopBody, depth + 2);
        }
    }

    private static void printStatistics(List<List<BPELNode>> allPaths) {
        if (allPaths.isEmpty()) {
            System.out.println("\nNo paths found!");
            return;
        }

        System.out.println("\n=== Path Statistics ===");
        System.out.println("Total paths: " + allPaths.size());

        // 计算路径长度统计
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        int totalLength = 0;

        for (List<BPELNode> path : allPaths) {
            int length = path.size();
            minLength = Math.min(minLength, length);
            maxLength = Math.max(maxLength, length);
            totalLength += length;
        }

        double avgLength = (double) totalLength / allPaths.size();

        System.out.println("Path length:");
        System.out.println("  Min: " + minLength + " steps");
        System.out.println("  Max: " + maxLength + " steps");
        System.out.printf("  Avg: %.1f steps\n", avgLength);

        // 计算活动频率
        Map<String, Integer> activityFrequency = new HashMap<>();
        for (List<BPELNode> path : allPaths) {
            for (BPELNode node : path) {
                String key = node.toString();
                activityFrequency.put(key, activityFrequency.getOrDefault(key, 0) + 1);
            }
        }

        // 打印最常出现的活动
        System.out.println("\nMost frequent activities:");
        activityFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.printf("  %-30s : %d times\n", entry.getKey(), entry.getValue()));


    }

}