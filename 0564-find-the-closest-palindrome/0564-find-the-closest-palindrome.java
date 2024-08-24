class Solution {
    public String nearestPalindromic(String n) {
        long ip = Long.valueOf(n);
        long small = smallest(String.valueOf(ip-1));
        long large = larger(String.valueOf(ip+1));
        if(large - ip < ip - small) return String.valueOf(large);
        else return String.valueOf(small);
        
    }

    private long larger(String n) {
        char[] data = n.toCharArray();
        int start = 0;
        int end = data.length-1;
        while(start < end) {
            while(data[start] != data[end]) {
                incrementNumber(data,end);
            }
            start++;
            end--;
        }
        return Long.parseLong(String.valueOf(data));
    }

    private long smallest(String n) {
        char[] data = n.toCharArray();
        int start = 0;
        int end = data.length-1;
        while(start < end) {
            while(data[start] != data[end]) {
                decrementNumber(data, end);
                if(data[0] == '0') return Long.parseLong(String.valueOf(data));
            }
            start++;
            end--;
        }
        return Long.parseLong(String.valueOf(data));
    }

    private void decrementNumber(char[] data, int i) {
        while(data[i] == '0') {
            data[i] = '9';
            i--;
        }
        data[i]--;
    }

    private void incrementNumber(char[] data, int i) {
        while(data[i] == '9') {
            data[i] = '0';
            i--;
        }
        data[i]++;
    }
}