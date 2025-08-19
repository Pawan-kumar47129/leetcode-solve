class Solution {
    
    double operation(double num1,double num2,int index){
        if(index==1) return num1+num2;
        if(index==2) return num1-num2;
        if(index==3) return num1*num2;
        if(index==4) return num1/num2;
        if(index==5) return num2-num1;
        if(index==6) return num2/num1;
        return 0;

    }
    private boolean solve(List<Double>nums){
        if(nums.size()==1){
            return Math.abs(nums.get(0) - 24) < 1e-6; // tolerance check
        }
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                if(i==j)continue;
                double a=nums.get(i);
                double b=nums.get(j);
                List<Double>newList=new ArrayList<>();
                for(int k=0;k<nums.size();k++){
                    if(k!=i && k!=j) newList.add(nums.get(k));
                }
                for(int index=1;index<=6;index++){
                    newList.add(operation(a,b,index));
                    if(solve(newList)) return true;
                    newList.remove(newList.size()-1);
                }
            }
        }
        return false;
    }
    public boolean judgePoint24(int[] cards) {
        List<Double>nums=new ArrayList<>();
        for(var card:cards){
            double value=(double)card;
            nums.add(value);
        }
        return solve(nums);
    }
}