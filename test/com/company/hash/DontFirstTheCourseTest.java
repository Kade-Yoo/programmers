package com.company.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DontFirstTheCourseTest {

    @Test
    public void 정렬_테스트() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        DontFirstTheCourse dontFirstTheCourse = new DontFirstTheCourse();
        DontFirstTheCourse.Marathoner sortedParticipant = dontFirstTheCourse.getSortedMarathoner(participant);
        DontFirstTheCourse.Marathoner sortedCompletion = dontFirstTheCourse.getSortedMarathoner(completion);

        String[] expectedValues = new String[]{"filipa", "josipa", "marina", "nikola", "vinko"};
        for (int index = 0; index < sortedParticipant.getMarathoner().length; index++) {
            Assertions.assertEquals(sortedParticipant.getMarathoner()[index], expectedValues[index]);
        }
    }

    @Test
    public void 정답이_가운데_있을떄() {
        DontFirstTheCourse dontFirstTheCourse = new DontFirstTheCourse();
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String answer = dontFirstTheCourse.solution(participant, completion);
        Assertions.assertEquals(answer, "vinko");
    }

    @Test
    public void 정답이_맨처음_있을때() {
        DontFirstTheCourse dontFirstTheCourse = new DontFirstTheCourse();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = dontFirstTheCourse.solution(participant, completion);
        Assertions.assertEquals(answer, "leo");
    }

    @Test
    public void 정답이_중복일때() {
        DontFirstTheCourse dontFirstTheCourse = new DontFirstTheCourse();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String answer = dontFirstTheCourse.solution(participant, completion);
        Assertions.assertEquals(answer, "mislav");
    }
}