class Solution {
    class Tuple{
        int nodeChar;
        long cost;
        Tuple(long cost,int nodeChar){
            this.cost=cost;
            this.nodeChar=nodeChar;
        }
    }
    long[] dijkstra(int startChar,List<int[]>[]adjList){
        
        // Priority queue to store characters with their conversion cost, sorted by cost
        PriorityQueue<Tuple>queue=new PriorityQueue<>((t1,t2)->Long.compare(t1.cost,t2.cost));
        
        //Array to store the minimum conversion cost to each character
        long[]minCosts=new long[26];
        //Initialize all costs to -1 (unreachable)
        Arrays.fill(minCosts,-1L);

        queue.add(new Tuple(0L,startChar));
        while(!queue.isEmpty()){
            Tuple current=queue.poll();
            long currentCost=current.cost;
            int currentChar =current.nodeChar;
            //explore all possible converions form the current character
            for(int[]conversion:adjList[currentChar]){
                int targetChar=conversion[0];
                long conversionCost=conversion[1];
                long newTotalCost=currentCost+conversionCost;
                //if we found a cheaper conversion ,update its cost
                if(minCosts[targetChar]==-1L || newTotalCost<minCosts[targetChar]){
                    minCosts[targetChar]=newTotalCost;
                    queue.add(new Tuple(newTotalCost,targetChar));
                }
            }
        }
        return minCosts;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        //make graph {a->{[b,2],[c,4],b->{[],[]}..}
        List<int[]>[]adjList=new List[26];
        for(int i=0;i<26;i++){
            adjList[i]=new ArrayList<>();
        }
        for(int i=0;i<original.length;i++){
            adjList[original[i]-'a'].add(new int[]{changed[i]-'a',cost[i]});
        }

        //find minimum cost to convert each charcter to all other character example a to b,a to c and so on
        //or calculate shorted paths for all possible charcter conversions
        long[][]minConversionCosts=new long[26][26];
        for(int i=0;i<26;i++){
            minConversionCosts[i]=dijkstra(i,adjList);
        }

        //calculate the total cost of converiong sorce to target

        long totalCost=0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                long charConversionCost=minConversionCosts[source.charAt(i)-'a'][target.charAt(i)-'a'];
                if(charConversionCost==-1){
                    return -1;//conversion not possible
                }
                totalCost+=charConversionCost;
            }
        }
        return totalCost;
    }
}