package org.example.tight.coupling;

public class Subject {
  public static void main(String[] args) {
    Topic1 t = new Topic1();
    t.understandTopic1();

    Topic2 t2 = new Topic2();
    t2.understandTopic2();
  }
}
