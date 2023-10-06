import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctAnswerIndex;

    public QuizQuestion(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}




public class QuizApp {
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static List<QuizQuestion> quizQuestions = new ArrayList<>();
    private static Timer timer = new Timer();
    private static final int TIME_LIMIT = 10; // Time limit for each question in seconds

    public static void main(String[] args) {
        // Initialize quiz questions
        initializeQuestions();

        // Start the quiz
        startQuiz();
    }

    private static void initializeQuestions() {
        // Add quiz questions with options and correct answers here
        quizQuestions.add(new QuizQuestion("What is the capital of France?",
                List.of("A. London", "B. Paris", "C. Berlin", "D. Madrid"), 1));
        quizQuestions.add(new QuizQuestion("What is 2 + 2?",
                List.of("A. 3", "B. 4", "C. 5", "D. 6"), 1));
        // Add more questions as needed
    }

    private static void startQuiz() {
        if (currentQuestionIndex < quizQuestions.size()) {
            QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());

            for (int i = 0; i < currentQuestion.getOptions().size(); i++) {
                System.out.println(currentQuestion.getOptions().get(i));
            }

            // Start the timer
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    displayNextQuestion();
                }
            }, TIME_LIMIT * 10000); // Convert seconds to milliseconds

            // Get user's answer
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer (Enter the option letter): ");
            String userAnswer = scanner.nextLine().toUpperCase();
            
            // Check if the user's answer is correct
            int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
            String correctAnswer = currentQuestion.getOptions().get(correctAnswerIndex).toUpperCase();
            
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAnswer);
            }
            
            // Cancel the timer
            timer.cancel();
            
            // Move to the next question
            displayNextQuestion();
        } else {
            // Quiz is over, display the final score
            System.out.println("Quiz finished!");
            System.out.println("Your score: " + score + " out of " + quizQuestions.size());
            // Display a summary of correct/incorrect answers here
        }
    }

    private static void displayNextQuestion() {
        currentQuestionIndex++;
        startQuiz();
    }
}
