package twenty25;

/**
 * 加油站
 */
public class April26 {
}

class Solution4_26 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int minGas = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            spare = spare + gas[i] - cost[i];
            if (spare < minGas) {
                minGas = spare;
                index = i + 1;
            }
        }
        return spare < 0 ? -1 : index % gas.length;
    }
}