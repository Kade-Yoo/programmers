package com.company.hash;

import java.util.Arrays;

/**
 * 완주하지 못한 선수 구하기
 *
 * 조건
 * 1. 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * 2. completion의 길이는 participant의 길이보다 1 작습니다.            100,000 * (100,000-1)
 * 3. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.    1-20 알파벳 소문자
 * 4. 참가자 중에는 동명이인이 있을 수 있습니다.                           중복 허용
 *
 * 코드 설명
 * 1. solution함수 : 문제의 solution을 내기 위한 함수
 * 2. Marathoner객체 : 참석자, 완주자 몰고을 갖는 객체 > Marathoner클래스를 참석자, 완주자 객체로 변경해도 될듯함
 * 3. getMarathonerDontFirstTheCourse : 정렬이 된 상태의 참석자, 완주자 목록을 비교하면서 다른 지점을 찾는다. > 참석자와 완주자가 다르면 완주하지 못한 사람으로 간주
 * 객체 안에 참석자, 완주자를 프로퍼티로 두는 것도 나쁘지 않으나 마라토너라는 고유한 특성을 갖기 떄문
 * 4. getSortedMarathoner : 반복문 1개와 조건문 1개로 해결하기 위해 정렬 처리
 */
public class DontFirstTheCourse {

    /**
     *  완주하지 못한 선수
     *
     * @param participant 참가자
     * @param completion 완주자
     * @return 정답
     */
    public String solution(String[] participant, String[] completion) {
        Marathoner sortedParticipant = this.getSortedMarathoner(participant);
        Marathoner sortedCompletion = this.getSortedMarathoner(completion);

        return getMarathonerDontFirstTheCourse(sortedParticipant, sortedCompletion);
    }

    /**
     * 완주하지 못한 마라토너
     *
     * @param participant 참석자
     * @param completion 완주자
     * @return 완주하지 못한 마라토너
     */
    private String getMarathonerDontFirstTheCourse(Marathoner participant, Marathoner completion) {
        for (int i = 0; i < completion.getMarathoner().length; i++) {
            if (!participant.getMarathoner()[i].equals(completion.getMarathoner()[i])) {
                return participant.getMarathoner()[i];
            }
        }
        return participant.getMarathoner()[completion.getMarathoner().length];
    }

    /**
     * get 정렬된 마라토너 객체
     * 
     * @param marathoner 마라토너
     * @return 정렬된 마라토너
     */
    public Marathoner getSortedMarathoner(String[] marathoner) {
        Arrays.sort(marathoner);
        
        return new Marathoner(marathoner);
    }

    /**
     * 마라토너 객체
     * 
     * 1. 데이터 셋팅
     * (데이터 정렬은 계산을 위한 특수한 행위이므로 해당 객체와 연관지을 수 없음)
     */
    public static class Marathoner {
        private final String[] marathoner;

        public Marathoner(String[] marathoner) {
            this.marathoner = marathoner.clone();
        }

        public String[] getMarathoner() {
            return this.marathoner;
        }
    }
}
