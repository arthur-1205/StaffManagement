package util;


import java.util.InputMismatchException;
import java.util.Scanner;


public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String errorMsg) {
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n <= lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound) {
        int n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n <= lowerBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    
    //nhập vào 1 số thực, chặn hết các trường hợp cà chớn 
    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //nhập vào một chuỗi kí tự, theo định dạng đc đưa vào
    //định dạng xài Regular Expression
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    
    public static String getAString(String errorMsg) {
        String id;
        while (true) {
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }
    
    //nhập vào một chuỗi kí tự, khác rỗng
    public static String getAString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static boolean getTrueFalse(String inputMsg, String errorMsg) {
        int choice = 0;
        boolean cont = false;
        do {
            try {
                System.out.println(inputMsg);
                choice = MyToys.getAnInteger("Input an integer 1 or 0!!");
                if (choice != 1 && choice != 0) {
                    throw new Exception();
                }
                cont = false;
                       
            } catch (InputMismatchException e1) {
               System.out.println("Input an integer!!");
               cont = true;
            } catch (Exception e2) {
                System.out.println(errorMsg);
                cont = true;
            }
        }while(cont); 
        if (choice == 1) {
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }        
    }
    
    public static int get1or0(String inputMsg, String outputMsg) {
        int choice = 0;
        boolean cont = false;
        do {
            try {
                System.out.print(inputMsg);
                choice = MyToys.getAnInteger("Invalid format!!");
                if(choice != 1 && choice != 0)
                    throw new Exception(outputMsg);
            }catch(Exception e) {
                System.out.println(outputMsg);
            }
                
        }while(cont);      
        return choice;
    }
 
     public static String getDate(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }
     
     public static String getMaleOrFemale(String inputMsg, String errorMsg) {
         while(true) {
             System.out.print(inputMsg);
             String gender = sc.nextLine();
             if(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))
                 return gender;
             else
                 System.out.println(errorMsg);
         }
    }
}
