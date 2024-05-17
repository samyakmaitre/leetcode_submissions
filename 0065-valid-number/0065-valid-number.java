class Solution {
    public boolean isNumber(String s) {
        // Define the regex pattern
        String regex = "^[-+]?((\\d+\\.\\d*)|(\\.\\d+)|(\\d+))(?:[eE][-+]?\\d+)?$";
        
        // Return if the string matches the regex pattern
        return s.matches(regex);
    }
}