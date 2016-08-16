package pl.droidsonroids.espressotest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_notes) RecyclerView mRecyclerViewNotes;
    @BindView(R.id.text_note_title) TextView mTextViewNoteTitle;
    @BindView(R.id.text_note_message) TextView mTextViewNoteMessage;

    private ArrayList<Note> mNotes;
    private NotesAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNotes = new ArrayList<>();
        mNotes.add(new Note("Some title",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore "
                        + "et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
                        + "nisi ut aliquip ex ea commodo consequat. "));

        mRecyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new NotesAdapter(this, mNotes);
        mRecyclerViewNotes.setAdapter(mAdapter);
    }

    @OnClick(R.id.button_add_note)
    public void onAddNoteClick() {
        mNotes.add(0, new Note(mTextViewNoteTitle.getText().toString(), mTextViewNoteMessage.getText().toString()));
        mAdapter.notifyDataSetChanged();
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

