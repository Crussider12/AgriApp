package agri.app.Customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by User on 09-03-2017.
 */

public class HelveticaNeuThinTextView extends AppCompatTextView {

    public HelveticaNeuThinTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public HelveticaNeuThinTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public HelveticaNeuThinTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("HelveticaNeuThin.ttf", context);
        setTypeface(customFont);
    }

}
