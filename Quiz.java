import java.io.*;
import java.util.*;
public class Quiz implements Serializable{
    private String  title;
    private List<Question>questions;
    private transient Scanner sc= new Scanner(System.in);

    public Quiz(String title) {
        this.title = title;
        this.questions= new ArrayList<>();
    }
    public void addQ(Question question){
        questions.add(question);
    }
    public void start(User user){
        System.out.println("\n====== "+title+" =====\n");
        int total=0;
        for(int i=0;i<questions.size();i++){
            Question q=questions.get(i);
            System.out.println("Question "+ (i+1)+":\n"+q);
            String answer=getUserAnswer(q);
            if(q.checkAnswer(answer)){
                System.out.println("Its correct \n");
                total++;
            }
            else{
                System.out.println("Wroong! correct answer: "+q.answer);
            }
        }
    user.recordScore(title,total,questions.size());
        System.out.println("Quiz completed ! final score: "+total+ "/"+questions.size());
    }

        private String getUserAnswer(Question q){
            while(true){
                System.out.println("Your answer: ");
                String input= sc.nextLine().trim();
                if(!input.isEmpty()){
                    return input;
                }

                System.out.println("Please enter A valid answer");
            }
        }
        public void save(String fileName){
        try (ObjectOutputStream oo= new ObjectOutputStream(new FileOutputStream(fileName))){
            oo.writeObject(this);
            System.out.println(" Quiz saved to file named "+ fileName) ;
        }
        catch (IOException e){
            System.out.println("Error saving the quiz"+ e.getMessage());
        }
    }
    public static Quiz load(String fileName){
        try(ObjectInputStream oi= new ObjectInputStream(new FileInputStream(fileName))){
                Quiz quiz = (Quiz) oi.readObject();
                quiz.sc= new Scanner(System.in);
            System.out.println("Quiz is loaded from "+ fileName);
             return quiz;
        }
        catch (IOException| ClassNotFoundException e  ){
            System.out.println("Error loading the quiz: "+ e.getMessage());
            return null;
        }

    }
    public String getTitle(){
        return title;
    }
    public List<Question> getQuestions(){
        return new ArrayList<>(questions);
    }
}



