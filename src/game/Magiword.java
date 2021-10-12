package game;

import players.*;

import java.util.Scanner;

public class Magiword {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Player player1 = getPlayer("Joueur 1");
        Player player2 = getPlayer("Joueur 2");

        play(player1, player2);
    }

    private static void play(Player player1, Player player2) {

        int round = 0;

        while (player1.getLife() > 0 && player2.getLife() > 0) {
            if (round % 2 == 0) {
                attack(round % 2, player1, player2);
            } else {
                attack(round % 2, player2, player1);
            }

            round++;
        }

        System.out.println("Fin de la partie");
        if (player1.getLife() > 0) {
            System.out.println("Le joueur 1 gagne");
        } else {
            System.out.println("Le joueur 2 gagne");
        }
    }

    private static void attack(int attackerIndex, Player attacker, Player defender) {
        System.out.println("Joueur " + (attackerIndex + 1) + " choississez votre attaque :");
        System.out.println("Taper 1 pour une Attaque Basique");
        System.out.println("Taper 2 pour une Attaque Spéciale");

        // IF BASIC OR SPECIAL, ASK USER
        int attackDamage = attacker.getBasicAttackDamages();

        defender.setLife(defender.getLife() - attackDamage);
    }

    private static Player getPlayer(String playerName) {
        PlayerType type = getType(playerName);
        int level = getBoundedValue("Level", 1, 100);
        int force = getBoundedValue("Force", 0, level);
        int agility = getBoundedValue("Agilité", 0, level - force);
        int intelligence = getBoundedValue("Intelligence", 0, level - force - agility);

        Player player;
        switch (type) {
            case WARRIOR:
                player = new Guerrier(level, level * 5, force, agility, intelligence);
                break;
            case MAGE:
                player = new Rodeur(level, level * 5, force, agility, intelligence);
                break;
            case RODEUR:
                player = new Mage(level, level * 5, force, agility, intelligence);
                break;
            default:
                throw new IllegalArgumentException("Impossible state");
        }
        return player;
    }

    private static PlayerType getType(String playerName) {
        int type;
        do {
            System.out.println(playerName + ", Choisissez votre personnage : ");

            printAllTypesToUser();

            type = scanner.nextInt() - 1;
        } while (type < 0 || type > PlayerType.values().length);

        PlayerType playerType = PlayerType.values()[type];

        System.out.println("Vous avez choisi d'être un player : " + playerType.name());

        return playerType;
    }

    private static void printAllTypesToUser() {
        PlayerType[] playerTypes = PlayerType.values();
        for (int i = 0; i < playerTypes.length; i++) {
            PlayerType playerType = playerTypes[i];

            System.out.println("Taper '" + (i + 1) + "' pour " + playerType.name());
        }
    }

    private static int getBoundedValue(String value, int minValue, int maxValue) {
        if (minValue >= maxValue) {
            return 0;
        }

        int boundedValue;
        do {
            System.out.println("Donne moi la " + value + " entre " + minValue + " et " + maxValue);
            boundedValue = scanner.nextInt();
        } while (boundedValue < minValue || boundedValue > maxValue);
        return boundedValue;
    }
}
