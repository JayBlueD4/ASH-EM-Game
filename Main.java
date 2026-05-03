import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Setting up player board variables
        String[] p1Tiles, p2Tiles, p3Tiles, p4Tiles, p5Tiles, p6Tiles;
        int[] p1TilesStatus, p2TilesStatus, p3TilesStatus, p4TilesStatus, p5TilesStatus, p6TilesStatus;

        //Setting up other variables
        boolean noWinners = true; String tileDrawn = ""; char tileLetter = ' '; int questionGenerated = 0; int playerGuessing = 0;

        //Tutorial Strings
        String singlePlayerTutorial = "\n\u001B[1m\u001B[4mAsh 'Em: (Single Edition)\u001B[0m\nAsh 'Em is Bingo with a twist! Each column represents a different category -> A: Arts (Music, Movies & TV Shows), S: Science, H: History & Geography, E: English, M: Math.\nCards are drawn at random (e.g. A22 or H15), with a corresponding question being asked.\n - If the card drawn doesn't match any tiles on your board, reply \"N\" when prompoted.\n - If the card does match a tile on your board, reply \"Y\" instead. You must then answer the given question correctly to claim that tile.\n - If you fail to answer the question correctly, you don't get the tile and a new one is drawn.\n - You win once you claim an entire line of 5 (horizontal, vertical, or diagonal).\n **The centre space is a free space!**";
        String multiplayerTutorial = "\n\u001B[1m\u001B[4mAsh 'Em: (Multiplayer Edition)\u001B[0m\nAsh 'Em is Bingo with a twist! Each column represents a different category -> A: Arts (Music, Movies & TV Shows), S: Science, H: History & Geography, E: English, M: Math.\nCards are drawn at random (e.g. A22 or H15), with a corresponding question being asked. Only those with a matching tile can answer the question. Once you have an answer, call\nout \"Ash 'Em\"! Whoever calls it out first gets to answer the question.\n - If the card drawn doesn't match with a tile on anyone's board, reply \"N\" when prompoted.\n - If the card does match a tile on anyone's board, reply \"Y\" instead. You must then answer the given question correctly to claim that tile.\n - If someone answers a question incorrectly, no one gets that tile and a new one is drawn.\n - Whoever claims an entire line of 5 (horizontal, vertical, or diagonal) first wins!\n **The centre space is a free space!**";

        //String Arrays Containing Questions
        String[] aQuestions = {"One dotted half-note is equivalent to how many quarter notes?\n a) 1\n b) 2\n c) 3\n d) 4", "Which one of these shows is not part of the \"12-season club\"?\n a) Hawaii Five-O\n b) M*A*S*H\n c) Bones\n d) Two and a Half Men", "A flute is a(n):\n a) wind instrument\n b) woodwind instrument\n c) air instrument",
                "Which movie is the highest grossing film of all time?\n a) Titanic\n b) Avatar\n c) Avengers: Endgame\n d) Avengers: Infinity War", "The harmonic A minor scale has one accidental. This is:\n a) A#\n b) Ab\n c) G#\n d) G♭", "John Williams was the composer for how many of the following movie franchises? \n - \"Star Wars\"\n - \"Home Alone\"\n - \"The Fabelmans \"\n - \"Jaws\"",
                "Choose the correct option to fill in the blank: In ⅜ time, the __ beat in the measure is \"strong\" (emphasized).\n a) 1st\n b) 2nd\n c) 3rd", "Choose all correct options (if multiple options are correct, separate each letter with a space). Which of these TV shows ran/have been running for over 10 years:\n a) Ninjago\n b) The Mandalorian\n c) Columbo\n d) Casualty", "Choose the correct answer: the saxophone is a) a brass instrument or b) a woodwind instrument.",
                "How many Spider-Man movies have been released as of 2023?\n a) 10\n b) 11\n c) 9\n d) 8\n\n(Hint: Sam Raimi's Spider-Man movies, The Amazing Spider-Man movies, MCU Spider-Man movies, animated Spider-Verse movies)", "How many sharps does the key signature of F minor have?\n a) 2\n b) 3\n c) 4\n d) 0", "Which one of the following actors/actresses has 4 children?\n a) Robert De Niro\n b) Denzel Washington\n c) Meryl Streep\n d) Cate Blanchett",
                "Which one of these famous composers is blind:\n a) Ludwig Van Beethoven\n b) Johann Sebastian Bach\n c) Wolfgang Amadeus Mozart\n d) Johannes Brahms", "Which one of these celebrities guest starred on \"Friends\"?\n a) Matthew Perry\n b) Alec Baldwin\n c) Michael Douglas\n d) Tom Cruise", "Which one of these options contains a \"sixteenth note\":\n a) ♩\n b) ♫\n c) ♪\n d) ♬",
                "Which one of these movies from this year (2023) has reached $1 Billion at the box office?\n a) John Wick: Chapter 4\n b) Creed III\n c) The Super Mario Bros. Movie\n d) Dungeons & Dragons", "\"SATB\" is used to describe the format of scores written for\n a) bands\n b) quartets\n c) orchestras\n d) choirs", "Which one of these actresses has played \"Mary Poppins\"\n a) Anne Hathaway\n b) Emily Blunt\n c) Marilyn Monroe\n d) Emma Watson",
                "The first two notes of a scale are E and F♯. To make the scale major, the next note must be:\n a) G♮\n b) G#\n c) G\n d) Gb", "Which TV show was released first?\n a) Silo\n b) The Days\n c) Never Have I Ever\n d) Warrior", "Who was the composer of the \"William Tell Overture\"?\n a) William Tell\n b) George Frideric Handel\n c) Luigi Boccherini\n d) Gioachino Rossini",
                "Which genre is the movie \"Interstellar\" part of?\n a) action\n b) horror\n c) comedy\n d) science fiction", "Choose the option which fills in the blank correctly: A \"sextuplet\" is a group of __ notes.\n a) 12\n b) 11\n c) 6\n d) 7", "Who was the director for \"The Force Awakens?\"\n a) George Lucas\n b) John Williams\n c) J.J. Abrams\n d) Dave Filoni",
                "What is the only instrument to have its own clef?", "Which one of these popular shows is the MOST popular?\n a) Stranger Things\n b) The 100\n c) Game of Thrones\n d) The Mandalorian", "The interval from G up to C is a:\n a) perfect 4th\n b) major 4th\n c) perfect 5th\n d) major 5th",
                "What is a tetralogy?\n a) a 4-movie series\n b) a 3-movie series\n c) a 6-movie series\n d) a 13-movie series", "Who was the composer of \"Canon in D\"?\n a) Johann Pachelbel\n b) Johann Pachebel\n c) Johann Sebastian Bach\n d) Johannes Brahms", "In the show, \"The Fresh Prince of Bel-Air\", what was the name of actor Will Smith's character?\n a) Will Smith\n b) Will Banks\n c) Will Butler\n d) Will Lewis"};

        String[] sQuestions = {"True or false: Field forces don't make contact with the objects they act on.", "What does the atomic number represent?\n a) the position of an element on the periodic table\n b) the overall charge of an atom's nucleus\n c) the number of protons in an atom's nucleus\n d) all of the above", "How many bones are in the human body?",
                "Two people are sitting 12 metres apart. They move 9 metres closer to each other. The gravitational force (Fg) between them is now\n a) 1/4 times as great\n b) 1/16 times as great\n c) the same\n d) 16 times as great\n e) 4 times as great\n\n(Hint: Fg is proportional to 1/r²)", "Which type of chemical compound contains a double-bond?\n a) alkenes\n b) alkanes\n c) alkynes", "What is the largest organ \u001B[1m\u001B[4min\u001B[0m the human body?",
                "Which of the following equations is the correct one?\n a) V = I/R\n b) V = R/I\n c) R = VI\n d) V = IR", "How many elements are on the periodic table?\n a) 120\n b) 123\n c) 118\n d) 116", "Stem cells:\n a) carry oxygen around the body\n b) destroy microbes found in the body\n c) give us energy\n d) create other cells",
                "Lightning is an example of charging by:\n a) friction\n b) conduction\n c) induction", "Which common spice has the chemical formula, \"NaCl\"?\n a) pepper\n b) salt\n c) cinnamon\n d) cumin", "Enzymes are\n a) proteins\n b) bacteria\n c) cells\n d) stimuli",
                "Choose the correct option to fill in the blanks: Electromagnetism is related to _________.\n a) all charges\n b) positive charges only \n c) negative charges only\n d) static/non-moving charges\n e) moving charges", "Which one of the following chemical compounds is a carbohydrate?\n a) NaHCO₃\n b) CH₃COOH\n c) KMnO₄\n d) NH₄Cl", "When one cell splits into two identical cells, this is called:\n a) meiosis\n b) mitosis\n c) cell duplication\n d) cell replication",
                "An astronaut's mass on the moon compared to on the Earth is:\n a) smaller\n b) larger\n c) the same", "How many protons does uranium contain?\n a) 14\n b) 103\n c) 79\n d) 92", "Which one of the following cells is \"unspecialized\" (has no specific function)?\n a) red blood cells\n b) T-cells\n c) stem cells\n d) skin cells",
                "Is gravitational potential energy a) positive or b) negative?", "What is the chemical formula for sugar?\n a) C12H22O11\n b) NaHCO3\n c) C6H12O6\n d) CuSO4", "A person who eats fish instead of meat is a:\n a) herbivore\n b) pescetarian\n c) peskitarian\n d) carnivore",
                "If a 12-Volt power source produces a current of 3 amps in a phone charger, what is the resistance of the phone charger?\n a) 0.25 orms\n b) 0.25 Ω\n c) 0.25 R\n d) 4 R\n e) 4 ohms\n f) 4 orms", "Choose the correct option to fill in the blanks: NO₂⁻ and CrO4²⁻ are __________, H₃O⁺ and Hg₂²⁺ are __________, and carbon-12 and carbon-14 are __________.\n a) cations, anions, isotopes\n b) anions, isotopes, cations\n c) anions, cations, isotopes\n d) cations, isotopes, anions", "Snakes like to eat frogs, grasshoppers eat grass, snakes are eaten by hawks, and frogs can consume grasshoppers. What is the correct order of this food chain?\n a) sun, grass, grasshoppers, frogs, snakes, hawks\n b) hawks, snakes, frogs, grasshoppers, grass, sun\n c) sun, snakes, frogs, grasshoppers, grass, hawks\n d) sun, grass, grasshoppers, frogs, hawks, snakes",
                "The electrostatic force between two opposite charges is\n a) repulsive\n b) attractive", "What is the element name of atomic number 87?\n a) Francium\n b) Polonium\n c) Germanium\n d) Americium", "What is the production of light by living organisms called?\n a) synergy\n b) bioluminescence\n c) luminary synthesis\n d) photosynthesis",
                "True or false: Electromagnetism is what makes motors spin.", "What is the chemical formula for ammonia?\n a) NO₃\n b) SO₄\n c) NH₃\n d) H₂SO₄", "What do plant cells have that animal cells don't?\n a) cell membrane\n b) mitochondria\n c) cell wall\n d) cytoplasm"};

        String[] hQuestions = {"When did the Cold War start?\n a) 1947\n b) 1918\n c) 1880\n d) 1991", "Name a continent that is also considered to be a country.", "G. W. Bush was a\n a) president\n b) vice-president\n c) both",
                "Name the only state that's located in Canada.", "What was the \"Great Depression\"?\n a) a time of great sadness in the world\n b) a time when prices dropped significantly throughout the world\n c) a time when prices increased significantly throughout the world", "Which city has a population of roughly 12.5 million?\n a) Rwanda\n b) Argentina\n c) Paris\n d) Los Angeles",
                "In what year did Justin Trudeau become the Prime Minister of Canada?", "Name a country with 11 letters that starts with the letter \"P\".", "Who was born on June 14, 1946?\n a) Eddie Murphy\n b) Donald Trump\n c) Hugh Grant\n d) Joe Biden",
                "Where is the city of Vancouver located?\n a) British Columbia\n b) Washington\n c) both\n d) neither", "The plague in the \"Great Plague of England\" was\n a) the Bubonic Plague\n b) influenza\n c) malaria\n d) the Dengue Fever", "The population of Canada is roughly\n a) 38 million\n b) 41 million\n c) 42 million\n d) 57 million",
                "Fill in the blanks using the form \"answer1, answer2\": The two opposing sides in World War II were the ______ Powers and the ______ Powers.", "Choose the option that fills in the blanks correctly: longitude lines are __________ and latitude lines are __________.\n a) horizontal, vertical\n b) vertical, horizontal", "What does \"A.D.\" stand for?\n a) Anno Domini\n b) After Death (of Christ)\n c) Accentus Deus\n d) After Dominion",
                "Name a country with 12 letters that starts with the letter \"U\".", "Out of the following people, who served the longest term as the Prime Minister of Canada?\n a) Stephen Harper\n b) Bill Clinton \n c) Jean Chrétien\n d) Justin Trudeau", "Which of the following is the only city found in Singapore?\n a) Xi'An\n b) Chongqing\n c) Singapore\n d) Shanghai",
                "How long was Jesus dead for?\n a) 3 days and 2 nights\n b) 4 days and 3 nights\n c) 3 days and 3 nights", "Which country has the largest population?\n a) Greece\n b) Vietnam\n c) Spain\n d) Austria", "Who is the Conservative Party's current leader?",
                "Name all seven continents.", "What does \"B.C.\" stand for?\n a) Before Creation\n b) Before Common Era\n c) Before Century\n d) Before Christ", "What is the only Asian nation that is divided in two?",
                "Who was the first prime minister of Canada?\n a) Charles Tupper\n b) John A. Macdonald\n c) William Lyon Mackenzie King\n d) John Diefenbaker", "Where is Lisbon located?\n a) Portugal\n b) France\n c) Venezuela\n d) Italy", "What did the signing of the \"Declaration of Independence\" lead to?\n a) several states of America becoming independent from the USA\n b) the American Revolution\n c) Canada and the USA becoming separate, official countries\n d) the USA becoming independent from Great Britain",
                "Which city has the largest population?\n a) United States\n b) Winnipeg\n c) Nome\n d) Barcelona", "What was the NDP originally called?\n a) CFF\n b) CFC\n c) FFC\n d) CCF", "What is the correct order of the four cardinal directions?\n a) Northeast, Southeast, Southwest, Southeast\n b) West, South, East, North\n c) North, East, West, South\n d) North, East, South, West"};

        String[] eQuestions = {"To fill in the blank in the sentence, \"The earthquake’s _______ were devastating\", do we use a) effects or b) affects?", "What do you call two things that are compared to each other without the use of comparison words?", "Two people dine in a restaurant. The first person's steak is not cooked the way they asked, so they demand to have another one. They are being\n a) aggressive\n b) passive\n c) turbulent\n d) assertive\n\nWrite the letter(s) that apply. If you choose multiple letters, type them with a space in between each one.",
                "Fill in the blank: when two words have a similarity in sound, they _______.", "Spell the very long word from Mary Poppins.", "What does it mean to \"go too far?\"\n a) to do something unnecessary\n b) to do something impossible\n c) to do something unacceptable",
                "Choose the option that fills in the blanks correctly: Matt and Mally invited me over to their house yesterday to meet ____ new dog. One day, I hope to get a\ndog of my own ____!\n a) too, their\n b) there, too\n c) their, too\n d) their, to", "What is the use of sounds/noises in poetry called? Spelling counts!", "Spell the word that sounds like \"wuh-stuh-sure\".",
                "What is \"biding your time?\"\n a) saving your time\n b) wasting your time\n c) waiting for the right time\n d) not wasting time & acting immediately", "A word should be capitalized when it's: A) a noun, B) a name, C) a noise, D) at the beginning of a sentence (if multiple options are\ncorrect, separate each letter with a space).", "Two words with opposite meanings are called:\n a) antonyms\n b) acrynoms\n c) synonyms\n d) acronyms",
                "Choose the option that fills in the blanks correctly: For some reason, I always seem to ____ my ____-fitting ring!\n a) lose, lose\n b) lose, loose\n c) loose, loose\n d) loose, lose", "What is personification?", "Spell the word that sounds like \"pin-yaa-ta\".",
                "When someone is getting \"too big for their boots\", they're becoming\n a) too fat\n b) too popular\n c) to tall\n d) too self-absorbed", "Every sentence has a subject and ________.\n a) a verb\n b) an object", "What are homophones?",
                "Choose the option that fills in the blanks correctly: I always ___ my watch on the table before I ___ down to sleep!\n a) lie, lie\n b) lay, lie\n c) lie, lay\n d) lay, lay\n e) multiple options are correct", "Fill in the blank: Walt Whitman is an example of a famous _____.", "Spell the word that sounds like \"flem\".",
                "When two people are \"at odds\", they're\n a) in total agreement\n b) in total disagreement\n c) in partial agreement\n d) in partial disagreement", "Is the possessive noun \"it's\" or \"its\"?", "The \"climax\" is:\n a) the middle of a story\n b) before the end of a story\n c) the most intense part of a story\n d) after the beginning of a story\n\nChoose all letters that apply. If you choose multiple letters, separate them with spaces.",
                "Which statement is true:\n a) bros. is the acronym of \"brothers\"\n b) WORD is the abbreviation of the \"West Orleans Recycling Depot\"\n c) NBITM is the acronym for the \"New Brunswick International Television Network\"\n d) IHLPC is the acronym for the \"International Hot Lunch Packaging Company\"", "Which famous female poet has the initials, E. D.? Capitalization matters!", "Spell the word that sounds like \"fl-ow-er\".",
                "A \"gentlemen's agreement\" is \n a) an informal deal based on trust\n b) a deal made by people of high class\n c) a deal between men\n d) a legally-binding contract", "When we talk about something that belongs to a singular thing, we can use apostrophes (e.g. Sam's apple, the lion's mane). When we talk about something\nbelonging to multiple things (e.g. lions, brothers, teachers), where do we put the apostrophe?", "The literary definition of a motif is:\n a) a specific character's musical theme\n b) the main musical theme in a story\n c) a subservient idea in a literary work\n d) a prominent idea in a literary work"};

        String[] mQuestions = {"If 1 = 3, 2 = 3, 3 = 5, 4 = 4, and 5 = 4, then 6 = ?", "Josh and Kayla competed in their regional sports competition. Josh won 10 medals in total, with 5 of them being silver. He won 2 fewer gold medals than Kayla.\nKayla won 4 gold medals, 1 silver medal, and 3 bronze medals. How many bronze medals did Josh win?", "What is the next number in the sequence of 2, 6, 12, 20, 30, 42?",
                "Dan is 17 and Jonah is 29. How many years ago was Jonah double Dan's age?", "What is (3 + 1) / 2 × 60?", "Evaluate 4² × 4³ ÷ 4² - 1",
                "What is 45² (there's a trick to answering this)?", "What is the next number in the sequence of 1/2, 2/3, 3/4, 4/5, 5/4, 4/3?", "Which three numbers have the same result when added and multiplied together? Write your answer in the form \"num1, num2, num3\".",
                "What is the cube root of 216?", "What are the values of x in 3x² + 20x + 25 = 0? Write your answer in the form \"num1 num2\".", "A right triangle's sides have lengths of 3 and 4. What is the length of the hypotenuse (Hint: Pythagorean Theorem)?",
                "Two girls were born from the same mother, at the same time and on the same date. And yet, they're somehow not twins. How is this possible?", "How many degrees do the angles of a triangle add up to?", "What's the next number in the sequence 1, 3, 0, 4, 1, 7, 0, 8, 1?",
                "What number gives the same result whether multiplied by itself, added to itself, or raised to the power of itself?", "Determine the average of 100, 98, and 12.", "How many degrees is π/2 radians (Hint: the conversion factor is 180/π)? Give just the number.",
                "A triangle has a base of 10 and a height of 15, what is its area?", "What is 2120 + 43 × 157 ÷ 29 × 0?", "Write pi to the fifth decimal place.",
                "What are the next two numbers in the sequence 20, 1, 18, 2, 14, 3, 8, 4? Write your answer as \"num1 num2\".", "There is a three-digit whole number. The second digit is two-and-a-half times larger than the third digit, while the first digit is three less than the second\ndigit. What is the number?", "Give the reciprocal of 5 in decimal form.",
                "What is (4 + 3) ÷ 2 × 5? Write your answer as a decimal number.", "What is the volume of a rectangular prism with length 3, height 9, and width 20?", "There is a 200cm ladder hanging over the side of a boat. The distance between its rungs is 20cm. The tide is currently rising at a rate of 10 cm/hour. When\nwill the water reach the seventh rung (if you believe the water never reaches it, then write \"never\" instead)?",
                "Evaluate log(10000)", "There are three groups of numbers: 3 12 4, 6 54 9, and 7 ? 7. What number should replace the question mark?", "Two days ago, I was 25 years old. Next year, I will be 28. This is only true for one day in the year. When is my birthday? Write your\nanswer as \"month day\"."};

        Scanner input = new Scanner(System.in);

        System.out.print("\u001B[1m\nWelcome to Ash 'Em! Please enter the number of players: \u001B[0m");
        int playerCount = input.nextInt();

        //Error message for when invalid player count is inputted
        if (playerCount < 1 || playerCount > 5) {
            System.out.print("\n\u001B[1m\u001B[31mSorry, this game is only for 1-6 players!");
            System.exit(1);
        }

        switch (playerCount) {
            case 1: p1Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p1Tiles, 0, p1Tiles.length); p1Tiles[12] = "\u001B[34m\u001B[1m***\u001B[0m";

                //Status of each tile (only centre tile, tile #13 (or index 12), should have the "claimed" status, 1)
                p1TilesStatus = new int[25]; p1TilesStatus[12] = 1;

                //Tutorial
                tutorialQuery(singlePlayerTutorial);

                //Start Game
                startGameQuery();
                System.out.print("\u001B[0m");
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                //Display Player Card
                printPlayerCards(p1Tiles);

                //Initial Values for Tiles Drawn
                noWinners = false; tileLetter = ' '; tileDrawn = ""; questionGenerated = 0;

                //Ask to draw first tile
                System.out.println();
                drawTileQuery();
                System.out.println();

                //Draw Tiles
                while (!noWinners) {
                    Boolean correctAnswer = false;

                    tileDrawn = drawTile();
                    tileLetter = tileDrawn.charAt(0);
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\u001B[32m\u001B[1mTile Drawn: \u001B[4m" + tileDrawn + "\u001B[0m\n");
                    continueQuery();

                    //Pick Random Question
                    questionGenerated = (int)(Math.random() * 30 + 1);

                    //If answered correctly, give player tile. If not, no one gets the tile
                    correctAnswer = askQuestion(tileLetter, questionGenerated, aQuestions, sQuestions, hQuestions, eQuestions, mQuestions);

                    if (correctAnswer) {
                        System.out.println("\u001B[1m\u001B[32mCorrect! You won tile \u001B[4m" + tileDrawn + "\u001B[24m!\u001B[0m\n");
                        for (int i = 0; i < p1Tiles.length; i++) {
                            if (tileDrawn.equals(p1Tiles[i])) {
                                p1Tiles[i] = "\u001B[1m\u001B[34m" + p1Tiles[i] + "\u001B[0m";
                                p1TilesStatus[i] = 1;
                            }
                        }
                    }
                    else {
                        System.out.println("\u001B[1m\u001B[31mSorry, that is incorrect :( No one gets the tile.\u001B[0m\n");
                    }

                    printPlayerCards(p1Tiles);

                    //Win Condition
                    if (p1TilesStatus[0] == 1 && p1TilesStatus[1] == 1 && p1TilesStatus[2] == 1 && p1TilesStatus[3] == 1 && p1TilesStatus[4] == 1
                            || p1TilesStatus[5] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[9] == 1
                            || p1TilesStatus[10] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[14] == 1
                            || p1TilesStatus[15] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[19] == 1
                            || p1TilesStatus[20] == 1 && p1TilesStatus[21] == 1 && p1TilesStatus[22] == 1 && p1TilesStatus[23] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[5] == 1 && p1TilesStatus[10] == 1 && p1TilesStatus[15] == 1 && p1TilesStatus[20] == 1
                            || p1TilesStatus[1] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[21] == 1
                            || p1TilesStatus[2] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[22] == 1
                            || p1TilesStatus[3] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[23] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[9] == 1 && p1TilesStatus[14] == 1 && p1TilesStatus[19] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[34m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player1", "you win!!!!");
                        System.exit(1);
                    }

                    System.out.println();
                    drawTileQuery();
                    System.out.println();
                }
                break;

            case 2: p1Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p1Tiles, 0, p1Tiles.length); p1Tiles[12] = "\u001B[34m\u001B[1m***\u001B[0m";

                p2Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p2Tiles, 0, p2Tiles.length); p2Tiles[12] = "\u001B[31m\u001B[1m***\u001B[0m";

                //Status of each tile (only centre tile, tile #13 (or index 12), should have the "claimed" status, 1)
                p1TilesStatus = new int[25]; p1TilesStatus[12] = 1;
                p2TilesStatus = new int[25]; p2TilesStatus[12] = 1;

                //Tutorial
                tutorialQuery(multiplayerTutorial);

                //Start Game
                startGameQuery();
                System.out.print("\u001B[0m");
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                //Display Player Cards
                printPlayerCards(p1Tiles, p2Tiles);

                //Initial Values for Tiles Drawn
                noWinners = false; tileLetter = ' '; tileDrawn = ""; questionGenerated = 0; playerGuessing = 0;

                //Ask to draw first tile
                System.out.println();
                drawTileQuery();
                System.out.println();

                //Draw Tiles
                while (!noWinners) {
                    Boolean correctAnswer = false;

                    tileDrawn = drawTile();
                    tileLetter = tileDrawn.charAt(0);
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\u001B[32m\u001B[1mTile Drawn: \u001B[4m" + tileDrawn + "\u001B[0m\n");
                    continueQuery();

                    //Pick Random Question
                    questionGenerated = (int)(Math.random() * 30 + 1);

                    //If answered correctly, give player tile. If not, no one gets the tile
                    correctAnswer = askQuestion(tileLetter, questionGenerated, aQuestions, sQuestions, hQuestions, eQuestions, mQuestions);

                    if (correctAnswer) {
                        System.out.print("\n\u001B[1m\u001B[32mCorrect! Which player guessed (1 or 2): \u001B[37m");
                        playerGuessing = input.nextInt();
                        //If invalid player number is inputted
                        while (playerGuessing != 1 && playerGuessing != 2) {
                            System.out.print("\u001B[1m\u001B[31mError: invalid player number. Please try again: \u001B[0m");
                            playerGuessing = input.nextInt();
                        }
                        //Give tile to player who guessed correctly
                        switch (playerGuessing) {
                            case 1: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[34m\u001B[4mPlayer1\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p1Tiles.length; i++) {
                                    if (tileDrawn.equals(p1Tiles[i])) {
                                        p1Tiles[i] = "\u001B[1m\u001B[34m" + p1Tiles[i] + "\u001B[0m";
                                        p1TilesStatus[i] = 1;
                                    }
                                } break;
                            case 2: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[31m\u001B[4mPlayer2\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p2Tiles.length; i++) {
                                    if (tileDrawn.equals(p2Tiles[i])) {
                                        p2Tiles[i] = "\u001B[1m\u001B[31m" + p2Tiles[i] + "\u001B[0m";
                                        p2TilesStatus[i] = 1;
                                    }
                                }
                        }
                    }
                    else {
                        System.out.println("\u001B[1m\u001B[31mSorry, that is incorrect :( No one gets the tile.\u001B[0m\n");
                    }

                    printPlayerCards(p1Tiles, p2Tiles);

                    //Player1 Win Condition
                    if (p1TilesStatus[0] == 1 && p1TilesStatus[1] == 1 && p1TilesStatus[2] == 1 && p1TilesStatus[3] == 1 && p1TilesStatus[4] == 1
                            || p1TilesStatus[5] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[9] == 1
                            || p1TilesStatus[10] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[14] == 1
                            || p1TilesStatus[15] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[19] == 1
                            || p1TilesStatus[20] == 1 && p1TilesStatus[21] == 1 && p1TilesStatus[22] == 1 && p1TilesStatus[23] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[5] == 1 && p1TilesStatus[10] == 1 && p1TilesStatus[15] == 1 && p1TilesStatus[20] == 1
                            || p1TilesStatus[1] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[21] == 1
                            || p1TilesStatus[2] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[22] == 1
                            || p1TilesStatus[3] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[23] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[9] == 1 && p1TilesStatus[14] == 1 && p1TilesStatus[19] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[32m%82s \u001B[4m\u001B[34m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player1", "you win!!!!");
                        System.exit(1);
                    }

                    //Player2 Win Condition
                    if (p2TilesStatus[0] == 1 && p2TilesStatus[1] == 1 && p2TilesStatus[2] == 1 && p2TilesStatus[3] == 1 && p2TilesStatus[4] == 1
                            || p2TilesStatus[5] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[7] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[9] == 1
                            || p2TilesStatus[10] == 1 && p2TilesStatus[11] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[13] == 1 && p2TilesStatus[14] == 1
                            || p2TilesStatus[15] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[17] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[19] == 1
                            || p2TilesStatus[20] == 1 && p2TilesStatus[21] == 1 && p2TilesStatus[22] == 1 && p2TilesStatus[23] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[0] == 1 && p2TilesStatus[5] == 1 && p2TilesStatus[10] == 1 && p2TilesStatus[15] == 1 && p2TilesStatus[20] == 1
                            || p2TilesStatus[1] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[11] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[21] == 1
                            || p2TilesStatus[2] == 1 && p2TilesStatus[7] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[17] == 1 && p2TilesStatus[22] == 1
                            || p2TilesStatus[3] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[13] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[23] == 1
                            || p2TilesStatus[4] == 1 && p2TilesStatus[9] == 1 && p2TilesStatus[14] == 1 && p2TilesStatus[19] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[0] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[4] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[31m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player2", "you win!!!!");
                        System.exit(1);
                    }

                    System.out.println();
                    drawTileQuery();
                    System.out.println();
                }

                break;

            case 3: p1Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p1Tiles, 0, p1Tiles.length); p1Tiles[12] = "\u001B[34m\u001B[1m***\u001B[0m";

                p2Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p2Tiles, 0, p2Tiles.length); p2Tiles[12] = "\u001B[31m\u001B[1m***\u001B[0m";

                p3Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p3Tiles, 0, p3Tiles.length); p3Tiles[12] = "\u001B[32m\u001B[1m***\u001B[0m";

                //Status of each tile (only centre tile, tile #13 (or index 12), should have the "claimed" status, 1)
                p1TilesStatus = new int[25]; p1TilesStatus[12] = 1;
                p2TilesStatus = new int[25]; p2TilesStatus[12] = 1;
                p3TilesStatus = new int[25]; p3TilesStatus[12] = 1;

                //Tutorial
                tutorialQuery(multiplayerTutorial);

                //Start Game
                startGameQuery();
                System.out.print("\u001B[0m");
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                //Display Player Cards
                printPlayerCards(p1Tiles, p2Tiles, p3Tiles);

                //Initial Values for Tiles Drawn
                noWinners = false; tileLetter = ' '; tileDrawn = ""; questionGenerated = 0; playerGuessing = 0;

                //Ask to draw first tile
                System.out.print("\n\n");
                drawTileQuery();
                System.out.print("\n\n");

                //Draw Tiles
                while (!noWinners) {
                    boolean correctAnswer = false;

                    tileDrawn = drawTile();
                    tileLetter = tileDrawn.charAt(0);
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\u001B[32m\u001B[1mTile Drawn: \u001B[4m" + tileDrawn + "\u001B[0m\n");
                    continueQuery();

                    //Pick Random Question
                    questionGenerated = (int)(Math.random() * 30 + 1);

                    //If answered correctly, give player tile. If not, no one gets the tile
                    correctAnswer = askQuestion(tileLetter, questionGenerated, aQuestions, sQuestions, hQuestions, eQuestions, mQuestions);

                    if (correctAnswer) {
                        System.out.print("\n\u001B[1m\u001B[32mCorrect! Which player guessed (1, 2, or 3): \u001B[37m");
                        playerGuessing = input.nextInt();
                        //If invalid player number is inputted
                        while (playerGuessing != 1 && playerGuessing != 2 && playerGuessing != 3) {
                            System.out.print("\u001B[1m\u001B[31mError: invalid player number. Please try again: \u001B[0m");
                            playerGuessing = input.nextInt();
                        }
                        switch (playerGuessing) {
                            case 1: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[34m\u001B[4mPlayer1\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p1Tiles.length; i++) {
                                    if (tileDrawn.equals(p1Tiles[i])) {
                                        p1Tiles[i] = "\u001B[1m\u001B[34m" + p1Tiles[i] + "\u001B[0m";
                                        p1TilesStatus[i] = 1;
                                    }
                                } break;
                            case 2: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[31m\u001B[4mPlayer2\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p2Tiles.length; i++) {
                                    if (tileDrawn.equals(p2Tiles[i])) {
                                        p2Tiles[i] = "\u001B[1m\u001B[31m" + p2Tiles[i] + "\u001B[0m";
                                        p2TilesStatus[i] = 1;
                                    }
                                } break;
                            case 3: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[32m\u001B[4mPlayer3\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p3Tiles.length; i++) {
                                    if (tileDrawn.equals(p3Tiles[i])) {
                                        p3Tiles[i] = "\u001B[1m\u001B[32m" + p3Tiles[i] + "\u001B[0m";
                                        p3TilesStatus[i] = 1;
                                    }
                                }
                        }
                    }
                    else {
                        System.out.println("\u001B[1m\u001B[31mSorry, that is incorrect :( No one gets the tile.\u001B[0m\n");
                    }

                    printPlayerCards(p1Tiles, p2Tiles, p3Tiles);

                    //Player1 Win Condition
                    if (p1TilesStatus[0] == 1 && p1TilesStatus[1] == 1 && p1TilesStatus[2] == 1 && p1TilesStatus[3] == 1 && p1TilesStatus[4] == 1
                            || p1TilesStatus[5] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[9] == 1
                            || p1TilesStatus[10] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[14] == 1
                            || p1TilesStatus[15] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[19] == 1
                            || p1TilesStatus[20] == 1 && p1TilesStatus[21] == 1 && p1TilesStatus[22] == 1 && p1TilesStatus[23] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[5] == 1 && p1TilesStatus[10] == 1 && p1TilesStatus[15] == 1 && p1TilesStatus[20] == 1
                            || p1TilesStatus[1] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[21] == 1
                            || p1TilesStatus[2] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[22] == 1
                            || p1TilesStatus[3] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[23] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[9] == 1 && p1TilesStatus[14] == 1 && p1TilesStatus[19] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[34m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player1", "you win!!!!");
                        System.exit(1);
                    }

                    //Player2 Win Condition
                    if (p2TilesStatus[0] == 1 && p2TilesStatus[1] == 1 && p2TilesStatus[2] == 1 && p2TilesStatus[3] == 1 && p2TilesStatus[4] == 1
                            || p2TilesStatus[5] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[7] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[9] == 1
                            || p2TilesStatus[10] == 1 && p2TilesStatus[11] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[13] == 1 && p2TilesStatus[14] == 1
                            || p2TilesStatus[15] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[17] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[19] == 1
                            || p2TilesStatus[20] == 1 && p2TilesStatus[21] == 1 && p2TilesStatus[22] == 1 && p2TilesStatus[23] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[0] == 1 && p2TilesStatus[5] == 1 && p2TilesStatus[10] == 1 && p2TilesStatus[15] == 1 && p2TilesStatus[20] == 1
                            || p2TilesStatus[1] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[11] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[21] == 1
                            || p2TilesStatus[2] == 1 && p2TilesStatus[7] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[17] == 1 && p2TilesStatus[22] == 1
                            || p2TilesStatus[3] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[13] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[23] == 1
                            || p2TilesStatus[4] == 1 && p2TilesStatus[9] == 1 && p2TilesStatus[14] == 1 && p2TilesStatus[19] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[0] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[4] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[31m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player2", "you win!!!!");
                        System.exit(1);
                    }

                    //Player3 Win Condition
                    if (p3TilesStatus[0] == 1 && p3TilesStatus[1] == 1 && p3TilesStatus[2] == 1 && p3TilesStatus[3] == 1 && p3TilesStatus[4] == 1
                            || p3TilesStatus[5] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[7] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[9] == 1
                            || p3TilesStatus[10] == 1 && p3TilesStatus[11] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[13] == 1 && p3TilesStatus[14] == 1
                            || p3TilesStatus[15] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[17] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[19] == 1
                            || p3TilesStatus[20] == 1 && p3TilesStatus[21] == 1 && p3TilesStatus[22] == 1 && p3TilesStatus[23] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[0] == 1 && p3TilesStatus[5] == 1 && p3TilesStatus[10] == 1 && p3TilesStatus[15] == 1 && p3TilesStatus[20] == 1
                            || p3TilesStatus[1] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[11] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[21] == 1
                            || p3TilesStatus[2] == 1 && p3TilesStatus[7] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[17] == 1 && p3TilesStatus[22] == 1
                            || p3TilesStatus[3] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[13] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[23] == 1
                            || p3TilesStatus[4] == 1 && p3TilesStatus[9] == 1 && p3TilesStatus[14] == 1 && p3TilesStatus[19] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[0] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[4] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[32m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player3", "you win!!!!");
                        System.exit(1);
                    }

                    System.out.print("\n\n");
                    drawTileQuery();
                    System.out.print("\n\n");
                } break;
            case 4: p1Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p1Tiles, 0, p1Tiles.length); p1Tiles[12] = "\u001B[34m\u001B[1m***\u001B[0m";

                p2Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p2Tiles, 0, p2Tiles.length); p2Tiles[12] = "\u001B[31m\u001B[1m***\u001B[0m";

                p3Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p3Tiles, 0, p3Tiles.length); p3Tiles[12] = "\u001B[32m\u001B[1m***\u001B[0m";

                p4Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p4Tiles, 0, p4Tiles.length); p4Tiles[12] = "\u001B[33m\u001B[1m***\u001B[0m";

                //Status of each tile (only centre tile, tile #13 (or index 12), should have the "claimed" status, 1)
                p1TilesStatus = new int[25]; p1TilesStatus[12] = 1;
                p2TilesStatus = new int[25]; p2TilesStatus[12] = 1;
                p3TilesStatus = new int[25]; p3TilesStatus[12] = 1;
                p4TilesStatus = new int[25]; p4TilesStatus[12] = 1;

                //Tutorial
                tutorialQuery(multiplayerTutorial);

                //Start Game
                startGameQuery();
                System.out.print("\u001B[0m");
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                //Display Player Cards
                printPlayerCards(p1Tiles, p2Tiles, p3Tiles, p4Tiles);

                //Initial Values for Tiles Drawn
                noWinners = false; tileLetter = ' '; tileDrawn = ""; questionGenerated = 0; playerGuessing = 0;

                //Ask to draw first tile
                System.out.print("\n\n");
                drawTileQuery();
                System.out.print("\n\n");

                //Draw Tiles
                while (!noWinners) {
                    boolean correctAnswer = false;

                    tileDrawn = drawTile();
                    tileLetter = tileDrawn.charAt(0);
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\u001B[32m\u001B[1mTile Drawn: \u001B[4m" + tileDrawn + "\u001B[0m\n");
                    continueQuery();

                    //Pick Random Question
                    questionGenerated = (int)(Math.random() * 30 + 1);

                    //If answered correctly, give player tile. If not, no one gets the tile
                    correctAnswer = askQuestion(tileLetter, questionGenerated, aQuestions, sQuestions, hQuestions, eQuestions, mQuestions);

                    if (correctAnswer) {
                        System.out.print("\n\u001B[1m\u001B[32mCorrect! Which player guessed (1, 2, 3, or 4): \u001B[37m");
                        playerGuessing = input.nextInt();
                        //If invalid player number is inputted
                        while (playerGuessing != 1 && playerGuessing != 2 && playerGuessing != 3 && playerGuessing != 4) {
                            System.out.print("\u001B[1m\u001B[31mError: invalid player number. Please try again: \u001B[0m");
                            playerGuessing = input.nextInt();
                        }
                        switch (playerGuessing) {
                            case 1: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[34m\u001B[4mPlayer1\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p1Tiles.length; i++) {
                                    if (tileDrawn.equals(p1Tiles[i])) {
                                        p1Tiles[i] = "\u001B[1m\u001B[34m" + p1Tiles[i] + "\u001B[0m";
                                        p1TilesStatus[i] = 1;
                                    }
                                } break;
                            case 2: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[31m\u001B[4mPlayer2\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p2Tiles.length; i++) {
                                    if (tileDrawn.equals(p2Tiles[i])) {
                                        p2Tiles[i] = "\u001B[1m\u001B[31m" + p2Tiles[i] + "\u001B[0m";
                                        p2TilesStatus[i] = 1;
                                    }
                                } break;
                            case 3: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[32m\u001B[4mPlayer3\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p3Tiles.length; i++) {
                                    if (tileDrawn.equals(p3Tiles[i])) {
                                        p3Tiles[i] = "\u001B[1m\u001B[32m" + p3Tiles[i] + "\u001B[0m";
                                        p3TilesStatus[i] = 1;
                                    }
                                } break;
                            case 4: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[33m\u001B[4mPlayer4\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p4Tiles.length; i++) {
                                    if (tileDrawn.equals(p4Tiles[i])) {
                                        p4Tiles[i] = "\u001B[1m\u001B[33m" + p4Tiles[i] + "\u001B[0m";
                                        p4TilesStatus[i] = 1;
                                    }
                                } break;
                        }
                    }
                    else {
                        System.out.println("\u001B[1m\u001B[31mSorry, that is incorrect :( No one gets the tile.\u001B[0m\n");
                    }

                    printPlayerCards(p1Tiles, p2Tiles, p3Tiles, p4Tiles);

                    //Player1 Win Condition
                    if (p1TilesStatus[0] == 1 && p1TilesStatus[1] == 1 && p1TilesStatus[2] == 1 && p1TilesStatus[3] == 1 && p1TilesStatus[4] == 1
                            || p1TilesStatus[5] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[9] == 1
                            || p1TilesStatus[10] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[14] == 1
                            || p1TilesStatus[15] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[19] == 1
                            || p1TilesStatus[20] == 1 && p1TilesStatus[21] == 1 && p1TilesStatus[22] == 1 && p1TilesStatus[23] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[5] == 1 && p1TilesStatus[10] == 1 && p1TilesStatus[15] == 1 && p1TilesStatus[20] == 1
                            || p1TilesStatus[1] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[21] == 1
                            || p1TilesStatus[2] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[22] == 1
                            || p1TilesStatus[3] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[23] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[9] == 1 && p1TilesStatus[14] == 1 && p1TilesStatus[19] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[34m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player1", "you win!!!!");
                        System.exit(1);
                    }

                    //Player2 Win Condition
                    if (p2TilesStatus[0] == 1 && p2TilesStatus[1] == 1 && p2TilesStatus[2] == 1 && p2TilesStatus[3] == 1 && p2TilesStatus[4] == 1
                            || p2TilesStatus[5] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[7] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[9] == 1
                            || p2TilesStatus[10] == 1 && p2TilesStatus[11] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[13] == 1 && p2TilesStatus[14] == 1
                            || p2TilesStatus[15] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[17] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[19] == 1
                            || p2TilesStatus[20] == 1 && p2TilesStatus[21] == 1 && p2TilesStatus[22] == 1 && p2TilesStatus[23] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[0] == 1 && p2TilesStatus[5] == 1 && p2TilesStatus[10] == 1 && p2TilesStatus[15] == 1 && p2TilesStatus[20] == 1
                            || p2TilesStatus[1] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[11] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[21] == 1
                            || p2TilesStatus[2] == 1 && p2TilesStatus[7] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[17] == 1 && p2TilesStatus[22] == 1
                            || p2TilesStatus[3] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[13] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[23] == 1
                            || p2TilesStatus[4] == 1 && p2TilesStatus[9] == 1 && p2TilesStatus[14] == 1 && p2TilesStatus[19] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[0] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[4] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[31m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player2", "you win!!!!");
                        System.exit(1);
                    }

                    //Player3 Win Condition
                    if (p3TilesStatus[0] == 1 && p3TilesStatus[1] == 1 && p3TilesStatus[2] == 1 && p3TilesStatus[3] == 1 && p3TilesStatus[4] == 1
                            || p3TilesStatus[5] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[7] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[9] == 1
                            || p3TilesStatus[10] == 1 && p3TilesStatus[11] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[13] == 1 && p3TilesStatus[14] == 1
                            || p3TilesStatus[15] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[17] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[19] == 1
                            || p3TilesStatus[20] == 1 && p3TilesStatus[21] == 1 && p3TilesStatus[22] == 1 && p3TilesStatus[23] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[0] == 1 && p3TilesStatus[5] == 1 && p3TilesStatus[10] == 1 && p3TilesStatus[15] == 1 && p3TilesStatus[20] == 1
                            || p3TilesStatus[1] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[11] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[21] == 1
                            || p3TilesStatus[2] == 1 && p3TilesStatus[7] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[17] == 1 && p3TilesStatus[22] == 1
                            || p3TilesStatus[3] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[13] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[23] == 1
                            || p3TilesStatus[4] == 1 && p3TilesStatus[9] == 1 && p3TilesStatus[14] == 1 && p3TilesStatus[19] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[0] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[4] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[32m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player3", "you win!!!!");
                        System.exit(1);
                    }

                    //Player4 Win Condition
                    if (p4TilesStatus[0] == 1 && p4TilesStatus[1] == 1 && p4TilesStatus[2] == 1 && p4TilesStatus[3] == 1 && p4TilesStatus[4] == 1
                            || p4TilesStatus[5] == 1 && p4TilesStatus[6] == 1 && p4TilesStatus[7] == 1 && p4TilesStatus[8] == 1 && p4TilesStatus[9] == 1
                            || p4TilesStatus[10] == 1 && p4TilesStatus[11] == 1 && p4TilesStatus[12] == 1 && p4TilesStatus[13] == 1 && p4TilesStatus[14] == 1
                            || p4TilesStatus[15] == 1 && p4TilesStatus[16] == 1 && p4TilesStatus[17] == 1 && p4TilesStatus[18] == 1 && p4TilesStatus[19] == 1
                            || p4TilesStatus[20] == 1 && p4TilesStatus[21] == 1 && p4TilesStatus[22] == 1 && p4TilesStatus[23] == 1 && p4TilesStatus[24] == 1
                            || p4TilesStatus[0] == 1 && p4TilesStatus[5] == 1 && p4TilesStatus[10] == 1 && p4TilesStatus[15] == 1 && p4TilesStatus[20] == 1
                            || p4TilesStatus[1] == 1 && p4TilesStatus[6] == 1 && p4TilesStatus[11] == 1 && p4TilesStatus[16] == 1 && p4TilesStatus[21] == 1
                            || p4TilesStatus[2] == 1 && p4TilesStatus[7] == 1 && p4TilesStatus[12] == 1 && p4TilesStatus[17] == 1 && p4TilesStatus[22] == 1
                            || p4TilesStatus[3] == 1 && p4TilesStatus[8] == 1 && p4TilesStatus[13] == 1 && p4TilesStatus[18] == 1 && p4TilesStatus[23] == 1
                            || p4TilesStatus[4] == 1 && p4TilesStatus[9] == 1 && p4TilesStatus[14] == 1 && p4TilesStatus[19] == 1 && p4TilesStatus[24] == 1
                            || p4TilesStatus[0] == 1 && p4TilesStatus[6] == 1 && p4TilesStatus[12] == 1 && p4TilesStatus[18] == 1 && p4TilesStatus[24] == 1
                            || p4TilesStatus[4] == 1 && p4TilesStatus[8] == 1 && p4TilesStatus[12] == 1 && p4TilesStatus[16] == 1 && p4TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[33m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player4", "you win!!!!");
                        System.exit(1);
                    }

                    System.out.print("\n\n");
                    drawTileQuery();
                    System.out.print("\n\n");
                } break;
            case 5: p1Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p1Tiles, 0, p1Tiles.length); p1Tiles[12] = "\u001B[34m\u001B[1m***\u001B[0m";

                p2Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p2Tiles, 0, p2Tiles.length); p2Tiles[12] = "\u001B[31m\u001B[1m***\u001B[0m";

                p3Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p3Tiles, 0, p3Tiles.length); p3Tiles[12] = "\u001B[32m\u001B[1m***\u001B[0m";

                p4Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p4Tiles, 0, p4Tiles.length); p4Tiles[12] = "\u001B[33m\u001B[1m***\u001B[0m";

                p5Tiles = new String[25];
                System.arraycopy(generateBoardNumbers(), 0, p5Tiles, 0, p5Tiles.length); p5Tiles[12] = "\u001B[35m\u001B[1m***\u001B[0m";

                //Status of each tile (only centre tile, tile #13 (or index 12), should have the "claimed" status, 1)
                p1TilesStatus = new int[25]; p1TilesStatus[12] = 1;
                p2TilesStatus = new int[25]; p2TilesStatus[12] = 1;
                p3TilesStatus = new int[25]; p3TilesStatus[12] = 1;
                p4TilesStatus = new int[25]; p4TilesStatus[12] = 1;
                p5TilesStatus = new int[25]; p5TilesStatus[12] = 1;

                //Tutorial
                tutorialQuery(multiplayerTutorial);

                //Start Game
                startGameQuery();
                System.out.print("\u001B[0m");
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                //Display Player Cards
                printPlayerCards(p1Tiles, p2Tiles, p3Tiles, p4Tiles, p5Tiles);

                //Initial Values for Tiles Drawn
                noWinners = false; tileLetter = ' '; tileDrawn = ""; questionGenerated = 0; playerGuessing = 0;

                //Ask to draw first tile
                System.out.print("\n\n");
                drawTileQuery();
                System.out.print("\n\n");

                //Draw Tiles
                while (!noWinners) {
                    boolean correctAnswer = false;

                    tileDrawn = drawTile();
                    tileLetter = tileDrawn.charAt(0);
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\u001B[32m\u001B[1mTile Drawn: \u001B[4m" + tileDrawn + "\u001B[0m\n");
                    continueQuery();

                    //Pick Random Question
                    questionGenerated = (int)(Math.random() * 30 + 1);

                    //If answered correctly, give player tile. If not, no one gets the tile
                    correctAnswer = askQuestion(tileLetter, questionGenerated, aQuestions, sQuestions, hQuestions, eQuestions, mQuestions);

                    if (correctAnswer) {
                        System.out.print("\n\u001B[1m\u001B[32mCorrect! Which player guessed (1, 2, 3, 4, or 5): \u001B[37m");
                        playerGuessing = input.nextInt();
                        //If invalid player number is inputted
                        while (playerGuessing != 1 && playerGuessing != 2 && playerGuessing != 3 && playerGuessing != 4 && playerGuessing != 5) {
                            System.out.print("\u001B[1m\u001B[31mError: invalid player number. Please try again: \u001B[0m");
                            playerGuessing = input.nextInt();
                        }
                        switch (playerGuessing) {
                            case 1: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[34m\u001B[4mPlayer1\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p1Tiles.length; i++) {
                                    if (tileDrawn.equals(p1Tiles[i])) {
                                        p1Tiles[i] = "\u001B[1m\u001B[34m" + p1Tiles[i] + "\u001B[0m";
                                        p1TilesStatus[i] = 1;
                                    }
                                } break;
                            case 2: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[31m\u001B[4mPlayer2\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p2Tiles.length; i++) {
                                    if (tileDrawn.equals(p2Tiles[i])) {
                                        p2Tiles[i] = "\u001B[1m\u001B[31m" + p2Tiles[i] + "\u001B[0m";
                                        p2TilesStatus[i] = 1;
                                    }
                                } break;
                            case 3: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[32m\u001B[4mPlayer3\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p3Tiles.length; i++) {
                                    if (tileDrawn.equals(p3Tiles[i])) {
                                        p3Tiles[i] = "\u001B[1m\u001B[32m" + p3Tiles[i] + "\u001B[0m";
                                        p3TilesStatus[i] = 1;
                                    }
                                } break;
                            case 4: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[33m\u001B[4mPlayer4\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p4Tiles.length; i++) {
                                    if (tileDrawn.equals(p4Tiles[i])) {
                                        p4Tiles[i] = "\u001B[1m\u001B[33m" + p4Tiles[i] + "\u001B[0m";
                                        p4TilesStatus[i] = 1;
                                    }
                                } break;
                            case 5: System.out.print("\n\u001B[1m\u001B[37mCongrats \u001B[35m\u001B[4mPlayer5\u001B[24m\u001B[37m, You won tile \u001B[0m\u001B[1m\u001B[4m" + tileDrawn + "\u001B[0m\u001B[1m\u001B[37m!\u001B[0m\n");
                                for (int i = 0; i < p5Tiles.length; i++) {
                                    if (tileDrawn.equals(p5Tiles[i])) {
                                        p5Tiles[i] = "\u001B[1m\u001B[35m" + p5Tiles[i] + "\u001B[0m";
                                        p5TilesStatus[i] = 1;
                                    }
                                }
                        }
                    }
                    else {
                        System.out.println("\u001B[1m\u001B[31mSorry, that is incorrect :( No one gets the tile.\u001B[0m\n");
                    }

                    printPlayerCards(p1Tiles, p2Tiles, p3Tiles, p4Tiles, p5Tiles);

                    //Player1 Win Condition
                    if (p1TilesStatus[0] == 1 && p1TilesStatus[1] == 1 && p1TilesStatus[2] == 1 && p1TilesStatus[3] == 1 && p1TilesStatus[4] == 1
                            || p1TilesStatus[5] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[9] == 1
                            || p1TilesStatus[10] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[14] == 1
                            || p1TilesStatus[15] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[19] == 1
                            || p1TilesStatus[20] == 1 && p1TilesStatus[21] == 1 && p1TilesStatus[22] == 1 && p1TilesStatus[23] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[5] == 1 && p1TilesStatus[10] == 1 && p1TilesStatus[15] == 1 && p1TilesStatus[20] == 1
                            || p1TilesStatus[1] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[11] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[21] == 1
                            || p1TilesStatus[2] == 1 && p1TilesStatus[7] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[17] == 1 && p1TilesStatus[22] == 1
                            || p1TilesStatus[3] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[13] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[23] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[9] == 1 && p1TilesStatus[14] == 1 && p1TilesStatus[19] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[0] == 1 && p1TilesStatus[6] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[18] == 1 && p1TilesStatus[24] == 1
                            || p1TilesStatus[4] == 1 && p1TilesStatus[8] == 1 && p1TilesStatus[12] == 1 && p1TilesStatus[16] == 1 && p1TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[34m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player1", "you win!!!!");
                        System.exit(1);
                    }

                    //Player2 Win Condition
                    if (p2TilesStatus[0] == 1 && p2TilesStatus[1] == 1 && p2TilesStatus[2] == 1 && p2TilesStatus[3] == 1 && p2TilesStatus[4] == 1
                            || p2TilesStatus[5] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[7] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[9] == 1
                            || p2TilesStatus[10] == 1 && p2TilesStatus[11] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[13] == 1 && p2TilesStatus[14] == 1
                            || p2TilesStatus[15] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[17] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[19] == 1
                            || p2TilesStatus[20] == 1 && p2TilesStatus[21] == 1 && p2TilesStatus[22] == 1 && p2TilesStatus[23] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[0] == 1 && p2TilesStatus[5] == 1 && p2TilesStatus[10] == 1 && p2TilesStatus[15] == 1 && p2TilesStatus[20] == 1
                            || p2TilesStatus[1] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[11] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[21] == 1
                            || p2TilesStatus[2] == 1 && p2TilesStatus[7] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[17] == 1 && p2TilesStatus[22] == 1
                            || p2TilesStatus[3] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[13] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[23] == 1
                            || p2TilesStatus[4] == 1 && p2TilesStatus[9] == 1 && p2TilesStatus[14] == 1 && p2TilesStatus[19] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[0] == 1 && p2TilesStatus[6] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[18] == 1 && p2TilesStatus[24] == 1
                            || p2TilesStatus[4] == 1 && p2TilesStatus[8] == 1 && p2TilesStatus[12] == 1 && p2TilesStatus[16] == 1 && p2TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[31m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player2", "you win!!!!");
                        System.exit(1);
                    }

                    //Player3 Win Condition
                    if (p3TilesStatus[0] == 1 && p3TilesStatus[1] == 1 && p3TilesStatus[2] == 1 && p3TilesStatus[3] == 1 && p3TilesStatus[4] == 1
                            || p3TilesStatus[5] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[7] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[9] == 1
                            || p3TilesStatus[10] == 1 && p3TilesStatus[11] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[13] == 1 && p3TilesStatus[14] == 1
                            || p3TilesStatus[15] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[17] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[19] == 1
                            || p3TilesStatus[20] == 1 && p3TilesStatus[21] == 1 && p3TilesStatus[22] == 1 && p3TilesStatus[23] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[0] == 1 && p3TilesStatus[5] == 1 && p3TilesStatus[10] == 1 && p3TilesStatus[15] == 1 && p3TilesStatus[20] == 1
                            || p3TilesStatus[1] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[11] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[21] == 1
                            || p3TilesStatus[2] == 1 && p3TilesStatus[7] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[17] == 1 && p3TilesStatus[22] == 1
                            || p3TilesStatus[3] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[13] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[23] == 1
                            || p3TilesStatus[4] == 1 && p3TilesStatus[9] == 1 && p3TilesStatus[14] == 1 && p3TilesStatus[19] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[0] == 1 && p3TilesStatus[6] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[18] == 1 && p3TilesStatus[24] == 1
                            || p3TilesStatus[4] == 1 && p3TilesStatus[8] == 1 && p3TilesStatus[12] == 1 && p3TilesStatus[16] == 1 && p3TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[32m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player3", "you win!!!!");
                        System.exit(1);
                    }

                    //Player4 Win Condition
                    if (p4TilesStatus[0] == 1 && p4TilesStatus[1] == 1 && p4TilesStatus[2] == 1 && p4TilesStatus[3] == 1 && p4TilesStatus[4] == 1
                            || p4TilesStatus[5] == 1 && p4TilesStatus[6] == 1 && p4TilesStatus[7] == 1 && p4TilesStatus[8] == 1 && p4TilesStatus[9] == 1
                            || p4TilesStatus[10] == 1 && p4TilesStatus[11] == 1 && p4TilesStatus[12] == 1 && p4TilesStatus[13] == 1 && p4TilesStatus[14] == 1
                            || p4TilesStatus[15] == 1 && p4TilesStatus[16] == 1 && p4TilesStatus[17] == 1 && p4TilesStatus[18] == 1 && p4TilesStatus[19] == 1
                            || p4TilesStatus[20] == 1 && p4TilesStatus[21] == 1 && p4TilesStatus[22] == 1 && p4TilesStatus[23] == 1 && p4TilesStatus[24] == 1
                            || p4TilesStatus[0] == 1 && p4TilesStatus[5] == 1 && p4TilesStatus[10] == 1 && p4TilesStatus[15] == 1 && p4TilesStatus[20] == 1
                            || p4TilesStatus[1] == 1 && p4TilesStatus[6] == 1 && p4TilesStatus[11] == 1 && p4TilesStatus[16] == 1 && p4TilesStatus[21] == 1
                            || p4TilesStatus[2] == 1 && p4TilesStatus[7] == 1 && p4TilesStatus[12] == 1 && p4TilesStatus[17] == 1 && p4TilesStatus[22] == 1
                            || p4TilesStatus[3] == 1 && p4TilesStatus[8] == 1 && p4TilesStatus[13] == 1 && p4TilesStatus[18] == 1 && p4TilesStatus[23] == 1
                            || p4TilesStatus[4] == 1 && p4TilesStatus[9] == 1 && p4TilesStatus[14] == 1 && p4TilesStatus[19] == 1 && p4TilesStatus[24] == 1
                            || p4TilesStatus[0] == 1 && p4TilesStatus[6] == 1 && p4TilesStatus[12] == 1 && p4TilesStatus[18] == 1 && p4TilesStatus[24] == 1
                            || p4TilesStatus[4] == 1 && p4TilesStatus[8] == 1 && p4TilesStatus[12] == 1 && p4TilesStatus[16] == 1 && p4TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[33m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player4", "you win!!!!");
                        System.exit(1);
                    }

                    //Player5 Win Condition
                    if (p5TilesStatus[0] == 1 && p5TilesStatus[1] == 1 && p5TilesStatus[2] == 1 && p5TilesStatus[3] == 1 && p5TilesStatus[4] == 1
                            || p5TilesStatus[5] == 1 && p5TilesStatus[6] == 1 && p5TilesStatus[7] == 1 && p5TilesStatus[8] == 1 && p5TilesStatus[9] == 1
                            || p5TilesStatus[10] == 1 && p5TilesStatus[11] == 1 && p5TilesStatus[12] == 1 && p5TilesStatus[13] == 1 && p5TilesStatus[14] == 1
                            || p5TilesStatus[15] == 1 && p5TilesStatus[16] == 1 && p5TilesStatus[17] == 1 && p5TilesStatus[18] == 1 && p5TilesStatus[19] == 1
                            || p5TilesStatus[20] == 1 && p5TilesStatus[21] == 1 && p5TilesStatus[22] == 1 && p5TilesStatus[23] == 1 && p5TilesStatus[24] == 1
                            || p5TilesStatus[0] == 1 && p5TilesStatus[5] == 1 && p5TilesStatus[10] == 1 && p5TilesStatus[15] == 1 && p5TilesStatus[20] == 1
                            || p5TilesStatus[1] == 1 && p5TilesStatus[6] == 1 && p5TilesStatus[11] == 1 && p5TilesStatus[16] == 1 && p5TilesStatus[21] == 1
                            || p5TilesStatus[2] == 1 && p5TilesStatus[7] == 1 && p5TilesStatus[12] == 1 && p5TilesStatus[17] == 1 && p5TilesStatus[22] == 1
                            || p5TilesStatus[3] == 1 && p5TilesStatus[8] == 1 && p5TilesStatus[13] == 1 && p5TilesStatus[18] == 1 && p5TilesStatus[23] == 1
                            || p5TilesStatus[4] == 1 && p5TilesStatus[9] == 1 && p5TilesStatus[14] == 1 && p5TilesStatus[19] == 1 && p5TilesStatus[24] == 1
                            || p5TilesStatus[0] == 1 && p5TilesStatus[6] == 1 && p5TilesStatus[12] == 1 && p5TilesStatus[18] == 1 && p5TilesStatus[24] == 1
                            || p5TilesStatus[4] == 1 && p5TilesStatus[8] == 1 && p5TilesStatus[12] == 1 && p5TilesStatus[16] == 1 && p5TilesStatus[20] == 1) {
                        System.out.printf("\n\n\u001B[1m\u001B[37m%82s \u001B[4m\u001B[35m%s\u001B[37m\u001B[24m, %s", "Congrats", "Player5", "you win!!!!");
                        System.exit(1);
                    }

                    System.out.print("\n\n");
                    drawTileQuery();
                    System.out.print("\n\n");
                } break;
            case 6:
        }
    }

    public static String[] generateBoardNumbers() {
        String[] boardNumbers = new String[25];

        //"A" Numbers
        int[] chosenANums = new int[5];
        for (int i = 0, j = 0; i <= 4; i++, j++) {
            int num = generateUniqueNum(j, chosenANums);

            //Add number to board
            if (num < 10)
                boardNumbers[i] = "A0" + num;
            else
                boardNumbers[i] = "A" + num;

            //Add to list of A #'s already on board
            chosenANums[i] = num;
        }
        //"S" Numbers
        int[] chosenSNums = new int[5];
        for (int i = 5, j = 0; i <= 9; i++, j++) {
            int num = generateUniqueNum(j, chosenSNums);

            //Add number to board
            if (num < 10)
                boardNumbers[i] = "S0" + num;
            else
                boardNumbers[i] = "S" + num;

            //Add to list of S #'s already on board
            chosenSNums[j] = num;
        }
        //"H" Numbers
        int[] chosenHNums = new int[5];
        for (int i = 10, j = 0; i <= 14; i++, j++) {
            int num = generateUniqueNum(j, chosenHNums);

            //Add number to board
            if (num < 10)
                boardNumbers[i] = "H0" + num;
            else
                boardNumbers[i] = "H" + num;

            //Add to list of H #'s already on board
            chosenHNums[j] = num;
        }
        //"E" Numbers
        int[] chosenENums = new int[5];
        for (int i = 15, j = 0; i <= 19; i++, j++) {
            int num = generateUniqueNum(j, chosenENums);

            //Add number to board
            if (num < 10)
                boardNumbers[i] = "E0" + num;
            else
                boardNumbers[i] = "E" + num;

            //Add to list of E #'s already on board
            chosenENums[j] = num;
        }
        //"M" Numbers
        int[] chosenMNums = new int[5];
        for (int i = 20, j = 0; i <= 24; i++, j++) {
            int num = generateUniqueNum(j, chosenMNums);

            //Add number to board
            if (num < 10)
                boardNumbers[i] = "M0" + num;
            else
                boardNumbers[i] = "M" + num;

            //Add to list of M #'s already on board
            chosenMNums[j] = num;
        }

        return boardNumbers;
    }
    public static int generateUniqueNum(int currentNumIndex, int[] currentNumList) {
        int num = 0;
        Boolean isDuplicate = false;
        do {
            isDuplicate = false;
            num = (int)(Math.random() * 30 + 1);
            for (int j = 0; j < currentNumIndex; j++)
                if (num == currentNumList[j])
                    isDuplicate = true;
        } while (isDuplicate);

        return num;
    }
    public static String drawTile() {
        Scanner input = new Scanner(System.in);
        Boolean relevantTile = false; int category = 0; int tileNumber = 0; char tileLetter = ' '; String tileDrawn = "";
        while (!relevantTile) {
            category = (int)(Math.random() * 5 + 1);
            tileNumber = (int)(Math.random() * 30 + 1);
            switch (category) {
                case 1: tileLetter = 'A'; break;
                case 2: tileLetter = 'S'; break;
                case 3: tileLetter = 'H'; break;
                case 4: tileLetter = 'E'; break;
                case 5: tileLetter = 'M';
            }

            if (tileNumber < 10)
                tileDrawn = "" + tileLetter + "0" + tileNumber;
            else
                tileDrawn = "" + tileLetter + tileNumber;

            System.out.print("Does anyone need the tile \u001B[4m\u001B[1m" + tileDrawn + "\u001B[0m (Y/N): ");
            String response = input.next();
            while (!(response.equalsIgnoreCase("Y")) && !(response.equalsIgnoreCase("N"))
                && !(response.equalsIgnoreCase("Yes")) && !(response.equalsIgnoreCase("No"))) {
                System.out.println("\u001B[1m\u001B[31mError: invalid input. Please try again.\u001B[0m");
                System.out.print("Does anyone need the tile \u001B[4m\u001B[1m" + tileDrawn + "\u001B[0m (Y/N): ");
                response = input.next();
            }
            if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
                relevantTile = true;
            }
            else
                System.out.println("Okay, drawing new tile...");
        }

        return tileDrawn;
    }
    public static void displayQuestion(String[] questions, int questionNumber) {
        System.out.println(questions[questionNumber - 1] + "\n");
        System.out.print("Ans: ");
    }
    public static void tutorialQuery(String tutorial) {
        Scanner tutorialInput = new Scanner(System.in);

        System.out.print("\nNeed the tutorial? (Y/N): ");
        String responseToTutorial = tutorialInput.next();
        while (!(responseToTutorial.equalsIgnoreCase("Y")) && !(responseToTutorial.equalsIgnoreCase("N"))) {
            System.out.print("\u001B[1m\u001B[31mInvalid answer. Please answer (Y/N): \u001B[0m");
            responseToTutorial = tutorialInput.next();
        }
        Boolean tutorialNeeded = (responseToTutorial.equalsIgnoreCase("Y")) ? true : false;
        //Print tutorial if needed
        if (tutorialNeeded) {
            System.out.println(tutorial);
        }
    }
    public static void startGameQuery() {
        Scanner startInput = new Scanner(System.in);
        System.out.printf("\u001B[32m\u001B[1m\n%102s\u001B[37m", "Type \"start\" to begin the game: ");
        Boolean gameStarted = (startInput.next().equalsIgnoreCase("start")) ? true : false;
        while (!gameStarted) {
            System.out.printf("\u001B[31m\u001B[1m%112s\n\u001B[32m%102s\u001B[37m", "Error: invalid start input. Please try again.", "Type \"start\" to begin the game: ");
            gameStarted = (startInput.next().equalsIgnoreCase("start")) ? true : false;
        }
    }
    public static void continueQuery() {
        Scanner continueInput = new Scanner(System.in);
        System.out.print("\u001B[1mType \"c\" when ready for the question: \u001B[0m");
        String answer = continueInput.next();

        while (!(answer.equalsIgnoreCase("c"))) {
            System.out.println("\u001B[1m\u001B[31mError: invalid input. Please try again.");
            System.out.print("\u001B[0m\u001B[1mType \"c\" when ready for the question: \u001B[0m");
            answer = continueInput.next();
        }

        System.out.print("\u001B[0m\n");
    }
    public static void drawTileQuery() {
        Scanner drawInput = new Scanner(System.in);
        System.out.print("\u001B[1mType \"d\" to draw the next tile: \u001B[0m");
        String answer = drawInput.next();

        while (!(answer.equalsIgnoreCase("d"))) {
            System.out.println("\u001B[1m\u001B[31mError: invalid input. Please try again.");
            System.out.print("\u001B[0m\u001B[1mType \"d\" to draw the next tile: \u001B[0m");
            answer = drawInput.next();
        }

        System.out.print("\u001B[0m");
    }
    public static void printPlayerCards(String[] cardNums) {
        System.out.printf("%65s\u001B[1m%s\n\n%82s\u001B[4m\u001B[34m%s\u001B[0m\n\n%103s\n%103s\n%74s%s\n%103s\n%74s%s\n%103s\n%74s%s\n%103s\n%74s%s\n%103s\n%74s%s\n%103s",
                "", "**Here's what your card looks like currently**",
                "", "Player Card",
                "    A     S     H    'E     M   ",
                "-------------------------------",
                "| ", cardNums[0] + " | " + cardNums[5] + " | " + cardNums[10] + " | " + cardNums[15] + " | " + cardNums[20] + " |",
                "-------------------------------",
                "| ", cardNums[1] + " | " + cardNums[6] + " | " + cardNums[11] + " | " + cardNums[16] + " | " + cardNums[21] + " |",
                "-------------------------------",
                "| ", cardNums[2] + " | " + cardNums[7] + " | " + cardNums[12] + " | " + cardNums[17] + " | " + cardNums[22] + " |",
                "-------------------------------",
                "| ", cardNums[3] + " | " + cardNums[8] + " | " + cardNums[13] + " | " + cardNums[18] + " | " + cardNums[23] + " |",
                "-------------------------------",
                "| ", cardNums[4] + " | " + cardNums[9] + " | " + cardNums[14] + " | " + cardNums[19] + " | " + cardNums[24] + " |",
                "-------------------------------");
    }

    public static void printPlayerCards(String[] firstCardNums, String[] secondCardNums) {
        System.out.printf("%61s\u001B[1m%s\n\n%58s\u001B[4m\u001B[34m%s\u001B[24m%31s\u001B[4m\u001B[31m%s\u001B[0m\n\n%124s\n%127s\n%52s%s\n%127s\n%52s%s\n%127s\n%52s%s\n%127s\n%52s%s\n%127s\n%52s%s\n%127s",
                "", "**Here's what each player's card looks like currently**",
                "", "Player 1's Card", "", "Player 2's Card",
                "A     S     H    'E     M                     A     S     H    'E     M",
                "-------------------------------               -------------------------------",
                "| ", firstCardNums[0] + " | " + firstCardNums[5] + " | " + firstCardNums[10] + " | " + firstCardNums[15] + " | " + firstCardNums[20] + " |               | " + secondCardNums[0] + " | " + secondCardNums[5] + " | " + secondCardNums[10] + " | " + secondCardNums[15] + " | " + secondCardNums[20] + " |",
                "-------------------------------               -------------------------------",
                "| ", firstCardNums[1] + " | " + firstCardNums[6] + " | " + firstCardNums[11] + " | " + firstCardNums[16] + " | " + firstCardNums[21] + " |               | " + secondCardNums[1] + " | " + secondCardNums[6] + " | " + secondCardNums[11] + " | " + secondCardNums[16] + " | " + secondCardNums[21] + " |",
                "-------------------------------               -------------------------------",
                "| ", firstCardNums[2] + " | " + firstCardNums[7] + " | " + firstCardNums[12] + " | " + firstCardNums[17] + " | " + firstCardNums[22] + " |               | " + secondCardNums[2] + " | " + secondCardNums[7] + " | " + secondCardNums[12] + " | " + secondCardNums[17] + " | " + secondCardNums[22] + " |",
                "-------------------------------               -------------------------------",
                "| ", firstCardNums[3] + " | " + firstCardNums[8] + " | " + firstCardNums[13] + " | " + firstCardNums[18] + " | " + firstCardNums[23] + " |               | " + secondCardNums[3] + " | " + secondCardNums[8] + " | " + secondCardNums[13] + " | " + secondCardNums[18] + " | " + secondCardNums[23] + " |",
                "-------------------------------               -------------------------------",
                "| ", firstCardNums[4] + " | " + firstCardNums[9] + " | " + firstCardNums[14] + " | " + firstCardNums[19] + " | " + firstCardNums[24] + " |               | " + secondCardNums[4] + " | " + secondCardNums[9] + " | " + secondCardNums[14] + " | " + secondCardNums[19] + " | " + secondCardNums[24] + " |",
                "-------------------------------               -------------------------------");
    }
    public static void printPlayerCards(String[] firstCardNums, String[] secondCardNums, String[] thirdCardNums) {
        System.out.printf("%61s\u001B[1m%s\n\n%34s\u001B[4m\u001B[34m%s\u001B[24m%31s\u001B[4m\u001B[31m%s\u001B[24m%31s\u001B[4m\u001B[32m%s\u001B[0m\n\n%146s\n%149s\n%28s%s\n%149s\n%28s%s\n%149s\n%28s%s\n%149s\n%28s%s\n%149s\n%28s%s\n%149s",
                "", "**Here's what each player's card looks like currently**",
                "", "Player 1's Card", "", "Player 2's Card", "", "Player 3's Card",
                "A     S     H    'E     M                     A     S     H    'E     M                     A     S     H    'E     M",
                "-------------------------------               -------------------------------               -------------------------------",
                "| ", firstCardNums[0] + " | " + firstCardNums[5] + " | " + firstCardNums[10] + " | " + firstCardNums[15] + " | " + firstCardNums[20] + " |               | " + secondCardNums[0] + " | " + secondCardNums[5] + " | " + secondCardNums[10] + " | " + secondCardNums[15] + " | " + secondCardNums[20] + " |               | " + thirdCardNums[0] + " | " + thirdCardNums[5] + " | " + thirdCardNums[10] + " | " + thirdCardNums[15] + " | " + thirdCardNums[20] + " |",
                "-------------------------------               -------------------------------               -------------------------------",
                "| ", firstCardNums[1] + " | " + firstCardNums[6] + " | " + firstCardNums[11] + " | " + firstCardNums[16] + " | " + firstCardNums[21] + " |               | " + secondCardNums[1] + " | " + secondCardNums[6] + " | " + secondCardNums[11] + " | " + secondCardNums[16] + " | " + secondCardNums[21] + " |               | " + thirdCardNums[1] + " | " + thirdCardNums[6] + " | " + thirdCardNums[11] + " | " + thirdCardNums[16] + " | " + thirdCardNums[21] + " |",
                "-------------------------------               -------------------------------               -------------------------------",
                "| ", firstCardNums[2] + " | " + firstCardNums[7] + " | " + firstCardNums[12] + " | " + firstCardNums[17] + " | " + firstCardNums[22] + " |               | " + secondCardNums[2] + " | " + secondCardNums[7] + " | " + secondCardNums[12] + " | " + secondCardNums[17] + " | " + secondCardNums[22] + " |               | " + thirdCardNums[2] + " | " + thirdCardNums[7] + " | " + thirdCardNums[12] + " | " + thirdCardNums[17] + " | " + thirdCardNums[22] + " |",
                "-------------------------------               -------------------------------               -------------------------------",
                "| ", firstCardNums[3] + " | " + firstCardNums[8] + " | " + firstCardNums[13] + " | " + firstCardNums[18] + " | " + firstCardNums[23] + " |               | " + secondCardNums[3] + " | " + secondCardNums[8] + " | " + secondCardNums[13] + " | " + secondCardNums[18] + " | " + secondCardNums[23] + " |               | " + thirdCardNums[3] + " | " + thirdCardNums[8] + " | " + thirdCardNums[13] + " | " + thirdCardNums[18] + " | " + thirdCardNums[23] + " |",
                "-------------------------------               -------------------------------               -------------------------------",
                "| ", firstCardNums[4] + " | " + firstCardNums[9] + " | " + firstCardNums[14] + " | " + firstCardNums[19] + " | " + firstCardNums[24] + " |               | " + secondCardNums[4] + " | " + secondCardNums[9] + " | " + secondCardNums[14] + " | " + secondCardNums[19] + " | " + secondCardNums[24] + " |               | " + thirdCardNums[4] + " | " + thirdCardNums[9] + " | " + thirdCardNums[14] + " | " + thirdCardNums[19] + " | " + thirdCardNums[24] + " |",
                "-------------------------------               -------------------------------               -------------------------------");
    }

    public static void printPlayerCards(String[] firstCardNums, String[] secondCardNums, String[] thirdCardNums, String[] fourthCardNums) {
        System.out.printf("%61s\u001B[1m%s\n\n%24s\u001B[4m\u001B[34m%s\u001B[24m%23s\u001B[4m\u001B[31m%s\u001B[24m%23s\u001B[4m\u001B[32m%s\u001B[24m%23s\u001B[4m\u001B[33m%s\u001B[0m\n\n%158s\n%161s\n%18s%s\n%161s\n%18s%s\n%161s\n%18s%s\n%161s\n%18s%s\n%161s\n%18s%s\n%161s",
                "", "**Here's what each player's card looks like currently**",
                "", "Player 1's Card", "", "Player 2's Card", "", "Player 3's Card", "", "Player 4's Card",
                "A     S     H    'E     M             A     S     H    'E     M             A     S     H    'E     M             A     S     H    'E     M",
                "-------------------------------       -------------------------------       -------------------------------       -------------------------------",
                "| ", firstCardNums[0] + " | " + firstCardNums[5] + " | " + firstCardNums[10] + " | " + firstCardNums[15] + " | " + firstCardNums[20] + " |       | " + secondCardNums[0] + " | " + secondCardNums[5] + " | " + secondCardNums[10] + " | " + secondCardNums[15] + " | " + secondCardNums[20] + " |       | " + thirdCardNums[0] + " | " + thirdCardNums[5] + " | " + thirdCardNums[10] + " | " + thirdCardNums[15] + " | " + thirdCardNums[20] + " |       | " + fourthCardNums[0] + " | " + fourthCardNums[5] + " | " + fourthCardNums[10] + " | " + fourthCardNums[15] + " | " + fourthCardNums[20] + " |",
                "-------------------------------       -------------------------------       -------------------------------       -------------------------------",
                "| ", firstCardNums[1] + " | " + firstCardNums[6] + " | " + firstCardNums[11] + " | " + firstCardNums[16] + " | " + firstCardNums[21] + " |       | " + secondCardNums[1] + " | " + secondCardNums[6] + " | " + secondCardNums[11] + " | " + secondCardNums[16] + " | " + secondCardNums[21] + " |       | " + thirdCardNums[1] + " | " + thirdCardNums[6] + " | " + thirdCardNums[11] + " | " + thirdCardNums[16] + " | " + thirdCardNums[21] + " |       | " + fourthCardNums[1] + " | " + fourthCardNums[6] + " | " + fourthCardNums[11] + " | " + fourthCardNums[16] + " | " + fourthCardNums[21] + " |",
                "-------------------------------       -------------------------------       -------------------------------       -------------------------------",
                "| ", firstCardNums[2] + " | " + firstCardNums[7] + " | " + firstCardNums[12] + " | " + firstCardNums[17] + " | " + firstCardNums[22] + " |       | " + secondCardNums[2] + " | " + secondCardNums[7] + " | " + secondCardNums[12] + " | " + secondCardNums[17] + " | " + secondCardNums[22] + " |       | " + thirdCardNums[2] + " | " + thirdCardNums[7] + " | " + thirdCardNums[12] + " | " + thirdCardNums[17] + " | " + thirdCardNums[22] + " |       | " + fourthCardNums[2] + " | " + fourthCardNums[7] + " | " + fourthCardNums[12] + " | " + fourthCardNums[17] + " | " + fourthCardNums[22] + " |",
                "-------------------------------       -------------------------------       -------------------------------       -------------------------------",
                "| ", firstCardNums[3] + " | " + firstCardNums[8] + " | " + firstCardNums[13] + " | " + firstCardNums[18] + " | " + firstCardNums[23] + " |       | " + secondCardNums[3] + " | " + secondCardNums[8] + " | " + secondCardNums[13] + " | " + secondCardNums[18] + " | " + secondCardNums[23] + " |       | " + thirdCardNums[3] + " | " + thirdCardNums[8] + " | " + thirdCardNums[13] + " | " + thirdCardNums[18] + " | " + thirdCardNums[23] + " |       | " + fourthCardNums[3] + " | " + fourthCardNums[8] + " | " + fourthCardNums[13] + " | " + fourthCardNums[18] + " | " + fourthCardNums[23] + " |",
                "-------------------------------       -------------------------------       -------------------------------       -------------------------------",
                "| ", firstCardNums[4] + " | " + firstCardNums[9] + " | " + firstCardNums[14] + " | " + firstCardNums[19] + " | " + firstCardNums[24] + " |       | " + secondCardNums[4] + " | " + secondCardNums[9] + " | " + secondCardNums[14] + " | " + secondCardNums[19] + " | " + secondCardNums[24] + " |       | " + thirdCardNums[4] + " | " + thirdCardNums[9] + " | " + thirdCardNums[14] + " | " + thirdCardNums[19] + " | " + thirdCardNums[24] + " |       | " + fourthCardNums[4] + " | " + fourthCardNums[9] + " | " + fourthCardNums[14] + " | " + fourthCardNums[19] + " | " + fourthCardNums[24] + " |",
                "-------------------------------       -------------------------------       -------------------------------       -------------------------------");
    }

    public static void printPlayerCards(String[] firstCardNums, String[] secondCardNums, String[] thirdCardNums, String[] fourthCardNums, String[] fifthCardNums) {
        System.out.printf("%60s\u001B[1m%s\n\n%10s\u001B[4m\u001B[34m%s\u001B[24m%20s\u001B[4m\u001B[31m%s\u001B[24m%20s\u001B[4m\u001B[32m%s\u001B[24m%20s\u001B[4m\u001B[33m%s\u001B[24m%20s\u001B[4m\u001B[35m%s\u001B[0m\n\n%170s\n%173s\n%4s%s\n%173s\n%4s%s\n%173s\n%4s%s\n%173s\n%4s%s\n%173s\n%4s%s\n%173s",
                "", "**Here's what each player's card looks like currently**",
                "", "Player 1's Card", "", "Player 2's Card", "", "Player 3's Card", "", "Player 4's Card", "", "Player 5's Card",
                "A     S     H    'E     M          A     S     H    'E     M          A     S     H    'E     M          A     S     H    'E     M          A     S     H    'E     M",
                "-------------------------------    -------------------------------    -------------------------------    -------------------------------    -------------------------------",
                "| ", firstCardNums[0] + " | " + firstCardNums[5] + " | " + firstCardNums[10] + " | " + firstCardNums[15] + " | " + firstCardNums[20] + " |    | " + secondCardNums[0] + " | " + secondCardNums[5] + " | " + secondCardNums[10] + " | " + secondCardNums[15] + " | " + secondCardNums[20] + " |    | " + thirdCardNums[0] + " | " + thirdCardNums[5] + " | " + thirdCardNums[10] + " | " + thirdCardNums[15] + " | " + thirdCardNums[20] + " |    | " + fourthCardNums[0] + " | " + fourthCardNums[5] + " | " + fourthCardNums[10] + " | " + fourthCardNums[15] + " | " + fourthCardNums[20] + " |    | " + fifthCardNums[0] + " | " + fifthCardNums[5] + " | " + fifthCardNums[10] + " | " + fifthCardNums[15] + " | " + fifthCardNums[20] + " |",
                "-------------------------------    -------------------------------    -------------------------------    -------------------------------    -------------------------------",
                "| ", firstCardNums[1] + " | " + firstCardNums[6] + " | " + firstCardNums[11] + " | " + firstCardNums[16] + " | " + firstCardNums[21] + " |    | " + secondCardNums[1] + " | " + secondCardNums[6] + " | " + secondCardNums[11] + " | " + secondCardNums[16] + " | " + secondCardNums[21] + " |    | " + thirdCardNums[1] + " | " + thirdCardNums[6] + " | " + thirdCardNums[11] + " | " + thirdCardNums[16] + " | " + thirdCardNums[21] + " |    | " + fourthCardNums[1] + " | " + fourthCardNums[6] + " | " + fourthCardNums[11] + " | " + fourthCardNums[16] + " | " + fourthCardNums[21] + " |    | " + fifthCardNums[1] + " | " + fifthCardNums[6] + " | " + fifthCardNums[11] + " | " + fifthCardNums[16] + " | " + fifthCardNums[21] + " |",
                "-------------------------------    -------------------------------    -------------------------------    -------------------------------    -------------------------------",
                "| ", firstCardNums[2] + " | " + firstCardNums[7] + " | " + firstCardNums[12] + " | " + firstCardNums[17] + " | " + firstCardNums[22] + " |    | " + secondCardNums[2] + " | " + secondCardNums[7] + " | " + secondCardNums[12] + " | " + secondCardNums[17] + " | " + secondCardNums[22] + " |    | " + thirdCardNums[2] + " | " + thirdCardNums[7] + " | " + thirdCardNums[12] + " | " + thirdCardNums[17] + " | " + thirdCardNums[22] + " |    | " + fourthCardNums[2] + " | " + fourthCardNums[7] + " | " + fourthCardNums[12] + " | " + fourthCardNums[17] + " | " + fourthCardNums[22] + " |    | " + fifthCardNums[2] + " | " + fifthCardNums[7] + " | " + fifthCardNums[12] + " | " + fifthCardNums[17] + " | " + fifthCardNums[22] + " |",
                "-------------------------------    -------------------------------    -------------------------------    -------------------------------    -------------------------------",
                "| ", firstCardNums[3] + " | " + firstCardNums[8] + " | " + firstCardNums[13] + " | " + firstCardNums[18] + " | " + firstCardNums[23] + " |    | " + secondCardNums[3] + " | " + secondCardNums[8] + " | " + secondCardNums[13] + " | " + secondCardNums[18] + " | " + secondCardNums[23] + " |    | " + thirdCardNums[3] + " | " + thirdCardNums[8] + " | " + thirdCardNums[13] + " | " + thirdCardNums[18] + " | " + thirdCardNums[23] + " |    | " + fourthCardNums[3] + " | " + fourthCardNums[8] + " | " + fourthCardNums[13] + " | " + fourthCardNums[18] + " | " + fourthCardNums[23] + " |    | " + fifthCardNums[3] + " | " + fifthCardNums[8] + " | " + fifthCardNums[13] + " | " + fifthCardNums[18] + " | " + fifthCardNums[23] + " |",
                "-------------------------------    -------------------------------    -------------------------------    -------------------------------    -------------------------------",
                "| ", firstCardNums[4] + " | " + firstCardNums[9] + " | " + firstCardNums[14] + " | " + firstCardNums[19] + " | " + firstCardNums[24] + " |    | " + secondCardNums[4] + " | " + secondCardNums[9] + " | " + secondCardNums[14] + " | " + secondCardNums[19] + " | " + secondCardNums[24] + " |    | " + thirdCardNums[4] + " | " + thirdCardNums[9] + " | " + thirdCardNums[14] + " | " + thirdCardNums[19] + " | " + thirdCardNums[24] + " |    | " + fourthCardNums[4] + " | " + fourthCardNums[9] + " | " + fourthCardNums[14] + " | " + fourthCardNums[19] + " | " + fourthCardNums[24] + " |    | " + fifthCardNums[4] + " | " + fifthCardNums[9] + " | " + fifthCardNums[14] + " | " + fifthCardNums[19] + " | " + fifthCardNums[24] + " |",
                "-------------------------------    -------------------------------    -------------------------------    -------------------------------    -------------------------------");
    }

    public static Boolean askQuestion(char tileLetter, int questionNumber, String[] aQuestions, String[] sQuestions, String[] hQuestions, String[] eQuestions, String[] mQuestions) {
        Scanner input = new Scanner(System.in);
        Boolean correctAnswer = false;

        //Types of Answers
        String answer = ""; double numericAnswer = 0;

        switch (tileLetter) {
            //"A" Questions
            case 'A': switch (questionNumber) {
                case 1: displayQuestion(aQuestions, 1);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 2: displayQuestion(aQuestions, 2);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 3: displayQuestion(aQuestions, 3);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 4: displayQuestion(aQuestions, 4);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 5: displayQuestion(aQuestions, 5);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 6: displayQuestion(aQuestions, 6);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("4") || answer.equalsIgnoreCase("four")) {
                        correctAnswer = true;
                    } break;
                case 7: displayQuestion(aQuestions, 7);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 8: displayQuestion(aQuestions, 8);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("a d") || answer.equalsIgnoreCase("d a") || answer.equalsIgnoreCase("a) d)") || answer.equalsIgnoreCase("d) a)")) {
                        correctAnswer = true;
                    } break;
                case 9: displayQuestion(aQuestions, 9);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 10: displayQuestion(aQuestions, 10);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 11: displayQuestion(aQuestions, 11);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 12: displayQuestion(aQuestions, 12);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 13: displayQuestion(aQuestions, 13);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 14: displayQuestion(aQuestions, 14);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 15: displayQuestion(aQuestions, 15);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 16: displayQuestion(aQuestions, 16);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 17: displayQuestion(aQuestions, 17);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 18: displayQuestion(aQuestions, 18);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 19: displayQuestion(aQuestions, 19);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 20: displayQuestion(aQuestions, 20);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 21: displayQuestion(aQuestions, 21);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 22: displayQuestion(aQuestions, 22);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 23: displayQuestion(aQuestions, 23);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 24: displayQuestion(aQuestions, 24);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 25: displayQuestion(aQuestions, 25);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("viola") || answer.equalsIgnoreCase("the viola")) {
                        correctAnswer = true;
                    } break;
                case 26: displayQuestion(aQuestions, 26);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 27: displayQuestion(aQuestions, 27);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 28: displayQuestion(aQuestions, 28);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 29: displayQuestion(aQuestions, 29);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 30: displayQuestion(aQuestions, 30);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    }
            }
                break;

            //"S" Questions
            case 'S': switch (questionNumber) {
                case 1: displayQuestion(sQuestions, 1);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("true") || answer.equalsIgnoreCase("t")) {
                        correctAnswer = true;
                    } break;
                case 2: displayQuestion(sQuestions, 2);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 3: displayQuestion(sQuestions, 3);
                    answer = input.next();
                    if (answer.equals("206")) {
                        correctAnswer = true;
                    } break;
                case 4: displayQuestion(sQuestions, 4);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 5: displayQuestion(sQuestions, 5);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 6: displayQuestion(sQuestions, 6);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("liver") || answer.equalsIgnoreCase("the liver")) {
                        correctAnswer = true;
                    } break;
                case 7: displayQuestion(sQuestions, 7);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 8: displayQuestion(sQuestions, 8);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 9: displayQuestion(sQuestions, 9);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 10: displayQuestion(sQuestions, 10);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 11: displayQuestion(sQuestions, 11);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 12: displayQuestion(sQuestions, 12);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 13: displayQuestion(sQuestions, 13);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("e)")) {
                        correctAnswer = true;
                    } break;
                case 14: displayQuestion(sQuestions, 14);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 15: displayQuestion(sQuestions, 15);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 16: displayQuestion(sQuestions, 16);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 17: displayQuestion(sQuestions, 17);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 18: displayQuestion(sQuestions, 18);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 19: displayQuestion(sQuestions, 19);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 20: displayQuestion(sQuestions, 20);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 21: displayQuestion(sQuestions, 21);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 22: displayQuestion(sQuestions, 22);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("e)")) {
                        correctAnswer = true;
                    } break;
                case 23: displayQuestion(sQuestions, 23);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 24: displayQuestion(sQuestions, 24);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 25: displayQuestion(sQuestions, 25);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 26: displayQuestion(sQuestions, 26);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 27: displayQuestion(sQuestions, 27);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 28: displayQuestion(sQuestions, 28);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("true") || answer.equalsIgnoreCase("t")) {
                        correctAnswer = true;
                    } break;
                case 29: displayQuestion(sQuestions, 29);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 30: displayQuestion(sQuestions, 30);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    }
            }
                break;

            //"H Questions"
            case 'H': switch (questionNumber) {
                case 1: displayQuestion(hQuestions, 1);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 2: displayQuestion(hQuestions, 2);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("Australia")) {
                        correctAnswer = true;
                    } break;
                case 3: displayQuestion(hQuestions, 3);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 4: displayQuestion(hQuestions, 4);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("Alaska")) {
                        correctAnswer = true;
                    } break;
                case 5: displayQuestion(hQuestions, 5);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 6: displayQuestion(hQuestions, 6);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 7: displayQuestion(hQuestions, 7);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("2015")) {
                        correctAnswer = true;
                    } break;
                case 8: displayQuestion(hQuestions, 8);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("Philippines")) {
                        correctAnswer = true;
                    } break;
                case 9: displayQuestion(hQuestions, 9);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 10: displayQuestion(hQuestions, 10);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 11: displayQuestion(hQuestions, 11);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 12: displayQuestion(hQuestions, 12);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 13: displayQuestion(hQuestions, 13);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("Allied, Axis") || answer.equalsIgnoreCase("Axis, Allied")) {
                        correctAnswer = true;
                    } break;
                case 14: displayQuestion(hQuestions, 14);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 15: displayQuestion(hQuestions, 15);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 16: displayQuestion(hQuestions, 16);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("United States")) {
                        correctAnswer = true;
                    } break;
                case 17: displayQuestion(hQuestions, 17);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 18: displayQuestion(hQuestions, 18);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 19: displayQuestion(hQuestions, 19);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 20: displayQuestion(hQuestions, 20);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 21: displayQuestion(hQuestions, 21);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("Pierre Poilievre")) {
                        correctAnswer = true;
                    } break;
                case 22: displayQuestion(hQuestions, 22);
                    answer = input.nextLine();
                    if ((answer.contains("North America") || answer.contains("north america"))
                            && (answer.contains("South America") || answer.contains("south america"))
                            && (answer.contains("Africa") || answer.contains("africa"))
                            && (answer.contains("Australia") || answer.contains("australia"))
                            && (answer.contains("Europe") || answer.contains("europe"))
                            && (answer.contains("Asia") || answer.contains("asia"))
                            && (answer.contains("Antarctica") || answer.contains("antarctica"))) {
                        correctAnswer = true;
                    } break;
                case 23: displayQuestion(hQuestions, 23);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 24: displayQuestion(hQuestions, 24);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("Korea")) {
                        correctAnswer = true;
                    } break;
                case 25: displayQuestion(hQuestions, 25);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 26: displayQuestion(hQuestions, 26);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 27: displayQuestion(hQuestions, 27);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 28: displayQuestion(hQuestions, 28);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 29: displayQuestion(hQuestions, 29);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 30: displayQuestion(hQuestions, 30);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    }
            }
                break;

            //"E" Questions
            case 'E': switch (questionNumber) {
                case 1: displayQuestion(eQuestions, 1);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 2: displayQuestion(eQuestions, 2);
                    answer = input.nextLine();
                    if (answer.contains("metaphors") || answer.contains("Metaphors")) {
                        correctAnswer = true;
                    } break;
                case 3: displayQuestion(eQuestions, 3);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("a d") || answer.equalsIgnoreCase("d a") || answer.equalsIgnoreCase("a) d)") || answer.equalsIgnoreCase("d) a)")) {
                        correctAnswer = true;
                    } break;
                case 4: displayQuestion(eQuestions, 4);
                    answer = input.next();
                    if (answer.contains("rhyme")) {
                        correctAnswer = true;
                    } break;
                case 5: displayQuestion(eQuestions, 5);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 6: displayQuestion(eQuestions, 6);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("supercalifragilisticexpialidocious")) {
                        correctAnswer = true;
                    } break;
                case 7: displayQuestion(eQuestions, 7);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 8: displayQuestion(eQuestions, 8);
                    answer = input.next();
                    if (answer.contains("onomatopoiea")) {
                        correctAnswer = true;
                    } break;
                case 9: displayQuestion(eQuestions, 9);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("worcestershire")) {
                        correctAnswer = true;
                    } break;
                case 10: displayQuestion(eQuestions, 10);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 11: displayQuestion(eQuestions, 11);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("B D") || answer.equalsIgnoreCase("D B") || answer.equalsIgnoreCase("B) D)") || answer.equalsIgnoreCase("D) B)")) {
                        correctAnswer = true;
                    } break;
                case 12: displayQuestion(eQuestions, 12);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 13: displayQuestion(eQuestions, 13);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 14: displayQuestion(eQuestions, 14);
                    answer = input.nextLine();
                    if ((answer.contains("object") || answer.contains("thing"))
                            && (answer.contains("human") || answer.contains("living"))
                            && (answer.contains("qualities") || answer.contains("describe") || answer.contains("characteristics"))) {
                        correctAnswer = true;
                    } break;
                case 15: displayQuestion(eQuestions, 15);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("pinata")) {
                        correctAnswer = true;
                    } break;
                case 16: displayQuestion(eQuestions, 16);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 17: displayQuestion(eQuestions, 17);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 18: displayQuestion(eQuestions, 18);
                    answer = input.nextLine();
                    if (answer.contains("same") && answer.contains("sound") && answer.contains("words")) {
                        correctAnswer = true;
                    } break;
                case 19: displayQuestion(eQuestions, 19);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 20: displayQuestion(eQuestions, 20);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("poet")) {
                        correctAnswer = true;
                    } break;
                case 21: displayQuestion(eQuestions, 21);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("phlegm")) {
                        correctAnswer = true;
                    } break;
                case 22: displayQuestion(eQuestions, 22);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("b)")) {
                        correctAnswer = true;
                    } break;
                case 23: displayQuestion(eQuestions, 23);
                    answer = input.next();
                    if (answer.contains("its") && !(answer.contains("it's"))) {
                        correctAnswer = true;
                    } break;
                case 24: displayQuestion(eQuestions, 24);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("c)")) {
                        correctAnswer = true;
                    } break;
                case 25: displayQuestion(eQuestions, 25);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    } break;
                case 26: displayQuestion(eQuestions, 26);
                    answer = input.nextLine();
                    if (answer.equals("Emily Dickinson")) {
                        correctAnswer = true;
                    } break;
                case 27: displayQuestion(eQuestions, 27);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("flower")) {
                        correctAnswer = true;
                    } break;
                case 28: displayQuestion(eQuestions, 28);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("a)")) {
                        correctAnswer = true;
                    } break;
                case 29: displayQuestion(eQuestions, 29);
                    answer = input.nextLine();
                    if ((answer.contains("after") || answer.contains("After")) && answer.contains("s")) {
                        correctAnswer = true;
                    } break;
                case 30: displayQuestion(eQuestions, 30);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("d)")) {
                        correctAnswer = true;
                    }
            }
                break;

            //"M" Questions
            case 'M': switch (questionNumber) {
                case 1: displayQuestion(mQuestions, 1);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == 3) {
                        correctAnswer = true;
                    } break;
                case 2: displayQuestion(mQuestions, 2);
                    answer = input.nextLine();
                    if (answer.equals("3") || answer.equalsIgnoreCase("three") || answer.equalsIgnoreCase("3 bronze medals") || answer.equalsIgnoreCase("three bronze medals")) {
                        correctAnswer = true;
                    } break;
                case 3: displayQuestion(mQuestions, 3);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == 56) {
                        correctAnswer = true;
                    } break;
                case 4: displayQuestion(mQuestions, 4);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("5") || answer.equalsIgnoreCase("five") || answer.equalsIgnoreCase("5 years") || answer.equalsIgnoreCase("five years") || answer.equalsIgnoreCase("5 years ago") || answer.equalsIgnoreCase("five years ago")) {
                        correctAnswer = true;
                    } break;
                case 5: displayQuestion(mQuestions, 5);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == (3 + 1) / 2.0 * 60) {
                        correctAnswer = true;
                    } break;
                case 6: displayQuestion(mQuestions, 6);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == Math.pow(4, 3) - 1) {
                        correctAnswer = true;
                    } break;
                case 7: displayQuestion(mQuestions, 7);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == Math.pow(45, 2)) {
                        correctAnswer = true;
                    } break;
                case 8: displayQuestion(mQuestions, 8);
                    answer = input.next();
                    if (answer.equals("3/2")) {
                        correctAnswer = true;
                    } break;
                case 9: displayQuestion(mQuestions, 9);
                    answer = input.nextLine();
                    if (answer.equals("1, 2, 3") || answer.equals("1, 3, 2") || answer.equals("2, 1, 3")
                            || answer.equals("2, 3, 1") || answer.equals("3, 1, 2") || answer.equals("3, 2, 1")) {
                        correctAnswer = true;
                    } break;
                case 10: displayQuestion(mQuestions, 10);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("6") || answer.equalsIgnoreCase("six")) {
                        correctAnswer = true;
                    } break;
                case 11: displayQuestion(mQuestions, 11);
                    answer = input.nextLine();
                    if (answer.equals("-5 -5/3") || answer.equals("-5/3 -5")) {
                        correctAnswer = true;
                    } break;
                case 12: displayQuestion(mQuestions, 12);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == Math.sqrt(Math.pow(3, 2) + Math.pow(4, 2))) {
                        correctAnswer = true;
                    } break;
                case 13: displayQuestion(mQuestions, 13);
                    answer = input.nextLine();
                    if (answer.contains("triplets")) {
                        correctAnswer = true;
                    } break;
                case 14: displayQuestion(mQuestions, 14);
                    answer = input.nextLine();
                    if (answer.equals("180") || answer.equalsIgnoreCase("180 degrees") || answer.equals("180°")) {
                        correctAnswer = true;
                    } break;
                case 15: displayQuestion(mQuestions, 15);
                    answer = input.next();
                    if (answer.equals("11")) {
                        correctAnswer = true;
                    } break;
                case 16: displayQuestion(mQuestions, 16);
                    answer = input.next();
                    if (answer.equals("2") || answer.equalsIgnoreCase("two")) {
                        correctAnswer = true;
                    } break;
                case 17: displayQuestion(mQuestions, 17);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == (100 + 98 + 12) / 3.0) {
                        correctAnswer = true;
                    } break;
                case 18: displayQuestion(mQuestions, 18);
                    answer = input.next();
                    if (answer.equals("11")) {
                        correctAnswer = true;
                    } break;
                case 19: displayQuestion(mQuestions, 19);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == 0.5 * 10 * 15) {
                        correctAnswer = true;
                    } break;
                case 20: displayQuestion(mQuestions, 20);
                    answer = input.next();
                    if (answer.equals("2120")) {
                        correctAnswer = true;
                    } break;
                case 21: displayQuestion(mQuestions, 21);
                    answer = input.next();
                    if (answer.equals("3.14159")) {
                        correctAnswer = true;
                    } break;
                case 22: displayQuestion(mQuestions, 22);
                    answer = input.nextLine();
                    if (answer.equals("0 5")) {
                        correctAnswer = true;
                    } break;
                case 23: displayQuestion(mQuestions, 23);
                    answer = input.next();
                    if (answer.equals("252")) {
                        correctAnswer = true;
                    } break;
                case 24: displayQuestion(mQuestions, 24);
                    answer = input.next();
                    if (answer.equals("0.2")) {
                        correctAnswer = true;
                    } break;
                case 25: displayQuestion(mQuestions, 25);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == (4 + 3) / 2.0 * 5) {
                        correctAnswer = true;
                    } break;
                case 26: displayQuestion(mQuestions, 26);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == 3 * 9 * 20) {
                        correctAnswer = true;
                    } break;
                case 27: displayQuestion(mQuestions, 27);
                    answer = input.next();
                    if (answer.equalsIgnoreCase("never")) {
                        correctAnswer = true;
                    } break;
                case 28: displayQuestion(mQuestions, 28);
                    numericAnswer = input.nextDouble();
                    if (numericAnswer == Math.log10(10000)) {
                        correctAnswer = true;
                    } break;
                case 29: displayQuestion(mQuestions, 29);
                    answer = input.next();
                    if (answer.equals("49")) {
                        correctAnswer = true;
                    } break;
                case 30: displayQuestion(mQuestions, 30);
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("December 31") || answer.equalsIgnoreCase("December 31st")) {
                        correctAnswer = true;
                    }
            }
        }

        return correctAnswer;
    }
}
