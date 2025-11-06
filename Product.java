public class Product {
    private String productCode;//קוד מוצר (מתחיל ב-"P" ו-4 ספרות)
    private String productName;//שם המוצר
    private double price;// מחיר בשקלים
    private String category;// קטגוריה (smartphones, laptops, tablets)
    private int warrantyMonths;// אחריות בחודשים
    private boolean inStock;// האם המוצר במלאי

    //בנאי ברירת מחדל
    public Product() {
        this.productCode = "P0000";
        this.productName = "";
        this.price = 0.0;
        this.category = "";
        this.warrantyMonths = 0;
        this.inStock = false;
    }

    //בנאי שמקבל את כל הפרמטרים
    public Product(String productCode, String productName, double price, String category, int warrantyMonths, boolean inStock) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.warrantyMonths = warrantyMonths;
        this.inStock = inStock;
    }

    //העתק שני של הבנאי
    public Product(Product copy) {
        this.productCode = copy.getProductCode();
        this.productName = copy.getProductName();
        this.price = copy.getPrice();
        this.category = copy.getCategory();
        this.warrantyMonths = copy.getWarrantyMonths();
        this.inStock = copy.isInStock();
    }


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    //מעלה את המחיר באחוזים
    public void increasePriceByPercent(double percent) {
        if (percent > 0) {
            this.price = this.price + (this.price * percent / 100);

        }

    }

    //מחזירה את המחיר כולל מע"ם (17%)
    public double getPriceWithVAT() {
        return this.price + (this.price * 0.17);
    }

    //בודקת אם זה מוצר יקר (מעל 3000 ש"ח)
    public boolean isExpensiveProduct() {
        if (this.price > 3000) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", warrantyMonths=" + warrantyMonths +
                ", inStock=" + inStock +
                '}';
    }

    // בודקת אם האחריות ארוכה (מעל 24 חודשים)
    public boolean hasLongWarranty() {
        if (this.warrantyMonths > 24) {
            return true;
        } else {
            return false;
        }
    }

    //בודקת אם המוצר כדאי לקנייה על בסיס יחס מחיר-איכות
    public boolean isWorthBuying() {
        if (this.price < 2000 && this.warrantyMonths >= 12 && this.inStock) {
            return true;
        }
        if (2000 < this.price && this.price < 5000 && this.warrantyMonths >= 18 && this.inStock) {
            return true;
        }
        if (this.price > 5000 && this.warrantyMonths >= 24 && this.inStock) {
            return true;
        }
        return false;
    }

    // מנתחת את שם המוצר ויוצרת דוח מפורט
    //analyzeProductName
    public String analyzeProductName() {
        String name = productName;
        int charCount = 0; // תווים ללא רווחים
        int uppercaseCount = 0; // אותיות גדולות
        char strongestChar = ' '; // האות עם ערך ASCII הכי גבוה
        int maxAscii = 0; // הערך הכי גבוה ב-ASCII
        boolean hasDigit = false; // האם יש מספר בשם
        int letterCount = 0; // רק אותיות (לא מספרים, לא רווחים)

        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (ch != ' ') {
                charCount++;
            }

            if (ch >= 'A' && ch <= 'Z') {
                uppercaseCount++;
                letterCount++;
            }
            if (ch >= 'a' && ch <= 'z') {
                letterCount++;
            }

            if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            }

            if ((int) ch > maxAscii) {
                maxAscii = (int) ch;
                strongestChar = ch;
            }
        }

        int spaceCount = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int wordCount = spaceCount + 1;

        int upperCasePercent = 0;
        if (letterCount > 0) {
            upperCasePercent = (uppercaseCount * 100) / letterCount;
        }

        String result = ", תווים: " + charCount + ", מילים: " + wordCount + ", אות חזקה: " + strongestChar + ", אחוז גדולות: " + upperCasePercent + "%";

        if (hasDigit) {
            result += ", מוצר דור חדש";
        }

        if (upperCasePercent > 50) {
            result += ", מוצר פרימיום";
        }
        return result;
    }



}

