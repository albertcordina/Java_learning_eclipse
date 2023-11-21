package localization;

import java.util.Locale;
import java.util.ResourceBundle;

class QuizService {
	
    private ResourceBundle bundle;
    
    public QuizService (Locale locale) {
        // Load the appropriate language bundle
        bundle = ResourceBundle.getBundle("packageName/quiz", locale);
    }
    
    public String getQuestion(int questionNumber) {
        // Retrieve question from the bundle
        return bundle.getString("question" + questionNumber);
    }
    public String getAnswer(int questionNumber) {
        // Retrieve answer from the bundle
        return bundle.getString("answer" + questionNumber);
    }
}

public class Locale_Quiz {
	
    public static void main(String[] args) {
    	
        QuizService english = new QuizService(new Locale("en", "US"));
        QuizService spanish = new QuizService(new Locale("es", "ES"));
        QuizService german = new QuizService(new Locale("ge", "GE"));
        
        displayQuestionAndAnswer(1, "English", english);
        displayQuestionAndAnswer(2, "Spanish", spanish);
        displayQuestionAndAnswer(3, "German", german);
    }
    
    private static void displayQuestionAndAnswer(int questionNumber, String language, QuizService quizService) {
    	
        System.out.println(language + " Quiz:");
        System.out.println("Question " + questionNumber + ": " + quizService.getQuestion(questionNumber));
        System.out.println("Answer " + questionNumber + ": " + quizService.getAnswer(questionNumber));
        System.out.println();
    }
}

/*
  
quiz.properties:
question1=What is the capital of France?
answer1=Paris
question2=How many continents are there?
answer2=7
question3=Which planet is known as the Red Planet?
answer3=Mars
quiz_es_ES.properties:
question1=¿Cuál es la capital de Francia?
answer1=París
question2=¿Cuántos continentes hay?
answer2=7
question3=¿Cuál planeta es conocido como el Planeta Rojo?
answer3=Marte
quiz_ge_GE.properties:
question1=Was ist die Hauptstadt von Frankreich?
answer1=Paris
question2=Wie viele Kontinente gibt es?
answer2=7
question3=Welcher Planet ist als der Rote Planet bekannt?
answer3=Mars

*/
