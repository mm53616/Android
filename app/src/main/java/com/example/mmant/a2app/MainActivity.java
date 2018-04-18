package com.example.mmant.a2app;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        EditText nameOfUser = findViewById(R.id.typedName);
        Editable userName = nameOfUser.getText();
        CheckBox checkbox1 = findViewById(R.id.addition1);
        boolean hasAddition1 = checkbox1.isChecked();
        CheckBox checkbox2 = findViewById(R.id.addition2);
        boolean hasAddition2 = checkbox2.isChecked();
       //        Log.v("MainActivity", "Ma bita smietane "+ hasAddition1);
        int price = calculatePrice(hasAddition1, hasAddition2);
        String priceMessage = createOrderSummary(price, hasAddition1, hasAddition2, userName);
        displayMessage(priceMessage);

    }

    /**
     * This method is called when the plus button is clicked.
     */
    public String createOrderSummary(int payment, boolean hasAddition1, boolean hasAddition2, Editable userName) {

        String message = "Imię: " + userName + "\nIlość: " + quantity + "\nDodatki:" + "\nbita śmietana  "
                + hasAddition1 + "\nczekolada " + hasAddition2 +"\nSuma: " + payment + "\nDziękuję!";
        return message;
    }


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {

        if(quantity<10) {
            quantity = quantity + 1;
            display(quantity);
        }
        else
            Toast.makeText(MainActivity.this, "Nie możesz zamówić więcej kaw!", Toast.LENGTH_LONG).show();
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if(quantity>1) {
            quantity = quantity - 1;
            display(quantity);
        }
        else
            Toast.makeText(MainActivity.this, "Nie możesz zamówić mniej kaw!", Toast.LENGTH_LONG).show();
    }

    /**
     * This method displays the given quantity value on the screen.
     *
     * @return total price
     */
    private int calculatePrice(boolean cream, boolean chocolate) {
        int pricePerCoffee = 5;
        int additionalCost=0;
        if (cream){
            additionalCost+=1;}
        if (chocolate){
            additionalCost+=additionalCost+2;}
        return quantity * (additionalCost+pricePerCoffee);
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