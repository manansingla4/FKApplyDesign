public class Play {
    public void playGame(Player[] players, Game game) {
        ShowGame showGame = new ShowGame();

        showGame.showGame(game);

        while (true) {
            for (Player player : players) {

                System.out.println("\n" + player.getName() + "'s Turn!!!");

                Coordinate c = player.playTurn(game);
                while (!game.isValid(c) || game.isMarked(c)) {
                    System.out.println("Invalid Choice, Try Again");
                    c = player.playTurn(game);
                }

                game.setMarked(c, player.getSymbol());

                showGame.showGame(game);

                boolean isWinner = game.checkWinner(player.getSymbol());

                if (isWinner) {
                    System.out.println("\n\n" + player.getName() + " wins !!!\n Game Over");
                    return;
                } else if (game.isFull()) {
                    System.out.println("\n\nGame Draw !!");
                    return;
                }
            }
        }

    }
}
