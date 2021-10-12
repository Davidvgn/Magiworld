import java.util.Scanner;

class Magiword {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Choix du personnage 1

        int character1 = getType("Joueur 1");
        int level1 = getLevel();
        int force1 = getForce();
        int agility1 = getAgility();
        int intelligence1 = getIntelligence();
        Player playerOne = getCharacter(character1, level1, force1, agility1, intelligence1);
        //int[] caracteristic1 = getAllCaracteristic();
        //Player playerOne = getCharacter(character1, caracteristic1);

        // Choix du personnage 2
        int character2 = getType("Joueur 2");
        int level2 = getLevel();
        int force2 = getForce();
        int agility2 = getAgility();
        int intelligence2 = getIntelligence();
        Player playerTwo = getCharacter(character2, level2, force2, agility2, intelligence2);
        // int[] caracteristic2 = getAllCaracteristic();
        //Player playerTwo = getCharacter(character2, caracteristic2);

        // Début du jeu
        while (playerOne.life > 0 && playerTwo.life > 0) {
            if (playerOne.life > 0) {
                // Joueur 1 joue :
                System.out.println("Joueur 1, choississez votre attaque :");
                System.out.println("Taper 1 pour une Attaque Basique");
                System.out.println("Taper 2 pour une Attaque Spéciale");
                int attaque = scanner.nextInt() - 1;
                // Si le joueur 1 est un Guerrier
                if (character1 == 0) {
                    if (attaque == 0) {
                        System.out.println("Coup d'Épée :");
                        playerTwo.life = playerTwo.life - playerOne.force;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque == 2) {
                        System.out.println("Coup de Rage :");
                        playerTwo.life = playerTwo.life - playerOne.force * 2;
                        playerOne.life = playerOne.life - playerOne.force / 2;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque > 2 || attaque < 1) {
                        System.out.println("Mauvaise saisie, vous perdez votre tour.");
                    }

                    // Si le joueur 1 est un Rodeur
                } else if (character1 == 1) {
                    if (attaque == 1) {
                        System.out.println("Tir à l'arc :");
                        playerTwo.life = playerTwo.life - playerOne.agility;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque == 2) {
                        System.out.println("Concentration :");
                        playerOne.agility = playerOne.life + playerOne.agility;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                        System.out.println("Agilité joueur 2 :" + playerOne.agility);
                    } else if (attaque > 2 || attaque < 1) {
                        System.out.println("Mauvaise saisie, vous perdez votre tour.");
                    }
                    // Si le joueur 1 est un Mage
                } else {
                    if (attaque == 1) {
                        System.out.println("Boule de feu:");
                        playerTwo.life = playerTwo.life - playerOne.intelligence;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque == 2) {
                        System.out.println("Soin :");
                        playerOne.life = playerOne.life + playerOne.intelligence * 2;
                        if (playerOne.life > level1 * 5) {
                            playerOne.life = level1 * 5;
                        }
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque > 2 || attaque < 1) {
                        System.out.println("Mauvaise saisie, vous perdez votre tour.");
                    }
                }
            } else {
                System.out.println("");
            }
            if (playerTwo.life > 0 && playerOne.life > 0) {
                // Joueur 2 joue :
                System.out.println("");
                System.out.println("Joueur 2, choississez votre attaque :");
                System.out.println("Taper 1 pour une Attaque Basique");
                System.out.println("Taper 2 pour une Attaque Spéciale");
                int attaque2 = scanner.nextInt();
                // Si le jouer 2 est un Guerrier
                if (character2 == 1) {
                    if (attaque2 == 1) {
                        System.out.println("Coup d'Épée :");
                        playerOne.life = playerOne.life - playerTwo.force;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque2 == 2) {
                        System.out.println("Coup de Rage :");
                        playerOne.life = playerOne.life - playerOne.force * 2;
                        playerTwo.life = playerTwo.life - playerTwo.force / 2;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque2 > 2 || attaque2 < 1) {
                        System.out.println("Mauvaise saisie, vous perdez votre tour.");
                    }
                    // Si le joueur 2 est un Rodeur
                } else if (character2 == 2) {
                    if (attaque2 == 1) {
                        System.out.println("Tir à l'arc :");
                        playerOne.life = playerOne.life - playerTwo.agility;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque2 == 2) {
                        System.out.println("Concentration :");
                        playerTwo.agility = playerTwo.life + playerTwo.agility;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                        System.out.println(" Agilité joueur 2 :" + playerTwo.agility);
                    } else if (attaque2 > 2 || attaque2 < 1) {
                        System.out.println("Mauvaise saisie, vous perdez votre tour.");
                    }
                    // Si le joueur 2 est un Mage
                } else {
                    if (attaque2 == 1) {
                        System.out.println("Boule de feu:");
                        playerOne.life = playerOne.life - playerTwo.intelligence;
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque2 == 2) {
                        System.out.println("Soin :");
                        playerTwo.life = playerTwo.life + playerTwo.intelligence * 2;
                        if (playerTwo.life > level2 * 5) {
                            playerTwo.life = level2 * 5;
                        }
                        System.out.println("Vie joueur 1 :" + playerOne.life);
                        System.out.println("Vie joueur 2 :" + playerTwo.life);
                    } else if (attaque2 > 2 || attaque2 < 1) {
                        System.out.println("Mauvaise saisie, vous perdez votre tour.");
                    }
                }
            } else {
                System.out.println("");
            }
            System.out.println("");
        }
        System.out.println("Fin de la partie");
        if (playerOne.life > 0) {
            System.out.println("Le joueur 1 gagne");
        } else {
            System.out.println("Le joueur 2 gagne");
        }
    }

    private static int getIntelligence() {
        int intelligence;
        intelligence = getBoundedValue("Intelligence", 0, 100);
        return intelligence;
    }

    private static int getAgility() {
        int agility;
        agility = getBoundedValue("Agilité", 0, 100);
        return agility;
    }

    private static int getForce() {
        int force;
        force = getBoundedValue("Force", 0, 100);
        return force;
    }

    private static int getLevel() {
            int level;
            level = getBoundedValue("Level", 1, 100);
            return level;
    }

    private static int getType(String playerName) {
        int type;
        do {
            System.out.println(playerName + ", Choisissez votre personnage : ");
            System.out.println("Taper '1' pour Guerrier, '2' pour Rodeur ou '3' pour Mage");
            type = scanner.nextInt() - 1;
        } while (type < 0 || type > 2);
        if (type == 0) {
            System.out.println("Vous avez choisi d'être un Guerrier");
        } else if (type == 1) {
            System.out.println("Vous avez choisi d'être un Rodeur");
        } else {
            System.out.println("Vous avez choisi d'être un Mage");
        }
        return type;
    }

    private static int getBoundedValue(String value, int minValue, int maxValue) {
        int boundedValue;
        do {
            System.out.println("Donne moi la " + value + " entre " + minValue + " et " + maxValue);
            boundedValue = scanner.nextInt();
        } while (boundedValue < minValue || boundedValue > maxValue);
        return boundedValue;
    }

    private static Player getCharacter() {
        Player player;
        switch (thePlayer) {
            case 0 -> player = new Guerrier(level, level*5, force, agility, intelligence);
            case 1 -> player = new Rodeur(level, level*5, force, agility, intelligence);
            default -> player = new Mage(level, level*5, force, agility, intelligence);
        }
        return player;
    }
       /*public static Player getCharacter(int theplayer, int[] theName) {
        Player player;
        switch (theplayer) {
            case 1 -> player = new Guerrier(theName[0], theName[0] * 5, theName[1], theName[2], theName[3]);
            case 2 -> player = new Rodeur(theName[0], theName[0] * 5, theName[1], theName[2], theName[3]);
            default -> player = new Mage(theName[0], theName[0] * 5, theName[1], theName[2], theName[3]);
        }
        return player;
    }*/
    /*private static int[] getAllCaracteristic() {
        System.out.println("");
        System.out.println("Définissez vos caractéristiques : ");
        System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
        int[] caracteristic = new int[4];
        caracteristic[0] = getBoundedValue("Level", 1, 100);
        caracteristic[1] = getBoundedValue("Force", 0, caracteristic[0]);
        caracteristic[2] = getBoundedValue("Agilité", 0, caracteristic[0] - caracteristic[1]);
        caracteristic[3] = getBoundedValue("Intelligence", 0, caracteristic[0] - caracteristic[1] - caracteristic[2]);
        return caracteristic;
    }*/
}
