package com.mini.solaiman.policedhara.app;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.mini.solaiman.policedhara.PdfActivity;
import com.mini.solaiman.policedhara.R;
import com.mini.solaiman.policedhara.adapter.CustomListAdapterV2;
import com.mini.solaiman.policedhara.model.Item;
import com.mini.solaiman.policedhara.model.PdfName;
import java.util.ArrayList;

public class VolumeTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_two);

        BackCon.background = 1;

        final ListView itemsListView  = (ListView)findViewById(R.id.v2list);

        //create adapter object
        CustomListAdapterV2 adapter = new CustomListAdapterV2(this, generateItemsList());
        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(VolumeTwo.this,PdfActivity.class);
                //intent.putExtra("query","ok1");
                PdfZoomControlar.zoom =true;

                TextView textView = (TextView) view.findViewById(R.id.partBtnx);
                String text = textView.getText().toString();
                PdfName.name=text;
                startActivity(intent);
            }
        });
        itemsListView.setAdapter(adapter);
    }

    private ArrayList<Item> generateItemsList() {
        ArrayList<Item> list = new ArrayList<>();

        list.add(new Item("I. Table showing all ranks of police officers in order of precedence",""));
        list.add(new Item("II. Procedure to be followed in connection with the alteration in the constitution, jurisdiction, site or nomenclature of police-stations. ",""));
        list.add(new Item("III. Instructions for the custody, issue and use of warrants for journeys on duty by police officers by railway, steamer or omnibus services. ",""));
        list.add(new Item("IV. Requisitions for military aid in dispersing unlawful assemblies.",""));
        list.add(new Item("V. Directions to be followed in obtaining arrest of an offender who has escaped to the United Kingdom, a colony or some other British possession.",""));
        list.add(new Item("VI. Hints on detecting counterfeit coins.",""));
        list.add(new Item("VII. List of miscellaneous duties of which the police, under the orders of the Provincial Government, have been wholly or partially relieved.",""));
        list.add(new Item("VIII. List of miscellaneous Acts and Rules conferring powers on the Police",""));
        list.add(new Item("IX. Standardized spelling of Indian personal names.",""));
        list.add(new Item("X. Method of recording personal descriptions.",""));
        list.add(new Item("XI. Instructions for maintaining index of crime in the office of the Superintendent and by the Circle Inspector. ",""));
        list.add(new Item("XII. List of periodical reports and returns due to and from various officers",""));
        list.add(new Item("XIII. List of registers and files to be maintained in various offices.",""));
        list.add(new Item("XIV. Rules for the care, custody and despatch of weapons deposited in police-stations and court malkhanas",""));
        list.add(new Item("XV. Special Reports of Crimes",""));
        list.add(new Item("XVI. A Sample Case Diary of A Burglary Case",""));
        list.add(new Item("XVII. Memorandum of instructions for the guidance of police and other officers in sending documents for examination by the Government Examiner of Questioned Documents or requiring his attendance in Law Courts.",""));
        list.add(new Item("XVIII. Memorandum of instructions for the guidance of police officers in making requisitions for expert opinion and in sending exhibits for examination in connection with the investigation of cases. ",""));
        list.add(new Item("XIX. Directions for investigation in cases of suspicious and unnatural deaths.",""));
        list.add(new Item("XX. Pursuit, arrest and extradition of offenders escaping out of British India into State territory or vice versa.",""));
        list.add(new Item("XXI. Procedure for securing the extradition of offenders to and from the French Settlement of Chandernagore.",""));
        list.add(new Item("XXII. List of States included in the Eastern States Agency.",""));
        list.add(new Item("XXIII. Memorandum of points to be looked into during inspection of police-stations by inspecting officers.",""));
        list.add(new Item("XXIV. Conditions which may be imposed under section 124, Code of Criminal Procedure, and rules under section 565 of that Code.",""));
        list.add(new Item("XXV. Rules for the working of floating outposts and patrol launches.",""));
        list.add(new Item("XXVI. Monthly reports of officers-in-charge of police–stations (Omitted)",""));
        list.add(new Item("XXVII. Rules for dealing with military offenders.",""));
        list.add(new Item("XXVIII. Index to Court Conviction Register and system of indexing names.",""));
        list.add(new Item("XXIX. Rules regarding notices of and enquiries into railway accidents. ",""));
        list.add(new Item("XXX. Measures to be taken against the institution of fraudulent civil suits in courts.",""));
        list.add(new Item("XXXI. Detective Warrants Rules",""));
        list.add(new Item("XXXII. Index to the information on record in Criminal Intelligence Bureau of the  Criminal Investigation  Department.",""));
        list.add(new Item("XXXIII. Classes of criminals to be photographed.",""));
        list.add(new Item("XXXIV. Addresses of different Finger Print Bureaux.",""));
        list.add(new Item("XXXV. Preparation of estimates of cost of additional police deputed under section 13, 14 or 15 of the Police Act, 1861.",""));
        list.add(new Item("XXXVI. Sample form of Magistrate’s order appointing special police officers.",""));
        list.add(new Item("XXXVII. Bengal Police Special Constabulary Reserve.",""));
        list.add(new Item("XXXVIII.-Police-guards-for-jails-and-health-and-other-camps",""));
        list.add(new Item("XXXIX. Escorts for prisoners, treasure and stamps.",""));
        list.add(new Item("XL. Scale of the cost of escorts for prisoners required to give evidence.",""));
        list.add(new Item("XLI. Instructions for the relief of escorts for prisoners or treasure by railway to or from other States",""));
        list.add(new Item("XLII. System of selection of Inspectors for promotion to the rank of Deputy Superintendent.",""));
        list.add(new Item("XLIII. System of selection of officers fit for promotion to the rank of Inspector for inclusion in the provincial approved list.",""));
        list.add(new Item("XLIV. Conditions for the employment of British soldiers in the Bengal Police Force on transfer to the Army Reserve.",""));
        list.add(new Item("XLV. Examinations recognized as being equivalent to Matriculation Examination of an Indian University.",""));
        list.add(new Item("XLVI. Method of selection of constables for officiating promotion to the rank of Assistant Sub-Inspector.",""));
        list.add(new Item("XLVII. Compensatory allowances .",""));
        list.add(new Item("XVIII. Memorandum of instructions for the guidance",""));
        list.add(new Item("XLIX. Syllabus for the training of constables in nursing.",""));
        list.add(new Item("L. List of Acts and Books, etc., prescribed for the examination of Sub-Inspectors in Law and Procedure and Criminology.",""));
        list.add(new Item("LI. Questions for checking pension and gratuity rolls.",""));
        list.add(new Item("LII. Rules regarding the submission of petitions to the Provincial Government by clerks.",""));
        list.add(new Item("LIII. Sanctioned scale of orderlies for police officers and various offices.",""));
        list.add(new Item("LIII-A. Rules for the use of and rnaintenance of Police motor vechicles.",""));
        list.add(new Item("LIV. First kit and maintenance grants.",""));
        list.add(new Item("LV. List of articles comprising the complete kit of Sergeants, Assistant Sub-Inspectors, head constables, constables, launch crews and boat men.",""));
        list.add(new Item("LVI. Statement showing the minimum period for which each article of clothing supplied at the cost of the Provincial Government is required to last.",""));
        list.add(new Item("LVII.-Marking-of-arms",""));
        list.add(new Item("LVIII. Memorandum of instructions for the storage, examination and test of small arms ammunition on charge of police units",""));
        list.add(new Item("LIX. Accoutrements and camp equipage.",""));
        list.add(new Item("LX. Rules as to the procedure to be adopted in regard to the treatment of staff of the Railway Police in Railway hospitals in emergent cases.",""));
        list.add(new Item("LXI. Form of recommendations for titles and decorations.",""));
        list.add(new Item("LXII. Form of application for awards of the Royal Humane Society.",""));
        list.add(new Item("LXIII. List of collections and files of English correspondence in the Superintendent‘s office. (Preservation and destruction of records).",""));
        list.add(new Item("LXIV. Scales of furniture and stores for different offices.",""));
        return list;
    }
}
