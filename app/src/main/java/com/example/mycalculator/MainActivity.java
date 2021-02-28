package com.example.mycalculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private TextView textView, preResultTextView;
    private List<List<Object>> calculateList = new ArrayList<>();

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonPoint = findViewById(R.id.button_point);

        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonMultiplication = findViewById(R.id.button_multiply);
        Button buttonSplit = findViewById(R.id.button_split);

        Button buttonResult = findViewById(R.id.button_result);

        Button buttonPercent = findViewById(R.id.button_percent);
        Button buttonGP = findViewById(R.id.button_generate_password);

        Button buttonMemoryClear = findViewById(R.id.button_memory_clear);
        Button buttonMemoryPlus = findViewById(R.id.button_memory_plus);
        Button buttonMemoryRead = findViewById(R.id.button_memory_read);
        Button buttonMemoryMinus = findViewById(R.id.button_memory_minus);

        Button buttonSQRT = findViewById(R.id.button_sqrt);
        Button buttonSquare = findViewById(R.id.button_square);

        Button buttonCancel = findViewById(R.id.button_cancel);

        textView = findViewById(R.id.textView);
        preResultTextView = findViewById(R.id.textView2);
        textView.setText("");
        preResultTextView.setText("");


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().length() == 1 & textView.getText().toString().equals("0")) {
                    return;
                }
                textView.setText(textView.getText().toString() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + "9");
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().contains(".")) {
                    return;
                }
                textView.setText(textView.getText().toString() + ".");
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                    return;
                }
                preResultTextView.setText(calculationResult(textView.getText(),"+"));
                textView.setText(textView.getText().toString() + "+");

            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                    return;
                }
                preResultTextView.setText(calculationResult(textView.getText(),"-"));
                textView.setText(textView.getText().toString() + "-");
            }
        });
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                    return;
                }
                preResultTextView.setText(calculationResult(textView.getText(),"*"));
                textView.setText(textView.getText().toString() + "*");
            }
        });
        buttonSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSymbol(textView.getText().toString().substring(textView.getText().length() - 1))) {
                    return;
                }
                preResultTextView.setText(calculationResult(textView.getText(),"/"));
                textView.setText(textView.getText().toString() + "/");
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                preResultTextView.setText("");
                calculateList.clear();
                index = 0;
            }
        });
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO выполнить действие между числами
                textView.setText(calculationResult(textView.getText().toString(),"="));
                //textView.setText(preResultTextView.getText());
                preResultTextView.setText("");
                calculateList.clear();
                index = 0;
            }
        });

    }

    private boolean checkSymbol(String charAction) {
        String m = "+-*/";
        return m.contains(charAction);
    }

    private CharSequence calculationResult(CharSequence number, String act) {
        String aux;
        if (calculateList.size() == 0) {
            calculateList.add(index,new ArrayList<>());
            calculateList.get(index).add(Double.parseDouble(number.toString()));
            calculateList.get(index).add(act);
            calculateList.get(index).add(number.length());
            return number;
        }
        aux = number.subSequence((int) calculateList.get(index).get(2),number.length()).toString();
        if (aux.contains("*") | aux.contains("/")) {
            aux = aux.substring(1);
        }
        index++;
        calculateList.add(index, new ArrayList<>());
        try {
            calculateList.get(index).add(Double.parseDouble(aux));
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return preResultTextView.getText();
            //TODO вставить логирование
        }
        calculateList.get(index).add(act);
        calculateList.get(index).add(number.length());
        return matrixAnalysisCalculatingResult(calculateList,0);
    }

    private CharSequence matrixAnalysisCalculatingResult(List<List<Object>> matrix, int i) {
        String action_1;
        String action_2;
        double result = (double) matrix.get(i).get(0);
        String priorityActions = "*/";
        String secondLevelActions = "+-";
        while (matrix.size() > i+1 ) {
            action_1 = (String) matrix.get(i).get(1);
            i++;
            action_2 = (String) matrix.get(i).get(1);
            if (priorityActions.contains(action_1)) {
                switch (action_1) {
                    case "*": {
                        result = result * (double) matrix.get(i).get(0);
                        continue;
                    }
                    case "/": {
                        result = result / (double) matrix.get(i).get(0);
                        continue;
                    }
                }
            }
            if (secondLevelActions.contains(action_2) | secondLevelActions.contains(action_1) & matrix.size() == i+1) {
                result = result + (double) matrix.get(i).get(0);
            }
        }
        return Double.toString(result);
    }
}