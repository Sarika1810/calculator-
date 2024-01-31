package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView inputtext,outputText;
private String input,output,newoutput;
private Button button0, button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonadd,
    buttonsubs,buttonmultiply,buttondivision,buttonpoint,buttonpower,button00,buttonequal,buttonclear,buttonpre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputtext=(TextView) findViewById(R.id.input_txt);
        outputText=(TextView) findViewById(R.id.output_txt);

        button0=(Button) findViewById(R.id.btn0);
        button1=(Button) findViewById(R.id.btn_one);
        button2=(Button) findViewById(R.id.btn_tow);
        button3=(Button) findViewById(R.id.btn_three);
        button4=(Button) findViewById(R.id.btn_four);
        button5=(Button) findViewById(R.id.btn_five);
        button6=(Button) findViewById(R.id.btn_six);
        button7=(Button) findViewById(R.id.btn_senve);
        button8=(Button) findViewById(R.id.btn_Eight);
        button9=(Button) findViewById(R.id.btn_nine);

        buttonadd=(Button) findViewById(R.id.btn_add);
        buttonsubs=(Button) findViewById(R.id.btn_minus);
        buttonmultiply=(Button) findViewById(R.id.btn_Multiply);
        buttondivision=(Button) findViewById(R.id.btn_Divede);
        buttonpower=(Button) findViewById(R.id.btn_Power);
        buttonequal=(Button) findViewById(R.id.btn_eaual);
        buttonpre=(Button) findViewById(R.id.btn_pre);
        buttonpoint=(Button) findViewById(R.id.btn_point);
        buttonclear=(Button) findViewById(R.id.btn_clear);
        button00=(Button) findViewById(R.id.btn_00);


    }
    public void onButtonClicked(View view) {

        Button button = (Button) view;
        String data=button.getText().toString();
        switch (data){

            case "C":
                input=null;
                output=null;
                outputText.setText("");
                 break;
            case "^":
                input+="^";
                 solve();
                 break;
            case "X":
                input+="*";
                solve();
                break;

            case "+":
                input+="+";
                solve();
                break;
            case "%":
                input+="%";
                double d= Double.parseDouble(inputtext.getText().toString())/100;
                outputText.setText(String.valueOf(d));

                break;
            case "=":

                solve();
                break;

            default:
                if(input == null)
                {
                    input ="";
                }
                if(data.equals("+")||data.equals("/")||data.equals("-"))
                {
                    solve();
                }
              input +=data;
        }
        inputtext.setText(input);
    }
    private void solve()
    {
if(input.split("\\+").length==2){
    String numbers[]=input.split("\\+");
    try{
        double d=Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
        output=Double.toString(d);
        newoutput=cutDecimal(output);
        outputText.setText(newoutput);
        input=d+"";

    }catch (Exception e)
    {
        outputText.setError(e.getMessage().toString());
    }

 }
        if(input.split("\\*").length==2){
            String numbers[]=input.split("\\*");
            try{
                double d=Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newoutput=cutDecimal(output);
                outputText.setText(newoutput);
                input=d+"";

            }catch (Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }

        }
        if(input.split("\\/").length==2){
            String numbers[]=input.split("\\/");
            try{
                double d=Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newoutput=cutDecimal(output);
                outputText.setText(newoutput);
                input=d+"";

            }catch (Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }

        }
        if(input.split("\\^").length==2){
            String numbers[]=input.split("\\^");
            try{
                double d=Math.pow(Double.parseDouble(numbers[0]),Double.parseDouble(numbers[1]));
                output=Double.toString(d);
                newoutput=cutDecimal(output);
                outputText.setText(newoutput);
                input=d+"";

            }catch (Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }

        }
        if(input.split("\\-").length==2){
            String numbers[]=input.split("\\-");
            try{
                double d=Double.parseDouble(numbers[0])-Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newoutput=cutDecimal(output);
                outputText.setText(newoutput);
                input=d+"";

            }catch (Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }

        }


    }
    private String cutDecimal(String number) {
        String n []= number.split("\\.");
        if(n.length>1){
          if (n[1].equals("0")){
              number=n[0];
          }
        }
        return number;

    }
}