package io.github.mlstudio.yiji.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

import io.github.mlstudio.yiji.R;
import io.github.mlstudio.yiji.tools.YiJiUtil;
import io.github.mlstudio.yiji.tools.db.DataManager;


public class EditMoneyFragment extends Fragment {

    public MaterialEditText editView;
    public ImageView tagImage;
    public TextView tagName;
    Activity activity;
    private int tagId = -1;
    private View mView;

    static public EditMoneyFragment newInstance(int position, int type) {
        EditMoneyFragment fragment = new EditMoneyFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("type", type);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.edit_money_fragment, container, false);

        if (getArguments().getInt("type") == 0) {
//            CoCoinFragmentManager.mainActivityEditMoneyFragment = this;
        } else if (getArguments().getInt("type") == 1) {
//            CoCoinFragmentManager.editRecordActivityEditMoneyFragment = this;
        }

        int fragmentPosition = getArguments().getInt("position");
        editView = mView.findViewById(R.id.money);
        tagImage = mView.findViewById(R.id.tag_image);
        tagName = mView.findViewById(R.id.tag_name);
        tagName.setTypeface(YiJiUtil.typefaceLatoLight);

        editView.setTypeface(YiJiUtil.typefaceLatoHairline);
//        editView.setText("0");
        editView.requestFocus();
//        editView.setHelperText(" ");
//        editView.setKeyListener(null);
//        editView.setOnClickListener(null);
//        editView.setOnTouchListener(null);

//        boolean shouldChange
//                = SettingManager.getInstance().getIsMonthLimit()
//                && SettingManager.getInstance().getIsColorRemind()
//                && RecordManager.getCurrentMonthExpense()
//                >= SettingManager.getInstance().getMonthWarning();
//
//        setEditColor(shouldChange);

//        if (getArguments().getInt("type") == 1
//                && YiJiUtil.editRecordPosition != -1) {
//            CoCoinFragmentManager.editRecordActivityEditMoneyFragment
//                    .setTagImage(CoCoinUtil.GetTagIcon(
//                            (int)RecordManager.SELECTED_RECORDS.get(CoCoinUtil.editRecordPosition).getTag()));
//            CoCoinFragmentManager.editRecordActivityEditMoneyFragment
//                    .setTagName(CoCoinUtil.GetTagName(
//                            (int)RecordManager.SELECTED_RECORDS.get(CoCoinUtil.editRecordPosition).getTag()));
//            CoCoinFragmentManager.editRecordActivityEditMoneyFragment
//                    .setTagId(RecordManager.SELECTED_RECORDS.get(CoCoinUtil.editRecordPosition).getTag());
//            CoCoinFragmentManager.editRecordActivityEditMoneyFragment
//                    .setNumberText(String.format("%.0f", RecordManager.SELECTED_RECORDS.get(CoCoinUtil.editRecordPosition).getMoney()));
//        }

        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTagImage(R.color.transparent);
        setTagName("");
        setTagId(-1);
        setNumberText("");
        setHelpText(" ");
    }

    public void updateTags() {

    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public void setTag(int p) {
        tagId = DataManager.TAGS.get(p).getId();
        tagName.setText(YiJiUtil.GetTagName(getContext(),DataManager.TAGS.get(p).getId()));
        tagImage.setImageResource(YiJiUtil.GetTagIcon(DataManager.TAGS.get(p).getId()));
    }

    public String getNumberText() {
        return editView.getText().toString();
    }

    public void setNumberText(String string) {
        editView.setText(string);
    }

    public String getHelpText() {
        return editView.getHelperText();
    }

    public void setHelpText(String string) {
          editView.setHelperText(string);
    }

    public void editRequestFocus() {
        editView.requestFocus();
        InputMethodManager imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mView.getWindowToken(), 0);
    }

    public void setEditColor(boolean shouldChange) {
//        if (shouldChange) {
//            editView.setTextColor(SettingManager.getInstance().getRemindColor());
//            editView.setPrimaryColor(SettingManager.getInstance().getRemindColor());
//            editView.setHelperTextColor(SettingManager.getInstance().getRemindColor());
//        } else {
//            editView.setTextColor(CoCoinUtil.getInstance().MY_BLUE);
//            editView.setPrimaryColor(CoCoinUtil.getInstance().MY_BLUE);
//            editView.setHelperTextColor(CoCoinUtil.getInstance().MY_BLUE);
//        }
    }

    public void setTagName(String name) {
        tagName.setText(name);
    }

    public void setTagImage(int resource) {
        tagImage.setImageResource(resource);
    }

    public void getTagPosition(int[] position) {
        tagImage.getLocationOnScreen(position);
        position[0] += tagImage.getWidth() / 2;
        position[1] += tagImage.getHeight() / 2;
    }

    public interface OnTagItemSelectedListener {
        void onTagItemPicked(int position);
    }

}
