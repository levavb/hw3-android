package com.example.triviaapp;


public class Questions {
    public Question[] questions = new Question[10];

//    public Questions(Question[] questions) {
//        this.questions = questions;
//    }

    public Questions() {
        questions[0] = new Question("Who was the first President of the United States?",
                new String[]{"John Adams", "George Washington", "Andrew Jackson", "Thomas Jefferson"},
                "George Washington");
        questions[1] = new Question("How many colonies were the United States originally?",
                new String[]{"11", "12", "13", "14"},
                "13");
        questions[2] = new Question(" What war was fought on American soil from 1861 to 1865?",
                new String[]{"War of 1812", "World War I", "The Revolutionary War", "The American Civil War"},
                "The American Civil War");
        questions[3] = new Question("Who was the 16th president of the US?",
                new String[]{"Abraham Lincoln", "Ulysses S. Grant", "James Buchanan", "Andrew Johnson"},
                "Abraham Lincoln");
        questions[4] = new Question("Who was the only president to serve two separate terms in office?",
                new String[]{"Benjamin Harrison", "William McKinley", "Grover Cleveland", "Chester A. Arthur"},
                "Grover Cleveland");
        questions[5] = new Question("Today in the United States government there are two major political parties.  The Republicans are one of the parties who is the other party?",
                new String[]{"The Independents", "The Progressives", "The Federalists", "The Democrats"},
                "The Democrats");
        questions[6] = new Question("How many judges are there in the United States Supreme Court?",
                new String[]{"5", "7", "9", "11"},
                "9");
        questions[7] = new Question("Who was the president from 1933 to 1945,  the only president to serve more than 8 years in office?",
                new String[]{"Harry Truman", "Franklin D. Roosevelt", "Herbert Hoover", "Dwight Eisenhower"},
                "Franklin D. Roosevelt");
        questions[8] = new Question("Who was the president from 1933 to 1945,  the only president to serve more than 8 years in office?",
                new String[]{"50", "100", "150", "200"},
                "100");

    }

    public Question getQuestion(int index) {
        return questions[index];
    }

}
