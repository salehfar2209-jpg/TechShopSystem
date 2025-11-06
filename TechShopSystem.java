public class TechShopSystem {
    //פונקציה שבודקת אם המספר לקוח תקין
    public static boolean isValidCustomerId(String id){
        if (id.length() != 6){
            return false;
        }
        for (int i=0 ; i < id.length();i++) {
            char c = id.charAt(i);
            if(c < '0' || c > '9'){
                return false;
            }

        }
        return true;
    }
    //בודקת אם קוד מוצר תקין (מתחיל ב-P ו-4 ספרות אחרי)
    public static boolean isValidProductCode(String code){
        if (code.length()!=5){
            return false;
        }
        if (code.charAt(0)!='P'){
            return false;
        }
        for (int i=1; i<code.length(); i++){
            int digit=code.charAt(i) - '0';
            if(digit < 0 || digit > 9)

            {
                return false;
            }
        }
        return true;
    }
    // מחשבת את סכום ספרותיו של הלקוח
    public static int sumDigitsOfCustomerId(String customerId){
        int sum = 0;
        int i = 0;

        while (i < customerId.length()) {
            int digit = customerId.charAt(i) - '0';
            sum += digit;
            i++;
        }

        return sum;
    }
    //חישובים עסקיים

    //  מחשבת את סך התשלום הסופי אחרי הנחה ומע"ם
    public static double calculateFinalPrice(Customer customer, Product product){
        double price = product.getPrice();
        if (customer.isVipMember()) {
            price = price * 0.9; // 10% הנחה
        }
        price = price * 1.17; // תוספת מע"מ
        return price;
    }
    //מחזירה הודעה על סטטוס הזמנה בהתבסס על גיל לקוח ומחיר מוצר

    public static boolean isValidPurchase(Customer customer , Product product ){
        if (customer.isYoungCustomer()){
            if (customer.getTotalPurchases() + product.getPrice() > 8000){
                return false;
            }
        }
        return true;
    }
    public static String getOrderStatus(Customer customer, Product product) {
        if (customer.isYoungCustomer() && product.getPrice() > 8000) {
            return "הזמנה נדחתה – לקוח צעיר לא יכול לרכוש מוצר יקר";
        } else {
            return "ההזמנה אושרה";
        }
    }







    public static void main(String[] args){
        Customer customer1 = new Customer("123456", "yossi", "cohen", 1995, 2000.0, false);
        Customer customer2 = new Customer("234567", "sara", "levi", 2000, 6000.0, true);
        Customer customer3 = new Customer("345678", "mohamed", "naser", 1985, 1200.0, false);
        Customer customer4 = new Customer("456789", "fatema", "khalaily", 1998, 8000.0, true);
        Customer customer5 = new Customer("567890", "omer", "shemesh", 2002, 300.0, false);
        Product product1 = new Product("P1001", "iPhone 15", 4500.0, "smartphones", 12, true);
        Product product2 = new Product("P2001", "MacBook Pro", 8500.0, "laptops", 36, true);
        Product product3 = new Product("P3001", "iPad Air", 2800.0, "tablets", 24, true);
        Product product4 = new Product("P4001", "Samsung Galaxy", 3200.0, "smartphones", 18, true);


        System.out.println(" מערכת ניהול חנות דיגיטלית ");
        System.out.println(":הדפסת פרטי כל הלקוחות");
        System.out.println();
        System.out.println("לקוח: " + customer1.getFirstName() + " " + customer1.getLastName() + " (" + customer1.getCustomerId() + ")");
        System.out.println("גיל: " + customer1.getAge() + ", סך קניות: " + customer1.getTotalPurchases() + ", סטטוס: VIP? " + customer1.isVipMember());
        System.out.println();
        System.out.println("לקוח: " + customer2.getFirstName() + " " + customer2.getLastName() + " (" + customer2.getCustomerId() + ")");
        System.out.println("גיל: " + customer2.getAge() + ", סך קניות: " + customer2.getTotalPurchases() + ", סטטוס: VIP? " + customer2.isVipMember());
        System.out.println();
        System.out.println("לקוח: " + customer3.getFirstName() + " " + customer3.getLastName() + " (" + customer3.getCustomerId() + ")");
        System.out.println("גיל: " + customer3.getAge() + ", סך קניות: " + customer3.getTotalPurchases() + ", סטטוס: VIP? " + customer3.isVipMember());
        System.out.println();
        System.out.println("לקוח: " + customer4.getFirstName() + " " + customer4.getLastName() + " (" + customer4.getCustomerId() + ")");
        System.out.println("גיל: " + customer4.getAge() + ", סך קניות: " + customer4.getTotalPurchases() + ", סטטוס: VIP? " + customer4.isVipMember());
        System.out.println();
        System.out.println("לקוח: " + customer5.getFirstName() + " " + customer5.getLastName() + " (" + customer5.getCustomerId() + ")");
        System.out.println("גיל: " + customer5.getAge() + ", סך קניות: " + customer5.getTotalPurchases() + ", סטטוס: VIP? " + customer5.isVipMember());
        System.out.println();

// הדפסת פרטי כל המוצרים
        System.out.println(":הדפסת פרטי כל המוצרים");
        System.out.println();
        System.out.println("מוצר: " + product1.getProductName() + " (" + product1.getProductCode() + ")");
        System.out.println("קטגוריה: " + product1.getCategory() + ", מחיר: " + product1.getPrice() + ", אחריות: " + product1.getWarrantyMonths() + " חודשים, במלאי? " + product1.isInStock());
        System.out.println();
        System.out.println("מוצר: " + product2.getProductName() + " (" + product2.getProductCode() + ")");
        System.out.println("קטגוריה: " + product2.getCategory() + ", מחיר: " + product2.getPrice() + ", אחריות: " + product2.getWarrantyMonths() + " חודשים, במלאי? " + product2.isInStock());
        System.out.println();
        System.out.println("מוצר: " + product3.getProductName() + " (" + product3.getProductCode() + ")");
        System.out.println("קטגוריה: " + product3.getCategory() + ", מחיר: " + product3.getPrice() + ", אחריות: " + product3.getWarrantyMonths() + " חודשים, במלאי? " + product3.isInStock());
        System.out.println();
        System.out.println("מוצר: " + product4.getProductName() + " (" + product4.getProductCode() + ")");
        System.out.println("קטגוריה: " + product4.getCategory() + ", מחיר: " + product4.getPrice() + ", אחריות: " + product4.getWarrantyMonths() + " חודשים, במלאי? " + product4.isInStock());
        System.out.println();


        //הדגמת פונקציות עזר שנמצאות במחלקה הראשית
        System.out.println(" ---הדגמת פונקציות עזר מהמחלקה הראשית--- ");
        System.out.println(" ");
        System.out.println(" המחיר של המוצר השלישי אחרי ההנחה עבור לקוח  2:  " + calculateFinalPrice(customer2 , product3));
        System.out.println(" ");
        System.out.println(" מחיר מוצר 2 עבור לקוח  1:  " + calculateFinalPrice(customer1 ,  product2));
        System.out.println(" ");
        System.out.println(" האם הקוד עבור לקוח מספר 3 תקין : " + isValidCustomerId(customer3.getCustomerId()));
        System.out.println(" ");
        System.out.println( " האם הקוד של מוצר 1 הוא תקין " + isValidProductCode(product1.getProductCode()));
        System.out.println(" ");
        System.out.println("סכום הספרות של הקוד של לקוח מספר   2: " + sumDigitsOfCustomerId(customer2.getFirstName() + customer2.getCustomerId()));
        System.out.println(" ");
        System.out.println(" האם העסקה חוקית " + isValidPurchase(customer2, product3));
        System.out.println(" ");
        System.out.println( " סטטוס הזמנה עבור לקוח מספר 1 שמנסה לקנות מוצר 4 הוא : " + getOrderStatus(customer1, product4));
        System.out.println(" ");

        //הדגמת פונקציות ממחלקת לקוחות
        System.out.println(" ---הדגמת פונקציות ממחלקת לקוחות--- ");
        System.out.println(" ");
        System.out.println(" סך קניות של לקוח 1 : " + customer1.getTotalPurchases()+ " האם הוא vip : " + customer1.isVipMember());
        System.out.println(" ");
        System.out.println( " המחיר של מוצר 3 אחרי הנחה : " + customer1.calculateDiscount(product3.getPrice()));
        System.out.println(" ");
        System.out.println( " האם הלקוח נחשב כצעיר : " + customer1.isYoungCustomer());
        System.out.println(" ");
        System.out.println( " האם לקוח 1 נחשב כנאמן :  " + customer1.isLoyalCustomer());
        System.out.println(" ");
        System.out.println(  " קוד לקוח מספר 1 על בסיס נתונים קיימים :  " + customer1.generateCustomerCode());
        System.out.println(" ");

        //הדגמת פונקציות ממחלקת מוצרים
        System.out.println(" ---הדגמת פונקציות ממחלקת מוצרים--- ");
        System.out.println(" ");
        product1.increasePriceByPercent(10);//העלאת המחיר של מוצר 1 ב10 אחוז
        System.out.println(  " המחיר של מוצר 1 אחרי העלאה ב10 אחוז : " + product1.getPrice());
        System.out.println(" ");
        System.out.println(" המחיר של מוצר 1 אחרי מע'מ " + product1.getPriceWithVAT());
        System.out.println(" ");
        System.out.println( " האם מוצר 1 נחשב כמוצר יקר ?  " + product1.isExpensiveProduct());
        System.out.println(" ");
        System.out.println( " הרם מוצר 1 נחשב כמוצר שכדאי לקנייה ?  " + product1.isWorthBuying());
        System.out.println(" ");
        System.out.println(" האם האחריות על מוצר 1 היא ארוכה : " + product1.hasLongWarranty());
        System.out.println(" ");
        System.out.println( " דוח מפורט למוצר 1 : " + product1.analyzeProductName());





        //תרחיש 1
        System.out.println( " --- תרחיש 1 ---");
        System.out.println( " האם העסקה שלקוח חמש קונה מוצר מספר 2 היא חוקית : " + isValidPurchase(customer5,product2));
        System.out.println(" ");
        //תרחיש 2
        System.out.println( " --- תרחיש 2 ---");
        customer4.addPurchase(product1.getPrice());
        customer4.addPurchase(product2.getPrice());
        customer4.addPurchase(product3.getPrice());
        customer4.addPurchase(product4.getPrice());
        System.out.println(" המחיר הסופי של העסקה של הלקוח 4 אחרי קניית 4 מוצרים : " + customer4.getTotalPurchases());
        System.out.println(" ");
        //תרחיש 3
        System.out.println( " --- תרחיש 3 ---");
        System.out.println( " יעד מכירות ללקוח 1 עבור חודש הבא" +  ' ' + customer1.getTotalPurchases()*1.2);
        System.out.println( " יעד מכירות ללקוח 2 עבור חודש הבא" +  ' ' + customer2.getTotalPurchases()*1.2);
        System.out.println( " יעד מכירות ללקוח 3 עבור חודש הבא" +  ' ' + customer3.getTotalPurchases()*1.2);
        System.out.println( " יעד מכירות ללקוח 4 עבור חודש הבא" +  ' ' + customer4.getTotalPurchases()*1.2);
        System.out.println( " יעד מכירות ללקוח 5 עבור חודש הבא" +  ' ' + customer5.getTotalPurchases()*1.2);



    }

}















