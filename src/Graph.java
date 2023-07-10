
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int cityNumber;
    private LinkedList<Integer> adj[];

    public Graph(int cityNumber) {
        //this.city = city;
        this.cityNumber = cityNumber;
        adj = new LinkedList[cityNumber + 1];
        for (int i = 0; i < cityNumber; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdges(int a, int b) {
        //--------------------------------------------------------
        // Summary: Assigns the edges between given nodes.
        // Precondition: a and b are integer.
        // Postcondition: The edges between the nodes are set.
        // --------------------------------------------------------
        adj[a].add(b);
    }

    public void BFS(int s, int e, int time,int travel) {
        //--------------------------------------------------------
        // Summary: Finds the route between starting and ending point
        // and stores it in a LinkedList.
        // Precondition: s, e, time and travel are integer.
        // Postcondition: The route has been set from starting point
        // to ending point and the travel time is calculated..
        // --------------------------------------------------------
        boolean visited[] = new boolean[cityNumber + 1];
        int path1[] = new int[cityNumber + 1];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        LinkedList<Integer> pathCount = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            LinkedList<Integer> list = adj[s];
            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                int v = list.get(i);
                if (v == e) {
                    path1[v] = s;
                    queue.clear();
                    break;
                }
                if (visited[v] != true) {
                    visited[v] = true;
                    queue.add(v);
                    path1[v] = s;
                }
            }
        }
        pathCount.add(e);
        int z = e;
        while (z != 0) {
            int k = path1[z];
            if (k != 0)
                pathCount.add(k);
            z = k;
        }
        System.out.println(pathCount.size());
        for (int i = pathCount.size() - 1; i>=0; i--) {
            System.out.print(pathCount.get(i) + " ");
        }
        System.out.println();

        //calculating the travel time
        int travelCount= pathCount.size()-1;
        int LuggageChange=  travelCount-1;

        int change= time-(travel%time);
        int totalTime= travelCount*travel+LuggageChange*change;
        System.out.println(change);
        System.out.println(totalTime);

    }
}
