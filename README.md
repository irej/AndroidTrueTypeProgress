# AndroidTrueTypeProgress

Sample Android program that shows a custom progress dialog containing an animation of TrueType font glyphs.

The progress dialog layout, fragment_progress_dialog.xml, contains a ViewFlipper. The ViewFlipper is defined with a list of FontTextViews. The ViewFlipper will automatically animate through this list of FontTextViews.

1. Place fauxsnow.ttf in app/src/main/assets/fonts
2. Implement FontTextView, a subclass of TextView, that sets fauxsnow.ttf as its Typeface.
3. Implement ProgressDialogFragment, which extends DialogFragment, and uses the fragment_progress_dialog.xml layout

The MainActivity has a button to show the progress dialog for 10 seconds.

![Screenshot](https://github.com/irej/AndroidTrueTypeProgress/blob/develop/screenshot.png "Screenshot")

The sample program uses Brian Kent's Faux Snow font
http://www.fontsquirrel.com/license/Faux-Snow-BRK


