package recursion.v1;

public class MaxScoreOfWord {
    public static void main(String[] args) {
        int score = getScore(new String[]{"dog", "cat", "dad", "good"}, new int[]{1, 1, 1, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0}, 0);

        System.out.println(score);


    }

    public static int getScore(String[] words, int[] frequency, int[] score, int index){

        if(index == words.length){
            return 0;
        }

        int scoreWithoutTakingWord = 0 + getScore(words, frequency, score, index + 1);

        String word = words[index];
        int scoreWithTakingWord = 0;
        boolean isFrequencyGoingNegative = false;
        for(int i = 0 ; i < word.length(); i++){

            char ch = word.charAt(i);
             if(frequency[ch - 'a'] == 0){
                 isFrequencyGoingNegative = true;
             }
            frequency[ch - 'a']--;
            scoreWithTakingWord += score[ch - 'a'];
        }

        int newScore = 0;
        if(!isFrequencyGoingNegative){
            newScore = scoreWithTakingWord + getScore(words, frequency, score, index + 1);
        }

        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            frequency[ch - 'a']++;
        }

        return Math.max(scoreWithoutTakingWord, newScore);
    }
}
