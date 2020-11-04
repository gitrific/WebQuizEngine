package io.github.gitrific.webquizengine;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizController {

    private List<Question> questions = new ArrayList<>();

    public QuizController() {
        this.questions.add(new Question("The Java Logo",
                "What is depicted on the Java logo?",
                new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"}, 2));
    }

    @GetMapping(path = "/api/quiz/{id}")
    public Question getQuestion(@PathVariable int id){
        return questions.get(id - 1);
    }

    @GetMapping(path = "/api/quiz")
    public Question getQuestion(){
        return questions.get(0);
    }

    @PostMapping(path = "/api/quiz")
    public Feedback solveQuiz(@RequestParam int answer) {
        return new Feedback(answer == questions.get(0).answer);
    }
}