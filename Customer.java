public class Customer {
    private String customerId; // קוד לקוח שבנוי מ 6 ספרות בדיוק
    private String firstName; // שם פרטי
    private String LastName; // שם משפחה
    private int birthYear; // שנת לידה
    private double totalPurchases; //סך הכל הקניות בשקלים
    private boolean isVipMember; // האם הלקח חבר vip

    //  הבנאי ברירת המחדל
    public Customer() {
        this.customerId = "000000";
        this.firstName = "";
        this.LastName = "";
        this.birthYear = 2000;
        this.totalPurchases = 0.0;
        this.isVipMember = false;
    }
    // בנאי שמקבל את כל הפרמטרים

    public Customer(String customerId, String firstName, String lastName, int birthYear, double totalPurchases, boolean isVipMember) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.LastName = lastName;
        this.birthYear = birthYear;
        this.totalPurchases = totalPurchases;
        this.isVipMember = isVipMember;

        //בנאי העתקה
    }

    public Customer(Customer copy) {
        this.customerId = copy.getCustomerId();
        this.firstName = copy.getFirstName();
        this.LastName = copy.getLastName();
        this.birthYear = copy.getBirthYear();
        this.totalPurchases=copy.getTotalPurchases();
        this.isVipMember = copy.getisVIP();
    }

    public boolean getisVIP(){
        return this.isVipMember;
    }

    public String getCustomerId() {
        return customerId;
    }
    //מוודא שמספר לקוח בדיוק 6 ספרות setCustomerId

    public void setCustomerId(String customerId) {
        if (customerId.length() == 6) {
            this.customerId = customerId;

        } else {
            System.out.println("מספר לקוח חייב להיות בדיוק 6 ספרות !");
        }
    }

    public String getFirstName () {
            return firstName;
    }

    public void setFirstName (String firstName){
            this.firstName = firstName;
    }

    public String getLastName () {
            return LastName;
    }

    public void setLastName (String lastName){
            LastName = lastName;
    }

    public int getBirthYear () {
            return birthYear;
    }

    public void setBirthYear ( int birthYear){
            this.birthYear = birthYear;
    }

    public double getTotalPurchases () {
            return totalPurchases;
    }

    public void setTotalPurchases ( double totalPurchases){
            this.totalPurchases = totalPurchases;
    }

    public boolean isVipMember() {
        return this.isVipMember;
    }

    public void setVipMember (boolean vipMember){
            this.isVipMember = vipMember;
    }

         // addPurchase מוסיפה סכום לסך הקניות ובודקת אם הלקוח vip (הסכום מעל 5000 )
    public void addPurchase(double amount) {
        this.totalPurchases = this.totalPurchases + amount;
        if (this.totalPurchases > 5000){
            this.isVipMember=true;
        }

        }

        // מתודת calculateDiscount מחשבת הנחה ללקוחות vip ולקוחות רגילים
    public double calculateDiscount(double purchaseAmount){
        if (isVipMember){
            return purchaseAmount*0.15;//מחשבת הנחה 15% ללקוח vip
        }
        else {
            return purchaseAmount*0.05;//מחשבת הנחה 5% ללקוח רגיל
        }


    }
    //מתודה שמחשבת את גיל הלקוח
    public int getAge(){
        return 2025-this.birthYear;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", birthYear=" + birthYear +
                ", totalPurchases=" + totalPurchases +
                ", isVipMember=" + isVipMember +
                '}';
    }

    //מתודה שבודקת אם הלקוח צעיר מתחת לגיל 30
    public boolean isYoungCustomer(){
        return getAge() < 30;
    }

    //בודקת אם הלקוח נאמן על בסיס גיל וסכום קניות
    public boolean isLoyalCustomer(){
        if(getAge()>25 && totalPurchases>2000){
            return true;
        }
        if (isVipMember && getAge()<40){
            return true;
        }
        if (totalPurchases>8000){
            return true;
        }
        return false;


    }
    public String generateCustomerCode(){
        String result="";
        char a=getFirstName().charAt(0);
        char b= getLastName().charAt(getLastName().length()-1);
        String sumCustomerId=sumNumbers(getCustomerId());
        int last2chars=getBirthYear()%100;
        String vip="";
        if (isVipMember)
            vip="VIP";
        String lucky="";
        if (Integer.parseInt(sumCustomerId)%2==0)
            lucky="LUCKY";
        result=vip+a+b+sumCustomerId+String.valueOf(last2chars)+lucky;



        return result;
    }
    public String sumNumbers(String num) {
        int sum = 0;
        int i = 0;

        while (i < num.length()) {
            int digit = num.charAt(i) - '0';
            sum += digit;
            i++;
        }

        return String.valueOf(sum);
    }




}







