import java.util.Scanner;

class Admin {
    private int totItem;
    private int[] price = new int[10];
    private String name;
    private String[] parent = new String[10];
    private String getype;
    private String password;
    protected String mobile;
    protected String mail;
    protected String stallid;
    public String restid;
    private String[] fmenu = new String[10];
    private String retype;
    private String rpasswd;

    // Global variables - made private but with public access methods
    private static String un;
    private static String ft;

    // Public static methods to access private static variables
    public static String getUn() {
        return un;
    }

    public static void setUn(String username) {
        un = username;
    }

    public static String getFt() {
        return ft;
    }

    public static void setFt(String foodType) {
        ft = foodType;
    }

    // Authentication function
    public int login() {
        if (Admin.getUn().equals(restid)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter the Login Password: ");
            String inputpasswd = scanner.nextLine();
            
            if (Admin.getUn().equals(restid) && password.equals(inputpasswd)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    // Password recovery function
    public int recover() {
        if (Admin.getUn().equals(restid)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter the Unique Keyword (Provided by Admin): ");
            String key = scanner.nextLine();
            
            if (key.equals(rpasswd)) {
                System.out.println("\nYou are a Valid user.");
                System.out.println("\nYour Password is " + password);
                System.out.println("\nPlease Exit To Login Again");
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public void getredata() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter the Food Stall Name: ");
        name = scanner.nextLine();
        
        System.out.print("\nEnter the Food Stall ID: ");
        restid = scanner.nextLine();
        
        System.out.print("\nEnter the Mobile Number: ");
        mobile = scanner.nextLine();
        
        System.out.print("\nEnter the E-Mail ID: ");
        mail = scanner.nextLine();
        
        System.out.print("\nEnter the Stall Unique ID: ");
        stallid = scanner.nextLine();
        
        System.out.println("\nFood Stall Food Options Possible are:");
        System.out.println("1. South-Indian");
        System.out.println("2. Continental");
        System.out.println("3. Chinese");
        System.out.println("4. Thailand");
        System.out.println("5. Multiple");
        
        System.out.print("\nEnter the Food Stall Food Options Type (Unique Number): ");
        int foodtype = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (foodtype == 1) retype = "South Indian";
        else if (foodtype == 2) retype = "Continental";
        else if (foodtype == 3) retype = "Chinese";
        else if (foodtype == 4) retype = "Thailand";
        else retype = "Multiple";
        
        System.out.print("\nEnter the Total Food menu Items: ");
        totItem = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < totItem; i++) {
            System.out.print("\nEnter the Food Item " + (i + 1) + " Name: ");
            fmenu[i] = scanner.nextLine();
            
            System.out.print("Enter the Price of Food " + (i + 1) + " INR: ");
            price[i] = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }
        
        System.out.print("\nCreate Your Login Password: ");
        password = scanner.nextLine();
        
        System.out.print("\nEnter the Unique Keyword to Recover Password: ");
        rpasswd = scanner.nextLine();
        
        System.out.println("\n\nPlease note your UserName is ID, i.e. " + restid);
    }

    public void redisplay() {
        System.out.println("\nFood Stall Name: " + name);
        System.out.println("Food Stall ID: " + restid);
        System.out.println("Food Stall Mobile No.: " + mobile);
        System.out.println("Food Stall E-Mail ID: " + mail);
        System.out.println("Food Stall Food Menu Total Items: " + totItem);
        
        for (int i = 0; i < totItem; i++) {
            System.out.println("\tFood Item " + (i + 1) + ": " + fmenu[i] + " :: Price: " + price[i]);
        }
        
        if (totItem == 0) {
            System.out.println("(None Food Items Specified...)");
        }
    }

    public int reprofile() {
        if (Admin.getUn().equals(restid)) {
            System.out.println("\nFood Stall Name: " + name);
            System.out.println("Food Stall Mobile: " + mobile);
            System.out.println("Food Stall Food Items Type: " + retype);
            return 1;
        } else {
            return 0;
        }
    }

    public int knowremenu() {
        if (Admin.getUn().equals(restid)) {
            System.out.println("\nFood Stall Food Items Type: " + retype);
            System.out.println("Food Stall Total menus: " + totItem);
            
            for (int i = 0; i < totItem; i++) {
                System.out.println("\tFood Item " + (i + 1) + ": " + fmenu[i] + " :: Price: " + price[i]);
            }
            return 1;
        } else {
            return 0;
        }
    }

    public void addremenu() {
        if (Admin.getUn().equals(restid)) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("\nEnter the New Food Item: ");
            fmenu[totItem] = scanner.nextLine();
            
            System.out.print("\nEnter the Price of new Food Item: ");
            price[totItem] = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            totItem++;
            System.out.println("\n\nNew menu Added Successfully...");
        }
    }

    public void delremenu() {
        knowremenu();
        
        if (Admin.getUn().equals(restid)) {
            if (totItem == 0 || totItem < 0) {
                totItem = 0;
                System.out.println("\nNone menus Exist...");
                System.exit(0);
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter the menu No. to be Deleted: ");
            int de = scanner.nextInt();
            
            if (de == totItem) {
                totItem--;
                fmenu[totItem] = " ";
                price[totItem] = 0;
            } else if (totItem == 1) {
                totItem = 0;
                fmenu[0] = " ";
                price[0] = 0;
            } else {
                de--;
                for (int p = de; p < totItem - 1; p++) {
                    fmenu[p] = fmenu[p + 1];
                    price[p] = price[p + 1];
                }
                totItem--;
            }
        }
    }

    public void modreprofile() {
        if (Admin.getUn().equals(restid)) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("\nCurrent Food Stall Name: " + name);
            System.out.print("Enter New Food Stall Name: ");
            String newname = scanner.nextLine();
            if (!newname.isEmpty()) name = newname;
            
            System.out.println("\nCurrent Mobile: " + mobile);
            System.out.print("Enter New Mobile: ");
            String newmobile = scanner.nextLine();
            if (!newmobile.isEmpty()) mobile = newmobile;
            
            System.out.println("\nCurrent E-Mail: " + mail);
            System.out.print("Enter New E-Mail: ");
            String newmail = scanner.nextLine();
            if (!newmail.isEmpty()) mail = newmail;
            
            System.out.println("\nFood Stall Food Options Possible are:");
            System.out.println("1. South-Indian");
            System.out.println("2. Continental");
            System.out.println("3. Chinese");
            System.out.println("4. Thailand");
            System.out.println("5. Multiple");
            
            System.out.print("\nEnter New Food Stall Food Options Type (Unique Number): ");
            int foodtype = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (foodtype == 1) retype = "South Indian";
            else if (foodtype == 2) retype = "Continental";
            else if (foodtype == 3) retype = "Chinese";
            else if (foodtype == 4) retype = "Thailand";
            else if (foodtype == 5) retype = "Multiple";
            
            System.out.println("\nRecords Updated Successfully...");
        } else {
            System.out.println("\nInvalid Input Provided...");
        }
    }

    public int knowresenutocustomer() {
        if (stallid.equals(Admin.getUn())) {
            System.out.println("\nFood Stall Name: " + name);
            System.out.println("Food Stall Unique ID: " + stallid);
            System.out.println("Food Stall Food Menu Type: " + retype);
            System.out.println("Food Stall Total Food Menu Items: " + totItem);
            
            for (int i = 0; i < totItem; i++) {
                System.out.println("\nFood Item " + (i + 1) + ": " + fmenu[i] + " :: price: " + price[i]);
            }
            return 1;
        } else {
            return 0;
        }
    }

    public void redisplaytocustomer() {
        System.out.println("\nFood Stall Name: " + name);
        System.out.println("Food Stall Unique ID: " + stallid);
        System.out.println("Food Stall Food Menu Total Items: " + totItem);
        
        for (int i = 0; i < totItem; i++) {
            System.out.println("\nFood Item " + (i + 1) + ": " + fmenu[i] + " :: price: " + price[i]);
        }
        
        if (totItem == 0) {
            System.out.println("{None Food Items Specified...}");
        }
    }

    public int searchrebyfoodtype() {
        if (Admin.getFt().equals(retype)) {
            System.out.println("\nFood Stall Name: " + name);
            System.out.println("Food Stall Unique ID: " + stallid);
            System.out.println("Food Stall Total Food Items: " + totItem);
            
            for (int i = 0; i < totItem; i++) {
                System.out.println("\nFood item " + (i + 1) + ": " + fmenu[i] + " ::: price: " + price[i]);
            }
            return 1;
        } else {
            return 0;
        }
    }

    public void invalid_input() {
        System.out.println("\nInvalid Input Provided !!! ");
        System.out.println("\n\n\n\t\tThank You");
    }
}

class MainMenu {
    private Admin a = new Admin();
    
    public void admin_call() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n\t\tWelcome To Admin Login Portal ");
        System.out.print("\n\nEnter the UserName: ");
        String adminuser = scanner.nextLine();
        
        System.out.print("\nEnter the Password: ");
        String adminpass = scanner.nextLine();
        
        if (adminuser.equals("admin") && adminpass.equals("password")) {
            System.out.println("\nLogin Successful!");
        } else {
            System.out.println("\n\n\t\t Invalid Access to Portal ");
            System.out.println("\n\n\t\t\tThank You !!!");
            System.exit(0);
        }
        
        char opera = 'y';
        do {
            System.out.println("\nWelcome To Admin Panel");
            System.out.println("Press 1 to Add Single Food Stall with record");
            System.out.println("Press 2 to Add Multiple Food Stalls with record");
            System.out.println("Press 3 to View All Food Stalls with records");
            System.out.println("Press 4 to Delete a Food Stall with Record");
            System.out.print("Enter Your Choice: ");
            
            int tmp = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (tmp == 1) {
                // Add single food stall
                System.out.println("\nEnter the Details:");
                a.getredata();
                System.out.println("\nRecord Entered Successfully...");
            } else if (tmp == 2) {
                // Add multiple food stalls
                int m = 0;
                do {
                    System.out.println("\nEnter the Details:");
                    a.getredata();
                    System.out.print("Press 0 if you want to Enter More Records: ");
                    m = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } while (m == 0);
                System.out.println("\nRecords Entered Successfully...");
            } else if (tmp == 3) {
                // View all food stalls
                a.redisplay();
            } else if (tmp == 4) {
                // Delete food stall
                System.out.print("\nEnter the Food stall ID: ");
                String tmpid = scanner.nextLine();
                System.out.println("Record Deleted Successfully...");
            }
            
            System.out.print("\n\nPress y for More Operations otherwise n: ");
            opera = scanner.nextLine().charAt(0);
            
            if (opera != 'y' && opera != 'Y') {
                System.out.println("\n\n\n\n\t\tThank You !!!");
            }
        } while (opera == 'Y' || opera == 'y');
    }
    
    public void r_call() {
        Scanner scanner = new Scanner(System.in);
        Admin f = new Admin();
        
        System.out.print("\n\nEnter the UserName: ");
        Admin.setUn(scanner.nextLine());
        
        System.out.println("Press 1 to Login");
        System.out.println("Press 2 to Recover Password");
        System.out.print("Enter Your Choice: ");
        
        int ho = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (ho == 1) {
            int value = f.login();
            if (value == 1) {
                System.out.println("\nLogin Successful!");
            } else {
                System.out.println("\nYou are an Invalid User.");
                System.exit(0);
            }
        } else if (ho == 2) {
            int recoverResult = f.recover();
            if (recoverResult == 0) {
                System.out.println("\nRecovery Failed.");
                System.exit(0);
            }
        }
        
        char con = 'y';
        do {
            System.out.println("\nWelcome To Food Stall Panel");
            System.out.println("Press 1 to View Profile");
            System.out.println("Press 2 to View Food Menu");
            System.out.println("Press 3 to Add Food Menu");
            System.out.println("Press 4 to Delete Food Menu");
            System.out.println("Press 5 to Modify Profile");
            System.out.print("Enter Your Choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (choice == 1) f.reprofile();
            else if (choice == 2) f.knowremenu();
            else if (choice == 3) f.addremenu();
            else if (choice == 4) f.delremenu();
            else if (choice == 5) f.modreprofile();
            else System.out.println("\nInvalid Input Provided !!! ");
            
            System.out.print("\n\nPress y to Continue; otherwise n: ");
            con = scanner.nextLine().charAt(0);
            
            if (con != 'y' && con != 'Y') {
                System.out.println("\n\n\n\n\t\tThank You !!!");
                System.exit(0);
            }
        } while (con == 'y' || con == 'Y');
    }
    
    public void customer_call() {
        Scanner scanner = new Scanner(System.in);
        Admin a = new Admin();
        
        char moreop = 'y';
        do {
            System.out.println("\nWelcome To Customer Panel");
            System.out.println("Press 1 to View All Food Stall unique IDs");
            System.out.println("Press 2 to View a stall by utilizing the stall ID");
            System.out.println("Press 3 to Search a food stall (Depending on food type)");
            System.out.print("Enter Your Choice: ");
            
            int inchoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (inchoice == 1) {
                a.redisplaytocustomer();
            } else if (inchoice == 2) {
                System.out.print("Enter Stall ID: ");
                Admin.setUn(scanner.nextLine());
                int result = a.knowresenutocustomer();
                if (result != 1) {
                    System.out.println("\nRecord not found....");
                }
            } else if (inchoice == 3) {
                System.out.println("Food Stall Food Options Possibilities are:");
                System.out.println("1. South-Indian");
                System.out.println("2. Continental");
                System.out.println("3. Chinese");
                System.out.println("4. Thailand");
                System.out.println("5. Multiple");
                
                System.out.print("Enter the Food Stall Food Options Type (Unique Number): ");
                int result = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                if (result == 1) Admin.setFt("South Indian");
                else if (result == 2) Admin.setFt("Continental");
                else if (result == 3) Admin.setFt("Chinese");
                else if (result == 4) Admin.setFt("Thailand");
                else Admin.setFt("Multiple");
                
                int searchResult = a.searchrebyfoodtype();
                if (searchResult != 1) {
                    System.out.println("\nNo Such Food Stall found....");
                }
            } else {
                System.out.println("\nInvalid Input Provided...");
            }
            
            System.out.print("\n\nPress y to Perform More Operations, otherwise n: ");
            moreop = scanner.nextLine().charAt(0);
            
            if (moreop != 'y' && moreop != 'Y') {
                System.out.println("\n\n\n\t\tThank You !!!");
                System.exit(0);
            }
        } while (moreop == 'y' || moreop == 'Y');
    }
    
    public void invalid_user_input() {
        a.invalid_input();
    }
}

public class FoodCourtManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu m = new MainMenu();
        
        System.out.println("\n\n\n\t\tWelcome to Food Court Management System ");
        System.out.println("\n\n\n\t\tPress Enter to Continue ");
        scanner.nextLine();
        
        System.out.println("\n\n\n\tPress 1 for Admin Portal");
        System.out.println("\tPress 2 for Food Stall Portal");
        System.out.println("\tPress 3 for Customer Portal");
        System.out.print("\n\n\tEnter Your Choice: ");
        
        int ch = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (ch == 1) m.admin_call();
        else if (ch == 2) m.r_call();
        else if (ch == 3) m.customer_call();
        else m.invalid_user_input();
        
        scanner.close();
    }
}