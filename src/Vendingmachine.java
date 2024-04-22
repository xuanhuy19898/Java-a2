
/**
 * Implementation of a measuring Scale with a random weight on the
 * left side. The user can manipulate the right to try and balance it.
 *
 * @author XUAN HUY PHAM - 000899551
 */
public class Vendingmachine {
    /**
     * name of products
     **/
    private String productName;
    /**
     * price of products
     **/
    private double productPrice;
    /**
     * quantity of products
     **/
    private int productQuantity;
    /**
     * the amount of unused credit
     **/
    private double unusedCredit;
    /**
     * the total of money the vending machine has got since it got switch on
     **/
    private double totalmoney;
    /**
     * count the number of toonies
     **/
    private int toonieCount;
    /**
     * count the number of loonies
     **/
    private int loonieCount;
    /**
     * count the number of quarters
     **/
    private int quarterCount;
    /**
     * count the number of nickels
     **/
    private int nickelCount;
    /**
     * count the number of dimes
     **/
    private int dimeCount;

    /**
     * @param productName     The name of the product.
     * @param productPrice    The price of the product.
     * @param productQuantity The quantity of the product.
     *                        these are to assign values to instance variable of vendingmachine
     *                        they set the name, price, quantity, amount of unused credit and the total amount of coins inserted
     */
    public Vendingmachine(String productName, double productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.unusedCredit = 0.0;
        this.totalmoney = 0.0;
        this.toonieCount = 0;
        this.loonieCount = 0;
        this.quarterCount = 0;
        this.dimeCount = 0;
        this.nickelCount = 0;
    }


    /**
     * @return the price of product
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * @return the quantity of product
     */
    public int getProductQuantity() {
        return productQuantity;
    }


    /**
     * @param toonies  values of each type of coins, toonies equal to 2.0
     * @param loonies  equal to 1.0
     * @param quarters equal to 0.25
     * @param dimes    equal to 0.10
     * @param nickels  equal to 0.05
     */
    public void insertCoin(double toonies, double loonies, double quarters, double dimes, double nickels) {
        unusedCredit += toonies * 2.0;
        toonieCount += (int) toonies;

        unusedCredit += loonies * 1.0;
        loonieCount += (int) loonies;

        unusedCredit += quarters * 0.25;
        quarterCount += (int) quarters;

        unusedCredit += dimes * 0.10;
        dimeCount += (int) dimes;

        unusedCredit += nickels * 0.05;
        nickelCount += (int) nickels;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    /**
     * @param quantity how many items user want to vend
     * @return true if it satisfy all the conditions
     */
    //this method is to response to user in case there's not enough credit or there's no product left
    //if unused credit is more than the total bill, the machine will work, and deduct the product quantity
    public boolean vend(int quantity) {
        if (productQuantity >= quantity) {
            double totalBill = productPrice * quantity;
            if (unusedCredit >= totalBill) {
                productQuantity -= quantity;
                totalmoney += totalBill;
                unusedCredit -= totalBill;
                setUnusedCredit(); // Update unusedCredit after deducting the credit
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @return the current unsued credit back to user
     */
    //then it set the amount of unusedd credit back to 0
    //it will return and show that amount to user
    public double returnCredit() {
        if (unusedCredit > 0) {
            double amountReturn = unusedCredit;
            unusedCredit = 0;
            toonieCount = 0;
            loonieCount = 0;
            quarterCount = 0;
            dimeCount = 0;
            nickelCount = 0;
            setUnusedCredit();
            return amountReturn;
        } else {
            return 0.0;
        }
    }

    /**
     * help to calculate the total credit and decut the unused credit if user buys items
     */
    public void setUnusedCredit() {
        double totalCredit = toonieCount * 2.0 + loonieCount * 1.0 + quarterCount * 0.25 + dimeCount * 0.10 + nickelCount * 0.05;
        unusedCredit = totalCredit - totalmoney;
        if (unusedCredit < 0) {
            unusedCredit = 0;
        }
    }

    /**
     * @return the unused credit
     */
    public double getUnusedCredit() {
        return unusedCredit;
    }

    /**
     * @return a full report showing all the status such as quantity or unused credits
     */
    //this string is to show a full report about the transaction.
    @Override
    public String toString() {
        setUnusedCredit();
        return "VendingMachine: " + productQuantity + " " + productName +
                ", $" + productPrice + ", $" + unusedCredit +
                ", $" + totalmoney;
    }
}
