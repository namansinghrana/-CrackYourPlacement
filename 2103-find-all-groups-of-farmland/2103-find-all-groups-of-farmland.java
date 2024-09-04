class Solution {
    int bottom_i, bottom_j;
    
    public void dfs(int[][] land, int i, int j)
    {
        if(i==land.length || j==land[0].length || land[i][j] ==0){
            return;
        }
        land[i][j]=0;
        bottom_i = Math.max(i, bottom_i);
        bottom_j = Math.max(j, bottom_j);
        dfs(land, i+1, j);
        dfs(land, i, j+1);
    }
    
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> lists = new ArrayList<>();

        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 1){
                    bottom_i=i;
                    bottom_j=j;
                    dfs(land,i,j);
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    list.add(bottom_i);
                    list.add(bottom_j);
                    lists.add(list);
                }
            }   
        }
        int size = lists.size();
        int[][] res = new int[size][4];
        int i=0;

        for(List<Integer> list : lists){
            res[i][0] = list.get(0);
            res[i][1] = list.get(1);
            res[i][2] = list.get(2);
            res[i][3] = list.get(3);
            i++;
        }

        return res;
    }
}