package com.example.mrnobody.mycalculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String s1="";
    public static String s2="";
    public static int flagX=0;
    public static String special="";
    public static String sqrtString="";
    HorizontalScrollView mH;

    public double temp=0;
    public static int flag=0;

    TextView mEditText,mTextViewT;


    public void finalResult(View v){
        double roundoff;
        int hh;
        flag=0;
        String prk[]=s2.split(" ");
        int z=prk.length;
        if(z>1) {
            s2 = s2 + s1+sqrtString+special;
            String srk[] = s2.split(" ");
            double mid = 0;
            int y = srk.length;
            if (y == 2) {
                temp = Double.parseDouble(srk[0]);
                roundoff=Math.round(temp* 100000.0) / 100000.0;
                if(roundoff%1==0){
                    hh=(int)roundoff;
                mEditText.setText("" + hh);
                    special = "" + hh;}
                else{
                    mEditText.setText("" + roundoff);
                    special=""+roundoff;}


                mTextViewT.setText(s2);
                s1 = "";
                s2 = "";

            } else if (y == 3) {
                temp = Double.parseDouble(srk[0]);
                double n = Double.parseDouble(srk[y - 1]);
                switch (srk[y - 2]) {
                    case "+":
                        mid = temp + n;
                        break;
                    case "-":
                        mid = temp - n;
                        break;
                    case "*":
                        mid = temp * n;
                        break;
                    case "/": {
                        if((int)n==0){
                            flagX=1;
                            s1="";

                            special="";
                            temp=0;
                            sqrtString="";
                            flag=0;
                            mEditText.setText("infinity");
                            mTextViewT.setText(s2);
                            s2="";}
                            else
                        mid = temp / n;
                    }
                }

                if(flagX==1){flagX=0;}
else{

                temp = mid;
                String lll = "" + mid;

                s1 = "";
                mTextViewT.setText(s2); mEditText.setText("" + temp);
                special = "" + temp;

                s2 = "";
               roundoff=Math.round(temp* 100000.0) / 100000.0;
                if(roundoff%1==0){
                    hh=(int)roundoff;
                    mEditText.setText("" + hh);
                    special = "" + hh;}
                else{
                    mEditText.setText("" + roundoff);
                    special=""+roundoff;
                }

            } }else if (y > 3 && y % 2 == 0) {

                mTextViewT.setText(s2 + s1);
                s2 = "";
                s1 = "";
                roundoff=Math.round(temp* 100000.0) / 100000.0;
                if(roundoff%1==0){
                    hh=(int)roundoff;
                    mEditText.setText("" + hh);
                    special = "" + hh;}
                else{
                    mEditText.setText("" + roundoff);
                   special=""+roundoff;
                }


            } else if (y > 3 && y % 2 != 0) {

                double n = Double.parseDouble(srk[y - 1]);
                switch (srk[y - 2]) {
                    case "+":
                        mid = temp + n;
                        break;
                    case "-":
                        mid = temp - n;
                        break;
                    case "*":
                        mid = temp * n;
                        break;
                    case "/":
                        if((int)n==0){
                            flagX=1;
                            s1="";

                            special="";
                            temp=0;
                            sqrtString="";
                            flag=0;
                            mEditText.setText("infinity");
                            mTextViewT.setText(s2);
                            s2="";
                        }
                        else
                        mid = temp / n;

                }
                if(flagX==1){flagX=0;}
                else{

                temp = mid;
                String lll = "" + mid;

                s1 = "";
                mTextViewT.setText(s2);
                s2 = "";
                roundoff=Math.round(temp* 100000.0) / 100000.0;
                if(roundoff%1==0){
                    hh=(int)roundoff;
                    mEditText.setText("" + hh);
                    special = "" + hh;}
                else{
                    mEditText.setText("" + roundoff);
                    special=""+roundoff;
                }

            }}

            else{
                mTextViewT.setText("");
                roundoff=Double.parseDouble(s1);
                roundoff=Math.round(roundoff*100000.0)/100000.0;
                if(roundoff%1==0){
                    hh=(int)roundoff;
                mEditText.setText("hh");
                special=""+hh;}
                else{
                    mEditText.setText(""+roundoff);
                    special=""+roundoff;
                }
                s1="";
                s2="";
                temp=Double.parseDouble(special);

            }


        }



    }

    public String calculateValues(){
        double roundoff;
        int hh;
        flag=0;
        double res=0,mid;
        String sar[]=s2.split(" ");
        int y=sar.length;
        Log.e("FILTER",""+y);
        if(y>=3){
            //double m=Double.parseDouble(s1);
            double n=Double.parseDouble(sar[y-2]);
            switch(sar[y-3]){
                case "+":
                    res=temp+n;
                    break;
                case "-":
                    res = temp-n;
                    break;
                case "*":
                    res=temp*n;
                    break;
                case "/":
                    if((int)n==0){
                            flagX=1;
                            s1="";
                            s2="";
                            special="";
                            temp=0;
                            sqrtString="";
                            flag=0;

                    }
                    else
                    res=temp/n;

            }
            if(flagX==1){
                flagX=0;
                return "infinity";
            }
            else{
            sqrtString="";
            temp=res;
            roundoff=Math.round(temp* 100000.0) / 100000.0;
            if(roundoff%1==0){
                hh=(int)roundoff;
                return ""+hh;
               }
            else{
              return ""+roundoff;
            }

        }}

     else {
            temp = Double.parseDouble(sar[0]);
            String lll="0";
            sqrtString="";
            return lll;
        }




    }


    public void onAddition(View v){

        if(s1.length()>0 || special.length()>0) {

           // s1=special;
            String inter = s1+sqrtString  + special           +        " + ";
            s2 = s2 + inter;
            mTextViewT.setText(s2);
            String pp = calculateValues();

            s1 = "";
            special="";
            mEditText.setText(pp);

        }
    }
    public void onSubtraction(View v){

        if(s1.length()>0|| special.length()>0){
            Log.e("FILTER","pass 2");
            String inter = s1+sqrtString     +special        +        " - ";
            s2 = s2 + inter;
            mTextViewT.setText(s2);
            String pp = calculateValues();
            s1 = "";
            special="";
            mEditText.setText(pp);

        }

    }
    public void onMultiplication(View v){

        if(s1.length()>0|| special.length()>0) {
            String inter = s1+sqrtString   +special          +        " * ";
            s2 = s2 + inter;
            mTextViewT.setText(s2);
            String pp = calculateValues();
            s1 = "";
            special="";
            mEditText.setText(pp);

        }

    }
    public void onDivision(View v){

        if(s1.length()>0|| special.length()>0) {

            String inter = s1+sqrtString   +special        +        " / ";
            s2 = s2 + inter;
            mTextViewT.setText(s2);
            String pp = calculateValues();
            special="";
            s1 = "";
            mEditText.setText(pp);

        }

    }



    public void getSquare(View v){
        double kk=Math.round(temp*1000.0)/1000.0;
        if(s1.length()>0 ){
            float jhk=Float.parseFloat(s1);
            double f=Math.pow(jhk,2);
            double roundOff = Math.round(f * 100000.0) / 100000.0;
            if(roundOff%1==0){
                int hh=(int)roundOff;
                special=""+hh;
                mEditText.setText("("+s1+")^2= "+hh);
            }
            else{
            mEditText.setText("("+s1+")^2= "+roundOff);
            // sqrtString=""+f;
            special=""+roundOff;}
            s1="";
        }

        else if(special.length()>0){
            double f =Math.pow(Double.parseDouble(special),2);
            double roundOff = Math.round(f*1000.0)/1000.0;
            if(roundOff%1==0){
                int hh=(int)roundOff;

                mEditText.setText("("+special+")^2= "+hh);
                special=""+hh;
            }
            else{
                mEditText.setText("("+special+")^2= "+roundOff);
                // sqrtString=""+f;
                special=""+roundOff;}
            s1="";

        }



    }

    public void squareRoot(View v){
        double kk=Math.round(temp*1000.0)/1000.0;
        if(s1.length()>0 ){
        float jhk=Float.parseFloat(s1);
            double f=Math.sqrt(jhk);
            double roundOff = Math.round(f * 10000.0) / 10000.0;
            if(roundOff%1==0){
                int hh=(int)roundOff;
                special=""+hh;
                mEditText.setText("sqt("+s1+")= "+hh);
            }
            else{
                mEditText.setText("sqt("+s1+")= "+roundOff);
                // sqrtString=""+f;
                special=""+roundOff;}

            s1="";

        }

        else if(special.length()>0){
            double f =Math.sqrt(Double.parseDouble(special));
            double roundOff = Math.round(f * 1000.0) / 1000.0;
            if(roundOff%1==0){
                int hh=(int)roundOff;
                mEditText.setText("sqt("+special+")= "+hh);
                special=""+hh;

            }
            else{
                mEditText.setText("sqt("+special+")= "+roundOff);
                // sqrtString=""+f;
                special=""+roundOff;}
            s1="";

        }



    }



    public void pointValues(View v){

        if(flag==0){
        if(s1.length()>0){
            s1=s1+".";
            mEditText.setText(s1);
        }
        else
            s1="0.";
            mEditText.setText(s1);
        flag=1;
        }

    }

    public void deleteOneCharacter(View v){
        if(s1.length()>0) {
            s1 = s1.substring(0, s1.length() - 1);
            mEditText.setText(s1);
            if (s1.length() == 0)
                mEditText.setText("0");

        }

        else {
            s1="";
            s2="";
            special="";
            temp=0;
            flag=0;
            sqrtString="";
            mEditText.setText("0");
            mTextViewT.setText("");
        }
        }


    public void allDelete(View v){
        s1="";
        s2="";
        special="";
        temp=0;
        sqrtString="";
        flag=0;
        mEditText.setText("0");
        mTextViewT.setText("");


    }


    public void setButtonTextCalculator(View v){
        special="";
        Button k =(Button)v;
        String m=k.getText().toString();
        s1=s1+m;
        mEditText.setText(s1);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    mEditText = (TextView)findViewById(R.id.edit_text_calc);
    mTextViewT=(TextView)findViewById(R.id.intermediate);

        Typeface myTypeface = Typeface.createFromAsset(this.getAssets(),"fonts/DS-DIGIB.TTF");

        mEditText.setTypeface(myTypeface);

        mTextViewT.setTypeface(myTypeface);
       /* mEditText.setHorizontallyScrolling(true);
        	mEditText.setSingleLine(true);
        	mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);



        mTextViewT.setHorizontallyScrolling(true);
        mTextViewT.setSingleLine(true);
        mTextViewT.setInputType(InputType.TYPE_CLASS_NUMBER);*/


    }
}
