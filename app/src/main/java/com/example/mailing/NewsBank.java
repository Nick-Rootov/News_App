package com.example.mailing;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

public class NewsBank {

    private static NewsBank sNewsBank; //Единственный экземпляр NewsBank
//префикс s в имени переменной обычно говорит о том, что данная переменная //статическая (static)
    private Context mAppContext; //Контекст приложения
    //Закрытый конструктор
    private ArrayList<News> mNews; //Список новостей


    private NewsBank(Context appContext) {
        mAppContext = appContext;
        mNews = new ArrayList<News>();
        for (int i = 0; i < 100; i++) {
            News c = new News();
            c.setTitle("Новость #" + i);
            c.setPassed(i % 2 == 0); // Для каждого второго объекта
            mNews.add(c);
        }
    }

    //Метод, возвращающий весь список новостей
    public ArrayList<News> getNewsList() {
        return mNews;
    }

    //Метод возвращающий одну новость по id
    public News getNews(UUID id) {
        for (News c : mNews) {
            if (c.getId().equals(id))
                return c;
        }
        return null; //вернуть null если новости с таким id нет
    }

    public static NewsBank getNewsBank(Context c) {
//Если экземпляр еще не существует, то вызываем конструктор
        if (sNewsBank == null) {
            sNewsBank = new NewsBank(c.getApplicationContext());
        }
        return sNewsBank;
    }







}
