package com.mohadian;

import java.util.*;

public class BabyNames {

    static class NameSet {
        Set<String> names = new HashSet();
        String rootName;
        int frequency;

        public NameSet(String rootName, int frequency) {
            this.rootName = rootName;
            this.frequency = frequency;
        }

        public void merge(Set<String> set, int freq) {
            names.addAll(set);
            frequency += freq;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> names = new HashMap<>();
        String[][] synonyms = new String[5][2];

        names.put("John", 10);
        names.put("Jon", 3);
        names.put("Davis", 2);
        names.put("Kari", 3);
        names.put("Johnny", 11);
        names.put("Carlton", 8);
        names.put("Carleton", 2);
        names.put("Jonathan", 9);
        names.put("Carrie", 5);

        synonyms[0] = new String[]{"Jonathan", "John"};
        synonyms[1] = new String[]{"Jon", "Johnny"};
        synonyms[2] = new String[]{"Johnny", "John"};
        synonyms[3] = new String[]{"Kari", "Carrie"};
        synonyms[4] = new String[]{"Carleton", "Carlton"};

        Map<String, Integer> frequencies = calculateFrequencies(names, synonyms);

        System.out.println(Arrays.toString(frequencies.keySet().toArray()));
        System.out.println(Arrays.toString(frequencies.values().toArray()));

    }

    private static Map<String, Integer> calculateFrequencies(Map<String, Integer> names, String[][] synonyms) {

        Map<String, NameSet> nameGroups = constructGroups(names);

        Map<String, NameSet> nameMergedGroups = mergeGroups(nameGroups, synonyms);

        Map<String, Integer> nameList = simplifyGroups(nameMergedGroups);

        return nameList;
    }

    private static Map<String, Integer> simplifyGroups(Map<String, NameSet> nameMergedGroups) {
        Map<String, Integer> list = new HashMap<>();
        for (Map.Entry<String, NameSet> entry : nameMergedGroups.entrySet()) {
            String name = entry.getKey();
            int fre = entry.getValue().frequency;
            list.put(name, fre);
        }
        return list;
    }

    private static Map<String, NameSet> mergeGroups(Map<String, NameSet> nameGroups, String[][] synonyms) {
        for (int i = 0; i < synonyms.length; i++) {
            String name1 = synonyms[i][0];
            String name2 = synonyms[i][1];

            NameSet nameSet1 = nameGroups.get(name1);
            NameSet nameSet2 = nameGroups.get(name2);

            if (nameSet1.frequency > nameSet2.frequency) {
                nameSet1.merge(nameSet2.names, nameSet2.frequency);
                nameGroups.remove(name2);
            } else {
                nameSet2.merge(nameSet1.names, nameSet1.frequency);
                nameGroups.remove(name1);
            }
        }

        return nameGroups;
    }

    private static Map<String, NameSet> constructGroups(Map<String, Integer> names) {
        Map<String, NameSet> nameGroups = new HashMap<>();

        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            Integer fre = entry.getValue();
            nameGroups.put(name, new NameSet(name, fre));
        }

        return nameGroups;
    }
}
