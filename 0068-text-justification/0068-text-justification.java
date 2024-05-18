class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLineLength = 0;

        for (String word : words) {
            if (currentLineLength + word.length() + currentLine.size() > maxWidth) {
                // Time to justify currentLine
                result.add(justifyLine(currentLine, currentLineLength, maxWidth, false));
                currentLine.clear();
                currentLineLength = 0;
            }
            currentLine.add(word);
            currentLineLength += word.length();
        }

        // Justify the last line
        result.add(justifyLine(currentLine, currentLineLength, maxWidth, true));
        
        return result;
    }

    private String justifyLine(List<String> line, int lineLength, int maxWidth, boolean isLastLine) {
        StringBuilder justified = new StringBuilder();
        int spacesNeeded = maxWidth - lineLength;
        int gaps = line.size() - 1;

        if (isLastLine || gaps == 0) {
            // Left justify
            for (String word : line) {
                justified.append(word).append(' ');
            }
            justified.setLength(justified.length() - 1); // Remove trailing space
            while (justified.length() < maxWidth) {
                justified.append(' ');
            }
        } else {
            // Fully justify
            int spacesPerGap = spacesNeeded / gaps;
            int extraSpaces = spacesNeeded % gaps;

            for (int i = 0; i < line.size(); i++) {
                justified.append(line.get(i));
                if (i < gaps) {
                    for (int j = 0; j < spacesPerGap; j++) {
                        justified.append(' ');
                    }
                    if (i < extraSpaces) {
                        justified.append(' ');
                    }
                }
            }
        }
        
        return justified.toString();
    }
}