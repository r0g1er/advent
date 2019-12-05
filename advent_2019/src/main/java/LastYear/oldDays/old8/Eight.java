package LastYear.oldDays.old8;

import days.Three.ArrayCreator;

/**
 * @author Rogier
 */
public final class Eight {
    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        String[] stringArray = creator.createFromFile("src/main/java/LastYear/oldDays/old8/input", ",");
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        boolean lastChild = true;
        int childsToGo = 1;
        int levelOfDeepnes = 0;
        //0 = level of deepnes
        //1 = what does it mean: amount of childer(1), amount of meta(2), or actual meta(3)
        //2= value as stored in original array
        //3= how many siblings to go


        int[][] whatIsWhatArray = new int[stringArray.length][4];
        int roundsTogo = intArray.length;
        int syblingsToGo = 0;

        for (int i = 0; i < roundsTogo; i += 2) {
            int amountOfChildNodes = intArray[i];
            int amountOfMetaData = intArray[i + 1];

            if (amountOfChildNodes == 0) {
                for (; amountOfMetaData > 0; amountOfMetaData--) {
                    whatIsWhatArray[i + amountOfMetaData][0] = levelOfDeepnes;
                    whatIsWhatArray[i + amountOfMetaData][1] = 3;
                    whatIsWhatArray[i + amountOfMetaData][2] = intArray[i + amountOfMetaData];
                    whatIsWhatArray[i + amountOfMetaData][3] = syblingsToGo;
                }
            }


            if (childsToGo == 0) {
                for (; amountOfMetaData < 0; amountOfMetaData--) {
                    whatIsWhatArray[roundsTogo][0] = levelOfDeepnes;
                    whatIsWhatArray[roundsTogo][1] = 3;
                    whatIsWhatArray[roundsTogo][2] = intArray[roundsTogo];
                    whatIsWhatArray[roundsTogo][3] = syblingsToGo;
                    roundsTogo--;
                }
                levelOfDeepnes--;
            }

            if (amountOfChildNodes > 0) {
                syblingsToGo = amountOfChildNodes;
                whatIsWhatArray[i][0] = levelOfDeepnes;
                whatIsWhatArray[i + 1][0] = levelOfDeepnes;
                whatIsWhatArray[i][1] = 1;
                whatIsWhatArray[i + 1][1] = 2;
                whatIsWhatArray[i][2] = amountOfChildNodes;
                whatIsWhatArray[i + 1][2] = amountOfMetaData;
                whatIsWhatArray[i][3] = syblingsToGo;
                whatIsWhatArray[i + 1][3] = syblingsToGo;
                levelOfDeepnes++;
            }


        }

for (int i=0;i<whatIsWhatArray.length;i++){
    System.out.print("[ ");
    for (int j=0;j<4;j++){
        System.out.print(whatIsWhatArray[i][j]+ ",  ");
    }
    System.out.println("]");
}
    }
}
