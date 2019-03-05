package agri.app.Customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CheckBox;

/**
 * Created by User on 09-03-2017.
 */

public class HelveticaNeuRegularRadioButton extends CheckBox {

    public HelveticaNeuRegularRadioButton(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public HelveticaNeuRegularRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public HelveticaNeuRegularRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("HelveticaNeuMedium.ttf", context);
        setTypeface(customFont);
    }

}
