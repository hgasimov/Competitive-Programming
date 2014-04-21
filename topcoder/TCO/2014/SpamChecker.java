package topcoder;

/*
 * TCO2014, Round 1B, 200 point problem
 */
public class SpamChecker {
    public static String spamCheck(String judgeLog, int good, int bad) {
        int sum = 0;
        for (int i = 0; i < judgeLog.length(); i++)
            if (judgeLog.charAt(i) == 'o') {
                sum += good;
            }
            else {
                sum -= bad;
                if (sum < 0) return "SPAM";
            }
        return "NOT SPAM";
    }    
}
