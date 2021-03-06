package com.company;

import java.util.Scanner;

public class Main {
    //Main menu
    public void showMainMenu(){
        System.out.println("Welcome to the Enigma prototype");
        System.out.println("Press 1 to choose the Caesar cipher machine, press 2 for the Vigenère, press 3 for" +
            "the number cipher and 4 to exit");
        Scanner keyboard = new Scanner(System.in);
        int userInput = keyboard.nextInt();
        if (userInput == 1){
            showCaesarMenu();
        } else {
            System.out.println("Still working to implement other code breakers");
        }
    }

    //Show Caesar main menu
    public void showCaesarMenu(){
        System.out.println("Welcome to the Caesar cipher prototype");
        System.out.println("Press 1 to encrypt a text or 2 to decrypt a text");
        Scanner keyboard = new Scanner(System.in);
        int userInput = keyboard.nextInt();
        if (userInput == 1){
            showCaesarEncryptionMenu();
        } else if (userInput == 2) {
            showCaesarDecryptionMenu();
        } else{
            System.out.println("We got a problem. I told you to press 1 or 2!");
        }
    }

    //Show caesar encryption menu
    public void showCaesarEncryptionMenu(){
        System.out.println("Welcome to the caesar encryption menu");
        System.out.println("Type text to be encrypted");
        Scanner keyboard = new Scanner(System.in);
        String originalText = keyboard.nextLine();
        System.out.println("Your text to be encrypted is: " + originalText);
        char[] originalTextArray = convertStringToCharArray(originalText);
        System.out.println("Type shift value for the encryption");
        int userInputShift = keyboard.nextInt();
        System.out.println(encryptArray(originalTextArray,userInputShift));
        showCaesarEncryptionPostMenu();
    }

    //Show caesar encryption post menu
    public void showCaesarEncryptionPostMenu(){
        System.out.println("Would you like to encrypt a new text (press 1), decrypt a text (press 2), " +
            "or back to main menu (press 3)");
        Scanner keyboard = new Scanner(System.in);
        int userInput = keyboard.nextInt();
        if (userInput == 1){
            showCaesarEncryptionMenu();
        } else if (userInput == 2){
            showCaesarDecryptionMenu();
        } else if (userInput == 3){
            showMainMenu();
        } else {
            showMainMenu();
        }
    }

    //Show caesar decryption menu
    public void showCaesarDecryptionMenu(){
        System.out.println("Welcome to the caesar decryption menu");
        System.out.println("Type code text to be decrypted");
        Scanner keyboard = new Scanner(System.in);
        String encryptedMessage = keyboard.next();
        System.out.println("Your text to be decrypted is: " + encryptedMessage);
        char[] encryptedMessageArray = convertStringToCharArray(encryptedMessage);
        System.out.println("Type shift value for the decryption");
        int userInputShift = keyboard.nextInt();
        System.out.println(decryptArray(encryptedMessageArray,userInputShift));
        showCaesarDecryptionPostMenu();
    }

    //Show caesar decryption post menu
    public void showCaesarDecryptionPostMenu(){
        System.out.println("Would you like to decrypt a new text (press 1), encrypt a text (press 2), " +
            "or back to main menu (press 3)");
        Scanner keyboard = new Scanner(System.in);
        int userInput = keyboard.nextInt();
        if (userInput == 1){
            showCaesarDecryptionMenu();
        } else if (userInput == 2){
            showCaesarEncryptionMenu();
        } else if (userInput == 3){
            showMainMenu();
        } else{
            showMainMenu();
        }


    }

    //Encrypt array
    public char[] encryptArray(char[] originalText, int shiftValue){
        char[] encryptedText = new char[originalText.length];
        for (int i = 0; i < originalText.length; i++){
            int number = convertLetterToNumber(originalText[i]);
            int shiftedNumber = shiftValueAbove(number, shiftValue);
            char letter = convertNumberToLetter(shiftedNumber);
            encryptedText[i] = letter;
        }
        return encryptedText;
    }

    //Decrypt array
    public char[] decryptArray(char[] codeText, int shiftValue){
        char[] decryptedText = new char[codeText.length];
        for (int i = 0 ; i < codeText.length; i++){
            int number = convertLetterToNumber(codeText[i]);
            int shiftedNumber = shiftValueBelow(number, shiftValue);
            char letter = convertNumberToLetter(shiftedNumber);
            decryptedText[i] = letter;
        }
        return decryptedText;
    }

    //Convert string to array
    public char[] convertStringToCharArray(String text){
        text = text.toUpperCase();
        return text.toCharArray();
    }

    //Convert a letter (char) to number
    public char convertLetterToNumber(char letter){
        char[] alphabet = {' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
            'W','X','Y','Z','Æ','Ø','Å'};
        char number = 0;
        for (char i = 0; i < alphabet.length; i++){
            if (alphabet[i] == letter){
                number = i;
            }
        }
        return number;
    }

    //Convert number to letter (char)
    public char convertNumberToLetter(int number){
        char[] alphabet = {' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
            'W','X','Y','Z','Æ','Ø','Å'};
        return alphabet[number];
    }

    //Corrects if shift value gets above outer bounds of alphabet
    public int shiftValueAbove(int number, int shiftValue){
        if (number == 0){
            return number;
        }
        for (int i = 0; i < shiftValue; i++){
            number++;
            if (number > 29){
                number = 1;
            }
        }
        return number;
    }

    //Corrects if shift value gets below lower bounds of alphabet
    public int shiftValueBelow(int number, int shiftValue){
        if (number == 0){
            return number;
        }
        for (int i = 0; i < shiftValue; i++){
            number--;
            if (number < 1){
                number = 29;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Main obj = new Main();

        //Foreløbigt virker Caesar code breaker kun
        obj.showMainMenu();
    }
}
