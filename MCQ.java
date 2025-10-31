import java.util.*;

public class MCQ extends Question {
    private List<String> options;
    private char correct; // A B  C  D  OPTIONS

    public MCQ(String question, String answer, List<String> options, char correct) {
        super(question, String.valueOf(correct).toUpperCase());
        this.options = new ArrayList<>(options);
        this.correct = Character.toUpperCase(correct);
        if (this.correct < 'A' || this.correct >= 'A' + options.size()) {
            throw new IllegalArgumentException("correct option must be between A, B,C,D ");
        }
    }

    @Override
    public boolean checkAnswer(String UserAnswer) {
        return correct.equals(UserAnswer.trim().toUpperCase());
    }

    @Override
    public String getOptions() {
        StringBuilder sb = new StringBuilder();
        char option = 'A';
        for (String opt : options) {
            sb.append("   [ ").append(option).append(" ]").append(opt).append("\n");
            option++;
        }
        return sb.toString();
    }

    public List<String> getOption() {
        return new ArrayList<>(options);
    }
}