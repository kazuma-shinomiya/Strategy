public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }

        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("Taro", new WinningStrategy(seed1));
        Player player2 = new Player("Ken", new ProbStrategy(seed2));
        for (int i = 0; i < 10000; i++) {
            Hand hand1 = player1.nextHand();
            Hand hand2 = player2.nextHand();
            if (hand1.isStrongerThan(hand2)) {
                player1.win();
                player2.lose();
            } else if (hand1.isWeakerThan(hand2)) {
                player1.lose();
                player2.win();
            } else {
                player1.even();
                player2.even();
            }
        }

        System.out.println("TOTAL");
        System.out.println(player1);
        System.out.println(player2);
    }
}
