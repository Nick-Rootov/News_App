package com.example.mailing;

import androidx.fragment.app.Fragment;
import java.util.UUID;

public class NewsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID newsId = (UUID)getIntent()
                .getSerializableExtra(NewsFragment.EXTRA_NEWS_ID);
        return NewsFragment.newInstance(newsId);

    }
}
