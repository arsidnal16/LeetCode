package arraysAndString;

import java.util.ArrayList;
import java.util.List;

public class LineJustification {
	
	public static void main(String args[]) {
		String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sagittis at est nec viverra. "
				+ "Curabitur elementum ante eget nisi pellentesque dignissim. Donec quis felis velit. Cras non nulla quam. "
				+ "Vestibulum at consectetur turpis. Sed rutrum lectus vel erat elementum cursus. Curabitur sit amet diam "
				+ "iaculis, egestas diam porttitor, facilisis arcu. Suspendisse fermentum augue quam, in imperdiet odio "
				+ "luctus et. Ut facilisis, ex sit amet feugiat egestas, magna est pharetra turpis, tempor egestas "
				+ "felis mi eget nisi. Aliquam dictum erat a velit dignissim, a aliquet enim eleifend. "
				+ "Curabitur nec tincidunt urna, non mollis nisi. Suspendisse dictum molestie ex, "
				+ "ac tincidunt nisi tempus accumsan. In erat elit, hendrerit vitae semper ac, aliquet vitae "
				+ "mi. Phasellus pulvinar dui id ipsum aliquet, id elementum risus vestibulum. "
				+ "Morbi ac interdum tortor. Etiam non egestas dui.";
		
		String[] inputArr = input.split("\\s");
		
		List<String> list = fullJustify(inputArr, 25);
		
		for(String str : list) {
			System.out.println(str);
		}
		
	}
	
	
	
	
	public static List<String> fullJustify(String[] input, int lengthOfLine) {
        List<String> result = new ArrayList<String>();
        
        int index = 0;
        while (index < input.length) {
            int count = input[index].length();
            int last = index + 1;
            while (last < input.length) {
                if (input[last].length() + count + 1 > lengthOfLine) break;
                count += input[last].length() + 1;
                last++;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == input.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(input[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < lengthOfLine; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (lengthOfLine - count) / diff;
                int r = (lengthOfLine - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(input[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            result.add(builder.toString());
            index = last;
        }
        
        
        return result;
    }
	

}
