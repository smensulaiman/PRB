package com.mini.solaiman.policedhara.app;

/**
 * Created by Solaiman on 10-Aug-18.
 */

public class JustifyText {

    public static String jText(String text){
       return " <html>\n" +
               "    <head>\n" +
               "        <meta http-equiv=\"content-type\" content=\"text/html;\" charset=\"UTF-8\">\n" +
               "            <style>\n" +
               "                /** Specify a font named \"MyFont\",\n" +
               "                and specify the URL where it can be found: */\n" +
               "                @font-face {\n" +
               "                    font-family: \"MyFont\";\n" +
               "                    src: url('file:///android_asset/fonts/PROTHOMA.TTF');\n" +
               "                }\n" +
               "                h3 { font-family:\"MyFont\"}\n" +
               "                body {\n" +
               "                text-align: justify;\n" +
               "                text-justify: inter-word;}\n" +
               "\n" +
               "                div {\n" +
               "                    text-align: justify;\n" +
                "                }\n" +
               "                p {\n" +
                                    "font-family:\"MyFont;\""+
               "                    color:#fff;                      "+
               "                    text-align: justify;\n" +
               "                    text-justify: inter-word;\n" +
               "                }\n" +
               "            </style>\n" +
               "    </head>\n" +
               "    <body><p style=\"color:white\">"+text+"</p></body></html>";


    }

}
