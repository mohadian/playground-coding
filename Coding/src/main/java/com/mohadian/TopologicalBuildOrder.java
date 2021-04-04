package com.mohadian;

import java.util.*;

public class TopologicalBuildOrder {
    static class Project {
        String name;
        int dependencies = 0;
        ArrayList<Project> children = new ArrayList<>();
        HashMap<String, Project> map = new HashMap<>();

        Project(String name) {
            this.name = name;
        }

        void addNeighbor(Project node) {
            if (!map.containsKey(node.name)) {
                map.put(node.name, node);
                children.add(node);
                node.incrementDependencies();
            }
        }

        private void incrementDependencies() {
            dependencies++;
        }

        private void decrementDependencies() {
            dependencies--;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class TopologicalGraph {
        ArrayList<Project> nodes = new ArrayList<>();
        HashMap<String, Project> map = new HashMap<>();

        Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }

        void addEdge(String start, String end) {
            Project startProject = getOrCreateNode(start);
            Project endProject = getOrCreateNode(end);

            startProject.addNeighbor(endProject);
        }
    }

    private static Project[] findBuildOrder(String[] projects, String[][] depandencies) {
        TopologicalGraph graph = buildGraph(projects, depandencies);
        return orderProjectsDFS(graph.nodes);
//        return orderProjects(graph.nodes);
    }

    private static Project[] orderProjectsDFS(ArrayList<Project> projects) {
        Stack<Project> order = new Stack<>();
        HashSet<Project> visited = new HashSet<>();

        for (Project project : projects) {
            if (!visited.contains(project)) {
                if (!doDFS(project, order, visited)) {
                    return null;
                }
            }
        }

        return convertOrderedStackToArray(projects, order);
    }

    private static boolean doDFS(Project project, Stack<Project> order, HashSet<Project> visited) {
        if (visited.contains(project)) {
            return false;
        }
        visited.add(project);

        for (Project child : project.children) {
            if (!visited.contains(child)) {
                doDFS(child, order, visited);
            }
        }
        order.add(project);
        return true;
    }

    private static Project[] convertOrderedStackToArray(ArrayList<Project> projects, Stack<Project> order) {
        Project[] ordered = new Project[projects.size()];
        int i = 0;
        while (!order.isEmpty()) {
            ordered[i++] = order.pop();
        }
        return ordered;
    }

    private static Project[] orderProjects(ArrayList<Project> nodes) {
        Project[] sorted = new Project[nodes.size()];

        int endOfList = addIndependentProjects(nodes, sorted, 0);

        if (endOfList == -1) {
            return null;
        }

        int toBeProcessed = 0;
        while (toBeProcessed < nodes.size()) {
            Project current = sorted[toBeProcessed];

            if (current == null) {
                return null;
            }

            for (Project child : current.children) {
                child.decrementDependencies();
            }
            endOfList = addIndependentProjects(nodes, sorted, endOfList);
            toBeProcessed++;
        }
        return sorted;
    }

    private static int addIndependentProjects(ArrayList<Project> nodes, Project[] sorted, int i) {
        int index = i;
        for (Project project : nodes) {
            if (project.dependencies == 0) {
                sorted[index++] = project;
                project.decrementDependencies();
            }
        }
        return index;
    }

    private static TopologicalGraph buildGraph(String[] projects, String[][] dependencies) {
        TopologicalGraph graph = new TopologicalGraph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }
        for (String[] dependency : dependencies) {
            graph.addEdge(dependency[0], dependency[1]);
        }
        return graph;
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};

        Project[] order = findBuildOrder(projects, dependencies);
        System.out.println(Arrays.toString(order));
    }
}
