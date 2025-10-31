import java.io.Serializable;

public abstract class Question implements Serializable {
    protected String question;
    protected String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public abstract boolean checkAnswer(String UserAnswer);

    public abstract String getOptions();

    @Override
    public String toString() {
        return question + "\n" + getOptions();
    }

}