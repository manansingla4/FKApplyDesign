import java.util.HashMap;
import java.util.Map;

public class LeaderBoard {
    private Map<String, Map<Integer, Integer>> leaderBoard;

    public LeaderBoard() {
        leaderBoard = new HashMap<>();
    }

    public void addPoints(Player player, int level) {
        String name = player.getName();

        if (leaderBoard.containsKey(player.getName())) {
            if (leaderBoard.get(name).containsKey(level)) {
                leaderBoard.get(name).put(level, leaderBoard.get(name).get(level) + 1);
            } else {
                leaderBoard.get(name).put(level, 1);
            }
        } else {
            leaderBoard.put(name, new HashMap<>());
            leaderBoard.get(name).put(level, 1);
        }
    }

    public void printLeaderBoard() {
        System.out.println("LeaderBoard");
        for (Map.Entry<String, Map<Integer, Integer>> ent : leaderBoard.entrySet()) {
            System.out.print(ent.getKey() + " -");
            for (Map.Entry<Integer, Integer> obj : ent.getValue().entrySet()) {
                System.out.print("\nLevel: " + obj.getKey() + " Points: " + obj.getValue());
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
}