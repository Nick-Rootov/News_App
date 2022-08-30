package com.example.mailing;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class NewsFragment extends Fragment {

    public static final String EXTRA_NEWS_ID =
            "com.pnzgu.mailing.crime_id";


    private News mNews;
    private EditText mTitleField;
    private EditText mContentField;
    private Button mDateButton;
    private CheckBox mPassedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // UUID newsId = (UUID)getActivity().getIntent()
       //         .getSerializableExtra(EXTRA_NEWS_ID);
        UUID newsId = (UUID)getArguments().getSerializable(EXTRA_NEWS_ID);
        mNews = NewsBank.getNewsBank(getActivity()).getNews(newsId);


    }

    public static NewsFragment newInstance(UUID newsId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_NEWS_ID, newsId);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_news2, parent, false);

        mTitleField = (EditText)v.findViewById(R.id.news_title);

        mTitleField.setText(mNews.getTitle());

        //Слушатель EditText
        mTitleField.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(
                    CharSequence c, int start, int before, int count) {
                mNews.setTitle(c.toString());
            }

            public void beforeTextChanged(
                    CharSequence c, int start, int count, int after) {
                // Пока оставим пустое место
            }
            public void afterTextChanged(Editable c) {

                // Пока оставим пустое место

            }
        });

        mContentField = (EditText)v.findViewById(R.id.news_content);

        mContentField.setText(mNews.getContent());

        //Слушатель EditText
        mContentField.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(
                    CharSequence c, int start, int before, int count) {
                mNews.setContent(c.toString());
            }

            public void beforeTextChanged(
                    CharSequence c, int start, int count, int after) {
                // Пока оставим пустое место
            }
            public void afterTextChanged(Editable c) {

                // Пока оставим пустое место

            }
        });

        //Получаем ссылку на кнопку и назначаем ей текст
        mDateButton = (Button)v.findViewById(R.id.news_date);
        mDateButton.setText(mNews.getDate().toString());

        //Пока заблокируем кнопку, чтобы она не реагировала на нажатия
        mDateButton.setEnabled(false);

        //получаем ссылку на CheckBox и назначаем слушателя,
//который будет обновлять поле mPassed объекта News
        mPassedCheckBox = (CheckBox)v.findViewById(R.id.news_passed);

        mPassedCheckBox.setChecked(mNews.getPassed());

        mPassedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isPassed)
            {
                // Назначение флага о прошедшей новости
                mNews.setPassed(isPassed);
            }
        });


        return v;

    }

}
