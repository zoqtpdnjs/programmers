package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> reportedMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();

        for(int i = 0; i < id_list.length; i++){
            reportedMap.put(id_list[i], new HashSet<String>());
            answerMap.put(id_list[i], 0);
        }
        System.out.println("reportedMap : " + reportedMap);
        System.out.println("answerMap : " + answerMap);

        for(int i = 0; i < report.length; i++){
            String[] tempStr = report[i].split(" ");
            String reportingId = tempStr[0];
            String reportedId = tempStr[1];
            reportedMap.get(reportedId).add(reportingId);
        }
        System.out.println("reportedMap 에 신고 내역 기록 : " + reportedMap);

        for (String reportedUser : reportedMap.keySet()) {
            HashSet<String> userForSend = reportedMap.get(reportedUser);
            if (userForSend.size() >= k) {
                for (String userId : userForSend) {
                    answerMap.put(userId, answerMap.get(userId) + 1);
                }
            }
        }
        System.out.println("answerMap 에 메일 수 기록 : " + answerMap);

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = answerMap.get(id_list[i]);
            System.out.println("answer : " + answer[i]);
        }

        return answer;
    }
}
