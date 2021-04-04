package com.mohadian;

import java.util.*;

public class SkylineDrawing {

    class BuildingPoints implements Comparable<BuildingPoints> {
        boolean isStart;
        int x;
        int height;

        @Override
        public int compareTo(BuildingPoints o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }

    public SkylineDrawing() {

    }

    public List<int[]> getSkyline(int[][] points) {
        BuildingPoints[] buildingPoints = new BuildingPoints[points.length * 2];
        int index = 0;
        for (int[] point : points) {
            buildingPoints[index] = new BuildingPoints();
            buildingPoints[index].isStart = true;
            buildingPoints[index].x = point[0];
            buildingPoints[index].height = point[2];

            buildingPoints[index + 1] = new BuildingPoints();
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].x = point[1];
            buildingPoints[index + 1].height = point[2];
            index += 2;
        }

        Arrays.sort(buildingPoints);

        TreeMap<Integer, Integer> queue = new TreeMap<>();
        int prevMaxHeight = 0;
        queue.put(0, 1);

        List<int[]> result = new ArrayList<>();
        for (BuildingPoints buildingPoint : buildingPoints) {
            if (buildingPoint.isStart) {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
            } else {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value == 1) {
                        return null;
                    }
                    return value - 1;
                });
            }
            int currentMaxHeight = queue.lastKey();

            if (prevMaxHeight != currentMaxHeight) {
                result.add(new int[]{buildingPoint.x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] buildings = {{1, 3, 4}, {3, 4, 4}, {2, 6, 2}, {8, 11, 4}, {7, 9, 3}, {10, 11, 2}};
        SkylineDrawing skylineDrawing = new SkylineDrawing();
        List<int[]> criticalPoints = skylineDrawing.getSkyline(buildings);
        criticalPoints.forEach(cp -> System.out.println(cp[0] + " - " + cp[1]));
    }
}
