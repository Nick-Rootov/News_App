package com.example.mailing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class NewsListFragment extends ListFragment {
    private static final String TAG = "NewsListFragment";
    private ArrayList<News> mNews;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.news_title);
        mNews = NewsBank.getNewsBank(getActivity()).getNewsList();

        // Создание адаптера
        NewsAdapter adapter = new NewsAdapter(mNews);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        News c = ((NewsAdapter)getListAdapter()).getItem(position);
        //Log.d(TAG, c.getTitle() + " was clicked");

        // Запуск NewsActivity
        Intent i = new Intent(getActivity(), NewsActivity.class);
        i.putExtra(NewsFragment.EXTRA_NEWS_ID, c.getId());
        startActivity(i);
    }

    private class NewsAdapter extends ArrayAdapter<News> {
        public NewsAdapter(ArrayList<News> news) {
            super(getActivity(), 0, news);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

// Если мы не получили представление, заполняем его
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_news, null);
            }

// Настройка представления для объекта News
            //Получаем объект из текущей позиции списка
            News c = getItem(position);

// получаем ссылку на каждый виджет в объекте представления и //настраиваем его данными News
            TextView titleTextView = (TextView)convertView.findViewById(R.id.news_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            TextView dateTextView = (TextView)convertView.findViewById(R.id.news_list_item_dataTextView);
            dateTextView.setText(c.getDate().toString());

            CheckBox passedCheckBox = (CheckBox)convertView.findViewById(R.id.news_list_item_passedCheckBox);
            passedCheckBox.setChecked(c.getPassed());
            return convertView;

        }
    }
    @Override
    public void onResume() {
        super.onResume();
        ((NewsAdapter)getListAdapter()).notifyDataSetChanged();
    }

}
