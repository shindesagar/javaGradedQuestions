package july29;

import java.util.Scanner;

public class passwordGenerator {
// create a program that generates random passwords for users based on their preferences and saves them to a file.
//  The program should provide a console-based user interface to prompt the user for different password options.
// Requirements:

// Password Generation: Implement a method to generate random passwords based on the user's specifications.
//  The user should be able to choose the password length and include different character types, such as uppercase 
// letters, lowercase letters, numbers, and special characters.

// Save Passwords: Allow the user to save the generated passwords to a file. The program should prompt 
// the user for a file name and create the file to store the passwords.

// Accept User Input: Provide a console-based menu system to prompt the user for password options, 
// such as length and character types.

// Error Handling: Handle possible errors, such as invalid password lengths or incorrect file names.

// Password Strength: Provide an option for the user to check the strength of a given password and provide 
// feedback on its complexity.

    public static void main(String[] args) {
       System.out.println("<=======================000==========================>"); 
       System.out.println("Validation criteria for passwords are as follows:"); 
       System.out.println("Minimum length of the password is 8"); 
       System.out.println("At least one uppercase letter is required"); 
       System.out.println("At least one lowercase letter is required"); 
       System.out.println("At least one special character is required"); 
       System.out.println("At least one digit is required"); 
       System.out.println("<=======================000==========================>"); 
       System.out.print("Enter your desired password:"); 
       Scanner scanner = new Scanner(System.in);
       String password = scanner.nextLine();
        if( validPassword(password)){
            System.out.print("Password Generated Successfully"); 
        }
        scanner.close();
    }

    public static boolean validPassword(String password){
        int passwordLength = 8;
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isSpecialCharacter = false;
        boolean isNumber = false;
        for(char ch: password.toCharArray()){
            if (Character.isUpperCase(ch)) {
                isUpperCase = true;
            }else if(Character.isLowerCase(ch)){
                isLowerCase = true;
            }else if(Character.isDigit(ch)){
                isNumber = true;
            }else if(isSpecialCharacter(ch)) {
                isSpecialCharacter = true;
            }
        }
        if(password.length() <= passwordLength){
            System.out.println("Minimum length of the password is 8"); 
        } if(!isUpperCase){
            System.out.println("At least one uppercase letter is required"); 
        } if(!isLowerCase){
            System.out.println("At least one lowercase letter is required"); 
        } if(!isSpecialCharacter){
            System.out.println("At least one special character is required"); 
        } if(!isNumber){
            System.out.println("At least one digit is required"); 
        }

        return password.length() >= passwordLength && isUpperCase && isLowerCase && isSpecialCharacter && isNumber;
    }
    public static boolean isSpecialCharacter(char ch ){
        String specialCharacters = "!@#$%^&*()_+{}[]|:;<>,.?/~`";
        return specialCharacters.indexOf(ch) != -1;
    }
}



