class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int forces[] = new int[n];
        int force =0;
        for(int i=0;i < n;i++) {
            if(dominoes.charAt(i) =='R') {
                force=n;
            } else if(dominoes.charAt(i) =='L') {
                force =0;
            } else {
                force = Math.max(force-1,0);
            }
            forces[i]+= force;
        }
        force =0;
        for(int i=n-1;i >=0;i--) {
            if(dominoes.charAt(i) =='R') {
                force=0;
            } else if(dominoes.charAt(i) =='L') {
                force =n;
            } else {
                force = Math.max(force-1,0);
            }
            forces[i]-= force;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i < forces.length;i++) {
            if(forces[i] > 0) {
                sb.append("R");
            } else if(forces[i] < 0) {
                sb.append("L");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}