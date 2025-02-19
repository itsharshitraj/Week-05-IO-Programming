package com.ioprogramming.csvdatahandling.advancedproblems.mergetwocsvfile;

class Student {
    String id, name, age, marks, grade;

    public Student(String id, String name, String age, String marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}
