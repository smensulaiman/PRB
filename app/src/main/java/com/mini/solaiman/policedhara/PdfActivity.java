package com.mini.solaiman.policedhara;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.mini.solaiman.policedhara.app.BackCon;
import com.mini.solaiman.policedhara.app.PdfZoomControlar;
import com.mini.solaiman.policedhara.model.PdfName;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

public class PdfActivity extends Activity implements OnPageChangeListener, OnLoadCompleteListener {
    String name = PdfName.name;
    private static final String TAG = PdfActivity.class.getSimpleName();
    public final String SAMPLE_FILE = name + ".pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);
        int con = BackCon.background;
        if (con == 0) {
            pdfView.setBackgroundResource(R.drawable.background);
        } else {
            pdfView.setBackgroundResource(R.drawable.html);
        }
        //pdfView.fitToWidth();
    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        try {
            pdfView.fromAsset(SAMPLE_FILE)
                    .defaultPage(pageNumber)
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .onPageChange(this)
                    .enableAnnotationRendering(true)
                    .onRender(new OnRenderListener() {
                        @Override
                        public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                            pdfView.fitToWidth();
                        }
                    })
                    .onLoad(this)
                    .scrollHandle(new DefaultScrollHandle(this))
                    .password(null)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .load();
        } catch (Exception e) {
            Toast.makeText(PdfActivity.this, "file not found", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");

    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }
}