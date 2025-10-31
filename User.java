import java.util.*;
import java.io.*;

public class User implements Serializable {
    private String name;
    private Map<String, Integer> scores;
    private Map<String, Integer> totalquestions;

    public User(String name) {
        this.name = name;
        this.scores = new HashMap<>();
        this.totalquestions = new HashMap<>();
    }

    public void recordScore(String quizTitle, int score, int total) {
        scores.put(quizTitle, score);
        totalquestions.put(quizTitle, total);
        saveUserData();
    }

    public void displayScores() {
        System.out.println("\n --- Score History for " + name + "---");

        if (scores.isEmpty()) {
            System.out.println("No scores yet...");
            return;
        }
        for (String title : scores.keySet()) {
            int s = scores.get(title);
            int t = totalquestions.get(title);
            System.out.printf("%s %d /%d (%.1f%%)%n", title, s, t, (s * 100.0 / t));
        }
    }

    private void saveUserData() {
        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(name + "_scores.dat"))) {
            oo.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error in saving in the data" + e.getMessage());
        }
    }

    private static User loadUser(String name) {
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(name + "_scores.dat"))) {
            User user = (User) oi.readObject();
            System.out.println("Welcome back," + user.name + " !");
            return user;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("New User created :" + name);
            return new User(name);
        }
    }

    public String getName() {
        return name;
    }


}