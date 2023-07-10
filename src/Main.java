
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        int island=scan.nextInt();
        int Edge= scan.nextInt();
        int time = scan.nextInt();
        int travel= scan.nextInt();


        Graph g= new Graph(island+1);

        for (int i=1;i<=Edge;i++){
            int u= scan.nextInt();
            int v=scan.nextInt();
            g.addEdges(u,v);
        }
        int x= scan.nextInt();
        int y= scan.nextInt();

        g.BFS(x,y,time,travel);
    }
}