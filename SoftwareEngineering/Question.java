package sprint1;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

class Question extends Post implements Serializable{
    private String title;
    private List<Answer> answers = new ArrayList<>();

    public Question(String title, String text, LocalDateTime dateCreated) {
        super(text, dateCreated);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String toString() {
        String result = "Question Title: " + title + "\n" + "Body: " + text;
        return result;
    }

}