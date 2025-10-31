public class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String question, String answer) {
        super(question, answer.toLowerCase());
        if (!answer.equalsIgnoreCase("true") &&
                !answer.equalsIgnoreCase("false")) {

            throw new IllegalArgumentException("True/false must be 'true' or 'false' ");

        }

    }

    @Override
    public boolean checkAnswer(String User) {
        return answer.equals( UserAnswer.trim().toLowerCase());
    }
    @Override
    public String getOptions(){
        return "[ 1 ] true    [ 2 ]  false ";
    }
}