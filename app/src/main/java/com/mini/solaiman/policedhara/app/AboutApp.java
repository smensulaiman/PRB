package com.mini.solaiman.policedhara.app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.mini.solaiman.policedhara.R;

public class AboutApp extends AppCompatActivity {
    CardView cv,author;
    //http://www.mdaminulislam.com
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/SolaimanLipi.ttf");
        String text = "পুলিশ প্রবিধান বাংলাদেশ পুলিশের জন্য এক অপরিহার্য অনুষঙ্গ ।কার্যকর আইন ব্যবস্থাপনার মাধ্যমে জনগণের স্বার্থ নিশ্চিতকরণের প্রয়োজনীয়তা দীর্ঘদিন ধরে অনুভূত হয়ে আসছে।স্বচ্ছতা ও জবাবদিহিতা আনয়ন এবং সহজ ও হয়রানিমুক্ত সেবা প্রদানের মাধ্যমে সুফল প্রতিষ্ঠা করা পুলিশের অন্যতম চ্যালেঞ্জ।পুলিশ প্রবিধান ১৯৪৭ সালে প্রণীত হয়।এরপর থেকে এ পর্যন্ত অনেক প্রবিধানের পরিবর্তন ঘটেছে সময়ের প্রয়োজনে।আরো পরিবর্তন দরকার এবং হবেও।পুলিশ সদস্যদের দৈনিক কার্যক্রম পরিচালনার জন্য পুলিশ প্রবিধান তথা পিআরবিএর প্রয়োজনীয়তা অপরিসীম।তারই লক্ষ্যে সকল পুলিশ সদস্যদের হাতে পুলিশ প্রবিধানসহজ লভ্য করার জন্য আমার এ ক্ষুদ্র প্রয়াস। এ জন্যই ‘বাংলাদেশের পুলিশ প্রবিধান(পি আর বি) ‘ নামক এই মোবাইল এ্যাপটি চালু করা হয়েছে।এই এ্যাপে প্রতিটি প্রবিধান সহজভাবে উপস্থাপন করা হয়েছে এবং এ উপস্থাপনায় প্রতিটি প্রবিধানের সহজ ব্যাখ্যা প্রদান করা হয়েছে।এই এ্যাপটি যে কোন পুলিশ সদস্য সহজে ব্যবহার করতে পারবে। এ্যাপের মেনুগুলো বিষয়ের সংশ্লিষ্টতা বজায় রেখে সাজানো হয়েছে।তাই এ্যাপের মেনুর প্রতিটি বিষয় উপর থেকে নিচে এবং প্রতিটি মেনুর প্রতিটি সাব-মেনু সংখ্যার ধারাবাহিকতা অনুযায়ী পাঠ করলে প্রতিট বিষয় সহজে বোধগম্য হবে।এই এ্যাপের সকল প্রবিধান,প্রবিধানের ব্যাখা,বিভিন্ন রেফারেন্স সমুহ,বিভিন্ন ফরম,পরিপত্র, সরকারী আদেশ সমুহ বিভিন্ন বই , সরকারী গেজেট, ইন্টারনেট ও গুগল সহ বিভিন্ন উৎস হতে সংগ্রহ করা হয়েছে।এটি আমার নিজস্ব তৈরি কোন আইন নয়।এই ব্যাপারে কারো কোন অভিযোগ থাকলে কোন ভাবেই আমি দায়ী নই।এই এ্যাপের ভাষাগত/তথ্যগত ত্রুটিসহ যেকোন ত্রুটি বা এ্যাপ সম্পর্কে যে কোন পরামর্শ জানাতে পারবেন।";
        WebView textview = (WebView)findViewById(R.id.text);
        textview.setBackgroundColor(Color.TRANSPARENT);
        textview.loadData(JustifyText.jText(text),"text/html","UTF-8");

        cv =  (CardView)findViewById(R.id.redirect);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ekattorit.com"));
                startActivity(intent);
                }catch (Exception e){

                }
            }
        });
        author =  (CardView)findViewById(R.id.author);
        author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mdaminulislam.com"));
                    startActivity(intent);
                }catch (Exception e){

                }
            }
        });
    }
}
