package acadgild.assignment.session9_assignment_4;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import acadgild.assignment.session9_assignment_4.adapter.CustomAdapter;
import acadgild.assignment.session9_assignment_4.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<User> users;
    CustomAdapter customAdapter;

    Button btnSave, btnCancel;
    EditText etName, etPhone, etDOB;
    ListView listView;

    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    View alertDialogView;
    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        users=new ArrayList<>();

        customAdapter=new CustomAdapter(this,users);

        listView.setAdapter(customAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);


        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            //     Toast.makeText(MainActivity.this, "Testing of Menu", Toast.LENGTH_SHORT).show();
            builder = new AlertDialog.Builder(this);
            inflater = LayoutInflater.from(this);
            alertDialogView = inflater.inflate(R.layout.custom_dialog, null);


            etName = (EditText) alertDialogView.findViewById(R.id.editTextName);
            etPhone = (EditText) alertDialogView.findViewById(R.id.editTextPhone);
            etDOB = (EditText) alertDialogView.findViewById(R.id.editTextDOB);

            btnSave = (Button) alertDialogView.findViewById(R.id.btnSave);
            btnCancel = (Button) alertDialogView.findViewById(R.id.btnCancel);

            btnSave.setOnClickListener(this);
            btnCancel.setOnClickListener(this);


            alertDialog = builder.create();
            alertDialog.setView(alertDialogView);

            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {

            User newUser = new User(etName.getText().toString(),
                    etPhone.getText().toString(),
                    etDOB.getText().toString());

            users.add(newUser);
            customAdapter.notifyDataSetChanged();

            alertDialog.dismiss();

        } else {
            alertDialog.dismiss();
        }
    }
}
