class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        int xor = start^goal;
        while(xor != 0){
            if((xor&1) == 1) count++;
            xor = xor >> 1;
        }
        return count;
    }
}