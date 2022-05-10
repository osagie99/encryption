import java.util.Arrays;

class Encrypt {
    private String message;
    private String[] finalMessage;

    public Encrypt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message.toLowerCase();
    }
    //    A method to check if the length of the string is less than 3

    private boolean stringLength(String string) {
        return getMessage().length() >= 3;
    }

//    A method to split string into roughly equal halves

    private String[] splitString (String string) {
        final int middle = getMessage().length() / 2 ;
        if(getMessage().length() % 2 == 0) {
            String partA = getMessage().substring(0, middle);
            String partB = getMessage().substring(middle);
            String[] partBA = {partB, partA};
            return  partBA;
        }
        String partA = getMessage().substring(0, Math.round(middle));
        String partB = getMessage().substring(Math.round(middle));
        String[] partBA = {partB, partA};
        return partBA;
    }

    public String[] getFinalMessage() {
        return finalMessage;
    }

    public void setFinalMessage(String[] finalMessage) {
        this.finalMessage = finalMessage;
    }

    public String[] encryptMessage () {
        if (!stringLength(getMessage())) {
            System.out.println("Enter String greater than 3");
            return null;
        }
        String[] splitString = splitString(getMessage());

        char[] charA = splitString[0].toCharArray();
        char[] charB = splitString[1].toCharArray();


        for (int i = 0; i < splitString[0].length(); i++) {
            switch (splitString[0].charAt(i)) {
                case 'a':
                    charA[i] = '1';
                    break;
                case 'e':
                    charA[i] = '5';
                    break;
                case 'i':
                    charA[i] = '3';
                    break;
                case 'o':
                    charA[i] = '2';
                    break;
                case 'u':
                    charA[i] = '4';
                    break;
            }
//
        }
        for (int i = 0; i < splitString[1].length(); i++) {
            switch (charB[i]) {
                case 'a':
                    charB[i] = '1';
                    break;
                case 'e':
                    charB[i] = '5';
                    break;
                case 'i':
                    charB[i] = '3';
                    break;
                case 'o':
                    charB[i] = '2';
                    break;
                case 'u':
                    charB[i] = '4';
                    break;
            }
//
        }

        splitString[0] = String.valueOf(charA);
        splitString[1] = String.valueOf(charB);

        String[] finalEncrypt = {splitString[0], splitString[1]};
        System.out.println((splitString[0] + splitString[1]));
        setFinalMessage(finalEncrypt);
        return finalEncrypt;
    }

    public void decryptMessage() {

        if(!stringLength(getMessage())){
            return;
        }

        String[] finalEncrypt = getFinalMessage();

        char[] charA = finalEncrypt[0].toCharArray();
        char[] charB = finalEncrypt[1].toCharArray();



        for (int i = 0; i < finalEncrypt[0].length(); i++) {
            switch (charA[i]) {
                case '1':
                    charA[i] = 'a';
                    break;
                case '5':
                    charA[i] = 'e';
                    break;
                case '3':
                    charA[i] = 'i';
                    break;
                case '2':
                    charA[i] = 'o';
                    break;
                case '4':
                    charA[i] = 'u';
                    break;
            }

//
        }
        for (int i = 0; i < finalEncrypt[1].length(); i++) {
            switch (charB[i]) {
                case '1':
                    charB[i] = 'a';
                    break;
                case '5':
                    charB[i] = 'e';
                    break;
                case '3':
                    charB[i] = 'i';
                    break;
                case '2':
                    charB[i] = 'o';
                    break;
                case '4':
                    charB[i] = 'u';
                    break;
            }
        }
        String partA = String.valueOf(charA);
        String partB = String.valueOf(charB);
        System.out.println(partB + partA);
    }
}
