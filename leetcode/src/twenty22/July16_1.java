package twenty22;

public class July16_1 {
}

class Solution7_16_1 {
    public fourNode intersect(fourNode quadTree1, fourNode quadTree2) {
        if(quadTree1.isLeaf) {
            if(quadTree1.val) {
                return new fourNode(true, true);
            }
            return new fourNode(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft,quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
        }
        if(quadTree2.isLeaf) {
            return intersect(quadTree2, quadTree1);
        }
        fourNode o1 = intersect(quadTree1.topLeft, quadTree2.topLeft);
        fourNode o2 = intersect(quadTree1.topRight, quadTree2.topRight);
        fourNode o3 = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        fourNode o4 = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (o1.isLeaf && o2.isLeaf && o3.isLeaf && o4.isLeaf && o1.val == o2.val && o1.val == o3.val && o1.val == o4.val) {
            return new fourNode(o1.val, true);
        }
        return new fourNode(false, false, o1, o2, o3, o4);
    }
}