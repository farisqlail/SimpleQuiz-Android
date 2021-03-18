package com.example.belajarandroid;

import org.w3c.dom.Text;

public class QuestionBank {

    private String TextQuestion [] = {

            "1. kita dapat melihat benda di sekitar kita menggunakan …",
            "2. untuk mencegah sakit gigi maka kita harus rajin …",
            "3. kita dapat mencium bau wangi menggunakan …",
            "4. tubuh manusia butuh makanan dan minuman agar tetap …"

    };

    private String MultipleChoice [][] = {

            {"telinga", "hidung", "mata"},
            {"sikat gigi", "cuci tangan", "makan permen"},
            {"leher", "hidung", "kaki"},
            {"sehat dan kuat", "lelah dan letih", "bisa tidur"}
    };

    private String mCorrectAnswer[] = {
            "mata", "sikat gigi", "hidung", "sehat dan kuat"
    };

    public int getLength() {

        return TextQuestion.length;
    }

    public String getQuestion(int a) {
        String question = TextQuestion[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = MultipleChoice[index][num-1];
        return choice0;
    }

    public  String getCorrectAnswere(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }

}
