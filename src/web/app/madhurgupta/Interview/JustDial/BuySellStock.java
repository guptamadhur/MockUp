package web.app.madhurgupta.Interview.JustDial;
/*
        # Author: Madhur Gupta
        # Github: github.com/guptamadhur
        # Project: Java MockUp

        Program to find best buying and selling days
*/

import java.util.ArrayList;

class IntervalStock
{
    int buy;
    int sell;

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }
}

class BuySellStock
{
    public static void main(String args[])
    {
        BuySellStock stock = new BuySellStock();

        // stock prices on consecutive days
        int price[] = {7, 1, 5, 3, 6};
        int n = price.length;

        // fucntion call
        stock.stockBuySell(price, n);
    }

    // This function finds the buy sell schedule for maximum profit
    void stockBuySell(int price[], int n)
    {
        // solution array
        ArrayList<IntervalStock> sol = new ArrayList<IntervalStock>();

        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0;

        // Traverse through given price array
        int i = 0;
        while (i < n - 1)
        {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            IntervalStock e = new IntervalStock();

            e.setBuy(price[i++]);
            // Store the index of minima


            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            e.setSell(price[i-1]);
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }

        // print solution
        int profit = 0;
        if (count == 0)
            System.out.println("No Profit");
        else
            for (int j = 0; j < count; j++){
                System.out.println("Buy at:"+ sol.get(j).getBuy() + " Sell at:" +sol.get(j).getSell());

                profit = profit+ sol.get(j).sell - sol.get(j).buy;
            }

        System.out.println("Total Profit: "+profit);

        return;
    }
}
  