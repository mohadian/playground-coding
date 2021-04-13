package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CircusTower {

    static class Person implements Comparable<Person> {
        int height;
        int weight;

        Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "h " + height + " w " + weight;
        }

        @Override
        public int compareTo(CircusTower.Person other) {
            if (other.height != this.height) {
                return this.height - other.height;
            } else {
                return this.weight - other.weight;
            }
        }

        boolean isBefore(Person other) {
            return (other.height < this.height || other.weight < this.weight);
        }
    }

    private static ArrayList<Person> tallestTower(ArrayList<Person> people) {
        Collections.sort(people);

        ArrayList<Person> longest = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            ArrayList<Person> current = calculateTallest(people, new ArrayList<>(), 0);
            longest = max(current, longest);
        }
        return longest;
    }

    private static ArrayList<Person> max(ArrayList<Person> current, ArrayList<Person> longest) {
        if (longest == null) {
            return current;
        }
        if (current == null) {
            return longest;
        }
        if (longest.size() > current.size()) {
            return longest;
        } else {
            return current;
        }
    }

    private static ArrayList<Person> calculateTallest(ArrayList<Person> personArrayList, ArrayList<Person> sequence, int index) {
        if (index >= personArrayList.size()) {
            return sequence;
        }
        Person person = personArrayList.get(index);

        ArrayList<Person> seqWith = new ArrayList<>();
        if (canAppend(sequence, person)) {
            ArrayList<Person> nseq = (ArrayList<Person>) sequence.clone();
            nseq.add(person);
            seqWith = calculateTallest(personArrayList, nseq, index + 1);
        }

        ArrayList<Person> seqWithout = calculateTallest(personArrayList, sequence, index + 1);

        if (seqWith == null || seqWithout.size() > seqWith.size()) {
            return seqWithout;
        } else {
            return seqWith;
        }
    }

    private static boolean canAppend(ArrayList<Person> sequence, Person person) {
        if (sequence == null) {
            return false;
        }
        if (sequence.size() == 0) {
            return true;
        }

        return sequence.get(sequence.size() - 1).isBefore(person);
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(10, 5));
        people.add(new Person(11, 5));
        people.add(new Person(9, 3));
        people.add(new Person(8, 4));
        people.add(new Person(12, 1));

        List<Person> tower = tallestTower(people);

        System.out.println(Arrays.toString(tower.toArray()));
    }
}
