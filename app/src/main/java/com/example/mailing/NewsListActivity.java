package com.example.mailing;

import androidx.fragment.app.Fragment;

public class NewsListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new NewsListFragment();
    }
}
