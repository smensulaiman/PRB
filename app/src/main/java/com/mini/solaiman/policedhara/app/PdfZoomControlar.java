package com.mini.solaiman.policedhara.app;

public class PdfZoomControlar {
    public static boolean zoom;

    public PdfZoomControlar() {
    }

    public static boolean isZoom() {
        return zoom;
    }

    public static void setZoom(boolean zoom) {
        PdfZoomControlar.zoom = zoom;
    }
}
