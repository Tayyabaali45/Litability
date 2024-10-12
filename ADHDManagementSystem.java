import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class ADHDManagementSystem {

    private static final String[] ADHD_TIPS = {
            "Create a daily routine and stick to it.",
            "Break tasks into smaller, manageable steps.",
            "Use timers to stay on track.",
            "Take regular breaks during work or study sessions.",
            "Keep a planner or calendar for important dates.",
            "Use color-coding for organization.",
            "Practice mindfulness or meditation.",
            "Exercise regularly to improve focus.",
            "Eat a balanced diet and stay hydrated.",
            "Get plenty of sleep.",
            "Minimize distractions in your environment.",
            "Use noise-canceling headphones if needed.",
            "Set specific goals for each task.",
            "Reward yourself for completing tasks.",
            "Ask for help when needed.",
            "Stay positive and patient with yourself.",
            "Use reminders and alarms.",
            "Keep your workspace clean and organized.",
            "Limit screen time, especially before bed.",
            "Practice deep breathing exercises.",
            "Join a support group.",
            "Work in a quiet, clutter-free space.",
            "Use apps to help with time management.",
            "Stay connected with friends and family.",
            "Break up long tasks with fun activities.",
            "Use sticky notes for important reminders.",
            "Prioritize tasks and focus on one thing at a time.",
            "Avoid multitasking.",
            "Keep a journal to track progress.",
            "Practice self-care regularly."
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> displayMainMenu());
    }

    public static void displayMainMenu() {
        while (true) {
            String welcomenote = "Welcome to ADHD Management System";
            Object[] options = {"Enter Program", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, welcomenote, "ADHD Management System",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == JOptionPane.YES_OPTION) {
                login();
            } else {
                System.exit(0);
            }
        }
    }

    public static void login() {
        while (true) {
            Object[] options = {"Take Test", "Exit"};
            int testChoice = JOptionPane.showOptionDialog(null, "Would you like to test your ADHD levels?", "ADHD Management System",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (testChoice == JOptionPane.NO_OPTION) {
                return;
            }

            Object[] loginOptions = {"Sign Up", "Sign In"};
            int loginOrSignUp = JOptionPane.showOptionDialog(null, "Do you want to login or signup?", "ADHD Management System",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, loginOptions, loginOptions[0]);

            if (loginOrSignUp == JOptionPane.YES_OPTION) {
                userSignUp();
            } else if (loginOrSignUp == JOptionPane.NO_OPTION) {
                userSignIn();
            }
        }
    }

    public static void ADHDtesting() {
        String[] questions = {
                "How often do you have trouble wrapping up the final details of a project, once the challenging parts have been done?",
                "How often do you have difficulty getting things in order when you have to do a task that requires organization?",
                "How often do you have problems remembering appointments or obligations?",
                "When you have a task that requires a lot of thought, how often do you avoid or delay getting started?",
                "How often do you fidget or squirm with your hands or feet when you have to sit down for a long time?",
                "How often do you feel overly active and compelled to do things, like you were driven by a motor?",
                "How often do you make careless mistakes when you have to work on a boring or difficult project?",
                "How often do you have difficulty keeping your attention when you are doing boring or repetitive work?",
                "How often do you have difficulty concentrating on what people say to you, even when they are speaking to you directly?",
                "How often do you misplace or have difficulty finding things at home or at work?",
                "How often are you distracted by activity or noise around you?",
                "How often do you leave your seat in meetings or other situations in which you are expected to remain seated?",
                "How often do you feel restless or fidgety?",
                "How often do you have difficulty unwinding and relaxing when you have time to yourself?"
        };

        int[] responses = new int[14];
        for (int i = 0; i < questions.length; i++) {
            responses[i] = askQuestion(i + 1, questions[i]);
        }

        // Calculate total score
        int totalScore = 0;
        for (int response : responses) {
            totalScore += response;
        }

        // Interpret total score and classify ADHD level
        String adhdLevel;
        if (totalScore <= 20) {
            adhdLevel = "Minimal ADHD symptoms";
        } else if (totalScore <= 40) {
            adhdLevel = "Mild ADHD symptoms";
        } else if (totalScore <= 60) {
            adhdLevel = "Moderate ADHD symptoms";
        } else {
            adhdLevel = "Severe ADHD symptoms";
        }

        // Display result and show a tip if ADHD symptoms are present
        JOptionPane.showMessageDialog(null, "Your ADHD level: " + adhdLevel, "ADHD Test Result", JOptionPane.INFORMATION_MESSAGE);
        if (totalScore > 20) {
            String tip = getRandomTip();
            JOptionPane.showMessageDialog(null, "ADHD symptoms are present. Here is a tip for you:\n" + tip, "ADHD Tip", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static int askQuestion(int questionNumber, String question) {
        while (true) {
            try {
                String[] options = {"0 - Never", "1 - Rarely", "2 - Sometimes", "3 - Often", "4 - Very Often"};
                int response = JOptionPane.showOptionDialog(null, question, "Question " + questionNumber,
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (response >= 0 && response <= 4) {
                    return response;
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a valid option.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void userSignUp() {
        while (true) {
            try {
                String username = JOptionPane.showInputDialog("Enter your name:");
                String email = JOptionPane.showInputDialog("Enter your email:");
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid email. Please enter a valid email (e.g., user@example.com).", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                String ageStr = JOptionPane.showInputDialog("Please enter your age:");
                int age;
                try {
                    age = Integer.parseInt(ageStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                String password = JOptionPane.showInputDialog("Enter your password:");
                String confirmPassword = JOptionPane.showInputDialog("Confirm your password:");
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(null, "Password must contain letters, numbers, and special characters.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                if (userExists(username, email)) {
                    JOptionPane.showMessageDialog(null, "User already exists. Please sign in.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                saveUserDetails(username, email, age, password);
                JOptionPane.showMessageDialog(null, "Sign Up successful! Please sign in.", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void userSignIn() {
        while (true) {
            try {
                String username = JOptionPane.showInputDialog("Enter your name:");
                String password = JOptionPane.showInputDialog("Enter your password:");

                if (authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ADHDtesting();
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Login Unsuccessful! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".com");
    }

    public static boolean isValidPassword(String password) {
        boolean hasLetter = false, hasDigit = false, hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isWhitespace(c)) hasSpecialChar = true;
            if (hasLetter && hasDigit && hasSpecialChar) return true;
        }
        return false;
    }

    public static void saveUserDetails(String username, String email, int age, String password) throws IOException {
        try (FileWriter writer = new FileWriter("Usersignupdetails.txt", true)) {
            writer.write(username + "," + email + "," + age + "," + password + "\n");
        }
    }

    public static boolean userExists(String username, String email) {
        try (Scanner fileReader = new Scanner(new File("Usersignupdetails.txt"))) {
            while (fileReader.hasNextLine()) {
                String[] userDetails = fileReader.nextLine().split(",");
                if (userDetails[0].equals(username) || userDetails[1].equals(email)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean authenticateUser(String username, String password) {
        try (Scanner fileReader = new Scanner(new File("Usersignupdetails.txt"))) {
            while (fileReader.hasNextLine()) {
                String[] userDetails = fileReader.nextLine().split(",");
                if (userDetails[0].equals(username) && userDetails[3].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getRandomTip() {
        Random rand = new Random();
        int index = rand.nextInt(ADHD_TIPS.length);
        return ADHD_TIPS[index];
    }
}




