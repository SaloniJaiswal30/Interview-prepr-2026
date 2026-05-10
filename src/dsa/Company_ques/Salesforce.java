//Question 1:
//A classification system evaluates whether given texts are spam based on a list of spam words.
//A text is labeled “spam” if it contains at least two spam words (each occurrence of a spam word in the text counts toward the total).
//Spam word matching is case-sensitive.
//
//Example:
//texts = {
//        "This is a limited offer just for you",
//        "Win cash now! Click here to claim your prize",
//        "Hello friend, just checking in",
//        "Congratulations! You have won a free gift"
//        };
//
//spamWords = {
//        "offer", "cash", "Click", "prize", "Congratulations", "free"
//        };
//
//Output:
//        ["not_spam", "spam", "not_spam", "spam"]

package dsa.Company_ques;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Salesforce {

    public static void main(String args[]) {
        String[] input = {
                "This is a limited offer just for you",
                "Win cash now! Click here to claim your prize",
                "Hello friend, just checking in",
                "Congratulations! You have won a free gift"
        };

        String[] spamWords = {
                "offer", "cash", "Click", "prize", "Congratulations", "free"
        };

        Set<String> s = new HashSet<>();
        for (String i : spamWords) {
            s.add(i);
        }

        List<String> result = new ArrayList<>();
        String spam="spam";
        String notSpam="not-spam";
        for (String statement : input) {
            statement =
                    statement.replaceAll("[^a-zA-Z ]", "");
            String[] words = statement.split(" ");
            int count = 0;
            for (String word : words) {
                if(s.contains(word)){
                    count++;
                }
                if(count>=2){
                    result.add(spam);
                    break;
                }
            }
            if(count<2){
                result.add(notSpam);
            }
        }
        System.out.println(result);
    }

}
