package ahmadrosid.com.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.Gravity.START;

/**
 * Created by ocittwo on 10/3/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class PercentView extends LinearLayout {

    private RelativeLayout mWrapHint;
    private TextView mHintView;
    private TextView mTextPercent;
    private EditText mEditText;

    private LinearLayout mWrapPercent;
    private LinearLayout mStartPercent;
    private LinearLayout mEndPercent;

    private boolean show_hint;
    private boolean hide_input_percent;

    public PercentView(Context context) {
        this(context, null);
    }

    public PercentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        setGravity(START);
        init(context, attrs);
        this.isInEditMode();
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.percent_view, this, true);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PercentView, 0, 0);

        String hint = array.getString(R.styleable.PercentView_hint);
        show_hint = array.getBoolean(R.styleable.PercentView_showHint, false);
        hide_input_percent = array.getBoolean(R.styleable.PercentView_hideInputPercent, false);

        float height = array.getDimension(R.styleable.PercentView_heightPercent, 5f);
        int percent = array.getInteger(R.styleable.PercentView_percent, 0);

        array.recycle();

        mEditText = (EditText) findViewById(R.id.input_text);
        mHintView = (TextView) findViewById(R.id.text_hint);
        mTextPercent = (TextView) findViewById(R.id.text_percent);
        mWrapPercent = (LinearLayout) findViewById(R.id.wrap_percent);
        mStartPercent = (LinearLayout) findViewById(R.id.start_percent);
        mEndPercent = (LinearLayout) findViewById(R.id.end_percent);
        mWrapHint = (RelativeLayout) findViewById(R.id.wrap_hint);

        mEditText.setHint(hint);
        mHintView.setText(hint);

        if (height > 5) {
            setHeightPercent(Math.round(height));
        }

        if (hide_input_percent) {
            hideInputPercent();
        }

        if (percent > 0) {
            setPercent(percent);
        }

        mEditText.addTextChangedListener(
                new TextWatcher() {
                    @Override public void afterTextChanged(Editable s) {
                        if (s.length() > 0) {
                            showPercent(mEditText.getText().toString());
                        } else {
                            showPercent("0");
                        }
                    }

                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }
                });
    }

    public void setHeightPercent(int height) {
        LayoutParams height_params = (LayoutParams) mWrapPercent.getLayoutParams();
        height_params.height = height;
        mWrapPercent.setLayoutParams(height_params);
    }

    private void showPercent(String s) {
        int percent = Integer.parseInt(s);
        if (percent == 0) {
            mWrapPercent.setVisibility(GONE);
            mWrapHint.setVisibility(GONE);
        } else {
            setAnimatePercent(percent, 0, mStartPercent);
            LinearLayout.LayoutParams percent_end = (LayoutParams) mEndPercent.getLayoutParams();
            percent_end.weight = 100;
            mEndPercent.setLayoutParams(percent_end);
            mWrapPercent.setVisibility(VISIBLE);
            if (show_hint) {
                mWrapHint.setVisibility(VISIBLE);
            }
        }
    }

    public void setPercent(int percent) {
        showPercent("" + percent);
        mEditText.setText("" + percent);
    }

    private void setAnimatePercent(final int percent, final int position, final LinearLayout view) {
        final LinearLayout.LayoutParams percent_start = (LayoutParams) mStartPercent.getLayoutParams();
        final int index = position + 1;
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if (position < percent) {
                    percent_start.weight = index;
                    view.setLayoutParams(percent_start);
                    mTextPercent.setText("" + index + "%");
                    setAnimatePercent(percent, index, view);
                }
            }
        }, 1);
    }

    public void showHint() {
        this.show_hint = true;
    }

    public void hideInputPercent() {
        mEditText.setVisibility(GONE);
    }
}
