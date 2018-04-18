package com.example.mmant.a2app;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {


        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);


    }

    /**
     * This method is called when the plus button is clicked.
     */
    public String createOrderSummary(int payment) {

        String message = "Name: " + "\nQuantity: " + quantity + "\nTotal: " + payment + "\nThank You!";
        return message;
    }


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {

        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     *
     * @return total price
     */
    private int calculatePrice() {
        int pricePerCoffee = 5;
        return quantity * pricePerCoffee;
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private int display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        return number;
    }

    /**
     * This method displays the given price on the screen.

     private void displayPrice(int number) {
     TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
     priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
     }
     */


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}