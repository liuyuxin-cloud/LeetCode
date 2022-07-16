package twenty22;

public class July15 {
}

class fourNode {
    public boolean val;
    public boolean isLeaf;
    public fourNode topLeft;
    public fourNode topRight;
    public fourNode bottomLeft;
    public fourNode bottomRight;


    public fourNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public fourNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public fourNode(boolean val, boolean isLeaf, fourNode topLeft, fourNode topRight, fourNode bottomLeft, fourNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution7_15{

    public fourNode construct(int [][] grid) {
        return dfs(grid, 0, 0,grid.length, grid.length);
    }

    public fourNode dfs(int[][] grid, int r0, int c0, int r1,int c1) {
        boolean same = true;
        for(int i = r0; i < r1; i++) {
            for(int j = c0; j < c1; j++) {
                if(grid[i][j] != grid[r0][c0]) {
                    same = false;
                    break;
                }
            }
            if(!same){
                break;
            }
        }
        if(same) {
            return new fourNode(grid[r0][c0] == 1, true);
        }

        fourNode ret = new fourNode(true, false,
                dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1 / 2)),
                dfs(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1 / 2)),
                dfs(grid, (r0 + r1) / 2, (c0 + c1 / 2), r1, c1)
                );
        return ret;
    }
}