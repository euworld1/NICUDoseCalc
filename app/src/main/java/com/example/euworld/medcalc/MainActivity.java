package com.example.euworld.medcalc;

// test change

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;



public class MainActivity extends AppCompatActivity {


    private EditText babyMass;
    private TextView t;




    private static final int ATROETTDOSE = 1;//global variables Instance VAriables
    private static final double CACLDOSE = 20;
    private static final double CAGLDOSE = 200;
    private final double DEXIVDOSE = 100;
    private final double DEXINFDOSE = 200;
    private final double EPIIVDOSE= 20;
    private final double EPIETTDOSE = 200;
    private final double LIDOIVDOSE = 100;
    private final double LIDOETTDOSE = 200;
    private final double LIDOINFDOSE = 20;
    private final double MGSO4DOSE = 200;
    private final double NALOXONEDOSE = 100;
    private final double PRODOSE = 200;
    private final double NABIDOSE = 20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.medication_array, android.R.layout.simple_spinner_item);

        final TextView t = (TextView) findViewById(R.id.outputScreen);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        t.setEnabled(true);






        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  //interface
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();

               EditText babyMass = (EditText) findViewById(R.id.babyMass);
                String bMass = babyMass.getText().toString();
                Log.d("sdfsdf", babyMass.toString());




                switch (position) {
                    case 0:

                        t.append("");
                        t.append("Your calculated dose for Atropine ETT (.1 mg/) would be: "+ getAtropine());
                        t.append("\n\n notes * Has not been studied; IV route preferred (see IV/IO dosing");
                        t.append("\n\n notes * Flush with NS");
                        t.append("\n\n notes *");
                        break;
                    case 1:
                        t.setText("");
                        caCl();
                        t.append("caCl");
                        break;
                    case 2:
                        t.setText("");
                        caGL();
                        break;
                    case 3:
                        t.setText("");
                        dextrose();
                        break;
                    case 4:
                        t.setText("");
                        dextrose10();
                        break;
                    case 5:
                        t.setText("");
                        ePIIV();
                        break;
                    case 6:
                        t.setText("");
                        ePIETT();
                        break;
                    case 7:
                        t.setText("");
                        lidoIV();
                        break;
                    case 8:
                        t.setText("");
                        lidoETT();
                        break;
                    case 9:
                        t.setText("");
                        lidoInf();
                        break;
                    case 10:
                        t.setText("");
                        mgSO4();
                        break;
                    case 11:
                        t.setText("");
                        nax();
                        break;
                    case 12:
                        t.setText("");
                        pro();
                        break;
                    case 13:
                        t.setText("");
                        naBi();
                        break;
*/
                    default:
                        t.append("Nigga! Try again");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

            private void naBi() {
                // TODO Auto-generated method stub
                //performs calculation

                double calculatedDose = NABIDOSE  * babyMass / 100;

                t.append("Your calculated dose Sodium Bicarbonate (4.2%) IV/IO (0.5 mEq/mL) would be: " + calculatedDose + " mL"  );
                t.append("\n\nnotes  * Administer as a slow bolus every 10 minutes as indicated by arterial blood gasses");
                t.append("\n\nnotes  * Should not be routinely used for cardiac arrest");

            }


            private void pro() {
                // TODO Auto-generated method stub
                double calculatedDose = PRODOSE  * babyMass / 100;

                t.append("Your calculated dose Procainamide IV/IO (500 mg/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * Dilute to <=30 mg/mL in NS prior to administration ");
                t.append("\n\nnotes  * Infuse over 30-60 minutes");
                t.append("\n\nnotes  * Reduced dose recommended in patients with hepatic or renal impairment");
            }


            private void nax() {
                // TODO Auto-generated method stub
                double calculatedDose = NALOXONEDOSE  * babyMass / 100;

                t.append("Your calculated dose Naloxone IV/IM (1 mg/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * Rapid bolus over 30 seconds");
                t.append("\n\nnotes  * Not recommended as part of initial resusitative efforts in the delivery room for newborns with respitory depression");
                t.append("\n\nnotes  * Before use, heart rate and color must be restored bt supporting ventilation ");
                t.append("\n\nnotes  * Avoid in babies whose mothers are suspected of having had long-term exposure to opioids");
            }


            private void mgSO4() {
                // TODO Auto-generated method stub
                double calculatedDose = MGSO4DOSE  * babyMass / 100;

                t.append("Your calculated dose Magnesium Sulfate IV/IO (500 mg/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  *If necessary, Dilute to <=mg/mL in D5W or NS prior to infusion");
                t.append("\n\nnotes  * Infuse over 10-20 minutes (over several minutes for torsade de pointes");

            }


            private void lidoInf() {
                // TODO Auto-generated method stub
                double calculatedDose = LIDOINFDOSE  * babyMass/ 100;

                t.append("Your calculated dose Lidocaine Infusion (4 mg/mg would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * Reduced dose recommendation in patients with hepatic impairment");

            }


            private void lidoETT() {
                // TODO Auto-generated method stub
                double calculatedDose = LIDOETTDOSE  * babyMass / 100;

                t.append("Your calculated dose Lidocaine ETT (10 mg/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * Flush with NS");
                t.append("\n\nnotes  * Follow with 5 assisted manual ventilations");

            }


            private void lidoIV() {
                // TODO Auto-generated method stub
                double calculatedDose = LIDOIVDOSE  * babyMass / 100;

                t.append("Your calculated dose Lidocaine IV/IO (10 mg/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * Administer as a rapid bolus");
                t.append("\n\nnotes  * Volumes <0.2 mL are not able to be accurately measured with standard syringes; prepare a dilution to provide the dose");

            }


            private void ePIETT() {
                // TODO Auto-generated method stub
                double calculatedDose = EPIETTDOSE  * babyMass / 100;

                t.append("Your calculated dose EPINEPHrine (1:10,000) ETT (0.1 mg/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * Due to lack of data with ETT administration, IV route is preferred (see IV/IO dosing");
                t.append("\n\nnotes  * Flush with NS");
                t.append("\n\nnotes  * Follow with 5 assisted manual ventilations ");
                t.append("\n\nnotes  * Interval: Every 3-5 minutes as needed");
            }


            private void ePIIV() {
                // TODO Auto-generated method stub
                double calculatedDose = EPIIVDOSE  * babyMass/ 100;

                t.append("Your calculated dose EPINEPHrine (1:10,000) IV/IO (0.1 mg/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * Administer as a rapid bolus");
                t.append("\n\nnotes  * Interval: Every 3-5 minutes as needed");
            }


            private void dextrose10() {
                // TODO Auto-generated method stub
                double calculatedDose = DEXINFDOSE  * babyMass / 100;

                t.append("Your calculated dose Dextrose (10%) Infusion (0.1 g/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * Monitor glucose and treat to maintain plasma glucose >= 40-50 mg/dL");
                t.append("\n\nnotes  * Note:If gestational age <34 weeks, start at the lower end of the dosing range");
            }



            private void dextrose() {
                // TODO Auto-generated method stub

                double calculatedDose = DEXIVDOSE  * babyMass / 100;

                t.append("Your calculated dose Dextrose (10%) IV/IO (0.1 g/mL) would be: " + calculatedDose + " mL" );
                t.append("\n\nnotes  * May repeat as needed or follow by a continuous infusion");
                t.append("\n\nnotes  * Monitor glucose and treat to maintain plasma glucose >= 40-50 mg/dL");
                t.append("\n\nnotes  * Note: 0.2 g/kg equivalent to 2 mL Dextrose (10%)/kg");
            }


            private void caGL() {
                // TODO Auto-generated method stub



                t.append("Your calculated dose Calcium Gluconate (10%)IV/IO (100mg/mL) would be:  mL" );
                t.append("\n\nnotes  * Dilute to <= 20 mg/mL in D5W or NS prior to administration (may consider delivering undiluted in cardiac arrest");
                t.append("\n\nnotes  * Infuse over 30 minutes for indications other than cardiac arrest (stop infusion if heart rate is <100 beats per minute); slow IV push for cardiac arrest");
                t.append("\n\nnotes  * May repeat if necessary");
                t.append("\n\nnotes  * Central line administration preferred due to severe complications of extravasation; however, glutonate is the salt of choice in non-arrest cases when central access is not available");

            }

            private void caCl() {
                // TODO Auto-generated method stub

                double calculatedDose = (CACLDOSE * babyMass / 100);

                t.append("Your calculated dose for [Calcium Cloride (10%)IV/IO (100mg/mL)] would be: " + calculatedDose + " mL ");
                t.append(" \n\n notes  * Dilute to <= 20 mg/mL in D5W or NS prior to administration (may consider delivering undiluted in cardiac arrest");
                t.append(" \n\n notes  * Infuse over 30 minutes for indications other than cardiac arrest (stop infusion if heart rate is <100 beats per minute); slow IV push for cardiac arrest");
                t.append(" \n\n notes  * May repeat if necessary");
                t.append(" \n\n notes  * Central line administration prefers due to severe complications of extravasation");
                t.append(" \n\n notes  * Volumes <0.2 mL are not able to be accurately measured with standard syringes, prepare a dilution to provide the dose");


            }
*/
            public double getAtropine () {

                return ATROETTDOSE * bMass;
            }


        });
    }}



