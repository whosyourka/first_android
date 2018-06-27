package com.katekit.common.view.dialog;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.katekit.common.R;


/**
 * Create custom Dialog windows for your application Custom dialogs rely on
 * custom layouts wich allow you to create and use your own look & feel.
 * <p>
 * Under GPL v3 : http://www.gnu.org/licenses/gpl-3.0.html
 * <p>
 * <a href="http://my.oschina.net/arthor" target="_blank"
 * rel="nofollow">@author</a> antoine vianey
 */
public class BaseDialogBuilder {
    private Context context;
    private String title;
    private String message;
    private String positiveButtonText;
    private String negativeButtonText;
    private String neturalButtonText;
    private String singleButtonText;
    private View contentView;
    private Drawable icon; //标题的图标
    private int drawablePadding; //标题图标的padding值
    private int messagePadding; //中间消息的padding值
    private boolean cancelable;
    private int messageGravity = Gravity.CENTER; //message的gravity

    private DialogInterface.OnClickListener positiveButtonClickListener,
            negativeButtonClickListener, neturalButtonClickListener, singleButtonClickListener;

    public BaseDialogBuilder(Context context) {
        this.context = context;
    }
    /**
     * Set the Dialog message from String
     *
     * @param message
     * @return
     */
    public BaseDialogBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Set the Dialog message from resource
     *
     * @param message
     * @return
     */
    public BaseDialogBuilder setMessage(int message) {
        this.message = (String) context.getText(message);
        return this;
    }

    /**
     * Set the Dialog title from resource
     *
     * @param title
     * @return
     */
    public BaseDialogBuilder setTitle(int title) {
        this.title = (String) context.getText(title);
        return this;
    }

    /**
     * Set the Dialog title from String
     *
     * @param title
     * @return
     */
    public BaseDialogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set a custom content view for the Dialog. If a message is set, the
     * contentView is not added to the Dialog...
     *
     * @param v
     * @return
     */
    public BaseDialogBuilder setContentView(View v) {
        this.contentView = v;
        return this;
    }

    /**
     * Set the neturalButton resource and it's listener
     *
     * @param neturalButtonText
     * @param listener
     * @return
     */
    public BaseDialogBuilder setNeutralButton(int neturalButtonText,
                                              DialogInterface.OnClickListener listener) {
        this.neturalButtonText = (String) context
                .getText(neturalButtonText);
        this.neturalButtonClickListener = listener;
        return this;
    }

    /**
     * Set the neturalButton text and it's listener
     *
     * @param neturalButtonText
     * @param listener
     * @return
     */
    public BaseDialogBuilder setNeutralButton(String neturalButtonText,
                                              DialogInterface.OnClickListener listener) {
        this.neturalButtonText = neturalButtonText;
        this.neturalButtonClickListener = listener;
        return this;
    }

    /**
     * Set the positive button resource and it's listener
     *
     * @param positiveButtonText
     * @param listener
     * @return
     */
    public BaseDialogBuilder setPositiveButton(int positiveButtonText,
                                               DialogInterface.OnClickListener listener) {
        this.positiveButtonText = (String) context
                .getText(positiveButtonText);
        this.positiveButtonClickListener = listener;
        return this;
    }

    /**
     * Set the positive button text and it's listener
     *
     * @param positiveButtonText
     * @param listener
     * @return
     */
    public BaseDialogBuilder setPositiveButton(String positiveButtonText,
                                               DialogInterface.OnClickListener listener) {
        this.positiveButtonText = positiveButtonText;
        this.positiveButtonClickListener = listener;
        return this;
    }

    /**
     * Set the negative button resource and it's listener
     *
     * @param negativeButtonText
     * @param listener
     * @return
     */
    public BaseDialogBuilder setNegativeButton(int negativeButtonText,
                                               DialogInterface.OnClickListener listener) {
        this.negativeButtonText = (String) context
                .getText(negativeButtonText);
        this.negativeButtonClickListener = listener;
        return this;
    }

    /**
     * Set the negative button text and it's listener
     *
     * @param negativeButtonText
     * @param listener
     * @return
     */
    public BaseDialogBuilder setNegativeButton(String negativeButtonText,
                                               DialogInterface.OnClickListener listener) {
        this.negativeButtonText = negativeButtonText;
        this.negativeButtonClickListener = listener;
        return this;
    }

    /**
     * Set the singleButton resource and it's listener
     * 只有一个按钮的时候使用
     *
     * @param singleButtonText
     * @param listener
     * @return
     */
    public BaseDialogBuilder setSingleButton(int singleButtonText,
                                             DialogInterface.OnClickListener listener) {
        this.singleButtonText = (String) context
                .getText(singleButtonText);
        this.singleButtonClickListener = listener;
        return this;
    }

    /**
     * Set the single button text and it's listener
     * 只有一个按钮的时候使用
     *
     * @param singleButtonText
     * @param listener
     * @return
     */
    public BaseDialogBuilder setSingleButton(String singleButtonText,
                                             DialogInterface.OnClickListener listener) {
        this.singleButtonText = singleButtonText;
        this.singleButtonClickListener = listener;
        return this;
    }

    public BaseDialogBuilder setDrawableIcon(int id) {
        this.icon = context.getResources().getDrawable(id);
        return this;
    }

    public BaseDialogBuilder setDrawable(Drawable drawable) {
        this.icon = drawable;
        return this;
    }

    public BaseDialogBuilder setDrawablePadding(int padding) {
        this.drawablePadding = dpToPx(padding);
        return this;
    }

    public BaseDialogBuilder setMessagePadding(int padding) {
        this.messagePadding = dpToPx(padding);
        return this;
    }

    public BaseDialogBuilder setMessageGravity(int gravity) {
        this.messageGravity = dpToPx(gravity);
        return this;
    }

    public BaseDialogBuilder setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    private int dpToPx(int dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * Create the custom dialog
     */
    public BaseDialog create() {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // instantiate the dialog with the custom Theme
        final BaseDialog dialog = new BaseDialog(context, R.style.dialog_style);
        View layout = inflater.inflate(R.layout.custom_dialog_layout, null);
        dialog.addContentView(layout, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ViewGroup footer = (ViewGroup) layout.findViewById(R.id.footer);
        TextView singleButton = ((TextView) layout.findViewById(R.id.singleButton));
        // set the dialog title
        if (!TextUtils.isEmpty(title)) {
            TextView textView = ((TextView) layout.findViewById(R.id.title));
            textView.setText(title);
            if (icon != null) {
                textView.setCompoundDrawablePadding(drawablePadding);
                textView.setCompoundDrawablesWithIntrinsicBounds(icon,
                        null, null, null);
            }
        } else {
            layout.findViewById(R.id.title).setVisibility(View.GONE);
        }
        if (singleButtonText != null) {
            footer.setVisibility(View.GONE);
            singleButton.setVisibility(View.VISIBLE);
            singleButton.setText(singleButtonText);
            if (singleButtonClickListener != null) {
                singleButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        singleButtonClickListener.onClick(dialog,
                                DialogInterface.BUTTON_POSITIVE);
                        dialog.dismiss();
                    }
                });
            }
        } else {
            footer.setVisibility(View.VISIBLE);
            singleButton.setVisibility(View.GONE);
        }
        // set the cancel button
        if (negativeButtonText != null) {
            ((TextView) layout.findViewById(R.id.negativeButton))
                    .setText(negativeButtonText);
            if (negativeButtonClickListener != null) {
                ((TextView) layout.findViewById(R.id.negativeButton))
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                negativeButtonClickListener.onClick(dialog,
                                        DialogInterface.BUTTON_NEGATIVE);
                                dialog.dismiss();
                            }
                        });
            }
        } else {
            // if no confirm button just set the visibility to GONE
            layout.findViewById(R.id.negativeButton).setVisibility(
                    View.GONE);
        }
        // set the confirm button
        if (positiveButtonText != null) {
            ((TextView) layout.findViewById(R.id.positiveButton))
                    .setText(positiveButtonText);
            if (positiveButtonClickListener != null) {
                ((TextView) layout.findViewById(R.id.positiveButton))
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                positiveButtonClickListener.onClick(dialog,
                                        DialogInterface.BUTTON_POSITIVE);
//                                dialog.dismiss();
                            }
                        });
            }

        } else {
            // if no confirm button just set the visibility to GONE
            layout.findViewById(R.id.positiveButton).setVisibility(
                    View.GONE);
        }
        // set the netural button
        if (neturalButtonText != null) {
            TextView netural = ((TextView) layout
                    .findViewById(R.id.neturalButton));
            netural.setText(neturalButtonText);
            netural.setVisibility(View.VISIBLE);
            View line = (View) layout.findViewById(R.id.line2);// 显示线
            line.setVisibility(View.VISIBLE);
            if (neturalButtonClickListener != null) {
                ((TextView) layout.findViewById(R.id.neturalButton))
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                neturalButtonClickListener.onClick(dialog,
                                        DialogInterface.BUTTON_NEUTRAL);
                                dialog.dismiss();
                            }
                        });
            }
        } else {
            // if no confirm button just set the visibility to GONE
            layout.findViewById(R.id.neturalButton)
                    .setVisibility(View.GONE);
        }
        // set the content message
        if (message != null) {
            TextView messageTextView = ((TextView) layout
                    .findViewById(R.id.message));
            messageTextView.setText(message);
            messageTextView.setGravity(messageGravity);
            messageTextView.setPadding(messagePadding, messagePadding,
                    messagePadding, messagePadding);
        } else if (contentView != null) {
            // if no message set
            // add the contentView to the dialog body
            ((RelativeLayout) layout.findViewById(R.id.content))
                    .removeAllViews();
            ((RelativeLayout) layout.findViewById(R.id.content)).addView(
                    contentView, new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        dialog.setContentView(layout);
        dialog.setCancelable(cancelable);
        return dialog;
    }

    public Dialog show() {
        Dialog dialog = create();
        dialog.show();
        return dialog;
    }

}
