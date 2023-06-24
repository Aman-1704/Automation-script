import java.util.*;
public class LoginPageTest {
    private static class LoginPage {
        private String username;
        private String password;

        public LoginPage(String username, String password) {
            this.username = username;
            this.password = password; 
        }

        public boolean isEmptyUsernameAndPassword() {
            return username.isEmpty() && password.isEmpty();
        }

        public boolean isEmptyUsername() {
            return username.isEmpty();
        }

        public boolean isEmptyPassword() {
            return password.isEmpty();
        }

        public boolean isValidCredentials() {
            return !username.isEmpty() && !password.isEmpty();
        }
    }

    private static class Alert {
        private String message;

        public void display(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private static class HomePage {
        private List<Double> transactionAmounts;

        public HomePage(List<Double> transactionAmounts) {
            this.transactionAmounts = transactionAmounts;
        }

        public boolean isTransactionTableSorted() {
            for (int i = 1; i < transactionAmounts.size(); i++) {
                if (transactionAmounts.get(i) < transactionAmounts.get(i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        LoginPageTest test = new LoginPageTest();
        test.runTests();
    }

    public void runTests() {
        // Perform login tests
        testEmptyUsernameAndPassword();
        testEmptyUsername();
        testEmptyPassword();
        testValidCredentials();
    }

    private void testEmptyUsernameAndPassword() {
        LoginPage loginPage = new LoginPage("", "");
        Alert alert = new Alert();

        if (loginPage.isEmptyUsernameAndPassword()) {
            alert.display("Both Username and Password must be present");
        }

        // Assert the alert message
        assert alert.getMessage().contains("Both Username and Password must be present");
    }

    private void testEmptyUsername() {
        LoginPage loginPage = new LoginPage("", "password");
        Alert alert = new Alert();

        if (loginPage.isEmptyUsername()) {
            alert.display("Username must be present");
        }

        // Assert the alert message
        assert alert.getMessage().contains("Username must be present");
    }

    private void testEmptyPassword() {
        LoginPage loginPage = new LoginPage("username", "");
        Alert alert = new Alert();

        if (loginPage.isEmptyPassword()) {
            alert.display("Password must be present");
        }

        // Assert the alert message
        assert alert.getMessage().contains("Password must be present");
    }

    private void testValidCredentials() {
        LoginPage loginPage = new LoginPage("validuser", "validpassword");
        HomePage homePage = new HomePage(Arrays.asList(10.5, 20.3, 15.2, 30.8));

        if (loginPage.isValidCredentials()) {
            // Perform the sorting test on the Home Page
            if (homePage.isTransactionTableSorted()) {
                System.out.println("Transaction table is sorted.");
            } else {
                System.out.println("Transaction table is not sorted.");
            }
        }
    }
}
